# Trie

## Project Title: Trie Data Structure Implementation in Java
This project is an implementation of a Trie data structure in Java, specifically designed to work with uppercase alphabetical letters. A Trie is a tree-like data structure that allows for efficient lookup of words in a dictionary. The project includes two Java classes: TrieNode and Trie that work together to implement the Trie data structure.

### Features
The implemented Trie data structure supports the following operations:

contains(String s): Returns true if the word 's' is contained in the Trie.<br />
isPrefix(String p): Returns true if 'p' is a prefix of any word in the Trie.<br />
insert(String s): Inserts the word 's' in the Trie.<br />
delete(String s): Deletes 's' from the Trie.<br />
isEmpty(): Returns true if the Trie is empty.<br />
clear(): Clears all the words from the Trie.<br />
Constructors, accessors, and mutators as needed.<br />
allWordsPrefix(String p): Returns an array of strings containing all words whose prefix is 'p'.<br />
size(): Returns the number of nodes in the Trie.<br />

Additionally, the project includes a menu-driven interface that allows users to interact with the Trie data structure through the following options:<br />
Create an empty Trie: Creates an empty Trie with no words.<br />
Create a Trie with initial letters: Prompts the user for an initial list of letters, generates all permutations of these letters, and inserts valid words in the Trie.<br />
Insert a word: Allows the user to manually insert a word into the Trie.<br />
Delete a word: Allows the user to manually delete a word from the Trie.<br />
List all words that begin with a prefix: Allows the user to enter a prefix and displays all words in the Trie that have that prefix.<br />
Size of the Trie: Displays the total number of nodes in the Trie.<br />
End: Terminates the program.<br />

### Screenshots
 

### Usage
To use the Trie data structure in this project, follow these steps:

Compile and run the Java program.<br />
Choose the desired operation from the menu options.<br />
Follow the prompts to enter input or perform actions on the Trie.<br />
View the output and results of the operations.<br />
Repeat steps 2-4 until the desired operations are completed.<br />
Terminate the program by selecting the 'End' option from the menu.<br />
###Output Screenshots<br />
The project requires including output screenshots of the program's execution. These screenshots should showcase the different operations performed on the Trie, such as inserting words, searching for prefixes, deleting words, and displaying the size of the Trie.<br />

### Dictionary File
A dictionary file is included with the project, which is used to validate the words inserted into the Trie initially from the user's input list of letters.<br />


### Conclusion
This project implements a Trie data structure in Java, providing efficient lookup of words in a dictionary. The program allows for various operations to be performed on the Trie, such as inserting, deleting, and searching for words and prefixes. The project also includes a menu-driven interface for ease of use.<br />
