import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
//////////////////////////////////
						

// A 'Trie' class is the whole tree which contain nodes that represented as 'TrieNode'
public class Trie<T extends Comparable<? super T>, TrieNode> {
	
	// constructors, accessors, mutators  //
	// initialize the tree with rootA
	TrieNode root;
	private int size = 0 ; // useful for coming size method at the end .
	public Trie() {
		// assign the root with empty character 
		root = new TrieNode('\0');
    }
	
	// getter the rootA
	public TrieNode getRoot() {
		return root;
	}

	// setter for the root
	public void setRoot(TrieNode root) {
		this.root = root;
	}

		// A helper method to return the final node of the word which is the final character
		public TrieNode getNode(String word) {
			// start from the root to search for the last char 
			TrieNode current = root;
			// for each character in this word
			for(int i = 0 ; i < word.length() ;i++) {
				// create a temporary c char 
				char c = word.charAt(i);
				// the check method to get the index of the letter be subtract 'A' , to get a number from 0-25 ,
					if(current.Children[c-'A'] == null) { // if we found the index null and its empty ' not created yet
					return null;// return null , there is no word to get from this Trie
				}
					// else , continue to the next child  
					current = current.Children[c-'A'];
			}
			// after finish this loop , current will be at the last node character , therefore , we return it 
			return current;
			
		}
	
	
		
	/////////////////////////////////////////// 'A-CONTAINS' METHOD ////////////////////////////////
	
	
	// the check if the Trie contain 'word' string , using 'getNode helper method' 
	public boolean contains(String word) {
		// here it will return the last character node
		TrieNode Node = getNode(word);
		
		// here to check 'Node' node if its not null , and isWord true 
		return Node != null && Node.isWord;
		
	}
	


	/////////////////////////////////////////// 'B-isPrefix' METHOD ////////////////////////////////
	
	
	// to check if the trie contain 'prefix' string , using 'getNode helper method' 
	public boolean isPrefix(String prefix) {
		
		// getNode method go through each character, if its not null , means this method not face any null nodes ,means for sure its a prefix . 
		return getNode(prefix) != null;
	}
	
	
	/////////////////////////////////////////// 'C-INSERT' METHOD ////////////////////////////////
	
	// insert method 'c' 
	// * here also , increase size variable to use it in size method
	public void insert(String word) {
		
		// Initialize a current selector node to the beginning ' in root ' 
		TrieNode current = root;
		// iterate over each character to see if it is a children of the root
		for(int i = 0 ; i < word.length() ;i++) {//for character per character in this word
			// Initialize to 'c' to check if it a children of the current node 
			char c = word.charAt(i);
			// the check method to get the index of the letter be subtract 'A' , to get a number from 0-25 ,
			if(current.Children[c-'A'] == null) { // if we found the index null and its empty ' not created yet
				// we should create new node called 'c' on it
				current.Children[c-'A'] = new TrieNode(c);
				size++;// use it in size method
			}
			
			
			// move deeper to the child node to continue inserting the rest of the characters 
			current = current.Children[c-'A'];
			
		}
		// if we finish with all characters , the last character node is completed a word ,
		// therefore , we will set this node ' isWord ' boolean , to true
		current.isWord = true;
		
	}
	
	/////////////////////////////////////////// 'D-DELETE' METHOD ////////////////////////////////
	
	// helper method
	public int countChildren(TrieNode theNode) {
		int num = 0; // start from zero
		for(int i = 0 ; i < 26 ; i++) { // for each child which not null , increase num of children
			if(theNode.Children[i] != null) {
				num++;
			}
					
		}
		return num;// end = return .
		
	}
	
	// delete method , just adjust the last node character of the word to be ' isWord = false ' 
	public void delete(String word) {
		
		// check first if the word to deleted is in the tree
		if(contains(word)) {
			//int numOfDeletedNodes = 0;
			// start from the root to search for the last char 
			TrieNode current = root;
			// for each character in this word
			for(int i = 0 ; i< word.length() ;i++) {
				// create a temporary c char 
				char c = word.charAt(i);

				
				// start going to the deeper character , till reach the end
				
				current = current.Children[c-'A'];			
			}
			
			
			// after finish this loop , the current loop is at the end of the word ' last character ' 
			// therefore , we will change its boolean ' isWord , to false ' to says that it no longer a word 
			current.isWord = false ;
			
	
		}
		else {
			System.out.println("Word not found!");// if there is no such a word to be deleted from the Trie
		}
		
	}

	/////////////////////////////////////////// 'E-isEMPTY' METHOD ////////////////////////////////
		
	// to check if the Trie is empty or not
	public boolean isEmpty() {
	
	// iterate in all children of the root , if there are null , means its empty 
		for(int i = 0 ; i < 26 ; i++){// there is 26 characters to check
			// for each child of root , if there element not empty ' null ' , return false because thats mean its not empty
			 if(root.Children[i]!=null) {
				 return false;
			 }
		}
		// no 'non null ' element found , its clearly empty
		return true;
	
	
	}
	
	/////////////////////////////////////////// 'F-clear' METHOD ////////////////////////////////
		
	// clear trie method , is very similar to isEmpty() method  
	public void clear() {
	
	// iterate in all children of the root , and set them to null 
		for(int i = 0 ; i < 26 ; i++){// there is 26 characters to check
			// for each child , set it to null 
			root.Children[i]=null; 
		}
		size = 0;// set size to zero after clear
	}
	
	/////////////////////////////////////////// 'G-// constructors, accessory, mutators  //' METHODS ////////////////////////////////
	
	//* they are on the top of the class *//
	
	
	/////////////////////////////////////////// 'H-//  allWordsPrefix  //' METHOD ///////////////
	
	// an arraylist to get the words from the bellow method ,, However,This will be converted to a list , to be returned successfully as a String[].
	ArrayList<String> words = new ArrayList<String>();
	// a method to insert a prefix and return all words in trie with that entered prefix 
	public String[] AllWordsPrefix(String prefix) {
		
		// set the current note to the last prefix character node 
		TrieNode current = getNode(prefix);// ' getNode(String) is method created up somewhere , insert a string return last char node of it
		// could be a break for recursion  
		if(current == null) {
			return null;
		}
		// here to check if current is a word ' knowing by check the boolean of character 'isWord' is true .
		if(current.isWord) { // if true
			words.add(prefix); // add the word to the 'words arrayList '
		}
		// know , we need to iterate in every child of the current node , ' recursively ' 
		for(TrieNode child : current.Children) { // for each child in current children array
			if(child!=null) { // there is 26 Children I think , but here we will select child who have a chars , not null !! 
			// if its a char valid child , then , we should go deeper into it as recursion ' with a prefix + its char ' 
			AllWordsPrefix(prefix+child.c);
			}
		}
		
		return words.toArray(new String[words.size()]);
	}
	
	/////////////////////////////////////////// 'i-size' METHOD ////////////////////////////////
	
	// to return the number of nodes of the trie
	// here , I initialize a size variable in the top of the class 
	// and increment it with each new node created in the ' insert method ' 
	// Moreover , I decrement it in delete method , and make it zero in clear method
	
	
	public int size() {
		
		
		// create a temp. Trie
		Trie c = new Trie();
		for(int j =0; j < 26 ; j++) {
			if(root.Children[j]!= null) {
				String[] all = AllWordsPrefix(root.Children[j].c+"");
				for(String x : all) {
					c.insert(x);
				}
			}
		}
		return c.size;
	}

	
	
}

