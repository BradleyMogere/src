public class Stack {
    /* Your Stack implementation will be here.
     * You can include any assumptions you have in your pdf submission*/
    int top;
    int[] array;
    int size;

    public  Stack(int capacity){
        this.size = capacity;
        array = new int[capacity];
        top = -1;
    }

    boolean isEmpty(){
        return top == -1;
    }
    boolean isFull(){
        return top == size - 1;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Your stack is full");
            return;
        }
        array[++top] = data;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Your stack is empty");
            return -1;
        }
        return array[top--];
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Your stack is empty");
            return -1;
        }
        return array[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(100000);
        stack.push(40);
        stack.push(60);
        stack.push(90);

        // Hapa tuna print the contents of the stack, usually we would iterate and pop elements
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
