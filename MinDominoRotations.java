// Time Complexity : O(n)
// Space Complexity : O(n), for maps
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if((tops == null || tops.length == 0) && (bottoms == null || bottoms.length == 0)){
            return -1;
        }
        //Maintain a map to keep count of elements and their frequency
        Map<Integer, Integer> map = new HashMap<>();
        int target = -1;
        for(int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
            //if the freq exceeds the length of the string, set it as target
            if(map.get(tops[i]) >= tops.length) {
                target = tops[i];
                break;
            }
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);
            if(map.get(bottoms[i]) >= bottoms.length) {
                target = bottoms[i];
                break;
            }
        }
        //if there is an element which is equal to or more than the length of the string, target is present, find min rotations
        if(target != -1) {
            return findMinRotations(tops, bottoms, target);
        }
        return target;
    }

    public int findMinRotations(int[] tops, int[] bottoms, int target) {
        int topRotations = 0, bottomRotations = 0;
        for(int i = 0; i < tops.length; i++) {
            //if both top and bottom equals target element, move both pointers
            if(tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            //if top element does not match target, increment top rotations count
            else if(tops[i] != target) {
                topRotations++;
            }
            //if bottom element does not match target, increment bottom rotations count
            else if(bottoms[i] != target) {
                bottomRotations++;
            }
        }
        //return min of top and bottom rotations
        return Math.min(topRotations, bottomRotations);
    }
}