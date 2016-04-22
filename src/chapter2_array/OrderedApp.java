package chapter2_array;

public class OrderedApp {

	
	public static void main(String[] args) {
		int maxSize=100;
		OrderArray arr=new OrderArray(maxSize);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(100);
		arr.insert(66);
		arr.insert(33);
		arr.display();
		int searchKey=1;
		if(arr.find(searchKey)==-1){
			System.out.println("can't find "+searchKey);
		}else{
			System.out.println("found "+searchKey);
		}
		arr.delete(22);
		arr.display();
	}
}

class OrderArray{
	private long[]a;
	private int nElems;
	public OrderArray(int max){
		a=new long[max];
		nElems=0;
	}
	
	public int size(){
		return nElems;
	}
	//二分法查�?
	
	/**
	 * @param searchKey
	 * @return 查得数组的索�? 当返�?-1 时则表示找不�?
	 */
	public int find(long searchKey){
		
		int lowerBound=0;
		int upperBound=nElems-1;
		while(true){
			int curIn=(lowerBound+upperBound)/2;
			if(a[curIn]==searchKey){
				return curIn;
			}
			if(lowerBound>upperBound){
				return -1;
			}else{
				if(a[curIn]>searchKey){
					upperBound=curIn-1;
				}else {
					lowerBound=curIn+1;
				}
			}
			
			
		}
		
		
	}
	
	//插入数据
	public void insert(long value){
		int j;
		for(j=0;j<nElems;j++){
			if(a[j]>value)
				break;
		}
		
		for(int k=nElems;k>j;k--){	
			a[k]=a[k-1];
		}
		a[j]=value;
		nElems++;
	}
	//删除数据
	public boolean delete(long value){
		int j=find(value);
		if(j==-1){
			return false;
		}
		for(int k=j;k<nElems;k++){
			a[k]=a[k+1];
		}
		nElems--;
		return true;
	}
	
	public void display(){
		
		for(int j=0;j<nElems;j++){
			
			System.out.print(a[j]+" "+"\n");
			
		}
		
	}
	
	
	
}