/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HW2;

/**
 *
 * @author PC
 */
public class LinkedList implements HW2Interface{
    DoubleLinkNode head = null;
    DoubleLinkNode tail = null;
    int size;
    @Override
    public void Insert(int newElement, int pos) throws Exception {
        DoubleLinkNode newNode = new DoubleLinkNode();

        if (head==null) {
            head = newNode;
            tail = newNode;
            newNode.Element = newElement;
        }
        else if(head!=null && pos==0) {
            newNode.right=head;
            head.left=newNode;
            head=newNode;
            newNode.Element = newElement;
        }
        else {
            int n=0;
            DoubleLinkNode temp = head;
            while (temp != null) {
                temp = temp.right;
                n++;
            }

            temp = head;
            if (pos > n | pos == n) {
                throw LinkedListException();
            }
            else {
                int i=0;
                while(i!=pos) {
                        temp=temp.right;
                        i++;
                }
                newNode.left=temp.left;
                temp.left.right=newNode;
                newNode.right=temp;
                temp.left=newNode;
                newNode.Element = newElement;
            }
        }	
    }


    @Override
    public int Delete(int pos) throws Exception {
        DoubleLinkNode newNode = new DoubleLinkNode();
        if (head != null) { //listem boş değilse
            if(head.right == null && pos == 0) { // listede tek bir node varsa baştan silme yaptım
                    head = null;
                    tail = null;
            }
            else if(head.right != null && pos ==0) { // listede tek bir node yoksa ama pos = 0 sa baştan silme yaptım
                    head = head.right;
                    head.left = null;
            }
            else {
                int n=0;
                DoubleLinkNode tmpNode = new DoubleLinkNode();
                tmpNode = head;
                while (tmpNode != null) {
                    n++;
                    tmpNode = tmpNode.right;
                }
                if(pos == (n-1)) {	// sondan silmek istersem
                    tail = tail.left;
                    tail.right = null;
                }
                else if (pos < 0 | pos > (n-1)) {
                    throw LinkedListException();
                }
                else {
                    tmpNode = head;
                    int k = 0;
                    while(k < pos) {
                            k++;
                            tmpNode = tmpNode.right;
                    }
                    tmpNode.right.left = tmpNode.left;	//aradan sildim
                    tmpNode.left.right = tmpNode.right;
                }
            }
        }
        else {
            throw LinkedListException();
        }
        return 0;
    }

    @Override
    public void LinkReverse() {
        DoubleLinkNode newNode = new DoubleLinkNode();
        DoubleLinkNode newNode1 = new DoubleLinkNode();
        newNode = tail;
        newNode1 = head;
        int n=0;
        int k=0;
        int i=0;
        DoubleLinkNode temp = head;
        while (temp != null) {
            temp = temp.right;
            n++;
        // listemin kaç elemanlı olduğunu bulup, n'ye eşitledim
        }
        size = n;
        while(i<n/2) {
            //newNode1 = newNode;
            k = newNode.Element;				// boştaki k değerime node'un (tail) elemanını attım
            newNode.Element = newNode1.Element; // node'a node1'in (head) elemanını attım 
            newNode1.Element = k;				// node1'e de k'da tuttuğum değeri attım.
            newNode = newNode.left;
            newNode1 = newNode1.right;
            i++;
        }
    }

    @Override
    public void SacuraL() {
        DoubleLinkNode newNode = new DoubleLinkNode();
        DoubleLinkNode newNode1 = new DoubleLinkNode();

        newNode = head;
        int n=0;

        while (newNode != null) {
            n++;
            newNode = newNode.right;
        }
        newNode = head;
        newNode1 = newNode.right;
        int counter=1;
        int z=0;
        while (z<n) {
            if(newNode1 != null) {
                if(newNode.Element!=newNode1.Element) {
                    DoubleLinkNode tmpNode = new DoubleLinkNode();
                    tmpNode.left = newNode;
                    newNode.right = tmpNode;
                    tmpNode.right = newNode1;
                    newNode1.left =tmpNode;
                    tmpNode.Element = counter;
                    newNode = tmpNode.right;
                    newNode1 = newNode1.right;
                    counter=1;
                }
                else {
                    DoubleLinkNode tmpNode = new DoubleLinkNode();
                    counter++;
                    newNode.left.right = newNode1;	// tekrar eden sayı bulduğum an ilk tekrar edeni siliyorum
                    newNode1.left= newNode.left;
                    newNode = newNode.right;
                    newNode1 = newNode1.right;
                }
            }
            else {
                DoubleLinkNode xNode = new DoubleLinkNode();
                newNode.right=xNode;
                xNode.left=newNode;
                xNode.Element=counter;
            }
            z++;
        }
    }

    @Override
    public void OpacuraL() {
        DoubleLinkNode newNode = new DoubleLinkNode();
        DoubleLinkNode newNode1 = new DoubleLinkNode();
        newNode = head;
        int n=0;
        int c=0;
        while (newNode != null) {
            n++;
            newNode = newNode.right;
        }
        newNode = head;
        while (newNode != null) {
            if(newNode.right.Element==1) {
                    c++;
            }
            newNode = newNode.right.right;
        }
        newNode = head;
        newNode1 = newNode.right;
        for(int i=1; i<=c; i++) {
            if(newNode1.right != null) {
                if (newNode1.Element==1) {
                    newNode1=newNode1.right;
                    newNode.right=newNode1;
                    newNode1.left=newNode;
                    newNode1=newNode1.right;
                    newNode=newNode.right;
                }
                else {
                    DoubleLinkNode tmpNode = new DoubleLinkNode();
                    tmpNode.right=newNode1;
                    newNode.right=tmpNode;
                    tmpNode.left=newNode;
                    newNode1.left=tmpNode;
                    tmpNode.Element=newNode.Element;
                    newNode=newNode.right;
                    newNode1.Element=newNode1.Element-1;
                    i=i-1;
                    if(newNode1.Element==1) {
                        newNode1=newNode1.right;
                        newNode.right=newNode1;
                        newNode1.left=newNode;
                        newNode1=newNode1.right;
                        newNode=newNode.right;
                    }
                }
            }
            else {
                newNode1 = newNode1.left;
                newNode1.right = null;
            }
        }
    }

    @Override
    public void Output() {
        DoubleLinkNode newNode = new DoubleLinkNode();
        newNode = head;
        System.out.print("The Elements in the list are : ");
        while(newNode != null) {
            System.out.print(newNode.Element + " ");
            
            newNode = newNode.right;
        }
        System.out.println();
    }

    @Override
    public void ReverseOutput() {
        DoubleLinkNode newNode = new DoubleLinkNode();
        newNode = tail;
        System.out.print("The Reverse Elements in the list are :  ");
        while(newNode != null) {
            System.out.print(newNode.Element + " ");
            newNode = newNode.left;
        }
        System.out.println();
    }
    public String toString() {
        DoubleLinkNode tmpNode = head;
        String result = "";
        while(tmpNode != null) {
            result += tmpNode.Element + " ";
            tmpNode = tmpNode.right;
        }
        return result;
    }
    @Override
    public Exception LinkedListException() {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
