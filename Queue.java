public class Queue {
    /* Your Queue implementation will be here.
     * You can include any assumptions you have in your pdf submission*/
    int front, rear, size;
    int capacity ;
    int array[];

    Queue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.front = this.rear = 0;
        this.array = new int[capacity];
    }
    boolean isFull(){
        return size == capacity;
    }
    boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int element){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        this.array[this.rear] = element;
        this.rear = (this.rear + 1) % this.capacity;
        this.size++;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int element = array[front];
        front = (front + 1) % capacity;
        size--;

        return;

    }

    int front(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }

    int rear(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return array[rear-1];
    }

    public static void main(String[] args) {
        //instantiating the objects
        Queue q = new Queue(100000);
        q.enqueue(1000);
        q.enqueue(2000);
        q.enqueue(3000);

        q.dequeue();
        System.out.println(q.front());
        System.out.println(q.rear());
    }
}
