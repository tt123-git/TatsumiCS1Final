/*This class is interface for AbstractCategory class. 
 * 
 */
package ToDoFinal;

interface Category {
  

  /*
   * Those 4 methods will implement to AbstractCategory class,
   * and override those. AbstractCategory class has sub classes 
   * that each categories, so catgTheName and thePriority will
   * inheritance to them.
   */

  public String getCatgName();

  public void setCatgName(String catgTheName);

  public String getPriority();

  public void setPriority(String thePriority);
}
