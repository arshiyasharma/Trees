package trees;

//Arshiya Sharma SC-A F554
//node class for the tree
import java.util.*;
class treeNode
{
    treeNode right, left;
    int info;
    treeNode()
    {
        right=left=null;
    }
    void input()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter number: ");
        info=inp.nextInt();
    }
}