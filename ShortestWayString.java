// Time Complexity : O(mn), where m is the length of the source string and n is the length of the target string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ShortestWayString {
    public int shortestWay(String source, String target) {
        //base case
        if((source == null || source.length() == 0) && (target == null || target.length() == 0)) return -1;
        int tp = 0, sp = 0, count = 0;

        //traverse target string and match every character with the source string. If it matches, increment both the pointers else increment source pointer alone
        //When the source pointer reaches the end, reset the source pointer and increment the count
        while(tp < target.length()) {
            int pos = tp;
            while(sp < source.length() && tp < target.length()) {
                if(target.charAt(tp) == source.charAt(sp)) {
                    tp++;
                    sp++;
                } else {
                    sp++;
                }
            }
            //If the target pointer is still the same as the position, there are matching characters in the source string
            if(pos == tp) {
                return -1;
            }
            sp = 0;
            count++;
        }
        return count;
    }
}