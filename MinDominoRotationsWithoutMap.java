// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinDominoRotationsWithoutMap {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if((tops == null || tops.length == 0) && (bottoms == null || bottoms.length == 0)){
            return -1;
        }
        //target element is going to be either the top or bottom element
        //try both combinations
        int target = findMinRotations(tops, bottoms, tops[0]);
        if(target == -1) {
            target = findMinRotations(tops, bottoms, bottoms[0]);
        }
        return target;
    }

    public int findMinRotations(int[] tops, int[] bottom, int target) {
        int topRotations = 0, bottomRotations = 0;
        for(int i = 0; i < tops.length; i++) {
            //if both top and bottom equals target element, move both pointers
            if(tops[i] != target && bottom[i] != target) {
                return -1;
            }
            //if top element does not match target, increment top rotations count
            else if(tops[i] != target) {
                topRotations++;
            }
            //if bottom element does not match target, increment bottom rotations count
            else if(bottom[i] != target) {
                bottomRotations++;
            }
        }
        return Math.min(topRotations, bottomRotations);
    }
}