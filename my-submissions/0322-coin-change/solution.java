class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] minimal = new int [amount + 1];
        Arrays.fill(minimal,amount + 1);

        minimal[0] = 0;

        for(int i = 0; i <= amount; i ++){
            for(int coin : coins){
                if(i - coin >= 0){
                    minimal[i] = Math.min(minimal[i], 1 + minimal[i - coin]);
                }
            }
        } 
        if(minimal[amount] > amount){
            return -1;
        }
        else{
            return minimal[amount];
        }
    }
}
