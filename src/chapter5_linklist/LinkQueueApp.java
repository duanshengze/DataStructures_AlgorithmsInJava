package chapter5_linklist;

class Link4{
	public long dData;
	public Link4 next;
	public Link4(long dD){
		dData=dD;
		next=null;
	}
	public void displayLink(){
		System.out.print(" "+dData+" ");
	}
}

class FirstLastList{
	private Link4 first;
	private Link4 last;
	public FirstLastList(){
		first=null;
		last=null;
	}
	
	public long deleteFirst(){
		long result;
		if(first!=null){
			result=first.dData;
			first=first.next;
			return result;
		}
		throw new IllegalArgumentException("链表为空，无法删除");
	}
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertLast(long e){
		Link4 link=new Link4(e);
		if(isEmpty()){
			first=link;
		}else {
			last.next=link;	
		}
		last=link;
	}
	public void displayLinkList(){
		Link4 current=first;
		System.out.print("front-->rear");
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println();
	}
	
}

class LinkQueue{
	private FirstLastList linklist;
	
	public LinkQueue(){
		linklist=new FirstLastList();
	}
	
	public long remove(){
		return linklist.deleteFirst();
	}
	
	public void insert(long e){
		linklist.insertLast(e);
	}
	
	public void displayQueue(){
		linklist.displayLinkList();
	}
	
}
public class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue queue=new LinkQueue();
		queue.insert(2);
		queue.insert(3);
		queue.displayQueue();
		queue.remove();
		queue.displayQueue();
	}
}
