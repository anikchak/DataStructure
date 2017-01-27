package queue;

import java.util.LinkedList;

import practice.linkedlist.LinkedListImpl;

class Animal{
	int order;
	String type;
	
	Animal(String s){
		this.type = s;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
		
}

//Dogs
class Dogs extends Animal{
	Dogs(String s){
		super(s);
	}
}

//Cats
class Cats extends Animal{
	Cats(String s){
		super(s);
	}
}
public class AnimalQueue {

	LinkedList<Dogs> dog = new LinkedList<Dogs>();
	LinkedList<Cats> cat = new LinkedList<Cats>();
	int order = 0;
	
	public void enQ(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dogs){
			dog.add((Dogs)a);
		}else if(a instanceof Cats){
			cat.add((Cats)a);
		}
	}
	
	public Dogs deQDog(){
		if(!dog.isEmpty()){
			return dog.pop();
		}else{
			return null;
		}
	}
	
	public Cats deQCat(){
		if(!cat.isEmpty()){
			return cat.pop();
		}else{
			return null;
		}
	}
	
	public Animal deQAny(){
		if(dog.isEmpty() && !cat.isEmpty()){
			return (Animal)deQCat();
		}else if(cat.isEmpty() && !dog.isEmpty()){
			return (Animal)deQDog();
		}
		Dogs d = dog.peek();
		Cats c = cat.peek();
		
		if(d.getOrder()<c.getOrder()){
			return (Animal)deQDog();
		}else{
			return (Animal)deQCat();
		}
	}
	
	public static void main(String args[]){
		AnimalQueue aq = new AnimalQueue();
		aq.enQ(new Dogs("d1"));
		aq.enQ(new Dogs("d2"));
		aq.enQ(new Cats("c1"));
		aq.enQ(new Cats("c2"));
		aq.enQ(new Cats("c3"));
		aq.enQ(new Dogs("d3"));
		aq.enQ(new Cats("c4"));
		aq.enQ(new Dogs("d4"));
		aq.enQ(new Dogs("d5"));
		aq.enQ(new Cats("c5"));
		//Animal a1 = aq.deQDog();
		//Animal c1 = aq.deQCat();
		int size = aq.dog.size()+aq.cat.size();
		//System.out.println("DeQ Dog = "+a1.getType()+" ["+a1.getOrder()+"]");
		//System.out.println("DeQ Cat = "+c1.getType()+" ["+c1.getOrder()+"]");
		
		System.out.println("DeQ Any");
		for(int i=0;i<size;i++){
			Animal a = aq.deQAny();
			System.out.println("DeQ Any = "+a.getType()+" ["+a.getOrder()+"]");
			//size = aq.dog.size()+aq.cat.size();
		}
		;
		
		//System.out.println("DeQ ANY = "+aq.deQAny().getType()+" ["+aq.deQAny().getOrder()+"]");
	}
}
