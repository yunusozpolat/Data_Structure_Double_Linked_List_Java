/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HW2;

/**
 *
 * @author PC
 */
public class HW2 {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        try {
            myList.Insert(1, 0);
            myList.Insert(2, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(9, 5);
            myList.Insert(9, 6);
            myList.Insert(1, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(3, 0);
            myList.Insert(2, 0);

            myList.Insert(5, 54);
            //myList.Insert(5, 54);


            //myList.ReverseOutput();
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
         myList.Output();
         myList.LinkReverse();
         myList.Output();
         myList.SacuraL();
         myList.Output();
         myList.OpacuraL();
         myList.Output();
         myList.ReverseOutput();
         //myList.Output();
         System.out.println(myList);
   }
}
