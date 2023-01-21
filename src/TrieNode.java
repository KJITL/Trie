									

// A " TrieNode " Class is a class to specify each nodes in "Trie" tree .
public class TrieNode<T extends Comparable<? super T>> {
	
	// variable for 'c' for character that stored in the node.
	public char c;
	//isWord a checker if we reach the end of the word 
	public boolean isWord;
	public char getC() {
		return c;
	}
	
	
	// constructors, accessors, mutators  //
	// and array Children is Children of this node basicly.
		public TrieNode[] Children;
		
		//to create a node ' constructor ' .
		public TrieNode( char c ){
			this.c = c;
			isWord = false;
			Children = new TrieNode[26];
		}
		
	public void setC(char c) {
		this.c = c;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public TrieNode[] getChildren() {
		return Children;
	}

	public void setChildren(TrieNode[] children) {
		Children = children;
	}
	
}
