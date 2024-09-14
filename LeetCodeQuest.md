<details>
<summary><b>2419. Longest Subarray With Maximum Bitwise AND</b></summary>
</details>

<details>
<summary><b>1. Two Sum</b></summary>

if a=3 c=9 a+b=c

3+b=9

b= 9–3=6

then b=6

We will follow the above logic to solve the problem. We will add the elements into Map and then check the target element by substracting with the keys. if the key found then return the array with indexes.
```java
public static int[] twoSum(int[] nums, int target) {

  Map<Integer, Integer> map = new HashMap<Integer, Integer>();

  for (int i = 0; i < nums.length; i++) {

   int req = target - nums[i];

   if (map.containsKey(req)) {

    int arr[] = { map.get(req), i };
    return arr;

   }

   map.put(nums[i], i);

  }

  return null;

 }
 ```
</details>

<details>
<summary><b>2. Add Two Numbers</b></summary>
</details>

<details>
<summary><b>3. Longest Substring Without Repeating Characters</b></summary>
```java
   public static int lengthOfLongestSubstring(String s) {

  int start = 0;
  int end = 0;
  int maxLength = 0;
  List<Character> list = new ArrayList<Character>();

  while (end < s.length()) {

   if (!list.contains(s.charAt(end))) {

    list.add(s.charAt(end));
    end++;
    maxLength = Math.max(maxLength, list.size());

   } else {
    list.remove(Character.valueOf(s.charAt(start)));
    start++;
   }

  }
  return maxLength;
 }
 ```
</details>

<details>
<summary><b>4. Median of Two Sorted Arrays</b></summary>
```java
public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

  int n1 = nums1.length;
  int n2 = nums2.length;
  int merge[] = new int[n1 + n2];

  int i = 0, j = 0, k = 0;

  while (i < n1 && j < n2) {

   if (nums1[i] <= nums2[j]) {
    merge[k] = nums1[i];
    i++;
   } else {
    merge[k] = nums2[j];
    j++;
   }

   k++;

  }

  while (i < n1) {
   merge[k] = nums1[i];
   i++;
   k++;
  }

  while (j < n2) {
   merge[k] = nums2[j];
   j++;
   k++;
  }

  int len = merge.length;

  if (len % 2 == 0) {

   return (merge[len / 2] + merge[len / 2 - 1]) / 2.0;

  } else {
   return merge[len / 2];
  }

 }
```
</details>

<details>
<summary><b>5. Longest Palindromic Substring</b></summary>
</details>

<details>
<summary><b>6. Zigzag Conversion</b></summary>
</details>

<details>
<summary><b>7. Reverse Integer</b></summary>
```java
  public static int reverse(int x) {
  int rev = 0;
  while (x != 0) {

   int digit = x % 10;
   if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
    return 0;
   }

   rev = (rev * 10) + digit;

   x = x / 10;

  }

  return rev;

 }
 ```
</details>

<details>
<summary><b>8. String to Integer (atoi)</b></summary>
</details>

<details>
<summary><b>9. Palindrome Number</b></summary>
```java
 public static boolean isPalindrome(int s) {

  int temp = s;
  int rev = 0;
  while (s > 0) {

   int digit = s % 10;
   rev = (rev * 10) + digit;
   s = s / 10;

  }
 
  if (rev == temp) {
   return true;
  }

  return false;
 }
```
</details>

<details>
<summary><b>10. Regular Expression Matching</b></summary>
</details>

<details>
<summary><b>11. Container With Most Water</b></summary>
</details>

<details>
<summary><b>12. Integer to Roman</b></summary>
</details>

<details>
<summary><b>13. Roman to Integer</b></summary>
</details>

<details>
<summary><b>14. Longest Common Prefix</b></summary>
```java
public static String longestCommonPrefix(String[] s) {

  Arrays.sort(s);

  String s1 = s[0];
  String s2 = s[s.length - 1];
  int i = 0;

  while (i < s1.length()) {

   if (s1.charAt(i) == s2.charAt(i)) {

    i++;

   } else {
    break;
   }

  }

  return i == 0 ? "" : s1.substring(0, i);

 }
 ```
</details>

<details>
<summary><b>17. Letter Combinations of a Phone Number</b></summary>
</details>

<details>
<summary><b>19. Remove Nth Node From End of List</b></summary>
</details>

<details>
<summary><b>20. Valid Parentheses</b></summary>
</details>

<details>
<summary><b>21. Merge Two Sorted Lists</b></summary>
</details>

<details>
<summary><b>22. Generate Parentheses</b></summary>
</details>

<details>
<summary><b>23. Merge k Sorted Lists</b></summary>
</details>

<details>
<summary><b>24. Swap Nodes in Pairs</b></summary>
</details>

<details>
<summary><b>25. Reverse Nodes in k-Group</b></summary>
</details>

<details>
<summary><b>26. Remove Duplicates from Sorted Array</b></summary>
</details>

<details>
<summary><b>27. Remove Element</b></summary>
```java
public int removeElement(int[] nums, int val) {

  int count = 0;

  for (int i = 0; i < nums.length; i++) {

   if (nums[i] != val) {
    nums[count] = nums[i];
    count++;
   }

  }

  return count;
 }
```
</details>

<details>
<summary><b>28. Find the Index of the First Occurrence in a String</b></summary>
```java
public static int find(String haystack, String needle) {

  for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

   if (needle.charAt(0) == haystack.charAt(i)) {

    if (haystack.substring(i, needle.length() + i).equals(needle)) {
     return i;

    }

   }

  }

  return -1;

 }
 ```
</details>

<details>
<summary><b>29. Divide Two Integers</b></summary>
</details>

<details>
<summary><b>30. Substring with Concatenation of All Words</b></summary>
</details>

<details>
<summary><b>31. Next Permutation</b></summary>
</details>

<details>
<summary><b>32. Longest Valid Parentheses</b></summary>
</details>

<details>
<summary><b>33. Search in Rotated Sorted Array</b></summary>
</details>

<details>
<summary><b>34. Find First and Last Position of Element in Sorted Array</b></summary>
```java
public static int[] searchRange(int[] nums, int target) {

  int[] arr = new int[2];
  arr[0] = -1;
  arr[1] = -1;

  for (int i = 0; i < nums.length; i++) {

   if (nums[i] == target) {
    if (arr[0] == -1) {
     arr[0] = i;
    }

    arr[1] = i;
   }

  }

  return arr;

 }
```
</details>

<details>
<summary><b>35. Search Insert Position</b></summary>
</details>

<details>
<summary><b>36. Valid Sudoku</b></summary>
</details>

<details>
<summary><b>37. Sudoku Solver</b></summary>
</details>

<details>
<summary><b>38. Count and Say</b></summary>
</details>

<details>
<summary><b>39. Combination Sum</b></summary>
</details>

<details>
<summary><b>40. Combination Sum II</b></summary>
</details>

<details>
<summary><b>41. First Missing Positive</b></summary>
</details>

<details>
<summary><b>42. Trapping Rain Water</b></summary>
</details>

<details>
<summary><b>43. Multiply Strings</b></summary>
</details>

<details>
<summary><b>44. Wildcard Matching</b></summary>
</details>

<details>
<summary><b>45. Jump Game II</b></summary>
</details>

<details>
<summary><b>46. Permutations</b></summary>
</details>

<details>
<summary><b>47. Permutations II</b></summary>
</details>

<details>
<summary><b>48. Rotate Image</b></summary>
</details>

<details>
<summary><b>49. Group Anagrams</b></summary>
</details>

<details>
<summary><b>50. Pow(x, n)</b></summary>
</details>

<details>
<summary><b>51. N-Queens</b></summary>
</details>

<details>
<summary><b>52. N-Queens II</b></summary>
</details>

<details>
<summary><b>53. Maximum Subarray</b></summary>
</details>

<details>
<summary><b>54. Spiral Matrix</b></summary>
</details>

<details>
<summary><b>55. Jump Game</b></summary>
</details>

<details>
<summary><b>56. Merge Intervals</b></summary>
</details>

<details>
<summary><b>57. Insert Interval</b></summary>
</details>

<details>
<summary><b>58. Length of Last Word</b></summary>
```java
  public static  int lengthOfLastWord(String s) {

  String[] words = s.trim().split(" ");

  return words[words.length - 1].length();

 }
```
</details>

<details>
<summary><b>59. Spiral Matrix II</b></summary>
</details>

<details>
<summary><b>60. Permutation Sequence</b></summary>
</details>

<details>
<summary><b>61. Rotate List</b></summary>
</details>

<details>
<summary><b>62. Unique Paths</b></summary>
</details>

<details>
<summary><b>63. Unique Paths II</b></summary>
</details>

<details>
<summary><b>64. Minimum Path Sum</b></summary>
</details>

<details>
<summary><b>65. Valid Number</b></summary>
</details>

<details>
<summary><b>66. Plus One</b></summary>
</details>

<details>
<summary><b>67. Add Binary</b></summary>
</details>

<details>
<summary><b>68. Text Justification</b></summary>
</details>

<details>
<summary><b>69. Sqrt(x)</b></summary>
</details>

<details>
<summary><b>70. Climbing Stairs</b></summary>
</details>

<details>
<summary><b>71. Simplify Path</b></summary>
</details>

<details>
<summary><b>72. Edit Distance</b></summary>
</details>

<details>
<summary><b>73. Set Matrix Zeroes</b></summary>
</details>

<details>
<summary><b>74. Search a</b></summary>
</details>

<details>
<summary><b>75. Sort Colors</b></summary>
</details>

<details>
<summary><b>76. Minimum Window Substring</b></summary>
</details>

<details>
<summary><b>77. Combinations</b></summary>
</details>

<details>
<summary><b>78. Subsets</b></summary>
</details>

<details>
<summary><b>79. Word Search</b></summary>
</details>

<details>
<summary><b>80. Remove Duplicates from Sorted Array II</b></summary>
</details>

<details>
<summary><b>81. Search in Rotated Sorted Array II</b></summary>
</details>

<details>
<summary><b>82. Remove Duplicates from Sorted List II</b></summary>
</details>

<details>
<summary><b>83. Remove Duplicates from Sorted List</b></summary>
</details>

<details>
<summary><b>84. Largest Rectangle in Histogram</b></summary>
</details>

<details>
<summary><b>85. Maximal Rectangle</b></summary>
</details>

<details>
<summary><b>86. Partition List</b></summary>
</details>

<details>
<summary><b>87. Scramble String</b></summary>
</details>

<details>
<summary><b>88. Merge Sorted Array</b></summary>
</details>

<details>
<summary><b>89. Gray Code</b></summary>
</details>

<details>
<summary><b>90. Subsets II</b></summary>
</details>

<details>
<summary><b>91. Decode Ways</b></summary>
</details>

<details>
<summary><b>92. Reverse Linked List II</b></summary>
</details>

<details>
<summary><b>93. Restore IP Addresses</b></summary>
</details>

<details>
<summary><b>94. Binary Tree Inorder Traversal</b></summary>
</details>

<details>
<summary><b>95. Unique Binary Search Trees II</b></summary>
</details>

<details>
<summary><b>96. Unique Binary Search Trees</b></summary>
</details>

<details>
<summary><b>97. Interleaving String</b></summary>
</details>

<details>
<summary><b>98. Validate Binary Search Tree</b></summary>
</details>

<details>
<summary><b>99. Recover Binary Search Tree</b></summary>
</details>

<details>
<summary><b>100. Same Tree</b></summary>
</details>

<details>
<summary><b>101. Symmetric Tree</b></summary>
</details>

<details>
<summary><b>102. Binary Tree Level Order Traversal</b></summary>
</details>

<details>
<summary><b>103. Binary Tree Zigzag Level Order Traversal</b></summary>
</details>

<details>
<summary><b>104. Maximum Depth of Binary Tree</b></summary>
</details>

<details>
<summary><b>105. Construct Binary Tree from Preorder and Inorder Traversal</b></summary>
</details>

<details>
<summary><b>106. Construct Binary Tree from Inorder and Postorder Traversal</b></summary>
</details>

<details>
<summary><b>107. Binary Tree Level Order Traversal II</b></summary>
</details>

<details>
<summary><b>108. Convert Sorted Array to Binary Search Tree</b></summary>
</details>

<details>
<summary><b>109. Convert Sorted List to Binary Search Tree</b></summary>
</details>

<details>
<summary><b>110. Balanced Binary Tree</b></summary>
</details>

<details>
<summary><b>111. Minimum Depth of Binary Tree</b></summary>
</details>

<details>
<summary><b>112. Path Sum</b></summary>
</details>

<details>
<summary><b>113. Path Sum II</b></summary>
</details>

<details>
<summary><b>114. Flatten Binary Tree to Linked List</b></summary>
</details>

<details>
<summary><b>115. Distinct Subsequences</b></summary>
</details>

<details>
<summary><b>116. Populating Next Right Pointers in Each Node</b></summary>
</details>

<details>
<summary><b>117. Populating Next Right Pointers in Each Node II</b></summary>
</details>

<details>
<summary><b>118. Pascal's Triangle</b></summary>
</details>

<details>
<summary><b>119. Pascal's Triangle II</b></summary>
</details>

<details>
<summary><b>120. Triangle</b></summary>
</details>

<details>
<summary><b>121. Best Time to Buy and Sell Stock</b></summary>
</details>

<details>
<summary><b>122. Best Time to Buy and Sell Stock II</b></summary>
</details>

<details>
<summary><b>123. Best Time to Buy and Sell Stock III</b></summary>
</details>

<details>
<summary><b>124. Binary Tree Maximum Path Sum</b></summary>
</details>

<details>
<summary><b>125. Valid Palindrome</b></summary>
</details>

<details>
<summary><b>126. Word Ladder II</b></summary>
</details>

<details>
<summary><b>127. Word Ladder</b></summary>
</details>

<details>
<summary><b>128. Longest Consecutive Sequence</b></summary>
</details>

<details>
<summary><b>129. Sum Root to Leaf Numbers</b></summary>
</details>

<details>
<summary><b>130. Surrounded Regions</b></summary>
</details>

<details>
<summary><b>131. Palindrome Partitioning</b></summary>
</details>

<details>
<summary><b>132. Palindrome Partitioning II</b></summary>
</details>

<details>
<summary><b>133. Clone Graph</b></summary>
</details>

<details>
<summary><b>134. Gas Station</b></summary>
</details>

<details>
<summary><b>135. Candy</b></summary>
</details>

<details>
<summary><b>136. Single Number</b></summary>
</details>

<details>
<summary><b>137. Single Number II</b></summary>
</details>

<details>
<summary><b>138. Copy List with Random Pointer</b></summary>
</details>

<details>
<summary><b>139. Word Break</b></summary>
</details>

<details>
<summary><b>140. Word Break II</b></summary>
</details>

<details>
<summary><b>141. Linked List Cycle</b></summary>
</details>

<details>
<summary><b>142. Linked List Cycle II</b></summary>
</details>

<details>
<summary><b>143. Reorder List</b></summary>
</details>

<details>
<summary><b>144. Binary Tree Preorder Traversal</b></summary>
</details>

<details>
<summary><b>145. Binary Tree Postorder Traversal</b></summary>
</details>

<details>
<summary><b>146. LRU Cache</b></summary>
</details>

<details>
<summary><b>147. Insertion Sort List</b></summary>
</details>

<details>
<summary><b>148. Sort List</b></summary>
</details>

<details>
<summary><b>149. Max Points on a Line</b></summary>
</details>

<details>
<summary><b>150. Evaluate Reverse Polish Notation</b></summary>
</details>

<details>
<summary><b>151. Reverse Words in a String</b></summary>
</details>

<details>
<summary><b>152. Maximum Product Subarray</b></summary>
</details>

<details>
<summary><b>153. Find Minimum in Rotated Sorted Array</b></summary>
</details>

<details>
<summary><b>154. Find Minimum in Rotated Sorted Array II</b></summary>
</details>

<details>
<summary><b>155. Min Stack</b></summary>
</details>

<details>
<summary><b>156. Binary Tree Upside Down</b></summary>
</details>

<details>
<summary><b>157. Read N Characters Given Read</b></summary>
</details>

<details>
<summary><b>158. Read N Characters Given read</b></summary>
</details>

<details>
<summary><b>159. Longest Substring with At Most Two Distinct Characters</b></summary>
</details>

<details>
<summary><b>160. Intersection of Two Linked Lists</b></summary>
</details>

<details>
<summary><b>161. One Edit Distance</b></summary>
</details>

<details>
<summary><b>162. Find Peak Element</b></summary>
</details>

<details>
<summary><b>163. Missing Ranges</b></summary>
</details>

<details>
<summary><b>164. Maximum Gap</b></summary>
</details>

<details>
<summary><b>165. Compare Version Numbers</b></summary>
</details>

<details>
<summary><b>166. Fraction to Recurring Decimal</b></summary>
</details>

<details>
<summary><b>167. Two Sum II - Input Array Is Sorted</b></summary>
</details>

<details>
<summary><b>168. Excel Sheet Column Title</b></summary>
</details>

<details>
<summary><b>169. Majority Element</b></summary>
</details>

<details>
<summary><b>170. Two Sum III - Data structure design</b></summary>
</details>

<details>
<summary><b>171. Excel Sheet Column Number</b></summary>
</details>

<details>
<summary><b>172. Factorial Trailing Zeroes</b></summary>
</details>

<details>
<summary><b>173. Binary Search Tree Iterator</b></summary>
</details>

<details>
<summary><b>174. Dungeon Game</b></summary>
</details>

<details>
<summary><b>175. Combine Two Tables</b></summary>
</details>

<details>
<summary><b>176. Second Highest Salary</b></summary>
</details>

<details>
<summary><b>177. Nth Highest Salary</b></summary>
</details>

<details>
<summary><b>178. Rank Scores</b></summary>
</details>

<details>
<summary><b>179. Largest Number</b></summary>
</details>

<details>
<summary><b>180. Consecutive Numbers</b></summary>
</details>

<details>
<summary><b>181. Employees Earning More Than Their Managers</b></summary>
</details>

<details>
<summary><b>182. Duplicate Emails</b></summary>
</details>

<details>
<summary><b>183. Customers Who Never Order</b></summary>
</details>

<details>
<summary><b>184. Department Highest Salary</b></summary>
</details>

<details>
<summary><b>185. Department Top Three Salaries</b></summary>
</details>

<details>
<summary><b>186. Reverse Words in a String II</b></summary>
</details>

<details>
<summary><b>187. Repeated DNA Sequences</b></summary>
</details>

<details>
<summary><b>188. Best Time to Buy and Sell Stock IV</b></summary>
</details>

<details>
<summary><b>189. Rotate Array</b></summary>
</details>

<details>
<summary><b>190. Reverse Bits</b></summary>
</details>

<details>
<summary><b>191. Number of</b></summary>
</details>

<details>
<summary><b>192. Word Frequency</b></summary>
</details>

<details>
<summary><b>193. Valid Phone Numbers</b></summary>
</details>

<details>
<summary><b>194. Transpose File</b></summary>
</details>

<details>
<summary><b>195. Tenth Line</b></summary>
</details>

<details>
<summary><b>196. Delete Duplicate Emails</b></summary>
</details>

<details>
<summary><b>197. Rising Temperature</b></summary>
</details>

<details>
<summary><b>198. House Robber</b></summary>
</details>

<details>
<summary><b>199. Binary Tree Right Side View</b></summary>
</details>

<details>
<summary><b>200. Number of Islands</b></summary>
</details>

<details>
<summary><b>201. Bitwise AND of Numbers Range</b></summary>
</details>

<details>
<summary><b>202. Happy Number</b></summary>
</details>

<details>
<summary><b>203. Remove Linked List Elements</b></summary>
</details>

<details>
<summary><b>204. Count Primes</b></summary>
</details>

<details>
<summary><b>205. Isomorphic Strings</b></summary>
</details>

<details>
<summary><b>206. Reverse Linked List</b></summary>
</details>

<details>
<summary><b>207. Course Schedule</b></summary>
</details>

<details>
<summary><b>208. Implement Trie (Prefix Tree)</b></summary>
</details>

<details>
<summary><b>209. Minimum Size Subarray Sum</b></summary>
</details>

<details>
<summary><b>210. Course Schedule II</b></summary>
</details>

<details>
<summary><b>211. Design Add and Search Words Data Structure</b></summary>
</details>

<details>
<summary><b>212. Word Search II</b></summary>
</details>

<details>
<summary><b>213. House Robber II</b></summary>
</details>

<details>
<summary><b>214. Shortest Palindrome</b></summary>
</details>

<details>
<summary><b>215. Kth Largest Element in an Array</b></summary>
</details>

<details>
<summary><b>216. Combination Sum III</b></summary>
</details>

<details>
<summary><b>217. Contains Duplicate</b></summary>
</details>

<details>
<summary><b>218. The Skyline Problem</b></summary>
</details>

<details>
<summary><b>219. Contains Duplicate II</b></summary>
</details>

<details>
<summary><b>220. Contains Duplicate III</b></summary>
</details>

<details>
<summary><b>221. Maximal Square</b></summary>
</details>

<details>
<summary><b>222. Count Complete Tree Nodes</b></summary>
</details>

<details>
<summary><b>223. Rectangle Area</b></summary>
</details>

<details>
<summary><b>224. Basic Calculator</b></summary>
</details>

<details>
<summary><b>225. Implement Stack using Queues</b></summary>
</details>

<details>
<summary><b>226. Invert Binary Tree</b></summary>
</details>

<details>
<summary><b>227. Basic Calculator II</b></summary>
</details>

<details>
<summary><b>228. Summary Ranges</b></summary>
</details>

<details>
<summary><b>229. Majority Element II</b></summary>
</details>

<details>
<summary><b>230. Kth Smallest Element in a BST</b></summary>
</details>

<details>
<summary><b>231. Power of Two</b></summary>
</details>

<details>
<summary><b>232. Implement Queue using Stacks</b></summary>
</details>

<details>
<summary><b>233. Number of Digit One</b></summary>
</details>

<details>
<summary><b>234. Palindrome Linked List</b></summary>
</details>

<details>
<summary><b>235. Lowest Common Ancestor of a Binary Search Tree</b></summary>
</details>

<details>
<summary><b>236. Lowest Common Ancestor of a Binary Tree</b></summary>
</details>

<details>
<summary><b>237. Delete Node in a Linked List</b></summary>
</details>

<details>
<summary><b>238. Product of Array Except Self</b></summary>
</details>

<details>
<summary><b>239. Sliding Window Maximum</b></summary>
</details>

<details>
<summary><b>240. Search a</b></summary>
</details>

<details>
<summary><b>241. Different Ways to Add Parentheses</b></summary>
</details>

<details>
<summary><b>242. Valid Anagram</b></summary>
</details>

<details>
<summary><b>243. Shortest Word Distance</b></summary>
</details>

<details>
<summary><b>244. Shortest Word Distance II</b></summary>
</details>

<details>
<summary><b>245. Shortest Word Distance III</b></summary>
</details>

<details>
<summary><b>246. Strobogrammatic Number</b></summary>
</details>

<details>
<summary><b>247. Strobogrammatic Number II</b></summary>
</details>

<details>
<summary><b>248. Strobogrammatic Number III</b></summary>
</details>

<details>
<summary><b>249. Group Shifted Strings</b></summary>
</details>

<details>
<summary><b>250. Count Univalue Subtrees</b></summary>
</details>

<details>
<summary><b>251. Flatten</b></summary>
</details>

<details>
<summary><b>252. Meeting Rooms</b></summary>
</details>

<details>
<summary><b>253. Meeting Rooms II</b></summary>
</details>

<details>
<summary><b>254. Factor Combinations</b></summary>
</details>

<details>
<summary><b>255. Verify Preorder Sequence in Binary Search Tree</b></summary>
</details>

<details>
<summary><b>256. Paint House</b></summary>
</details>

<details>
<summary><b>257. Binary Tree Paths</b></summary>
</details>

<details>
<summary><b>258. Add Digits</b></summary>
</details>

<details>
<summary><b>260. Single Number III</b></summary>
</details>

<details>
<summary><b>261. Graph Valid Tree</b></summary>
</details>

<details>
<summary><b>262. Trips and Users</b></summary>
</details>

<details>
<summary><b>263. Ugly Number</b></summary>
</details>

<details>
<summary><b>264. Ugly Number II</b></summary>
</details>

<details>
<summary><b>265. Paint House II</b></summary>
</details>

<details>
<summary><b>266. Palindrome Permutation</b></summary>
</details>

<details>
<summary><b>267. Palindrome Permutation II</b></summary>
</details>

<details>
<summary><b>268. Missing Number</b></summary>
</details>

<details>
<summary><b>269. Alien Dictionary</b></summary>
</details>

<details>
<summary><b>270. Closest Binary Search Tree Value</b></summary>
</details>

<details>
<summary><b>271. Encode and Decode Strings</b></summary>
</details>

<details>
<summary><b>272. Closest Binary Search Tree Value II</b></summary>
</details>

<details>
<summary><b>273. Integer to English Words</b></summary>
</details>

<details>
<summary><b>274. H-Index</b></summary>
</details>

<details>
<summary><b>275. H-Index II</b></summary>
</details>

<details>
<summary><b>276. Paint Fence</b></summary>
</details>

<details>
<summary><b>277. Find the Celebrity</b></summary>
</details>

<details>
<summary><b>278. First Bad Version</b></summary>
</details>

<details>
<summary><b>279. Perfect Squares</b></summary>
</details>

<details>
<summary><b>280. Wiggle Sort</b></summary>
</details>

<details>
<summary><b>281. Zigzag Iterator</b></summary>
</details>

<details>
<summary><b>282. Expression Add Operators</b></summary>
</details>

<details>
<summary><b>283. Move Zeroes</b></summary>
</details>

<details>
<summary><b>284. Peeking Iterator</b></summary>
</details>

<details>
<summary><b>285. Inorder Successor in BST</b></summary>
</details>

<details>
<summary><b>286. Walls and Gates</b></summary>
</details>

<details>
<summary><b>287. Find the Duplicate Number</b></summary>
</details>

<details>
<summary><b>288. Unique Word Abbreviation</b></summary>
</details>

<details>
<summary><b>289. Game of Life</b></summary>
</details>

<details>
<summary><b>290. Word Pattern</b></summary>
</details>

<details>
<summary><b>291. Word Pattern II</b></summary>
</details>

<details>
<summary><b>292. Nim Game</b></summary>
</details>

<details>
<summary><b>293. Flip Game</b></summary>
</details>

<details>
<summary><b>294. Flip Game II</b></summary>
</details>

<details>
<summary><b>295. Find Median from Data Stream</b></summary>
</details>

<details>
<summary><b>296. Best Meeting Point</b></summary>
</details>

<details>
<summary><b>297. Serialize and Deserialize Binary Tree</b></summary>
</details>

<details>
<summary><b>298. Binary Tree Longest Consecutive Sequence</b></summary>
</details>

<details>
<summary><b>299. Bulls and Cows</b></summary>
</details>

<details>
<summary><b>300. Longest Increasing Subsequence</b></summary>
</details>

<details>
<summary><b>301. Remove Invalid Parentheses</b></summary>
</details>

<details>
<summary><b>302. Smallest Rectangle Enclosing Black Pixels</b></summary>
</details>

<details>
<summary><b>303. Range Sum Query - Immutable</b></summary>
</details>

<details>
<summary><b>304. Range Sum Query</b></summary>
</details>

<details>
<summary><b>305. Number of Islands II</b></summary>
</details>

<details>
<summary><b>306. Additive Number</b></summary>
</details>

<details>
<summary><b>307. Range Sum Query - Mutable</b></summary>
</details>

<details>
<summary><b>308. Range Sum Query</b></summary>
</details>

<details>
<summary><b>309. Best Time to Buy and Sell Stock with Cooldown</b></summary>
</details>

<details>
<summary><b>310. Minimum Height Trees</b></summary>
</details>

<details>
<summary><b>311. Sparse Matrix Multiplication</b></summary>
</details>

<details>
<summary><b>312. Burst Balloons</b></summary>
</details>

<details>
<summary><b>313. Super Ugly Number</b></summary>
</details>

<details>
<summary><b>314. Binary Tree Vertical Order Traversal</b></summary>
</details>

<details>
<summary><b>315. Count of Smaller Numbers After Self</b></summary>
</details>

<details>
<summary><b>316. Remove Duplicate Letters</b></summary>
</details>

<details>
<summary><b>317. Shortest Distance from All Buildings</b></summary>
</details>

<details>
<summary><b>318. Maximum Product of Word Lengths</b></summary>
</details>

<details>
<summary><b>319. Bulb Switcher</b></summary>
</details>

<details>
<summary><b>320. Generalized Abbreviation</b></summary>
</details>

<details>
<summary><b>321. Create Maximum Number</b></summary>
</details>

<details>
<summary><b>322. Coin Change</b></summary>
</details>

<details>
<summary><b>323. Number of Connected Components in an Undirected Graph</b></summary>
</details>

<details>
<summary><b>324. Wiggle Sort II</b></summary>
</details>

<details>
<summary><b>325. Maximum Size Subarray Sum Equals k</b></summary>
</details>

<details>
<summary><b>326. Power of Three</b></summary>
</details>

<details>
<summary><b>327. Count of Range Sum</b></summary>
</details>

<details>
<summary><b>328. Odd Even Linked List</b></summary>
</details>

<details>
<summary><b>329. Longest Increasing Path in a Matrix</b></summary>
</details>

<details>
<summary><b>330. Patching Array</b></summary>
</details>

<details>
<summary><b>331. Verify Preorder Serialization of a Binary Tree</b></summary>
</details>

<details>
<summary><b>332. Reconstruct Itinerary</b></summary>
</details>

<details>
<summary><b>333. Largest BST Subtree</b></summary>
</details>

<details>
<summary><b>334. Increasing Triplet Subsequence</b></summary>
</details>

<details>
<summary><b>335. Self Crossing</b></summary>
</details>

<details>
<summary><b>336. Palindrome Pairs</b></summary>
</details>

<details>
<summary><b>337. House Robber III</b></summary>
</details>

<details>
<summary><b>338. Counting Bits</b></summary>
</details>

<details>
<summary><b>339. Nested List Weight Sum</b></summary>
</details>

<details>
<summary><b>340. Longest Substring with At Most K Distinct Characters</b></summary>
</details>

<details>
<summary><b>341. Flatten Nested List Iterator</b></summary>
</details>

<details>
<summary><b>342. Power of Four</b></summary>
</details>

<details>
<summary><b>343. Integer Break</b></summary>
</details>

<details>
<summary><b>344. Reverse String</b></summary>
</details>

<details>
<summary><b>345. Reverse Vowels of a String</b></summary>
</details>

<details>
<summary><b>346. Moving Average from Data Stream</b></summary>
</details>

<details>
<summary><b>347. Top K Frequent Elements</b></summary>
</details>

<details>
<summary><b>348. Design Tic-Tac-Toe</b></summary>
</details>

<details>
<summary><b>349. Intersection of Two Arrays</b></summary>
</details>

<details>
<summary><b>350. Intersection of Two Arrays II</b></summary>
</details>

<details>
<summary><b>351. Android Unlock Patterns</b></summary>
</details>

<details>
<summary><b>352. Data Stream as Disjoint Intervals</b></summary>
</details>

<details>
<summary><b>353. Design Snake Game</b></summary>
</details>

<details>
<summary><b>354. Russian Doll Envelopes</b></summary>
</details>

<details>
<summary><b>355. Design Twitter</b></summary>
</details>

<details>
<summary><b>356. Line Reflection</b></summary>
</details>

<details>
<summary><b>357. Count Numbers with Unique Digits</b></summary>
</details>

<details>
<summary><b>358. Rearrange String k Distance Apart</b></summary>
</details>

<details>
<summary><b>359. Logger Rate Limiter</b></summary>
</details>

<details>
<summary><b>360. Sort Transformed Array</b></summary>
</details>

<details>
<summary><b>361. Bomb Enemy</b></summary>
</details>

<details>
<summary><b>362. Design Hit Counter</b></summary>
</details>

<details>
<summary><b>363. Max Sum of Rectangle No Larger Than K</b></summary>
</details>

<details>
<summary><b>364. Nested List Weight Sum II</b></summary>
</details>

<details>
<summary><b>365. Water and Jug Problem</b></summary>
</details>

<details>
<summary><b>366. Find Leaves of Binary Tree</b></summary>
</details>

<details>
<summary><b>367. Valid Perfect Square</b></summary>
</details>

<details>
<summary><b>368. Largest Divisible Subset</b></summary>
</details>

<details>
<summary><b>369. Plus One Linked List</b></summary>
</details>

<details>
<summary><b>370. Range Addition</b></summary>
</details>

<details>
<summary><b>371. Sum of Two Integers</b></summary>
</details>

<details>
<summary><b>372. Super Pow</b></summary>
</details>

<details>
<summary><b>373. Find K Pairs with Smallest Sums</b></summary>
</details>

<details>
<summary><b>374. Guess Number Higher or Lower</b></summary>
</details>

<details>
<summary><b>375. Guess Number Higher or Lower II</b></summary>
</details>

<details>
<summary><b>376. Wiggle Subsequence</b></summary>
</details>

<details>
<summary><b>377. Combination Sum IV</b></summary>
</details>

<details>
<summary><b>378. Kth Smallest Element in a Sorted Matrix</b></summary>
</details>

<details>
<summary><b>379. Design Phone Directory</b></summary>
</details>

<details>
<summary><b>380. Insert Delete GetRandom O(</b></summary>
</details>

<details>
<summary><b>381. Insert Delete GetRandom O(</b></summary>
</details>

<details>
<summary><b>382. Linked List Random Node</b></summary>
</details>

<details>
<summary><b>383. Ransom Note</b></summary>
</details>

<details>
<summary><b>384. Shuffle an Array</b></summary>
</details>

<details>
<summary><b>385. Mini Parser</b></summary>
</details>

<details>
<summary><b>386. Lexicographical Numbers</b></summary>
</details>

<details>
<summary><b>387. First Unique Character in a String</b></summary>
</details>

<details>
<summary><b>388. Longest Absolute File Path</b></summary>
</details>

<details>
<summary><b>389. Find the Difference</b></summary>
</details>

<details>
<summary><b>390. Elimination Game</b></summary>
</details>

<details>
<summary><b>391. Perfect Rectangle</b></summary>
</details>

<details>
<summary><b>392. Is Subsequence</b></summary>
</details>

<details>
<summary><b>393. UTF-</b></summary>
</details>

<details>
<summary><b>394. Decode String</b></summary>
</details>

<details>
<summary><b>395. Longest Substring with At Least K Repeating Characters</b></summary>
</details>

<details>
<summary><b>396. Rotate Function</b></summary>
</details>

<details>
<summary><b>397. Integer Replacement</b></summary>
</details>

<details>
<summary><b>398. Random Pick Index</b></summary>
</details>

<details>
<summary><b>399. Evaluate Division</b></summary>
</details>

<details>
<summary><b>400. Nth Digit</b></summary>
</details>

<details>
<summary><b>401. Binary Watch</b></summary>
</details>

<details>
<summary><b>402. Remove K Digits</b></summary>
</details>

<details>
<summary><b>403. Frog Jump</b></summary>
</details>

<details>
<summary><b>404. Sum of Left Leaves</b></summary>
</details>

<details>
<summary><b>405. Convert a Number to Hexadecimal</b></summary>
</details>

<details>
<summary><b>406. Queue Reconstruction by Height</b></summary>
</details>

<details>
<summary><b>407. Trapping Rain Water II</b></summary>
</details>

<details>
<summary><b>408. Valid Word Abbreviation</b></summary>
</details>

<details>
<summary><b>409. Longest Palindrome</b></summary>
</details>

<details>
<summary><b>410. Split Array Largest Sum</b></summary>
</details>

<details>
<summary><b>411. Minimum Unique Word Abbreviation</b></summary>
</details>

<details>
<summary><b>412. Fizz Buzz</b></summary>
</details>

<details>
<summary><b>413. Arithmetic Slices</b></summary>
</details>

<details>
<summary><b>414. Third Maximum Number</b></summary>
</details>

<details>
<summary><b>415. Add Strings</b></summary>
</details>

<details>
<summary><b>416. Partition Equal Subset Sum</b></summary>
</details>

<details>
<summary><b>417. Pacific Atlantic Water Flow</b></summary>
</details>

<details>
<summary><b>418. Sentence Screen Fitting</b></summary>
</details>

<details>
<summary><b>419. Battleships in a Board</b></summary>
</details>

<details>
<summary><b>420. Strong Password Checker</b></summary>
</details>

<details>
<summary><b>421. Maximum XOR of Two Numbers in an Array</b></summary>
</details>

<details>
<summary><b>422. Valid Word Square</b></summary>
</details>

<details>
<summary><b>423. Reconstruct Original Digits from English</b></summary>
</details>

<details>
<summary><b>424. Longest Repeating Character Replacement</b></summary>
</details>

<details>
<summary><b>425. Word Squares</b></summary>
</details>

<details>
<summary><b>426. Convert Binary Search Tree to Sorted Doubly Linked List</b></summary>
</details>

<details>
<summary><b>427. Construct Quad Tree</b></summary>
</details>

<details>
<summary><b>428. Serialize and Deserialize N-ary Tree</b></summary>
</details>

<details>
<summary><b>429. N-ary Tree Level Order Traversal</b></summary>
</details>

<details>
<summary><b>430. Flatten a Multilevel Doubly Linked List</b></summary>
</details>

<details>
<summary><b>431. Encode N-ary Tree to Binary Tree</b></summary>
</details>

<details>
<summary><b>432. All O`one Data Structure</b></summary>
</details>

<details>
<summary><b>433. Minimum Genetic Mutation</b></summary>
</details>

<details>
<summary><b>434. Number of Segments in a String</b></summary>
</details>

<details>
<summary><b>435. Non-overlapping Intervals</b></summary>
</details>

<details>
<summary><b>436. Find Right Interval</b></summary>
</details>

<details>
<summary><b>437. Path Sum III</b></summary>
</details>

<details>
<summary><b>438. Find All Anagrams in a String</b></summary>
</details>

<details>
<summary><b>439. Ternary Expression Parser</b></summary>
</details>

<details>
<summary><b>440. K-th Smallest in Lexicographical Order</b></summary>
</details>

<details>
<summary><b>441. Arranging Coins</b></summary>
</details>

<details>
<summary><b>442. Find All Duplicates in an Array</b></summary>
</details>

<details>
<summary><b>443. String Compression</b></summary>
</details>

<details>
<summary><b>444. Sequence Reconstruction</b></summary>
</details>

<details>
<summary><b>445. Add Two Numbers II</b></summary>
</details>

<details>
<summary><b>446. Arithmetic Slices II - Subsequence</b></summary>
</details>

<details>
<summary><b>447. Number of Boomerangs</b></summary>
</details>

<details>
<summary><b>448. Find All Numbers Disappeared in an Array</b></summary>
</details>

<details>
<summary><b>449. Serialize and Deserialize BST</b></summary>
</details>

<details>
<summary><b>450. Delete Node in a BST</b></summary>
</details>

<details>
<summary><b>451. Sort Characters By Frequency</b></summary>
</details>

<details>
<summary><b>452. Minimum Number of Arrows to Burst Balloons</b></summary>
</details>

<details>
<summary><b>453. Minimum Moves to Equal Array Elements</b></summary>
</details>

<details>
<summary><b>455. Assign Cookies</b></summary>
</details>

<details>
<summary><b>457. Circular Array Loop</b></summary>
</details>

<details>
<summary><b>458. Poor Pigs</b></summary>
</details>

<details>
<summary><b>459. Repeated Substring Pattern</b></summary>
</details>

<details>
<summary><b>460. LFU Cache</b></summary>
</details>

<details>
<summary><b>461. Hamming Distance</b></summary>
</details>

<details>
<summary><b>462. Minimum Moves to Equal Array Elements II</b></summary>
</details>

<details>
<summary><b>463. Island Perimeter</b></summary>
</details>

<details>
<summary><b>464. Can I Win</b></summary>
</details>

<details>
<summary><b>465. Optimal Account Balancing</b></summary>
</details>

<details>
<summary><b>466. Count The Repetitions</b></summary>
</details>

<details>
<summary><b>467. Unique Substrings in Wraparound String</b></summary>
</details>

<details>
<summary><b>468. Validate IP Address</b></summary>
</details>

<details>
<summary><b>469. Convex Polygon</b></summary>
</details>

<details>
<summary><b>470. Implement Rand</b></summary>
</details>

<details>
<summary><b>471. Encode String with Shortest Length</b></summary>
</details>

<details>
<summary><b>472. Concatenated Words</b></summary>
</details>

<details>
<summary><b>473. Matchsticks to Square</b></summary>
</details>

<details>
<summary><b>474. Ones and Zeroes</b></summary>
</details>

<details>
<summary><b>475. Heaters</b></summary>
</details>

<details>
<summary><b>476. Number Complement</b></summary>
</details>

<details>
<summary><b>477. Total Hamming Distance</b></summary>
</details>

<details>
<summary><b>478. Generate Random Point in a Circle</b></summary>
</details>

<details>
<summary><b>479. Largest Palindrome Product</b></summary>
</details>

<details>
<summary><b>480. Sliding Window Median</b></summary>
</details>

<details>
<summary><b>481. Magical String</b></summary>
</details>

<details>
<summary><b>482. License Key Formatting</b></summary>
</details>

<details>
<summary><b>483. Smallest Good Base</b></summary>
</details>

<details>
<summary><b>484. Find Permutation</b></summary>
</details>

<details>
<summary><b>485. Max Consecutive Ones</b></summary>
</details>

<details>
<summary><b>486. Predict the Winner</b></summary>
</details>

<details>
<summary><b>487. Max Consecutive Ones II</b></summary>
</details>

<details>
<summary><b>488. Zuma Game</b></summary>
</details>

<details>
<summary><b>489. Robot Room Cleaner</b></summary>
</details>

<details>
<summary><b>490. The Maze</b></summary>
</details>

<details>
<summary><b>491. Non-decreasing Subsequences</b></summary>
</details>

<details>
<summary><b>492. Construct the Rectangle</b></summary>
</details>

<details>
<summary><b>493. Reverse Pairs</b></summary>
</details>

<details>
<summary><b>494. Target Sum</b></summary>
</details>

<details>
<summary><b>495. Teemo Attacking</b></summary>
</details>

<details>
<summary><b>496. Next Greater Element I</b></summary>
</details>

<details>
<summary><b>497. Random Point in Non-overlapping Rectangles</b></summary>
</details>

<details>
<summary><b>498. Diagonal Traverse</b></summary>
</details>

<details>
<summary><b>499. The Maze III</b></summary>
</details>

<details>
<summary><b>500. Keyboard Row</b></summary>
</details>

<details>
<summary><b>501. Find Mode in Binary Search Tree</b></summary>
</details>

<details>
<summary><b>502. IPO</b></summary>
</details>

<details>
<summary><b>503. Next Greater Element II</b></summary>
</details>

<details>
<summary><b>504. Base</b></summary>
</details>

<details>
<summary><b>505. The Maze II</b></summary>
</details>

<details>
<summary><b>506. Relative Ranks</b></summary>
</details>

<details>
<summary><b>507. Perfect Number</b></summary>
</details>

<details>
<summary><b>508. Most Frequent Subtree Sum</b></summary>
</details>

<details>
<summary><b>509. Fibonacci Number</b></summary>
</details>

<details>
<summary><b>510. Inorder Successor in BST II</b></summary>
</details>

<details>
<summary><b>511. Game Play Analysis I</b></summary>
</details>

<details>
<summary><b>512. Game Play Analysis II</b></summary>
</details>

<details>
<summary><b>513. Find Bottom Left Tree Value</b></summary>
</details>

<details>
<summary><b>514. Freedom Trail</b></summary>
</details>

<details>
<summary><b>515. Find Largest Value in Each Tree Row</b></summary>
</details>

<details>
<summary><b>516. Longest Palindromic Subsequence</b></summary>
</details>

<details>
<summary><b>517. Super Washing Machines</b></summary>
</details>

<details>
<summary><b>518. Coin Change II</b></summary>
</details>

<details>
<summary><b>519. Random Flip Matrix</b></summary>
</details>

<details>
<summary><b>520. Detect Capital</b></summary>
</details>

<details>
<summary><b>521. Longest Uncommon Subsequence I</b></summary>
</details>

<details>
<summary><b>522. Longest Uncommon Subsequence II</b></summary>
</details>

<details>
<summary><b>523. Continuous Subarray Sum</b></summary>
</details>

<details>
<summary><b>524. Longest Word in Dictionary through Deleting</b></summary>
</details>

<details>
<summary><b>525. Contiguous Array</b></summary>
</details>

<details>
<summary><b>526. Beautiful Arrangement</b></summary>
</details>

<details>
<summary><b>527. Word Abbreviation</b></summary>
</details>

<details>
<summary><b>528. Random Pick with Weight</b></summary>
</details>

<details>
<summary><b>529. Minesweeper</b></summary>
</details>

<details>
<summary><b>530. Minimum Absolute Difference in BST</b></summary>
</details>

<details>
<summary><b>531. Lonely Pixel I</b></summary>
</details>

<details>
<summary><b>532. K-diff Pairs in an Array</b></summary>
</details>

<details>
<summary><b>533. Lonely Pixel II</b></summary>
</details>

<details>
<summary><b>534. Game Play Analysis III</b></summary>
</details>

<details>
<summary><b>535. Encode and Decode TinyURL</b></summary>
</details>

<details>
<summary><b>536. Construct Binary Tree from String</b></summary>
</details>

<details>
<summary><b>537. Complex Number Multiplication</b></summary>
</details>

<details>
<summary><b>538. Convert BST to Greater Tree</b></summary>
</details>

<details>
<summary><b>539. Minimum Time Difference</b></summary>
</details>

<details>
<summary><b>540. Single Element in a Sorted Array</b></summary>
</details>

<details>
<summary><b>541. Reverse String II</b></summary>
</details>

<details>
<summary><b>543. Diameter of Binary Tree</b></summary>
</details>

<details>
<summary><b>544. Output Contest Matches</b></summary>
</details>

<details>
<summary><b>545. Boundary of Binary Tree</b></summary>
</details>

<details>
<summary><b>546. Remove Boxes</b></summary>
</details>

<details>
<summary><b>547. Number of Provinces</b></summary>
</details>

<details>
<summary><b>548. Split Array with Equal Sum</b></summary>
</details>

<details>
<summary><b>549. Binary Tree Longest Consecutive Sequence II</b></summary>
</details>

<details>
<summary><b>550. Game Play Analysis IV</b></summary>
</details>

<details>
<summary><b>551. Student Attendance Record I</b></summary>
</details>

<details>
<summary><b>552. Student Attendance Record II</b></summary>
</details>

<details>
<summary><b>553. Optimal Division</b></summary>
</details>

<details>
<summary><b>554. Brick Wall</b></summary>
</details>

<details>
<summary><b>555. Split Concatenated Strings</b></summary>
</details>

<details>
<summary><b>556. Next Greater Element III</b></summary>
</details>

<details>
<summary><b>557. Reverse Words in a String III</b></summary>
</details>

<details>
<summary><b>558. Logical OR of Two Binary Grids Represented as Quad-Trees</b></summary>
</details>

<details>
<summary><b>559. Maximum Depth of N-ary Tree</b></summary>
</details>

<details>
<summary><b>560. Subarray Sum Equals K</b></summary>
</details>

<details>
<summary><b>561. Array Partition</b></summary>
</details>

<details>
<summary><b>562. Longest Line of Consecutive One in Matrix</b></summary>
</details>

<details>
<summary><b>563. Binary Tree Tilt</b></summary>
</details>

<details>
<summary><b>564. Find the Closest Palindrome</b></summary>
</details>

<details>
<summary><b>565. Array Nesting</b></summary>
</details>

<details>
<summary><b>566. Reshape the Matrix</b></summary>
</details>

<details>
<summary><b>567. Permutation in String</b></summary>
</details>

<details>
<summary><b>568. Maximum Vacation Days</b></summary>
</details>

<details>
<summary><b>569. Median Employee Salary</b></summary>
</details>

<details>
<summary><b>570. Managers with at Least</b></summary>
</details>

<details>
<summary><b>571. Find Median Given Frequency of Numbers</b></summary>
</details>

<details>
<summary><b>572. Subtree of Another Tree</b></summary>
</details>

<details>
<summary><b>573. Squirrel Simulation</b></summary>
</details>

<details>
<summary><b>574. Winning Candidate</b></summary>
</details>

<details>
<summary><b>575. Distribute Candies</b></summary>
</details>

<details>
<summary><b>576. Out of Boundary Paths</b></summary>
</details>

<details>
<summary><b>577. Employee Bonus</b></summary>
</details>

<details>
<summary><b>578. Get Highest Answer Rate Question</b></summary>
</details>

<details>
<summary><b>579. Find Cumulative Salary of an Employee</b></summary>
</details>

<details>
<summary><b>580. Count Student Number in Departments</b></summary>
</details>

<details>
<summary><b>581. Shortest Unsorted Continuous Subarray</b></summary>
</details>

<details>
<summary><b>582. Kill Process</b></summary>
</details>

<details>
<summary><b>583. Delete Operation for Two Strings</b></summary>
</details>

<details>
<summary><b>584. Find Customer Referee</b></summary>
</details>

<details>
<summary><b>585. Investments in</b></summary>
</details>

<details>
<summary><b>586. Customer Placing the Largest Number of Orders</b></summary>
</details>

<details>
<summary><b>587. Erect the Fence</b></summary>
</details>

<details>
<summary><b>588. Design In-Memory File System</b></summary>
</details>

<details>
<summary><b>589. N-ary Tree Preorder Traversal</b></summary>
</details>

<details>
<summary><b>590. N-ary Tree Postorder Traversal</b></summary>
</details>

<details>
<summary><b>591. Tag Validator</b></summary>
</details>

<details>
<summary><b>592. Fraction Addition and Subtraction</b></summary>
</details>

<details>
<summary><b>593. Valid Square</b></summary>
</details>

<details>
<summary><b>594. Longest Harmonious Subsequence</b></summary>
</details>

<details>
<summary><b>595. Big Countries</b></summary>
</details>

<details>
<summary><b>596. Classes More Than</b></summary>
</details>

<details>
<summary><b>597. Friend Requests I: Overall Acceptance Rate</b></summary>
</details>

<details>
<summary><b>598. Range Addition II</b></summary>
</details>

<details>
<summary><b>599. Minimum Index Sum of Two Lists</b></summary>
</details>

<details>
<summary><b>600. Non-negative Integers without Consecutive Ones</b></summary>
</details>

<details>
<summary><b>601. Human Traffic of Stadium</b></summary>
</details>

<details>
<summary><b>602. Friend Requests II: Who Has the Most Friends</b></summary>
</details>

<details>
<summary><b>603. Consecutive Available Seats</b></summary>
</details>

<details>
<summary><b>604. Design Compressed String Iterator</b></summary>
</details>

<details>
<summary><b>605. Can Place Flowers</b></summary>
</details>

<details>
<summary><b>606. Construct String from Binary Tree</b></summary>
</details>

<details>
<summary><b>607. Sales Person</b></summary>
</details>

<details>
<summary><b>608. Tree Node</b></summary>
</details>

<details>
<summary><b>609. Find Duplicate File in System</b></summary>
</details>

<details>
<summary><b>610. Triangle Judgement</b></summary>
</details>

<details>
<summary><b>611. Valid Triangle Number</b></summary>
</details>

<details>
<summary><b>612. Shortest Distance in a Plane</b></summary>
</details>

<details>
<summary><b>613. Shortest Distance in a Line</b></summary>
</details>

<details>
<summary><b>614. Second Degree Follower</b></summary>
</details>

<details>
<summary><b>615. Average Salary: Departments VS Company</b></summary>
</details>

<details>
<summary><b>616. Add Bold Tag in String</b></summary>
</details>

<details>
<summary><b>617. Merge Two Binary Trees</b></summary>
</details>

<details>
<summary><b>618. Students Report By Geography</b></summary>
</details>

<details>
<summary><b>619. Biggest Single Number</b></summary>
</details>

<details>
<summary><b>620. Not Boring Movies</b></summary>
</details>

<details>
<summary><b>621. Task Scheduler</b></summary>
</details>

<details>
<summary><b>622. Design Circular Queue</b></summary>
</details>

<details>
<summary><b>623. Add One Row to Tree</b></summary>
</details>

<details>
<summary><b>624. Maximum Distance in Arrays</b></summary>
</details>

<details>
<summary><b>625. Minimum Factorization</b></summary>
</details>

<details>
<summary><b>626. Exchange Seats</b></summary>
</details>

<details>
<summary><b>627. Swap Salary</b></summary>
</details>

<details>
<summary><b>628. Maximum Product of Three Numbers</b></summary>
</details>

<details>
<summary><b>629. K Inverse Pairs Array</b></summary>
</details>

<details>
<summary><b>630. Course Schedule III</b></summary>
</details>

<details>
<summary><b>631. Design Excel Sum Formula</b></summary>
</details>

<details>
<summary><b>632. Smallest Range Covering Elements from K Lists</b></summary>
</details>

<details>
<summary><b>633. Sum of Square Numbers</b></summary>
</details>

<details>
<summary><b>634. Find the Derangement of An Array</b></summary>
</details>

<details>
<summary><b>635. Design Log Storage System</b></summary>
</details>

<details>
<summary><b>636. Exclusive Time of Functions</b></summary>
</details>

<details>
<summary><b>637. Average of Levels in Binary Tree</b></summary>
</details>

<details>
<summary><b>638. Shopping Offers</b></summary>
</details>

<details>
<summary><b>639. Decode Ways II</b></summary>
</details>

<details>
<summary><b>640. Solve the Equation</b></summary>
</details>

<details>
<summary><b>641. Design Circular Deque</b></summary>
</details>

<details>
<summary><b>642. Design Search Autocomplete System</b></summary>
</details>

<details>
<summary><b>643. Maximum Average Subarray I</b></summary>
</details>

<details>
<summary><b>644. Maximum Average Subarray II</b></summary>
</details>

<details>
<summary><b>645. Set Mismatch</b></summary>
</details>

<details>
<summary><b>646. Maximum Length of Pair Chain</b></summary>
</details>

<details>
<summary><b>647. Palindromic Substrings</b></summary>
</details>

<details>
<summary><b>648. Replace Words</b></summary>
</details>

<details>
<summary><b>649. Dota</b></summary>
</details>

<details>
<summary><b>652. Find Duplicate Subtrees</b></summary>
</details>

<details>
<summary><b>653. Two Sum IV - Input is a BST</b></summary>
</details>

<details>
<summary><b>654. Maximum Binary Tree</b></summary>
</details>

<details>
<summary><b>655. Print Binary Tree</b></summary>
</details>

<details>
<summary><b>656. Coin Path</b></summary>
</details>

<details>
<summary><b>657. Robot Return to Origin</b></summary>
</details>

<details>
<summary><b>658. Find K Closest Elements</b></summary>
</details>

<details>
<summary><b>659. Split Array into Consecutive Subsequences</b></summary>
</details>

<details>
<summary><b>660. Remove</b></summary>
</details>

<details>
<summary><b>661. Image Smoother</b></summary>
</details>

<details>
<summary><b>662. Maximum Width of Binary Tree</b></summary>
</details>

<details>
<summary><b>663. Equal Tree Partition</b></summary>
</details>

<details>
<summary><b>664. Strange Printer</b></summary>
</details>

<details>
<summary><b>665. Non-decreasing Array</b></summary>
</details>

<details>
<summary><b>666. Path Sum IV</b></summary>
</details>

<details>
<summary><b>667. Beautiful Arrangement II</b></summary>
</details>

<details>
<summary><b>668. Kth Smallest Number in Multiplication Table</b></summary>
</details>

<details>
<summary><b>669. Trim a Binary Search Tree</b></summary>
</details>

<details>
<summary><b>670. Maximum Swap</b></summary>
</details>

<details>
<summary><b>671. Second Minimum Node In a Binary Tree</b></summary>
</details>

<details>
<summary><b>672. Bulb Switcher II</b></summary>
</details>

<details>
<summary><b>673. Number of Longest Increasing Subsequence</b></summary>
</details>

<details>
<summary><b>674. Longest Continuous Increasing Subsequence</b></summary>
</details>

<details>
<summary><b>675. Cut Off Trees for Golf Event</b></summary>
</details>

<details>
<summary><b>676. Implement Magic Dictionary</b></summary>
</details>

<details>
<summary><b>677. Map Sum Pairs</b></summary>
</details>

<details>
<summary><b>678. Valid Parenthesis String</b></summary>
</details>

<details>
<summary><b>680. Valid Palindrome II</b></summary>
</details>

<details>
<summary><b>681. Next Closest Time</b></summary>
</details>

<details>
<summary><b>682. Baseball Game</b></summary>
</details>

<details>
<summary><b>683. K Empty Slots</b></summary>
</details>

<details>
<summary><b>684. Redundant Connection</b></summary>
</details>

<details>
<summary><b>685. Redundant Connection II</b></summary>
</details>

<details>
<summary><b>686. Repeated String Match</b></summary>
</details>

<details>
<summary><b>687. Longest Univalue Path</b></summary>
</details>

<details>
<summary><b>688. Knight Probability in Chessboard</b></summary>
</details>

<details>
<summary><b>689. Maximum Sum of</b></summary>
</details>

<details>
<summary><b>690. Employee Importance</b></summary>
</details>

<details>
<summary><b>691. Stickers to Spell Word</b></summary>
</details>

<details>
<summary><b>692. Top K Frequent Words</b></summary>
</details>

<details>
<summary><b>693. Binary Number with Alternating Bits</b></summary>
</details>

<details>
<summary><b>694. Number of Distinct Islands</b></summary>
</details>

<details>
<summary><b>695. Max Area of Island</b></summary>
</details>

<details>
<summary><b>696. Count Binary Substrings</b></summary>
</details>

<details>
<summary><b>697. Degree of an Array</b></summary>
</details>

<details>
<summary><b>698. Partition to K Equal Sum Subsets</b></summary>
</details>

<details>
<summary><b>699. Falling Squares</b></summary>
</details>

<details>
<summary><b>700. Search in a Binary Search Tree</b></summary>
</details>

<details>
<summary><b>701. Insert into a Binary Search Tree</b></summary>
</details>

<details>
<summary><b>702. Search in a Sorted Array of Unknown Size</b></summary>
</details>

<details>
<summary><b>703. Kth Largest Element in a Stream</b></summary>
</details>

<details>
<summary><b>704. Binary Search</b></summary>
</details>

<details>
<summary><b>705. Design HashSet</b></summary>
</details>

<details>
<summary><b>706. Design HashMap</b></summary>
</details>

<details>
<summary><b>707. Design Linked List</b></summary>
</details>

<details>
<summary><b>708. Insert into a Sorted Circular Linked List</b></summary>
</details>

<details>
<summary><b>709. To Lower Case</b></summary>
</details>

<details>
<summary><b>710. Random Pick with Blacklist</b></summary>
</details>

<details>
<summary><b>711. Number of Distinct Islands II</b></summary>
</details>

<details>
<summary><b>712. Minimum ASCII Delete Sum for Two Strings</b></summary>
</details>

<details>
<summary><b>713. Subarray Product Less Than K</b></summary>
</details>

<details>
<summary><b>714. Best Time to Buy and Sell Stock with Transaction Fee</b></summary>
</details>

<details>
<summary><b>715. Range Module</b></summary>
</details>

<details>
<summary><b>716. Max Stack</b></summary>
</details>

<details>
<summary><b>718. Maximum Length of Repeated Subarray</b></summary>
</details>

<details>
<summary><b>719. Find K-th Smallest Pair Distance</b></summary>
</details>

<details>
<summary><b>720. Longest Word in Dictionary</b></summary>
</details>

<details>
<summary><b>721. Accounts Merge</b></summary>
</details>

<details>
<summary><b>722. Remove Comments</b></summary>
</details>

<details>
<summary><b>723. Candy Crush</b></summary>
</details>

<details>
<summary><b>724. Find Pivot Index</b></summary>
</details>

<details>
<summary><b>725. Split Linked List in Parts</b></summary>
</details>

<details>
<summary><b>726. Number of Atoms</b></summary>
</details>

<details>
<summary><b>727. Minimum Window Subsequence</b></summary>
</details>

<details>
<summary><b>728. Self Dividing Numbers</b></summary>
</details>

<details>
<summary><b>729. My Calendar I</b></summary>
</details>

<details>
<summary><b>730. Count Different Palindromic Subsequences</b></summary>
</details>

<details>
<summary><b>731. My Calendar II</b></summary>
</details>

<details>
<summary><b>732. My Calendar III</b></summary>
</details>

<details>
<summary><b>733. Flood Fill</b></summary>
</details>

<details>
<summary><b>734. Sentence Similarity</b></summary>
</details>

<details>
<summary><b>735. Asteroid Collision</b></summary>
</details>

<details>
<summary><b>736. Parse Lisp Expression</b></summary>
</details>

<details>
<summary><b>737. Sentence Similarity II</b></summary>
</details>

<details>
<summary><b>738. Monotone Increasing Digits</b></summary>
</details>

<details>
<summary><b>739. Daily Temperatures</b></summary>
</details>

<details>
<summary><b>740. Delete and Earn</b></summary>
</details>

<details>
<summary><b>741. Cherry Pickup</b></summary>
</details>

<details>
<summary><b>742. Closest Leaf in a Binary Tree</b></summary>
</details>

<details>
<summary><b>743. Network Delay Time</b></summary>
</details>

<details>
<summary><b>744. Find Smallest Letter Greater Than Target</b></summary>
</details>

<details>
<summary><b>745. Prefix and Suffix Search</b></summary>
</details>

<details>
<summary><b>746. Min Cost Climbing Stairs</b></summary>
</details>

<details>
<summary><b>747. Largest Number At Least Twice of Others</b></summary>
</details>

<details>
<summary><b>748. Shortest Completing Word</b></summary>
</details>

<details>
<summary><b>749. Contain Virus</b></summary>
</details>

<details>
<summary><b>750. Number Of Corner Rectangles</b></summary>
</details>

<details>
<summary><b>751. IP to CIDR</b></summary>
</details>

<details>
<summary><b>752. Open the Lock</b></summary>
</details>

<details>
<summary><b>753. Cracking the Safe</b></summary>
</details>

<details>
<summary><b>754. Reach a Number</b></summary>
</details>

<details>
<summary><b>755. Pour Water</b></summary>
</details>

<details>
<summary><b>756. Pyramid Transition Matrix</b></summary>
</details>

<details>
<summary><b>757. Set Intersection Size At Least Two</b></summary>
</details>

<details>
<summary><b>758. Bold Words in String</b></summary>
</details>

<details>
<summary><b>759. Employee Free Time</b></summary>
</details>

<details>
<summary><b>760. Find Anagram Mappings</b></summary>
</details>

<details>
<summary><b>761. Special Binary String</b></summary>
</details>

<details>
<summary><b>762. Prime Number of Set Bits in Binary Representation</b></summary>
</details>

<details>
<summary><b>763. Partition Labels</b></summary>
</details>

<details>
<summary><b>764. Largest Plus Sign</b></summary>
</details>

<details>
<summary><b>765. Couples Holding Hands</b></summary>
</details>

<details>
<summary><b>766. Toeplitz Matrix</b></summary>
</details>

<details>
<summary><b>767. Reorganize String</b></summary>
</details>

<details>
<summary><b>768. Max Chunks To Make Sorted II</b></summary>
</details>

<details>
<summary><b>769. Max Chunks To Make Sorted</b></summary>
</details>

<details>
<summary><b>770. Basic Calculator IV</b></summary>
</details>

<details>
<summary><b>771. Jewels and Stones</b></summary>
</details>

<details>
<summary><b>772. Basic Calculator III</b></summary>
</details>

<details>
<summary><b>773. Sliding Puzzle</b></summary>
</details>

<details>
<summary><b>774. Minimize Max Distance to Gas Station</b></summary>
</details>

<details>
<summary><b>775. Global and Local Inversions</b></summary>
</details>

<details>
<summary><b>776. Split BST</b></summary>
</details>

<details>
<summary><b>777. Swap Adjacent in LR String</b></summary>
</details>

<details>
<summary><b>778. Swim in Rising Water</b></summary>
</details>

<details>
<summary><b>779. K-th Symbol in Grammar</b></summary>
</details>

<details>
<summary><b>780. Reaching Points</b></summary>
</details>

<details>
<summary><b>781. Rabbits in Forest</b></summary>
</details>

<details>
<summary><b>782. Transform to Chessboard</b></summary>
</details>

<details>
<summary><b>783. Minimum Distance Between BST Nodes</b></summary>
</details>

<details>
<summary><b>784. Letter Case Permutation</b></summary>
</details>

<details>
<summary><b>785. Is Graph Bipartite?</b></summary>
</details>

<details>
<summary><b>786. K-th Smallest Prime Fraction</b></summary>
</details>

<details>
<summary><b>787. Cheapest Flights Within K Stops</b></summary>
</details>

<details>
<summary><b>788. Rotated Digits</b></summary>
</details>

<details>
<summary><b>789. Escape The Ghosts</b></summary>
</details>

<details>
<summary><b>790. Domino and Tromino Tiling</b></summary>
</details>

<details>
<summary><b>791. Custom Sort String</b></summary>
</details>

<details>
<summary><b>792. Number of Matching Subsequences</b></summary>
</details>

<details>
<summary><b>793. Preimage Size of Factorial Zeroes Function</b></summary>
</details>

<details>
<summary><b>794. Valid Tic-Tac-Toe State</b></summary>
</details>

<details>
<summary><b>795. Number of Subarrays with Bounded Maximum</b></summary>
</details>

<details>
<summary><b>796. Rotate String</b></summary>
</details>

<details>
<summary><b>797. All Paths From Source to Target</b></summary>
</details>

<details>
<summary><b>798. Smallest Rotation with Highest Score</b></summary>
</details>

<details>
<summary><b>799. Champagne Tower</b></summary>
</details>

<details>
<summary><b>800. Similar RGB Color</b></summary>
</details>

<details>
<summary><b>801. Minimum Swaps To Make Sequences Increasing</b></summary>
</details>

<details>
<summary><b>802. Find Eventual Safe States</b></summary>
</details>

<details>
<summary><b>803. Bricks Falling When Hit</b></summary>
</details>

<details>
<summary><b>804. Unique Morse Code Words</b></summary>
</details>

<details>
<summary><b>805. Split Array With Same Average</b></summary>
</details>

<details>
<summary><b>806. Number of Lines To Write String</b></summary>
</details>

<details>
<summary><b>807. Max Increase to Keep City Skyline</b></summary>
</details>

<details>
<summary><b>808. Soup Servings</b></summary>
</details>

<details>
<summary><b>809. Expressive Words</b></summary>
</details>

<details>
<summary><b>810. Chalkboard XOR Game</b></summary>
</details>

<details>
<summary><b>811. Subdomain Visit Count</b></summary>
</details>

<details>
<summary><b>812. Largest Triangle Area</b></summary>
</details>

<details>
<summary><b>813. Largest Sum of Averages</b></summary>
</details>

<details>
<summary><b>814. Binary Tree Pruning</b></summary>
</details>

<details>
<summary><b>815. Bus Routes</b></summary>
</details>

<details>
<summary><b>816. Ambiguous Coordinates</b></summary>
</details>

<details>
<summary><b>817. Linked List Components</b></summary>
</details>

<details>
<summary><b>818. Race Car</b></summary>
</details>

<details>
<summary><b>819. Most Common Word</b></summary>
</details>

<details>
<summary><b>820. Short Encoding of Words</b></summary>
</details>

<details>
<summary><b>821. Shortest Distance to a Character</b></summary>
</details>

<details>
<summary><b>822. Card Flipping Game</b></summary>
</details>

<details>
<summary><b>823. Binary Trees With Factors</b></summary>
</details>

<details>
<summary><b>824. Goat Latin</b></summary>
</details>

<details>
<summary><b>825. Friends Of Appropriate Ages</b></summary>
</details>

<details>
<summary><b>826. Most Profit Assigning Work</b></summary>
</details>

<details>
<summary><b>827. Making A Large Island</b></summary>
</details>

<details>
<summary><b>828. Count Unique Characters of All Substrings of a Given String</b></summary>
</details>

<details>
<summary><b>829. Consecutive Numbers Sum</b></summary>
</details>

<details>
<summary><b>830. Positions of Large Groups</b></summary>
</details>

<details>
<summary><b>831. Masking Personal Information</b></summary>
</details>

<details>
<summary><b>832. Flipping an Image</b></summary>
</details>

<details>
<summary><b>833. Find And Replace in String</b></summary>
</details>

<details>
<summary><b>834. Sum of Distances in Tree</b></summary>
</details>

<details>
<summary><b>835. Image Overlap</b></summary>
</details>

<details>
<summary><b>836. Rectangle Overlap</b></summary>
</details>

<details>
<summary><b>837. New</b></summary>
</details>

<details>
<summary><b>838. Push Dominoes</b></summary>
</details>

<details>
<summary><b>839. Similar String Groups</b></summary>
</details>

<details>
<summary><b>840. Magic Squares In Grid</b></summary>
</details>

<details>
<summary><b>841. Keys and Rooms</b></summary>
</details>

<details>
<summary><b>842. Split Array into Fibonacci Sequence</b></summary>
</details>

<details>
<summary><b>843. Guess the Word</b></summary>
</details>

<details>
<summary><b>844. Backspace String Compare</b></summary>
</details>

<details>
<summary><b>845. Longest Mountain in Array</b></summary>
</details>

<details>
<summary><b>846. Hand of Straights</b></summary>
</details>

<details>
<summary><b>847. Shortest Path Visiting All Nodes</b></summary>
</details>

<details>
<summary><b>848. Shifting Letters</b></summary>
</details>

<details>
<summary><b>849. Maximize Distance to Closest Person</b></summary>
</details>

<details>
<summary><b>850. Rectangle Area II</b></summary>
</details>

<details>
<summary><b>851. Loud and Rich</b></summary>
</details>

<details>
<summary><b>852. Peak Index in a Mountain Array</b></summary>
</details>

<details>
<summary><b>853. Car Fleet</b></summary>
</details>

<details>
<summary><b>854. K-Similar Strings</b></summary>
</details>

<details>
<summary><b>855. Exam Room</b></summary>
</details>

<details>
<summary><b>856. Score of Parentheses</b></summary>
</details>

<details>
<summary><b>857. Minimum Cost to Hire K Workers</b></summary>
</details>

<details>
<summary><b>858. Mirror Reflection</b></summary>
</details>

<details>
<summary><b>859. Buddy Strings</b></summary>
</details>

<details>
<summary><b>860. Lemonade Change</b></summary>
</details>

<details>
<summary><b>861. Score After Flipping Matrix</b></summary>
</details>

<details>
<summary><b>862. Shortest Subarray with Sum at Least K</b></summary>
</details>

<details>
<summary><b>863. All Nodes Distance K in Binary Tree</b></summary>
</details>

<details>
<summary><b>864. Shortest Path to Get All Keys</b></summary>
</details>

<details>
<summary><b>865. Smallest Subtree with all the Deepest Nodes</b></summary>
</details>

<details>
<summary><b>866. Prime Palindrome</b></summary>
</details>

<details>
<summary><b>867. Transpose Matrix</b></summary>
</details>

<details>
<summary><b>868. Binary Gap</b></summary>
</details>

<details>
<summary><b>869. Reordered Power of</b></summary>
</details>

<details>
<summary><b>870. Advantage Shuffle</b></summary>
</details>

<details>
<summary><b>871. Minimum Number of Refueling Stops</b></summary>
</details>

<details>
<summary><b>872. Leaf-Similar Trees</b></summary>
</details>

<details>
<summary><b>873. Length of Longest Fibonacci Subsequence</b></summary>
</details>

<details>
<summary><b>874. Walking Robot Simulation</b></summary>
</details>

<details>
<summary><b>875. Koko Eating Bananas</b></summary>
</details>

<details>
<summary><b>876. Middle of the Linked List</b></summary>
</details>

<details>
<summary><b>877. Stone Game</b></summary>
</details>

<details>
<summary><b>878. Nth Magical Number</b></summary>
</details>

<details>
<summary><b>879. Profitable Schemes</b></summary>
</details>

<details>
<summary><b>880. Decoded String at Index</b></summary>
</details>

<details>
<summary><b>881. Boats to Save People</b></summary>
</details>

<details>
<summary><b>882. Reachable Nodes In Subdivided Graph</b></summary>
</details>

<details>
<summary><b>883. Projection Area of</b></summary>
</details>

<details>
<summary><b>884. Uncommon Words from Two Sentences</b></summary>
</details>

<details>
<summary><b>885. Spiral Matrix III</b></summary>
</details>

<details>
<summary><b>886. Possible Bipartition</b></summary>
</details>

<details>
<summary><b>887. Super Egg Drop</b></summary>
</details>

<details>
<summary><b>888. Fair Candy Swap</b></summary>
</details>

<details>
<summary><b>889. Construct Binary Tree from Preorder and Postorder Traversal</b></summary>
</details>

<details>
<summary><b>890. Find and Replace Pattern</b></summary>
</details>

<details>
<summary><b>891. Sum of Subsequence Widths</b></summary>
</details>

<details>
<summary><b>892. Surface Area of</b></summary>
</details>

<details>
<summary><b>893. Groups of Special-Equivalent Strings</b></summary>
</details>

<details>
<summary><b>894. All Possible Full Binary Trees</b></summary>
</details>

<details>
<summary><b>895. Maximum Frequency Stack</b></summary>
</details>

<details>
<summary><b>896. Monotonic Array</b></summary>
</details>

<details>
<summary><b>897. Increasing Order Search Tree</b></summary>
</details>

<details>
<summary><b>898. Bitwise ORs of Subarrays</b></summary>
</details>

<details>
<summary><b>899. Orderly Queue</b></summary>
</details>

<details>
<summary><b>900. RLE Iterator</b></summary>
</details>

<details>
<summary><b>901. Online Stock Span</b></summary>
</details>

<details>
<summary><b>902. Numbers At Most N Given Digit Set</b></summary>
</details>

<details>
<summary><b>903. Valid Permutations for DI Sequence</b></summary>
</details>

<details>
<summary><b>904. Fruit Into Baskets</b></summary>
</details>

<details>
<summary><b>905. Sort Array By Parity</b></summary>
</details>

<details>
<summary><b>906. Super Palindromes</b></summary>
</details>

<details>
<summary><b>907. Sum of Subarray Minimums</b></summary>
</details>

<details>
<summary><b>908. Smallest Range I</b></summary>
</details>

<details>
<summary><b>909. Snakes and Ladders</b></summary>
</details>

<details>
<summary><b>910. Smallest Range II</b></summary>
</details>

<details>
<summary><b>911. Online Election</b></summary>
</details>

<details>
<summary><b>912. Sort an Array</b></summary>
</details>

<details>
<summary><b>913. Cat and Mouse</b></summary>
</details>

<details>
<summary><b>914. X of a Kind in a Deck of Cards</b></summary>
</details>

<details>
<summary><b>915. Partition Array into Disjoint Intervals</b></summary>
</details>

<details>
<summary><b>916. Word Subsets</b></summary>
</details>

<details>
<summary><b>917. Reverse Only Letters</b></summary>
</details>

<details>
<summary><b>918. Maximum Sum Circular Subarray</b></summary>
</details>

<details>
<summary><b>919. Complete Binary Tree Inserter</b></summary>
</details>

<details>
<summary><b>920. Number of Music Playlists</b></summary>
</details>

<details>
<summary><b>921. Minimum Add to Make Parentheses Valid</b></summary>
</details>

<details>
<summary><b>922. Sort Array By Parity II</b></summary>
</details>

<details>
<summary><b>924. Minimize Malware Spread</b></summary>
</details>

<details>
<summary><b>925. Long Pressed Name</b></summary>
</details>

<details>
<summary><b>926. Flip String to Monotone Increasing</b></summary>
</details>

<details>
<summary><b>927. Three Equal Parts</b></summary>
</details>

<details>
<summary><b>928. Minimize Malware Spread II</b></summary>
</details>

<details>
<summary><b>929. Unique Email Addresses</b></summary>
</details>

<details>
<summary><b>930. Binary Subarrays With Sum</b></summary>
</details>

<details>
<summary><b>931. Minimum Falling Path Sum</b></summary>
</details>

<details>
<summary><b>932. Beautiful Array</b></summary>
</details>

<details>
<summary><b>933. Number of Recent Calls</b></summary>
</details>

<details>
<summary><b>934. Shortest Bridge</b></summary>
</details>

<details>
<summary><b>935. Knight Dialer</b></summary>
</details>

<details>
<summary><b>936. Stamping The Sequence</b></summary>
</details>

<details>
<summary><b>937. Reorder Data in Log Files</b></summary>
</details>

<details>
<summary><b>938. Range Sum of BST</b></summary>
</details>

<details>
<summary><b>939. Minimum Area Rectangle</b></summary>
</details>

<details>
<summary><b>940. Distinct Subsequences II</b></summary>
</details>

<details>
<summary><b>941. Valid Mountain Array</b></summary>
</details>

<details>
<summary><b>942. DI String Match</b></summary>
</details>

<details>
<summary><b>943. Find the Shortest Superstring</b></summary>
</details>

<details>
<summary><b>944. Delete Columns to Make Sorted</b></summary>
</details>

<details>
<summary><b>945. Minimum Increment to Make Array Unique</b></summary>
</details>

<details>
<summary><b>946. Validate Stack Sequences</b></summary>
</details>

<details>
<summary><b>947. Most Stones Removed with Same Row or Column</b></summary>
</details>

<details>
<summary><b>948. Bag of Tokens</b></summary>
</details>

<details>
<summary><b>949. Largest Time for Given Digits</b></summary>
</details>

<details>
<summary><b>950. Reveal Cards In Increasing Order</b></summary>
</details>

<details>
<summary><b>951. Flip Equivalent Binary Trees</b></summary>
</details>

<details>
<summary><b>952. Largest Component Size by Common Factor</b></summary>
</details>

<details>
<summary><b>953. Verifying an Alien Dictionary</b></summary>
</details>

<details>
<summary><b>954. Array of Doubled Pairs</b></summary>
</details>

<details>
<summary><b>955. Delete Columns to Make Sorted II</b></summary>
</details>

<details>
<summary><b>956. Tallest Billboard</b></summary>
</details>

<details>
<summary><b>957. Prison Cells After N Days</b></summary>
</details>

<details>
<summary><b>958. Check Completeness of a Binary Tree</b></summary>
</details>

<details>
<summary><b>959. Regions Cut By Slashes</b></summary>
</details>

<details>
<summary><b>960. Delete Columns to Make Sorted III</b></summary>
</details>

<details>
<summary><b>961. N-Repeated Element in Size</b></summary>
</details>

<details>
<summary><b>962. Maximum Width Ramp</b></summary>
</details>

<details>
<summary><b>963. Minimum Area Rectangle II</b></summary>
</details>

<details>
<summary><b>964. Least Operators to Express Number</b></summary>
</details>

<details>
<summary><b>965. Univalued Binary Tree</b></summary>
</details>

<details>
<summary><b>966. Vowel Spellchecker</b></summary>
</details>

<details>
<summary><b>967. Numbers With Same Consecutive Differences</b></summary>
</details>

<details>
<summary><b>968. Binary Tree Cameras</b></summary>
</details>

<details>
<summary><b>969. Pancake Sorting</b></summary>
</details>

<details>
<summary><b>970. Powerful Integers</b></summary>
</details>

<details>
<summary><b>971. Flip Binary Tree To Match Preorder Traversal</b></summary>
</details>

<details>
<summary><b>972. Equal Rational Numbers</b></summary>
</details>

<details>
<summary><b>973. K Closest Points to Origin</b></summary>
</details>

<details>
<summary><b>974. Subarray Sums Divisible by K</b></summary>
</details>

<details>
<summary><b>975. Odd Even Jump</b></summary>
</details>

<details>
<summary><b>976. Largest Perimeter Triangle</b></summary>
</details>

<details>
<summary><b>977. Squares of a Sorted Array</b></summary>
</details>

<details>
<summary><b>978. Longest Turbulent Subarray</b></summary>
</details>

<details>
<summary><b>979. Distribute Coins in Binary Tree</b></summary>
</details>

<details>
<summary><b>980. Unique Paths III</b></summary>
</details>

<details>
<summary><b>981. Time Based Key-Value Store</b></summary>
</details>

<details>
<summary><b>982. Triples with Bitwise AND Equal To Zero</b></summary>
</details>

<details>
<summary><b>983. Minimum Cost For Tickets</b></summary>
</details>

<details>
<summary><b>984. String Without AAA or BBB</b></summary>
</details>

<details>
<summary><b>985. Sum of Even Numbers After Queries</b></summary>
</details>

<details>
<summary><b>986. Interval List Intersections</b></summary>
</details>

<details>
<summary><b>987. Vertical Order Traversal of a Binary Tree</b></summary>
</details>

<details>
<summary><b>988. Smallest String Starting From Leaf</b></summary>
</details>

<details>
<summary><b>989. Add to Array-Form of Integer</b></summary>
</details>

<details>
<summary><b>990. Satisfiability of Equality Equations</b></summary>
</details>

<details>
<summary><b>991. Broken Calculator</b></summary>
</details>

<details>
<summary><b>992. Subarrays with K Different Integers</b></summary>
</details>

<details>
<summary><b>993. Cousins in Binary Tree</b></summary>
</details>

<details>
<summary><b>994. Rotting Oranges</b></summary>
</details>

<details>
<summary><b>995. Minimum Number of K Consecutive Bit Flips</b></summary>
</details>

<details>
<summary><b>996. Number of Squareful Arrays</b></summary>
</details>

<details>
<summary><b>997. Find the Town Judge</b></summary>
</details>

<details>
<summary><b>998. Maximum Binary Tree II</b></summary>
</details>

<details>
<summary><b>999. Available Captures for Rook</b></summary>
</details>

<details>
<summary><b>1000. Minimum Cost to Merge Stones</b></summary>
</details>

<details>
<summary><b>1001. Grid Illumination</b></summary>
</details>

<details>
<summary><b>1002. Find Common Characters</b></summary>
</details>

<details>
<summary><b>1003. Check If Word Is Valid After Substitutions</b></summary>
</details>

<details>
<summary><b>1004. Max Consecutive Ones III</b></summary>
</details>

<details>
<summary><b>1005. Maximize Sum Of Array After K Negations</b></summary>
</details>

<details>
<summary><b>1006. Clumsy Factorial</b></summary>
</details>

<details>
<summary><b>1007. Minimum Domino Rotations For Equal Row</b></summary>
</details>

<details>
<summary><b>1008. Construct Binary Search Tree from Preorder Traversal</b></summary>
</details>

<details>
<summary><b>1009. Complement of Base</b></summary>
</details>

<details>
<summary><b>1010. Pairs of Songs With Total Durations Divisible by</b></summary>
</details>

<details>
<summary><b>1011. Capacity To Ship Packages Within D Days</b></summary>
</details>

<details>
<summary><b>1012. Numbers With Repeated Digits</b></summary>
</details>

<details>
<summary><b>1013. Partition Array Into Three Parts With Equal Sum</b></summary>
</details>

<details>
<summary><b>1014. Best Sightseeing Pair</b></summary>
</details>

<details>
<summary><b>1015. Smallest Integer Divisible by K</b></summary>
</details>

<details>
<summary><b>1016. Binary String With Substrings Representing</b></summary>
</details>

<details>
<summary><b>1017. Convert to Base -</b></summary>
</details>

<details>
<summary><b>1018. Binary Prefix Divisible By</b></summary>
</details>

<details>
<summary><b>1019. Next Greater Node In Linked List</b></summary>
</details>

<details>
<summary><b>1020. Number of Enclaves</b></summary>
</details>

<details>
<summary><b>1021. Remove Outermost Parentheses</b></summary>
</details>

<details>
<summary><b>1022. Sum of Root To Leaf Binary Numbers</b></summary>
</details>

<details>
<summary><b>1023. Camelcase Matching</b></summary>
</details>

<details>
<summary><b>1024. Video Stitching</b></summary>
</details>

<details>
<summary><b>1025. Divisor Game</b></summary>
</details>

<details>
<summary><b>1026. Maximum Difference Between Node and Ancestor</b></summary>
</details>

<details>
<summary><b>1027. Longest Arithmetic Subsequence</b></summary>
</details>

<details>
<summary><b>1028. Recover a Tree From Preorder Traversal</b></summary>
</details>

<details>
<summary><b>1029. Two City Scheduling</b></summary>
</details>

<details>
<summary><b>1030. Matrix Cells in Distance Order</b></summary>
</details>

<details>
<summary><b>1031. Maximum Sum of Two Non-Overlapping Subarrays</b></summary>
</details>

<details>
<summary><b>1032. Stream of Characters</b></summary>
</details>

<details>
<summary><b>1033. Moving Stones Until Consecutive</b></summary>
</details>

<details>
<summary><b>1034. Coloring A Border</b></summary>
</details>

<details>
<summary><b>1035. Uncrossed Lines</b></summary>
</details>

<details>
<summary><b>1036. Escape a Large Maze</b></summary>
</details>

<details>
<summary><b>1037. Valid Boomerang</b></summary>
</details>

<details>
<summary><b>1038. Binary Search Tree to Greater Sum Tree</b></summary>
</details>

<details>
<summary><b>1039. Minimum Score Triangulation of Polygon</b></summary>
</details>

<details>
<summary><b>1040. Moving Stones Until Consecutive II</b></summary>
</details>

<details>
<summary><b>1041. Robot Bounded In Circle</b></summary>
</details>

<details>
<summary><b>1042. Flower Planting With No Adjacent</b></summary>
</details>

<details>
<summary><b>1043. Partition Array for Maximum Sum</b></summary>
</details>

<details>
<summary><b>1044. Longest Duplicate Substring</b></summary>
</details>

<details>
<summary><b>1045. Customers Who Bought All Products</b></summary>
</details>

<details>
<summary><b>1046. Last Stone Weight</b></summary>
</details>

<details>
<summary><b>1047. Remove All Adjacent Duplicates In String</b></summary>
</details>

<details>
<summary><b>1048. Longest String Chain</b></summary>
</details>

<details>
<summary><b>1049. Last Stone Weight II</b></summary>
</details>

<details>
<summary><b>1050. Actors and Directors Who Cooperated At Least Three Times</b></summary>
</details>

<details>
<summary><b>1051. Height Checker</b></summary>
</details>

<details>
<summary><b>1052. Grumpy Bookstore Owner</b></summary>
</details>

<details>
<summary><b>1053. Previous Permutation With One Swap</b></summary>
</details>

<details>
<summary><b>1054. Distant Barcodes</b></summary>
</details>

<details>
<summary><b>1055. Shortest Way to Form String</b></summary>
</details>

<details>
<summary><b>1056. Confusing Number</b></summary>
</details>

<details>
<summary><b>1057. Campus Bikes</b></summary>
</details>

<details>
<summary><b>1058. Minimize Rounding Error to Meet Target</b></summary>
</details>

<details>
<summary><b>1059. All Paths from Source Lead to Destination</b></summary>
</details>

<details>
<summary><b>1060. Missing Element in Sorted Array</b></summary>
</details>

<details>
<summary><b>1061. Lexicographically Smallest Equivalent String</b></summary>
</details>

<details>
<summary><b>1062. Longest Repeating Substring</b></summary>
</details>

<details>
<summary><b>1063. Number of Valid Subarrays</b></summary>
</details>

<details>
<summary><b>1064. Fixed Point</b></summary>
</details>

<details>
<summary><b>1065. Index Pairs of a String</b></summary>
</details>

<details>
<summary><b>1066. Campus Bikes II</b></summary>
</details>

<details>
<summary><b>1067. Digit Count in Range</b></summary>
</details>

<details>
<summary><b>1068. Product Sales Analysis I</b></summary>
</details>

<details>
<summary><b>1069. Product Sales Analysis II</b></summary>
</details>

<details>
<summary><b>1070. Product Sales Analysis III</b></summary>
</details>

<details>
<summary><b>1071. Greatest Common Divisor of Strings</b></summary>
</details>

<details>
<summary><b>1072. Flip Columns For Maximum Number of Equal Rows</b></summary>
</details>

<details>
<summary><b>1073. Adding Two Negabinary Numbers</b></summary>
</details>

<details>
<summary><b>1074. Number of Submatrices That Sum to Target</b></summary>
</details>

<details>
<summary><b>1075. Project Employees I</b></summary>
</details>

<details>
<summary><b>1076. Project Employees II</b></summary>
</details>

<details>
<summary><b>1077. Project Employees III</b></summary>
</details>

<details>
<summary><b>1078. Occurrences After Bigram</b></summary>
</details>

<details>
<summary><b>1079. Letter Tile Possibilities</b></summary>
</details>

<details>
<summary><b>1080. Insufficient Nodes in Root to Leaf Paths</b></summary>
</details>

<details>
<summary><b>1081. Smallest Subsequence of Distinct Characters</b></summary>
</details>

<details>
<summary><b>1082. Sales Analysis I</b></summary>
</details>

<details>
<summary><b>1083. Sales Analysis II</b></summary>
</details>

<details>
<summary><b>1084. Sales Analysis III</b></summary>
</details>

<details>
<summary><b>1085. Sum of Digits in the Minimum Number</b></summary>
</details>

<details>
<summary><b>1086. High Five</b></summary>
</details>

<details>
<summary><b>1087. Brace Expansion</b></summary>
</details>

<details>
<summary><b>1088. Confusing Number II</b></summary>
</details>

<details>
<summary><b>1089. Duplicate Zeros</b></summary>
</details>

<details>
<summary><b>1090. Largest Values From Labels</b></summary>
</details>

<details>
<summary><b>1091. Shortest Path in Binary Matrix</b></summary>
</details>

<details>
<summary><b>1092. Shortest Common Supersequence</b></summary>
</details>

<details>
<summary><b>1093. Statistics from a Large Sample</b></summary>
</details>

<details>
<summary><b>1094. Car Pooling</b></summary>
</details>

<details>
<summary><b>1095. Find in Mountain Array</b></summary>
</details>

<details>
<summary><b>1096. Brace Expansion II</b></summary>
</details>

<details>
<summary><b>1097. Game Play Analysis V</b></summary>
</details>

<details>
<summary><b>1098. Unpopular Books</b></summary>
</details>

<details>
<summary><b>1099. Two Sum Less Than K</b></summary>
</details>

<details>
<summary><b>1100. Find K-Length Substrings With 

Status
Title
Solution
Acceptance
Difficulty
Frequency</b></summary>
</details>

<details>
<summary><b>1101. The Earliest Moment When Everyone Become Friends</b></summary>
</details>

<details>
<summary><b>1102. Path With Maximum Minimum Value</b></summary>
</details>

<details>
<summary><b>1103. Distribute Candies to People</b></summary>
</details>

<details>
<summary><b>1104. Path In Zigzag Labelled Binary Tree</b></summary>
</details>

<details>
<summary><b>1105. Filling Bookcase Shelves</b></summary>
</details>

<details>
<summary><b>1106. Parsing A Boolean Expression</b></summary>
</details>

<details>
<summary><b>1107. New Users Daily Count</b></summary>
</details>

<details>
<summary><b>1108. Defanging an IP Address</b></summary>
</details>

<details>
<summary><b>1109. Corporate Flight Bookings</b></summary>
</details>

<details>
<summary><b>1110. Delete Nodes And Return Forest</b></summary>
</details>

<details>
<summary><b>1111. Maximum Nesting Depth of Two Valid Parentheses Strings</b></summary>
</details>

<details>
<summary><b>1112. Highest Grade For Each Student</b></summary>
</details>

<details>
<summary><b>1113. Reported Posts</b></summary>
</details>

<details>
<summary><b>1114. Print in Order</b></summary>
</details>

<details>
<summary><b>1115. Print FooBar Alternately</b></summary>
</details>

<details>
<summary><b>1116. Print Zero Even Odd</b></summary>
</details>

<details>
<summary><b>1117. Building H</b></summary>
</details>

<details>
<summary><b>1118. Number of Days in a Month</b></summary>
</details>

<details>
<summary><b>1119. Remove Vowels from a String</b></summary>
</details>

<details>
<summary><b>1120. Maximum Average Subtree</b></summary>
</details>

<details>
<summary><b>1121. Divide Array Into Increasing Sequences</b></summary>
</details>

<details>
<summary><b>1122. Relative Sort Array</b></summary>
</details>

<details>
<summary><b>1123. Lowest Common Ancestor of Deepest Leaves</b></summary>
</details>

<details>
<summary><b>1124. Longest Well-Performing Interval</b></summary>
</details>

<details>
<summary><b>1125. Smallest Sufficient Team</b></summary>
</details>

<details>
<summary><b>1126. Active Businesses</b></summary>
</details>

<details>
<summary><b>1127. User Purchase Platform</b></summary>
</details>

<details>
<summary><b>1128. Number of Equivalent Domino Pairs</b></summary>
</details>

<details>
<summary><b>1129. Shortest Path with Alternating Colors</b></summary>
</details>

<details>
<summary><b>1130. Minimum Cost Tree From Leaf Values</b></summary>
</details>

<details>
<summary><b>1131. Maximum of Absolute Value Expression</b></summary>
</details>

<details>
<summary><b>1132. Reported Posts II</b></summary>
</details>

<details>
<summary><b>1133. Largest Unique Number</b></summary>
</details>

<details>
<summary><b>1134. Armstrong Number</b></summary>
</details>

<details>
<summary><b>1135. Connecting Cities With Minimum Cost</b></summary>
</details>

<details>
<summary><b>1136. Parallel Courses</b></summary>
</details>

<details>
<summary><b>1137. N-th Tribonacci Number</b></summary>
</details>

<details>
<summary><b>1138. Alphabet Board Path</b></summary>
</details>

<details>
<summary><b>1139. Largest</b></summary>
</details>

<details>
<summary><b>1140. Stone Game II</b></summary>
</details>

<details>
<summary><b>1141. User Activity for the Past</b></summary>
</details>

<details>
<summary><b>1142. User Activity for the Past</b></summary>
</details>

<details>
<summary><b>1143. Longest Common Subsequence</b></summary>
</details>

<details>
<summary><b>1144. Decrease Elements To Make Array Zigzag</b></summary>
</details>

<details>
<summary><b>1145. Binary Tree Coloring Game</b></summary>
</details>

<details>
<summary><b>1146. Snapshot Array</b></summary>
</details>

<details>
<summary><b>1147. Longest Chunked Palindrome Decomposition</b></summary>
</details>

<details>
<summary><b>1148. Article Views I</b></summary>
</details>

<details>
<summary><b>1149. Article Views II</b></summary>
</details>

<details>
<summary><b>1150. Check If a Number Is Majority Element in a Sorted Array</b></summary>
</details>

<details>
<summary><b>1151. Minimum Swaps to Group All</b></summary>
</details>

<details>
<summary><b>1152. Analyze User Website Visit Pattern</b></summary>
</details>

<details>
<summary><b>1153. String Transforms Into Another String</b></summary>
</details>

<details>
<summary><b>1154. Day of the Year</b></summary>
</details>

<details>
<summary><b>1155. Number of Dice Rolls With Target Sum</b></summary>
</details>

<details>
<summary><b>1156. Swap For Longest Repeated Character Substring</b></summary>
</details>

<details>
<summary><b>1157. Online Majority Element In Subarray</b></summary>
</details>

<details>
<summary><b>1158. Market Analysis I</b></summary>
</details>

<details>
<summary><b>1159. Market Analysis II</b></summary>
</details>

<details>
<summary><b>1160. Find Words That Can Be Formed by Characters</b></summary>
</details>

<details>
<summary><b>1161. Maximum Level Sum of a Binary Tree</b></summary>
</details>

<details>
<summary><b>1162. As Far from Land as Possible</b></summary>
</details>

<details>
<summary><b>1163. Last Substring in Lexicographical Order</b></summary>
</details>

<details>
<summary><b>1164. Product Price at a Given Date</b></summary>
</details>

<details>
<summary><b>1165. Single-Row Keyboard</b></summary>
</details>

<details>
<summary><b>1166. Design File System</b></summary>
</details>

<details>
<summary><b>1167. Minimum Cost to Connect Sticks</b></summary>
</details>

<details>
<summary><b>1168. Optimize Water Distribution in a Village</b></summary>
</details>

<details>
<summary><b>1169. Invalid Transactions</b></summary>
</details>

<details>
<summary><b>1170. Compare Strings by Frequency of the Smallest Character</b></summary>
</details>

<details>
<summary><b>1171. Remove Zero Sum Consecutive Nodes from Linked List</b></summary>
</details>

<details>
<summary><b>1172. Dinner Plate Stacks</b></summary>
</details>

<details>
<summary><b>1173. Immediate Food Delivery I</b></summary>
</details>

<details>
<summary><b>1174. Immediate Food Delivery II</b></summary>
</details>

<details>
<summary><b>1175. Prime Arrangements</b></summary>
</details>

<details>
<summary><b>1176. Diet Plan Performance</b></summary>
</details>

<details>
<summary><b>1177. Can Make Palindrome from Substring</b></summary>
</details>

<details>
<summary><b>1178. Number of Valid Words for Each Puzzle</b></summary>
</details>

<details>
<summary><b>1179. Reformat Department Table</b></summary>
</details>

<details>
<summary><b>1180. Count Substrings with Only One Distinct Letter</b></summary>
</details>

<details>
<summary><b>1181. Before and After Puzzle</b></summary>
</details>

<details>
<summary><b>1182. Shortest Distance to Target Color</b></summary>
</details>

<details>
<summary><b>1183. Maximum Number of Ones</b></summary>
</details>

<details>
<summary><b>1184. Distance Between Bus Stops</b></summary>
</details>

<details>
<summary><b>1185. Day of the Week</b></summary>
</details>

<details>
<summary><b>1186. Maximum Subarray Sum with One Deletion</b></summary>
</details>

<details>
<summary><b>1187. Make Array Strictly Increasing</b></summary>
</details>

<details>
<summary><b>1188. Design Bounded Blocking Queue</b></summary>
</details>

<details>
<summary><b>1189. Maximum Number of Balloons</b></summary>
</details>

<details>
<summary><b>1190. Reverse Substrings Between Each Pair of Parentheses</b></summary>
</details>

<details>
<summary><b>1191. K-Concatenation Maximum Sum</b></summary>
</details>

<details>
<summary><b>1192. Critical Connections in a Network</b></summary>
</details>

<details>
<summary><b>1193. Monthly Transactions I</b></summary>
</details>

<details>
<summary><b>1194. Tournament Winners</b></summary>
</details>

<details>
<summary><b>1195. Fizz Buzz Multithreaded</b></summary>
</details>

<details>
<summary><b>1196. How Many Apples Can You Put into the Basket</b></summary>
</details>

<details>
<summary><b>1197. Minimum Knight Moves</b></summary>
</details>

<details>
<summary><b>1198. Find Smallest Common Element in All Rows</b></summary>
</details>

<details>
<summary><b>1199. Minimum Time to Build Blocks</b></summary>
</details>

<details>
<summary><b>1200. Minimum Absolute Difference</b></summary>
</details>

<details>
<summary><b>1201. Ugly Number III</b></summary>
</details>

<details>
<summary><b>1202. Smallest String With Swaps</b></summary>
</details>

<details>
<summary><b>1203. Sort Items by Groups Respecting Dependencies</b></summary>
</details>

<details>
<summary><b>1204. Last Person to Fit in the Bus</b></summary>
</details>

<details>
<summary><b>1205. Monthly Transactions II</b></summary>
</details>

<details>
<summary><b>1206. Design Skiplist</b></summary>
</details>

<details>
<summary><b>1207. Unique Number of Occurrences</b></summary>
</details>

<details>
<summary><b>1208. Get Equal Substrings Within Budget</b></summary>
</details>

<details>
<summary><b>1209. Remove All Adjacent Duplicates in String II</b></summary>
</details>

<details>
<summary><b>1210. Minimum Moves to Reach Target with Rotations</b></summary>
</details>

<details>
<summary><b>1211. Queries Quality and Percentage</b></summary>
</details>

<details>
<summary><b>1212. Team Scores in Football Tournament</b></summary>
</details>

<details>
<summary><b>1213. Intersection of Three Sorted Arrays</b></summary>
</details>

<details>
<summary><b>1214. Two Sum BSTs</b></summary>
</details>

<details>
<summary><b>1215. Stepping Numbers</b></summary>
</details>

<details>
<summary><b>1216. Valid Palindrome III</b></summary>
</details>

<details>
<summary><b>1217. Minimum Cost to Move Chips to The Same Position</b></summary>
</details>

<details>
<summary><b>1218. Longest Arithmetic Subsequence of Given Difference</b></summary>
</details>

<details>
<summary><b>1219. Path with Maximum Gold</b></summary>
</details>

<details>
<summary><b>1220. Count Vowels Permutation</b></summary>
</details>

<details>
<summary><b>1221. Split a String in Balanced Strings</b></summary>
</details>

<details>
<summary><b>1222. Queens That Can Attack the King</b></summary>
</details>

<details>
<summary><b>1223. Dice Roll Simulation</b></summary>
</details>

<details>
<summary><b>1224. Maximum Equal Frequency</b></summary>
</details>

<details>
<summary><b>1225. Report Contiguous Dates</b></summary>
</details>

<details>
<summary><b>1226. The Dining Philosophers</b></summary>
</details>

<details>
<summary><b>1227. Airplane Seat Assignment Probability</b></summary>
</details>

<details>
<summary><b>1228. Missing Number In Arithmetic Progression</b></summary>
</details>

<details>
<summary><b>1229. Meeting Scheduler</b></summary>
</details>

<details>
<summary><b>1230. Toss Strange Coins</b></summary>
</details>

<details>
<summary><b>1231. Divide Chocolate</b></summary>
</details>

<details>
<summary><b>1232. Check If It Is a Straight Line</b></summary>
</details>

<details>
<summary><b>1233. Remove Sub-Folders from the Filesystem</b></summary>
</details>

<details>
<summary><b>1234. Replace the Substring for Balanced String</b></summary>
</details>

<details>
<summary><b>1235. Maximum Profit in Job Scheduling</b></summary>
</details>

<details>
<summary><b>1236. Web Crawler</b></summary>
</details>

<details>
<summary><b>1237. Find Positive Integer Solution for a Given Equation</b></summary>
</details>

<details>
<summary><b>1238. Circular Permutation in Binary Representation</b></summary>
</details>

<details>
<summary><b>1239. Maximum Length of a Concatenated String with Unique Characters</b></summary>
</details>

<details>
<summary><b>1240. Tiling a Rectangle with the Fewest Squares</b></summary>
</details>

<details>
<summary><b>1241. Number of Comments per Post</b></summary>
</details>

<details>
<summary><b>1242. Web Crawler Multithreaded</b></summary>
</details>

<details>
<summary><b>1243. Array Transformation</b></summary>
</details>

<details>
<summary><b>1244. Design A Leaderboard</b></summary>
</details>

<details>
<summary><b>1245. Tree Diameter</b></summary>
</details>

<details>
<summary><b>1246. Palindrome Removal</b></summary>
</details>

<details>
<summary><b>1247. Minimum Swaps to Make Strings Equal</b></summary>
</details>

<details>
<summary><b>1248. Count Number of Nice Subarrays</b></summary>
</details>

<details>
<summary><b>1249. Minimum Remove to Make Valid Parentheses</b></summary>
</details>

<details>
<summary><b>1250. Check If It Is a Good Array</b></summary>
</details>

<details>
<summary><b>1251. Average Selling Price</b></summary>
</details>

<details>
<summary><b>1252. Cells with Odd Values in a Matrix</b></summary>
</details>

<details>
<summary><b>1253. Reconstruct a</b></summary>
</details>

<details>
<summary><b>1254. Number of Closed Islands</b></summary>
</details>

<details>
<summary><b>1255. Maximum Score Words Formed by Letters</b></summary>
</details>

<details>
<summary><b>1256. Encode Number</b></summary>
</details>

<details>
<summary><b>1257. Smallest Common Region</b></summary>
</details>

<details>
<summary><b>1258. Synonymous Sentences</b></summary>
</details>

<details>
<summary><b>1259. Handshakes That Don't Cross</b></summary>
</details>

<details>
<summary><b>1260. Shift</b></summary>
</details>

<details>
<summary><b>1261. Find Elements in a Contaminated Binary Tree</b></summary>
</details>

<details>
<summary><b>1262. Greatest Sum Divisible by Three</b></summary>
</details>

<details>
<summary><b>1263. Minimum Moves to Move a Box to Their Target Location</b></summary>
</details>

<details>
<summary><b>1264. Page Recommendations</b></summary>
</details>

<details>
<summary><b>1265. Print Immutable Linked List in Reverse</b></summary>
</details>

<details>
<summary><b>1266. Minimum Time Visiting All Points</b></summary>
</details>

<details>
<summary><b>1267. Count Servers that Communicate</b></summary>
</details>

<details>
<summary><b>1268. Search Suggestions System</b></summary>
</details>

<details>
<summary><b>1269. Number of Ways to Stay in the Same Place After Some Steps</b></summary>
</details>

<details>
<summary><b>1270. All People Report to the Given Manager</b></summary>
</details>

<details>
<summary><b>1271. Hexspeak</b></summary>
</details>

<details>
<summary><b>1272. Remove Interval</b></summary>
</details>

<details>
<summary><b>1273. Delete Tree Nodes</b></summary>
</details>

<details>
<summary><b>1274. Number of Ships in a Rectangle</b></summary>
</details>

<details>
<summary><b>1275. Find Winner on a Tic Tac Toe Game</b></summary>
</details>

<details>
<summary><b>1276. Number of Burgers with No Waste of Ingredients</b></summary>
</details>

<details>
<summary><b>1277. Count Square Submatrices with All Ones</b></summary>
</details>

<details>
<summary><b>1278. Palindrome Partitioning III</b></summary>
</details>

<details>
<summary><b>1279. Traffic Light Controlled Intersection</b></summary>
</details>

<details>
<summary><b>1280. Students and Examinations</b></summary>
</details>

<details>
<summary><b>1281. Subtract the Product and Sum of Digits of an Integer</b></summary>
</details>

<details>
<summary><b>1282. Group the People Given the Group Size They Belong To</b></summary>
</details>

<details>
<summary><b>1283. Find the Smallest Divisor Given a Threshold</b></summary>
</details>

<details>
<summary><b>1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix</b></summary>
</details>

<details>
<summary><b>1285. Find the Start and End Number of Continuous Ranges</b></summary>
</details>

<details>
<summary><b>1286. Iterator for Combination</b></summary>
</details>

<details>
<summary><b>1287. Element Appearing More Than</b></summary>
</details>

<details>
<summary><b>1288. Remove Covered Intervals</b></summary>
</details>

<details>
<summary><b>1289. Minimum Falling Path Sum II</b></summary>
</details>

<details>
<summary><b>1290. Convert Binary Number in a Linked List to Integer</b></summary>
</details>

<details>
<summary><b>1291. Sequential Digits</b></summary>
</details>

<details>
<summary><b>1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold</b></summary>
</details>

<details>
<summary><b>1293. Shortest Path in a Grid with Obstacles Elimination</b></summary>
</details>

<details>
<summary><b>1294. Weather Type in Each Country</b></summary>
</details>

<details>
<summary><b>1295. Find Numbers with Even Number of Digits</b></summary>
</details>

<details>
<summary><b>1296. Divide Array in Sets of K Consecutive Numbers</b></summary>
</details>

<details>
<summary><b>1297. Maximum Number of Occurrences of a Substring</b></summary>
</details>

<details>
<summary><b>1298. Maximum Candies You Can Get from Boxes</b></summary>
</details>

<details>
<summary><b>1299. Replace Elements with Greatest Element on Right Side</b></summary>
</details>

<details>
<summary><b>1300. Sum of Mutated Array Closest to Target</b></summary>
</details>

<details>
<summary><b>1301. Number of Paths with Max Score</b></summary>
</details>

<details>
<summary><b>1302. Deepest Leaves Sum</b></summary>
</details>

<details>
<summary><b>1303. Find the Team Size</b></summary>
</details>

<details>
<summary><b>1304. Find N Unique Integers Sum up to Zero</b></summary>
</details>

<details>
<summary><b>1305. All Elements in Two Binary Search Trees</b></summary>
</details>

<details>
<summary><b>1306. Jump Game III</b></summary>
</details>

<details>
<summary><b>1307. Verbal Arithmetic Puzzle</b></summary>
</details>

<details>
<summary><b>1308. Running Total for Different Genders</b></summary>
</details>

<details>
<summary><b>1309. Decrypt String from Alphabet to Integer Mapping</b></summary>
</details>

<details>
<summary><b>1310. XOR Queries of a Subarray</b></summary>
</details>

<details>
<summary><b>1311. Get Watched Videos by Your Friends</b></summary>
</details>

<details>
<summary><b>1312. Minimum Insertion Steps to Make a String Palindrome</b></summary>
</details>

<details>
<summary><b>1313. Decompress Run-Length Encoded List</b></summary>
</details>

<details>
<summary><b>1314. Matrix Block Sum</b></summary>
</details>

<details>
<summary><b>1315. Sum of Nodes with Even-Valued Grandparent</b></summary>
</details>

<details>
<summary><b>1316. Distinct Echo Substrings</b></summary>
</details>

<details>
<summary><b>1317. Convert Integer to the Sum of Two No-Zero Integers</b></summary>
</details>

<details>
<summary><b>1318. Minimum Flips to Make a OR b Equal to c</b></summary>
</details>

<details>
<summary><b>1319. Number of Operations to Make Network Connected</b></summary>
</details>

<details>
<summary><b>1320. Minimum Distance to Type a Word Using Two Fingers</b></summary>
</details>

<details>
<summary><b>1321. Restaurant Growth</b></summary>
</details>

<details>
<summary><b>1322. Ads Performance</b></summary>
</details>

<details>
<summary><b>1323. Maximum</b></summary>
</details>

<details>
<summary><b>1324. Print Words Vertically</b></summary>
</details>

<details>
<summary><b>1325. Delete Leaves With a Given Value</b></summary>
</details>

<details>
<summary><b>1326. Minimum Number of Taps to Open to Water a Garden</b></summary>
</details>

<details>
<summary><b>1327. List the Products Ordered in a Period</b></summary>
</details>

<details>
<summary><b>1328. Break a Palindrome</b></summary>
</details>

<details>
<summary><b>1329. Sort the Matrix Diagonally</b></summary>
</details>

<details>
<summary><b>1330. Reverse Subarray To Maximize Array Value</b></summary>
</details>

<details>
<summary><b>1331. Rank Transform of an Array</b></summary>
</details>

<details>
<summary><b>1332. Remove Palindromic Subsequences</b></summary>
</details>

<details>
<summary><b>1333. Filter Restaurants by Vegan-Friendly, Price and Distance</b></summary>
</details>

<details>
<summary><b>1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance</b></summary>
</details>

<details>
<summary><b>1335. Minimum Difficulty of a Job Schedule</b></summary>
</details>

<details>
<summary><b>1336. Number of Transactions per Visit</b></summary>
</details>

<details>
<summary><b>1337. The K Weakest Rows in a Matrix</b></summary>
</details>

<details>
<summary><b>1338. Reduce Array Size to The Half</b></summary>
</details>

<details>
<summary><b>1339. Maximum Product of Splitted Binary Tree</b></summary>
</details>

<details>
<summary><b>1340. Jump Game V</b></summary>
</details>

<details>
<summary><b>1341. Movie Rating</b></summary>
</details>

<details>
<summary><b>1342. Number of Steps to Reduce a Number to Zero</b></summary>
</details>

<details>
<summary><b>1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold</b></summary>
</details>

<details>
<summary><b>1344. Angle Between Hands of a Clock</b></summary>
</details>

<details>
<summary><b>1345. Jump Game IV</b></summary>
</details>

<details>
<summary><b>1346. Check If N and Its Double Exist</b></summary>
</details>

<details>
<summary><b>1347. Minimum Number of Steps to Make Two Strings Anagram</b></summary>
</details>

<details>
<summary><b>1348. Tweet Counts Per Frequency</b></summary>
</details>

<details>
<summary><b>1349. Maximum Students Taking Exam</b></summary>
</details>

<details>
<summary><b>1350. Students With Invalid Departments</b></summary>
</details>

<details>
<summary><b>1351. Count Negative Numbers in a Sorted Matrix</b></summary>
</details>

<details>
<summary><b>1352. Product of the Last K Numbers</b></summary>
</details>

<details>
<summary><b>1353. Maximum Number of Events That Can Be Attended</b></summary>
</details>

<details>
<summary><b>1354. Construct Target Array With Multiple Sums</b></summary>
</details>

<details>
<summary><b>1355. Activity Participants</b></summary>
</details>

<details>
<summary><b>1356. Sort Integers by The Number of</b></summary>
</details>

<details>
<summary><b>1357. Apply Discount Every n Orders</b></summary>
</details>

<details>
<summary><b>1358. Number of Substrings Containing All Three Characters</b></summary>
</details>

<details>
<summary><b>1359. Count All Valid Pickup and Delivery Options</b></summary>
</details>

<details>
<summary><b>1360. Number of Days Between Two Dates</b></summary>
</details>

<details>
<summary><b>1361. Validate Binary Tree Nodes</b></summary>
</details>

<details>
<summary><b>1362. Closest Divisors</b></summary>
</details>

<details>
<summary><b>1363. Largest Multiple of Three</b></summary>
</details>

<details>
<summary><b>1364. Number of Trusted Contacts of a Customer</b></summary>
</details>

<details>
<summary><b>1365. How Many Numbers Are Smaller Than the Current Number</b></summary>
</details>

<details>
<summary><b>1366. Rank Teams by Votes</b></summary>
</details>

<details>
<summary><b>1367. Linked List in Binary Tree</b></summary>
</details>

<details>
<summary><b>1368. Minimum Cost to Make at Least One Valid Path in a Grid</b></summary>
</details>

<details>
<summary><b>1369. Get the Second Most Recent Activity</b></summary>
</details>

<details>
<summary><b>1370. Increasing Decreasing String</b></summary>
</details>

<details>
<summary><b>1371. Find the Longest Substring Containing Vowels in Even Counts</b></summary>
</details>

<details>
<summary><b>1372. Longest ZigZag Path in a Binary Tree</b></summary>
</details>

<details>
<summary><b>1373. Maximum Sum BST in Binary Tree</b></summary>
</details>

<details>
<summary><b>1374. Generate a String With Characters That Have Odd Counts</b></summary>
</details>

<details>
<summary><b>1375. Number of Times Binary String Is Prefix-Aligned</b></summary>
</details>

<details>
<summary><b>1376. Time Needed to Inform All Employees</b></summary>
</details>

<details>
<summary><b>1377. Frog Position After T Seconds</b></summary>
</details>

<details>
<summary><b>1378. Replace Employee ID With The Unique Identifier</b></summary>
</details>

<details>
<summary><b>1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree</b></summary>
</details>

<details>
<summary><b>1380. Lucky Numbers in a Matrix</b></summary>
</details>

<details>
<summary><b>1381. Design a Stack With Increment Operation</b></summary>
</details>

<details>
<summary><b>1382. Balance a Binary Search Tree</b></summary>
</details>

<details>
<summary><b>1383. Maximum Performance of a Team</b></summary>
</details>

<details>
<summary><b>1384. Total Sales Amount by Year</b></summary>
</details>

<details>
<summary><b>1385. Find the Distance Value Between Two Arrays</b></summary>
</details>

<details>
<summary><b>1386. Cinema Seat Allocation</b></summary>
</details>

<details>
<summary><b>1387. Sort Integers by The Power Value</b></summary>
</details>

<details>
<summary><b>1388. Pizza With</b></summary>
</details>

<details>
<summary><b>1389. Create Target Array in the Given Order</b></summary>
</details>

<details>
<summary><b>1390. Four Divisors</b></summary>
</details>

<details>
<summary><b>1391. Check if There is a Valid Path in a Grid</b></summary>
</details>

<details>
<summary><b>1392. Longest Happy Prefix</b></summary>
</details>

<details>
<summary><b>1393. Capital Gain/Loss</b></summary>
</details>

<details>
<summary><b>1394. Find Lucky Integer in an Array</b></summary>
</details>

<details>
<summary><b>1395. Count Number of Teams</b></summary>
</details>

<details>
<summary><b>1396. Design Underground System</b></summary>
</details>

<details>
<summary><b>1397. Find All Good Strings</b></summary>
</details>

<details>
<summary><b>1398. Customers Who Bought Products A and B but Not C</b></summary>
</details>

<details>
<summary><b>1399. Count Largest Group</b></summary>
</details>

<details>
<summary><b>1400. Construct K Palindrome Strings</b></summary>
</details>

<details>
<summary><b>1401. Circle and Rectangle Overlapping</b></summary>
</details>

<details>
<summary><b>1402. Reducing Dishes</b></summary>
</details>

<details>
<summary><b>1403. Minimum Subsequence in Non-Increasing Order</b></summary>
</details>

<details>
<summary><b>1404. Number of Steps to Reduce a Number in Binary Representation to One</b></summary>
</details>

<details>
<summary><b>1405. Longest Happy String</b></summary>
</details>

<details>
<summary><b>1406. Stone Game III</b></summary>
</details>

<details>
<summary><b>1407. Top Travellers</b></summary>
</details>

<details>
<summary><b>1408. String Matching in an Array</b></summary>
</details>

<details>
<summary><b>1409. Queries on a Permutation With Key</b></summary>
</details>

<details>
<summary><b>1410. HTML Entity Parser</b></summary>
</details>

<details>
<summary><b>1411. Number of Ways to Paint N ×</b></summary>
</details>

<details>
<summary><b>1412. Find the Quiet Students in All Exams</b></summary>
</details>

<details>
<summary><b>1413. Minimum Value to Get Positive Step by Step Sum</b></summary>
</details>

<details>
<summary><b>1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K</b></summary>
</details>

<details>
<summary><b>1415. The k-th Lexicographical String of All Happy Strings of Length n</b></summary>
</details>

<details>
<summary><b>1416. Restore The Array</b></summary>
</details>

<details>
<summary><b>1417. Reformat The String</b></summary>
</details>

<details>
<summary><b>1418. Display Table of Food Orders in a Restaurant</b></summary>
</details>

<details>
<summary><b>1419. Minimum Number of Frogs Croaking</b></summary>
</details>

<details>
<summary><b>1420. Build Array Where You Can Find The Maximum Exactly K Comparisons</b></summary>
</details>

<details>
<summary><b>1421. NPV Queries</b></summary>
</details>

<details>
<summary><b>1422. Maximum Score After Splitting a String</b></summary>
</details>

<details>
<summary><b>1423. Maximum Points You Can Obtain from Cards</b></summary>
</details>

<details>
<summary><b>1424. Diagonal Traverse II</b></summary>
</details>

<details>
<summary><b>1425. Constrained Subsequence Sum</b></summary>
</details>

<details>
<summary><b>1426. Counting Elements</b></summary>
</details>

<details>
<summary><b>1427. Perform String Shifts</b></summary>
</details>

<details>
<summary><b>1428. Leftmost Column with at Least a One</b></summary>
</details>

<details>
<summary><b>1429. First Unique Number</b></summary>
</details>

<details>
<summary><b>1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree</b></summary>
</details>

<details>
<summary><b>1431. Kids With the Greatest Number of Candies</b></summary>
</details>

<details>
<summary><b>1432. Max Difference You Can Get From Changing an Integer</b></summary>
</details>

<details>
<summary><b>1433. Check If a String Can Break Another String</b></summary>
</details>

<details>
<summary><b>1434. Number of Ways to Wear Different Hats to Each Other</b></summary>
</details>

<details>
<summary><b>1435. Create a Session Bar Chart</b></summary>
</details>

<details>
<summary><b>1436. Destination City</b></summary>
</details>

<details>
<summary><b>1437. Check If All</b></summary>
</details>

<details>
<summary><b>1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</b></summary>
</details>

<details>
<summary><b>1439. Find the Kth Smallest Sum of a Matrix With Sorted Rows</b></summary>
</details>

<details>
<summary><b>1440. Evaluate Boolean Expression</b></summary>
</details>

<details>
<summary><b>1441. Build an Array With Stack Operations</b></summary>
</details>

<details>
<summary><b>1442. Count Triplets That Can Form Two Arrays of Equal XOR</b></summary>
</details>

<details>
<summary><b>1443. Minimum Time to Collect All Apples in a Tree</b></summary>
</details>

<details>
<summary><b>1444. Number of Ways of Cutting a Pizza</b></summary>
</details>

<details>
<summary><b>1445. Apples & Oranges</b></summary>
</details>

<details>
<summary><b>1446. Consecutive Characters</b></summary>
</details>

<details>
<summary><b>1447. Simplified Fractions</b></summary>
</details>

<details>
<summary><b>1448. Count Good Nodes in Binary Tree</b></summary>
</details>

<details>
<summary><b>1449. Form Largest Integer With Digits That Add up to Target</b></summary>
</details>

<details>
<summary><b>1450. Number of Students Doing Homework at a Given Time</b></summary>
</details>

<details>
<summary><b>1451. Rearrange Words in a Sentence</b></summary>
</details>

<details>
<summary><b>1452. People Whose List of Favorite Companies Is Not a Subset of Another List</b></summary>
</details>

<details>
<summary><b>1453. Maximum Number of Darts Inside of a Circular Dartboard</b></summary>
</details>

<details>
<summary><b>1454. Active Users</b></summary>
</details>

<details>
<summary><b>1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence</b></summary>
</details>

<details>
<summary><b>1456. Maximum Number of Vowels in a Substring of Given Length</b></summary>
</details>

<details>
<summary><b>1457. Pseudo-Palindromic Paths in a Binary Tree</b></summary>
</details>

<details>
<summary><b>1458. Max Dot Product of Two Subsequences</b></summary>
</details>

<details>
<summary><b>1459. Rectangles Area</b></summary>
</details>

<details>
<summary><b>1460. Make Two Arrays Equal by Reversing Subarrays</b></summary>
</details>

<details>
<summary><b>1461. Check If a String Contains All Binary Codes of Size K</b></summary>
</details>

<details>
<summary><b>1462. Course Schedule IV</b></summary>
</details>

<details>
<summary><b>1463. Cherry Pickup II</b></summary>
</details>

<details>
<summary><b>1464. Maximum Product of Two Elements in an Array</b></summary>
</details>

<details>
<summary><b>1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts</b></summary>
</details>

<details>
<summary><b>1466. Reorder Routes to Make All Paths Lead to the City Zero</b></summary>
</details>

<details>
<summary><b>1467. Probability of a Two Boxes Having The Same Number of Distinct Balls</b></summary>
</details>

<details>
<summary><b>1468. Calculate Salaries</b></summary>
</details>

<details>
<summary><b>1469. Find All The Lonely Nodes</b></summary>
</details>

<details>
<summary><b>1470. Shuffle the Array</b></summary>
</details>

<details>
<summary><b>1471. The k Strongest Values in an Array</b></summary>
</details>

<details>
<summary><b>1472. Design Browser History</b></summary>
</details>

<details>
<summary><b>1473. Paint House III</b></summary>
</details>

<details>
<summary><b>1474. Delete N Nodes After M Nodes of a Linked List</b></summary>
</details>

<details>
<summary><b>1475. Final Prices With a Special Discount in a Shop</b></summary>
</details>

<details>
<summary><b>1476. Subrectangle Queries</b></summary>
</details>

<details>
<summary><b>1477. Find Two Non-overlapping Sub-arrays Each With Target Sum</b></summary>
</details>

<details>
<summary><b>1478. Allocate Mailboxes</b></summary>
</details>

<details>
<summary><b>1479. Sales by Day of the Week</b></summary>
</details>

<details>
<summary><b>1480. Running Sum of</b></summary>
</details>

<details>
<summary><b>1481. Least Number of Unique Integers after K Removals</b></summary>
</details>

<details>
<summary><b>1482. Minimum Number of Days to Make m Bouquets</b></summary>
</details>

<details>
<summary><b>1483. Kth Ancestor of a Tree Node</b></summary>
</details>

<details>
<summary><b>1484. Group Sold Products By The Date</b></summary>
</details>

<details>
<summary><b>1485. Clone Binary Tree With Random Pointer</b></summary>
</details>

<details>
<summary><b>1486. XOR Operation in an Array</b></summary>
</details>

<details>
<summary><b>1487. Making File Names Unique</b></summary>
</details>

<details>
<summary><b>1488. Avoid Flood in The City</b></summary>
</details>

<details>
<summary><b>1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree</b></summary>
</details>

<details>
<summary><b>1490. Clone N-ary Tree</b></summary>
</details>

<details>
<summary><b>1491. Average Salary Excluding the Minimum and Maximum Salary</b></summary>
</details>

<details>
<summary><b>1492. The kth Factor of n</b></summary>
</details>

<details>
<summary><b>1493. Longest Subarray of</b></summary>
</details>

<details>
<summary><b>1494. Parallel Courses II</b></summary>
</details>

<details>
<summary><b>1495. Friendly Movies Streamed Last Month</b></summary>
</details>

<details>
<summary><b>1496. Path Crossing</b></summary>
</details>

<details>
<summary><b>1497. Check If Array Pairs Are Divisible by k</b></summary>
</details>

<details>
<summary><b>1498. Number of Subsequences That Satisfy the Given Sum Condition</b></summary>
</details>

<details>
<summary><b>1499. Max Value of Equation</b></summary>
</details>

<details>
<summary><b>1500. Design a File Sharing System</b></summary>
</details>

<details>
<summary><b>1501. Countries You Can Safely Invest In</b></summary>
</details>

<details>
<summary><b>1502. Can Make Arithmetic Progression From Sequence</b></summary>
</details>

<details>
<summary><b>1503. Last Moment Before All Ants Fall Out of a Plank</b></summary>
</details>

<details>
<summary><b>1504. Count Submatrices With All Ones</b></summary>
</details>

<details>
<summary><b>1505. Minimum Possible Integer After at Most K Adjacent Swaps On Digits</b></summary>
</details>

<details>
<summary><b>1506. Find Root of N-Ary Tree</b></summary>
</details>

<details>
<summary><b>1507. Reformat Date</b></summary>
</details>

<details>
<summary><b>1508. Range Sum of Sorted Subarray Sums</b></summary>
</details>

<details>
<summary><b>1509. Minimum Difference Between Largest and Smallest Value in Three Moves</b></summary>
</details>

<details>
<summary><b>1510. Stone Game IV</b></summary>
</details>

<details>
<summary><b>1511. Customer Order Frequency</b></summary>
</details>

<details>
<summary><b>1512. Number of Good Pairs</b></summary>
</details>

<details>
<summary><b>1513. Number of Substrings With Only</b></summary>
</details>

<details>
<summary><b>1514. Path with Maximum Probability</b></summary>
</details>

<details>
<summary><b>1515. Best Position for a Service Centre</b></summary>
</details>

<details>
<summary><b>1516. Move Sub-Tree of N-Ary Tree</b></summary>
</details>

<details>
<summary><b>1517. Find Users With Valid E-Mails</b></summary>
</details>

<details>
<summary><b>1518. Water Bottles</b></summary>
</details>

<details>
<summary><b>1519. Number of Nodes in the Sub-Tree With the Same Label</b></summary>
</details>

<details>
<summary><b>1520. Maximum Number of Non-Overlapping Substrings</b></summary>
</details>

<details>
<summary><b>1521. Find a Value of a Mysterious Function Closest to Target</b></summary>
</details>

<details>
<summary><b>1522. Diameter of N-Ary Tree</b></summary>
</details>

<details>
<summary><b>1523. Count Odd Numbers in an Interval Range</b></summary>
</details>

<details>
<summary><b>1524. Number of Sub-arrays With Odd Sum</b></summary>
</details>

<details>
<summary><b>1525. Number of Good Ways to Split a String</b></summary>
</details>

<details>
<summary><b>1526. Minimum Number of Increments on Subarrays to Form a Target Array</b></summary>
</details>

<details>
<summary><b>1527. Patients With a Condition</b></summary>
</details>

<details>
<summary><b>1528. Shuffle String</b></summary>
</details>

<details>
<summary><b>1529. Minimum Suffix Flips</b></summary>
</details>

<details>
<summary><b>1530. Number of Good Leaf Nodes Pairs</b></summary>
</details>

<details>
<summary><b>1531. String Compression II</b></summary>
</details>

<details>
<summary><b>1532. The Most Recent Three Orders</b></summary>
</details>

<details>
<summary><b>1533. Find the Index of the Large Integer</b></summary>
</details>

<details>
<summary><b>1534. Count Good Triplets</b></summary>
</details>

<details>
<summary><b>1535. Find the Winner of an Array Game</b></summary>
</details>

<details>
<summary><b>1536. Minimum Swaps to Arrange a Binary Grid</b></summary>
</details>

<details>
<summary><b>1537. Get the Maximum Score</b></summary>
</details>

<details>
<summary><b>1538. Guess the Majority in a Hidden Array</b></summary>
</details>

<details>
<summary><b>1539. Kth Missing Positive Number</b></summary>
</details>

<details>
<summary><b>1540. Can Convert String in K Moves</b></summary>
</details>

<details>
<summary><b>1541. Minimum Insertions to Balance a Parentheses String</b></summary>
</details>

<details>
<summary><b>1542. Find Longest Awesome Substring</b></summary>
</details>

<details>
<summary><b>1543. Fix Product Name Format</b></summary>
</details>

<details>
<summary><b>1544. Make The String Great</b></summary>
</details>

<details>
<summary><b>1545. Find Kth Bit in Nth Binary String</b></summary>
</details>

<details>
<summary><b>1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target</b></summary>
</details>

<details>
<summary><b>1547. Minimum Cost to Cut a Stick</b></summary>
</details>

<details>
<summary><b>1548. The Most Similar Path in a Graph</b></summary>
</details>

<details>
<summary><b>1549. The Most Recent Orders for Each Product</b></summary>
</details>

<details>
<summary><b>1550. Three Consecutive Odds</b></summary>
</details>

<details>
<summary><b>1551. Minimum Operations to Make Array Equal</b></summary>
</details>

<details>
<summary><b>1552. Magnetic Force Between Two Balls</b></summary>
</details>

<details>
<summary><b>1553. Minimum Number of Days to Eat N Oranges</b></summary>
</details>

<details>
<summary><b>1554. Strings Differ by One Character</b></summary>
</details>

<details>
<summary><b>1555. Bank Account Summary</b></summary>
</details>

<details>
<summary><b>1556. Thousand Separator</b></summary>
</details>

<details>
<summary><b>1557. Minimum Number of Vertices to Reach All Nodes</b></summary>
</details>

<details>
<summary><b>1558. Minimum Numbers of Function Calls to Make Target Array</b></summary>
</details>

<details>
<summary><b>1559. Detect Cycles in</b></summary>
</details>

<details>
<summary><b>1560. Most Visited Sector in a Circular Track</b></summary>
</details>

<details>
<summary><b>1561. Maximum Number of Coins You Can Get</b></summary>
</details>

<details>
<summary><b>1562. Find Latest Group of Size M</b></summary>
</details>

<details>
<summary><b>1563. Stone Game V</b></summary>
</details>

<details>
<summary><b>1564. Put Boxes Into the Warehouse I</b></summary>
</details>

<details>
<summary><b>1565. Unique Orders and Customers Per Month</b></summary>
</details>

<details>
<summary><b>1566. Detect Pattern of Length M Repeated K or More Times</b></summary>
</details>

<details>
<summary><b>1567. Maximum Length of Subarray With Positive Product</b></summary>
</details>

<details>
<summary><b>1568. Minimum Number of Days to Disconnect Island</b></summary>
</details>

<details>
<summary><b>1569. Number of Ways to Reorder Array to Get Same BST</b></summary>
</details>

<details>
<summary><b>1570. Dot Product of Two Sparse Vectors</b></summary>
</details>

<details>
<summary><b>1571. Warehouse Manager</b></summary>
</details>

<details>
<summary><b>1572. Matrix Diagonal Sum</b></summary>
</details>

<details>
<summary><b>1573. Number of Ways to Split a String</b></summary>
</details>

<details>
<summary><b>1574. Shortest Subarray to be Removed to Make Array Sorted</b></summary>
</details>

<details>
<summary><b>1575. Count All Possible Routes</b></summary>
</details>

<details>
<summary><b>1576. Replace All ?'s to Avoid Consecutive Repeating Characters</b></summary>
</details>

<details>
<summary><b>1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers</b></summary>
</details>

<details>
<summary><b>1578. Minimum Time to Make Rope Colorful</b></summary>
</details>

<details>
<summary><b>1579. Remove Max Number of Edges to Keep Graph Fully Traversable</b></summary>
</details>

<details>
<summary><b>1580. Put Boxes Into the Warehouse II</b></summary>
</details>

<details>
<summary><b>1581. Customer Who Visited but Did Not Make Any Transactions</b></summary>
</details>

<details>
<summary><b>1582. Special Positions in a Binary Matrix</b></summary>
</details>

<details>
<summary><b>1583. Count Unhappy Friends</b></summary>
</details>

<details>
<summary><b>1584. Min Cost to Connect All Points</b></summary>
</details>

<details>
<summary><b>1585. Check If String Is Transformable With Substring Sort Operations</b></summary>
</details>

<details>
<summary><b>1586. Binary Search Tree Iterator II</b></summary>
</details>

<details>
<summary><b>1587. Bank Account Summary II</b></summary>
</details>

<details>
<summary><b>1588. Sum of All Odd Length Subarrays</b></summary>
</details>

<details>
<summary><b>1589. Maximum Sum Obtained of Any Permutation</b></summary>
</details>

<details>
<summary><b>1590. Make Sum Divisible by P</b></summary>
</details>

<details>
<summary><b>1591. Strange Printer II</b></summary>
</details>

<details>
<summary><b>1592. Rearrange Spaces Between Words</b></summary>
</details>

<details>
<summary><b>1593. Split a String Into the Max Number of Unique Substrings</b></summary>
</details>

<details>
<summary><b>1594. Maximum Non Negative Product in a Matrix</b></summary>
</details>

<details>
<summary><b>1595. Minimum Cost to Connect Two Groups of Points</b></summary>
</details>

<details>
<summary><b>1596. The Most Frequently Ordered Products for Each Customer</b></summary>
</details>

<details>
<summary><b>1597. Build Binary Expression Tree From Infix Expression</b></summary>
</details>

<details>
<summary><b>1598. Crawler Log Folder</b></summary>
</details>

<details>
<summary><b>1599. Maximum Profit of Operating a Centennial Wheel</b></summary>
</details>

<details>
<summary><b>1600. Throne Inheritance</b></summary>
</details>

<details>
<summary><b>1601. Maximum Number of Achievable Transfer Requests</b></summary>
</details>

<details>
<summary><b>1602. Find Nearest Right Node in Binary Tree</b></summary>
</details>

<details>
<summary><b>1603. Design Parking System</b></summary>
</details>

<details>
<summary><b>1604. Alert Using Same Key-Card Three or More Times in a One Hour Period</b></summary>
</details>

<details>
<summary><b>1605. Find Valid Matrix Given Row and Column Sums</b></summary>
</details>

<details>
<summary><b>1606. Find Servers That Handled Most Number of Requests</b></summary>
</details>

<details>
<summary><b>1607. Sellers With No Sales</b></summary>
</details>

<details>
<summary><b>1608. Special Array With X Elements Greater Than or Equal X</b></summary>
</details>

<details>
<summary><b>1609. Even Odd Tree</b></summary>
</details>

<details>
<summary><b>1610. Maximum Number of Visible Points</b></summary>
</details>

<details>
<summary><b>1611. Minimum One Bit Operations to Make Integers Zero</b></summary>
</details>

<details>
<summary><b>1612. Check If Two Expression Trees are Equivalent</b></summary>
</details>

<details>
<summary><b>1613. Find the Missing IDs</b></summary>
</details>

<details>
<summary><b>1614. Maximum Nesting Depth of the Parentheses</b></summary>
</details>

<details>
<summary><b>1615. Maximal Network Rank</b></summary>
</details>

<details>
<summary><b>1616. Split Two Strings to Make Palindrome</b></summary>
</details>

<details>
<summary><b>1617. Count Subtrees With Max Distance Between Cities</b></summary>
</details>

<details>
<summary><b>1618. Maximum Font to Fit a Sentence in a Screen</b></summary>
</details>

<details>
<summary><b>1619. Mean of Array After Removing Some Elements</b></summary>
</details>

<details>
<summary><b>1620. Coordinate With Maximum Network Quality</b></summary>
</details>

<details>
<summary><b>1621. Number of Sets of K Non-Overlapping Line Segments</b></summary>
</details>

<details>
<summary><b>1622. Fancy Sequence</b></summary>
</details>

<details>
<summary><b>1623. All Valid Triplets That Can Represent a Country</b></summary>
</details>

<details>
<summary><b>1624. Largest Substring Between Two Equal Characters</b></summary>
</details>

<details>
<summary><b>1625. Lexicographically Smallest String After Applying Operations</b></summary>
</details>

<details>
<summary><b>1626. Best Team With No Conflicts</b></summary>
</details>

<details>
<summary><b>1627. Graph Connectivity With Threshold</b></summary>
</details>

<details>
<summary><b>1628. Design an Expression Tree With Evaluate Function</b></summary>
</details>

<details>
<summary><b>1629. Slowest Key</b></summary>
</details>

<details>
<summary><b>1630. Arithmetic Subarrays</b></summary>
</details>

<details>
<summary><b>1631. Path With Minimum Effort</b></summary>
</details>

<details>
<summary><b>1632. Rank Transform of a Matrix</b></summary>
</details>

<details>
<summary><b>1633. Percentage of Users Attended a Contest</b></summary>
</details>

<details>
<summary><b>1634. Add Two Polynomials Represented as Linked Lists</b></summary>
</details>

<details>
<summary><b>1635. Hopper Company Queries I</b></summary>
</details>

<details>
<summary><b>1636. Sort Array by Increasing Frequency</b></summary>
</details>

<details>
<summary><b>1637. Widest Vertical Area Between Two Points Containing No Points</b></summary>
</details>

<details>
<summary><b>1638. Count Substrings That Differ by One Character</b></summary>
</details>

<details>
<summary><b>1639. Number of Ways to Form a Target String Given a Dictionary</b></summary>
</details>

<details>
<summary><b>1640. Check Array Formation Through Concatenation</b></summary>
</details>

<details>
<summary><b>1641. Count Sorted Vowel Strings</b></summary>
</details>

<details>
<summary><b>1642. Furthest Building You Can Reach</b></summary>
</details>

<details>
<summary><b>1643. Kth Smallest Instructions</b></summary>
</details>

<details>
<summary><b>1644. Lowest Common Ancestor of a Binary Tree II</b></summary>
</details>

<details>
<summary><b>1645. Hopper Company Queries II</b></summary>
</details>

<details>
<summary><b>1646. Get Maximum in Generated Array</b></summary>
</details>

<details>
<summary><b>1647. Minimum Deletions to Make Character Frequencies Unique</b></summary>
</details>

<details>
<summary><b>1648. Sell Diminishing-Valued Colored Balls</b></summary>
</details>

<details>
<summary><b>1649. Create Sorted Array through Instructions</b></summary>
</details>

<details>
<summary><b>1650. Lowest Common Ancestor of a Binary Tree III</b></summary>
</details>

<details>
<summary><b>1651. Hopper Company Queries III</b></summary>
</details>

<details>
<summary><b>1652. Defuse the Bomb</b></summary>
</details>

<details>
<summary><b>1653. Minimum Deletions to Make String Balanced</b></summary>
</details>

<details>
<summary><b>1654. Minimum Jumps to Reach Home</b></summary>
</details>

<details>
<summary><b>1655. Distribute Repeating Integers</b></summary>
</details>

<details>
<summary><b>1656. Design an Ordered Stream</b></summary>
</details>

<details>
<summary><b>1657. Determine if Two Strings Are Close</b></summary>
</details>

<details>
<summary><b>1658. Minimum Operations to Reduce X to Zero</b></summary>
</details>

<details>
<summary><b>1659. Maximize Grid Happiness</b></summary>
</details>

<details>
<summary><b>1660. Correct a Binary Tree</b></summary>
</details>

<details>
<summary><b>1661. Average Time of Process per Machine</b></summary>
</details>

<details>
<summary><b>1662. Check If Two String Arrays are Equivalent</b></summary>
</details>

<details>
<summary><b>1663. Smallest String With A Given Numeric Value</b></summary>
</details>

<details>
<summary><b>1664. Ways to Make a Fair Array</b></summary>
</details>

<details>
<summary><b>1665. Minimum Initial Energy to Finish Tasks</b></summary>
</details>

<details>
<summary><b>1666. Change the Root of a Binary Tree</b></summary>
</details>

<details>
<summary><b>1667. Fix Names in a Table</b></summary>
</details>

<details>
<summary><b>1668. Maximum Repeating Substring</b></summary>
</details>

<details>
<summary><b>1669. Merge In Between Linked Lists</b></summary>
</details>

<details>
<summary><b>1670. Design Front Middle Back Queue</b></summary>
</details>

<details>
<summary><b>1671. Minimum Number of Removals to Make Mountain Array</b></summary>
</details>

<details>
<summary><b>1672. Richest Customer Wealth</b></summary>
</details>

<details>
<summary><b>1673. Find the Most Competitive Subsequence</b></summary>
</details>

<details>
<summary><b>1674. Minimum Moves to Make Array Complementary</b></summary>
</details>

<details>
<summary><b>1675. Minimize Deviation in Array</b></summary>
</details>

<details>
<summary><b>1676. Lowest Common Ancestor of a Binary Tree IV</b></summary>
</details>

<details>
<summary><b>1677. Product's Worth Over Invoices</b></summary>
</details>

<details>
<summary><b>1678. Goal Parser Interpretation</b></summary>
</details>

<details>
<summary><b>1679. Max Number of K-Sum Pairs</b></summary>
</details>

<details>
<summary><b>1680. Concatenation of Consecutive Binary Numbers</b></summary>
</details>

<details>
<summary><b>1681. Minimum Incompatibility</b></summary>
</details>

<details>
<summary><b>1682. Longest Palindromic Subsequence II</b></summary>
</details>

<details>
<summary><b>1683. Invalid Tweets</b></summary>
</details>

<details>
<summary><b>1684. Count the Number of Consistent Strings</b></summary>
</details>

<details>
<summary><b>1685. Sum of Absolute Differences in a Sorted Array</b></summary>
</details>

<details>
<summary><b>1686. Stone Game VI</b></summary>
</details>

<details>
<summary><b>1687. Delivering Boxes from Storage to Ports</b></summary>
</details>

<details>
<summary><b>1688. Count of Matches in Tournament</b></summary>
</details>

<details>
<summary><b>1689. Partitioning Into Minimum Number Of Deci-Binary Numbers</b></summary>
</details>

<details>
<summary><b>1690. Stone Game VII</b></summary>
</details>

<details>
<summary><b>1691. Maximum Height by Stacking Cuboids</b></summary>
</details>

<details>
<summary><b>1692. Count Ways to Distribute Candies</b></summary>
</details>

<details>
<summary><b>1693. Daily Leads and Partners</b></summary>
</details>

<details>
<summary><b>1694. Reformat Phone Number</b></summary>
</details>

<details>
<summary><b>1695. Maximum Erasure Value</b></summary>
</details>

<details>
<summary><b>1696. Jump Game VI</b></summary>
</details>

<details>
<summary><b>1697. Checking Existence of Edge Length Limited Paths</b></summary>
</details>

<details>
<summary><b>1698. Number of Distinct Substrings in a String</b></summary>
</details>

<details>
<summary><b>1699. Number of Calls Between Two Persons</b></summary>
</details>

<details>
<summary><b>1700. Number of Students Unable to Eat Lunch</b></summary>
</details>

<details>
<summary><b>1701. Average Waiting Time</b></summary>
</details>

<details>
<summary><b>1702. Maximum Binary String After Change</b></summary>
</details>

<details>
<summary><b>1703. Minimum Adjacent Swaps for K Consecutive Ones</b></summary>
</details>

<details>
<summary><b>1704. Determine if String Halves Are Alike</b></summary>
</details>

<details>
<summary><b>1705. Maximum Number of Eaten Apples</b></summary>
</details>

<details>
<summary><b>1706. Where Will the Ball Fall</b></summary>
</details>

<details>
<summary><b>1707. Maximum XOR With an Element From Array</b></summary>
</details>

<details>
<summary><b>1708. Largest Subarray Length K</b></summary>
</details>

<details>
<summary><b>1709. Biggest Window Between Visits</b></summary>
</details>

<details>
<summary><b>1710. Maximum Units on a Truck</b></summary>
</details>

<details>
<summary><b>1711. Count Good Meals</b></summary>
</details>

<details>
<summary><b>1712. Ways to Split Array Into Three Subarrays</b></summary>
</details>

<details>
<summary><b>1713. Minimum Operations to Make a Subsequence</b></summary>
</details>

<details>
<summary><b>1714. Sum Of Special Evenly-Spaced Elements In Array</b></summary>
</details>

<details>
<summary><b>1715. Count Apples and Oranges</b></summary>
</details>

<details>
<summary><b>1716. Calculate Money in Leetcode Bank</b></summary>
</details>

<details>
<summary><b>1717. Maximum Score From Removing Substrings</b></summary>
</details>

<details>
<summary><b>1718. Construct the Lexicographically Largest Valid Sequence</b></summary>
</details>

<details>
<summary><b>1719. Number Of Ways To Reconstruct A Tree</b></summary>
</details>

<details>
<summary><b>1720. Decode XORed Array</b></summary>
</details>

<details>
<summary><b>1721. Swapping Nodes in a Linked List</b></summary>
</details>

<details>
<summary><b>1722. Minimize Hamming Distance After Swap Operations</b></summary>
</details>

<details>
<summary><b>1723. Find Minimum Time to Finish All Jobs</b></summary>
</details>

<details>
<summary><b>1724. Checking Existence of Edge Length Limited Paths II</b></summary>
</details>

<details>
<summary><b>1725. Number Of Rectangles That Can Form The Largest Square</b></summary>
</details>

<details>
<summary><b>1726. Tuple with Same Product</b></summary>
</details>

<details>
<summary><b>1727. Largest Submatrix With Rearrangements</b></summary>
</details>

<details>
<summary><b>1728. Cat and Mouse II</b></summary>
</details>

<details>
<summary><b>1729. Find Followers Count</b></summary>
</details>

<details>
<summary><b>1730. Shortest Path to Get Food</b></summary>
</details>

<details>
<summary><b>1731. The Number of Employees Which Report to Each Employee</b></summary>
</details>

<details>
<summary><b>1732. Find the Highest Altitude</b></summary>
</details>

<details>
<summary><b>1733. Minimum Number of People to Teach</b></summary>
</details>

<details>
<summary><b>1734. Decode XORed Permutation</b></summary>
</details>

<details>
<summary><b>1735. Count Ways to Make Array With Product</b></summary>
</details>

<details>
<summary><b>1736. Latest Time by Replacing Hidden Digits</b></summary>
</details>

<details>
<summary><b>1737. Change Minimum Characters to Satisfy One of Three Conditions</b></summary>
</details>

<details>
<summary><b>1738. Find Kth Largest XOR Coordinate Value</b></summary>
</details>

<details>
<summary><b>1739. Building Boxes</b></summary>
</details>

<details>
<summary><b>1740. Find Distance in a Binary Tree</b></summary>
</details>

<details>
<summary><b>1741. Find Total Time Spent by Each Employee</b></summary>
</details>

<details>
<summary><b>1742. Maximum Number of Balls in a Box</b></summary>
</details>

<details>
<summary><b>1743. Restore the Array From Adjacent Pairs</b></summary>
</details>

<details>
<summary><b>1744. Can You Eat Your Favorite Candy on Your Favorite Day?</b></summary>
</details>

<details>
<summary><b>1745. Palindrome Partitioning IV</b></summary>
</details>

<details>
<summary><b>1746. Maximum Subarray Sum After One Operation</b></summary>
</details>

<details>
<summary><b>1747. Leetflex Banned Accounts</b></summary>
</details>

<details>
<summary><b>1748. Sum of Unique Elements</b></summary>
</details>

<details>
<summary><b>1749. Maximum Absolute Sum of Any Subarray</b></summary>
</details>

<details>
<summary><b>1750. Minimum Length of String After Deleting Similar Ends</b></summary>
</details>

<details>
<summary><b>1751. Maximum Number of Events That Can Be Attended II</b></summary>
</details>

<details>
<summary><b>1752. Check if Array Is Sorted and Rotated</b></summary>
</details>

<details>
<summary><b>1753. Maximum Score From Removing Stones</b></summary>
</details>

<details>
<summary><b>1754. Largest Merge Of Two Strings</b></summary>
</details>

<details>
<summary><b>1755. Closest Subsequence Sum</b></summary>
</details>

<details>
<summary><b>1756. Design Most Recently Used Queue</b></summary>
</details>

<details>
<summary><b>1757. Recyclable and Low Fat Products</b></summary>
</details>

<details>
<summary><b>1758. Minimum Changes To Make Alternating Binary String</b></summary>
</details>

<details>
<summary><b>1759. Count Number of Homogenous Substrings</b></summary>
</details>

<details>
<summary><b>1760. Minimum Limit of Balls in a Bag</b></summary>
</details>

<details>
<summary><b>1761. Minimum Degree of a Connected Trio in a Graph</b></summary>
</details>

<details>
<summary><b>1762. Buildings With an Ocean View</b></summary>
</details>

<details>
<summary><b>1763. Longest Nice Substring</b></summary>
</details>

<details>
<summary><b>1764. Form Array by Concatenating Subarrays of Another Array</b></summary>
</details>

<details>
<summary><b>1765. Map of Highest Peak</b></summary>
</details>

<details>
<summary><b>1766. Tree of Coprimes</b></summary>
</details>

<details>
<summary><b>1767. Find the Subtasks That Did Not Execute</b></summary>
</details>

<details>
<summary><b>1768. Merge Strings Alternately</b></summary>
</details>

<details>
<summary><b>1769. Minimum Number of Operations to Move All Balls to Each Box</b></summary>
</details>

<details>
<summary><b>1770. Maximum Score from Performing Multiplication Operations</b></summary>
</details>

<details>
<summary><b>1771. Maximize Palindrome Length From Subsequences</b></summary>
</details>

<details>
<summary><b>1772. Sort Features by Popularity</b></summary>
</details>

<details>
<summary><b>1773. Count Items Matching a Rule</b></summary>
</details>

<details>
<summary><b>1774. Closest Dessert Cost</b></summary>
</details>

<details>
<summary><b>1775. Equal Sum Arrays With Minimum Number of Operations</b></summary>
</details>

<details>
<summary><b>1776. Car Fleet II</b></summary>
</details>

<details>
<summary><b>1777. Product's Price for Each Store</b></summary>
</details>

<details>
<summary><b>1778. Shortest Path in a Hidden Grid</b></summary>
</details>

<details>
<summary><b>1779. Find Nearest Point That Has the Same X or Y Coordinate</b></summary>
</details>

<details>
<summary><b>1780. Check if Number is a Sum of Powers of Three</b></summary>
</details>

<details>
<summary><b>1781. Sum of Beauty of All Substrings</b></summary>
</details>

<details>
<summary><b>1782. Count Pairs Of Nodes</b></summary>
</details>

<details>
<summary><b>1783. Grand Slam Titles</b></summary>
</details>

<details>
<summary><b>1784. Check if Binary String Has at Most One Segment of Ones</b></summary>
</details>

<details>
<summary><b>1785. Minimum Elements to Add to Form a Given Sum</b></summary>
</details>

<details>
<summary><b>1786. Number of Restricted Paths From First to Last Node</b></summary>
</details>

<details>
<summary><b>1787. Make the XOR of All Segments Equal to Zero</b></summary>
</details>

<details>
<summary><b>1788. Maximize the Beauty of the Garden</b></summary>
</details>

<details>
<summary><b>1789. Primary Department for Each Employee</b></summary>
</details>

<details>
<summary><b>1790. Check if One String Swap Can Make Strings Equal</b></summary>
</details>

<details>
<summary><b>1791. Find Center of Star Graph</b></summary>
</details>

<details>
<summary><b>1792. Maximum Average Pass Ratio</b></summary>
</details>

<details>
<summary><b>1793. Maximum Score of a Good Subarray</b></summary>
</details>

<details>
<summary><b>1794. Count Pairs of Equal Substrings With Minimum Difference</b></summary>
</details>

<details>
<summary><b>1795. Rearrange Products Table</b></summary>
</details>

<details>
<summary><b>1796. Second Largest Digit in a String</b></summary>
</details>

<details>
<summary><b>1797. Design Authentication Manager</b></summary>
</details>

<details>
<summary><b>1798. Maximum Number of Consecutive Values You Can Make</b></summary>
</details>

<details>
<summary><b>1799. Maximize Score After N Operations</b></summary>
</details>

<details>
<summary><b>1800. Maximum Ascending Subarray Sum</b></summary>
</details>

<details>
<summary><b>1801. Number of Orders in the Backlog</b></summary>
</details>

<details>
<summary><b>1802. Maximum Value at a Given Index in a Bounded Array</b></summary>
</details>

<details>
<summary><b>1803. Count Pairs With XOR in a Range</b></summary>
</details>

<details>
<summary><b>1804. Implement Trie II (Prefix Tree)</b></summary>
</details>

<details>
<summary><b>1805. Number of Different Integers in a String</b></summary>
</details>

<details>
<summary><b>1806. Minimum Number of Operations to Reinitialize a Permutation</b></summary>
</details>

<details>
<summary><b>1807. Evaluate the Bracket Pairs of a String</b></summary>
</details>

<details>
<summary><b>1808. Maximize Number of Nice Divisors</b></summary>
</details>

<details>
<summary><b>1809. Ad-Free Sessions</b></summary>
</details>

<details>
<summary><b>1810. Minimum Path Cost in a Hidden Grid</b></summary>
</details>

<details>
<summary><b>1811. Find Interview Candidates</b></summary>
</details>

<details>
<summary><b>1812. Determine Color of a Chessboard Square</b></summary>
</details>

<details>
<summary><b>1813. Sentence Similarity III</b></summary>
</details>

<details>
<summary><b>1814. Count Nice Pairs in an Array</b></summary>
</details>

<details>
<summary><b>1815. Maximum Number of Groups Getting Fresh Donuts</b></summary>
</details>

<details>
<summary><b>1816. Truncate Sentence</b></summary>
</details>

<details>
<summary><b>1817. Finding the Users Active Minutes</b></summary>
</details>

<details>
<summary><b>1818. Minimum Absolute Sum Difference</b></summary>
</details>

<details>
<summary><b>1819. Number of Different Subsequences GCDs</b></summary>
</details>

<details>
<summary><b>1820. Maximum Number of Accepted Invitations</b></summary>
</details>

<details>
<summary><b>1821. Find Customers With Positive Revenue this Year</b></summary>
</details>

<details>
<summary><b>1822. Sign of the Product of an Array</b></summary>
</details>

<details>
<summary><b>1823. Find the Winner of the Circular Game</b></summary>
</details>

<details>
<summary><b>1824. Minimum Sideway Jumps</b></summary>
</details>

<details>
<summary><b>1825. Finding MK Average</b></summary>
</details>

<details>
<summary><b>1826. Faulty Sensor</b></summary>
</details>

<details>
<summary><b>1827. Minimum Operations to Make the Array Increasing</b></summary>
</details>

<details>
<summary><b>1828. Queries on Number of Points Inside a Circle</b></summary>
</details>

<details>
<summary><b>1829. Maximum XOR for Each Query</b></summary>
</details>

<details>
<summary><b>1830. Minimum Number of Operations to Make String Sorted</b></summary>
</details>

<details>
<summary><b>1831. Maximum Transaction Each Day</b></summary>
</details>

<details>
<summary><b>1832. Check if the Sentence Is Pangram</b></summary>
</details>

<details>
<summary><b>1833. Maximum Ice Cream Bars</b></summary>
</details>

<details>
<summary><b>1834. Single-Threaded CPU</b></summary>
</details>

<details>
<summary><b>1835. Find XOR Sum of All Pairs Bitwise AND</b></summary>
</details>

<details>
<summary><b>1836. Remove Duplicates From an Unsorted Linked List</b></summary>
</details>

<details>
<summary><b>1837. Sum of Digits in Base K</b></summary>
</details>

<details>
<summary><b>1838. Frequency of the Most Frequent Element</b></summary>
</details>

<details>
<summary><b>1839. Longest Substring Of All Vowels in Order</b></summary>
</details>

<details>
<summary><b>1840. Maximum Building Height</b></summary>
</details>

<details>
<summary><b>1841. League Statistics</b></summary>
</details>

<details>
<summary><b>1842. Next Palindrome Using Same Digits</b></summary>
</details>

<details>
<summary><b>1843. Suspicious Bank Accounts</b></summary>
</details>

<details>
<summary><b>1844. Replace All Digits with Characters</b></summary>
</details>

<details>
<summary><b>1845. Seat Reservation Manager</b></summary>
</details>

<details>
<summary><b>1846. Maximum Element After Decreasing and Rearranging</b></summary>
</details>

<details>
<summary><b>1847. Closest Room</b></summary>
</details>

<details>
<summary><b>1848. Minimum Distance to the Target Element</b></summary>
</details>

<details>
<summary><b>1849. Splitting a String Into Descending Consecutive Values</b></summary>
</details>

<details>
<summary><b>1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number</b></summary>
</details>

<details>
<summary><b>1851. Minimum Interval to Include Each Query</b></summary>
</details>

<details>
<summary><b>1852. Distinct Numbers in Each Subarray</b></summary>
</details>

<details>
<summary><b>1853. Convert Date Format</b></summary>
</details>

<details>
<summary><b>1854. Maximum Population Year</b></summary>
</details>

<details>
<summary><b>1855. Maximum Distance Between a Pair of Values</b></summary>
</details>

<details>
<summary><b>1856. Maximum Subarray Min-Product</b></summary>
</details>

<details>
<summary><b>1857. Largest Color Value in a Directed Graph</b></summary>
</details>

<details>
<summary><b>1858. Longest Word With All Prefixes</b></summary>
</details>

<details>
<summary><b>1859. Sorting the Sentence</b></summary>
</details>

<details>
<summary><b>1860. Incremental Memory Leak</b></summary>
</details>

<details>
<summary><b>1861. Rotating the Box</b></summary>
</details>

<details>
<summary><b>1862. Sum of Floored Pairs</b></summary>
</details>

<details>
<summary><b>1863. Sum of All Subset XOR Totals</b></summary>
</details>

<details>
<summary><b>1864. Minimum Number of Swaps to Make the Binary String Alternating</b></summary>
</details>

<details>
<summary><b>1865. Finding Pairs With a Certain Sum</b></summary>
</details>

<details>
<summary><b>1866. Number of Ways to Rearrange Sticks With K Sticks Visible</b></summary>
</details>

<details>
<summary><b>1867. Orders With Maximum Quantity Above Average</b></summary>
</details>

<details>
<summary><b>1868. Product of Two Run-Length Encoded Arrays</b></summary>
</details>

<details>
<summary><b>1869. Longer Contiguous Segments of Ones than Zeros</b></summary>
</details>

<details>
<summary><b>1870. Minimum Speed to Arrive on Time</b></summary>
</details>

<details>
<summary><b>1871. Jump Game VII</b></summary>
</details>

<details>
<summary><b>1872. Stone Game VIII</b></summary>
</details>

<details>
<summary><b>1873. Calculate Special Bonus</b></summary>
</details>

<details>
<summary><b>1874. Minimize Product Sum of Two Arrays</b></summary>
</details>

<details>
<summary><b>1875. Group Employees of the Same Salary</b></summary>
</details>

<details>
<summary><b>1876. Substrings of Size Three with Distinct Characters</b></summary>
</details>

<details>
<summary><b>1877. Minimize Maximum Pair Sum in Array</b></summary>
</details>

<details>
<summary><b>1878. Get Biggest Three Rhombus Sums in a Grid</b></summary>
</details>

<details>
<summary><b>1879. Minimum XOR Sum of Two Arrays</b></summary>
</details>

<details>
<summary><b>1880. Check if Word Equals Summation of Two Words</b></summary>
</details>

<details>
<summary><b>1881. Maximum Value after Insertion</b></summary>
</details>

<details>
<summary><b>1882. Process Tasks Using Servers</b></summary>
</details>

<details>
<summary><b>1883. Minimum Skips to Arrive at Meeting On Time</b></summary>
</details>

<details>
<summary><b>1884. Egg Drop With</b></summary>
</details>

<details>
<summary><b>1885. Count Pairs in Two Arrays</b></summary>
</details>

<details>
<summary><b>1886. Determine Whether Matrix Can Be Obtained By Rotation</b></summary>
</details>

<details>
<summary><b>1887. Reduction Operations to Make the Array Elements Equal</b></summary>
</details>

<details>
<summary><b>1888. Minimum Number of Flips to Make the Binary String Alternating</b></summary>
</details>

<details>
<summary><b>1889. Minimum Space Wasted From Packaging</b></summary>
</details>

<details>
<summary><b>1890. The Latest Login in</b></summary>
</details>

<details>
<summary><b>1891. Cutting Ribbons</b></summary>
</details>

<details>
<summary><b>1892. Page Recommendations II</b></summary>
</details>

<details>
<summary><b>1893. Check if All the Integers in a Range Are Covered</b></summary>
</details>

<details>
<summary><b>1894. Find the Student that Will Replace the Chalk</b></summary>
</details>

<details>
<summary><b>1895. Largest Magic Square</b></summary>
</details>

<details>
<summary><b>1896. Minimum Cost to Change the Final Value of Expression</b></summary>
</details>

<details>
<summary><b>1897. Redistribute Characters to Make All Strings Equal</b></summary>
</details>

<details>
<summary><b>1898. Maximum Number of Removable Characters</b></summary>
</details>

<details>
<summary><b>1899. Merge Triplets to Form Target Triplet</b></summary>
</details>

<details>
<summary><b>1900. The Earliest and Latest Rounds Where Players Compete</b></summary>
</details>

<details>
<summary><b>1901. Find a Peak Element II</b></summary>
</details>

<details>
<summary><b>1902. Depth of BST Given Insertion Order</b></summary>
</details>

<details>
<summary><b>1903. Largest Odd Number in String</b></summary>
</details>

<details>
<summary><b>1904. The Number of Full Rounds You Have Played</b></summary>
</details>

<details>
<summary><b>1905. Count Sub Islands</b></summary>
</details>

<details>
<summary><b>1906. Minimum Absolute Difference Queries</b></summary>
</details>

<details>
<summary><b>1907. Count Salary Categories</b></summary>
</details>

<details>
<summary><b>1908. Game of Nim</b></summary>
</details>

<details>
<summary><b>1909. Remove One Element to Make the Array Strictly Increasing</b></summary>
</details>

<details>
<summary><b>1910. Remove All Occurrences of a Substring</b></summary>
</details>

<details>
<summary><b>1911. Maximum Alternating Subsequence Sum</b></summary>
</details>

<details>
<summary><b>1912. Design Movie Rental System</b></summary>
</details>

<details>
<summary><b>1913. Maximum Product Difference Between Two Pairs</b></summary>
</details>

<details>
<summary><b>1914. Cyclically Rotating a Grid</b></summary>
</details>

<details>
<summary><b>1915. Number of Wonderful Substrings</b></summary>
</details>

<details>
<summary><b>1916. Count Ways to Build Rooms in an Ant Colony</b></summary>
</details>

<details>
<summary><b>1917. Leetcodify Friends Recommendations</b></summary>
</details>

<details>
<summary><b>1918. Kth Smallest Subarray Sum</b></summary>
</details>

<details>
<summary><b>1919. Leetcodify Similar Friends</b></summary>
</details>

<details>
<summary><b>1920. Build Array from Permutation</b></summary>
</details>

<details>
<summary><b>1921. Eliminate Maximum Number of Monsters</b></summary>
</details>

<details>
<summary><b>1922. Count Good Numbers</b></summary>
</details>

<details>
<summary><b>1923. Longest Common Subpath</b></summary>
</details>

<details>
<summary><b>1924. Erect the Fence II</b></summary>
</details>

<details>
<summary><b>1925. Count Square Sum Triples</b></summary>
</details>

<details>
<summary><b>1926. Nearest Exit from Entrance in Maze</b></summary>
</details>

<details>
<summary><b>1927. Sum Game</b></summary>
</details>

<details>
<summary><b>1928. Minimum Cost to Reach Destination in Time</b></summary>
</details>

<details>
<summary><b>1929. Concatenation of Array</b></summary>
</details>

<details>
<summary><b>1930. Unique Length-</b></summary>
</details>

<details>
<summary><b>1931. Painting a Grid With Three Different Colors</b></summary>
</details>

<details>
<summary><b>1932. Merge BSTs to Create Single BST</b></summary>
</details>

<details>
<summary><b>1933. Check if String Is Decomposable Into Value-Equal Substrings</b></summary>
</details>

<details>
<summary><b>1934. Confirmation Rate</b></summary>
</details>

<details>
<summary><b>1935. Maximum Number of Words You Can Type</b></summary>
</details>

<details>
<summary><b>1936. Add Minimum Number of Rungs</b></summary>
</details>

<details>
<summary><b>1937. Maximum Number of Points with Cost</b></summary>
</details>

<details>
<summary><b>1938. Maximum Genetic Difference Query</b></summary>
</details>

<details>
<summary><b>1939. Users That Actively Request Confirmation Messages</b></summary>
</details>

<details>
<summary><b>1940. Longest Common Subsequence Between Sorted Arrays</b></summary>
</details>

<details>
<summary><b>1941. Check if All Characters Have Equal Number of Occurrences</b></summary>
</details>

<details>
<summary><b>1942. The Number of the Smallest Unoccupied Chair</b></summary>
</details>

<details>
<summary><b>1943. Describe the Painting</b></summary>
</details>

<details>
<summary><b>1944. Number of Visible People in a Queue</b></summary>
</details>

<details>
<summary><b>1945. Sum of Digits of String After Convert</b></summary>
</details>

<details>
<summary><b>1946. Largest Number After Mutating Substring</b></summary>
</details>

<details>
<summary><b>1947. Maximum Compatibility Score Sum</b></summary>
</details>

<details>
<summary><b>1948. Delete Duplicate Folders in System</b></summary>
</details>

<details>
<summary><b>1949. Strong Friendship</b></summary>
</details>

<details>
<summary><b>1950. Maximum of Minimum Values in All Subarrays</b></summary>
</details>

<details>
<summary><b>1951. All the Pairs With the Maximum Number of Common Followers</b></summary>
</details>

<details>
<summary><b>1952. Three Divisors</b></summary>
</details>

<details>
<summary><b>1953. Maximum Number of Weeks for Which You Can Work</b></summary>
</details>

<details>
<summary><b>1954. Minimum Garden Perimeter to Collect Enough Apples</b></summary>
</details>

<details>
<summary><b>1955. Count Number of Special Subsequences</b></summary>
</details>

<details>
<summary><b>1956. Minimum Time For K Virus Variants to Spread</b></summary>
</details>

<details>
<summary><b>1957. Delete Characters to Make Fancy String</b></summary>
</details>

<details>
<summary><b>1958. Check if Move is Legal</b></summary>
</details>

<details>
<summary><b>1959. Minimum Total Space Wasted With K Resizing Operations</b></summary>
</details>

<details>
<summary><b>1960. Maximum Product of the Length of Two Palindromic Substrings</b></summary>
</details>

<details>
<summary><b>1961. Check If String Is a Prefix of Array</b></summary>
</details>

<details>
<summary><b>1962. Remove Stones to Minimize the Total</b></summary>
</details>

<details>
<summary><b>1963. Minimum Number of Swaps to Make the String Balanced</b></summary>
</details>

<details>
<summary><b>1964. Find the Longest Valid Obstacle Course at Each Position</b></summary>
</details>

<details>
<summary><b>1965. Employees With Missing Information</b></summary>
</details>

<details>
<summary><b>1966. Binary Searchable Numbers in an Unsorted Array</b></summary>
</details>

<details>
<summary><b>1967. Number of Strings That Appear as Substrings in Word</b></summary>
</details>

<details>
<summary><b>1968. Array With Elements Not Equal to Average of Neighbors</b></summary>
</details>

<details>
<summary><b>1969. Minimum Non-Zero Product of the Array Elements</b></summary>
</details>

<details>
<summary><b>1970. Last Day Where You Can Still Cross</b></summary>
</details>

<details>
<summary><b>1971. Find if Path Exists in Graph</b></summary>
</details>

<details>
<summary><b>1972. First and Last Call On the Same Day</b></summary>
</details>

<details>
<summary><b>1973. Count Nodes Equal to Sum of Descendants</b></summary>
</details>

<details>
<summary><b>1974. Minimum Time to Type Word Using Special Typewriter</b></summary>
</details>

<details>
<summary><b>1975. Maximum Matrix Sum</b></summary>
</details>

<details>
<summary><b>1976. Number of Ways to Arrive at Destination</b></summary>
</details>

<details>
<summary><b>1977. Number of Ways to Separate Numbers</b></summary>
</details>

<details>
<summary><b>1978. Employees Whose Manager Left the Company</b></summary>
</details>

<details>
<summary><b>1979. Find Greatest Common Divisor of Array</b></summary>
</details>

<details>
<summary><b>1980. Find Unique Binary String</b></summary>
</details>

<details>
<summary><b>1981. Minimize the Difference Between Target and Chosen Elements</b></summary>
</details>

<details>
<summary><b>1982. Find Array Given Subset Sums</b></summary>
</details>

<details>
<summary><b>1983. Widest Pair of Indices With Equal Range Sum</b></summary>
</details>

<details>
<summary><b>1984. Minimum Difference Between Highest and Lowest of K Scores</b></summary>
</details>

<details>
<summary><b>1985. Find the Kth Largest Integer in the Array</b></summary>
</details>

<details>
<summary><b>1986. Minimum Number of Work Sessions to Finish the Tasks</b></summary>
</details>

<details>
<summary><b>1987. Number of Unique Good Subsequences</b></summary>
</details>

<details>
<summary><b>1988. Find Cutoff Score for Each School</b></summary>
</details>

<details>
<summary><b>1989. Maximum Number of People That Can Be Caught in Tag</b></summary>
</details>

<details>
<summary><b>1990. Count the Number of Experiments</b></summary>
</details>

<details>
<summary><b>1991. Find the Middle Index in Array</b></summary>
</details>

<details>
<summary><b>1992. Find All Groups of Farmland</b></summary>
</details>

<details>
<summary><b>1993. Operations on Tree</b></summary>
</details>

<details>
<summary><b>1994. The Number of Good Subsets</b></summary>
</details>

<details>
<summary><b>1995. Count Special Quadruplets</b></summary>
</details>

<details>
<summary><b>1996. The Number of Weak Characters in the Game</b></summary>
</details>

<details>
<summary><b>1997. First Day Where You Have Been in All the Rooms</b></summary>
</details>

<details>
<summary><b>1998. GCD Sort of an Array</b></summary>
</details>

<details>
<summary><b>1999. Smallest Greater Multiple Made of Two Digits</b></summary>
</details>

<details>
<summary><b>2000. Reverse Prefix of Word</b></summary>
</details>

<details>
<summary><b>2001. Number of Pairs of Interchangeable Rectangles</b></summary>
</details>

<details>
<summary><b>2002. Maximum Product of the Length of Two Palindromic Subsequences</b></summary>
</details>

<details>
<summary><b>2003. Smallest Missing Genetic Value in Each Subtree</b></summary>
</details>

<details>
<summary><b>2004. The Number of Seniors and Juniors to Join the Company</b></summary>
</details>

<details>
<summary><b>2005. Subtree Removal Game with Fibonacci Tree</b></summary>
</details>

<details>
<summary><b>2006. Count Number of Pairs With Absolute Difference K</b></summary>
</details>

<details>
<summary><b>2007. Find Original Array From Doubled Array</b></summary>
</details>

<details>
<summary><b>2008. Maximum Earnings From Taxi</b></summary>
</details>

<details>
<summary><b>2009. Minimum Number of Operations to Make Array Continuous</b></summary>
</details>

<details>
<summary><b>2010. The Number of Seniors and Juniors to Join the Company II</b></summary>
</details>

<details>
<summary><b>2011. Final Value of Variable After Performing Operations</b></summary>
</details>

<details>
<summary><b>2012. Sum of Beauty in the Array</b></summary>
</details>

<details>
<summary><b>2013. Detect Squares</b></summary>
</details>

<details>
<summary><b>2014. Longest Subsequence Repeated k Times</b></summary>
</details>

<details>
<summary><b>2015. Average Height of Buildings in Each Segment</b></summary>
</details>

<details>
<summary><b>2016. Maximum Difference Between Increasing Elements</b></summary>
</details>

<details>
<summary><b>2017. Grid Game</b></summary>
</details>

<details>
<summary><b>2018. Check if Word Can Be Placed In Crossword</b></summary>
</details>

<details>
<summary><b>2019. The Score of Students Solving Math Expression</b></summary>
</details>

<details>
<summary><b>2020. Number of Accounts That Did Not Stream</b></summary>
</details>

<details>
<summary><b>2021. Brightest Position on Street</b></summary>
</details>

<details>
<summary><b>2022. Convert</b></summary>
</details>

<details>
<summary><b>2023. Number of Pairs of Strings With Concatenation Equal to Target</b></summary>
</details>

<details>
<summary><b>2024. Maximize the Confusion of an Exam</b></summary>
</details>

<details>
<summary><b>2025. Maximum Number of Ways to Partition an Array</b></summary>
</details>

<details>
<summary><b>2026. Low-Quality Problems</b></summary>
</details>

<details>
<summary><b>2027. Minimum Moves to Convert String</b></summary>
</details>

<details>
<summary><b>2028. Find Missing Observations</b></summary>
</details>

<details>
<summary><b>2029. Stone Game IX</b></summary>
</details>

<details>
<summary><b>2030. Smallest K-Length Subsequence With Occurrences of a Letter</b></summary>
</details>

<details>
<summary><b>2031. Count Subarrays With More Ones Than Zeros</b></summary>
</details>

<details>
<summary><b>2032. Two Out of Three</b></summary>
</details>

<details>
<summary><b>2033. Minimum Operations to Make a Uni-Value Grid</b></summary>
</details>

<details>
<summary><b>2034. Stock Price Fluctuation</b></summary>
</details>

<details>
<summary><b>2035. Partition Array Into Two Arrays to Minimize Sum Difference</b></summary>
</details>

<details>
<summary><b>2036. Maximum Alternating Subarray Sum</b></summary>
</details>

<details>
<summary><b>2037. Minimum Number of Moves to Seat Everyone</b></summary>
</details>

<details>
<summary><b>2038. Remove Colored Pieces if Both Neighbors are the Same Color</b></summary>
</details>

<details>
<summary><b>2039. The Time When the Network Becomes Idle</b></summary>
</details>

<details>
<summary><b>2040. Kth Smallest Product of Two Sorted Arrays</b></summary>
</details>

<details>
<summary><b>2041. Accepted Candidates From the Interviews</b></summary>
</details>

<details>
<summary><b>2042. Check if Numbers Are Ascending in a Sentence</b></summary>
</details>

<details>
<summary><b>2043. Simple Bank System</b></summary>
</details>

<details>
<summary><b>2044. Count Number of Maximum Bitwise-OR Subsets</b></summary>
</details>

<details>
<summary><b>2045. Second Minimum Time to Reach Destination</b></summary>
</details>

<details>
<summary><b>2046. Sort Linked List Already Sorted Using Absolute Values</b></summary>
</details>

<details>
<summary><b>2047. Number of Valid Words in a Sentence</b></summary>
</details>

<details>
<summary><b>2048. Next Greater Numerically Balanced Number</b></summary>
</details>

<details>
<summary><b>2049. Count Nodes With the Highest Score</b></summary>
</details>

<details>
<summary><b>2050. Parallel Courses III</b></summary>
</details>

<details>
<summary><b>2051. The Category of Each Member in the Store</b></summary>
</details>

<details>
<summary><b>2052. Minimum Cost to Separate Sentence Into Rows</b></summary>
</details>

<details>
<summary><b>2053. Kth Distinct String in an Array</b></summary>
</details>

<details>
<summary><b>2054. Two Best Non-Overlapping Events</b></summary>
</details>

<details>
<summary><b>2055. Plates Between Candles</b></summary>
</details>

<details>
<summary><b>2056. Number of Valid Move Combinations On Chessboard</b></summary>
</details>

<details>
<summary><b>2057. Smallest Index With Equal Value</b></summary>
</details>

<details>
<summary><b>2058. Find the Minimum and Maximum Number of Nodes Between Critical Points</b></summary>
</details>

<details>
<summary><b>2059. Minimum Operations to Convert Number</b></summary>
</details>

<details>
<summary><b>2060. Check if an Original String Exists Given Two Encoded Strings</b></summary>
</details>

<details>
<summary><b>2061. Number of Spaces Cleaning Robot Cleaned</b></summary>
</details>

<details>
<summary><b>2062. Count Vowel Substrings of a String</b></summary>
</details>

<details>
<summary><b>2063. Vowels of All Substrings</b></summary>
</details>

<details>
<summary><b>2064. Minimized Maximum of Products Distributed to Any Store</b></summary>
</details>

<details>
<summary><b>2065. Maximum Path Quality of a Graph</b></summary>
</details>

<details>
<summary><b>2066. Account Balance</b></summary>
</details>

<details>
<summary><b>2067. Number of Equal Count Substrings</b></summary>
</details>

<details>
<summary><b>2068. Check Whether Two Strings are Almost Equivalent</b></summary>
</details>

<details>
<summary><b>2069. Walking Robot Simulation II</b></summary>
</details>

<details>
<summary><b>2070. Most Beautiful Item for Each Query</b></summary>
</details>

<details>
<summary><b>2071. Maximum Number of Tasks You Can Assign</b></summary>
</details>

<details>
<summary><b>2072. The Winner University</b></summary>
</details>

<details>
<summary><b>2073. Time Needed to Buy Tickets</b></summary>
</details>

<details>
<summary><b>2074. Reverse Nodes in Even Length Groups</b></summary>
</details>

<details>
<summary><b>2075. Decode the Slanted Ciphertext</b></summary>
</details>

<details>
<summary><b>2076. Process Restricted Friend Requests</b></summary>
</details>

<details>
<summary><b>2077. Paths in Maze That Lead to Same Room</b></summary>
</details>

<details>
<summary><b>2078. Two Furthest Houses With Different Colors</b></summary>
</details>

<details>
<summary><b>2079. Watering Plants</b></summary>
</details>

<details>
<summary><b>2080. Range Frequency Queries</b></summary>
</details>

<details>
<summary><b>2081. Sum of k-Mirror Numbers</b></summary>
</details>

<details>
<summary><b>2082. The Number of Rich Customers</b></summary>
</details>

<details>
<summary><b>2083. Substrings That Begin and End With the Same Letter</b></summary>
</details>

<details>
<summary><b>2084. Drop Type</b></summary>
</details>

<details>
<summary><b>2085. Count Common Words With One Occurrence</b></summary>
</details>

<details>
<summary><b>2086. Minimum Number of Food Buckets to Feed the Hamsters</b></summary>
</details>

<details>
<summary><b>2087. Minimum Cost Homecoming of a Robot in a Grid</b></summary>
</details>

<details>
<summary><b>2088. Count Fertile Pyramids in a Land</b></summary>
</details>

<details>
<summary><b>2089. Find Target Indices After Sorting Array</b></summary>
</details>

<details>
<summary><b>2090. K Radius Subarray Averages</b></summary>
</details>

<details>
<summary><b>2091. Removing Minimum and Maximum From Array</b></summary>
</details>

<details>
<summary><b>2092. Find All People With Secret</b></summary>
</details>

<details>
<summary><b>2093. Minimum Cost to Reach City With Discounts</b></summary>
</details>

<details>
<summary><b>2094. Finding</b></summary>
</details>

<details>
<summary><b>2095. Delete the Middle Node of a Linked List</b></summary>
</details>

<details>
<summary><b>2096. Step-By-Step Directions From a Binary Tree Node to Another</b></summary>
</details>

<details>
<summary><b>2097. Valid Arrangement of Pairs</b></summary>
</details>

<details>
<summary><b>2098. Subsequence of Size K With the Largest Even Sum</b></summary>
</details>

<details>
<summary><b>2099. Find Subsequence of Length K With the Largest Sum</b></summary>
</details>

<details>
<summary><b>2100. Find Good Days to Rob the Bank</b></summary>
</details>

<details>
<summary><b>2101. Detonate the Maximum Bombs</b></summary>
</details>

<details>
<summary><b>2102. Sequentially Ordinal Rank Tracker</b></summary>
</details>

<details>
<summary><b>2103. Rings and Rods</b></summary>
</details>

<details>
<summary><b>2104. Sum of Subarray Ranges</b></summary>
</details>

<details>
<summary><b>2105. Watering Plants II</b></summary>
</details>

<details>
<summary><b>2106. Maximum Fruits Harvested After at Most K Steps</b></summary>
</details>

<details>
<summary><b>2107. Number of Unique Flavors After Sharing K Candies</b></summary>
</details>

<details>
<summary><b>2108. Find First Palindromic String in the Array</b></summary>
</details>

<details>
<summary><b>2109. Adding Spaces to a String</b></summary>
</details>

<details>
<summary><b>2110. Number of Smooth Descent Periods of a Stock</b></summary>
</details>

<details>
<summary><b>2111. Minimum Operations to Make the Array K-Increasing</b></summary>
</details>

<details>
<summary><b>2112. The Airport With the Most Traffic</b></summary>
</details>

<details>
<summary><b>2113. Elements in Array After Removing and Replacing Elements</b></summary>
</details>

<details>
<summary><b>2114. Maximum Number of Words Found in Sentences</b></summary>
</details>

<details>
<summary><b>2115. Find All Possible Recipes from Given Supplies</b></summary>
</details>

<details>
<summary><b>2116. Check if a Parentheses String Can Be Valid</b></summary>
</details>

<details>
<summary><b>2117. Abbreviating the Product of a Range</b></summary>
</details>

<details>
<summary><b>2118. Build the Equation</b></summary>
</details>

<details>
<summary><b>2119. A Number After a Double Reversal</b></summary>
</details>

<details>
<summary><b>2120. Execution of All Suffix Instructions Staying in a Grid</b></summary>
</details>

<details>
<summary><b>2121. Intervals Between Identical Elements</b></summary>
</details>

<details>
<summary><b>2122. Recover the Original Array</b></summary>
</details>

<details>
<summary><b>2123. Minimum Operations to Remove Adjacent Ones in Matrix</b></summary>
</details>

<details>
<summary><b>2124. Check if All A's Appears Before All B's</b></summary>
</details>

<details>
<summary><b>2125. Number of Laser Beams in a Bank</b></summary>
</details>

<details>
<summary><b>2126. Destroying Asteroids</b></summary>
</details>

<details>
<summary><b>2127. Maximum Employees to Be Invited to a Meeting</b></summary>
</details>

<details>
<summary><b>2128. Remove All Ones With Row and Column Flips</b></summary>
</details>

<details>
<summary><b>2129. Capitalize the Title</b></summary>
</details>

<details>
<summary><b>2130. Maximum Twin Sum of a Linked List</b></summary>
</details>

<details>
<summary><b>2131. Longest Palindrome by Concatenating Two Letter Words</b></summary>
</details>

<details>
<summary><b>2132. Stamping the Grid</b></summary>
</details>

<details>
<summary><b>2133. Check if Every Row and Column Contains All Numbers</b></summary>
</details>

<details>
<summary><b>2134. Minimum Swaps to Group All</b></summary>
</details>

<details>
<summary><b>2135. Count Words Obtained After Adding a Letter</b></summary>
</details>

<details>
<summary><b>2136. Earliest Possible Day of Full Bloom</b></summary>
</details>

<details>
<summary><b>2137. Pour Water Between Buckets to Make Water Levels Equal</b></summary>
</details>

<details>
<summary><b>2138. Divide a String Into Groups of Size k</b></summary>
</details>

<details>
<summary><b>2139. Minimum Moves to Reach Target Score</b></summary>
</details>

<details>
<summary><b>2140. Solving Questions With Brainpower</b></summary>
</details>

<details>
<summary><b>2141. Maximum Running Time of N Computers</b></summary>
</details>

<details>
<summary><b>2142. The Number of Passengers in Each Bus I</b></summary>
</details>

<details>
<summary><b>2143. Choose Numbers From Two Arrays in Range</b></summary>
</details>

<details>
<summary><b>2144. Minimum Cost of Buying Candies With Discount</b></summary>
</details>

<details>
<summary><b>2145. Count the Hidden Sequences</b></summary>
</details>

<details>
<summary><b>2146. K Highest Ranked Items Within a Price Range</b></summary>
</details>

<details>
<summary><b>2147. Number of Ways to Divide a Long Corridor</b></summary>
</details>

<details>
<summary><b>2148. Count Elements With Strictly Smaller and Greater Elements</b></summary>
</details>

<details>
<summary><b>2149. Rearrange Array Elements by Sign</b></summary>
</details>

<details>
<summary><b>2150. Find All Lonely Numbers in the Array</b></summary>
</details>

<details>
<summary><b>2151. Maximum Good People Based on Statements</b></summary>
</details>

<details>
<summary><b>2152. Minimum Number of Lines to Cover Points</b></summary>
</details>

<details>
<summary><b>2153. The Number of Passengers in Each Bus II</b></summary>
</details>

<details>
<summary><b>2154. Keep Multiplying Found Values by Two</b></summary>
</details>

<details>
<summary><b>2155. All Divisions With the Highest Score of a Binary Array</b></summary>
</details>

<details>
<summary><b>2156. Find Substring With Given Hash Value</b></summary>
</details>

<details>
<summary><b>2157. Groups of Strings</b></summary>
</details>

<details>
<summary><b>2158. Amount of New Area Painted Each Day</b></summary>
</details>

<details>
<summary><b>2159. Order Two Columns Independently</b></summary>
</details>

<details>
<summary><b>2160. Minimum Sum of Four Digit Number After Splitting Digits</b></summary>
</details>

<details>
<summary><b>2161. Partition Array According to Given Pivot</b></summary>
</details>

<details>
<summary><b>2162. Minimum Cost to Set Cooking Time</b></summary>
</details>

<details>
<summary><b>2163. Minimum Difference in Sums After Removal of Elements</b></summary>
</details>

<details>
<summary><b>2164. Sort Even and Odd Indices Independently</b></summary>
</details>

<details>
<summary><b>2165. Smallest Value of the Rearranged Number</b></summary>
</details>

<details>
<summary><b>2166. Design Bitset</b></summary>
</details>

<details>
<summary><b>2167. Minimum Time to Remove All Cars Containing Illegal Goods</b></summary>
</details>

<details>
<summary><b>2168. Unique Substrings With Equal Digit Frequency</b></summary>
</details>

<details>
<summary><b>2169. Count Operations to Obtain Zero</b></summary>
</details>

<details>
<summary><b>2170. Minimum Operations to Make the Array Alternating</b></summary>
</details>

<details>
<summary><b>2171. Removing Minimum Number of Magic Beans</b></summary>
</details>

<details>
<summary><b>2172. Maximum AND Sum of Array</b></summary>
</details>

<details>
<summary><b>2173. Longest Winning Streak</b></summary>
</details>

<details>
<summary><b>2174. Remove All Ones With Row and Column Flips II</b></summary>
</details>

<details>
<summary><b>2175. The Change in Global Rankings</b></summary>
</details>

<details>
<summary><b>2176. Count Equal and Divisible Pairs in an Array</b></summary>
</details>

<details>
<summary><b>2177. Find Three Consecutive Integers That Sum to a Given Number</b></summary>
</details>

<details>
<summary><b>2178. Maximum Split of Positive Even Integers</b></summary>
</details>

<details>
<summary><b>2179. Count Good Triplets in an Array</b></summary>
</details>

<details>
<summary><b>2180. Count Integers With Even Digit Sum</b></summary>
</details>

<details>
<summary><b>2181. Merge Nodes in Between Zeros</b></summary>
</details>

<details>
<summary><b>2182. Construct String With Repeat Limit</b></summary>
</details>

<details>
<summary><b>2183. Count Array Pairs Divisible by K</b></summary>
</details>

<details>
<summary><b>2184. Number of Ways to Build Sturdy Brick Wall</b></summary>
</details>

<details>
<summary><b>2185. Counting Words With a Given Prefix</b></summary>
</details>

<details>
<summary><b>2186. Minimum Number of Steps to Make Two Strings Anagram II</b></summary>
</details>

<details>
<summary><b>2187. Minimum Time to Complete Trips</b></summary>
</details>

<details>
<summary><b>2188. Minimum Time to Finish the Race</b></summary>
</details>

<details>
<summary><b>2189. Number of Ways to Build House of Cards</b></summary>
</details>

<details>
<summary><b>2190. Most Frequent Number Following Key In an Array</b></summary>
</details>

<details>
<summary><b>2191. Sort the Jumbled Numbers</b></summary>
</details>

<details>
<summary><b>2192. All Ancestors of a Node in a Directed Acyclic Graph</b></summary>
</details>

<details>
<summary><b>2193. Minimum Number of Moves to Make Palindrome</b></summary>
</details>

<details>
<summary><b>2194. Cells in a Range on an Excel Sheet</b></summary>
</details>

<details>
<summary><b>2195. Append K Integers With Minimal Sum</b></summary>
</details>

<details>
<summary><b>2196. Create Binary Tree From Descriptions</b></summary>
</details>

<details>
<summary><b>2197. Replace Non-Coprime Numbers in Array</b></summary>
</details>

<details>
<summary><b>2198. Number of Single Divisor Triplets</b></summary>
</details>

<details>
<summary><b>2199. Finding the Topic of Each Post</b></summary>
</details>

<details>
<summary><b>2200. Find All K-Distant Indices in an Array</b></summary>
</details>

<details>
<summary><b>2201. Count Artifacts That Can Be Extracted</b></summary>
</details>

<details>
<summary><b>2202. Maximize the Topmost Element After K Moves</b></summary>
</details>

<details>
<summary><b>2203. Minimum Weighted Subgraph With the Required Paths</b></summary>
</details>

<details>
<summary><b>2204. Distance to a Cycle in Undirected Graph</b></summary>
</details>

<details>
<summary><b>2205. The Number of Users That Are Eligible for Discount</b></summary>
</details>

<details>
<summary><b>2206. Divide Array Into Equal Pairs</b></summary>
</details>

<details>
<summary><b>2207. Maximize Number of Subsequences in a String</b></summary>
</details>

<details>
<summary><b>2208. Minimum Operations to Halve Array Sum</b></summary>
</details>

<details>
<summary><b>2209. Minimum White Tiles After Covering With Carpets</b></summary>
</details>

<details>
<summary><b>2210. Count Hills and Valleys in an Array</b></summary>
</details>

<details>
<summary><b>2211. Count Collisions on a Road</b></summary>
</details>

<details>
<summary><b>2212. Maximum Points in an Archery Competition</b></summary>
</details>

<details>
<summary><b>2213. Longest Substring of One Repeating Character</b></summary>
</details>

<details>
<summary><b>2214. Minimum Health to Beat Game</b></summary>
</details>

<details>
<summary><b>2215. Find the Difference of Two Arrays</b></summary>
</details>

<details>
<summary><b>2216. Minimum Deletions to Make Array Beautiful</b></summary>
</details>

<details>
<summary><b>2217. Find Palindrome With Fixed Length</b></summary>
</details>

<details>
<summary><b>2218. Maximum Value of K Coins From Piles</b></summary>
</details>

<details>
<summary><b>2219. Maximum Sum Score of Array</b></summary>
</details>

<details>
<summary><b>2220. Minimum Bit Flips to Convert Number</b></summary>
</details>

<details>
<summary><b>2221. Find Triangular Sum of an Array</b></summary>
</details>

<details>
<summary><b>2222. Number of Ways to Select Buildings</b></summary>
</details>

<details>
<summary><b>2223. Sum of Scores of Built Strings</b></summary>
</details>

<details>
<summary><b>2224. Minimum Number of Operations to Convert Time</b></summary>
</details>

<details>
<summary><b>2225. Find Players With Zero or One Losses</b></summary>
</details>

<details>
<summary><b>2226. Maximum Candies Allocated to K Children</b></summary>
</details>

<details>
<summary><b>2227. Encrypt and Decrypt Strings</b></summary>
</details>

<details>
<summary><b>2228. Users With Two Purchases Within Seven Days</b></summary>
</details>

<details>
<summary><b>2229. Check if an Array Is Consecutive</b></summary>
</details>

<details>
<summary><b>2230. The Users That Are Eligible for Discount</b></summary>
</details>

<details>
<summary><b>2231. Largest Number After Digit Swaps by Parity</b></summary>
</details>

<details>
<summary><b>2232. Minimize Result by Adding Parentheses to Expression</b></summary>
</details>

<details>
<summary><b>2233. Maximum Product After K Increments</b></summary>
</details>

<details>
<summary><b>2234. Maximum Total Beauty of the Gardens</b></summary>
</details>

<details>
<summary><b>2235. Add Two Integers</b></summary>
</details>

<details>
<summary><b>2236. Root Equals Sum of Children</b></summary>
</details>

<details>
<summary><b>2237. Count Positions on Street With Required Brightness</b></summary>
</details>

<details>
<summary><b>2238. Number of Times a Driver Was a Passenger</b></summary>
</details>

<details>
<summary><b>2239. Find Closest Number to Zero</b></summary>
</details>

<details>
<summary><b>2240. Number of Ways to Buy Pens and Pencils</b></summary>
</details>

<details>
<summary><b>2241. Design an ATM Machine</b></summary>
</details>

<details>
<summary><b>2242. Maximum Score of a Node Sequence</b></summary>
</details>

<details>
<summary><b>2243. Calculate Digit Sum of a String</b></summary>
</details>

<details>
<summary><b>2244. Minimum Rounds to Complete All Tasks</b></summary>
</details>

<details>
<summary><b>2245. Maximum Trailing Zeros in a Cornered Path</b></summary>
</details>

<details>
<summary><b>2246. Longest Path With Different Adjacent Characters</b></summary>
</details>

<details>
<summary><b>2247. Maximum Cost of Trip With K Highways</b></summary>
</details>

<details>
<summary><b>2248. Intersection of Multiple Arrays</b></summary>
</details>

<details>
<summary><b>2249. Count Lattice Points Inside a Circle</b></summary>
</details>

<details>
<summary><b>2250. Count Number of Rectangles Containing Each Point</b></summary>
</details>

<details>
<summary><b>2251. Number of Flowers in Full Bloom</b></summary>
</details>

<details>
<summary><b>2252. Dynamic Pivoting of a Table</b></summary>
</details>

<details>
<summary><b>2253. Dynamic Unpivoting of a Table</b></summary>
</details>

<details>
<summary><b>2254. Design Video Sharing Platform</b></summary>
</details>

<details>
<summary><b>2255. Count Prefixes of a Given String</b></summary>
</details>

<details>
<summary><b>2256. Minimum Average Difference</b></summary>
</details>

<details>
<summary><b>2257. Count Unguarded Cells in the Grid</b></summary>
</details>

<details>
<summary><b>2258. Escape the Spreading Fire</b></summary>
</details>

<details>
<summary><b>2259. Remove Digit From Number to Maximize Result</b></summary>
</details>

<details>
<summary><b>2260. Minimum Consecutive Cards to Pick Up</b></summary>
</details>

<details>
<summary><b>2261. K Divisible Elements Subarrays</b></summary>
</details>

<details>
<summary><b>2262. Total Appeal of A String</b></summary>
</details>

<details>
<summary><b>2263. Make Array Non-decreasing or Non-increasing</b></summary>
</details>

<details>
<summary><b>2264. Largest</b></summary>
</details>

<details>
<summary><b>2265. Count Nodes Equal to Average of Subtree</b></summary>
</details>

<details>
<summary><b>2266. Count Number of Texts</b></summary>
</details>

<details>
<summary><b>2267. Check if There Is a Valid Parentheses String Path</b></summary>
</details>

<details>
<summary><b>2268. Minimum Number of Keypresses</b></summary>
</details>

<details>
<summary><b>2269. Find the K-Beauty of a Number</b></summary>
</details>

<details>
<summary><b>2270. Number of Ways to Split Array</b></summary>
</details>

<details>
<summary><b>2271. Maximum White Tiles Covered by a Carpet</b></summary>
</details>

<details>
<summary><b>2272. Substring With Largest Variance</b></summary>
</details>

<details>
<summary><b>2273. Find Resultant Array After Removing Anagrams</b></summary>
</details>

<details>
<summary><b>2274. Maximum Consecutive Floors Without Special Floors</b></summary>
</details>

<details>
<summary><b>2275. Largest Combination With Bitwise AND Greater Than Zero</b></summary>
</details>

<details>
<summary><b>2276. Count Integers in Intervals</b></summary>
</details>

<details>
<summary><b>2277. Closest Node to Path in Tree</b></summary>
</details>

<details>
<summary><b>2278. Percentage of Letter in String</b></summary>
</details>

<details>
<summary><b>2279. Maximum Bags With Full Capacity of Rocks</b></summary>
</details>

<details>
<summary><b>2280. Minimum Lines to Represent a Line Chart</b></summary>
</details>

<details>
<summary><b>2281. Sum of Total Strength of Wizards</b></summary>
</details>

<details>
<summary><b>2282. Number of People That Can Be Seen in a Grid</b></summary>
</details>

<details>
<summary><b>2283. Check if Number Has Equal Digit Count and Digit Value</b></summary>
</details>

<details>
<summary><b>2284. Sender With Largest Word Count</b></summary>
</details>

<details>
<summary><b>2285. Maximum Total Importance of Roads</b></summary>
</details>

<details>
<summary><b>2286. Booking Concert Tickets in Groups</b></summary>
</details>

<details>
<summary><b>2287. Rearrange Characters to Make Target String</b></summary>
</details>

<details>
<summary><b>2288. Apply Discount to Prices</b></summary>
</details>

<details>
<summary><b>2289. Steps to Make Array Non-decreasing</b></summary>
</details>

<details>
<summary><b>2290. Minimum Obstacle Removal to Reach Corner</b></summary>
</details>

<details>
<summary><b>2291. Maximum Profit From Trading Stocks</b></summary>
</details>

<details>
<summary><b>2292. Products With Three or More Orders in Two Consecutive Years</b></summary>
</details>

<details>
<summary><b>2293. Min Max Game</b></summary>
</details>

<details>
<summary><b>2294. Partition Array Such That Maximum Difference Is K</b></summary>
</details>

<details>
<summary><b>2295. Replace Elements in an Array</b></summary>
</details>

<details>
<summary><b>2296. Design a Text Editor</b></summary>
</details>

<details>
<summary><b>2297. Jump Game VIII</b></summary>
</details>

<details>
<summary><b>2298. Tasks Count in the Weekend</b></summary>
</details>

<details>
<summary><b>2299. Strong Password Checker II</b></summary>
</details>

<details>
<summary><b>2300. Successful Pairs of Spells and Potions</b></summary>
</details>

<details>
<summary><b>2301. Match Substring After Replacement</b></summary>
</details>

<details>
<summary><b>2302. Count Subarrays With Score Less Than K</b></summary>
</details>

<details>
<summary><b>2303. Calculate Amount Paid in Taxes</b></summary>
</details>

<details>
<summary><b>2304. Minimum Path Cost in a Grid</b></summary>
</details>

<details>
<summary><b>2305. Fair Distribution of Cookies</b></summary>
</details>

<details>
<summary><b>2306. Naming a Company</b></summary>
</details>

<details>
<summary><b>2307. Check for Contradictions in Equations</b></summary>
</details>

<details>
<summary><b>2308. Arrange Table by Gender</b></summary>
</details>

<details>
<summary><b>2309. Greatest English Letter in Upper and Lower Case</b></summary>
</details>

<details>
<summary><b>2310. Sum of Numbers With Units Digit K</b></summary>
</details>

<details>
<summary><b>2311. Longest Binary Subsequence Less Than or Equal to K</b></summary>
</details>

<details>
<summary><b>2312. Selling Pieces of Wood</b></summary>
</details>

<details>
<summary><b>2313. Minimum Flips in Binary Tree to Get Result</b></summary>
</details>

<details>
<summary><b>2314. The First Day of the Maximum Recorded Degree in Each City</b></summary>
</details>

<details>
<summary><b>2315. Count Asterisks</b></summary>
</details>

<details>
<summary><b>2316. Count Unreachable Pairs of Nodes in an Undirected Graph</b></summary>
</details>

<details>
<summary><b>2317. Maximum XOR After Operations</b></summary>
</details>

<details>
<summary><b>2318. Number of Distinct Roll Sequences</b></summary>
</details>

<details>
<summary><b>2319. Check if Matrix Is X-Matrix</b></summary>
</details>

<details>
<summary><b>2320. Count Number of Ways to Place Houses</b></summary>
</details>

<details>
<summary><b>2321. Maximum Score Of Spliced Array</b></summary>
</details>

<details>
<summary><b>2322. Minimum Score After Removals on a Tree</b></summary>
</details>

<details>
<summary><b>2323. Find Minimum Time to Finish All Jobs II</b></summary>
</details>

<details>
<summary><b>2324. Product Sales Analysis IV</b></summary>
</details>

<details>
<summary><b>2325. Decode the Message</b></summary>
</details>

<details>
<summary><b>2326. Spiral Matrix IV</b></summary>
</details>

<details>
<summary><b>2327. Number of People Aware of a Secret</b></summary>
</details>

<details>
<summary><b>2328. Number of Increasing Paths in a Grid</b></summary>
</details>

<details>
<summary><b>2329. Product Sales Analysis V</b></summary>
</details>

<details>
<summary><b>2330. Valid Palindrome IV</b></summary>
</details>

<details>
<summary><b>2331. Evaluate Boolean Binary Tree</b></summary>
</details>

<details>
<summary><b>2332. The Latest Time to Catch a Bus</b></summary>
</details>

<details>
<summary><b>2333. Minimum Sum of Squared Difference</b></summary>
</details>

<details>
<summary><b>2334. Subarray With Elements Greater Than Varying Threshold</b></summary>
</details>

<details>
<summary><b>2335. Minimum Amount of Time to Fill Cups</b></summary>
</details>

<details>
<summary><b>2336. Smallest Number in Infinite Set</b></summary>
</details>

<details>
<summary><b>2337. Move Pieces to Obtain a String</b></summary>
</details>

<details>
<summary><b>2338. Count the Number of Ideal Arrays</b></summary>
</details>

<details>
<summary><b>2339. All the Matches of the League</b></summary>
</details>

<details>
<summary><b>2340. Minimum Adjacent Swaps to Make a Valid Array</b></summary>
</details>

<details>
<summary><b>2341. Maximum Number of Pairs in Array</b></summary>
</details>

<details>
<summary><b>2342. Max Sum of a Pair With Equal Sum of Digits</b></summary>
</details>

<details>
<summary><b>2343. Query Kth Smallest Trimmed Number</b></summary>
</details>

<details>
<summary><b>2344. Minimum Deletions to Make Array Divisible</b></summary>
</details>

<details>
<summary><b>2345. Finding the Number of Visible Mountains</b></summary>
</details>

<details>
<summary><b>2346. Compute the Rank as a Percentage</b></summary>
</details>

<details>
<summary><b>2347. Best Poker Hand</b></summary>
</details>

<details>
<summary><b>2348. Number of Zero-Filled Subarrays</b></summary>
</details>

<details>
<summary><b>2349. Design a Number Container System</b></summary>
</details>

<details>
<summary><b>2350. Shortest Impossible Sequence of Rolls</b></summary>
</details>

<details>
<summary><b>2351. First Letter to Appear Twice</b></summary>
</details>

<details>
<summary><b>2352. Equal Row and Column Pairs</b></summary>
</details>

<details>
<summary><b>2353. Design a Food Rating System</b></summary>
</details>

<details>
<summary><b>2354. Number of Excellent Pairs</b></summary>
</details>

<details>
<summary><b>2355. Maximum Number of Books You Can Take</b></summary>
</details>

<details>
<summary><b>2356. Number of Unique Subjects Taught by Each Teacher</b></summary>
</details>

<details>
<summary><b>2357. Make Array Zero by Subtracting Equal Amounts</b></summary>
</details>

<details>
<summary><b>2358. Maximum Number of Groups Entering a Competition</b></summary>
</details>

<details>
<summary><b>2359. Find Closest Node to Given Two Nodes</b></summary>
</details>

<details>
<summary><b>2360. Longest Cycle in a Graph</b></summary>
</details>

<details>
<summary><b>2361. Minimum Costs Using the Train Line</b></summary>
</details>

<details>
<summary><b>2362. Generate the Invoice</b></summary>
</details>

<details>
<summary><b>2363. Merge Similar Items</b></summary>
</details>

<details>
<summary><b>2364. Count Number of Bad Pairs</b></summary>
</details>

<details>
<summary><b>2365. Task Scheduler II</b></summary>
</details>

<details>
<summary><b>2366. Minimum Replacements to Sort the Array</b></summary>
</details>

<details>
<summary><b>2367. Number of Arithmetic Triplets</b></summary>
</details>

<details>
<summary><b>2368. Reachable Nodes With Restrictions</b></summary>
</details>

<details>
<summary><b>2369. Check if There is a Valid Partition For The Array</b></summary>
</details>

<details>
<summary><b>2370. Longest Ideal Subsequence</b></summary>
</details>

<details>
<summary><b>2371. Minimize Maximum Value in a Grid</b></summary>
</details>

<details>
<summary><b>2372. Calculate the Influence of Each Salesperson</b></summary>
</details>

<details>
<summary><b>2373. Largest Local Values in a Matrix</b></summary>
</details>

<details>
<summary><b>2374. Node With Highest Edge Score</b></summary>
</details>

<details>
<summary><b>2375. Construct Smallest Number From DI String</b></summary>
</details>

<details>
<summary><b>2376. Count Special Integers</b></summary>
</details>

<details>
<summary><b>2377. Sort the Olympic Table</b></summary>
</details>

<details>
<summary><b>2378. Choose Edges to Maximize Score in a Tree</b></summary>
</details>

<details>
<summary><b>2379. Minimum Recolors to Get K Consecutive Black Blocks</b></summary>
</details>

<details>
<summary><b>2380. Time Needed to Rearrange a Binary String</b></summary>
</details>

<details>
<summary><b>2381. Shifting Letters II</b></summary>
</details>

<details>
<summary><b>2382. Maximum Segment Sum After Removals</b></summary>
</details>

<details>
<summary><b>2383. Minimum Hours of Training to Win a Competition</b></summary>
</details>

<details>
<summary><b>2384. Largest Palindromic Number</b></summary>
</details>

<details>
<summary><b>2385. Amount of Time for Binary Tree to Be Infected</b></summary>
</details>

<details>
<summary><b>2386. Find the K-Sum of an Array</b></summary>
</details>

<details>
<summary><b>2387. Median of a Row Wise Sorted Matrix</b></summary>
</details>

<details>
<summary><b>2388. Change Null Values in a Table to the Previous Value</b></summary>
</details>

<details>
<summary><b>2389. Longest Subsequence With Limited Sum</b></summary>
</details>

<details>
<summary><b>2390. Removing Stars From a String</b></summary>
</details>

<details>
<summary><b>2391. Minimum Amount of Time to Collect Garbage</b></summary>
</details>

<details>
<summary><b>2392. Build a Matrix With Conditions</b></summary>
</details>

<details>
<summary><b>2393. Count Strictly Increasing Subarrays</b></summary>
</details>

<details>
<summary><b>2394. Employees With Deductions</b></summary>
</details>

<details>
<summary><b>2395. Find Subarrays With Equal Sum</b></summary>
</details>

<details>
<summary><b>2396. Strictly Palindromic Number</b></summary>
</details>

<details>
<summary><b>2397. Maximum Rows Covered by Columns</b></summary>
</details>

<details>
<summary><b>2398. Maximum Number of Robots Within Budget</b></summary>
</details>

<details>
<summary><b>2399. Check Distances Between Same Letters</b></summary>
</details>

<details>
<summary><b>2400. Number of Ways to Reach a Position After Exactly k Steps</b></summary>
</details>

<details>
<summary><b>2401. Longest Nice Subarray</b></summary>
</details>

<details>
<summary><b>2402. Meeting Rooms III</b></summary>
</details>

<details>
<summary><b>2403. Minimum Time to Kill All Monsters</b></summary>
</details>

<details>
<summary><b>2404. Most Frequent Even Element</b></summary>
</details>

<details>
<summary><b>2405. Optimal Partition of String</b></summary>
</details>

<details>
<summary><b>2406. Divide Intervals Into Minimum Number of Groups</b></summary>
</details>

<details>
<summary><b>2407. Longest Increasing Subsequence II</b></summary>
</details>

<details>
<summary><b>2408. Design SQL</b></summary>
</details>

<details>
<summary><b>2409. Count Days Spent Together</b></summary>
</details>

<details>
<summary><b>2410. Maximum Matching of Players With Trainers</b></summary>
</details>

<details>
<summary><b>2411. Smallest Subarrays With Maximum Bitwise OR</b></summary>
</details>

<details>
<summary><b>2412. Minimum Money Required Before Transactions</b></summary>
</details>

<details>
<summary><b>2413. Smallest Even Multiple</b></summary>
</details>

<details>
<summary><b>2414. Length of the Longest Alphabetical Continuous Substring</b></summary>
</details>

<details>
<summary><b>2415. Reverse Odd Levels of Binary Tree</b></summary>
</details>

<details>
<summary><b>2416. Sum of Prefix Scores of Strings</b></summary>
</details>

<details>
<summary><b>2417. Closest Fair Integer</b></summary>
</details>

<details>
<summary><b>2418. Sort the People</b></summary>
</details>

<details>
<summary><b>2419. Longest Subarray With Maximum Bitwise AND</b></summary>
</details>

<details>
<summary><b>2420. Find All Good Indices</b></summary>
</details>

<details>
<summary><b>2421. Number of Good Paths</b></summary>
</details>

<details>
<summary><b>2422. Merge Operations to Turn Array Into a Palindrome</b></summary>
</details>

<details>
<summary><b>2423. Remove Letter To Equalize Frequency</b></summary>
</details>

<details>
<summary><b>2424. Longest Uploaded Prefix</b></summary>
</details>

<details>
<summary><b>2425. Bitwise XOR of All Pairings</b></summary>
</details>

<details>
<summary><b>2426. Number of Pairs Satisfying Inequality</b></summary>
</details>

<details>
<summary><b>2427. Number of Common Factors</b></summary>
</details>

<details>
<summary><b>2428. Maximum Sum of an Hourglass</b></summary>
</details>

<details>
<summary><b>2429. Minimize XOR</b></summary>
</details>

<details>
<summary><b>2430. Maximum Deletions on a String</b></summary>
</details>

<details>
<summary><b>2431. Maximize Total Tastiness of Purchased Fruits</b></summary>
</details>

<details>
<summary><b>2432. The Employee That Worked on the Longest Task</b></summary>
</details>

<details>
<summary><b>2433. Find The Original Array of Prefix Xor</b></summary>
</details>

<details>
<summary><b>2434. Using a Robot to Print the Lexicographically Smallest String</b></summary>
</details>

<details>
<summary><b>2435. Paths in Matrix Whose Sum Is Divisible by K</b></summary>
</details>

<details>
<summary><b>2436. Minimum Split Into Subarrays With GCD Greater Than One</b></summary>
</details>

<details>
<summary><b>2437. Number of Valid Clock Times</b></summary>
</details>

<details>
<summary><b>2438. Range Product Queries of Powers</b></summary>
</details>

<details>
<summary><b>2439. Minimize Maximum of Array</b></summary>
</details>

<details>
<summary><b>2440. Create Components With Same Value</b></summary>
</details>

<details>
<summary><b>2441. Largest Positive Integer That Exists With Its Negative</b></summary>
</details>

<details>
<summary><b>2442. Count Number of Distinct Integers After Reverse Operations</b></summary>
</details>

<details>
<summary><b>2443. Sum of Number and Its Reverse</b></summary>
</details>

<details>
<summary><b>2444. Count Subarrays With Fixed Bounds</b></summary>
</details>

<details>
<summary><b>2445. Number of Nodes With Value One</b></summary>
</details>

<details>
<summary><b>2446. Determine if Two Events Have Conflict</b></summary>
</details>

<details>
<summary><b>2447. Number of Subarrays With GCD Equal to K</b></summary>
</details>

<details>
<summary><b>2448. Minimum Cost to Make Array Equal</b></summary>
</details>

<details>
<summary><b>2449. Minimum Number of Operations to Make Arrays Similar</b></summary>
</details>

<details>
<summary><b>2450. Number of Distinct Binary Strings After Applying Operations</b></summary>
</details>

<details>
<summary><b>2451. Odd String Difference</b></summary>
</details>

<details>
<summary><b>2452. Words Within Two Edits of Dictionary</b></summary>
</details>

<details>
<summary><b>2453. Destroy Sequential Targets</b></summary>
</details>

<details>
<summary><b>2454. Next Greater Element IV</b></summary>
</details>

<details>
<summary><b>2455. Average Value of Even Numbers That Are Divisible by Three</b></summary>
</details>

<details>
<summary><b>2456. Most Popular Video Creator</b></summary>
</details>

<details>
<summary><b>2457. Minimum Addition to Make Integer Beautiful</b></summary>
</details>

<details>
<summary><b>2458. Height of Binary Tree After Subtree Removal Queries</b></summary>
</details>

<details>
<summary><b>2459. Sort Array by Moving Items to Empty Space</b></summary>
</details>

<details>
<summary><b>2460. Apply Operations to an Array</b></summary>
</details>

<details>
<summary><b>2461. Maximum Sum of Distinct Subarrays With Length K</b></summary>
</details>

<details>
<summary><b>2462. Total Cost to Hire K Workers</b></summary>
</details>

<details>
<summary><b>2463. Minimum Total Distance Traveled</b></summary>
</details>

<details>
<summary><b>2464. Minimum Subarrays in a Valid Split</b></summary>
</details>

<details>
<summary><b>2465. Number of Distinct Averages</b></summary>
</details>

<details>
<summary><b>2466. Count Ways To Build Good Strings</b></summary>
</details>

<details>
<summary><b>2467. Most Profitable Path in a Tree</b></summary>
</details>

<details>
<summary><b>2468. Split Message Based on Limit</b></summary>
</details>

<details>
<summary><b>2469. Convert the Temperature</b></summary>
</details>

<details>
<summary><b>2470. Number of Subarrays With LCM Equal to K</b></summary>
</details>

<details>
<summary><b>2471. Minimum Number of Operations to Sort a Binary Tree by Level</b></summary>
</details>

<details>
<summary><b>2472. Maximum Number of Non-overlapping Palindrome Substrings</b></summary>
</details>

<details>
<summary><b>2473. Minimum Cost to Buy Apples</b></summary>
</details>

<details>
<summary><b>2474. Customers With Strictly Increasing Purchases</b></summary>
</details>

<details>
<summary><b>2475. Number of Unequal Triplets in Array</b></summary>
</details>

<details>
<summary><b>2476. Closest Nodes Queries in a Binary Search Tree</b></summary>
</details>

<details>
<summary><b>2477. Minimum Fuel Cost to Report to the Capital</b></summary>
</details>

<details>
<summary><b>2478. Number of Beautiful Partitions</b></summary>
</details>

<details>
<summary><b>2479. Maximum XOR of Two Non-Overlapping Subtrees</b></summary>
</details>

<details>
<summary><b>2480. Form a Chemical Bond</b></summary>
</details>

<details>
<summary><b>2481. Minimum Cuts to Divide a Circle</b></summary>
</details>

<details>
<summary><b>2482. Difference Between Ones and Zeros in Row and Column</b></summary>
</details>

<details>
<summary><b>2483. Minimum Penalty for a Shop</b></summary>
</details>

<details>
<summary><b>2484. Count Palindromic Subsequences</b></summary>
</details>

<details>
<summary><b>2485. Find the Pivot Integer</b></summary>
</details>

<details>
<summary><b>2486. Append Characters to String to Make Subsequence</b></summary>
</details>

<details>
<summary><b>2487. Remove Nodes From Linked List</b></summary>
</details>

<details>
<summary><b>2488. Count Subarrays With Median K</b></summary>
</details>

<details>
<summary><b>2489. Number of Substrings With Fixed Ratio</b></summary>
</details>

<details>
<summary><b>2490. Circular Sentence</b></summary>
</details>

<details>
<summary><b>2491. Divide Players Into Teams of Equal Skill</b></summary>
</details>

<details>
<summary><b>2492. Minimum Score of a Path Between Two Cities</b></summary>
</details>

<details>
<summary><b>2493. Divide Nodes Into the Maximum Number of Groups</b></summary>
</details>

<details>
<summary><b>2494. Merge Overlapping Events in the Same Hall</b></summary>
</details>

<details>
<summary><b>2495. Number of Subarrays Having Even Product</b></summary>
</details>

<details>
<summary><b>2496. Maximum Value of a String in an Array</b></summary>
</details>

<details>
<summary><b>2497. Maximum Star Sum of a Graph</b></summary>
</details>

<details>
<summary><b>2498. Frog Jump II</b></summary>
</details>

<details>
<summary><b>2499. Minimum Total Cost to Make Arrays Unequal</b></summary>
</details>

<details>
<summary><b>2500. Delete Greatest Value in Each Row</b></summary>
</details>

<details>
<summary><b>2501. Longest Square Streak in an Array</b></summary>
</details>

<details>
<summary><b>2502. Design Memory Allocator</b></summary>
</details>

<details>
<summary><b>2503. Maximum Number of Points From Grid Queries</b></summary>
</details>

<details>
<summary><b>2504. Concatenate the Name and the Profession</b></summary>
</details>

<details>
<summary><b>2505. Bitwise OR of All Subsequence Sums</b></summary>
</details>

<details>
<summary><b>2506. Count Pairs Of Similar Strings</b></summary>
</details>

<details>
<summary><b>2507. Smallest Value After Replacing With Sum of Prime Factors</b></summary>
</details>

<details>
<summary><b>2508. Add Edges to Make Degrees of All Nodes Even</b></summary>
</details>

<details>
<summary><b>2509. Cycle Length Queries in a Tree</b></summary>
</details>

<details>
<summary><b>2510. Check if There is a Path With Equal Number of</b></summary>
</details>

<details>
<summary><b>2511. Maximum Enemy Forts That Can Be Captured</b></summary>
</details>

<details>
<summary><b>2512. Reward Top K Students</b></summary>
</details>

<details>
<summary><b>2513. Minimize the Maximum of Two Arrays</b></summary>
</details>

<details>
<summary><b>2514. Count Anagrams</b></summary>
</details>

<details>
<summary><b>2515. Shortest Distance to Target String in a Circular Array</b></summary>
</details>

<details>
<summary><b>2516. Take K of Each Character From Left and Right</b></summary>
</details>

<details>
<summary><b>2517. Maximum Tastiness of Candy Basket</b></summary>
</details>

<details>
<summary><b>2518. Number of Great Partitions</b></summary>
</details>

<details>
<summary><b>2519. Count the Number of K-Big Indices</b></summary>
</details>

<details>
<summary><b>2520. Count the Digits That Divide a Number</b></summary>
</details>

<details>
<summary><b>2521. Distinct Prime Factors of Product of Array</b></summary>
</details>

<details>
<summary><b>2522. Partition String Into Substrings With Values at Most K</b></summary>
</details>

<details>
<summary><b>2523. Closest Prime Numbers in Range</b></summary>
</details>

<details>
<summary><b>2524. Maximum Frequency Score of a Subarray</b></summary>
</details>

<details>
<summary><b>2525. Categorize Box According to Criteria</b></summary>
</details>

<details>
<summary><b>2526. Find Consecutive Integers from a Data Stream</b></summary>
</details>

<details>
<summary><b>2527. Find Xor-Beauty of Array</b></summary>
</details>

<details>
<summary><b>2528. Maximize the Minimum Powered City</b></summary>
</details>

<details>
<summary><b>2529. Maximum Count of Positive Integer and Negative Integer</b></summary>
</details>

<details>
<summary><b>2530. Maximal Score After Applying K Operations</b></summary>
</details>

<details>
<summary><b>2531. Make Number of Distinct Characters Equal</b></summary>
</details>

<details>
<summary><b>2532. Time to Cross a Bridge</b></summary>
</details>

<details>
<summary><b>2533. Number of Good Binary Strings</b></summary>
</details>

<details>
<summary><b>2534. Time Taken to Cross the Door</b></summary>
</details>

<details>
<summary><b>2535. Difference Between Element Sum and Digit Sum of an Array</b></summary>
</details>

<details>
<summary><b>2536. Increment Submatrices by One</b></summary>
</details>

<details>
<summary><b>2537. Count the Number of Good Subarrays</b></summary>
</details>

<details>
<summary><b>2538. Difference Between Maximum and Minimum Price Sum</b></summary>
</details>

<details>
<summary><b>2539. Count the Number of Good Subsequences</b></summary>
</details>

<details>
<summary><b>2540. Minimum Common Value</b></summary>
</details>

<details>
<summary><b>2541. Minimum Operations to Make Array Equal II</b></summary>
</details>

<details>
<summary><b>2542. Maximum Subsequence Score</b></summary>
</details>

<details>
<summary><b>2543. Check if Point Is Reachable</b></summary>
</details>

<details>
<summary><b>2544. Alternating Digit Sum</b></summary>
</details>

<details>
<summary><b>2545. Sort the Students by Their Kth Score</b></summary>
</details>

<details>
<summary><b>2546. Apply Bitwise Operations to Make Strings Equal</b></summary>
</details>

<details>
<summary><b>2547. Minimum Cost to Split an Array</b></summary>
</details>

<details>
<summary><b>2548. Maximum Price to Fill a Bag</b></summary>
</details>

<details>
<summary><b>2549. Count Distinct Numbers on Board</b></summary>
</details>

<details>
<summary><b>2550. Count Collisions of Monkeys on a Polygon</b></summary>
</details>

<details>
<summary><b>2551. Put Marbles in Bags</b></summary>
</details>

<details>
<summary><b>2552. Count Increasing Quadruplets</b></summary>
</details>

<details>
<summary><b>2553. Separate the Digits in an Array</b></summary>
</details>

<details>
<summary><b>2554. Maximum Number of Integers to Choose From a Range I</b></summary>
</details>

<details>
<summary><b>2555. Maximize Win From Two Segments</b></summary>
</details>

<details>
<summary><b>2556. Disconnect Path in a Binary Matrix by at Most One Flip</b></summary>
</details>

<details>
<summary><b>2557. Maximum Number of Integers to Choose From a Range II</b></summary>
</details>

<details>
<summary><b>2558. Take Gifts From the Richest Pile</b></summary>
</details>

<details>
<summary><b>2559. Count Vowel Strings in Ranges</b></summary>
</details>

<details>
<summary><b>2560. House Robber IV</b></summary>
</details>

<details>
<summary><b>2561. Rearranging Fruits</b></summary>
</details>

<details>
<summary><b>2562. Find the Array Concatenation Value</b></summary>
</details>

<details>
<summary><b>2563. Count the Number of Fair Pairs</b></summary>
</details>

<details>
<summary><b>2564. Substring XOR Queries</b></summary>
</details>

<details>
<summary><b>2565. Subsequence With the Minimum Score</b></summary>
</details>

<details>
<summary><b>2566. Maximum Difference by Remapping a Digit</b></summary>
</details>

<details>
<summary><b>2567. Minimum Score by Changing Two Elements</b></summary>
</details>

<details>
<summary><b>2568. Minimum Impossible OR</b></summary>
</details>

<details>
<summary><b>2569. Handling Sum Queries After Update</b></summary>
</details>

<details>
<summary><b>2570. Merge Two</b></summary>
</details>

<details>
<summary><b>2571. Minimum Operations to Reduce an Integer to</b></summary>
</details>

<details>
<summary><b>2572. Count the Number of Square-Free Subsets</b></summary>
</details>

<details>
<summary><b>2573. Find the String with LCP</b></summary>
</details>

<details>
<summary><b>2574. Left and Right Sum Differences</b></summary>
</details>

<details>
<summary><b>2575. Find the Divisibility Array of a String</b></summary>
</details>

<details>
<summary><b>2576. Find the Maximum Number of Marked Indices</b></summary>
</details>

<details>
<summary><b>2577. Minimum Time to Visit a Cell In a Grid</b></summary>
</details>

<details>
<summary><b>2578. Split With Minimum Sum</b></summary>
</details>

<details>
<summary><b>2579. Count Total Number of Colored Cells</b></summary>
</details>

<details>
<summary><b>2580. Count Ways to Group Overlapping Ranges</b></summary>
</details>

<details>
<summary><b>2581. Count Number of Possible Root Nodes</b></summary>
</details>

<details>
<summary><b>2582. Pass the Pillow</b></summary>
</details>

<details>
<summary><b>2583. Kth Largest Sum in a Binary Tree</b></summary>
</details>

<details>
<summary><b>2584. Split the Array to Make Coprime Products</b></summary>
</details>

<details>
<summary><b>2585. Number of Ways to Earn Points</b></summary>
</details>

<details>
<summary><b>2586. Count the Number of Vowel Strings in Range</b></summary>
</details>

<details>
<summary><b>2587. Rearrange Array to Maximize Prefix Score</b></summary>
</details>

<details>
<summary><b>2588. Count the Number of Beautiful Subarrays</b></summary>
</details>

<details>
<summary><b>2589. Minimum Time to Complete All Tasks</b></summary>
</details>

<details>
<summary><b>2590. Design a Todo List</b></summary>
</details>

<details>
<summary><b>2591. Distribute Money to Maximum Children</b></summary>
</details>

<details>
<summary><b>2592. Maximize Greatness of an Array</b></summary>
</details>

<details>
<summary><b>2593. Find Score of an Array After Marking All Elements</b></summary>
</details>

<details>
<summary><b>2594. Minimum Time to Repair Cars</b></summary>
</details>

<details>
<summary><b>2595. Number of Even and Odd Bits</b></summary>
</details>

<details>
<summary><b>2596. Check Knight Tour Configuration</b></summary>
</details>

<details>
<summary><b>2597. The Number of Beautiful Subsets</b></summary>
</details>

<details>
<summary><b>2598. Smallest Missing Non-negative Integer After Operations</b></summary>
</details>

<details>
<summary><b>2599. Make the Prefix Sum Non-negative</b></summary>
</details>

<details>
<summary><b>2600. K Items With the Maximum Sum</b></summary>
</details>

<details>
<summary><b>2601. Prime Subtraction Operation</b></summary>
</details>

<details>
<summary><b>2602. Minimum Operations to Make All Array Elements Equal</b></summary>
</details>

<details>
<summary><b>2603. Collect Coins in a Tree</b></summary>
</details>

<details>
<summary><b>2604. Minimum Time to Eat All Grains</b></summary>
</details>

<details>
<summary><b>2605. Form Smallest Number From Two Digit Arrays</b></summary>
</details>

<details>
<summary><b>2606. Find the Substring With Maximum Cost</b></summary>
</details>

<details>
<summary><b>2607. Make K-Subarray Sums Equal</b></summary>
</details>

<details>
<summary><b>2608. Shortest Cycle in a Graph</b></summary>
</details>

<details>
<summary><b>2609. Find the Longest Balanced Substring of a Binary String</b></summary>
</details>

<details>
<summary><b>2610. Convert an Array Into a</b></summary>
</details>

<details>
<summary><b>2611. Mice and Cheese</b></summary>
</details>

<details>
<summary><b>2612. Minimum Reverse Operations</b></summary>
</details>

<details>
<summary><b>2613. Beautiful Pairs</b></summary>
</details>

<details>
<summary><b>2614. Prime In Diagonal</b></summary>
</details>

<details>
<summary><b>2615. Sum of Distances</b></summary>
</details>

<details>
<summary><b>2616. Minimize the Maximum Difference of Pairs</b></summary>
</details>

<details>
<summary><b>2617. Minimum Number of Visited Cells in a Grid</b></summary>
</details>

<details>
<summary><b>2618. Check if Object Instance of Class</b></summary>
</details>

<details>
<summary><b>2619. Array Prototype Last</b></summary>
</details>

<details>
<summary><b>2620. Counter</b></summary>
</details>

<details>
<summary><b>2621. Sleep</b></summary>
</details>

<details>
<summary><b>2622. Cache With Time Limit</b></summary>
</details>

<details>
<summary><b>2623. Memoize</b></summary>
</details>

<details>
<summary><b>2624. Snail Traversal</b></summary>
</details>

<details>
<summary><b>2625. Flatten Deeply Nested Array</b></summary>
</details>

<details>
<summary><b>2626. Array Reduce Transformation</b></summary>
</details>

<details>
<summary><b>2627. Debounce</b></summary>
</details>

<details>
<summary><b>2628. JSON Deep Equal</b></summary>
</details>

<details>
<summary><b>2629. Function Composition</b></summary>
</details>

<details>
<summary><b>2630. Memoize II</b></summary>
</details>

<details>
<summary><b>2631. Group By</b></summary>
</details>

<details>
<summary><b>2632. Curry</b></summary>
</details>

<details>
<summary><b>2633. Convert Object to JSON String</b></summary>
</details>

<details>
<summary><b>2634. Filter Elements from Array</b></summary>
</details>

<details>
<summary><b>2635. Apply Transform Over Each Element in Array</b></summary>
</details>

<details>
<summary><b>2636. Promise Pool</b></summary>
</details>

<details>
<summary><b>2637. Promise Time Limit</b></summary>
</details>

<details>
<summary><b>2638. Count the Number of K-Free Subsets</b></summary>
</details>

<details>
<summary><b>2639. Find the Width of Columns of a Grid</b></summary>
</details>

<details>
<summary><b>2640. Find the Score of All Prefixes of an Array</b></summary>
</details>

<details>
<summary><b>2641. Cousins in Binary Tree II</b></summary>
</details>

<details>
<summary><b>2642. Design Graph With Shortest Path Calculator</b></summary>
</details>

<details>
<summary><b>2643. Row With Maximum Ones</b></summary>
</details>

<details>
<summary><b>2644. Find the Maximum Divisibility Score</b></summary>
</details>

<details>
<summary><b>2645. Minimum Additions to Make Valid String</b></summary>
</details>

<details>
<summary><b>2646. Minimize the Total Price of the Trips</b></summary>
</details>

<details>
<summary><b>2647. Color the Triangle Red</b></summary>
</details>

<details>
<summary><b>2648. Generate Fibonacci Sequence</b></summary>
</details>

<details>
<summary><b>2649. Nested Array Generator</b></summary>
</details>

<details>
<summary><b>2650. Design Cancellable Function</b></summary>
</details>

<details>
<summary><b>2651. Calculate Delayed Arrival Time</b></summary>
</details>

<details>
<summary><b>2652. Sum Multiples</b></summary>
</details>

<details>
<summary><b>2653. Sliding Subarray Beauty</b></summary>
</details>

<details>
<summary><b>2654. Minimum Number of Operations to Make All Array Elements Equal to</b></summary>
</details>

<details>
<summary><b>2655. Find Maximal Uncovered Ranges</b></summary>
</details>

<details>
<summary><b>2656. Maximum Sum With Exactly K Elements</b></summary>
</details>

<details>
<summary><b>2657. Find the Prefix Common Array of Two Arrays</b></summary>
</details>

<details>
<summary><b>2658. Maximum Number of Fish in a Grid</b></summary>
</details>

<details>
<summary><b>2659. Make Array Empty</b></summary>
</details>

<details>
<summary><b>2660. Determine the Winner of a Bowling Game</b></summary>
</details>

<details>
<summary><b>2661. First Completely Painted Row or Column</b></summary>
</details>

<details>
<summary><b>2662. Minimum Cost of a Path With Special Roads</b></summary>
</details>

<details>
<summary><b>2663. Lexicographically Smallest Beautiful String</b></summary>
</details>

<details>
<summary><b>2664. The Knight’s Tour</b></summary>
</details>

<details>
<summary><b>2665. Counter II</b></summary>
</details>

<details>
<summary><b>2666. Allow One Function Call</b></summary>
</details>

<details>
<summary><b>2667. Create Hello World Function</b></summary>
</details>

<details>
<summary><b>2668. Find Latest Salaries</b></summary>
</details>

<details>
<summary><b>2669. Count Artist Occurrences On Spotify Ranking List</b></summary>
</details>

<details>
<summary><b>2670. Find the Distinct Difference Array</b></summary>
</details>

<details>
<summary><b>2671. Frequency Tracker</b></summary>
</details>

<details>
<summary><b>2672. Number of Adjacent Elements With the Same Color</b></summary>
</details>

<details>
<summary><b>2673. Make Costs of Paths Equal in a Binary Tree</b></summary>
</details>

<details>
<summary><b>2674. Split a Circular Linked List</b></summary>
</details>

<details>
<summary><b>2675. Array of Objects to Matrix</b></summary>
</details>

<details>
<summary><b>2676. Throttle</b></summary>
</details>

<details>
<summary><b>2677. Chunk Array</b></summary>
</details>

<details>
<summary><b>2678. Number of Senior Citizens</b></summary>
</details>

<details>
<summary><b>2679. Sum in a Matrix</b></summary>
</details>

<details>
<summary><b>2680. Maximum OR</b></summary>
</details>

<details>
<summary><b>2681. Power of Heroes</b></summary>
</details>

<details>
<summary><b>2682. Find the Losers of the Circular Game</b></summary>
</details>

<details>
<summary><b>2683. Neighboring Bitwise XOR</b></summary>
</details>

<details>
<summary><b>2684. Maximum Number of Moves in a Grid</b></summary>
</details>

<details>
<summary><b>2685. Count the Number of Complete Components</b></summary>
</details>

<details>
<summary><b>2686. Immediate Food Delivery III</b></summary>
</details>

<details>
<summary><b>2687. Bikes Last Time Used</b></summary>
</details>

<details>
<summary><b>2688. Find Active Users</b></summary>
</details>

<details>
<summary><b>2689. Extract Kth Character From The Rope Tree</b></summary>
</details>

<details>
<summary><b>2690. Infinite Method Object</b></summary>
</details>

<details>
<summary><b>2691. Immutability Helper</b></summary>
</details>

<details>
<summary><b>2692. Make Object Immutable</b></summary>
</details>

<details>
<summary><b>2693. Call Function with Custom Context</b></summary>
</details>

<details>
<summary><b>2694. Event Emitter</b></summary>
</details>

<details>
<summary><b>2695. Array Wrapper</b></summary>
</details>

<details>
<summary><b>2696. Minimum String Length After Removing Substrings</b></summary>
</details>

<details>
<summary><b>2697. Lexicographically Smallest Palindrome</b></summary>
</details>

<details>
<summary><b>2698. Find the Punishment Number of an Integer</b></summary>
</details>

<details>
<summary><b>2699. Modify Graph Edge Weights</b></summary>
</details>

<details>
<summary><b>2700. Differences Between Two Objects</b></summary>
</details>

<details>
<summary><b>2701. Consecutive Transactions with Increasing Amounts</b></summary>
</details>

<details>
<summary><b>2702. Minimum Operations to Make Numbers Non-positive</b></summary>
</details>

<details>
<summary><b>2703. Return Length of Arguments Passed</b></summary>
</details>

<details>
<summary><b>2704. To Be Or Not To Be</b></summary>
</details>

<details>
<summary><b>2705. Compact Object</b></summary>
</details>

<details>
<summary><b>2706. Buy Two Chocolates</b></summary>
</details>

<details>
<summary><b>2707. Extra Characters in a String</b></summary>
</details>

<details>
<summary><b>2708. Maximum Strength of a Group</b></summary>
</details>

<details>
<summary><b>2709. Greatest Common Divisor Traversal</b></summary>
</details>

<details>
<summary><b>2710. Remove Trailing Zeros From a String</b></summary>
</details>

<details>
<summary><b>2711. Difference of Number of Distinct Values on Diagonals</b></summary>
</details>

<details>
<summary><b>2712. Minimum Cost to Make All Characters Equal</b></summary>
</details>

<details>
<summary><b>2713. Maximum Strictly Increasing Cells in a Matrix</b></summary>
</details>

<details>
<summary><b>2714. Find Shortest Path with K Hops</b></summary>
</details>

<details>
<summary><b>2715. Timeout Cancellation</b></summary>
</details>

<details>
<summary><b>2716. Minimize String Length</b></summary>
</details>

<details>
<summary><b>2717. Semi-Ordered Permutation</b></summary>
</details>

<details>
<summary><b>2718. Sum of Matrix After Queries</b></summary>
</details>

<details>
<summary><b>2719. Count of Integers</b></summary>
</details>

<details>
<summary><b>2720. Popularity Percentage</b></summary>
</details>

<details>
<summary><b>2721. Execute Asynchronous Functions in Parallel</b></summary>
</details>

<details>
<summary><b>2722. Join Two Arrays by ID</b></summary>
</details>

<details>
<summary><b>2723. Add Two Promises</b></summary>
</details>

<details>
<summary><b>2724. Sort By</b></summary>
</details>

<details>
<summary><b>2725. Interval Cancellation</b></summary>
</details>

<details>
<summary><b>2726. Calculator with Method Chaining</b></summary>
</details>

<details>
<summary><b>2727. Is Object Empty</b></summary>
</details>

<details>
<summary><b>2728. Count Houses in a Circular Street</b></summary>
</details>

<details>
<summary><b>2729. Check if The Number is Fascinating</b></summary>
</details>

<details>
<summary><b>2730. Find the Longest Semi-Repetitive Substring</b></summary>
</details>

<details>
<summary><b>2731. Movement of Robots</b></summary>
</details>

<details>
<summary><b>2732. Find a Good Subset of the Matrix</b></summary>
</details>

<details>
<summary><b>2733. Neither Minimum nor Maximum</b></summary>
</details>

<details>
<summary><b>2734. Lexicographically Smallest String After Substring Operation</b></summary>
</details>

<details>
<summary><b>2735. Collecting Chocolates</b></summary>
</details>

<details>
<summary><b>2736. Maximum Sum Queries</b></summary>
</details>

<details>
<summary><b>2737. Find the Closest Marked Node</b></summary>
</details>

<details>
<summary><b>2738. Count Occurrences in Text</b></summary>
</details>

<details>
<summary><b>2739. Total Distance Traveled</b></summary>
</details>

<details>
<summary><b>2740. Find the Value of the Partition</b></summary>
</details>

<details>
<summary><b>2741. Special Permutations</b></summary>
</details>

<details>
<summary><b>2742. Painting the Walls</b></summary>
</details>

<details>
<summary><b>2743. Count Substrings Without Repeating Character</b></summary>
</details>

<details>
<summary><b>2744. Find Maximum Number of String Pairs</b></summary>
</details>

<details>
<summary><b>2745. Construct the Longest New String</b></summary>
</details>

<details>
<summary><b>2746. Decremental String Concatenation</b></summary>
</details>

<details>
<summary><b>2747. Count Zero Request Servers</b></summary>
</details>

<details>
<summary><b>2748. Number of Beautiful Pairs</b></summary>
</details>

<details>
<summary><b>2749. Minimum Operations to Make the Integer Zero</b></summary>
</details>

<details>
<summary><b>2750. Ways to Split Array Into Good Subarrays</b></summary>
</details>

<details>
<summary><b>2751. Robot Collisions</b></summary>
</details>

<details>
<summary><b>2752. Customers with Maximum Number of Transactions on Consecutive Days</b></summary>
</details>

<details>
<summary><b>2753. Count Houses in a Circular Street II</b></summary>
</details>

<details>
<summary><b>2754. Bind Function to Context</b></summary>
</details>

<details>
<summary><b>2755. Deep Merge of Two Objects</b></summary>
</details>

<details>
<summary><b>2756. Query Batching</b></summary>
</details>

<details>
<summary><b>2757. Generate Circular Array Values</b></summary>
</details>

<details>
<summary><b>2758. Next Day</b></summary>
</details>

<details>
<summary><b>2759. Convert JSON String to Object</b></summary>
</details>

<details>
<summary><b>2760. Longest Even Odd Subarray With Threshold</b></summary>
</details>

<details>
<summary><b>2761. Prime Pairs With Target Sum</b></summary>
</details>

<details>
<summary><b>2762. Continuous Subarrays</b></summary>
</details>

<details>
<summary><b>2763. Sum of Imbalance Numbers of All Subarrays</b></summary>
</details>

<details>
<summary><b>2764. Is Array a Preorder of Some ‌Binary Tree</b></summary>
</details>

<details>
<summary><b>2765. Longest Alternating Subarray</b></summary>
</details>

<details>
<summary><b>2766. Relocate Marbles</b></summary>
</details>

<details>
<summary><b>2767. Partition String Into Minimum Beautiful Substrings</b></summary>
</details>

<details>
<summary><b>2768. Number of Black Blocks</b></summary>
</details>

<details>
<summary><b>2769. Find the Maximum Achievable Number</b></summary>
</details>

<details>
<summary><b>2770. Maximum Number of Jumps to Reach the Last Index</b></summary>
</details>

<details>
<summary><b>2771. Longest Non-decreasing Subarray From Two Arrays</b></summary>
</details>

<details>
<summary><b>2772. Apply Operations to Make All Array Elements Equal to Zero</b></summary>
</details>

<details>
<summary><b>2773. Height of Special Binary Tree</b></summary>
</details>

<details>
<summary><b>2774. Array Upper Bound</b></summary>
</details>

<details>
<summary><b>2775. Undefined to Null</b></summary>
</details>

<details>
<summary><b>2776. Convert Callback Based Function to Promise Based Function</b></summary>
</details>

<details>
<summary><b>2777. Date Range Generator</b></summary>
</details>

<details>
<summary><b>2778. Sum of Squares of Special Elements</b></summary>
</details>

<details>
<summary><b>2779. Maximum Beauty of an Array After Applying Operation</b></summary>
</details>

<details>
<summary><b>2780. Minimum Index of a Valid Split</b></summary>
</details>

<details>
<summary><b>2781. Length of the Longest Valid Substring</b></summary>
</details>

<details>
<summary><b>2782. Number of Unique Categories</b></summary>
</details>

<details>
<summary><b>2783. Flight Occupancy and Waitlist Analysis</b></summary>
</details>

<details>
<summary><b>2784. Check if Array is Good</b></summary>
</details>

<details>
<summary><b>2785. Sort Vowels in a String</b></summary>
</details>

<details>
<summary><b>2786. Visit Array Positions to Maximize Score</b></summary>
</details>

<details>
<summary><b>2787. Ways to Express an Integer as Sum of Powers</b></summary>
</details>

<details>
<summary><b>2788. Split Strings by Separator</b></summary>
</details>

<details>
<summary><b>2789. Largest Element in an Array after Merge Operations</b></summary>
</details>

<details>
<summary><b>2790. Maximum Number of Groups With Increasing Length</b></summary>
</details>

<details>
<summary><b>2791. Count Paths That Can Form a Palindrome in a Tree</b></summary>
</details>

<details>
<summary><b>2792. Count Nodes That Are Great Enough</b></summary>
</details>

<details>
<summary><b>2793. Status of Flight Tickets</b></summary>
</details>

<details>
<summary><b>2794. Create Object from Two Arrays</b></summary>
</details>

<details>
<summary><b>2795. Parallel Execution of Promises for Individual Results Retrieval</b></summary>
</details>

<details>
<summary><b>2796. Repeat String</b></summary>
</details>

<details>
<summary><b>2797. Partial Function with Placeholders</b></summary>
</details>

<details>
<summary><b>2798. Number of Employees Who Met the Target</b></summary>
</details>

<details>
<summary><b>2799. Count Complete Subarrays in an Array</b></summary>
</details>

<details>
<summary><b>2800. Shortest String That Contains Three Strings</b></summary>
</details>

<details>
<summary><b>2801. Count Stepping Numbers in Range</b></summary>
</details>

<details>
<summary><b>2802. Find The K-th Lucky Number</b></summary>
</details>

<details>
<summary><b>2803. Factorial Generator</b></summary>
</details>

<details>
<summary><b>2804. Array Prototype ForEach</b></summary>
</details>

<details>
<summary><b>2805. Custom Interval</b></summary>
</details>

<details>
<summary><b>2806. Account Balance After Rounded Purchase</b></summary>
</details>

<details>
<summary><b>2807. Insert Greatest Common Divisors in Linked List</b></summary>
</details>

<details>
<summary><b>2808. Minimum Seconds to Equalize a Circular Array</b></summary>
</details>

<details>
<summary><b>2809. Minimum Time to Make Array Sum At Most x</b></summary>
</details>

<details>
<summary><b>2810. Faulty Keyboard</b></summary>
</details>

<details>
<summary><b>2811. Check if it is Possible to Split Array</b></summary>
</details>

<details>
<summary><b>2812. Find the Safest Path in a Grid</b></summary>
</details>

<details>
<summary><b>2813. Maximum Elegance of a K-Length Subsequence</b></summary>
</details>

<details>
<summary><b>2814. Minimum Time Takes to Reach Destination Without Drowning</b></summary>
</details>

<details>
<summary><b>2815. Max Pair Sum in an Array</b></summary>
</details>

<details>
<summary><b>2816. Double a Number Represented as a Linked List</b></summary>
</details>

<details>
<summary><b>2817. Minimum Absolute Difference Between Elements With Constraint</b></summary>
</details>

<details>
<summary><b>2818. Apply Operations to Maximize Score</b></summary>
</details>

<details>
<summary><b>2819. Minimum Relative Loss After Buying Chocolates</b></summary>
</details>

<details>
<summary><b>2820. Election Results</b></summary>
</details>

<details>
<summary><b>2821. Delay the Resolution of Each Promise</b></summary>
</details>

<details>
<summary><b>2822. Inversion of Object</b></summary>
</details>

<details>
<summary><b>2823. Deep Object Filter</b></summary>
</details>

<details>
<summary><b>2824. Count Pairs Whose Sum is Less than Target</b></summary>
</details>

<details>
<summary><b>2825. Make String a Subsequence Using Cyclic Increments</b></summary>
</details>

<details>
<summary><b>2826. Sorting Three Groups</b></summary>
</details>

<details>
<summary><b>2827. Number of Beautiful Integers in the Range</b></summary>
</details>

<details>
<summary><b>2828. Check if a String Is an Acronym of Words</b></summary>
</details>

<details>
<summary><b>2829. Determine the Minimum Sum of a k-avoiding Array</b></summary>
</details>

<details>
<summary><b>2830. Maximize the Profit as the Salesman</b></summary>
</details>

<details>
<summary><b>2831. Find the Longest Equal Subarray</b></summary>
</details>

<details>
<summary><b>2832. Maximal Range That Each Element Is Maximum in It</b></summary>
</details>

<details>
<summary><b>2833. Furthest Point From Origin</b></summary>
</details>

<details>
<summary><b>2834. Find the Minimum Possible Sum of a Beautiful Array</b></summary>
</details>

<details>
<summary><b>2835. Minimum Operations to Form Subsequence With Target Sum</b></summary>
</details>

<details>
<summary><b>2836. Maximize Value of Function in a Ball Passing Game</b></summary>
</details>

<details>
<summary><b>2837. Total Traveled Distance</b></summary>
</details>

<details>
<summary><b>2838. Maximum Coins Heroes Can Collect</b></summary>
</details>

<details>
<summary><b>2839. Check if Strings Can be Made Equal With Operations I</b></summary>
</details>

<details>
<summary><b>2840. Check if Strings Can be Made Equal With Operations II</b></summary>
</details>

<details>
<summary><b>2841. Maximum Sum of Almost Unique Subarray</b></summary>
</details>

<details>
<summary><b>2842. Count K-Subsequences of a String With Maximum Beauty</b></summary>
</details>

<details>
<summary><b>2843. Count Symmetric Integers</b></summary>
</details>

<details>
<summary><b>2844. Minimum Operations to Make a Special Number</b></summary>
</details>

<details>
<summary><b>2845. Count of Interesting Subarrays</b></summary>
</details>

<details>
<summary><b>2846. Minimum Edge Weight Equilibrium Queries in a Tree</b></summary>
</details>

<details>
<summary><b>2847. Smallest Number With Given Digit Product</b></summary>
</details>

<details>
<summary><b>2848. Points That Intersect With Cars</b></summary>
</details>

<details>
<summary><b>2849. Determine if a Cell Is Reachable at a Given Time</b></summary>
</details>

<details>
<summary><b>2850. Minimum Moves to Spread Stones Over Grid</b></summary>
</details>

<details>
<summary><b>2851. String Transformation</b></summary>
</details>

<details>
<summary><b>2852. Sum of Remoteness of All Cells</b></summary>
</details>

<details>
<summary><b>2853. Highest Salaries Difference</b></summary>
</details>

<details>
<summary><b>2854. Rolling Average Steps</b></summary>
</details>

<details>
<summary><b>2855. Minimum Right Shifts to Sort the Array</b></summary>
</details>

<details>
<summary><b>2856. Minimum Array Length After Pair Removals</b></summary>
</details>

<details>
<summary><b>2857. Count Pairs of Points With Distance k</b></summary>
</details>

<details>
<summary><b>2858. Minimum Edge Reversals So Every Node Is Reachable</b></summary>
</details>

<details>
<summary><b>2859. Sum of Values at Indices With K Set Bits</b></summary>
</details>

<details>
<summary><b>2860. Happy Students</b></summary>
</details>

<details>
<summary><b>2861. Maximum Number of Alloys</b></summary>
</details>

<details>
<summary><b>2862. Maximum Element-Sum of a Complete Subset of Indices</b></summary>
</details>

<details>
<summary><b>2863. Maximum Length of Semi-Decreasing Subarrays</b></summary>
</details>

<details>
<summary><b>2864. Maximum Odd Binary Number</b></summary>
</details>

<details>
<summary><b>2865. Beautiful Towers I</b></summary>
</details>

<details>
<summary><b>2866. Beautiful Towers II</b></summary>
</details>

<details>
<summary><b>2867. Count Valid Paths in a Tree</b></summary>
</details>

<details>
<summary><b>2868. The Wording Game</b></summary>
</details>

<details>
<summary><b>2869. Minimum Operations to Collect Elements</b></summary>
</details>

<details>
<summary><b>2870. Minimum Number of Operations to Make Array Empty</b></summary>
</details>

<details>
<summary><b>2871. Split Array Into Maximum Number of Subarrays</b></summary>
</details>

<details>
<summary><b>2872. Maximum Number of K-Divisible Components</b></summary>
</details>

<details>
<summary><b>2873. Maximum Value of an Ordered Triplet I</b></summary>
</details>

<details>
<summary><b>2874. Maximum Value of an Ordered Triplet II</b></summary>
</details>

<details>
<summary><b>2875. Minimum Size Subarray in Infinite Array</b></summary>
</details>

<details>
<summary><b>2876. Count Visited Nodes in a Directed Graph</b></summary>
</details>

<details>
<summary><b>2877. Create a DataFrame from List</b></summary>
</details>

<details>
<summary><b>2878. Get the Size of a DataFrame</b></summary>
</details>

<details>
<summary><b>2879. Display the First Three Rows</b></summary>
</details>

<details>
<summary><b>2880. Select Data</b></summary>
</details>

<details>
<summary><b>2881. Create a New Column</b></summary>
</details>

<details>
<summary><b>2882. Drop Duplicate Rows</b></summary>
</details>

<details>
<summary><b>2883. Drop Missing Data</b></summary>
</details>

<details>
<summary><b>2884. Modify Columns</b></summary>
</details>

<details>
<summary><b>2885. Rename Columns</b></summary>
</details>

<details>
<summary><b>2886. Change Data Type</b></summary>
</details>

<details>
<summary><b>2887. Fill Missing Data</b></summary>
</details>

<details>
<summary><b>2888. Reshape Data: Concatenate</b></summary>
</details>

<details>
<summary><b>2889. Reshape Data: Pivot</b></summary>
</details>

<details>
<summary><b>2890. Reshape Data: Melt</b></summary>
</details>

<details>
<summary><b>2891. Method Chaining</b></summary>
</details>

<details>
<summary><b>2892. Minimizing Array After Replacing Pairs With Their Product</b></summary>
</details>

<details>
<summary><b>2893. Calculate Orders Within Each Interval</b></summary>
</details>

<details>
<summary><b>2894. Divisible and Non-divisible Sums Difference</b></summary>
</details>

<details>
<summary><b>2895. Minimum Processing Time</b></summary>
</details>

<details>
<summary><b>2896. Apply Operations to Make Two Strings Equal</b></summary>
</details>

<details>
<summary><b>2897. Apply Operations on Array to Maximize Sum of Squares</b></summary>
</details>

<details>
<summary><b>2898. Maximum Linear Stock Score</b></summary>
</details>

<details>
<summary><b>2899. Last Visited Integers</b></summary>
</details>

<details>
<summary><b>2900. Longest Unequal Adjacent Groups Subsequence I</b></summary>
</details>

<details>
<summary><b>2901. Longest Unequal Adjacent Groups Subsequence II</b></summary>
</details>

<details>
<summary><b>2902. Count of Sub-Multisets With Bounded Sum</b></summary>
</details>

<details>
<summary><b>2903. Find Indices With Index and Value Difference I</b></summary>
</details>

<details>
<summary><b>2904. Shortest and Lexicographically Smallest Beautiful String</b></summary>
</details>

<details>
<summary><b>2905. Find Indices With Index and Value Difference II</b></summary>
</details>

<details>
<summary><b>2906. Construct Product Matrix</b></summary>
</details>

<details>
<summary><b>2907. Maximum Profitable Triplets With Increasing Prices I</b></summary>
</details>

<details>
<summary><b>2908. Minimum Sum of Mountain Triplets I</b></summary>
</details>

<details>
<summary><b>2909. Minimum Sum of Mountain Triplets II</b></summary>
</details>

<details>
<summary><b>2910. Minimum Number of Groups to Create a Valid Assignment</b></summary>
</details>

<details>
<summary><b>2911. Minimum Changes to Make K Semi-palindromes</b></summary>
</details>

<details>
<summary><b>2912. Number of Ways to Reach Destination in the Grid</b></summary>
</details>

<details>
<summary><b>2913. Subarrays Distinct Element Sum of Squares I</b></summary>
</details>

<details>
<summary><b>2914. Minimum Number of Changes to Make Binary String Beautiful</b></summary>
</details>

<details>
<summary><b>2915. Length of the Longest Subsequence That Sums to Target</b></summary>
</details>

<details>
<summary><b>2916. Subarrays Distinct Element Sum of Squares II</b></summary>
</details>

<details>
<summary><b>2917. Find the K-or of an Array</b></summary>
</details>

<details>
<summary><b>2918. Minimum Equal Sum of Two Arrays After Replacing Zeros</b></summary>
</details>

<details>
<summary><b>2919. Minimum Increment Operations to Make Array Beautiful</b></summary>
</details>

<details>
<summary><b>2920. Maximum Points After Collecting Coins From All Nodes</b></summary>
</details>

<details>
<summary><b>2921. Maximum Profitable Triplets With Increasing Prices II</b></summary>
</details>

<details>
<summary><b>2922. Market Analysis III</b></summary>
</details>

<details>
<summary><b>2923. Find Champion I</b></summary>
</details>

<details>
<summary><b>2924. Find Champion II</b></summary>
</details>

<details>
<summary><b>2925. Maximum Score After Applying Operations on a Tree</b></summary>
</details>

<details>
<summary><b>2926. Maximum Balanced Subsequence Sum</b></summary>
</details>

<details>
<summary><b>2927. Distribute Candies Among Children III</b></summary>
</details>

<details>
<summary><b>2928. Distribute Candies Among Children I</b></summary>
</details>

<details>
<summary><b>2929. Distribute Candies Among Children II</b></summary>
</details>

<details>
<summary><b>2930. Number of Strings Which Can Be Rearranged to Contain Substring</b></summary>
</details>

<details>
<summary><b>2931. Maximum Spending After Buying Items</b></summary>
</details>

<details>
<summary><b>2932. Maximum Strong Pair XOR I</b></summary>
</details>

<details>
<summary><b>2933. High-Access Employees</b></summary>
</details>

<details>
<summary><b>2934. Minimum Operations to Maximize Last Elements in Arrays</b></summary>
</details>

<details>
<summary><b>2935. Maximum Strong Pair XOR II</b></summary>
</details>

<details>
<summary><b>2936. Number of Equal Numbers Blocks</b></summary>
</details>

<details>
<summary><b>2937. Make Three Strings Equal</b></summary>
</details>

<details>
<summary><b>2938. Separate Black and White Balls</b></summary>
</details>

<details>
<summary><b>2939. Maximum Xor Product</b></summary>
</details>

<details>
<summary><b>2940. Find Building Where Alice and Bob Can Meet</b></summary>
</details>

<details>
<summary><b>2941. Maximum GCD-Sum of a Subarray</b></summary>
</details>

<details>
<summary><b>2942. Find Words Containing Character</b></summary>
</details>

<details>
<summary><b>2943. Maximize Area of Square Hole in Grid</b></summary>
</details>

<details>
<summary><b>2944. Minimum Number of Coins for Fruits</b></summary>
</details>

<details>
<summary><b>2945. Find Maximum Non-decreasing Array Length</b></summary>
</details>

<details>
<summary><b>2946. Matrix Similarity After Cyclic Shifts</b></summary>
</details>

<details>
<summary><b>2947. Count Beautiful Substrings I</b></summary>
</details>

<details>
<summary><b>2948. Make Lexicographically Smallest Array by Swapping Elements</b></summary>
</details>

<details>
<summary><b>2949. Count Beautiful Substrings II</b></summary>
</details>

<details>
<summary><b>2950. Number of Divisible Substrings</b></summary>
</details>

<details>
<summary><b>2951. Find the Peaks</b></summary>
</details>

<details>
<summary><b>2952. Minimum Number of Coins to be Added</b></summary>
</details>

<details>
<summary><b>2953. Count Complete Substrings</b></summary>
</details>

<details>
<summary><b>2954. Count the Number of Infection Sequences</b></summary>
</details>

<details>
<summary><b>2955. Number of Same-End Substrings</b></summary>
</details>

<details>
<summary><b>2956. Find Common Elements Between Two Arrays</b></summary>
</details>

<details>
<summary><b>2957. Remove Adjacent Almost-Equal Characters</b></summary>
</details>

<details>
<summary><b>2958. Length of Longest Subarray With at Most K Frequency</b></summary>
</details>

<details>
<summary><b>2959. Number of Possible Sets of Closing Branches</b></summary>
</details>

<details>
<summary><b>2960. Count Tested Devices After Test Operations</b></summary>
</details>

<details>
<summary><b>2961. Double Modular Exponentiation</b></summary>
</details>

<details>
<summary><b>2962. Count Subarrays Where Max Element Appears at Least K Times</b></summary>
</details>

<details>
<summary><b>2963. Count the Number of Good Partitions</b></summary>
</details>

<details>
<summary><b>2964. Number of Divisible Triplet Sums</b></summary>
</details>

<details>
<summary><b>2965. Find Missing and Repeated Values</b></summary>
</details>

<details>
<summary><b>2966. Divide Array Into Arrays With Max Difference</b></summary>
</details>

<details>
<summary><b>2967. Minimum Cost to Make Array Equalindromic</b></summary>
</details>

<details>
<summary><b>2968. Apply Operations to Maximize Frequency Score</b></summary>
</details>

<details>
<summary><b>2969. Minimum Number of Coins for Fruits II</b></summary>
</details>

<details>
<summary><b>2970. Count the Number of Incremovable Subarrays I</b></summary>
</details>

<details>
<summary><b>2971. Find Polygon With the Largest Perimeter</b></summary>
</details>

<details>
<summary><b>2972. Count the Number of Incremovable Subarrays II</b></summary>
</details>

<details>
<summary><b>2973. Find Number of Coins to Place in Tree Nodes</b></summary>
</details>

<details>
<summary><b>2974. Minimum Number Game</b></summary>
</details>

<details>
<summary><b>2975. Maximum Square Area by Removing Fences From a Field</b></summary>
</details>

<details>
<summary><b>2976. Minimum Cost to Convert String I</b></summary>
</details>

<details>
<summary><b>2977. Minimum Cost to Convert String II</b></summary>
</details>

<details>
<summary><b>2978. Symmetric Coordinates</b></summary>
</details>

<details>
<summary><b>2979. Most Expensive Item That Can Not Be Bought</b></summary>
</details>

<details>
<summary><b>2980. Check if Bitwise OR Has Trailing Zeros</b></summary>
</details>

<details>
<summary><b>2981. Find Longest Special Substring That Occurs Thrice I</b></summary>
</details>

<details>
<summary><b>2982. Find Longest Special Substring That Occurs Thrice II</b></summary>
</details>

<details>
<summary><b>2983. Palindrome Rearrangement Queries</b></summary>
</details>

<details>
<summary><b>2984. Find Peak Calling Hours for Each City</b></summary>
</details>

<details>
<summary><b>2985. Calculate Compressed Mean</b></summary>
</details>

<details>
<summary><b>2986. Find Third Transaction</b></summary>
</details>

<details>
<summary><b>2987. Find Expensive Cities</b></summary>
</details>

<details>
<summary><b>2988. Manager of the Largest Department</b></summary>
</details>

<details>
<summary><b>2989. Class Performance</b></summary>
</details>

<details>
<summary><b>2990. Loan Types</b></summary>
</details>

<details>
<summary><b>2991. Top Three Wineries</b></summary>
</details>

<details>
<summary><b>2992. Number of Self-Divisible Permutations</b></summary>
</details>

<details>
<summary><b>2993. Friday Purchases I</b></summary>
</details>

<details>
<summary><b>2994. Friday Purchases II</b></summary>
</details>

<details>
<summary><b>2995. Viewers Turned Streamers</b></summary>
</details>

<details>
<summary><b>2996. Smallest Missing Integer Greater Than Sequential Prefix Sum</b></summary>
</details>

<details>
<summary><b>2997. Minimum Number of Operations to Make Array XOR Equal to K</b></summary>
</details>

<details>
<summary><b>2998. Minimum Number of Operations to Make X and Y Equal</b></summary>
</details>

<details>
<summary><b>2999. Count the Number of Powerful Integers</b></summary>
</details>

<details>
<summary><b>3000. Maximum Area of Longest Diagonal Rectangle</b></summary>
</details>

<details>
<summary><b>3001. Minimum Moves to Capture The Queen</b></summary>
</details>

<details>
<summary><b>3002. Maximum Size of a Set After Removals</b></summary>
</details>

<details>
<summary><b>3003. Maximize the Number of Partitions After Operations</b></summary>
</details>

<details>
<summary><b>3004. Maximum Subtree of the Same Color</b></summary>
</details>

<details>
<summary><b>3005. Count Elements With Maximum Frequency</b></summary>
</details>

<details>
<summary><b>3006. Find Beautiful Indices in the Given Array I</b></summary>
</details>

<details>
<summary><b>3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K</b></summary>
</details>

<details>
<summary><b>3008. Find Beautiful Indices in the Given Array II</b></summary>
</details>

<details>
<summary><b>3009. Maximum Number of Intersections on the Chart</b></summary>
</details>

<details>
<summary><b>3010. Divide an Array Into Subarrays With Minimum Cost I</b></summary>
</details>

<details>
<summary><b>3011. Find if Array Can Be Sorted</b></summary>
</details>

<details>
<summary><b>3012. Minimize Length of Array Using Operations</b></summary>
</details>

<details>
<summary><b>3013. Divide an Array Into Subarrays With Minimum Cost II</b></summary>
</details>

<details>
<summary><b>3014. Minimum Number of Pushes to Type Word I</b></summary>
</details>

<details>
<summary><b>3015. Count the Number of Houses at a Certain Distance I</b></summary>
</details>

<details>
<summary><b>3016. Minimum Number of Pushes to Type Word II</b></summary>
</details>

<details>
<summary><b>3017. Count the Number of Houses at a Certain Distance II</b></summary>
</details>

<details>
<summary><b>3018. Maximum Number of Removal Queries That Can Be Processed I</b></summary>
</details>

<details>
<summary><b>3019. Number of Changing Keys</b></summary>
</details>

<details>
<summary><b>3020. Find the Maximum Number of Elements in Subset</b></summary>
</details>

<details>
<summary><b>3021. Alice and Bob Playing Flower Game</b></summary>
</details>

<details>
<summary><b>3022. Minimize OR of Remaining Elements Using Operations</b></summary>
</details>

<details>
<summary><b>3023. Find Pattern in Infinite Stream I</b></summary>
</details>

<details>
<summary><b>3024. Type of Triangle</b></summary>
</details>

<details>
<summary><b>3025. Find the Number of Ways to Place People I</b></summary>
</details>

<details>
<summary><b>3026. Maximum Good Subarray Sum</b></summary>
</details>

<details>
<summary><b>3027. Find the Number of Ways to Place People II</b></summary>
</details>

<details>
<summary><b>3028. Ant on the Boundary</b></summary>
</details>

<details>
<summary><b>3029. Minimum Time to Revert Word to Initial State I</b></summary>
</details>

<details>
<summary><b>3030. Find the Grid of Region Average</b></summary>
</details>

<details>
<summary><b>3031. Minimum Time to Revert Word to Initial State II</b></summary>
</details>

<details>
<summary><b>3032. Count Numbers With Unique Digits II</b></summary>
</details>

<details>
<summary><b>3033. Modify the Matrix</b></summary>
</details>

<details>
<summary><b>3034. Number of Subarrays That Match a Pattern I</b></summary>
</details>

<details>
<summary><b>3035. Maximum Palindromes After Operations</b></summary>
</details>

<details>
<summary><b>3036. Number of Subarrays That Match a Pattern II</b></summary>
</details>

<details>
<summary><b>3037. Find Pattern in Infinite Stream II</b></summary>
</details>

<details>
<summary><b>3038. Maximum Number of Operations With the Same Score I</b></summary>
</details>

<details>
<summary><b>3039. Apply Operations to Make String Empty</b></summary>
</details>

<details>
<summary><b>3040. Maximum Number of Operations With the Same Score II</b></summary>
</details>

<details>
<summary><b>3041. Maximize Consecutive Elements in an Array After Modification</b></summary>
</details>

<details>
<summary><b>3042. Count Prefix and Suffix Pairs I</b></summary>
</details>

<details>
<summary><b>3043. Find the Length of the Longest Common Prefix</b></summary>
</details>

<details>
<summary><b>3044. Most Frequent Prime</b></summary>
</details>

<details>
<summary><b>3045. Count Prefix and Suffix Pairs II</b></summary>
</details>

<details>
<summary><b>3046. Split the Array</b></summary>
</details>

<details>
<summary><b>3047. Find the Largest Area of Square Inside Two Rectangles</b></summary>
</details>

<details>
<summary><b>3048. Earliest Second to Mark Indices I</b></summary>
</details>

<details>
<summary><b>3049. Earliest Second to Mark Indices II</b></summary>
</details>

<details>
<summary><b>3050. Pizza Toppings Cost Analysis</b></summary>
</details>

<details>
<summary><b>3051. Find Candidates for Data Scientist Position</b></summary>
</details>

<details>
<summary><b>3052. Maximize Items</b></summary>
</details>

<details>
<summary><b>3053. Classifying Triangles by Lengths</b></summary>
</details>

<details>
<summary><b>3054. Binary Tree Nodes</b></summary>
</details>

<details>
<summary><b>3055. Top Percentile Fraud</b></summary>
</details>

<details>
<summary><b>3056. Snaps Analysis</b></summary>
</details>

<details>
<summary><b>3057. Employees Project Allocation</b></summary>
</details>

<details>
<summary><b>3058. Friends With No Mutual Friends</b></summary>
</details>

<details>
<summary><b>3059. Find All Unique Email Domains</b></summary>
</details>

<details>
<summary><b>3060. User Activities within Time Bounds</b></summary>
</details>

<details>
<summary><b>3061. Calculate Trapping Rain Water</b></summary>
</details>

<details>
<summary><b>3062. Winner of the Linked List Game</b></summary>
</details>

<details>
<summary><b>3063. Linked List Frequency</b></summary>
</details>

<details>
<summary><b>3064. Guess the Number Using Bitwise Questions I</b></summary>
</details>

<details>
<summary><b>3065. Minimum Operations to Exceed Threshold Value I</b></summary>
</details>

<details>
<summary><b>3066. Minimum Operations to Exceed Threshold Value II</b></summary>
</details>

<details>
<summary><b>3067. Count Pairs of Connectable Servers in a Weighted Tree Network</b></summary>
</details>

<details>
<summary><b>3068. Find the Maximum Sum of Node Values</b></summary>
</details>

<details>
<summary><b>3069. Distribute Elements Into Two Arrays I</b></summary>
</details>

<details>
<summary><b>3070. Count Submatrices with Top-Left Element and Sum Less Than k</b></summary>
</details>

<details>
<summary><b>3071. Minimum Operations to Write the Letter Y on a Grid</b></summary>
</details>

<details>
<summary><b>3072. Distribute Elements Into Two Arrays II</b></summary>
</details>

<details>
<summary><b>3073. Maximum Increasing Triplet Value</b></summary>
</details>

<details>
<summary><b>3074. Apple Redistribution into Boxes</b></summary>
</details>

<details>
<summary><b>3075. Maximize Happiness of Selected Children</b></summary>
</details>

<details>
<summary><b>3076. Shortest Uncommon Substring in an Array</b></summary>
</details>

<details>
<summary><b>3077. Maximum Strength of K Disjoint Subarrays</b></summary>
</details>

<details>
<summary><b>3078. Match Alphanumerical Pattern in Matrix I</b></summary>
</details>

<details>
<summary><b>3079. Find the Sum of Encrypted Integers</b></summary>
</details>

<details>
<summary><b>3080. Mark Elements on Array by Performing Queries</b></summary>
</details>

<details>
<summary><b>3081. Replace Question Marks in String to Minimize Its Value</b></summary>
</details>

<details>
<summary><b>3082. Find the Sum of the Power of All Subsequences</b></summary>
</details>

<details>
<summary><b>3083. Existence of a Substring in a String and Its Reverse</b></summary>
</details>

<details>
<summary><b>3084. Count Substrings Starting and Ending with Given Character</b></summary>
</details>

<details>
<summary><b>3085. Minimum Deletions to Make String K-Special</b></summary>
</details>

<details>
<summary><b>3086. Minimum Moves to Pick K Ones</b></summary>
</details>

<details>
<summary><b>3087. Find Trending Hashtags</b></summary>
</details>

<details>
<summary><b>3088. Make String Anti-palindrome</b></summary>
</details>

<details>
<summary><b>3089. Find Bursty Behavior</b></summary>
</details>

<details>
<summary><b>3090. Maximum Length Substring With Two Occurrences</b></summary>
</details>

<details>
<summary><b>3091. Apply Operations to Make Sum of Array Greater Than or Equal to k</b></summary>
</details>

<details>
<summary><b>3092. Most Frequent IDs</b></summary>
</details>

<details>
<summary><b>3093. Longest Common Suffix Queries</b></summary>
</details>

<details>
<summary><b>3094. Guess the Number Using Bitwise Questions II</b></summary>
</details>

<details>
<summary><b>3095. Shortest Subarray With OR at Least K I</b></summary>
</details>

<details>
<summary><b>3096. Minimum Levels to Gain More Points</b></summary>
</details>

<details>
<summary><b>3097. Shortest Subarray With OR at Least K II</b></summary>
</details>

<details>
<summary><b>3098. Find the Sum of Subsequence Powers</b></summary>
</details>

<details>
<summary><b>3099. Harshad Number</b></summary>
</details>

<details>
<summary><b>3100. Water Bottles II</b></summary>
</details>

<details>
<summary><b>3101. Count Alternating Subarrays</b></summary>
</details>

<details>
<summary><b>3102. Minimize Manhattan Distances</b></summary>
</details>

<details>
<summary><b>3103. Find Trending Hashtags II</b></summary>
</details>

<details>
<summary><b>3104. Find Longest Self-Contained Substring</b></summary>
</details>

<details>
<summary><b>3105. Longest Strictly Increasing or Strictly Decreasing Subarray</b></summary>
</details>

<details>
<summary><b>3106. Lexicographically Smallest String After Operations With Constraint</b></summary>
</details>

<details>
<summary><b>3107. Minimum Operations to Make Median of Array Equal to K</b></summary>
</details>

<details>
<summary><b>3108. Minimum Cost Walk in Weighted Graph</b></summary>
</details>

<details>
<summary><b>3109. Find the Index of Permutation</b></summary>
</details>

<details>
<summary><b>3110. Score of a String</b></summary>
</details>

<details>
<summary><b>3111. Minimum Rectangles to Cover Points</b></summary>
</details>

<details>
<summary><b>3112. Minimum Time to Visit Disappearing Nodes</b></summary>
</details>

<details>
<summary><b>3113. Find the Number of Subarrays Where Boundary Elements Are Maximum</b></summary>
</details>

<details>
<summary><b>3114. Latest Time You Can Obtain After Replacing Characters</b></summary>
</details>

<details>
<summary><b>3115. Maximum Prime Difference</b></summary>
</details>

<details>
<summary><b>3116. Kth Smallest Amount With Single Denomination Combination</b></summary>
</details>

<details>
<summary><b>3117. Minimum Sum of Values by Dividing Array</b></summary>
</details>

<details>
<summary><b>3118. Friday Purchase III</b></summary>
</details>

<details>
<summary><b>3119. Maximum Number of Potholes That Can Be Fixed</b></summary>
</details>

<details>
<summary><b>3120. Count the Number of Special Characters I</b></summary>
</details>

<details>
<summary><b>3121. Count the Number of Special Characters II</b></summary>
</details>

<details>
<summary><b>3122. Minimum Number of Operations to Satisfy Conditions</b></summary>
</details>

<details>
<summary><b>3123. Find Edges in Shortest Paths</b></summary>
</details>

<details>
<summary><b>3124. Find Longest Calls</b></summary>
</details>

<details>
<summary><b>3125. Maximum Number That Makes Result of Bitwise AND Zero</b></summary>
</details>

<details>
<summary><b>3126. Server Utilization Time</b></summary>
</details>

<details>
<summary><b>3127. Make a Square with the Same Color</b></summary>
</details>

<details>
<summary><b>3128. Right Triangles</b></summary>
</details>

<details>
<summary><b>3129. Find All Possible Stable Binary Arrays I</b></summary>
</details>

<details>
<summary><b>3130. Find All Possible Stable Binary Arrays II</b></summary>
</details>

<details>
<summary><b>3131. Find the Integer Added to Array I</b></summary>
</details>

<details>
<summary><b>3132. Find the Integer Added to Array II</b></summary>
</details>

<details>
<summary><b>3133. Minimum Array End</b></summary>
</details>

<details>
<summary><b>3134. Find the Median of the Uniqueness Array</b></summary>
</details>

<details>
<summary><b>3135. Equalize Strings by Adding or Removing Characters at Ends</b></summary>
</details>

<details>
<summary><b>3136. Valid Word</b></summary>
</details>

<details>
<summary><b>3137. Minimum Number of Operations to Make Word K-Periodic</b></summary>
</details>

<details>
<summary><b>3138. Minimum Length of Anagram Concatenation</b></summary>
</details>

<details>
<summary><b>3139. Minimum Cost to Equalize Array</b></summary>
</details>

<details>
<summary><b>3140. Consecutive Available Seats II</b></summary>
</details>

<details>
<summary><b>3141. Maximum Hamming Distances</b></summary>
</details>

<details>
<summary><b>3142. Check if Grid Satisfies Conditions</b></summary>
</details>

<details>
<summary><b>3143. Maximum Points Inside the Square</b></summary>
</details>

<details>
<summary><b>3144. Minimum Substring Partition of Equal Character Frequency</b></summary>
</details>

<details>
<summary><b>3145. Find Products of Elements of Big Array</b></summary>
</details>

<details>
<summary><b>3146. Permutation Difference between Two Strings</b></summary>
</details>

<details>
<summary><b>3147. Taking Maximum Energy From the Mystic Dungeon</b></summary>
</details>

<details>
<summary><b>3148. Maximum Difference Score in a Grid</b></summary>
</details>

<details>
<summary><b>3149. Find the Minimum Cost Array Permutation</b></summary>
</details>

<details>
<summary><b>3150. Invalid Tweets II</b></summary>
</details>

<details>
<summary><b>3151. Special Array I</b></summary>
</details>

<details>
<summary><b>3152. Special Array II</b></summary>
</details>

<details>
<summary><b>3153. Sum of Digit Differences of All Pairs</b></summary>
</details>

<details>
<summary><b>3154. Find Number of Ways to Reach the K-th Stair</b></summary>
</details>

<details>
<summary><b>3155. Maximum Number of Upgradable Servers</b></summary>
</details>

<details>
<summary><b>3156. Employee Task Duration and Concurrent Tasks</b></summary>
</details>

<details>
<summary><b>3157. Find the Level of Tree with Minimum Sum</b></summary>
</details>

<details>
<summary><b>3158. Find the XOR of Numbers Which Appear Twice</b></summary>
</details>

<details>
<summary><b>3159. Find Occurrences of an Element in an Array</b></summary>
</details>

<details>
<summary><b>3160. Find the Number of Distinct Colors Among the Balls</b></summary>
</details>

<details>
<summary><b>3161. Block Placement Queries</b></summary>
</details>

<details>
<summary><b>3162. Find the Number of Good Pairs I</b></summary>
</details>

<details>
<summary><b>3163. String Compression III</b></summary>
</details>

<details>
<summary><b>3164. Find the Number of Good Pairs II</b></summary>
</details>

<details>
<summary><b>3165. Maximum Sum of Subsequence With Non-adjacent Elements</b></summary>
</details>

<details>
<summary><b>3166. Calculate Parking Fees and Duration</b></summary>
</details>

<details>
<summary><b>3167. Better Compression of String</b></summary>
</details>

<details>
<summary><b>3168. Minimum Number of Chairs in a Waiting Room</b></summary>
</details>

<details>
<summary><b>3169. Count Days Without Meetings</b></summary>
</details>

<details>
<summary><b>3170. Lexicographically Minimum String After Removing Stars</b></summary>
</details>

<details>
<summary><b>3171. Find Subarray With Bitwise OR Closest to K</b></summary>
</details>

<details>
<summary><b>3172. Second Day Verification</b></summary>
</details>

<details>
<summary><b>3173. Bitwise OR of Adjacent Elements</b></summary>
</details>

<details>
<summary><b>3174. Clear Digits</b></summary>
</details>

<details>
<summary><b>3175. Find The First Player to win K Games in a Row</b></summary>
</details>

<details>
<summary><b>3176. Find the Maximum Length of a Good Subsequence I</b></summary>
</details>

<details>
<summary><b>3177. Find the Maximum Length of a Good Subsequence II</b></summary>
</details>

<details>
<summary><b>3178. Find the Child Who Has the Ball After K Seconds</b></summary>
</details>

<details>
<summary><b>3179. Find the N-th Value After K Seconds</b></summary>
</details>

<details>
<summary><b>3180. Maximum Total Reward Using Operations I</b></summary>
</details>

<details>
<summary><b>3181. Maximum Total Reward Using Operations II</b></summary>
</details>

<details>
<summary><b>3182. Find Top Scoring Students</b></summary>
</details>

<details>
<summary><b>3183. The Number of Ways to Make the Sum</b></summary>
</details>

<details>
<summary><b>3184. Count Pairs That Form a Complete Day I</b></summary>
</details>

<details>
<summary><b>3185. Count Pairs That Form a Complete Day II</b></summary>
</details>

<details>
<summary><b>3186. Maximum Total Damage With Spell Casting</b></summary>
</details>

<details>
<summary><b>3187. Peaks in Array</b></summary>
</details>

<details>
<summary><b>3188. Find Top Scoring Students II</b></summary>
</details>

<details>
<summary><b>3189. Minimum Moves to Get a Peaceful Board</b></summary>
</details>

<details>
<summary><b>3190. Find Minimum Operations to Make All Elements Divisible by Three</b></summary>
</details>

<details>
<summary><b>3191. Minimum Operations to Make Binary Array Elements Equal to One I</b></summary>
</details>

<details>
<summary><b>3192. Minimum Operations to Make Binary Array Elements Equal to One II</b></summary>
</details>

<details>
<summary><b>3193. Count the Number of Inversions</b></summary>
</details>

<details>
<summary><b>3194. Minimum Average of Smallest and Largest Elements</b></summary>
</details>

<details>
<summary><b>3195. Find the Minimum Area to Cover All Ones I</b></summary>
</details>

<details>
<summary><b>3196. Maximize Total Cost of Alternating Subarrays</b></summary>
</details>

<details>
<summary><b>3197. Find the Minimum Area to Cover All Ones II</b></summary>
</details>

<details>
<summary><b>3198. Find Cities in Each State</b></summary>
</details>

<details>
<summary><b>3199. Count Triplets with Even XOR Set Bits I</b></summary>
</details>

<details>
<summary><b>3200. Maximum Height of a Triangle</b></summary>
</details>

<details>
<summary><b>3201. Find the Maximum Length of Valid Subsequence I</b></summary>
</details>

<details>
<summary><b>3202. Find the Maximum Length of Valid Subsequence II</b></summary>
</details>

<details>
<summary><b>3203. Find Minimum Diameter After Merging Two Trees</b></summary>
</details>

<details>
<summary><b>3204. Bitwise User Permissions Analysis</b></summary>
</details>

<details>
<summary><b>3205. Maximum Array Hopping Score I</b></summary>
</details>

<details>
<summary><b>3206. Alternating Groups I</b></summary>
</details>

<details>
<summary><b>3207. Maximum Points After Enemy Battles</b></summary>
</details>

<details>
<summary><b>3208. Alternating Groups II</b></summary>
</details>

<details>
<summary><b>3209. Number of Subarrays With AND Value of K</b></summary>
</details>

<details>
<summary><b>3210. Find the Encrypted String</b></summary>
</details>

<details>
<summary><b>3211. Generate Binary Strings Without Adjacent Zeros</b></summary>
</details>

<details>
<summary><b>3212. Count Submatrices With Equal Frequency of X and Y</b></summary>
</details>

<details>
<summary><b>3213. Construct String with Minimum Cost</b></summary>
</details>

<details>
<summary><b>3214. Year on Year Growth Rate</b></summary>
</details>

<details>
<summary><b>3215. Count Triplets with Even XOR Set Bits II</b></summary>
</details>

<details>
<summary><b>3216. Lexicographically Smallest String After a Swap</b></summary>
</details>

<details>
<summary><b>3217. Delete Nodes From Linked List Present in Array</b></summary>
</details>

<details>
<summary><b>3218. Minimum Cost for Cutting Cake I</b></summary>
</details>

<details>
<summary><b>3219. Minimum Cost for Cutting Cake II</b></summary>
</details>

<details>
<summary><b>3220. Odd and Even Transactions</b></summary>
</details>

<details>
<summary><b>3221. Maximum Array Hopping Score II</b></summary>
</details>

<details>
<summary><b>3222. Find the Winning Player in Coin Game</b></summary>
</details>

<details>
<summary><b>3223. Minimum Length of String After Operations</b></summary>
</details>

<details>
<summary><b>3224. Minimum Array Changes to Make Differences Equal</b></summary>
</details>

<details>
<summary><b>3225. Maximum Score From Grid Operations</b></summary>
</details>

<details>
<summary><b>3226. Number of Bit Changes to Make Two Integers Equal</b></summary>
</details>

<details>
<summary><b>3227. Vowels Game in a String</b></summary>
</details>

<details>
<summary><b>3228. Maximum Number of Operations to Move Ones to the End</b></summary>
</details>

<details>
<summary><b>3229. Minimum Operations to Make Array Equal to Target</b></summary>
</details>

<details>
<summary><b>3230. Customer Purchasing Behavior Analysis</b></summary>
</details>

<details>
<summary><b>3231. Minimum Number of Increasing Subsequence to Be Removed</b></summary>
</details>

<details>
<summary><b>3232. Find if Digit Game Can Be Won</b></summary>
</details>

<details>
<summary><b>3233. Find the Count of Numbers Which Are Not Special</b></summary>
</details>

<details>
<summary><b>3234. Count the Number of Substrings With Dominant Ones</b></summary>
</details>

<details>
<summary><b>3235. Check if the Rectangle Corner Is Reachable</b></summary>
</details>

<details>
<summary><b>3236. CEO Subordinate Hierarchy</b></summary>
</details>

<details>
<summary><b>3237. Alt and Tab Simulation</b></summary>
</details>

<details>
<summary><b>3238. Find the Number of Winning Players</b></summary>
</details>

<details>
<summary><b>3239. Minimum Number of Flips to Make Binary Grid Palindromic I</b></summary>
</details>

<details>
<summary><b>3240. Minimum Number of Flips to Make Binary Grid Palindromic II</b></summary>
</details>

<details>
<summary><b>3241. Time Taken to Mark All Nodes</b></summary>
</details>

<details>
<summary><b>3242. Design Neighbor Sum Service</b></summary>
</details>

<details>
<summary><b>3243. Shortest Distance After Road Addition Queries I</b></summary>
</details>

<details>
<summary><b>3244. Shortest Distance After Road Addition Queries II</b></summary>
</details>

<details>
<summary><b>3245. Alternating Groups III</b></summary>
</details>

<details>
<summary><b>3246. Premier League Table Ranking</b></summary>
</details>

<details>
<summary><b>3247. Number of Subsequences with Odd Sum</b></summary>
</details>

<details>
<summary><b>3248. Snake in Matrix</b></summary>
</details>

<details>
<summary><b>3249. Count the Number of Good Nodes</b></summary>
</details>

<details>
<summary><b>3250. Find the Count of Monotonic Pairs I</b></summary>
</details>

<details>
<summary><b>3251. Find the Count of Monotonic Pairs II</b></summary>
</details>

<details>
<summary><b>3252. Premier League Table Ranking II</b></summary>
</details>

<details>
<summary><b>3253. Construct String with Minimum Cost ()</b></summary>
</details>

<details>
<summary><b>3254. Find the Power of K-Size Subarrays I</b></summary>
</details>

<details>
<summary><b>3255. Find the Power of K-Size Subarrays II</b></summary>
</details>

<details>
<summary><b>3256. Maximum Value Sum by Placing Three Rooks I</b></summary>
</details>

<details>
<summary><b>3257. Maximum Value Sum by Placing Three Rooks II</b></summary>
</details>

<details>
<summary><b>3258. Count Substrings That Satisfy K-Constraint I</b></summary>
</details>

<details>
<summary><b>3259. Maximum Energy Boost From Two Drinks</b></summary>
</details>

<details>
<summary><b>3260. Find the Largest Palindrome Divisible by K</b></summary>
</details>

<details>
<summary><b>3261. Count Substrings That Satisfy K-Constraint II</b></summary>
</details>

<details>
<summary><b>3262. Find Overlapping Shifts</b></summary>
</details>

<details>
<summary><b>3263. Convert Doubly Linked List to Array I</b></summary>
</details>

<details>
<summary><b>3264. Final Array State After K Multiplication Operations I</b></summary>
</details>

<details>
<summary><b>3265. Count Almost Equal Pairs I</b></summary>
</details>

<details>
<summary><b>3266. Final Array State After K Multiplication Operations II</b></summary>
</details>

<details>
<summary><b>3267. Count Almost Equal Pairs II</b></summary>
</details>

<details>
<summary><b>3268. Find Overlapping Shifts II</b></summary>
</details>

<details>
<summary><b>3269. Constructing Two Increasing Arrays</b></summary>
</details>

<details>
<summary><b>3270. Find the Key of the Numbers</b></summary>
</details>

<details>
<summary><b>3271. Hash Divided String</b></summary>
</details>

<details>
<summary><b>3272. Find the Count of Good Integers</b></summary>
</details>

<details>
<summary><b>3273. Minimum Amount of Damage Dealt to Bob</b></summary>
</details>

<details>
<summary><b>3274. Check if Two Chessboard Squares Have the Same Color</b></summary>
</details>

<details>
<summary><b>3275. K-th Nearest Obstacle Queries</b></summary>
</details>

<details>
<summary><b>3276. Select Cells in Grid With Maximum Score</b></summary>
</details>

<details>
<summary><b>3277. Maximum XOR Score Subarray Queries</b></summary>
</details>

<details>
<summary><b>3278. Find Candidates for Data Scientist Position II</b></summary>
</details>

<details>
<summary><b>3279. Maximum Total Area Occupied by Pistons</b></summary>
</details>

<details>
<summary><b>3280. Convert Date to Binary</b></summary>
</details>

<details>
<summary><b>3281. Maximize Score of Numbers in Ranges</b></summary>
</details>

<details>
<summary><b>3282. Reach End of Array With Max Score</b></summary>
</details>

<details>
<summary><b>3283. Maximum Number of Moves to Kill All Pawns</b></summary>
</details>

<details>
<summary><b>3284. Sum of Consecutive Subarrays</b></summary>
</details>

