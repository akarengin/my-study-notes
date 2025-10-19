package mockinterview;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        String modifiable = "abdgggda";
        String target = "abdggda";
        System.out.println("Modifiable indices: " + Question1.getRemovableIndices2(modifiable, target));

    }

    public static List<Integer> getRemovableIndices1(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) != 1) return List.of(-1);
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            StringBuilder modifiedStr1 = new StringBuilder(str1);
            modifiedStr1.deleteCharAt(i); // Remove the character at index `i`
            if (modifiedStr1.toString().equals(str2)) {
                indices.add(i); // Add index if the modified string matches `str2`
            }
        }

        return indices.isEmpty() ? List.of(-1) : indices;
    }

    public static List<Integer> getRemovableIndices2(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) != 1) return List.of(-1);
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            String modifiedStr1 = str1.substring(0, i) + str1.substring(i + 1); // Skip character at index `i`
            if (modifiedStr1.equals(str2)) {
                indices.add(i); // Add index if the modified string matches `str2`
            }
        }
        return indices.isEmpty() ? List.of(-1) : indices;
    }

}
