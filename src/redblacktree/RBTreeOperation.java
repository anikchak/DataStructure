package redblacktree;

public class RBTreeOperation {
	
	private RBTreeStrc rootNode = null;
	private static final String RED = "RED";
	private static final String BLACK = "BLACK";
	
	public void insertNode(int value){
		rootNode = insertNodeHelper(rootNode,null,value);
	}
	
	public RBTreeStrc insertNodeHelper(RBTreeStrc current, RBTreeStrc parent, int data){
		if(current == null){
			if(parent == null){//RootNode creation
				current = new RBTreeStrc(data);
				current.setColor(BLACK);
			}else{
				current = new RBTreeStrc(data);
				current.setColor(RED);
				current.setParentNode(parent);
			}
		}else{
			boolean isLeft = true;
			if(data<current.getData()){
				RBTreeStrc left = insertNodeHelper(current.getLeftNode(), current, data);
				System.out.println("Left = "+left.getData()+" current="+current.getData());
				if(left == current.getParentNode()){
					return left;
				}
				System.out.println("For current = "+current.getData()+" parent = "+current.getParentNode());
				current.setLeftNode(left);
				isLeft = true;
			}else if(data>current.getData()){
				RBTreeStrc right = insertNodeHelper(current.getRightNode(), current, data);
				if(right == current.getParentNode()){
					return right;
				}
				current.setRightNode(right);
				isLeft = false;
			}
			RBTreeStrc sibbling  = null;
			
			if(isLeft){
				if(current.getColor()==RED && current.getLeftNode().getColor() == RED){
					System.out.println("Left:RED-RED Conflict hit at = "+current.getData());
					if(current.getData() < current.getParentNode().getData()){
						sibbling = current.getParentNode().getRightNode();
					}else{
						sibbling = current.getParentNode().getLeftNode();
					}
					if(sibbling == null || (sibbling!=null && sibbling.getColor()==BLACK)){
						System.out.println("Left insertion - Rotation Needed");
						if(current.getParentNode().getData()>current.getData()){
							System.out.println("Single Right Rotation needed");
							rightRotate(current, true);
							System.out.println("After Right Rotation...current = "+current.getData());
						}else{
							System.out.println("Double Rotation: Left Rotate");
							rightRotate(current.getLeftNode(), false);
							System.out.println("current1="+current.getData());
							current = current.getParentNode();
							leftRotate(current, true);
						}
					}else if(sibbling != null && sibbling.getColor() == RED){
						sibbling.setColor(BLACK);
						current.setColor(BLACK);
						RBTreeStrc parentNode = current.getParentNode();
						if(parentNode != null && parentNode.getParentNode() != null){
							String grandPColor = parentNode.getColor();
							parentNode.setColor((grandPColor == BLACK ? RED:BLACK));
						}
					}
					}
			}else {
				if(current.getColor()==RED && current.getRightNode().getColor() == RED){
					System.out.println("Right:RED-RED COnflict hit at = "+current.getData());
					if(current.getData() < current.getParentNode().getData()){
						sibbling = current.getParentNode().getRightNode();
					}else{
						sibbling = current.getParentNode().getLeftNode();
					}
					if(sibbling == null || (sibbling!=null && sibbling.getColor()==BLACK)){
						System.out.println("Right insertion - Rotation Needed");
						if(current.getParentNode().getData()>current.getData()){
							System.out.println("Double Rotation: Right Rotate");
							leftRotate(current.getRightNode(), false);
							System.out.println("current2="+current.getParentNode().getData());
							current = current.getParentNode();
							rightRotate(current, true);
						}else{
							System.out.println("Single left rotation needed");
							leftRotate(current, true);
							System.out.println("After Left Rotation...current = "+current.getData());
						}
					}else if(sibbling != null && sibbling.getColor() == RED){
						sibbling.setColor(BLACK);
						current.setColor(BLACK);
						RBTreeStrc parentNode = current.getParentNode();
						if(parentNode != null && parentNode.getParentNode() != null){
							String grandPColor = parentNode.getColor();
							parentNode.setColor((grandPColor == BLACK ? RED:BLACK));
						}
					}
				}
			}
		}
		return current;
	}
	
	public void rightRotate(RBTreeStrc node,boolean iscolor){
		System.out.println("Right Rotate Hit="+node.getData()+node.getColor());
		RBTreeStrc temp = node.getParentNode();
		temp.setLeftNode(node.getRightNode());
		node.setParentNode(temp.getParentNode());
		temp.setParentNode(node);
		node.setRightNode(temp);
		if(iscolor){
			node.setColor(BLACK);
			String pColor = BLACK.equalsIgnoreCase(temp.getColor())?RED:BLACK; 
			temp.setColor(pColor);
		}
	}
	
	public void leftRotate(RBTreeStrc node, boolean isColor){
		System.out.println("Left Rotate Hit="+node.getData()+node.getColor());
		RBTreeStrc temp = node.getParentNode();
		temp.setRightNode(node.getLeftNode());
		node.setParentNode(temp.getParentNode());
		temp.setParentNode(node);
		node.setLeftNode(temp);
		if(isColor){
			node.setColor(BLACK);
			String pColor = BLACK.equalsIgnoreCase(temp.getColor())?RED:BLACK; 
			temp.setColor(pColor);
		}
	}
	
	public void traverseTree(){
		System.out.println("Starting traversal from rootnode with value = "+rootNode.getData());
		System.out.println(rootNode.getLeftNode().getData());
		System.out.println(rootNode.getRightNode().getData());
		traverseTreeHelper(rootNode);
	}
	public void traverseTreeHelper(RBTreeStrc node){
		if(node==null){
			return;
		}else{
		traverseTreeHelper(node.getLeftNode());
		System.out.print(node.getData()+"["+node.getColor()+"] ");
		traverseTreeHelper(node.getRightNode());
		}
	}
}
