package stringstorage;

public class SuffixTree {

	public class SuffixNode {
		SuffixNode child[] = new SuffixNode[256]; // There could be 256
													// characters corresponding
													// to child node
		int start;
		End end;
		int index = 0;
		SuffixNode suffixLink = null;

		public SuffixNode(int s, End e) {
			// SuffixNode node = new SuffixNode();
			this.start = s;
			this.end = e;
			// return node;
		}
	}

	public class End {
		int end;

		End(int e) {
			this.end = e;
		}
	}

	public class Active {
		SuffixNode activeNode;
		int activeEdge = -1;
		int activeLength = 0;
	}
	public class EndOfPathException extends Exception{
	}
	
	char input[];
	SuffixNode root;
	Active active = new Active();
	End e;
	int remainingSuffixCount = 0;

	public void suffixTree(String word) {
		word = word + "$";
		input = word.toCharArray();

		// build suffix tree
		buildSuffixTree(input);
	}

	public void buildSuffixTree(char[] input) {
		// Creating root node
		root = new SuffixNode(1, new End(0));
		root.index = -1;
		active.activeNode = root;
		e = new End(-1);

		// Starting phase-wise execution
		for (int i = 0; i < input.length; i++) {
			startPhase(i);
		}
	}

	// Starting phase execution
	public void startPhase(int i) {
		// int remainingSuffixCount = 0;
		// Increment end and rem initially in each phase
		e.end++;
		remainingSuffixCount++;
		SuffixNode lastCreatedSuffixNode = null;
		SuffixNode sn = selectedNodeAtIndex(i);
		// System.out.println("inputVal="+input[i]+" start="+sn.start+" end="+sn.end.end);
		// System.out.println("inputVal="+input[i]);
		 System.out.println("Before= rem="+remainingSuffixCount+" AL="+active.activeLength+" val="+input[i]+" i="+i+" AE="+active.activeEdge+" start="+active.activeNode.start+" end="+active.activeNode.end.end);
		while (remainingSuffixCount > 0) {

			if (active.activeLength == 0) {
				// Check if there is a path from root to the char at index. If
				// not then create a new path else its a showstopper
				if (selectedNodeAtIndex(i) == null) {
					// System.out.println("Creating new node for="+input[i]);
					SuffixNode node = new SuffixNode(i, e);
					// node.createNode(i, e);
					active.activeNode.child[input[i]] = node;
					remainingSuffixCount--;
				} else {
					active.activeLength++;
					active.activeEdge = selectedNodeAtIndex(i).start;
					break;
				}
			} else { // If active length is not 0, the we are traversing in the
						// tree
						// check if nextchar is same as index. If true - then
						// show stopper; increment activelength. If false,
						// create a new internal node
				try{
				char ch = nextChar(i);
				System.out.println("nextChar ="+ch+"--");
				
				if (ch == input[i]) {
					active.activeLength++;
					break;
				} else {
					// choosing the location to create new internal node
					SuffixNode node = selectNodeAtActiveEdge();
					int oldStart = node.start;
					node.start = node.start + active.activeLength;
					// Creating a new internal node
					SuffixNode newInternalNode = new SuffixNode(oldStart,
							new End(oldStart + active.activeLength - 1));
					newInternalNode.index = -1;
					// newInternalNode.createNode(oldStart, new
					// End(oldStart+active.activeLength-1));
					// Creating new leaf
					SuffixNode newLeaf = new SuffixNode(i, e);
					// newLeaf.createNode(i, e);

					newInternalNode.child[input[newInternalNode.start
							+ active.activeLength]] = node;
					newInternalNode.child[input[i]] = newLeaf;
					active.activeNode.child[input[newInternalNode.start]] = newInternalNode;
					// Check if a new internal node was created in the last
					// iteration
					if (lastCreatedSuffixNode != null) {
						lastCreatedSuffixNode.suffixLink = newInternalNode;
					}
					lastCreatedSuffixNode = newInternalNode;
					newInternalNode.suffixLink = root;

					// Check if activeNode is root or not
					// System.out.println("AN==root?"+(active.activeNode ==
					// root));
					if (active.activeNode == root) {
						active.activeEdge++;
						active.activeLength--;
					} else {
						active.activeNode = active.activeNode.suffixLink;
					}
					 System.out.println("ch = "+ch+"Node start-end"+node.start+"-"+node.end.end);
					 System.out.println("ch = "+ch+"Internal Node start-end"+newInternalNode.start+"-"+newInternalNode.end.end);
					 System.out.println("ch = "+ch+"leaf Node start-end"+newLeaf.start+"-"+newLeaf.end.end);
					remainingSuffixCount--;
				}
			}catch(EndOfPathException exp){
				//This catch handles the scenario where nextchar is not present on any of the edges from an already existing internal node. 
				//Hence only a new leaf is required to be created from this internal node
				System.out.println("Inside Catch");
				SuffixNode n = selectNodeAtActiveEdge();
				//Creating leafNode
				n.child[input[i]] = new SuffixNode(i,e);
				
				if (lastCreatedSuffixNode != null) {
					lastCreatedSuffixNode.suffixLink = n;
                }
				
				if (active.activeNode == root) {
					active.activeEdge++;
					active.activeLength--;
				} else {
					active.activeNode = active.activeNode.suffixLink;
				}
				remainingSuffixCount--;
			}

			 System.out.println("After= rem="+remainingSuffixCount+" AL="+active.activeLength+" val="+input[i]+" i="+i+" AE="+active.activeEdge+" start="+active.activeNode.start+" end="+active.activeNode.end.end);
		}
	  }
	}

	public SuffixNode selectedNodeAtIndex(int i) {
		return active.activeNode.child[input[i]];
	}

	public SuffixNode selectNodeAtActiveEdge() {
		return active.activeNode.child[input[active.activeEdge]];
	}

	public char nextChar(int i) throws EndOfPathException{
		SuffixNode n = selectNodeAtActiveEdge();
		/*
		 * if(n==null){ n = selectedNodeAtIndex(i); }
		 */
		int diff = n.end.end - n.start;
		// Checking if the active length is within the edge range
		if (diff >= active.activeLength) {
			return input[n.start + active.activeLength];
		} 
		
		else if (diff+1 == active.activeLength){
			System.out.println("i'm here"+input[i]);
			if(n.child[input[i]] != null){
                return input[i];
            }
		}else{
			active.activeNode = n;
			active.activeLength = active.activeLength - diff - 1;
			active.activeEdge = active.activeEdge + diff + 1;
			return nextChar(i);
		}
		
		throw new EndOfPathException();
	}

	public void dfsTraverseSuffixTree() {
		// Setting the index for suffixes
		dfsSetIndex(root,0);
		// Traverse the tree
		System.out.println("Suffixes: ");
		dfsTraverseSuffixTree(root);
	}

	
	public void dfsSetIndex(SuffixNode node, int wordCount) {
		if(node==null){
			return;
		}else if(node.index == -1){
			if(node.end.end<node.start){
				//This means its the root
				wordCount = 0;
				for(SuffixNode n: node.child){
					dfsSetIndex(n,wordCount);
				}
			}else{
				//This means its some internal node
				wordCount = wordCount+(node.end.end-node.start)+1;
				for(SuffixNode n: node.child){
					dfsSetIndex(n,wordCount);
				}
			}
		}else{
			node.index = input.length - (wordCount+(node.end.end-node.start)+1);
		}
	}

	public void dfsTraverseSuffixTree(SuffixNode n) {
		if (n == null) {
			return;
		} else {

			for (SuffixNode node : n.child) {
				dfsTraverseSuffixTree(node);
			}
			/*
			System.out.println();
			System.out.print("Start = " + n.start + " End=" + n.end.end
					+ " index=" + n.index);
			for (int i = n.start; i <= n.end.end; i++) {
				System.out.print(" " + input[i]);
			}
			
			*/
			// Display all the suffixes
			
			 if(n.index != -1){ 
				// System.out.println("index = "+n.index+" length="+input.length);
				 for(int i=n.index;i<input.length;i++){
					 System.out.print(input[i]); 
					 } 
				 System.out.println(); 
			 	 }
			 
		}
	}

	public static void main(String[] args) {
		SuffixTree st = new SuffixTree();
		st.suffixTree("mississippi");
		st.dfsTraverseSuffixTree();
	}

}
