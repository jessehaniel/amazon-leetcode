# Cheat Sheet

- Number of Islands: Connected nodes problem -> from the first node, set all connected nodes off. Then you will have only the root nodes.
- Partition Labels: anchor and j -> from an array containing the last position of every character, move the anchor everytime you reach the last position of a character.
- Two Sum: complement -> By brute force you can sum every pair of numbers and compare with the target, or by optimal solution storing every number in a map, then looking for the complement element in the map.
- Reorder Data in Log Files: Comparator -> define a custom sort engine, but avoiding the details of the algorithm (focus on sorting criteria).
- Median of Two Sorted Arrays: merge and sort the array, then take the median of it.
- LRU Cache -> simply overrides the LinkedHashMap which gives the get/put O(1), and then overrides the `removeEldestEntry` method with the condition `size() > capacity`.
- Minimum Difficulty of a Job Schedule: Let's use a function to represent our target value, say, F(i, j) means the minimum difficulty on i-th day who takes j-th work as its end.
`F(i, j) = MIN{ F(i - 1, k - 1) + MAX_DIFFICULTY(k, j) }, k from i to j`
- Longest Palindromic Substring: Expand Around Center.
- String to Integer (atoi): check overflows/underflows.
- Critical Connections in a Network: find the number of bridges in the graph. A bridge is essentially an edge whose removal would make the graph disconnected. This algorithm is known as the Tarjan's algorithm. -> An edge is a critical connection, if and only if it is not in a cycle.
- K Closest Points to Origin: sort and copy the k points. Brute Force -> Arrays.sort; or QuickSelect (The QuickSelect algorithm is essentially a partial application of one of the most common sorting methods: the QuickSort algorithm).
- Merge Two Sorted Lists:
- Top K Frequent Words:
- Most Common Word:
- Merge k Sorted Lists:
- Integer to Roman:
- Roman to Integer:
- Valid Parentheses:
- 
