/*This class implemented Category class. AbstractCategory get parameter to sub classes.
CatgName and Priority has getter and setter. Get parameter to sub class and set it to this class of 
catgName and priority.
 * 
 */
package ToDoFinal;

/*
 * AbstractCategory class implement Category class.
 * AbstractCategory class has each category sub classes,
 * They inheritance to catgTheName and thePriority.
 * And those override by getter and setter.
 * getCatgName() is used in ToDo class.
 * getPriority() is used in SeePlan class.
 * 
 */

public abstract class AbstractCategory implements Category{
  private String catgName;//This field
  private String priority;//This field

  public AbstractCategory(String catgTheName, String thePriority){//class method

    catgName = catgTheName;//Field can get overrided catgName
    priority = thePriority;//Field can get overrided priority
  }

  @Override
  public String getCatgName(){
    return catgName;//return from setter
  }

  @Override
  public void setCatgName(String catgTheName){
    catgName = catgTheName;//Set catgTheName to sub classes.
  }

  @Override
  public String getPriority(){
    return priority;//return from setter
  }

  @Override
  public void setPriority(String thePriority){
    priority = thePriority;//Set catgTheName to sub classes.
  }

}
