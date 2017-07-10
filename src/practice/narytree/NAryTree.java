package practice.narytree;

import java.util.LinkedList;
import java.util.Queue;

public class NAryTree {
	
	class NaryNode{
		int data;
		NaryNode children[] = null;
		public NaryNode(int d) {
			this.data = d;
			children = new NaryNode[nAry];
		}
	}

	int nAry = 0;
	public NAryTree(int n) {
		nAry = n;
	}
	NaryNode root = null;
	public void insertNode(int d){
		NaryNode newNode = new NaryNode(d);
		if(root == null){
			root = newNode;
			return;
		}else
		{
			Queue<NaryNode> q = new LinkedList<NaryNode>();
			q.add(root);
			while(!q.isEmpty()){
				NaryNode currNode = q.poll();
				for(int i=0;i<currNode.children.length;i++){
					if(currNode.children[i]==null){
						currNode.children[i] = newNode;
						return;
					}else{
						q.add(currNode.children[i]);
					}
				}
			}
		}
	}
	public void traverseLevelOrder(NaryNode node){
		Queue<NaryNode> q = new LinkedList<NaryNode>();
		q.add(node);
		q.add(null);
		while(!q.isEmpty()){
			NaryNode nn = q.poll();
			if(nn==null){
				if(q.isEmpty()) break;
				q.add(null);
				System.out.println();
			}else{
				System.out.print(nn.data+" ");
				for(int i=0;i<nn.children.length;i++){
					if(nn.children[i]!=null){
						q.add(nn.children[i]);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		NAryTree n = new NAryTree(3);
	    n.insertNode(1);
	    n.insertNode(2);
	    n.insertNode(3);
	    n.insertNode(4);
	    n.insertNode(5);
	    n.insertNode(6);
	    n.insertNode(7);
	    n.insertNode(8);
	    n.insertNode(9);
	    n.insertNode(10);
	    n.insertNode(11);
	    n.insertNode(12);
	    n.insertNode(13);
	    n.insertNode(14);
	    n.traverseLevelOrder(n.root);
//	    NAryTree n1 = new NAryTree(3);
//	    NaryNode nn = n1.new  NaryNode(1);
//	    nn.children[0] = n1.new  NaryNode(2);
//	    nn.children[1] = n1.new  NaryNode(3);
//	    nn.children[0].children[0] = n1.new  NaryNode(4);
//	    nn.children[0].children[1] = n1.new  NaryNode(5);
//	    nn.children[0].children[2] = n1.new  NaryNode(6);
//	    nn.children[1].children[0] = n1.new  NaryNode(7);
//	    nn.children[1].children[1] = n1.new  NaryNode(8);
//	    nn.children[1].children[2] = n1.new  NaryNode(9);
//	    n1.traverseLevelOrder(nn);
	}

}
