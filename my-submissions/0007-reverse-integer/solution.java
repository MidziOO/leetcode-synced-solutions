class Solution {
    public int reverse(int x) {
        

        int res = 0;
        

        while(x != 0){

            int cur = x % 10;


            int newRes = res * 10 + cur ;
            

            if((newRes - cur)/10 != res) return 0;      
            res = newRes;

            x = x/10;
        }
        return res; 

    }
}
