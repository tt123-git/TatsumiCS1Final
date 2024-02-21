/*In this class, you can check schedules input in the ToDo class by category. This class is a subclass of the ToDo class. First, this class starts with the readFile method, which determines which category of schedules to check. If an inappropriate category or number is entered, it will loop and repeat the same question again. Next, once you have chosen a category, you decide whether to change the category or continue as a confirmation. If you enter Y, you can continue with the category unchanged. If you enter N, you can go back to the previous option and choose another category again. Once you have selected a category, you can review the schedule in the file for the selected category.
 * 
 */
package ToDoFinal;

import java.util.*;
import java.io.*;

enum Name{JOB, CLASSES, STUDY, HANGOUT, HOBBY, IMPORTANT, OTHER;
}//Declaration enum objects

public class SeePlan extends ToDo{

  ToDo toDo = new ToDo();//Constructor of ToDo class
  String fixCategoryStr;//when asked change category or not, Y or N will store to here
  boolean bool = true;

private String scanOutPut;//If you do not need to change category, input string will store to this

SeePlan(String scanString){//Constructor of this class

    this.setscanOutPut(scanString);
  }

ToDoRun change = new ToDoRun();//ToDoRun class constructor
    

    /*
     * readFile method 
     * 
     * Function1:
     * You can chose category or order number what category suchedule you want to makesure.
     * 
     * Function2:
     * You can change category when you asked "Do you want to change category? Enter N".
     * 
     * Function3:
     * If you decided to category program call next step that fileCheck method.
     * 
     */

    public void readFile(){

    categoryArr();//Show you to categories list

    System.out.println();              
    System.out.println();
    System.out.println("Input schedule category or order number");
    Scanner scanPlan = new Scanner(System.in);//You can input category name or number
    scanOutPut = scanPlan.nextLine();

    if(scanOutPut.equals("1") || scanOutPut.equals("2") || scanOutPut.equals("3") || scanOutPut.equals("4")|| scanOutPut.equals("5") || scanOutPut.equals("6") || scanOutPut.equals("7")||scanOutPut.equals("job") || scanOutPut.equals("classes") || scanOutPut.equals("study") || scanOutPut.equals("hang out") ||
    scanOutPut.equals("hobby") || scanOutPut.equals("important") ||
    scanOutPut.equals("other")){//If you input vaild category or number you can pass here

      System.out.println("Continue see schedule process. Enter Y");
      System.out.println("Do you want to change category? Enter N");

      Scanner scanPlan1 = new Scanner(System.in);//Input Y or N
      fixCategoryStr = scanPlan1.nextLine();

      switch (fixCategoryStr) {
            case "Y":
          
            fileCheck();//If yes call faileCheck method
            System.exit(0);

            case "N":
              categoryArr();//Show you categories list
              System.out.println();
              change.change1();//Call ToDoRun class change1 method, and change category by setter. 
              fileCheck();//After change category, call fileCheck method
              break;
          
            default://If input is not Y or N pass default
              while(fixCategoryStr != "Y" || fixCategoryStr != "N"){//This loop will loop until input Y or N
                System.out.println("Input must be Y or N");
                System.out.println("Continue see schedule process. Enter Y");
                System.out.println("Do you want to change category? Enter N");
                Scanner scanPlan4 = new Scanner(System.in);
                fixCategoryStr = scanPlan4.nextLine();

                if(fixCategoryStr.equals("Y")){//Call fileCheck method

                  fileCheck();
                  System.exit(0);
                }
                else if(fixCategoryStr.equals("N")){//After change category, 
                  categoryArr();
                  System.out.println();
                  change.change1();
                  fileCheck();
                  break;
                }
              }
              break;
          }
    }
    else{

      while (scanOutPut != "1" || scanOutPut != "2" || scanOutPut != "3" || scanOutPut != "4"|| 
      scanOutPut != "5" || scanOutPut != "6" || scanOutPut != "7"|| scanOutPut != "job" ||
      scanOutPut != "classes" || scanOutPut != "study" || scanOutPut != "hang out" ||
      scanOutPut != "hobby" || scanOutPut != "important" || scanOutPut != "other"  ) {
        //This loop will loop until input valid input
        categoryArr();//Show you category list
        System.out.println();
        System.out.println("Input vaild category name or category number");
        Scanner scanPlan2 = new Scanner(System.in);
        scanOutPut = scanPlan2.nextLine();

        if(scanOutPut.equals("1") || scanOutPut.equals("2") || scanOutPut.equals("3") || scanOutPut.equals("4")|| scanOutPut.equals("5") || scanOutPut.equals("6") || scanOutPut.equals("7")||scanOutPut.equals("job") || scanOutPut.equals("classes") || scanOutPut.equals("study") || scanOutPut.equals("hang out") ||
        scanOutPut.equals("hobby") || scanOutPut.equals("important") ||
        scanOutPut.equals("other")){//If you input vaild input you can chouse cange category or not

          System.out.println("Continue see schedule process. Enter Y");
          System.out.println("Do you want to change category? Enter N");

          Scanner scanPlan3 = new Scanner(System.in);
          fixCategoryStr = scanPlan3.nextLine();
          switch (fixCategoryStr) {//Call faileCheck method
            case "Y":
          
            fileCheck();
            System.exit(0);

            case "N"://After change category, and call fileCheck method
              categoryArr();
              System.out.println();
              change.change1();
              fileCheck();
              break;
          
            default:
              while(fixCategoryStr != "Y" || fixCategoryStr != "N"){//If input is not Y or N pass here
                System.out.println("Input must be Y or N");
                System.out.println("Continue see schedule process. Enter Y");
                System.out.println("Do you want to change category? Enter N");
                Scanner scanPlan4 = new Scanner(System.in);
                fixCategoryStr = scanPlan4.nextLine();

                if(fixCategoryStr.equals("Y")){//Call fileCheck method

                  fileCheck();
                  System.exit(0);
                }
                else if(fixCategoryStr.equals("N")){//After change category, call fileCheck method
                  categoryArr();
                  System.out.println();
                  change.change1();
                  fileCheck();
                  break;
                }
                break;
              }
          }
        }

      }

    }

   
    }

    /*
     * fileCheck method:
     * 
     * function1
     * If each categories file does not exist, make new file.
     * 
     * function2
     * If you decide to which category schedule you want to see, 
     * you can see schedule from file by scanner. 
     */

    public void fileCheck(){

      Name nameJob = Name.JOB;//enum instances, erum object will print when you see each file of schedules
      Name nameClass = Name.CLASSES;
      Name nameStudy = Name.STUDY;
      Name nameHangOut = Name.HANGOUT;
      Name nameHobby = Name.HOBBY;
      Name nameImportant = Name.IMPORTANT;
      Name nameOther = Name.OTHER;

       if(scanOutPut.equals("job")  || scanOutPut.equals("1")){
      try {
            if(!job.exists()){//If not file exist, make new file
          
              job.createNewFile();
          }
          
          Scanner readJob = new Scanner(job);
          System.out.println(nameJob + " schedules lists priority is " + ctgJob.getPriority());
          while(readJob.hasNextLine()){//Read schedule

              String jobStr = readJob.nextLine();
              System.out.println(jobStr);
            
          }
          
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
    else if(scanOutPut.equals("classes") || scanOutPut.equals("2")){
         try {
            if(!classes.exists()){//If not file exist, make new file
          
              classes.createNewFile();
          }
         
          Scanner readClass = new Scanner(classes);
          System.out.println(nameClass + " schedules lists priority is " + ctgClass.getPriority());
          while(readClass.hasNextLine()){//Read schedule

              String classStr = readClass.nextLine();
              System.out.println(classStr);
            
          }
            
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    else if(scanOutPut.equals("study") || scanOutPut.equals("3")){
      try {
            if(!study.exists()){//If not file exist, make new file
          
              study.createNewFile();
          }
          Scanner readStudy = new Scanner(study);
          System.out.println(nameStudy + " schedules lists priority is " + ctgStudy.getPriority());
          while(readStudy.hasNextLine()){//Read schedule

              String studyStr = readStudy.nextLine();
              System.out.println(studyStr);
            
          }
            
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }
    }
    else if(scanOutPut.equals("hang out") || scanOutPut.equals("4")){
      try {
            if(!hangOut.exists()){//If not file exist, make new file
          
              hangOut.createNewFile();
          }
          Scanner readHangOut = new Scanner(hangOut);
          System.out.println(nameHangOut + " schedules lists priority is " + ctgHangOut.getPriority());
          while(readHangOut.hasNextLine()){//Read schedule

              String hangOutStr = readHangOut.nextLine();
              System.out.println(hangOutStr);
            
          }
         
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
    else if(scanOutPut.equals("hobby") || scanOutPut.equals("5")){
      try {
            if(!hobby.exists()){//If not file exist, make new file
          
              hobby.createNewFile();
          }
          Scanner readHobby = new Scanner(hobby);
          System.out.println(nameHobby + " schedules lists priority is " + ctgHobby.getPriority());
          while(readHobby.hasNextLine()){//Read schedule

              String hobbyStr = readHobby.nextLine();
              System.out.println(hobbyStr);
            
          }
         
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
   
    else if(scanOutPut.equals("important") || scanOutPut.equals("6")){
      try {
            if(!important.exists()){//If not file exist, make new file
          
              important.createNewFile();
          }
          Scanner readImportant = new Scanner(important);
          System.out.println(nameImportant + " schedules lists priority is " + ctgImportant.getPriority());
          while(readImportant.hasNextLine()){//Read schedule

              String importantStr = readImportant.nextLine();
              System.out.println(importantStr);
            
          }
         
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
    else if(scanOutPut.equals("other") || scanOutPut.equals("7")){
      try {
            if(!other.exists()){//If not file exist, make new file
          
              other.createNewFile();
          }

          Scanner readOther = new Scanner(other);
          System.out.println(nameOther + " schedules lists priority is " + ctgOther.getPriority());
          while(readOther.hasNextLine()){//Read schedule

              String otherStr = readOther.nextLine();
              System.out.println(otherStr);
            
          }
          
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }
    }
    else{
      System.out.println("Input vaild category or order number");
    }
    if(scanOutPut.equals("1") || scanOutPut.equals("2") || scanOutPut.equals("3") || scanOutPut.equals("4")|| scanOutPut.equals("5") || scanOutPut.equals("6") || scanOutPut.equals("7")||scanOutPut.equals("job") || scanOutPut.equals("classes") || scanOutPut.equals("study") || scanOutPut.equals("hang out") ||
    scanOutPut.equals("hobby") || scanOutPut.equals("important") ||
    scanOutPut.equals("other")){//If scanOutPut decide yet, do not pass here

          bool = false;//when pass here last time, makes can not change category anymore   
        }
    
    }

    public String getscanOutPut(){//change category from ToDoRun class change1 method
      return scanOutPut;
    }
  
    public void setscanOutPut(String scanOutPut){//Set new category
        this.scanOutPut = scanOutPut;
    }

    
}
  
