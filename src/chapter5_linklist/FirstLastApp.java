package chapter5_linklist;


class Link3{
	public long dData;
	public Link3 next;
	public Link3(long dD){
		dData=dD;
		next=null;
	}
	public void displayLink(){
		System.out.print(dData+" ");	
	}
}



class FirstLastList{
	private Link3 first;
	private Link3 last;
	public FirstLastList(){
		first=null;
		last=null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(long dD){
		Link3 link=new Link3(dD);
		
		if(isEmpty()){
			last=link;
		}
	
		link.next=first;
		first=link;
		
		
	}
	
	public void insertLast(long dD){
		Link3 link=new Link3(dD);
		if(isEmpty()){
			first=link;
		}else {
			last.next=link;
		}
		last=link;
		
		
		
	}
	
	
	
}



public class FirstLastApp {
	public static void main(String[] args) {
		
	}
}
