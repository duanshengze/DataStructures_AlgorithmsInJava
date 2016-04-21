package chapter1_array;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.swing.internal.plaf.basic.resources.basic;



class Person{
	private String lastName;
	private String firstName;
	private int age;
	public Person(String last,String first,int a){
		lastName=last;
		firstName=first;
		age=a;
	}
	public void displayPerson(){
		System.out.print(" last name: "+lastName);
		System.out.print(" first name: "+firstName);
		System.out.println(" ,Age: "+age);
	}
	
	public String getLast(){
		return lastName;
	}
}

class ClassDataArray{
	private Person[]a;
	private int nElems;
	public ClassDataArray(int max){
		a=new Person[max];
		nElems=0;
	}
	
	/**
	 * 查找
	 * @param searchName
	 * @return
	 */
	public Person find(String searchName){
		int j;
		for(j=0;j<nElems;j++){
			if(a[j].equals(searchName)){
				break;
			}
		}
		if(j==nElems)return null;
		return a[j];
		
	}
	 
	/** 插入
	 * @param p
	 */
	public void insert(Person p){
		if(p==null)return;
		a[nElems]=p;
		nElems++;
	}
	
	/**
	 * 删除
	 * @param searchName
	 * @return
	 */
	public boolean delete(String searchName){
		int i;
		for( i=0;i<nElems;i++){
			if (a[i].getLast().equals(searchName)) {
				break;
			}
		}
		if(i==nElems){
			return false;
		}
		for(int k=i;k<nElems;k++){
			a[k]=a[k+1];
		}
		nElems--;
		return true;
		
		
	}
	public void displayA(){
		for(int j=0;j<nElems;j++){
			a[j].displayPerson();
			
		}
		
	}
	
}









public class ClassDataApp {
	public static void main(String[] args) {
		int maxSize=100;
		ClassDataArray arr;
		arr=new ClassDataArray(maxSize);
		arr.insert(new Person("Evans", "Patty", 24));
		arr.insert(new Person("Evans1", "Patty", 24));
		arr.insert(new Person("Evans2", "Patty", 24));
		arr.insert(new Person("Evans3", "Patty", 24));
		arr.insert(new Person("Evans4", "Patty", 24));
		arr.insert(new Person("Evans5", "Patty", 24));
		arr.insert(new Person("Evans6", "Patty", 24));
		arr.insert(new Person("Evans7", "Patty", 24));
		arr.insert(new Person("Evans8", "Patty", 24));
		arr.displayA();
		arr.delete("Evans8");
		arr.displayA();
	}

}
