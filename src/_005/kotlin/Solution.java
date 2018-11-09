package _005.kotlin;

/**
 * @author relish
 * @since 2018/10/20
 */
class Solution {
    // 1 暴力破解 O(n^3) 超时
    public String longestPalindrome1(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        String result = s.substring(0, 1);
        int maxLength = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                String str = s.substring(i, j);
                if (str.equals(new StringBuilder(str).reverse().toString())) {
                    int length = str.length();
                    if (length > maxLength) {
                        maxLength = length;
                        result = str;
                    }
                }
            }
        }
        return result;
    }

    // 2 中心扩散 O(n^2) 超时
    public String longestPalindrome2(String s) {
        if (s.length() <= 1) return s;
        char[] c = s.toCharArray();
        String ans = s.substring(0, 1);
        int maxLength = 1;
        for (int i = 0; i < c.length; i++) {
            final int initL = i - 1;
            final int initR = i + 1;
            int l = initL;
            int r = initR;
            int count = 1;
            String sb = c[i] + "";
            boolean needRunTwice = false;
            if (r < c.length && c[i] == c[r]) {
                needRunTwice = true;
                sb = sb + c[r];
                count++;
                r++;
                if (count > maxLength) {
                    maxLength = count;
                    ans = sb;
                }
            }
            String tAns = handle(c,l,r,sb,count,ans,maxLength);
            if(tAns.length()>maxLength){
                ans = tAns;
                maxLength = ans.length();
            }
            if(needRunTwice){
                count = 1;
                l = initL;
                r = initR;
                sb = c[i] + "";
                String tAns2 = handle(c,l,r,sb,count,ans,maxLength);
                if(tAns2.length()>maxLength){
                    ans = tAns2;
                    maxLength = ans.length();
                }
            }
        }
        return ans;
    }

    private static String handle(char[] c, int l, int r, String sb, int count, String oldAns, int oldMaxLength){
        String ans = oldAns;
        int maxLength = oldMaxLength;
        while (l >= 0 && r < c.length) {
            if (c[l] != c[r]) break;
            sb = c[l] + sb + c[r];
            count += 2;
            if (count > maxLength) {
                maxLength = count;
                ans = sb;
            }
            l--;
            r++;
        }
        return ans;
    }


    // 3
    public String longestPalindrome(String s) {
        String ans = "";
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("ccc"));
        System.out.println(solution.longestPalindrome("aaaa"));
        System.out.println(solution.longestPalindrome("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
    }
}