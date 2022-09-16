import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//100%
public class Main1 {

    /*
     * 请完成下面这个函数，实现题目要求的功能
     ****************************** 开始写代码
     ******************************/
    static List<List<Integer>> subsetSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<>();
        subsetSums(nums, target, 0, result, results);
        return results;
    }

    private static void subsetSums(int[] nums, int target, int index, List<Integer> result,
            List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (target < 0 || index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            subsetSums(nums, target - nums[i], i + 1, result, results);
            result.remove(result.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return;
    }

    /****************************** 结束写代码 ******************************/

    public static List<Integer> extractNumList(String arr) {
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(arr);
        List<Integer> res = new ArrayList<>();
        while (matcher.find()) {
            res.add(Integer.parseInt(matcher.group()));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arr = in.nextLine().trim();
        List<Integer> array = extractNumList(arr);
        int[] nums = array.stream().mapToInt(Integer::valueOf).toArray();
        int target = Integer.parseInt(in.nextLine().trim());

        List<List<Integer>> res = subsetSums(nums, target);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(String.valueOf(res.get(i).get(j)) + " ");
            }
        }
    }
}
