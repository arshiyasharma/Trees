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

    void Postorder ()
    {
        System.out.print("\nPost Order traversal[LRC]-\t");
        curr=root;
        while(curr!=null)
        {
            while(curr!=null)
            {
                push(curr);
                if(curr.right!=null)
                {
                    curr.right.info*=-1;
                    push(curr.right);
                }
                curr=curr.left;
            }
            while(true)
            {
                curr=pop();
                if(curr==null)
                    break;
                else if(curr.info>0)
                    System.out.print(curr.info+"\t");
                else
                {
                    curr.info*=-1;
                    break;
                }
            }
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

    treeNode pop()
    {
        treeNode TN;
        if(start!=null)
        {
            TN=start.info;
            start=start.next;
        }
        else    
            return null;
        return TN;
    }

    public static void main(String[] args)
    {
        Tree obj=new Tree();
        obj.create();
        obj.inOrder();
        obj.Postorder();
        obj.preOrder();
    }
}
