package leetcode.editor.cn;

/**
 * @description： 用JAVA实现字符串压缩算法。将字符串 aaabcdda 编程实现将其转换为 3a1b1c2d1a
 * @author：JBL
 * @date：2021/9/22 4:58 下午
 */
public class CompressAlg {
    public static String stringToReduce(final String str) {
        StringBuffer result = new StringBuffer();
        char c1 = str.charAt(0);
        int sum = 1;
        for (int i = 1, count = str.length(); i < count; i++) {
            char c2 = str.charAt(i);
            if (c1 == c2) {
                sum++;
                continue;
            }
            result.append(c1).append(sum);
            c1 = c2;
            sum = 1;
        }
        result.append(c1).append(sum); // 加上最后一个字符及个数
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringToReduce("aabcccccaaa"));
    }

}
