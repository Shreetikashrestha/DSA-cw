public class stacks {
  
    char stk[];
    int size;
    int top=-1;
    stacks(int size){
    this.size =size;
    stk=new char[size];
    }
    void push(char data){
        if(isFULL()){
            System.out.println("stack overflow");
        }
        else{
            // top++;
            // stk[top]=data; or
            stk[++top]=data;
        }
    }
    char pop(){
        if(isEmpty()){
            System.out.println("stack underflow");
            return 'f';
        }
        return stk[top--];//pahila top ko value then --

    }
    char peek(){
        return stk[top];
    }
    
    boolean isFULL(){
    return top==size-1;
    }
    
    boolean isEmpty(){
        return top==-1;
    }
      public static void main(String[] args) {
    stacks stk=new stacks(5);
    stk.push(10);
    stk.push(20);
    System.out.println(stk.pop());
    
}

  
  }
