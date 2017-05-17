package geekforgeeks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Nodes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int data;
	Nodes left;
	Nodes right;
	Nodes(int d){
		this.data = d;
	}
}
public class SerializeDeserialize {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SerializeDeserialize sd = new SerializeDeserialize();
		Nodes n = new Nodes(123);
		try{
			//Serialize Object
			FileOutputStream fos = new FileOutputStream("C:\\Users\\anikchak.ORADEV\\Desktop\\Serialization\\Doc.txt");
			ObjectOutputStream op = new ObjectOutputStream(fos);
			op.writeObject(n);
			op.flush();
			System.out.println("Success");
			op.close();
			//Deserialze Object
			FileInputStream fis = new FileInputStream("C:\\Users\\anikchak.ORADEV\\Desktop\\Serialization\\Doc.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Nodes readNode = (Nodes)ois.readObject();
			System.out.println("Value read = "+readNode.data);
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
