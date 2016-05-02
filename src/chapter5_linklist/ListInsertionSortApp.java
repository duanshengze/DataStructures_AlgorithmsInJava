package chapter5_linklist;
class Link6{
	long dData;
	Link6 next;
	public Link6(long dD) {
		dData=dD;
	}
	public void displayLink(){
		System.out.print(" "+dData+" ");
	}
}
class SortedLinkList{
	private Link6 first;
	public SortedLinkList(long []linkArr){
		for(int i=0;i<linkArr.length;i++){
			insert(linkArr[i]);
		}
	}
	
	public void insert(long e){
		Link6 link6=new Link6(e);
		Link6 previous=null;
		Link6 current=first;
		
		while(current!=null&&current.dData<e){
			previous=current;
			current=current.next;
		}
		if(previous==null){
			link6.next=first;
			first=link6;
			return;
		}
		previous.next=link6;
		link6.next=current;
	
	}
	
	public void displayList(){
		Link6 current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println();
		
		
	}
	
	
}

public class ListInsertionSortApp {

	public static void main(String[] args) {
		SortedLinkList sortedLinkList=new SortedLinkList(new long[]{10,13,20,45,6,4,3,2,1});
		sortedLinkList.displayList();
	}

}
