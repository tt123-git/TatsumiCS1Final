/*
This class is essentially the main class of this to do list application. Therefore, the program is run from this class. This class is a subclass of the ToDo class. First, this class allows the user to choose whether to create a new plans or to check an existing plans, and to create a new plan by calling the category method of the ToDo class if Y is entered. If you input N, you can call the readFile method of the SeePlan class to check the existing plans. If you mistakenly input anything other than Y or N, it will loop back to you.
 */
package ToDoFinal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToDoRun extends ToDo{

  private static String changeStr;

  static SeePlan see = new SeePlan(changeStr);//SeePlan class constructor

  /*
   * main method:
   * 
   * Function1
   * Can chose make new plan or make sure plans.
   * Input Y call ToDo class category method that is you can make new plan.
   * Input N call SeePlan class readFile method that is you can make sure your plan.
   */

  public static void main(String[]args)throws FileNotFoundException, Exception{

    String selectStr;

    ToDo toDo = new ToDo();

    System.out.println("Do you want make a new schedule? Input Y");
    System.out.println("Do you want to make sure your schedule? Input N");
    Scanner select = new Scanner(System.in);
    selectStr = select.nextLine();

      if(selectStr.equals("Y")){

      toDo.category();//Call ToDo class category method.
    }
    else if(selectStr.equals("N")){

      see.readFile();//Call SeePlan readFile method.
    }
    else{
      while(selectStr != "Y" || selectStr != "N"){//if input exept Y and N, question will loop
        System.out.println("Input must be Y or N");
        System.out.println("Do you want make a new schedule? Input Y");
        System.out.println("Do you want to make sure your schedule? Input N");
         Scanner select1 = new Scanner(System.in);
         selectStr = select1.nextLine();

        if(selectStr.equals("Y")){

          toDo.category();//Call ToDo class category method.
        }
        else if(selectStr.equals("N")){

          see.readFile();//Call SeePlan readFile method.
        }
      }
    }

  }

  public static void change1(){//change category for SeePlan class using encapsulation

    if(see.bool == false){//This is if bool get false from SeePlan class, passthere and exit.
      System.exit(0);
    }

    System.out.println("Input plan category or order number");
  
    Scanner changeCtg = new Scanner(System.in);
    changeStr = changeCtg.nextLine();
    see.setscanOutPut(changeStr);//change category by setter

  }
  
}
