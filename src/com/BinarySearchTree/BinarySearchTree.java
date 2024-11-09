package com.BinarySearchTree;

 
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data=data;
	}
}
 
  class BST {
       Node root;
       public void insert(int data) {
    	   root=insertRec(root, data);
       }
       
       ///Insert
       public Node insertRec(Node root,int data) {
    	   if(root==null) {
    		   root=new Node(data);
    	   }
    	   else if(data<root.data) {
    		   root.left=insertRec(root.left, data);
    	   }
    	   else if(data>root.data) {
    		   root.right=insertRec(root.right, data);
    	   }
    	   return root; 
       }
       
       
       public void inOrder() {
    	   inOrderRec(root);
       }
       
       public void inOrderRec(Node root) {
    	   if(root!=null) {
    		   inOrderRec(root.left);
    		   System.out.print(root.data+" ");
    		   inOrderRec(root.right);
    	   }
       }
       
       // delete
       
       public void delete(int data) {
           root = deleteRec(root, data);
       }

       private Node deleteRec(Node root, int data) {
           if (root == null) {
               return root;  
           }

            if (data < root.data) {
               root.left = deleteRec(root.left, data);
           } else if (data > root.data) {
               root.right = deleteRec(root.right, data);
           } else {
 
                if (root.left == null) {
                   return root.right;
               } else if (root.right == null) {
                   return root.left;
               }

                root.data = minValue(root.right);

                root.right = deleteRec(root.right, root.data);
           }

           return root;
       }  private int minValue(Node root) {
           int minValue = root.data;
           while (root.left != null) {
               minValue = root.left.data;
               root = root.left;
           }
           return minValue;
       }
  }

public class BinarySearchTree{
	public static void main(String[] args) {
		BST tree=new BST();
		tree.insert(8);
		tree.insert(7);
		tree.insert(12);
		tree.insert(15);
		tree.insert(2);
		tree.insert(5);
        System.out.println("In-order traversal before deletion:");

		    tree.inOrder();
		    tree.delete(7);  
	        tree.delete(15); 
	        tree.delete(8); 
            System.out.println();
	        System.out.println("In-order traversal after deletion:");
	        tree.inOrder();
		
	}
}
