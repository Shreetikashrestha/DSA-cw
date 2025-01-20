public class CheckParenthesis {

    boolean checkParenthesis(String exp){
        stacks stk = new stacks(exp.length());
        String openingbraces="[{(";
        String clsoingbraces="]})";

        for(int i =0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='{'|| ch=='['||ch=='('){
                stk.push(ch);

            }
            else{
                int indx=clsoingbraces.indexOf(ch);
                char openbracket=openingbraces.charAt(indx);
                if(stk.isEmpty()){
                    return false;
                }
                if(stk.pop()!=openbracket){
                    return false;

                }

            }
        }
        if (!stk.isEmpty()){
            return false;

        }
        return true ;
    }
    
}


