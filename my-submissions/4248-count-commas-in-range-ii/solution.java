class Solution {
    public long countCommas(long n) {
        if (n < 1000) return 0; 
        
        long commas = 0;
        long start = 1000;

        while(start <= n){
            commas += n - start + 1;
            start *= 1000;

        }
        return commas;

    }
}
