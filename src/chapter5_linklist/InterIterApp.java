package chapter5_linklist;

public class InterIterApp {
	public static void main(String[] args) {
		
		LinkList10 theLinkList=new LinkList10();
		ListIterator iter=theLinkList.getIterator();
		iter.insertAfter(11);
		iter.insertAfter(40);
		iter.insertAfter(30);
		iter.insertAfter(80);
		iter.insertAfter(45);
		theLinkList.displayLinkList();
		iter.reset();

		while(!iter.atEnd()){
			if(iter.getCurrent().data%3==0){
				iter.deleteCurrent();
			}else{
				iter.nextLink();
			}
		}
		
		if(iter.getCurrent().data%3==0){
			iter.deleteCurrent();
		}
		theLinkList.displayLinkList();
		
	}

}
