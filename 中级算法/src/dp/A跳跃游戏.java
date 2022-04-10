package dp;

public class A跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,0,1,4};
        boolean b = (new A跳跃游戏()).canJump2(nums);
        System.out.println(b);

    }


    //贪心
    public boolean canJump(int[] nums){
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if(i <= rightmost){
                rightmost = Math.max(rightmost,i+nums[i]);
                if(rightmost >= n-1){
                    return true;
                }
            }
        }
        return false;
    }

    // dp
    public boolean canJump2(int[] nums){
        int len = nums.length;
        if(len <= 1)
            return true;

        //dp[i] 代表从nums[0...i-1]一路跳过来，是否能到达
        boolean[] dp = new boolean[len];

        //初始条件
        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && j+nums[j] >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }

    //DFS
    boolean flag = false;
    public  boolean canJump3(int[] nums) {
        int len = nums.length;
        if(len <= 1)
            return true;
        boolean[] visited = new boolean[len];
        dfs(nums,0,len,visited);
        return flag;
    }

    public void dfs(int[] nums,int k,int len,boolean[] visited){
        if(k >= len-1){
            flag = true;
            return;
        }
        if(visited[k] || nums[k] == 0) return;
        visited[k] = true;
        for (int i = 1; i <= nums[k]; i++) {
            dfs(nums,i+k,len,visited);
        }
    }
}
