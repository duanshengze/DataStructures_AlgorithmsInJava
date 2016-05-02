package chapter5_linklist;

import sun.reflect.generics.tree.ReturnType;

class Link2{
	public int iData;
	public double dData;
	public Link2 next;
	
	public Link2(int iD,double dD){
		iData=iD;
		dData=dD;
		next=null;
	}
	
	public void displayLink2(){
		System.out.print("{ "+iData+","+dData+" }");
	}
	
}

class Link2List{
	public Link2 first;
	
	public Link2List() {
		first=null;
	}
	
	public void insertFirst(int iD,double dD){
		Link2 newLink2=new Link2(iD, dD);
		newLink2.next=first;
		first=newLink2;
	}
	public Link2 deleteFirst(){
		Link2 temp=first;
		first=first.next;
		return temp;
	}
	
	public Link2 find(int iD){
		Link2 current=first;
		while(!(current==null)){
			if(current.iData==iD){
				break;
			}
			current=current.next;
		}
		return current;
	}
//	//自己写的方法
//	public Link2 delete(int iD){
//		Link2 temp=first;
//		Link2 current=first;
//		if(first.iData==iD) {
//			first=first.next;
//			return temp;
//		}
//		while(current!=null){
//			if(current.next!=null&&current.next.iData==iD){
//				temp=current.next;
//				current.next=current.next.next;
//				return temp;
//			}
//			current=current.next;
//		}
//		return null;
//	}
	// 调用删除的前提是链表非空
	public Link2 delete(int iD){
		Link2 previous=first;
		Link2 content=first;
		
		while(content.iData!=iD){
			if(content.next==null){
					return null;
				}else {
					previous=content;
					content=content.next;
				}
	 }//end while 
			if(content==first){
				first=first.next;
			}else {
				previous.next=content.next;
			}
			return content;
	}
	
	
	public void insertAfter(int key,Link2 newLink){
		
		if(first==null) return ;//如果为空则返回

		Link2 previous=first;
		Link2 current=first;
		while(current.iData!=key){
			if(current.next==null){
				return;
			}else {
				current=current.next;
			}
		}
		//find it
		Link2 after=current.next;
		current.next=newLink;
		newLink.next=after;
		
	}
	
	public void displayLink2List(){
		Link2 current=first;
		System.out.print("First-->Last ");
		while(!(current==null)){
			current.displayLink2();
			current=current.next;
		}
		System.out.println();
		
	}
	
}

public class LinkList2App {
	public static void main(String[] args) {
		Link2List link2List=new Link2List();
		link2List.insertFirst(12, 12.9);
		link2List.insertFirst(13, 13.9);
		link2List.insertFirst(14, 14.9);
		link2List.insertFirst(14, 14.9);
		link2List.displayLink2List();
		link2List.delete(13).displayLink2();;
		link2List.displayLink2List();	
		link2List.insertAfter(1, new Link2(44, 44.3));
		link2List.displayLink2List();
	}
}
