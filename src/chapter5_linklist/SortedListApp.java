package chapter5_linklist;
class Link5{
	public long dData;
	public Link5 next;
	public Link5(long dD){
		dData=dD;
	}
	public void displayLink(){
		System.out.print(" "+dData+" ");
	}
}
class SortedLink{
	private Link5 first;
	public SortedLink (){
		first=null;
	}
	
	
	
	
	public long remove(){	
		Link5 temp=first;
		first=first.next;
		return temp.dData;	
	}
	public void insert(long e){
		Link5 newLink=new Link5(e);
		Link5 current=first;
		Link5 previous=null;
		while(current!=null&&current.dData<e){
			previous=current;
			current=current.next;
			
		}
		if(previous==null){
			newLink.next=first;
			first=newLink;
			return;
		}
		previous.next=newLink;
		newLink.next=current;
		
	}
	
	public void displaySortedLink(){
		Link5 current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println("");
		
		
	}
	
}


public class SortedListApp {
	public static void main(String[] args) {
		SortedLink sortedLink=new SortedLink();
		sortedLink.insert(40);
	
		sortedLink.insert(40);
	
		sortedLink.insert(10);
		sortedLink.insert(30);
		sortedLink.insert(50);
		sortedLink.displaySortedLink();
	}
}
