import algorithm.LinkedList.ReverseLinkedList;
import algorithm.sort.SortTestHelper;
import jzoffer.model.ListNode;
import jzoffer.model.TreeNode;
import org.omg.CORBA.WrongTransactionHolder;

import java.util.*;
import java.util.jar.JarEntry;

public class Test {


    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                SortTestHelper.swap(arr, j, i);
            }
        }

        SortTestHelper.swap(arr, l, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static boolean search(int[][] array, int target) {

        int row = 0;
        int col = array[0].length - 1;

        while (col >= 0 && row <= array.length - 1) {
            if (array[col][row] == target) {
                return true;
            } else if (array[col][row] < target) {
                row++;
            } else if (array[col][row] > target) {
                col--;
            }
        }
        return false;
    }

    public int minNumberInRotateArray(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[l]) {
                l = m;
            } else {
                h = m + 1;
            }
        }
        return nums[l];
    }

    public static void reorderOddEven(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (start < end && arr[start] % 2 != 0) {
                start++;
            }

            if (start < end && arr[end] % 2 == 0) {
                end--;
            }

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static int findGreatestSumOfSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        for (int i : arr) {
            if (curMax <= 0) {
                curMax = i;
            } else {
                curMax += i;
            }
            if (curMax > max) {
                max = curMax;
            }
        }
        return max;
    }

    public String printMinNumber(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);

        }
        return sb.toString();
    }

    public boolean isPalindrome(int x) {
        int div = 1;
        while (div <= x / 10) {
            div *= 10;
        }

        while (x > 0) {
            if (x / div != x % 10) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            helper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    private void helper(char[] chars, int index, ArrayList<String> res) {
        if (index == chars.length - 1) {
            String string = String.valueOf(chars);
            if (!res.contains(string)) res.add(string);
        } else {
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                helper(chars, index + 1, res);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static char[] reverseSentence(char[] data) {
        reverse(data, 0, data.length - 1);

        int start = 0, end = 0;
        while (start < data.length) {
            if (data[start] == ' ') {
                start++;
                end++;
            } else if (data[end] == ' ') {
                reverse(data, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return data;
    }

    public static void reverse(char[] data, int start, int end) {
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end++;
        }
    }

    public static char[] leftRotateString(char[] data, int n) {
        reverse(data, 0, n);
        reverse(data, n + 1, data.length - 1);
        reverse(data, 0, data.length - 1);
        return data;
    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (len > 0) return len;
            } else {
                len++;
            }
        }
        return len;
    }

    public static String replaceSpace(char[] charArray) {
        int spaceNum = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                spaceNum++;
            }
        }
        if (spaceNum == 0) return new String(charArray);

        int oldIndex = charArray.length - 1;
        int newLength = charArray.length + spaceNum * 2;
        int newIndex = newLength - 1;
        char[] newChar = new char[newLength];

        while (oldIndex >= 0) {
            if (charArray[oldIndex] == ' ') {
                newChar[newIndex] = '0';
                newChar[newIndex - 1] = 2;
                newChar[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                newChar[newIndex] = charArray[oldIndex];
                newIndex--;
            }
            oldIndex++;
        }
        return new String(newChar);
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {

            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }


    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1.next == null) ? pHead2 : l1.next;
            l2 = (l2.next == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return cur;
    }

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {

        if (tobeDelete.next != null) {
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            ListNode cur = head;
            while (cur.next != tobeDelete) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode p1 = head;
        for (int i = 1; i < k; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }

        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();

//        Stack<Integer> stack = new Stack<>();
//        ListNode cur = listNode;
//        while (cur.next != null) {
//            stack.push(cur.val);
//            cur = cur.next;
//        }
//        while (stack.isEmpty()) {
//            result.add(stack.pop());
//        }

        if (listNode.next != null) {
            result.addAll(printListFromTailToHead(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
//        if (head1.val < head2.val) {
//            head1.next = merge(head1.next,head2);
//            return head1;
//        }else {
//            head2.next = merge(head1,head2.next);
//            return head2;
//        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) cur.next = head1;
        if (head2 != null) cur.next = head2;

        return head.next;

    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(-1);
        ListNode leftCur = leftDummy;

        ListNode rightDummy = new ListNode(-1);
        ListNode rightCur = leftDummy;

        ListNode runner = head;
        while (runner != null) {
            if (runner.val < x) {
                leftCur.next = runner;
                leftCur = leftCur.next;
            } else {
                rightCur.next = runner;
                rightCur = rightCur.next;
            }
            runner = runner.next;
        }
        rightCur.next = null;
        leftCur.next = rightDummy.next;
        return leftDummy.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast != null) slow = slow.next;
        ListNode newHead = reverse(slow);
        fast = head;

        while (newHead != null) {
            if (newHead.val != fast.val) return false;
            fast = fast.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    class LC {

        class Node {
            Node pre, next;
            int key, val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private int capacity;
        private HashMap<Integer, Node> hashMap = new HashMap<>();
        private Node head = new Node(-1, -1);
        private Node tail = new Node(-1, -1);

        public LC(int capacity) {
            this.capacity = capacity;
        }

        private void set(int key, int value) {
            Node node = hashMap.get(key);
            if (node == null) {
                node = new Node(key, value);
                hashMap.put(key, node);
                moveToTail(node);
            } else {
                node.val = value;
                node.pre.next = node.next;
                node.next.pre = node.pre;
                moveToTail(node);
            }
            if (hashMap.size() > capacity) {
                hashMap.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }

        private int get(int key) {
            Node node = hashMap.get(key);
            if (node != null) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                moveToTail(node);
                return node.val;
            }
            return -1;
        }

        private void moveToTail(Node node) {
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
        }
    }

    class MyQueue {
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        private void push(int value) {
            pushStack.push(value);
        }

        private int pop() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("empty!");
            }
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }
    }

    class MyStack {
        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        private boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        private void push(int value) {
            if (!queue1.isEmpty()) {
                queue1.offer(value);
            } else {
                queue2.offer(value);
            }
        }

        private int pop() {
            if (isEmpty()) throw new RuntimeException("empty");
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            } else {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            }
        }
    }

    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        private void push(int value) {
            stack.push(value);
            if (minStack.isEmpty() || value < minStack.peek()) {
                minStack.push(value);
            } else {
                minStack.push(minStack.peek());
            }
        }

        private int pop() {
            if (stack.isEmpty()) throw new RuntimeException("empty");
            minStack.pop();
            return stack.pop();
        }

        private int min() {
            if (minStack.isEmpty()) throw new RuntimeException("empty");
            return minStack.peek();
        }
    }

    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushSequence.length; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int pre[], int startPre, int endPre,
                                          int in[], int startIn, int endIn) {
        if (startPre < endPre || startIn < endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSubTree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }

    public void mirror(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }

    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start <= end) return true;
        int right = start;

        while (right < end - 1 && sequence[right] > sequence[end]) {
            right++;
        }

        int index = right;
        while (index < end - 1) {
            if (sequence[index] < sequence[end]) {
                return false;
            }
        }
        return verifySequenceOfBST(sequence, start, right - 1) && verifySequenceOfBST(sequence, right, end - 1);
    }

    public static void findPath(TreeNode root, int expectedSum) {
        if (root == null) return;
        LinkedList<TreeNode> result = new LinkedList<>();
        findPath(root, 0, expectedSum, result);
    }

    public static void findPath(TreeNode root, int curSum, int expectedSum, LinkedList<TreeNode> result) {
        if (root == null) return;
        curSum += root.val;
        result.add(root);
        if (curSum < expectedSum) {
            findPath(root.left, curSum, expectedSum, result);
            findPath(root.right, curSum, expectedSum, result);
        } else if (curSum == expectedSum) {
            if (root.left == null && root.right == null) {
                System.out.println(result);
            }
        }
        result.remove(result.size() - 1);
    }

    int count = 0;
    TreeNode resultNode;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return resultNode;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            resultNode = root;
        }
        inOrder(root, k);
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    public boolean isBalanced2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) queue.poll();
        }
        return queue.peek();
    }

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        int f1 = 0;
        int f2 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public static int JumpFloor(int n) {
        if (n <= 0) return -1;
        if (n <= 2) return n;
//        return JumpFloor(n - 1) + JumpFloor(n - 2);
        int f1 = 1;
        int f2 = 2;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow *= base;
        }
        return isNegative ? 1 / pow : pow;
    }

    public void print1ToMaxOfNDigits(int n) {
        char[] chars = new char[n];
        print1ToMaxOfNDigits(chars,0);
    }
    public void print1ToMaxOfNDigits(char[] chars, int digit) {
        if (digit == chars.length) {
            System.out.println(chars.toString());
        } else {
            for (int i = 0; i < 10; i++) {
                chars[digit] = (char) (i + '0');
                print1ToMaxOfNDigits(chars,digit+1);
            }
        }
    }

    public int GetUglyNumber_Solution(int N) {
        if (N <= 6) return N;
        int i2 = 0,i3 = 0, i5=0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if (dp[i] == next2) i2++;
            if (dp[i] == next3) i3++;
            if (dp[i] == next5) i5++;
        }
        return dp[N-1];
    }

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) return i;
        }
        return -1;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin,prices[i]);
            max = Math.max(max,prices[i] - soFarMin);
        }
        return max;
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }
    private int movingCountCore(int threshold, int rows, int cols, int row, int col,boolean[] visited) {
        int count = 0;
        if (check(threshold,rows,cols,row,col,visited)) {
            visited[row*cols+col] = true;
            count = 1+ movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }
    private boolean check(int threshold, int rows, int cols, int row, int col,boolean[] visited) {
        return col >= 0 && col < cols
                && row >= 0 && row < rows
                && !visited[row * cols + col]
                && (getDigitSum(col) + getDigitSum(row) <= threshold);
    }

    private int getDigitSum(int digit) {
        int result = 0;
        while (digit > 0){
            result += digit %10;
            digit /= 10;
        }
        return result;
    }

    public int bulbSwitch(int n) {
        // 计算一个数之下有多少小于或等于它的平方数，使用一个开平方用的函数就可以了
        return (int) (n >= 0 ? Math.sqrt(n) : 0);
    }

    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2) -> o2 - o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;
    public void Insert(Integer val) {
        if (N %2 == 0) {
            left.offer(val);
            right.offer(left.poll());
        }else {
            right.offer(val);
            left.offer(right.poll());
        }
        N++;
    }
    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        }else {
            return (double)right.peek();
        }
    }

    int[] cnts = new int[256];
    Queue<Character> queue = new LinkedList<>();
    public void Insert(char ch) {
        cnts[ch]++;
        queue.offer(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }




}
