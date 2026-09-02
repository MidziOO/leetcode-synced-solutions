class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>(); 
    
        for(int i = 0; i < tokens.length ; i++ ){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                
                int b = stack.pop();
                int a = stack.pop();
                 
                if(tokens[i].equals("+")){
                    stack.push(a+b);
                }
                if(tokens[i].equals("-")){
                    stack.push(a-b);
                } 
                if(tokens[i].equals("*")){
                    stack.push(a*b);
                }
                if(tokens[i].equals("/")){
                    stack.push(a/b);
                }   
            } 
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        } 
        return stack.pop();
    }
}
