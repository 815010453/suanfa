import java.util.Stack;

public class TwoStacksQueue{
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;
    public TwoStacksQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }
    private void pushToPop(){
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();

    }

    public int poll(){
        if(stackPush.empty()&& stackPop.empty()){
            throw  new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw  new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }
    public static void main(String[] args){
        TwoStacksQueue q = new TwoStacksQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.stackPush);
        System.out.println(q.stackPop);
        System.out.println(q);
    }
}