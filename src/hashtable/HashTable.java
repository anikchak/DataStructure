package hashtable;

import java.util.ArrayList;

class HashNode<K,V>{
	K key;
	V value;
	HashNode<K,V> next;
	
	HashNode(K key, V val){
		this.key = key;
		this.value = val;
	}
}

public class HashTable<K,V> {

	ArrayList<HashNode<K,V>> hashList = new ArrayList<HashNode<K,V>>();
	int size = 0;
	int noOfBuckets = 20;
	
	HashTable(){
		for(int i=0;i<noOfBuckets;i++){
			hashList.add(null);
		}
	}
	
	//This method is used to fetch the index corresponding to key -- Hash function
	public int getKeyIndex(K key){
		int hashCode = key.hashCode();
		int index = hashCode%noOfBuckets;
		return index;
	}
	
	public void add(K key, V value){
		int keyIndex = getKeyIndex(key);
		HashNode<K,V> head = hashList.get(keyIndex);
		//Checking if the key is already present
		while(head!=null){
			if(head.key.equals(key)){
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = hashList.get(keyIndex);
		HashNode<K,V> newNode = new HashNode<K,V>(key, value);
		newNode.next = head;
		hashList.set(keyIndex, newNode);
		size++;
		//Checking load factor
		if((1.0*size)/noOfBuckets >= 0.7)
		{
			noOfBuckets = 2*noOfBuckets;
			size=0;
			ArrayList<HashNode<K,V>> temp = hashList;
			hashList = new ArrayList<HashNode<K,V>>();
			//Re-initializing hashList with new bucket size
			for(int i=0;i<noOfBuckets;i++){
				hashList.add(null);
			}
			//Re-assigning all the values
			for(HashNode<K,V> n : temp){
				while(n != null){
					{
						add(n.key, n.value);
						n = n.next;
					}
				}
			}
		}
	}
	
	public V get(K key){
		int keyIndex = getKeyIndex(key);
		HashNode<K,V> n = hashList.get(keyIndex);
		while(n != null){
			if(n.key.equals(key)){
				return n.value;
			}
			n = n.next;
		}
		return null;
	}
	
	public V remove(K key){
		int keyIndex = getKeyIndex(key);
		HashNode<K,V> n = hashList.get(keyIndex);
		HashNode<K,V> prev = null;
		while(n!=null){
			if(n.key.equals(key)){
				break;
			}else{
				prev = n;
				n = n.next;
			}
		}
		//Key not found
		if(n == null){
			return null;
		}
		//If key is found then check if prev is null
		if(prev != null){
			prev.next = n.next;
		}else{
			hashList.set(keyIndex, n.next);
		}
		size--;
		return n.value;
	}
	
	public void display(){
		System.out.println();
		for(HashNode<K,V> n : hashList){
			while(n!=null){
				System.out.print("<"+n.key+","+n.value+"> ");
				n = n.next;
			}
		}
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String args[]){
		HashTable<Integer, String> ht = new HashTable<Integer, String>();
		ht.add(1, "one");
		ht.add(11, "eleven");
		System.out.println("HashTable Size = "+ht.size());
		System.out.println(ht.get(11));
		//System.out.println(ht.remove(11));
		ht.add(12,"twelve");
		ht.add(2, "two");
		ht.add(3, "three");
		ht.add(4, "four");
		ht.add(5, "five");
		ht.add(21, "twenty one");
		System.out.println(ht.get(90));
		ht.display();
		System.out.println("\n\nRemoving elements:");
		System.out.println(ht.remove(11));
		System.out.println(ht.remove(4));
		System.out.println(ht.remove(1));
		System.out.println(ht.remove(21));
		System.out.println(ht.remove(2));
		System.out.println(ht.remove(12));
		System.out.println(ht.remove(5));
		System.out.println(ht.remove(3));
		ht.display();
		System.out.println("HashTable Size = "+ht.size());
		System.out.println("Is HashTable empty? = "+ht.isEmpty());
	}
}
