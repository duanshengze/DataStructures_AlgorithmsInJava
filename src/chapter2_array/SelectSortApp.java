package chapter2_array;

public class SelectSortApp {
	public static void main(String[] args) {
		
	}
}
class ArraySel{
	private long[]a;
	private int nElems;
	
	public ArraySel(int max){
		a=new long[max];
		nElems=0;
	}
	
	public void selectSort(){
		
		for(int out=0;out<nElems-1;out++){
			long min=a[out];
			 for(int i=out+1;i<nElems-2;i++){
				 if(a[i]<a[i+1]){
					 min=a[i]; 
				 }
			 }
			
			
		}
		
		
	}
	
	
}
