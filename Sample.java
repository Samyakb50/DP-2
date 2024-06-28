// Time Complexity : O(2^(coins.length+ sum))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes, time limit exceed
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
int count(int coins[], int n, int sum)
    {

        if (sum == 0)
            return 1;

        if (sum < 0 || n<= 0)
            return 0;

        return count(coins, n - 1, sum)
            + count(coins, n, sum - coins[n - 1]);
    }


not working
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : yes
int count(int coins[], int n, int sum)
{
    int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;

        for (int j=0;j<=n;j++){
            dp[0][j] = 999999;
        }

        for (int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if (j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                    if (j==n){
                        if (dp[i-1][j] != 999999 && dp[i][j]!= dp[i-1][j])
                            ans += 1;
                        else if(dp[i][j-coins[i-1]] != 999999)
                            ans += 1;
                    }
                } 
            }
        }
        return ans;
    }


// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
int count(int coins[], int n, int sum)
{
    int m = coins.length;
    int n = amount;
    int[] dp = new int[n+1];
    dp[0] = 1;

    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if (j<coins[i-1])
                dp[j] = dp[j];
            else
                dp[j] = dp[j] + dp[j-coins[i-1]];
        }
    }
    return dp[n];
}


// Time Complexity : O(n)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public int minCost(int[][] costs){
    int n = costs.length;

    int retR = costs[n-1][0];
    int retB = costs[n-1][1];
    int retG = costs[n-1][2];
    
    for(int i=n-2;i>=0;i--){
        int tempR = retR;
        retR = costs[i][0] + Math.min(retB, retG);
        int tempB = retB;
        retB = costs[i][1] + Math.min(tempR, retG);
        retG = costs[i][2] + Math.min(tempR, tempB);
    }

    return Math.min(retR, Math.min(retB, retG));
}