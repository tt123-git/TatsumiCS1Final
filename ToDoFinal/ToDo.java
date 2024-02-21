/*In this class, a program is written to add new plans by categories. This class implements CategoryArray. First, when the category method of this class is called, enter the year, month, and day, respectively. Past or inappropriate numbers and string are not accepted. However, the last day of the month is different for each month, so the calender method is used to determine the last day of the month, and if the day does not exist, an exception is thrown. If any other incorrect number or character is entered, the loop can be redone as many times as necessary. Once the correct day is entered, we move on to selecting the plans category. Once the correct category is selected, the categoryPick method is called and the files in the selected category are selected so that the plans can be written to each file.
 * 
 */

package ToDoFinal;

import java.io.*;
import java.util.Scanner;

import ToDoFinal.Categories.CtgClass;
import ToDoFinal.Categories.CtgHangOut;
import ToDoFinal.Categories.CtgHobby;
import ToDoFinal.Categories.CtgImportant;
import ToDoFinal.Categories.CtgJob;
import ToDoFinal.Categories.CtgOther;
import ToDoFinal.Categories.CtgStudy;

import java.util.Calendar;

public class ToDo implements CategoryArray{

    File job = new File("ToDoFinal/job.txt");//All file pathes
    File classes = new File("ToDoFinal/classes.txt");
    File study = new File("ToDoFinal/study.txt");
    File hangOut = new File("ToDoFinal/hangOut.txt");
    File hobby = new File("ToDoFinal/hobby.txt");
    File important = new File("ToDoFinal/important.txt");
    File other = new File("ToDoFinal/other.txt");

    private String planScan1;//YYYY string field
    private String planScan2;//MM string field
    private String planScan3;//DD string field

    private int planInt;//for YYYY string to int
    private int planInt1;// for MM string to int
    private int planInt2;//for DD string to int

    private int year;//This year
    private int month;//This month
    private int day;//Today

    String scanOutPut;//Category input string

    boolean existDay = true; //if last day of the month is exsit get false

    CtgJob ctgJob = new CtgJob("job", "High");//Ctg classes constructors
    CtgClass ctgClass = new CtgClass("class", "High");
    CtgStudy ctgStudy = new CtgStudy("study", "normal");
    CtgHangOut ctgHangOut = new CtgHangOut("hang out", "normal");
    CtgHobby ctgHobby = new CtgHobby("hobby", "High");
    CtgImportant ctgImportant = new CtgImportant("important", "Very High");
    CtgOther ctgOther = new CtgOther("other", "Low");


  /*
   * category method:
   * 
   * Function1
   * Can not input past year, month and day compare with today. 
   * If input invalid number,program will loop and can fix it.
   * If input invalid string, program will throw exception.
   * */  

  public void category()throws FileNotFoundException, Exception{

    System.out.println("Enter the YYYY for your schedule");                            
    Scanner planYear = new Scanner(System.in);
    planScan1 = planYear.nextLine();//Input for YYYY       
    planInt = Integer.parseInt(planScan1);
    calNew();//Call calNew class for compare today's year, month and day 
    
    if(planInt < year){//If input is past year, it will loop, you need to input this year or future
      while(planInt < year){
        System.out.println("It is past year");
        System.out.println("Input this year or future");
        Scanner planYear1 = new Scanner(System.in);
        planScan1 = planYear1.nextLine();  
        planInt = Integer.parseInt(planScan1);//Need to store valid year

      }

    }
    
    System.out.println("Enter the MM for your schedule");                            
    Scanner planMonth = new Scanner(System.in);
    planScan2 = planMonth.nextLine();
    planInt1 = Integer.parseInt(planScan2); 
    if(planInt1 < month && planInt == year || planInt1 > 12){//If past month or more than 12, it will loop
      while(planInt1 < month && planInt == year || planInt1 > 12){
        System.out.println("It is past month or invalid month");
        System.out.println("Input this month or future");
        Scanner planMonth1 = new Scanner(System.in);
        planScan2 = planMonth1.nextLine();
        planInt1 = Integer.parseInt(planScan2);//Need to input future 

      }
    }
  
    System.out.println("Enter the DD for your schedule");                            
    Scanner planDay = new Scanner(System.in);
    planScan3 = planDay.nextLine();
    planInt2 = Integer.parseInt(planScan3); 
    if(planInt2 < day && planInt == year && planInt1 == month ||
     planInt2 > 31){//If input is past day or input more than 31, it will loop

      while(planInt2 < day && planInt == year && planInt1 == month 
      || planInt2 > 31){
        System.out.println("It is past day or invalid day");
        System.out.println("Input today or future");
        Scanner planDay1 = new Scanner(System.in);
        planScan3 = planDay1.nextLine();
        planInt2 = Integer.parseInt(planScan3);//Need to input future day 

      }
    }
    calender();//if last day of the month is not exist, throw exception from calender method
    

    categoryArr();//Show category list from categoryArr method
               
    System.out.println();              
    System.out.println();
    System.out.println("Input plan category or order number");
    Scanner scan = new Scanner(System.in);
    scanOutPut = scan.nextLine();//Need to input category or order number

    if(scanOutPut.equals("1") || scanOutPut.equals("2") || scanOutPut.equals("3") || scanOutPut.equals("4")|| scanOutPut.equals("5") || scanOutPut.equals("6") || scanOutPut.equals("7")||scanOutPut.equals("job") || scanOutPut.equals("classes") || scanOutPut.equals("study") || scanOutPut.equals("hang out") ||
    scanOutPut.equals("hobby") || scanOutPut.equals("important") ||
    scanOutPut.equals("other")){//If input valid category of number call categoryPick method
      
      categoryPick();
    }
    else{//If input invalid category of number, loop until input vaild input
      while(scanOutPut != "1" || scanOutPut != "2" || scanOutPut != "3" || scanOutPut != "4"|| 
      scanOutPut != "5" || scanOutPut != "6" || scanOutPut != "7"|| scanOutPut != "job" ||
      scanOutPut != "classes" || scanOutPut != "study" || scanOutPut != "hang out" ||
      scanOutPut != "hobby" || scanOutPut != "important" || scanOutPut != "other"){

        categoryArr();
        System.out.println();
        System.out.println("Input vaild category name or category number");
        Scanner scanAgain = new Scanner(System.in);//Scanner for input
        scanOutPut = scanAgain.nextLine();

        if(scanOutPut.equals("1") || scanOutPut.equals("2") || scanOutPut.equals("3") || scanOutPut.equals("4")|| scanOutPut.equals("5") || scanOutPut.equals("6") || scanOutPut.equals("7")||scanOutPut.equals("job") || scanOutPut.equals("classes") || scanOutPut.equals("study") || scanOutPut.equals("hang out") ||
        scanOutPut.equals("hobby") || scanOutPut.equals("important") ||
        scanOutPut.equals("other")){

          categoryPick();//if vaild input, call categoryPick method
          break;
        }
        else{

        }

      }
    }

  }

  /*
   * categoryPick method:
   * 
   * Function1
   * If files does not exist each categories, make new file.
   * 
   * Function2
   * If file exist, read selected category file schedule by scanner.
   * Print priority each categories.
   * 
   */

  public void categoryPick()throws FileNotFoundException, Exception{

    if(scanOutPut.equals("job")  || scanOutPut.equals("1")){//If scanOutPut is job or 1
      try {
            if(!job.exists()){//if file not exist make new file
          
              job.createNewFile();
          }
          FileWriter planFile = new FileWriter(job, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgJob.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan1 = new Scanner(System.in);//input plan
          String jobScan = scan1.nextLine();
          planFile.write(jobScan + "\n");//append to plan to file
          
          planFile.close(); //close file writer
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
    else if(scanOutPut.equals("classes") || scanOutPut.equals("2")){//If input is classes or 2
         try {
            if(!classes.exists()){//if file not exist make new file
          
              classes.createNewFile();
          }
          FileWriter planFile = new FileWriter(classes, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgClass.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan2 = new Scanner(System.in);//input plan
          String classScan = scan2.nextLine();
          planFile.write(classScan + "\n");//append to plan to file
          
          planFile.close();//close file writer 
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    else if(scanOutPut.equals("study") || scanOutPut.equals("3")){//If scanOutPut is study or 3
      try {
            if(!study.exists()){//if file not exist make new file
          
              study.createNewFile();
          }
          FileWriter planFile = new FileWriter(study, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgStudy.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan3 = new Scanner(System.in);//input plan
          String studyScan = scan3.nextLine();
          planFile.write(studyScan + "\n");//append to plan to file
          
          planFile.close();//close file writer 
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }
    }
    else if(scanOutPut.equals("hang out") || scanOutPut.equals("4")){//If input is hang out or 4
      try {
            if(!hangOut.exists()){//if file not exist make new file
          
              hangOut.createNewFile();
          }
          FileWriter planFile = new FileWriter(hangOut, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgHangOut.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan4 = new Scanner(System.in);//input plan
          String hangScan = scan4.nextLine();
          planFile.write(hangScan + "\n");//append to plan to file
          planFile.close();//close file writer
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
    else if(scanOutPut.equals("hobby") || scanOutPut.equals("5")){//If scanOutPut is hobby or 5
      try {
            if(!hobby.exists()){//if file not exist make new file
          
              hobby.createNewFile();
          }
          FileWriter planFile = new FileWriter(hobby, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgHobby.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan5 = new Scanner(System.in);//input plan
          String hobbyScan = scan5.nextLine();
          planFile.write(hobbyScan + "\n");//append to plan to file
          planFile.close();//close file writer
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
   
    else if(scanOutPut.equals("important") || scanOutPut.equals("6")){//If input is imprtant or 6
      try {
            if(!important.exists()){//if file not exist make new file
          
              important.createNewFile();
          }
          FileWriter planFile = new FileWriter(important, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgHobby.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan6 = new Scanner(System.in);//input plan
          String importantScan = scan6.nextLine();
          planFile.write(importantScan + "\n");//append to plan to file
          planFile.close();//close file writer
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }

    }
    else if(scanOutPut.equals("other") || scanOutPut.equals("7")){//If scanOutPut is other or 7
      try {
            if(!other.exists()){//if file not exist make new file
          
              other.createNewFile();
          }
          FileWriter planFile = new FileWriter(other, true);//FileWriter constructor
          planFile.write(planScan1 + "," + planScan2 + "," + planScan3 + ":" + " ");//input year, month and day
          System.out.println("Enter your "+ ctgOther.getCatgName() +" schedule");//print priority using polymorphism
          Scanner scan7 = new Scanner(System.in);//input plan
          String otherScan = scan7.nextLine();
          planFile.write(otherScan + "\n");//append to plan to file
          planFile.close();//close file writer
          } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
          
        }
    }
   
  }

  /*
   * calender method:
   * 
   * Function1
   * 
   * Using calender class, compare with year, month day that inputed 
   * and that day is exist or not, if not exist, throw exception.  
   */


  public void calender()throws Exception{//Compare the day is exsist or not

    Calendar cal = Calendar.getInstance();//Get calender instance

    int intYear = Integer.parseInt(planScan1);//input year convert to int
    int intMonth = Integer.parseInt(planScan2);//input month convert to int
    int intDay = Integer.parseInt(planScan3);//input day convert to int
    
    cal.setLenient(false);//Check iligal year,month and day
    cal.set(intYear, intMonth - 1, intDay);//month is usually added 1, so need to subtract 1
   
    try{
      cal.getTime();//Get Today's year, month and day
      existDay = false;//comfirm defined day is exsit or not
      System.out.println("It is valid date");
    }
    catch(Exception ex){
      throw new IllegalArgumentException("Does not exsist that day.");
    }
      
    }

    /*categoryArr method:

    Function1

    This is abstract method from CategoryArray class. 
    Implemented this method. Inheritance categoryList.
    Make categories list by for loop.
     * 
     */

    public void categoryArr(){
      for(int i = 0; i < categoryList.length; i++){//Make category list
      System.out.print((i + 1) +","+ categoryList[i] + " ");
    }   
    }

    /*
     * calNew method:
     * 
     * Function1
     * Using calender class. get year, month and day for today.
     * Then compre today and inputed days.
     */

     public void calNew()throws Exception{

      Calendar calToday = Calendar.getInstance();//Get calender instance

      year = calToday.get(Calendar.YEAR);//Get this year
      month = calToday.get(Calendar.MONTH) + 1;//Get this month but month is usulally -1, so need to add 1
      day = calToday.get(Calendar.DATE);//Get today
      //This info for compare with input is past or not

     }
    
}
