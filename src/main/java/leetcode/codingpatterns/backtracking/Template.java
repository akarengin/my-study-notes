package leetcode.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Template {

    public static void main(String[] args) {

    }

    /* Common Backtracking Patterns */

    // Permutations
    void backtrack(List<Integer> nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums.get(i));

            backtrack(nums, path, used, res);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


}
