package hackerrank.onemonthkit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Week1 {

    public static void main(String[] args) {
        //plusMinus(List.of(-4, 3, -9, 0, 4, 1));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        //miniMaxSum(list);

        //System.out.println(timeConversion("07:01:00PM"));

        //System.out.println(matchingStrings(List.of("aba","baba","aba","xzxb"), List.of("aba","xzxb","ab")));

        List<Integer> myList = new ArrayList<>();
        myList.add(0);
        myList.add(1);
        myList.add(1);
        myList.add(0);
        myList.add(5);
        myList.add(2);
        myList.add(2);
        myList.add(4);
        myList.add(4);
        //System.out.println(lonelyinteger(myList));

        //System.out.println(flippingBits(9));

        List<List<Integer>> diagonalList = new ArrayList<>();
        diagonalList.add(List.of(11, 2, 4));
        diagonalList.add(List.of(4,5,6));
        diagonalList.add(List.of(10, 8, -12));
        //System.out.println(diagonalDifference(diagonalList));

        //System.out.println(countingSort(List.of(1,1,3,2,1)));

        //System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));

        List<Integer> A = new ArrayList<>();
        A.addAll(List.of(0, 1));
        List<Integer> B = new ArrayList<>();
        B.addAll(List.of(0, 2));
        //System.out.println(twoArrays(1, A, B));

        //System.out.println(birthday(List.of(2, 2, 1, 3, 2), 4, 2));

        //System.out.println(stringsXOR("10101","00101"));

        List<List<Integer>> flippingMatrix= new ArrayList<>();
        flippingMatrix.add(List.of(112,42,83,119));
        flippingMatrix.add(List.of(56,125,56,49));
        flippingMatrix.add(List.of(15,78,101,43));
        flippingMatrix.add(List.of(62,98,114,108));
        //System.out.println(flippingMatrix(flippingMatrix));

        //10, 20, 20, 10, 10, 30, 50, 10, 20
        List<Integer> sockMerchant= new ArrayList<>();
        sockMerchant.add(10);
        sockMerchant.add(20);
        sockMerchant.add(20);
        sockMerchant.add(10);
        sockMerchant.add(10);
        sockMerchant.add(30);
        sockMerchant.add(50);
        sockMerchant.add(10);
        sockMerchant.add(20);
        //System.out.println(sockMerchant(9,sockMerchant));
        int [] a = {2, 3, 5, 1, 4};

        //findZigZagSequence(a,5);

        //System.out.println(pageCount(5, 3));

        //System.out.println(towerBreakers(2, 6));

        //System.out.println(caesarCipher("middle-Outz", 2));

        List<Integer> maxMin= new ArrayList<>();
        maxMin.add(100);
        maxMin.add(200);
        maxMin.add(300);
        maxMin.add(350);
        maxMin.add(400);
        maxMin.add(401);
        maxMin.add(402);
        maxMin.add(40);
        maxMin.add(100);
        maxMin.add(200);
        // Continuous subArrays wanted !!!
        //System.out.println(maxMin(3,maxMin));

        //System.out.println(gridChallenge(List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv")));

        //System.out.println(balancedSums(List.of(1,2,3,3)));

        //System.out.println(superDigit("9875", 4));

        //System.out.println(counterGame(6));

        //System.out.println(sumXor(5));


    }

    public static void plusMinus(List<Integer> arr) {
        double positive = 0;
        double negative = 0;
        double zero = 0;
        double size = arr.size();
        for (int i = 0; i < size; i++) {
            if(arr.get(i) > 0) positive++;
            else if(arr.get(i) < 0) negative++;
            else zero++;
        }
        System.out.printf("%f\n%f\n%f" ,positive/size, negative/size, zero/size);
    }

    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum+=arr.get(i);
        }
        Collections.sort(arr);
        System.out.print((sum - arr.get(4)) + " " + (sum - arr.get(0)));
    }

    public static String timeConversion(String s) {
        String military = s;
        String[] split = s.split(":");
        String amPm = s.substring(s.length() - 2, s.length());
        Integer firstPart = Integer.valueOf(split[0]);
        if ("AM".equals(amPm)) {
            if(12 == firstPart) {
                military = s.replace("12", "00");
            }
        } else {
            if(12 != firstPart) {
                int newValue =  firstPart + 12;
                military = s.replace(split[0], String.valueOf(newValue));
            }
        }
        return military.replace(amPm, "");
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            for (int j = 0; j < strings.size(); j++) {
                if (queries.get(i).equals(strings.get(j))) {
                    count++;
                }
            }
            list.add(count);
            count = 0;
        }
        return list;
    }

    public static int lonelyinteger(List<Integer> a) {
        Collections.sort(a);
        for (int i = 0; i < a.size()-2; i++) {
            if(!a.get(i).equals(a.get(i+1))) return a.get(i);
            i++;
        }
        return a.get(a.size() - 1);
    }

    public static int lonelyintegers(List<Integer> a) {
        int result = 0;
        for (Integer number : a) {
            result ^= number;
        }
        return result;
    }

    public static long flippingBits(long n) {
        long mask = (1L << 32) - 1;
        return n ^ mask;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        int sum = 0;
        int opSize = 0;
        for(int i = 0; i < size; i++) {
            sum += arr.get(i).get(i);
            opSize += arr.get(size-i-1).get(i);
        }
        return Math.abs(sum-opSize);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        int[] charCount = new int[100];
        for(int i = 0; i < arr.size(); i++) {
            charCount[arr.get(i)]++;
        }
        for(int i : charCount) {
            list.add(i);
        }
        return list;
    }

    public static String pangrams(String s) {
        String alphabet = "abcdefghijklmnopqrstuvxwyz";
        String upperCase = alphabet.toUpperCase();
        for (int i = 0; i < alphabet.length(); i++) {
            if (!s.contains(alphabet.substring(i, i + 1)) && !s.contains(upperCase.substring(i, i + 1)))
                return "not pangram";
        }
        return "pangram";
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        boolean b = true;
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i)+B.get(i) < k) b = false;
        }
        return b ? "YES" : "NO";
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i <= s.size() - m ; i++) {
            for (int j = i; j < i+m; j++) {
                sum += s.get(j);
            }
            if(sum == d) count++;
            sum = 0;
        }
        return count;
    }

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i))
                res += "0";
            else
                res += "1";
        }

        return res;
    }

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get(arr.size()/2);
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int size = matrix.size();
        int sum = 0;
        for (int i = 0; i < size/2; i++) {
            for (int j = 0; j < size/2; j++) {
                sum += Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(size - j-1), Math.max(matrix.get(size - i-1).get(j), matrix.get(size - i-1).get(size - j-1))));
            }
        }
        return sum;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        int sum = 0;
        int[] array = new int[101];
        for (int i = 0; i < ar.size(); i++) {
            array[ar.get(i)]++;
        }
        for (Integer number : array) {
            sum += number/2;
        }
        return sum;
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n - 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static int pageCount(int n, int p) {
        return p <= n/2 ? p/2 : n/2 - p/2;
    }

    public static int towerBreakers(int n, int m) {
        if(m == 1) return 2;
        if(n % 2 != 0) return 1;
        else return 2;
    }
    public static String caesarCipher(String s, int k) {
        String result = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char lc = Character.toLowerCase(c);
            if(Character.isLetter(c)) {
                int codePoint = (alphabet.indexOf(lc) + k) % 26;
                if(c > 'Z') {
                    result  += alphabet.charAt(codePoint);
                } else {
                    result  += Character.toUpperCase(alphabet.charAt(codePoint));
                }
            } else {
                result += c;
            }
        }
        return result;
    }

    public static int maxMin(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size()-k; i++) {
            int max = arr.get(i+k-1);
            int min = arr.get(i);
            abs = Math.min(abs, max - min);
        }
        return abs;
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        int idx = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> resutList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < queries.size(); i++) {
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            idx = (x ^ lastAnswer) % n;
            if(x == 1) {
                list.get(idx).add(y);
            } else {
                lastAnswer = list.get(idx).get(y % list.get(idx).size());
                resutList.add(lastAnswer);
            }
        }
        return resutList;
    }

    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            grid.set(i, new String(chars));
        }
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size()-1; j++) {
                if (grid.get(j).charAt(i) > grid.get(j+1).charAt(i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static String balancedSums(List<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        int currSum = 0;
        for (int j = 0; j < arr.size(); j++) {
            int curr = arr.get(j);
            currSum += curr;
            if(sum - currSum == currSum - curr) return "YES";
        }
        return "NO";
    }

    public static int superDigit(String n, int k) {
        if(n.length() == 1 && k == 1) {
            return Integer.parseInt(n);
        }
        long superDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            superDigit += Integer.parseInt(String.valueOf(n.charAt(i)));
        }
        superDigit *= k;
        if(superDigit < 10) return (int) superDigit;
        return superDigit(String.valueOf(superDigit), 1);
    }

    public static String counterGame(long n) {
        if(n == 1) return "Richard";
        int counter = 0;
        long x = 1;
        while(n != 1) {
            x*=2;
            if(x == n) {
                n = x/2;
                counter++;
                x = 1;
            }
            if(x > n) {
                n = n - x/2;
                counter++;
                x = 1;
            }

        }
        return counter % 2 == 0 ? "Richard" : "Louise";
    }

    public static long sumXor(long n) {
        int p = 0;
        while(n > 1) {
            if ((n & (n >> 1)) == 0) p++;
        }
        return (long) Math.pow(2,p);
    }

}
