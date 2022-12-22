// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Variables used - currInt, nextInt, jumps
 * 2 - Iterate over each element, calculate the next interval and update the currInt if required. Calculate jumps
 * 2 - IDea is to calculate the next interval greedily so that we get to explore as many elements as possible
 */

class Solution {
    public int jump(int[] nums) {
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        
        if(nums.length < 2)
            return 0;
        
        for(int i=1; i < nums.length;i++)
        {
            nextInt = Math.max(nextInt,nums[i] + i);
            if(i == currInt && i != nums.length - 1)
            {
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}


/*
 * Approach 2 - BFS
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        if(n < 2)
            return 0;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        q.add(0);
        set.add(0);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                int currInd = q.poll();
                if(currInd >= n-1)
                    return jumps;
                for(int j = 0; j<=nums[currInd];j++)
                {
                    int newInd = j + currInd;
                    if(!set.contains(newInd))
                    {
                        q.add(newInd);
                        set.add(newInd);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}