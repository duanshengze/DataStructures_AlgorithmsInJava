package chapter5_linklist;
class Link7{
	public long dData;
	public Link7 next;
	public Link7 prev;
	public Link7(long dD){
		dData=dD;
	}
	
	public void displayLink(){
		
		System.out.print(" "+dData+" ");
	}
	
}

class DoubleLinkedList{
	private Link7 first;
	private Link7 last;
	public DoubleLinkedList(){
		first=null;
		last=null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void insertFirst(long e){
		Link7 newLink=new Link7(e);
		if(isEmpty()){
			last=newLink;
		}else {
			first.prev=newLink;
		}
			newLink.next=first;
			first=newLink;	
	}
	
	public void insertLast(long e){
		Link7 newLink=new Link7(e);
		if(isEmpty()){
			first=newLink;
		}else {
			newLink.prev=last;
			last.next=newLink;
		}
		last=newLink;
	} 
	
	
	public Link7 deleteFirst(){
		Link7 temp=first;
		
		if(first.next==null){
			last=null;
		}else {
			first.next.prev=null;
		}
		 first=first.next;
		return temp;
		
	}
	
	
	public Link7 deleteLast(){
		Link7 temp=last;
		if(last.prev==null){
			// only one item
			first=null;
		}else{
			last.prev.next=null;
		}
		    last=last.prev;
		return last;
		
	}
	
	public boolean insertAfter(long key,long dd){
		//ensure no empty list?
		Link7 current=first;
		Link7 newLink=new Link7(dd);
		while(current!=null){
			if(current.dData==key){
				if(current==last){
					current.prev=last;
					last.next=current;
					last=current;
					return true;
				}else{
					newLink.prev=current;
					newLink.next=current.next;
					current.next=newLink;
					current.next.prev=newLink;
					return true;
				}
		
			}//end if(current.dData==old)
			current=current.next;
		}//end while
		return false;
	}
	public Link7 deleteKey(long key){
		if(isEmpty())return null;
		Link7 current=first;
		while(current.dData!=key){
			current=current.next;
			if(current==null){
				return null;
			}
		}
		if(current==first){
			if(current.next==null){
				last=null;
				first=last;
				
			}else {
				current.next.prev=null;
				first=first.next;
				
			}
			return current;
		}else if(current==last){
			if(current.prev==null){
				first=null;
			}else {
				current.prev.next=null;
				last=current.prev;
			}
			return current;
			
		}else {
			current.prev.next=current.next;
			current.next.prev=current.prev;
			return current;
		}
		
		
	}
	
	public void displayForward(){
		System.out.print("List(first-->last)");
		Link7 current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}	
		System.out.println();
	}
	
	public void displayBackward(){
		System.out.print("List(last-->first)");
		Link7 current=last;
		while(current!=null){
			current.displayLink();
			current=current.prev;
		}
		System.out.println();
		
	}
}

public class DoubleLinkedApp {
	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
		System.out.println(doubleLinkedList.insertAfter(1, 2));
		doubleLinkedList.insertFirst(22);
		doubleLinkedList.insertFirst(44);
		doubleLinkedList.insertFirst(66);
		doubleLinkedList.insertFirst(11);
		doubleLinkedList.insertFirst(45);
		System.out.println(doubleLinkedList.insertAfter(45, 1));
		doubleLinkedList.displayBackward();
		
		doubleLinkedList.displayForward();
		doubleLinkedList.deleteKey(45).displayLink();
		doubleLinkedList.displayBackward();
	}
}
