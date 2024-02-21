/*This class is sub class of AbstractCategory class. This class method of parameter inheritance from 
super class method of parameter for Polymorphism.
 * 
 */
package ToDoFinal.Categories;

import ToDoFinal.AbstractCategory;

public class CtgHangOut extends AbstractCategory{
  
  public CtgHangOut(String catgTheName, String thePriority){
    super(catgTheName, thePriority);//Inharitance AbstractCategory class

  }
  
}
