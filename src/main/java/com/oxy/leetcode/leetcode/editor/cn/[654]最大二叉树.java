//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 
// 👍 563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/**
 * 1.先获取数组中的最大值
 * 2.将最大值赋值给根节点
 * 3.截取左边和右边的数组，然后递归
 */
class TreeNodeSolution {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode treeNode = new TreeNode();
        return createTree(treeNode, nums);
    }

    private TreeNode createTree(TreeNode treeNode, int[] nums) {
        if (nums.length == 1) {
            treeNode.val = nums[0];
            return treeNode;
        }
        //找出数组的最大值
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        //赋值根节点
        treeNode.val = max;
        //获取左边的数值，然后递归
        int[] leftArr = getNewArr(nums, 0, maxIndex);
        if (leftArr != null) {
            TreeNode left = new TreeNode();
            treeNode.left = createTree(left, leftArr);
        }
        //获取右边的数值，然后递归
        int[] rightArr = getNewArr(nums, maxIndex + 1, nums.length);
        if (rightArr != null) {
            TreeNode right = new TreeNode();
            treeNode.right = createTree(right, rightArr);
        }
        return treeNode;

    }

    //获取新数组
    private int[] getNewArr(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int[] arr = new int[end - start];
        for (int i = 0; start < end; start++, i++) {
            arr[i] = nums[start];
        }
        return arr;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
