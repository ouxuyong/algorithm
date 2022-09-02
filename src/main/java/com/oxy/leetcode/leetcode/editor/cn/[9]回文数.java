//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 2163 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SolutionRelated {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1001);
        System.out.println(palindrome);
    }

    /**
     * 字符串解法
     * @param num
     * @return
     */
    public static boolean isPalindrome(int num){
        String string = Integer.toString(num);
        int left = 0;
        int right = string.length()-1;
        while (left < right){
            if(string.charAt(left) != string.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 第二种 不用字符串的解法 （看的其他人的题解）
     * 作者：reedfan
     *  链接：https://leetcode.cn/problems/palindrome-number/solution/ji-bai-liao-99de-javayong-hu-dai-ma-you-ya-by-reed/
     *  来源：力扣（LeetCode）
     *  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
