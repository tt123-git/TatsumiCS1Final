/*This class is for interface. I use this array a lot in implemented and implemented sub class.
By call abstract method I can use this arry in implemented class and that sub classes.
 * 
 */
package ToDoFinal;


public interface CategoryArray {

  final String [] categoryList = {"job", "classes", "study", "hang out", "hobby", 
                                "important", "other"};//Use final, interface for this array.

  void categoryArr();//Abstract method
} 
