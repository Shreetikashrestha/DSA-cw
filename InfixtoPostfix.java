public class InfixtoPostfix {
    int precedence(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }
        else if(ch=='*'||ch=='/'){
            return 2;
        }
        else if (ch=='^'){
            return 3;
        }
        return -1;//either bracket or operand 
    }
    String convertToPostfix(String exp){
        String res="";
        stacks  stk= new stacks(exp.length());
        for(int i=0; i<exp.length();i++){
            char ch= exp.charAt(i);
            if (precedence(ch)>0){
                while (stk.isEmpty()==false && precedence(stk.peek())>=precedence(ch)) {
                    res=res+stk.pop();
                    
                }
                stk.push(ch);
            }
            else if(ch=='('){
                stk.push(ch);
               

            }
            else if(ch=='('){
                char x=stk.pop();
                while (x!='(') {
                    res=res+x;
                    x=stk.pop();
                    
                }

            }
            else{
                res=res+ch;
            }
            }

        
        return res;
    }
}

