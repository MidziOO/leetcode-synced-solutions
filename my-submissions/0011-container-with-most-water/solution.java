class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int maxV = 0;

        while(left < right){
        maxV = Math.max(maxV, Math.min(height[left], height[right]) * (right - left));

            if(height[left] < height[right] ){
                left++;
            }
            else{
                right --;
            }
        }
        return maxV;
    }
}
