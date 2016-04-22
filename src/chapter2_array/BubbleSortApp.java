package chapter2_array;

public class BubbleSortApp {
	public static void main(String[] args) {
			int maxSize=100;
			ArrayBub arr=new ArrayBub(maxSize); 
			arr.insert(77);
			arr.insert(99);
			arr.insert(44);
			arr.insert(55);
			arr.display();
			arr.bubbleSort();
			arr.display();
	}
}
class ArrayBub{
	private long[]a;
	private int nElems;
	public ArrayBub(int max) {
		a=new long[max];
		nElems=0;
		// TODO Auto-generated constructor stub
	}
	
	public void bubbleSort(){
		
		for(int out=nElems-1;out>1;out--){
			for(int j=0;j<out;j++){
				if(a[j]>a[j+1]){
					
					long temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}	
		}
		
	}
	public void display(){
		for(int i=0;i<nElems;i++){
			
			System.out.print(" "+a[i]);
			
		}
		System.out.println(" ");
	}
	
	
	public void insert(long e){
		
		a[nElems]=e;
		nElems++;
		
	}
	
}
