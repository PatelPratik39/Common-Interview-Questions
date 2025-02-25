# Common-Interview-Questions

# 1. Majority of the elements — HASHING
    - Given an Integer array of size n, find all elements that appear more than [n/3] times.
    - nums[] = {1,3,2,5,1,3,1,5,1};   \\ 1
    - nums[] = {1,2};    \\1,2
        
# 2. Union of 2 Arrays - Hashing
    - means there will be 2 arrays and we need to combine it one witout repetation and provide the size of united array

# 3. Intersection of 2 arrays - HASHING
    - means there will be 2 arrays and we need to store common elements  and provide the size of united array
# Queue - 
    - A queue follows FIFO principle
    - increases space utilization efficiency by conecting both the eneds of an array
    - best approcch for some scheduling and streaming tasks .
    - Time complexity - O(1) constant that is great and space complexity is O(n)

# Binary Search Tree—(BST)
    - its a data structure that facilitates fast look ups, addition, and deletion of elements.
    -  it makes searching and sorting make super efficient,
    - Each Node in a BST has most two children, reffered to as a left child and right child.

    - The Left subtree of a node contains only nodes with keys less than the Node's key.
    - The Right subtree of the node contains only node with keys greater than the node's key.
    - BST does not allow any duplications.

* Time Complexity of a Binary Search tree
    *  Insert Operation :
    -  to insert a new node, compare the node value with the root. if the value is less than node, then move it to the left side 
    -  and if the value is greater than the node value, then move it to the right side. 
    -  Repeat this step until an appropriate null subtree is found and insert the node there

    *  Delete Operation:
    * there are three cases of deletion
                  - Leaf Node: Remove the node
                  - Node with One Child: Remove the node and replace it with its child
                  - Node with Two Child: Find the node's in order successor or in - order predecessor, swap the values with the node to be deleted and then remove the in-order successor / predecessor
    
    *    Search Operation : 
                - To search for a value, compare it with the root, if value matches, the search is successful.
                - if the value is less, continue searching in the left subtree
                - if the value is greater, continue searching in the right subtree.
                  - Time Complexity:
                    - Best case: O(log n)
                    - Average Case: O(log n)
                    - Worst Case: O(n) -> if a tree becomes linkedList or Unbalanced
        
    *  Traversal (Time Complexity for traversal for all operations — O(n)) :
        - In - order Traversal : Ascending Order like Left subtree -> Node -> Right Subtree
        - Pre - Order Traversal : In the Order form like : Node -> Left Subtree -> right Subtree
        - Post - Order Traversal: left subtree -> right subtree -> Node
     
*  Space Complexity for BST 
  - The space complexity id linear as each node requires constant space
    - O(n)

#   what is depth-First Search (DFS)?
    - Level order Traversal using queue means DFS - Depth First Search
-   Time Complexity is linear so O(n)

#  what is Breadth First Search (BFS)?
    - PreOrder,InORder, PostOrder are known as BreadthFirst Search
-   Time Complexity is linear so O(n)

# TRIE Data Structure
-   TRIE is a powerful data structure for storing and querying strings efficiently, especially when we are dealing with prefix-based searches.
-  store and retrieve keys in a dataset of a string manner.
- commonly used in applications that involve dictionary-like structures, such as autocomplete systems and spell checks
    *   Feature of TRIE Data structure
        - Prefix-based storage: a TRIE stores string in such a manner that common prefixes are shared easily that helps in
                                reducing time complexity when multiple strings share common prefixes.
        - Nodes and Edges: Each Node in TRIE represent a single character of a string.
                           Edge between nodes represent the connection between characters.
        - Root Node: In TRIE Data structure, Root Node remains empty which represents the beginning of all strings.
        - End of word Marker: Nodes often have end of word marker to indicate that end of valid word.
  
    *   Structure of TRIE DATA STRUCTURE
        - Node: Each Node in the TRIE has seperate map of an Array of child Nodes.
        - The Node includes a boolean flag to indicate if the node represents the end of a valid word
        - Edges: represents the pointer from one node to another character to the next line of the string.
    * Space Complexity: O(L) = O(n) because common prefixes are stored only once

# Sorting
  
*   Bubble Sort => 
  - Bubble sort repeatedly steps through the list
  - compares the adjacent elements and swaps them if they are in incorrect order.
  - This process continues until no more swaps are needed means sorted.
  - If an array is sorted, then Time complexity will be O(n) otherwise O(n^2).

* Selection Sort =>

* Insertion Sort =>
  - It takes an array which is divided by into a sorted array and unsorted array.
  - 0th index is considered as a sorted array, and the rest of the elements are considered as an unsorted array.
  - in Insertion sort, we are comparing each element from an unsorted array to a sorted array element.
  - if an element from unsorted array is smaller than a sorted array! push back the sorted array element
    and add an element which is smaller than elements from a sorted array.

# Recursion 
    
*   What is Recursion?? -> a function that calls itself that is recursion in java
  * f(f(x)) = f(x^2) => x = 2 => f(2^2) = f(4) => 4^2 = 16. so, f(f(x)) = 16, if x = 2
    * Tower Of Hanoi Algorithm
    

# Merge Sort
* Divide and Conquer approach

# Quick Sort
* Pivot and Partition Approach

# Graph Data Structure
* create a graph following Adjacency List

# Dijkstra's Algorithm to find the shortest Distance from source to destination.
*   TimeComplexity is O(E + E logV)
* Dijkstra's Algorithm: Finds shortest paths from a source to all nodes.

# BellmanFord's Algorithm to find the shortest Distance from source to destination.
* it allows negavtive distances
* does not allow negative weight
* time Complexity O(V*E)

# Minimum Spanning Tree (MST)
* Edges arw connected always and weighted
* no Cycles performed
 * Prim's Algorithm is the example of MST

# Prim's Algorithm
*   Prim's Algorithm: Finds the minimum spanning tree of a graph.
*   Time Complexity:  𝑂((𝑉+𝐸)log𝑉)
*   Space Complexity: 𝑂(𝑉+𝐸)