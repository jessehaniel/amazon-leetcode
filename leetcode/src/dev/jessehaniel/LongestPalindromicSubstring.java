package dev.jessehaniel;

public class LongestPalindromicSubstring {

    // Given a string s, return the longest palindromic substring in s.

    private int lo;
    private int maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        var output = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(output);//bab
        output = new LongestPalindromicSubstring().longestPalindrome("cbbd");
        System.out.println(output);//bb
        output = new LongestPalindromicSubstring().longestPalindrome("a");
        System.out.println(output);//a
        output = new LongestPalindromicSubstring().longestPalindrome("ac");
        System.out.println(output);//a
    }

}
