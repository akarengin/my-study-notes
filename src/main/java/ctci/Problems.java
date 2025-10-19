package ctci;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problems {

    public static void main(String[] args) {
        Problems problem = new Problems();
        //System.out.println("isUnique: " + problem.isUnique5("heLlo"));

        //System.out.println("checkPermutation: " + problem.checkPermutation1("Apple", "eppaL"));

        char[] str = "Mr John Smith    ".toCharArray();
        //System.out.println(problem.urlIfy1(new String(str), 13));
        //problem.urlIfy3(str, 13);

        Stream<String> permutation = problem.permutation("Tact Coa");
        //permutation.forEach(System.out::println);
        //permutation.filter(problem::palindrome).forEach(System.out::println);
        //System.out.println(problem.palindrome("Taco cat"));

        System.out.println("oneWay: " + problem.oneWay1("spal", "pale"));

    }

    // Functional Programming way #1
    public boolean isUnique1(String str) {
        int[] arr = new int[128];
        return str.chars().allMatch(e -> ++arr[e] <= 1);
    }

    // Functional Programming way #2
    public boolean isUnique2(String str) {
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet())
                .size() == str.length();
    }

    // Old-school way #1
    public boolean isUnique3(String str) {
        // Check for null input
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // The array size should be 128 to accommodate all ASCII characters
        // Or 256 for extended ASCII if needed
        // Using 128 here as it's sufficient for standard ASCII
        int[] arr = new int[128];
        try {
            for (char ch : str.toCharArray()) {
                // Check if character is within ASCII range
                if (ch >= 128) {
                    throw new IllegalArgumentException("String contains non-ASCII characters");
                }
                arr[ch]++;
            }
            for (int i : arr) {
                if (i > 1) return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("String contains invalid characters", e);
        }
    }

    // Old-school way #2
    public boolean isUnique4(String str) {
        if (str == null || str.length() > 128) {
            return false;
        }

        boolean[] seen = new boolean[128];
        for (char ch : str.toCharArray()) {
            if (seen[ch]) {
                return false;
            }
            seen[ch] = true;
        }
        return true;
    }

    // Old-school way #3
    /*This method checks if a string has all unique characters using bit manipulation
    It uses a single integer 'checker' as a bit vector to track seen characters
    Each bit position represents a character (a-z)
    For each character:
    1. Calculate bit position by subtracting 'a' (e.g. 'c' - 'a' = 2)
    2. Check if bit is already set using & operator
    3. If bit is set, character is duplicate, return false
    4. Otherwise, set the bit using | operator
    Only works for lowercase a-z (26 bits needed)*/
    boolean isUnique5(String str) {
        int checker = 0; //
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int base = Character.isUpperCase(ch) ? 'A' : 'a';
            int val = ch - base;
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    // Functional Programming (FP) way #1
    public boolean checkPermutation1(String str1, String str2) {
        return str1 != null && str2 != null && str1.length() == str2.length()
                && getCharFrequencyMap(str1).equals(getCharFrequencyMap(str2));
    }

    private Map<Integer, Long> getCharFrequencyMap(String str) {
        return str.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Functional Programming way #2
    public boolean checkPermutation2(String str1, String str2) {
        return str1 != null && str2 != null && str1.length() == str2.length()
                && sortString(str1).equals(sortString(str2));
    }

    private String sortString(String str) {
        return str.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }


    // Old-school way #1
    boolean checkPermutation3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; // Assumption: ASCII characters

        // Count characters in s
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        // Check characters in t
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    // Old-school (OC) way #2
    public boolean checkPermutation4(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // FP way #1
    public String urlIfy1(String str, int trueLength) {
        return Arrays.stream(str.substring(0, trueLength).split(""))
                .map(s -> s.replace(" ", "%20"))
                .collect(Collectors.joining());
    }

    // FP way #2
    public String urlIfy2(String str, int trueLength) {
        return IntStream.range(0, trueLength)
                .mapToObj(i -> {
                    char ch = str.charAt(i);
                    return ch == ' ' ? "%20" : String.valueOf(ch);
                })
                .reduce("", String::concat);
    }

    // OC way #1
    public void urlIfy3(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        // This line calculates the final length of the string after replacing spaces with '%20'
        // trueLength: original string length
        // spaceCount: number of spaces in the string
        // spaceCount * 2: additional length needed since each space becomes '%20' (3 chars, so +2 per space)
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        System.out.println(str);
    }

    // OC way #2
    public String urlIfy4(String str, int trueLength) {
        char[] chars = str.toCharArray();
        // Each space character will be replaced with "%20" (3 characters)
        // In the worst case, every character in the input string could be a space
        StringBuilder result = new StringBuilder(trueLength * 3);
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                result.append("%20");
            } else {
                result.append(chars[i]);
            }
        }
        return result.toString();
    }

    // FP way #1
    public Stream<String> permutation(String input) {
        if (input == null || input.isEmpty()) {
            return Stream.empty();
        }

        if (input.length() == 1) {
            return Stream.of(input);
        }

        return IntStream.range(0, input.length()) // Tact Coa
                .boxed()
                .flatMap(i -> {
                    char currentChar = input.charAt(i);
                    StringBuilder remaining = new StringBuilder(input.length() - 1)
                            .append(input, 0, i)
                            .append(input, i + 1, input.length());

                    return permutation(remaining.toString())
                            .map(subPerm -> currentChar + subPerm);
                });
    }

    // FP way #1
    public boolean palindrome(String str) { // Tact Coa
        if (str == null || str.isEmpty()) {
            return true;    // or false, depending on your requirements
        }
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        return IntStream.range(0, cleaned.length() / 2)
                .allMatch(i -> cleaned.charAt(i) == cleaned.charAt(cleaned.length() - 1 - i));
    }

    // OC way #1
    /*We use a hash table to count how many times each
    character appears. Then, we iterate through the hash table and ensure that no more than one character has
    an odd count.*/
    boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    /* Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
     * This is case insensitive. Non-letter characters map to -1. */
    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }


    public boolean oneWay1(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 2) return false;
        if (str1.equals(str2)) return true;

        Map<Integer, Long> freq1 = getMap(str1);

        Map<Integer, Long> freq2 = getMap(str2);

        return IntStream.range(0, 128)
                .filter(i -> !Objects.equals(freq1.getOrDefault(i, 0L), freq2.getOrDefault(i, 0L)))
                .count() <= 1;
    }

    private Map<Integer, Long> getMap(String str1) {
        return str1.chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }

    // Time Complexity: O(n) where n is the length of the longer string
    // Space Complexity: O(1) since we use fixed size arrays of 128
    public boolean oneWay2(String str1, String str2) {
        int diff = 0;
        if (Math.abs(str1.length() - str2.length()) > 1) return false;
        if (str1.equals(str2)) return true;
        else {
            int[] arr1 = new int[128];
            int[] arr2 = new int[128];
            charSequence(str1, arr1);
            charSequence(str2, arr2);
            for (int i = 0; i < 128; i++) {
                if (arr1[i] != arr2[i]) diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }

    private void charSequence(String str, int[] arr) {
        str.chars().forEach(i -> ++arr[i]);
    }

    boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String sl = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int indexl = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && indexl < sl.length()) {
            if (sl.charAt(indexl) != s2.charAt(index2)) {

                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;

                if (sl.length() == s2.length()) {//On replace, move shorter pointer
                    indexl++;
                }
            } else {
                indexl++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }


}
