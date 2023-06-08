package DataStructures_Udemy.List;

public class LinkedList {
    private Node head;  // Pointer to the first Node in the data structure
    private Node tail;  // Pointer to the last Node in the data structure
    private int length; // Length of Linked DataStructures_Udemy.List

    /**
     * Constructor to create a new EMPTY Linked DataStructures_Udemy.List
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructor to create a new Lined DataStructures_Udemy.List with initial Node as Node(data)
     * @param data  : The data inside the first Node in Linked DataStructures_Udemy.List
     */
    public LinkedList(int data) {
        Node node = new Node(data);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public Node getHead() {
        if (head == null) {
            return null;
        } else {
            return this.head;
        }
    }

    public Node getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Append method here, create a new Node by provided data as parameter, and
     * append newly created Node to the end of the LinkedList.
     * @param data : Data of the new Node
     */
    public void append(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    /**
     * Append method here, add a new Node by provided as parameter, and
     * append new Node to the end of the LinkedList.
     * @param newNode : New Node to be appended to the end of the Linked DataStructures_Udemy.List.
     */
    public void append(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    /**
     * Insert method here, create a new Node by provided data as parameter, and
     * insert newly created Node to the beginning of the LinkedList.
     * @param data : Data of the new Node
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            Node temp = head;
            head = newNode;
            head.setNext(temp);
        } else {
            head = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Insert method here, add a new Node by provided as parameter, and
     * insert new Node to the beginning of the LinkedList.
     * @param newNode : New Node to be inserted to the beginning of the Linked DataStructures_Udemy.List.
     */
    public void insertFirst(Node newNode) {
        if (!isEmpty()) {
            Node temp = head;
            head = newNode;
            head.setNext(temp);
        } else {
            head = newNode;
        }
        length++;
    }

    /**
     * Another insert method, which is used the length of the Linked DataStructures_Udemy.List not the isEmpty() method.
     * @param data : The data to be added to the Linked DataStructures_Udemy.List at index 0.
     */
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(tail);
            head = newNode;
        }
        length++;
    }

    /**
     * This method insert a new Node, with specified value, at the particular index.
     * @param index : The index where the new Node will be added.
     * @param data : The value of the new Node which will be added to a Linked DataStructures_Udemy.List at specified index.
     */
    public void insertAtIndex(int index, int data) {
        Node temp = getNodeAtIndex(index);
        if (temp != null) {
            if (index != 0) {
                Node previous = getPrevious(temp);
                Node newNode = new Node(data);
                previous.setNext(newNode);
                newNode.setNext(temp);
                length++;
            } else {
                insertFirst(data);
            }
        } else {
            if (index == length) {
                append(data);
            }
        }
    }

    /**
     * Another method to insert a new Node, with specified value, at the particular index.
     * @param index : The index where the new Node will be added.
     * @param data : The value of the new Node which will be added to a Linked DataStructures_Udemy.List at specified index.
     * @return : True if the new data inserted, False if the data cannot be inserted at the specified index.
     */
    public boolean insertAtIndex_2(int index, int data) {
        if (index < 0 || index > getSize()) {
            return false;
        } else if (index == 0) {
            insertFirst(data);
            return true;
        } else if (index == getSize()) {
            append(data);
            return true;
        } else {
            Node newNode = new Node(data);
            Node temp = getNodeAtIndex(index - 1);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            return true;
        }

    }

    /**
     * It returns the Node's previous Node in a Linked DataStructures_Udemy.List.
     * @param node : The Node which we want to get its previous Node.
     * @return : Previous Node of the specified Node.
     */
    public Node getPrevious(Node node) {
        Node temp = head;
        Node previous = null;
        while (temp != node) {
            previous = temp;
            temp = temp.getNext();
        }
        return previous;
    }

    /**
     * This function removes the last item inside a Linked DataStructures_Udemy.List.
     */
    public void removeLast() {
        if (!isEmpty()) {
            tail = getPrevious(tail);
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
            length--;
        }
    }

    /**
     * This function removes the last item inside a Linked DataStructures_Udemy.List and return it.
     * This is the same as the pop() method.
     * @return : The removed last item in the Linked DataStructures_Udemy.List
     */
    public Node removeReturnLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node previous = head;
        while (temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
        }
        tail = previous;
        tail.setNext(null);
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * It removes the last item in a Linked DataStructures_Udemy.List and return it.
     * @return : The removed last item.
     */
    public Node pop() {
        if (!isEmpty()) {
            Node temp = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = getPrevious(tail);
                tail.setNext(null);
            }
            length--;
            return temp;
        }
        return null;
    }

    /**
     * This function remove the first item inside a Linked DataStructures_Udemy.List.
     */
    public void removeFirst() {
        if (!isEmpty()) {
            Node temp = head.getNext();
            if (head != tail) {
                head = temp;
            } else {
                head = null;
                tail = null;
            }
            length--;
        }
    }

    /**
     * The function which is remove the first item from a Linked DataStructures_Udemy.List and return it.
     * @return temp: The first item which is removed from the Linked DataStructures_Udemy.List
     */
    public Node removeReturnFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    /**
     * This method returns the index of a Node which its value is specified.
     * @param data : The value which we want to get its index.
     * @return index : The index of the first occurrence of the data inside the Linked DataStructures_Udemy.List.
     */
    public int getIndexOfNode(int data) {
        if (!isEmpty()) {
            int index = 0;
            Node temp = head;
            if (head != tail) {
                while (temp.getData() != data) {
                    temp = temp.getNext();
                    index++;
                }
                return index;
            }
            return index;
        }
        return -1;
    }

    /**
     * This method return the length or size of the Linked DataStructures_Udemy.List.
     * @return Size/length of the Linked DataStructures_Udemy.List
     */
    public int getSize() {
        if (isEmpty()) {
            return 0;
        } else {
            if (head == tail) {
                return 1;
            } else {
                int count = 0;
                Node temp = head;
                while (temp != null) {
                    temp = temp.getNext();
                    count++;
                }
                return count;
            }
        }
    }

    /**
     * This method returns the Node at the specified index.
     * @param index : The index of a Node which we want to return.
     * @return Node : The node at the specified index.
     */
    public Node getNodeAtIndex(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp;
        }
    }

    /**
     * This method remove the element of the Linked DataStructures_Udemy.List at the specified index.
     * @param index : The index of the element that we want to remove.
     */
    public void removeFromIndex(int index) {
        if (index >= 0 && index < length) {
            if (index == 0) {
                Node temp = head.getNext();
                Node tempNext = temp.getNext();
                head = temp;
                temp.setNext(tempNext);
            } else {
                Node temp = getNodeAtIndex(index);
                Node previous = getPrevious(temp);
                previous.setNext(temp.getNext());
            }
            length--;
        }
    }

    /**
     * This is another method to remove the element of the Linked DataStructures_Udemy.List at the specified index.
     * @param index : The index of the element that we want to remove.
     * @return : The Node at specified index which is removed from the Linked DataStructures_Udemy.List.
     */
    public Node removeFromIndex_2(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        }
        if (index == 0) {
            return removeReturnFirst();
        }
        if (index == getSize() - 1) {
            return removeReturnLast();
        }

        Node prev = getNodeAtIndex(index - 1);
        Node temp = prev.getNext();

        prev.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp;
    }

    /**
     * Set data of a Node at particular index as specified value
     * @param index : index, where the Node's value will be changed
     * @param data : The value which will be inserted as a value of Node.
     * @return : it returns boolean value if it can add return true, else false.
     */
    public boolean setDataOfIndex(int index, int data) {
        Node temp = getNodeAtIndex(index);
        if (temp != null) {
            temp.setData(data);
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method reverse the Linked DataStructures_Udemy.List in place.
     */
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }

    /**
     * This method return the smallest value inside the Linked DataStructures_Udemy.List.
     * @return : The smallest data in the Linked DataStructures_Udemy.List.
     */
    public int smallest() {
        int min;
        Node temp = head;
        min = temp.getData();
        while (temp != null) {
            if (temp.getData() < min) {
                min = temp.getData();
            }
            temp = temp.getNext();
        }
        return min;
    }

    /**
     * This method return the largest value inside the Linked DataStructures_Udemy.List.
     * @return : The largest data in the Linked DataStructures_Udemy.List.
     */
    public int largest() {
        int max;
        Node temp;
        temp = head;
        max = temp.getData();
        while (temp != null) {
            if (temp.getData() > max) {
                max = temp.getData();
            }
            temp = temp.getNext();
        }
        return max;
    }


    /**
     * This method delete the second element in the Linked DataStructures_Udemy.List
     */
    public void deleteSecond() {
        if (head.getNext() != null) {
            Node temp = head.getNext();
            Node tempN = temp.getNext();
            temp.setNext(null);
            head.setNext(tempN);
        }
    }

    /**
     * This method delete the second element in the Linked DataStructures_Udemy.List and return it.
     * @return : The second element in the Linked DataStructures_Udemy.List.
     */
    public Node deleteReturnSecond() {
        if (head.getNext() != null) {
            Node temp = head.getNext();
            Node tempN = temp.getNext();
            temp.setNext(null);
            head.setNext(tempN);
            return temp;
        }
        return null;
    }


    /**
     * Write a function that will delete the odd indexed elements from a singly
     * linked list. The function will also return the deleted nodes as a new linked list.
     * @return : The deleted nodes as a new linked list
     */
    public LinkedList oddIndexedElements() {
        LinkedList deletedList = new LinkedList();
        if (head == null) {
            return deletedList;
        }
        Node current = head;
        int index = 1;
        while (current != null && current.getNext() != null) {
            if (index % 2 != 0) {
                Node deletedNode = current.getNext();
                current.setNext(deletedNode.getNext());
                deletedNode.setNext(null);
                deletedList.append(deletedNode.getData());
            } else {
                current = current.getNext();
            }
            index++;
        }
        return deletedList;
    }


    /**
     * This function will delete even indexed elements from a singly linked list.
     */
    public void deleteEvenIndexed() {
        if (head == null || head.getNext() == null) {
            // Empty list or list with only one node, nothing to delete
            return;
        }

        Node current = head;
        Node prev = null;
        int index = 0;

        while (current != null) {
            if (index % 2 == 0) {
                // Even index, delete the node
                if (prev == null) {
                    // If it's the first node, update the head
                    head = current.getNext();
                } else {
                    // Update the previous node's next reference
                    prev.setNext(current.getNext());
                }
                current.setNext(null); // Remove the reference from the deleted node
                current = prev != null ? prev.getNext() : head; // Move to the next node
            } else {
                // Odd index, move to the next node
                prev = current;
                current = current.getNext();
            }
            index++;
        }
    }


    /**
     * The function that will add a new node before the last node of a
     * singly linked list.
     * @param newNode : The node that will be added to the Linked DataStructures_Udemy.List.
     */
    public void insertBeforeLast(Node newNode) {
        if (head == null) {
            // Empty list, newNode becomes the head
            head = newNode;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
        }

        // Insert newNode before the last node
        newNode.setNext(current);
        if (prev == null) {
            // If there's only one node, newNode becomes the new head
            head = newNode;
        } else {
            prev.setNext(newNode);
        }
    }


    /**
     * Given a sorted linked list, write a function to add a new integer without
     * destroying the sortedness property
     * @param x: The new data value to be added to a Linked DataStructures_Udemy.List.
     */
    public void AddToSortedList(int x) {
        Node newNode = new Node(x);

        if (head == null || x < head.getData()) {
            // Empty list or x is smaller than the current head, newNode becomes the new head
            newNode.setNext(head);
            head = newNode;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && x >= current.getData()) {
            prev = current;
            current = current.getNext();
        }

        // Insert newNode at the appropriate position
        assert prev != null;
        prev.setNext(newNode);
        newNode.setNext(current);
    }


    /**
     * Given node X, write a function to move that node n position forward.
     * Assume that there are at least n nodes after node X.
     * @param X
     * @param n
     */
    public void move(Node X, int n) {
        if (X == null || n <= 0)
            return;

        // Find the node before X
        Node prevX = null;
        Node current = head;
        while (current != null && current != X) {
            prevX = current;
            current = current.getNext();
        }

        if (current == null)
            return; // Node X not found

        // Find the node at the new position
        Node newX = X;
        for (int i = 0; i < n; i++) {
            newX = newX.getNext();
        }

        // Update the pointers to move X to the new position
        if (prevX == null) {
            // X is the head node
            head = X.getNext();
        } else {
            prevX.setNext(X.getNext());
        }
        X.setNext(newX.getNext());
        newX.setNext(X);
    }


    /**
     * Given an integer N, write a function which returns the prime factors
     * of N as singly linked list.
     * @param N: Given integer
     * @return: A linked list which contains the prime factors of N
     */
    public LinkedList primeFactors(int N) {
        LinkedList factors = new LinkedList();

        // Check if 2 is a factor of N
        while (N % 2 == 0) {
            factors.append(2);
            N /= 2;
        }

        // Check for other prime factors starting from 3
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                factors.append(i);
                N /= i;
            }
        }

        // If N is a prime number greater than 2
        if (N > 2) {
            factors.append(N);
        }

        return factors;
    }


    /**
     * Write a function that determines if a singly link list is palindrome, that
     * is, it is equal its reverse.
     * @return: true if it is palindrome, false otherwise.
     */
    public boolean isPalindrome() {
        // Base case: an empty list or a single node is considered a palindrome
        if (head == null || head.getNext() == null) {
            return true;
        }

        // Find the middle node using the two-pointer technique
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // Reverse the second half of the linked list
        Node secondHalf = reverse(slow);

        // Compare the first half with the reversed second half
        Node curr1 = head;
        Node curr2 = secondHalf;
        while (curr1 != null && curr2 != null) {
            if (curr1.getData() != curr2.getData()) {
                return false;
            }
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }

        // Restore the original linked list (re-reverse the second half)
        reverse(secondHalf);

        return true;
    }

    /**
     * Reverse a linked list from specified Node.
     * @param node: The node which we reverse the items after that
     * @return
     */
    private Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            Node next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /**
     * Given two sorted linked lists L1 and L2, write a function to compute
     * L1 (intersection) L2.
     * @param l1 : Sorted Linked DataStructures_Udemy.List
     * @param l2 : Sorted Linked DataStructures_Udemy.List
     * @return: Intersection of L1 and L2
     */
    public LinkedList intersection(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        Node curr1 = l1.head;
        Node curr2 = l2.head;

        while (curr1 != null && curr2 != null) {
            if (curr1.getData() == curr2.getData()) {
                result.append(curr1.getData());
                curr1 = curr1.getNext();
                curr2 = curr2.getNext();
            } else if (curr1.getData() < curr2.getData()) {
                curr1 = curr1.getNext();
            } else {
                curr2 = curr2.getNext();
            }
        }

        return result;
    }


    /**
     * Write a function that deletes all nodes having value X from a singly
     * linked list.
     * @param X: The value of the node to be deleted.
     */
    public void deleteAll(int X) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (curr.getData() == X) {
                if (prev == null) {
                    // Deleting the head node
                    head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
            } else {
                prev = curr;
            }
            curr = curr.getNext();
        }
    }


    /**
     * Write a function that checks if the original list contains the elements
     * of the second list in the same order.
     * @param sub: The second Linked DataStructures_Udemy.List
     * @return: true if it contains the elements of the second list in the same order, false otherwise.
     */
    public boolean subList(LinkedList sub) {
        Node curr1 = head;
        Node curr2 = sub.head;

        while (curr1 != null && curr2 != null) {
            if (curr1.getData() == curr2.getData()) {
                curr2 = curr2.getNext();
            }
            curr1 = curr1.getNext();
        }

        return curr2 == null; // Return true if we reached the end of sub list
    }


    /**
     * Write a function that returns the Fibonacci numbers between A and B
     * as a linked list. Fibonacci's numbers are:
     *      F_0 = 0
     *      F_1 = 1
     *      F_2 = 1
     *      . . .
     *      F_n = F_n−1 + F_n−2
     * @param A : Starting number
     * @param B : Ending number
     * @return : The linked list which contains Fibonacci numbers between A and B.
     */
    public LinkedList fibonacci(int A, int B) {
        LinkedList result = new LinkedList();
        int prev = 0;
        int curr = 1;

        while (curr <= B) {
            if (curr >= A) {
                result.append(curr);
            }
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return result;
    }


    /**
     * Suppose you are given a linked list of N integers that are sorted. Write
     * an algorithm to remove duplicate elements from that sorted linked list.
     * @param A : The sorted Linked DataStructures_Udemy.List.
     */
    public void removeDuplicates(LinkedList A) {
        Node curr = A.head;

        while (curr != null && curr.getNext() != null) {
            if (curr.getData() == curr.getNext().getData()) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }
        }
    }


    /**
     * Suppose you are given a linked list of N integers that are sorted. Write
     * an algorithm to remove single elements from that sorted linked list.
     * @param A : Sorted Linked DataStructures_Udemy.List
     */
    public static void removeSingles(LinkedList A) {
        Node curr = A.head;
        Node prev = null;

        while (curr != null && curr.getNext() != null) {
            if (curr.getData() != curr.getNext().getData()) {
                if (prev == null) {
                    A.head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
            }
            curr = curr.getNext();
        }
    }


    // *****************************************************************************************************

    /**
     * A function that sort the Linked DataStructures_Udemy.List in ascending order.
     * In-place sorting.
     * It uses Merge Sort
     */
    public void ascendingSort() {
        if (head == null || head.getNext() == null) {
            // The list is already sorted or empty
            return;
        }

        head = mergeSort(head);
    }

    /**
     * Merge Sort
     * @param head
     * @return
     */
    private Node mergeSort(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        // Split the list into two halves
        Node middle = getMiddleNode(head);
        Node nextOfMiddle = middle.getNext();
        middle.setNext(null);

        // Recursively sort the two halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        Node sortedList = merge(left, right);

        return sortedList;
    }

    /**
     * Helper method for Merge Sort
     * @param left
     * @param right
     * @return
     */
    private Node merge(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.getData() <= right.getData()) {
            result = left;
            result.setNext(merge(left.getNext(), right));
        } else {
            result = right;
            result.setNext(merge(left, right.getNext()));
        }

        return result;
    }

    /**
     * Helper method for Merge Sort
     * @param head
     * @return
     */
    private Node getMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    // *****************************************************************************************************
    // *****************************************************************************************************

    /**
     * A function that sort the Linked DataStructures_Udemy.List in descending order.
     * In-place sorting.
     * It uses Merge Sort
     */
    public void descendingSort() {
        // Check if the list is empty or contains only one node
        if (head == null || head.getNext() == null) {
            return;
        }

        // Perform merge sort to sort the list
        head = mergeSortDescending(head);
    }

    /**
     * Helper method for Descending Sort.
     * @param node
     * @return
     */
    private Node mergeSortDescending(Node node) {
        // Base case: If the list is empty or contains only one node, return the head
        if (node == null || node.getNext() == null) {
            return node;
        }

        // Split the list into two halves
        Node middle = getMiddleNode(node);
        Node nextOfMiddle = middle.getNext();
        middle.setNext(null);

        // Recursively sort the two halves
        Node left = mergeSortDescending(node);
        Node right = mergeSortDescending(nextOfMiddle);

        // Merge the sorted halves in descending order
        return mergeDescending(left, right);
    }

    private Node mergeDescending(Node left, Node right) {
        // Create a dummy node as the head of the merged list
        Node dummy = new Node();
        Node tail = dummy;

        // Merge the two lists in descending order
        while (left != null && right != null) {
            if (left.getData() >= right.getData()) {
                tail.setNext(left);
                left = left.getNext();
            } else {
                tail.setNext(right);
                right = right.getNext();
            }
            tail = tail.getNext();
        }

        // Append the remaining nodes from either list
        if (left != null) {
            tail.setNext(left);
        } else {
            tail.setNext(right);
        }

        // Return the head of the merged list
        return dummy.getNext();
    }

// *****************************************************************************************************



    /**
     * Write the method which prints the contents of the odd indexed nodes
     * (1, 3, . . .) in the linked list.
     */
    public void printOddNodes() {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (index % 2 != 0) {
                System.out.print(index + ":" + current.getData() + " - ");
            }
            current = current.getNext();
            index++;
        }
        System.out.println();
    }



    /**
     * This method doubles each node in the Linked DataStructures_Udemy.List.
     */
    public void doubleList() {
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.getData());
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            current = newNode.getNext();
            length++;
        }
    }



    public String toString() {
        Node temp = head;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.getData());
            str.append(" -> ");
            temp = temp.getNext();
        }
        str.append("NULL");
        return str.toString();
    }
}
