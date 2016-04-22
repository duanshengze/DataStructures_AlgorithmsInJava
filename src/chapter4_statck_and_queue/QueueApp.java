package chapter4_statck_and_queue;


class Queue{
	private int maxSize;
	private long[]queArray;
	private int rear;
	private int front;
	private int nElems;
	public Queue(int max){
		maxSize=max;
		queArray=new long[max];
		rear=-1;
		front=0;
		nElems=0;
	}
	
	public void insert(long e){
		if(rear==maxSize-1)
			rear=-1;
		queArray[++rear]=e;
		nElems++;
	}
	
	public long remove(){
		
		long temp=queArray[front++];
		if(front==maxSize){
			front=0;
		}
		nElems--;
		return temp;
	}
	 public long peekFront(){
		 return queArray[front];
	 }
	
	 public boolean isEmpty(){
		 return nElems==0;
	 }
	 
	 public boolean isFull(){
		 return nElems==maxSize;
	 }
	 public int size(){
		 return nElems;
	 }
	 
	
}

public class QueueApp {

	public static void main(String[] args) {
		Queue theQueue=new Queue(5);
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		
//		theQueue.remove();
//		theQueue.remove();
//		theQueue.remove();
		
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
		theQueue.insert(80);
		
		while(!theQueue.isEmpty()){
			long n=theQueue.remove();
			System.out.print(n+" ");

		}
			System.out.println();		
	
	}

}
