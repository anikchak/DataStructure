package redblacktree;

public class RBTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RBTreeOperation op  = new RBTreeOperation();
		op.insertNode(100);
		op.insertNode(120);
		op.insertNode(110);
		op.insertNode(90);
		op.insertNode(105);
		op.insertNode(80);
		op.insertNode(140);
		op.insertNode(130);
		op.insertNode(125);
		op.insertNode(115);
		op.insertNode(121);
		op.traverseTree();
	}

}
