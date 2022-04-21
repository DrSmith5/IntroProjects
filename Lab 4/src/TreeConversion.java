import java.util.ArrayList;
import java.util.Collections;

public class TreeConversion 
{
	
	Node root;
	
	public void addNode(Node root, int key)	// first argument not needed since in this class, just for example.
	{
		Node newNode = new Node(key);
		if (root == null)
		{
			root = newNode; 
			return;
		}
		Node current = root;
		while (true)
		{
			if (key < current.key)
			{
				if (current.left != null)
				{
					current = current.left;
				}
				else
				{
					current.left = newNode; 
					return;
				}
			}
			else
			{
				if (current.right != null)
				{
					current = current.right;
				}
				else
				{
					current.right = newNode; 
					return;
				}
			}
		}
	}
	
	public boolean checkIfBinaryTree(ArrayList<Integer> keys)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>(keys);
		Collections.sort(temp);
		if (temp.equals(keys))
		{
			return false;
		}
		else
			return true;
	}
	
	void inOrderTraversal(Node node, ArrayList<Integer> keys)
	{
		if (node == null)
		{
			return;
		}
		
		inOrderTraversal(node.left, keys);
		keys.add(node.key);
		inOrderTraversal(node.right, keys);

	}
	
	public void convertToBST(Node node, ArrayList<Integer> keys, int[] i)
	{
		if (node == null)
		{
			return;
		}
		convertToBST(node.left, keys, i);
		node.key = keys.get(i[0]);
		i[0]++;
		convertToBST(node.right, keys, i);
	}
	
	void inOrderTraversalPrint(Node node)
	{
		if (node == null)
		{
			return;
		}
		
		inOrderTraversalPrint(node.left);
		System.out.println(node.key + " ");
		inOrderTraversalPrint(node.right);

	}
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> keys = new ArrayList<>();
		TreeConversion btree = new TreeConversion();
		
		btree.root = new Node(10);
		btree.root.left = new Node(2);
		btree.root.left.left = new Node(8);
		btree.root.left.right = new Node(4);
		btree.root.right = new Node(7);
		
		//btree.checkIfBinaryTree(btree.root);
		btree.inOrderTraversal(btree.root, keys);
		int[] index = new int[keys.size()];
		System.out.println("Is this a binary tree? (T/F)");
		System.out.println(btree.checkIfBinaryTree(keys));
		
		System.out.println("\nIn order print - Before conversion to BST");
		btree.inOrderTraversalPrint(btree.root);
		Collections.sort(keys);
		btree.convertToBST(btree.root, keys, index);
		System.out.println("\nIn order print - After conversion to BST");
		btree.inOrderTraversalPrint(btree.root);

	}

}
