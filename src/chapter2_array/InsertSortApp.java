
package chapter2_array;


class ArrayIns{
	private long[]a;
	private int nElems;
	public ArrayIns(int max){
		a=new long[max];
		nElems=0;
		
	}
	
	public void insertionSort(){
		for(int right=1;right<nElems;right++){
			long temp=a[right];
			int left=right-1;
			for(;left>=0;){
				if(a[right]<a[left]){
					a[left+1]=a[left];
					left--;
				}
				break;
			}
			a[left+1]=temp;	
		}
		
	}
	
	public void insert(long value){
		a[nElems]=value;
		nElems++;
	}
	public void display(){
		for(int i=0;i<nElems;i++){
			 System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}
	
}

public class InsertSortApp {

	
	public static void main(String[] args) {
		ArrayIns ai=new ArrayIns(100);
		ai.insert(4);
		ai.insert(5);
		ai.insert(4);
//		ai.insert(100);
//		ai.insert(98);
//		ai.insert(97);
		ai.display();
		ai.insertionSort();
		ai.display();
	}

}
