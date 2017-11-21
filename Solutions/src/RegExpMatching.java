
/** 
 * Implement regular expression matching with support for '.' and '*' 
 * 
*/
public class RegExpMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        long beginTime = System.currentTimeMillis();
        boolean ret = doMatch(s, p, (char) 0);
        System.out.println("total cost on time : " + (System.currentTimeMillis() - beginTime) + " ms.");

        beginTime = System.currentTimeMillis();
        boolean ret2 = doMatch2(s, p);
        System.out.println("total cost on time : " + (System.currentTimeMillis() - beginTime) + " ms.");

        beginTime = System.currentTimeMillis();
        boolean ret3 = doMatch3(s, p);
        System.out.println("total cost on time : " + (System.currentTimeMillis() - beginTime) + " ms.");
        return ret == ret2 && ret == ret3;
    }

    /**
     * Match from the beginning of s and p to the ends.
     * 
     * Outcome: Time Limit Exceeded
     * Since there are so much redo during execution.
     * Considering for a DP solution.
     */
    private boolean doMatch(String s, String p, char preceding) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        else if (p.length() == 0)
            return false;
        else {
            char first = p.charAt(0);
            try {
                switch (first) {

                case '.':
                    if (p.length() >= 2 && p.charAt(1) == '*')
                        if (doMatch(s, p.substring(2), (char) 0))
                            return true;
                    if (s.length() > 0)
                        if (doMatch(s.substring(1), p.substring(1), '.'))
                            return true;
                    return false;

                case '*':
                    if (preceding == 0)
                        return false;
                    else if (s.length() == 0 || preceding != '.' && preceding != s.charAt(0))
                        return doMatch(s, p.substring(1), (char) 0);
                    return s.length() > 0 && (p.length() > 1 && p.charAt(1) == s.charAt(0)
                            && doMatch(s.substring(1), p.substring(1), (char) 0)
                            || doMatch(s.substring(1), p, preceding));

                default:
                    if (s.length() == 0 || s.charAt(0) != first) {
                        if (p.charAt(1) == '*')
                            return doMatch(s, p.substring(2), (char) 0);
                        else
                            return false;
                    } else
                        return doMatch(s.substring(1), p.substring(1), s.charAt(0))
                                || p.length() >= 2 && p.charAt(1) == '*' && doMatch(s, p.substring(2), (char) 0);
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    /**
     * Solution #1 in leetcode.(Recursion)
     * https://leetcode.com/problems/regular-expression-matching/solution/
     */
    boolean doMatch2(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (doMatch2(s, p.substring(2)) || (first_match && doMatch2(s.substring(1), p)));
        } else {
            return first_match && doMatch2(s.substring(1), p.substring(1));
        }
    }

    /**
     * Solution #2 in leetcode.(DP)
     */
    boolean doMatch3(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i=s.length(); i >=0; i--){
            for(int j=p.length()-1; j>=0;j--){
                boolean first_match = 
                (
                    i < s.length() &&
                    (
                        p.charAt(j)==s.charAt(i) || 
                        p.charAt(j)=='.'
                    )
                );

                if(j+1 < p.length() && p.charAt(j+1)=='*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                }else{
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        RegExpMatching rem = new RegExpMatching();

        String a = "aaaaaaaaaaaaab";
        String b = "a*a*a*a*a*a*a*a*a*a*c";
        System.out.println(rem.isMatch(a, b));
    }
}