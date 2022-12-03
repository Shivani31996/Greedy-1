// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - In the forward pass, check only the element on the left. If the element on the left is smaller than the current
 * element, increase current candy count by 1.
 * 2 - In the backward pass, take the maximum of the current candy count and one plus the candy count of the element 
 * on the right if the rating of the current element is more than that of the element on the right.
 * 3 - In the end, we return the sum of the resultant array
 */

public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
        {
            return 0;
        }

        int n = ratings.length;
        int result[] = new int[n];
        Arrays.fill(result,1);
        
        if(n == 1)
        {
            return 1;
        }
        
        //forward pass
        for(int i = 1; i < n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                result[i] = 1 + result[i -1];
            }
        }
        
        //backward pass
        int sum = result[n - 1];
        for(int i = n - 2; i>=0; i--)
        {
            if(ratings[i] > ratings[i + 1])
            {
                result[i] = Math.max(result[i], 1 + result[i + 1]);
            }
            sum += result[i];
        }
        
        return sum;
    }
}
