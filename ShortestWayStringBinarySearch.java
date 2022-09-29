// Time Complexity : O(n), where n is the length of the target string
// Space Complexity : O(n log m), where m is the length of the source string and n is the length of the target string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ShortestWayStringBinarySearch {
    public int shortestWay(String source, String target) {
        //base case
        if((source == null || source.length() == 0) && (target == null || target.length() == 0)) return -1;
        int tp = 0, sp = 0, count = 1;

        //Maintain a map of each character and its list of occurences (index in the source string)
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < source.length(); i++){
            char c = source.charAt(i);
            if(map.containsKey(c)) {
                List<Integer> list = map.get(c);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(c, list);
            }
        }

        while(tp < target.length()) {
            char c = target.charAt(tp);
            //if the character is not found in the source string, return -1
            if(!map.containsKey(c)) return -1;

            //Get the list of indices of occurence of the char in the source string
            List<Integer> list = map.get(c);

            //Do binary search in the list to find source pointer index, If it's found it returns the index
            //If it's not found, it returns -(index it's supposed to be) -1
            int index = Collections.binarySearch(list, sp);

            //get the actual index it is supposed to be
            if(index < 0) index = -index -1;

            //if the index reached the end of the source string, reset the pointer and increment the count.
            if(index == list.size()) {
                sp = 0;
                count++;
            } else {
                //move the source pointer index to binary search index
                sp = list.get(index);
                sp++;
                tp++;
            }
        }
        return count;
    }
}