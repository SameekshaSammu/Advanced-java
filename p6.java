/*
 1c. Linked List Programs
 1.Write a Java program to iterate through all elements in a linked list starting at the specified position ( 2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))
 */
package lab1;
import java.util.LinkedList;
import java.util.ListIterator;

public class p6 {

    public static void main(String[] args) {

        // ✅ Create LinkedList
        LinkedList<String> listobj = new LinkedList<>();

        // ✅ Add elements
        listobj.add("Apple");
        listobj.add("Banana");
        listobj.add("Cherry");
        listobj.add("Mango");
        listobj.add("Orange");

        // ✅ Create iterator starting from 2nd position (index 1)
        ListIterator<String> iteratorobj = listobj.listIterator(1);

        System.out.println("Elements starting from 2nd position:");

        // ✅ Iterate using iterator
        while (iteratorobj.hasNext()) {
            System.out.println(iteratorobj.next());
        }
    }
}