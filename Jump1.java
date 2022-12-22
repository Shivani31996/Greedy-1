import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*Approach 1 - Greedy
 * 1 - Start with a pointer at the last index. 
 * 2 - We check if using the 2nd last element we are able to reach the last element. IF yes, then the new target will
 * be the second last element. 
 * 3 - In the end, we check if the target has reached index 0 which means it was able to traverse until the very beginning
 */
public class Jump1 {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        int n = nums.length;
        int target = n - 1;
        for(int i = n-2;i >=0;i--)
        {
            if(nums[i] + i >= target)
            {
                target = i;
            }
        }
        return target == 0;
    }
}


/*
 * Approach 2 - BFS with Optimization
 */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        if(nums.length == 1)
        {
            return true;
        }
        int n = nums.length;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int j = 1; j <= nums[curr];j++)
            {
                int idx = j + curr;
                if(idx == n - 1)
                    return true;
                if(!set.contains(idx))
                {
                    q.add(idx);
                    set.add(idx);
                }
            }
        }
        return false;
    }
}