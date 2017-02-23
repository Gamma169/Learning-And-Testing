import java.util.*;

public class BST{
	
	public static LinkedList<Node> printQueue;


	public Node head;

	public BST() {
		head = null;
	}

	public BST(Node h) {
		head = h;
	}



	public void Insert(int data) {
		if (head == null) {
			head = new Node(data, true, true);
		}
		else {
			boolean rightmost = true;
			Node place = head;
			while (place != null) {
				if (data > place.data) {
					if (place.right != null)
						place = place.right;
					else {
						place.right = new Node(data, true, rightmost);
						return;
					}
				}
				else {
					rightmost = false;
					if (place.left != null) 
						place = place.left;
					else {
						place.left = new Node(data, false, false);
						return;
					}
				}
			}
		}
	}


	public static void PrintTree(BST bst) {
		EnqueueTree(bst);

		while (!printQueue.isEmpty()) {
			Node n = (Node)printQueue.removeLast();
			
			if (n.data != -1)
				System.out.print(n.data + " ");
			else 
				System.out.print(" ");
			if (n.isRightNode) {
				if (n.rightmost)
					System.out.print("\n");
				else
					System.out.print("| ");
			}
		}
	}
	public static void EnqueueTree(BST bst) {
		//Stack<Node> tempStack = new Stack<Node>();
		LinkedList<Node> tempList = new LinkedList<Node>();

		printQueue = new LinkedList<Node>();

		Node head = bst.head;
		if (bst.head == null)
			return;
		else
			tempList.addFirst(head);
		while (!tempList.isEmpty()) {
			Node n = (Node)tempList.removeLast();
			printQueue.addFirst(n);
			if (n.data != -1) {
				if (n.left != null)
					tempList.addFirst(n.left);
				if (n.right != null)
					tempList.addFirst(n.right);
				else if (!n.rightmost)
					tempList.addFirst(new Node(-1, true, false));
			}

		}

	} 

	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void main(String[] args) {

		int[] array = new int[]{13, 4, 8, 1, 87, 34, 0, 2540, 0, 12, 53, 7, 305};

		BST bst = new BST();
		//bst.Insert(5);
		//bst.Insert(6);
		//bst.Insert(4);
		//bst.Insert(1);

		for (int i=0; i<array.length; i++){
			bst.Insert(array[i]);
		}

		PrintTree(bst);
	}




}

class Node{

	public Node left;
	public Node right;
	public int data;

	public boolean isRightNode;
	public boolean rightmost;

	public Node(int input, boolean rightnode, boolean mostright){
		data = input;
		left = null;
		right = null;

		isRightNode = rightnode;
		rightmost = mostright;
	}

}

