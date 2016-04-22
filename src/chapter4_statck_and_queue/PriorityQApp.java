package chapter4_statck_and_queue;

import sun.launcher.resources.launcher;

class PriorityQ{
	//array in storted order ,from max at 0 to min at size-1
	private int maxSize;
	private long[]queArray;
	private int nItems;
	
	public PriorityQ(int max){
		maxSize=max;
		queArray=new long[maxSize];
		nItems=0;
	}
	
	
	public void insert(long e){
		if(nItems==0){
			queArray[nItems++]=e;
		}else {
			int i=0;
			for(;i<nItems;i++){
				if(e>queArray[i]){
					break;
				}
			}
			
			for(int j=i;j<nItems;j++){
				queArray[j+1]=queArray[j];
			}
			queArray[i]=e;
			nItems++;
		}
		
		
	}
	public long remove(){
		return queArray[--nItems];
	}
	
	public boolean isFull(){
		return nItems==maxSize;
	}
	
	public boolean isEmpty(){
		return nItems==0;
	}
	
}

public class PriorityQApp {
		public static void main(String[] args) {
			PriorityQ pq=new PriorityQ(5);
			pq.insert(30);
			pq.insert(50);
			pq.insert(10);
			pq.insert(40);
			pq.insert(20);
			while(!pq.isEmpty()){
				long q=pq.remove();
				System.out.print(q+" ");
				
			}
			System.out.println(" ÊÇ·ñ¿ÕÁË"+pq.isEmpty());
		}
}
