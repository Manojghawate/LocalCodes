package com;

public class BST {
	private Node root;
	
	public void printRightSubstree() {
		inorderRec(root.right);
	}
	public void insert( int data) {
		root = insertRec(root,data);
	}
	private Node  insertRec(Node root, int data) {
		if(root == null) {
			root = new Node(data, null, null);
			return root;
		}
		if(data < root.data)
			root.left = insertRec(root.left, data);
		else
			root.right = insertRec(root.right, data);
		return root;
	}
	public void delete( int data) {
		root = deleteRec(root,data);
	}
	private Node  deleteRec(Node root, int data) {
		if(root == null) {
			return root;
		}
		if(data < root.data)
			root.left = deleteRec(root.left, data);
		else if(data > root.data)
			root.right = deleteRec(root.right, data);
		else {
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}
		return root;
	}
	private int getMinvalue(Node root) {
		int minValue = root.data;
		while(root.left != null) {
			minValue = root.data;
			root = root.left;
		}
		return minValue;
	}
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }
	public boolean search(int data) {
		return searchRec(root,data);
	}
	private boolean searchRec(Node root, int data) {
		if(root == null) 
			return false;
		if(root.data == data) 
			return true;
		if(data < root.data)
			return searchRec(root.left, data);
		else
			return searchRec(root.right, data);
	}
	public void inOrder() {
		System.out.print("Inorder Traverser : ");
		inorderRec(root);
		System.out.println();
		
	}
	private void inorderRec(Node root) {
		if(root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}
	public void preOrder() {
		System.out.print("Preorder Traverser :");
		preOrderRec(root);
		System.out.println();
		
	}
	private void preOrderRec(Node root) {
		if(root != null) {
			System.out.print(root.data + " " );
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	public void postOrder() {
		System.out.print("Postorder Traverser : ");
		postOrderRec(root);
		System.out.println();
		
	}
	private void postOrderRec(Node root) {
		if(root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.print(root.data + " " );
		}
	}
	
	private static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	public static void main(String[] args) {
//		BST bst = new BST();
//		// Insert values
//		bst.insert(50);
//		bst.insert(30);
//		bst.insert(20);
//		bst.insert(40);
//		bst.insert(70);
//		bst.insert(60);
//		bst.insert(80);
//
//		// Print traversals
//		bst.inOrder();
//		bst.preOrder();
//		bst.postOrder();
//
//		// Search for a value
//		System.out.println("Search for value 40:");
//		System.out.println(bst.search(40) ? "Found" : "Not Found");
//
//		System.out.println("Search for value 100:");
//		System.out.println(bst.search(100) ? "Found" : "Not Found");
		
		 BST bst = new BST();

	        // Inserting nodes into the BST
	        bst.insert(50);
	        bst.insert(30);
	        bst.insert(20);
	        bst.insert(40);
	        bst.insert(70);
	        bst.insert(60);
	        bst.insert(80);

	        // Inorder traversal of the BST
	        System.out.println("Inorder traversal:");
	        bst.inOrder();

	        // Preorder traversal of the BST
	        System.out.println("Preorder traversal:");
	        bst.preOrder();

	        // Postorder traversal of the BST
	        System.out.println("Postorder traversal:");
	        bst.postOrder();

	        // Searching for a node in the BST
	        System.out.println("Search 40: " + bst.search(40)); // true
	        System.out.println("Search 90: " + bst.search(90)); // false

	        // Deleting a node from the BST
	        bst.delete(20);
	        System.out.println("Inorder traversal after deleting 20:");
	        bst.inOrder();

	        bst.delete(30);
	        System.out.println("Inorder traversal after deleting 30:");
	        bst.inOrder();

	        bst.delete(50);
	        System.out.println("Inorder traversal after deleting 50:");
	        bst.inOrder();

	}

}
