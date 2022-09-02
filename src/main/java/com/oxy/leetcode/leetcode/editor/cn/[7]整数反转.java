//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3613 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class ReverseSolution {
    public static void main(String[] args) {
        int num = reverse(1232);
        System.out.println(num);
    }

    /**
     * 利用字符串反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String str = Integer.toString(x);
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = chars.length -1; i >= 0; i-- ){
            if(chars[i] == '-' || chars[i] == '+'){
                stringBuffer = new StringBuffer(chars[i] + stringBuffer.toString());
                continue;
            }
            stringBuffer.append(chars[i]);
        }
        Long aLong = Long.parseLong(stringBuffer.toString());
        if(aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE){
            return 0;
        }

        return aLong.intValue();
    }

    /**
     * 将整数依次除以10求余，将余数存到list中，然后依次取出 * list.size() - 1 - i 次幂并相加
     * @param num
     * @return
     */
    public static int reverse2(int num) {
        int temp = num;
        int sign = 10;
        List<Integer> list = new ArrayList<Integer>();
        while (temp != 0) {
            int i = temp % sign;
            list.add(i);
            temp = temp / sign;
        }
        Double sum = 0.0;
        double pow;
        for (int i = 0; i < list.size(); i++) {
            int index = list.size() - 1 - i;
            pow = Math.pow(10, index);
            sum += list.get(i) * pow;
        }
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        }
        return sum.intValue();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
