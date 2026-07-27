class Solution {
    public String addBinary(String a, String b) {

        int carry = 0; 

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j>= 0 || carry > 0){
            int sum = carry; 

            if(i >= 0){

                if(a.charAt(i) == '1'){
                    sum += 1;
                }
                i--;
            }

            
            if(j >= 0){

                if(b.charAt(j) == '1'){
                    sum += 1;
                }
                j--;
            }

            if(sum == 0){
                result.append(0);
                carry = 0;
            }

            
            if(sum == 1){
                result.append(1);
                carry = 0;
            }
            
            if(sum == 2){
                result.append(0);
                carry = 1;
            }
            
            if(sum == 3){
                result.append(1);
                carry = 1;
            }
        }
    return result.reverse().toString();
    }
}
