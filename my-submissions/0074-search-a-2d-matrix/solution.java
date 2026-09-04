class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows - 1;
        int targetRow = -1; 
        while(low <= high){
            int mid = low + (high - low ) /2; 
            
            if(target >= matrix[mid][0] && target <= matrix[mid][cols-1]){
                targetRow = mid;
                break; 
            }

            else if(matrix[mid][0] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(targetRow == -1) return false;


        int left = 0;
        int right = cols-1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(target == matrix[targetRow][mid]){
                return true; 
            }

            else if(matrix[targetRow][mid] < target){
                left = mid+1;
            }
            else {
                right = mid -1;
            } 

        }
        return false;
    }
}
