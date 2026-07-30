// Problem number 146
// import java.util.*;

// class LRUCache {
//     class Node {
//         int key, value;
//         Node prev, next;
//         Node(int key, int value) {
//             this.key = key;
//             this.value = value;
//         }
//     }
//     private int capacity;
//     private Map<Integer, Node> map;
//     private Node head, tail;
//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         map = new HashMap<>();
//         head = new Node(0, 0);
//         tail = new Node(0, 0);
//         head.next = tail;
//         tail.prev = head;
//     }

//     private void remove(Node node) {
//         node.prev.next = node.next;
//         node.next.prev = node.prev;
//     }

//     private void insert(Node node) {
//         node.next = head.next;
//         node.prev = head;

//         head.next.prev = node;
//         head.next = node;
//     }
//     public int get(int key) {
//         if (!map.containsKey(key))
//             return -1;
//         Node node = map.get(key);
//         remove(node);
//         insert(node);
//         return node.value;
//     }
//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             Node node = map.get(key);
//             node.value = value;
//             remove(node);
//             insert(node);
//         } else {
//             if (map.size() == capacity) {
//                 Node lru = tail.prev;
//                 remove(lru);
//                 map.remove(lru.key);
//             }
//             Node newNode = new Node(key, value);
//             insert(newNode);
//             map.put(key, newNode);
//         }
//     }
// }


// problem number 23 Merge k Sorted Lists
// import java.util.PriorityQueue;
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new PriorityQueue<>(
//             (a, b) -> a.val - b.val
//         );
//         for (ListNode node : lists) {
//             if (node != null) {
//                 pq.offer(node);
//             }
//         }
//         ListNode dummy = new ListNode(0);
//         ListNode current = dummy;
//         while (!pq.isEmpty()) {
//             ListNode node = pq.poll();
//             current.next = node;
//             current = current.next;
//             if (node.next != null) {
//                 pq.offer(node.next);
//             }
//         }
//         return dummy.next;
//     }
// }
// Problem number 695 Max Area of Island
// class Solution {
//     public int maxAreaOfIsland(int[][] grid) {
//         int maxArea = 0;

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 1) {
//                     maxArea = Math.max(maxArea, dfs(grid, i, j));
//                 }
//             }
//         }
//         return maxArea;
//     }
//     private int dfs(int[][] grid, int row, int col) {
//         if (row < 0 || row >= grid.length ||
//             col < 0 || col >= grid[0].length ||
//             grid[row][col] == 0) {
//             return 0;
//         }
//         grid[row][col] = 0; // Mark as visited
//         return 1
//                 + dfs(grid, row + 1, col)
//                 + dfs(grid, row - 1, col)
//                 + dfs(grid, row, col + 1)
//                 + dfs(grid, row, col - 1);
//     }
// }
// Problem number 733 Flood Fill
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {

//         int originalColor = image[sr][sc];

//         if (originalColor == color) {
//             return image;
//         }

//         dfs(image, sr, sc, originalColor, color);
//         return image;
//     }

//     private void dfs(int[][] image, int row, int col, int originalColor, int color) {

//         if (row < 0 || row >= image.length ||
//             col < 0 || col >= image[0].length ||
//             image[row][col] != originalColor) {
//             return;
//         }

//         image[row][col] = color;

//         dfs(image, row + 1, col, originalColor, color);
//         dfs(image, row - 1, col, originalColor, color);
//         dfs(image, row, col + 1, originalColor, color);
//         dfs(image, row, col - 1, originalColor, color);
//     }
// }
