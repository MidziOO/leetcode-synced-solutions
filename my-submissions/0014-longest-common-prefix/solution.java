class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0 || strs == null) return "";

        StringBuilder prefix = new StringBuilder(strs[0]);

        for(int i =0; i < strs.length; i ++ ){
            while(strs[i].indexOf(prefix.toString() ) != 0 ){
                prefix.setLength(prefix.length() - 1);

                if(prefix.length() == 0){
                     return "";
                }
            }
        }
        return prefix.toString();

    }
}
