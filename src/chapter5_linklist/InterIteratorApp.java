package chapter5_linklist;
class Link10{
	public long dData;
	public Link10 next;
	public Link10(long dD){
		dData=dD;
	}
	
	public void displayLink(){
		System.out.print(" "+dData+" ");
	}

}
class LinkList10{
	private Link10 first;
	
	
	public LinkList10(){
		first=null;
		;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void setFirst(Link10 e){
		first=e;
	}
	
	public Link10 getFirst(){
		
		return first;
	}
	
	public ListIterator getIterator(){
		return new ListIterator(this);
	}
	public void displayLinkList(){
		Link10 current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;	
		}
		System.out.println("");
	}
}

class ListIterator{
	private LinkList10 mLinkList; 
	private Link10 previous;
	private Link10 current;
	public ListIterator(LinkList10 linkList){
		mLinkList=linkList;
		reset();
	}
	public void reset(){
		current=mLinkList.getFirst();
		previous=null;
	}
	public boolean atEnd(){
		return current.next==null;
	}
	public void nextLink(){
		previous=current;
		current=current.next;
	}
	public Link10 getCurrent(){
		return current;
	}
	
	public void insertAfter(long dd){
		Link10 newLink=new Link10(dd);
		if(mLinkList.isEmpty()){
			mLinkList.setFirst(newLink);
			current=newLink;		
		}else {
			newLink.next=current.next;
			current.next=newLink;
			nextLink();
		}
	}
	
	public void inserBefore(long e){
		Link10 newLink=new Link10(e);
		if(previous==null){
			mLinkList.setFirst(newLink);
			reset();
		}else {
			newLink.next=current;
			previous.next=newLink;
			current=newLink;
		}	
	}
	
	public long deleteCurrent(){
		if(current==null)throw new RuntimeException("无数据可删除！");
		long value=current.dData;
		if(previous==null){
			mLinkList.setFirst(current.next);
			reset();
		}else {
			previous.next=current.next;
			
			if(atEnd()){
				reset();
			}else {
				current=current.next;
			}
	
		}
		return value;
	}
	
}
public class InterIteratorApp {
	public static void main(String[] args) {
		LinkList10 theLinkList=new LinkList10();
		ListIterator iter=theLinkList.getIterator();
		iter.insertAfter(10);
		iter.insertAfter(20);
		iter.insertAfter(30);
		iter.inserBefore(100);
		theLinkList.displayLinkList();
	}
	

}
