package trees;

//Arshiya Sharma SC-A F554
//Trees data structure - traversing Pre Order and In Order using stacking techniques and search function
import java.util.*;
class Tree
{
    treeNode curr, root, newNode,prev;
    stackNode start,ptr;
    Scanner inp=new Scanner(System.in);
    void create()
    {
        System.out.println("Enter 0 to exit. ");
        while(true)
        {
            newNode=new treeNode();
            newNode.input();
            if(newNode.info==0)
                break;

            if(root==null)
                root=newNode;
            else if(newNode.info>root.info && root.right==null)
                root.right=newNode;
            else if(newNode.info<root.info && root.left==null)
                root.left=newNode;
            else
            {
                curr=root;
                while(true)
                {
                    if(newNode.info>curr.info)
                    {
                        if(curr.right==null)
                        {
                            curr.right=newNode;
                            break;
                        }
                        curr=curr.right;
                    }
                    else if(newNode.info<curr.info)
                    {
                        if(curr.left==null)
                        {
                            curr.left=newNode;
                            break;
                        }
                        curr=curr.left;
                    }
                }
            }
        }
    }

    void preOrder()
    {
        System.out.print("\nPreOrder traversal[CLR]-\t");
        curr=root;
        int ctr=0;
        while(curr!=null)
        {
            while(curr!=null)
            {
                if(curr.right==null && curr.left==null)
                    ctr++;
                System.out.print(curr.info+"\t");
                if(curr.right!=null)
                    push(curr.right);
                curr=curr.left;
            }
            curr=pop();
        }
        System.out.println("\n\nThe number of leaves is: "+ctr);
    }

    void inOrder()
    {
        System.out.print("\nInOrder traversal[LCR]-\t");
        curr=root;                                                                                            
        while(curr!=null)
        {
            while(curr!=null)
            {
                push(curr);
                curr=curr.left;
            }
            curr=pop();
            System.out.print("\t"+curr.info);
            while(curr.right==null)
            {
                curr=pop();
                if(curr==null)
                    break;
                System.out.print("\t"+curr.info);
            }
            if(curr!=null)
                curr=curr.right;
        }
    }

    void push(treeNode TN)
    {
        stackNode ptr=new stackNode();
        ptr.info=TN;
        if(start==null)
            start=ptr;
        else
        {
            ptr.next=start;
            start=ptr;
        }
    }

    boolean flag = false;
    void searchNode(treeNode temp, int val)
    {
        if(root == null) //empty tree check 
            System.out.println("Tree is empty"); 
        else
        {
            if(temp.info == val){  
                flag = true;  
                return;  
            }  
            //Search in left subtree  
            if(flag == false && temp.left != null)
                searchNode(temp.left, val); 
            //Search in right subtree  
            if(flag == false && temp.right != null) 
                searchNode(temp.right, val);
        }  
    }
    void search()
    {
        System.out.print("Enter the number to search for:");
        int val = inp.nextInt();
        searchNode(root,val);
        if(flag)  
            System.out.println("Element is present in the binary tree.");  
        else  
            System.out.println("Element is not present in the binary tree."); 
    }
    
    treeNode pop()
    {
        treeNode TN=null;
        if(start!=null)
        {
            TN=start.info;
            start=start.next;
        }
        return TN;
    }
    
    public static void main(String[] args)
    {
        Tree obj=new Tree();
        obj.create();
        obj.inOrder();
        obj.preOrder();
        obj.search();
    }
}
/*
 * OUTPUT:
Enter 0 to exit. 
Enter number: 65
Enter number: 83
Enter number: 234
Enter number: 475
Enter number: 282
Enter number: 1
Enter number: 3498
Enter number: 23
Enter number: 45
Enter number: 0

InOrder traversal[LCR]-		1	23	45	65	83	234	282	475	3498
PreOrder traversal[CLR]-	65	1	23	45	83	234	475	282	3498	

The number of leaves is: 3
Enter the number to search for:65
Element is present in the binary tree.
 */