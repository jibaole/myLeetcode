package leetcode.editor.cn;

/**
 * @description：字符串相关算法
 * @author：JBL
 * @date：2021/12/15 5:43 下午
 */
public class AlgString {

    public static void main(String[] args) {
        //System.out.println(isPalindrome(1));
        String s = "anagram", t = "nagaram";
        //System.out.println(isAnagram(s,t));

        //System.out.println(longestPalindrome("abccccdd"));
        //System.out.println(isIsomorphic("paper","title"));
        System.out.println(countBinarySubstrings("00110011"));
    }

    public static boolean isPalindrome(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }


    public static boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算一组字符集合可以组成的回文字符串的最大长度
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt / 2) * 2;
        }
        if (palindrome < s.length()) {
            palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return palindrome;
    }

    /**
     * 字符串同构
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }

    /**
     * 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
     * @param s
     * @return
     */
    public  static int countBinarySubstrings(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
