import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

										
public class MainDrive {

	public static void main(String[] args) throws FileNotFoundException {
		
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		/////////////..*****  THE MAIN PROGRAM "" PROJECT INTERFACE "" ***/////////////////////////
		System.out.println();
		System.out.println("========================================================");
		System.out.println("=~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=");
		System.out.println("=~~~~~~~ - ~~~~~~~~~~~   =");
		System.out.println("=~~~~ CREATOR :- ~~~   =");
		System.out.println("=~~~~ COURSE : - ~~~~~~    =");
		System.out.println("=~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=");
		System.out.println("========================================================");
		System.out.println();
		// start with null Trie
		Trie theTrie = null;
		String end;// this variable usefull to know if the user want to continue or exit the program
		boolean TrieCreated = false;// to check if trie created , before go through rest of methods
		int option;// to go through each methods 
		do{    // looping till the user enter the right choice ' 1-7 ' and exit if he enters 7 
			// design the interface of the project " questions for user "
			System.out.println();
			System.out.println("########################################################");
			System.out.println("#******************************************************#");
			System.out.println("#~~~~~~~~#TRIE PROJECT: ENTER YOUR CHOICE?#~~~~~~~~~~~~#");
			System.out.println("#******************************************************#");
			System.out.println("########################################################"); 
			System.out.println("#                                                      #");
			System.out.println("#     1) Create an empty trie                          #");
			System.out.println("#     2) Create a trie with initial letters            #");
			System.out.println("#     3) Insert a word                                 #");
			System.out.println("#     4) Delete a word                                 #");
			System.out.println("#     5) List all words that begin with a prefix       #");
			System.out.println("#     6) Size of the trie                              #");
			System.out.println("#     7) End                                           #");
			System.out.println("#                                                      #");
			System.out.println("#******************************************************#");
			System.out.println("########################################################");
			System.out.println();
			
			// wait for the user choice
			Scanner scan = new Scanner(System.in);
			while(!scan.hasNextInt()) { // should has next integer typed , not String
			    scan.next(); // thats why will be asked till he enter integer !
			}
			option = scan.nextInt(); // option selected successfully
			  
			if(option <1 || option >7) { // if he entered wrong option
		System.out.println("You select wrong option , please select between (1,7) ");
			}
			if(option == 1 ) {// create an empty trie
				theTrie = new Trie(); // Initialized from constructor 
				TrieCreated = true; // to allow the user using other methods 
				System.out.println("\n===== An empty trie has been created successfuly ====");
			}
			
			if(option == 2 ) { // take a letter from the user and insert the premetutation of it in the Trie tree 
				//Take the input
				theTrie = new Trie();// Initialized from constructor 
				TrieCreated = true;// to allow the user using other methods
				System.out.println("======================================================");
				System.out.print("**~Enter your list of letters> ");
				
				Scanner string = new Scanner(System.in);
				String word = string.next();
				word = word.toUpperCase();// to avoid lower case error
				//Store all letter in arraylist called ' letters ' 
				ArrayList<Character> letters = new ArrayList<Character>();
				for(int i = 0 ; i < word.length() ;i++) {
					letters.add(word.charAt(i));
				}
				
				
				
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				
				// ## store dictionary.txt ' given in BB file ' in file, and scan it into dictTxt  ## //
				
				File file = new File(args[0]); // To run this , *(1) I download the txt file and name it dictionary ,then store it in project file ' beside src ' , (2) change run configration and name it ' dictionary.txt ' 
				Scanner dictTxt = new Scanner(file);
				
				// create a dictionaryList of array list to add line line of scanned ' dictTxt variable 
				ArrayList<String> dictionaryList = new ArrayList<String>( );
				// till reach the end when there is no next line
				while(dictTxt.hasNextLine()) {
					// add line line from txt to dictionaryList arrayList
					dictionaryList.add(dictTxt.nextLine());
				}
				
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				
				// create a finalList that have a valid words consist of given ' lettersArrayList characters ' which are from user 
				ArrayList<String> finalList = new ArrayList<String>( );
				
				//iterate for each word in dictionary to find a valid word that have a letters array characters 
				for(int i = 0 ; i < dictionaryList.size(); i++) {
					// Temporary list to remove each letter after check it ' useful to avoid repeated letter cases ' 
					ArrayList<Character> tempList = new ArrayList<>(letters);
					// a checker if the word still not have any outer character
					boolean acceptedWord = true;
					// check if the word we are in is less than or equal the number of entered letters ' for effience reasons'
					if(dictionaryList.get(i).length() <= letters.size()) {
						
						// for each character of this word , check if its in the ' letters array list ' 
						for(int c = 0 ; c < dictionaryList.get(i).length() ; c++) {
							
							// check each letter if it in ' tempList which is letters '  array list , if not , put it false and get out of this word loop 
							if(!tempList.contains(dictionaryList.get(i).charAt(c))) {
								acceptedWord = false;
								break;
							}
							// here to remove element from the temporary , to make sure that there will be accurate repetition of characters
							tempList.remove(new Character(dictionaryList.get(i).charAt(c)));
							
						}
						// if the word contain of all user letter or less , insert to final list
						if(acceptedWord) {
							finalList.add(dictionaryList.get(i));
						}
					}
			
				}

				
				// inserting all this finalList words into the trie
				for(int i = 0 ; i < finalList.size(); i++) {
					//System.out.println(finalList.get(i)); ' JUST TO SHOW THE INSERTED LIST . NO NEED ' 
					theTrie.insert(finalList.get(i));
	
				}
				
				System.out.printf("\n======= The program has created a Trie with %s permutation successfully. =========",(word));
				System.out.println("\n=================================================================================");
				
			}
			
			if(option == 3 ) { // insert the word
				if(TrieCreated) {
					// make the user to write the word that to be inserted in the trie
					System.out.println("======================================================");
					System.out.print("**~ Write the word that you want to insert: ");
					Scanner insertWord = new Scanner(System.in);
					String s = insertWord.next();
					// insert it using ' insert ' method 
					theTrie.insert(s);
					
					System.out.printf("\n======= '%s' word has been inserted successfuly =========",(s));
					System.out.println("======================================================");
				}
				else {
					System.out.println("=== There is no any trie created yet.");
				}
				
			}
			
			if(option == 4 ) { // to delete the word 
				if(TrieCreated) {
					// make the user to write the word that to be deleted in the trie
					System.out.println("======================================================");
					System.out.print("**~ Write the word that you want to delete it =: ");
					Scanner deleteWord = new Scanner(System.in);
					String s = deleteWord.next();
					// delete it using ' delete ' method 
					theTrie.delete(s);
					System.out.printf("\n======= '%s' word has been deleted successfully =========",(s));
					System.out.println("======================================================");
				}
				else {
					System.out.println("=== There is no any trie created yet.");
				}
				
				
				
			}
			
			if(option == 5 ) { // list all words with the prefix 
				// make user to write the prefix
				if(TrieCreated) {
					System.out.println("======================================================");
					 System.out.print("**~ Write a prefix to see all words in Trie begin with it: ");
					 Scanner prefixWord = new Scanner(System.in); 
					 String s = prefixWord.next(); //
					 if(theTrie.isPrefix(s)) {
						//print all the words that it begin with user prefix String[] list =
						 String[] list = theTrie.AllWordsPrefix(s); 
						 for(int i = 0 ; i < list.length ; i++) { // print
						 //it with index 
							 	System.out.print(i+1); 
							 	System.out.print(": ");
							 	System.out.println(list[i]);// word by word in the list // profic jx }
						
						 
						 } 
						 System.out.printf("\n#======= Search with '%s' prefix is done =========#",(s));
						 
					 }
					 else {
						 System.out.printf("No word found with %s prefix.",(s));
					 }
					 
					 System.out.println("======================================================");
				}
				else {
					System.out.println("=== There is no any trie created yet.");
				}
				
				
				
			}
			
			if(option == 6 ) { // print the size of the trie
				if(TrieCreated) {
					System.out.println("======================================================");
					  System.out.print("=**The size of Trie is:");
					System.out.println(theTrie.size());
					System.out.println("======================================================");
				}
				else {
					System.out.println("=== There is no any trie created yet.");
				}
				
			}
			
			if(option == 7 ) {
				
				break;
			}
			System.out.println("\n");
			System.out.println("~~");
			System.out.println("*Press and enter any key to return back to main menu.");
			System.out.println("*Else,Type '0' to exit the program. ");
			System.out.println();
			
			Scanner ex = new Scanner(System.in);
			end = ex.next();
			}while (option != 7 && end.compareTo("0")!=0); // if user not press 7 or 0 , exist numbers , then , the program will continue 
			
			System.out.println();
			System.out.println("======================================================");
			System.out.println("=  ~~~ PROGRAM ENDS SUCCESSFULY ~~~~                 =");
			System.out.println("======================================================");
			System.out.println();
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
	} // end of main class 
				


}

