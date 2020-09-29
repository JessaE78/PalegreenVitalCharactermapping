/*
- Project 1
- Jessa Ecle, Johnny Chan, Santiago Acevedo, Christopher Nguyen, follow me on instagram @ chris.to.pho chris sucks my ass ,:D atleast i didnt get rejected from lockheed
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

class Main {

  public static String[] Instructor; // Global Instructor String
  public static String[] Student1; // Global firstStudent String
  public static String[] Student2; // Global secondStudent String
  
  // Print Menu Function
  public static void printMenu() 
  {
      System.out.println("\t\t\tWelcome to my Personal Management System\n\n");
      System.out.println("Choose one of the options: \n");
      System.out.println("1 - Enter the information of the faculty");
      System.out.println("2 - Enter the information of two students");
      System.out.println("3 - Print tuition invoice");
      System.out.println("4 - Print faculty information");
      System.out.println("5 - Exit program");   
  }

   // Select Menu Options
  public static int selectChoice (int option)
  {     
      Scanner scnr = new Scanner (System.in);
      String answer;
      int choice = 0;
      switch (option) {
        case 1: // Faculty Information
        choice = 1;
        System.out.println("Enter faculty information");

        
        if (Instructor != null)
        {
          System.out.println("You have faculty filled in. Do you want to update the information?");
          System.out.println("Yes or No: ");
          answer = scnr.next();
          answer = answer.toLowerCase();
          if (answer.equals("yes"))
          {
            choice = 1;
            System.out.println("Enter faculty information");
            Instructor = Arrays.copyOf(Faculty(), 4);
            break;
          }
          else if (answer.equals("no"))
          {
            break;
          }
          else 
          {
            System.out.println("Invalid Input");
            break;
          }
        }
        Instructor = Arrays.copyOf(Faculty(), 4);
        break;

        case 2: //Student Information
          if(Student1 != null && Student2 != null)
          {
            System.out.println("You have already have two students filled in. Do you want to update their information?");
            System.out.println("Yes or No: ");
            answer = scnr.next();
            answer = answer.toLowerCase();
            if(answer.equals("yes")){
              choice = 2;
              System.out.println("Enter student 1 information");
              Student1 = firstStudent();
              System.out.println("Enter student 2 information");
              Student2 = secondStudent();
              break;
            }
            else if(answer.equals("no"))
            {
              break;
            }
            else
            {
              System.out.println(answer);
              System.out.println("Invalid Input");
              break;
            }
            
          }
          choice = 2;
          System.out.println("Enter student 1 information");
          Student1 = firstStudent();
          System.out.println("Enter student 2 information");
          Student2 = secondStudent();
        // students
        break;

        case 3: // Student Invoice
        choice = 3;
        studentInvoice(Student1, Student2);
        break;

        case 4: // Faculty Information
        choice = 4;
        facultyInvoice(Instructor);
        break;

        case 5: // Exit Program
        choice = 5;
        System.out.println("Peace out, A-Town");
        break;
        
        default:
        choice = 0;
        System.out.println("\n\n\nInvalid entry- please try again");
        break;
        
      }
      
      return choice;

  }

  // String storing Faculty Information
  public static String[] Faculty()
  {
    Scanner scnr = new Scanner(System.in);
    String[] criteria = new String[4];
    
    System.out.print("Name of the faculty: ");
    criteria[0] = scnr.nextLine();

    System.out.print("ID: ");
    criteria[1] = scnr.nextLine();
    
    System.out.print("Rank: ");
    criteria[2] = scnr.nextLine();
    criteria[2] = criteria[2].toLowerCase();
    while(!criteria[2].equals("professor") && !criteria[2].equals("adjunct")){
      System.out.println("Sorry entered rank (" + criteria[2] + ") is invalid");
      System.out.print("Rank: ");
      criteria[2] = scnr.nextLine();
      criteria[2] = criteria[2].toLowerCase();
    }

    System.out.print("Department: ");
    criteria[3] = scnr.nextLine();
    criteria[3] = criteria[3].toLowerCase();
    while(!criteria[3].equals("mathematics") && !criteria[3].equals("engineering") && !criteria[3].equals("arts") && !criteria[3].equals("science")){
      System.out.println("Invalid department");
      System.out.print("Department: ");
      criteria[3] = scnr.nextLine();
      criteria[3] = criteria[3].toLowerCase();
    }

    return criteria;
    
  }

  // String storing first student information
  public static String [] firstStudent()
  {
      Scanner scnr = new Scanner(System.in);
      String [] info = new String[4];
      
      System.out.print("Name of Student: ");
      info[0] = scnr.nextLine();
      
      System.out.print("ID: ");
      info[1] = scnr.next();

      System.out.print("GPA: ");
      info[2] = scnr.next();
      
      System.out.print("Credit Hours: ");
      info[3] = scnr.next();

      return info;
  } 

  // String storing second student information
  public static String[] secondStudent()
  {
      Scanner scnr = new Scanner(System.in);
      String [] data = new String[4];

      System.out.print("Name of Student: ");
      data[0] = scnr.nextLine();
      
      System.out.print("ID: ");
      data[1] = scnr.next();

      System.out.print("GPA: ");
      data[2] = scnr.next();
      
      System.out.print("Credit Hours: ");
      data[3] = scnr.next();

      return data;
  }

  // Print facultyInvoice function
  public static void facultyInvoice(String Instructor[])
  {
      System.out.println("-------------------------------------------------------");
      System.out.println(Instructor[0]);
      System.out.println(Instructor[3]+" Department,"+Instructor[2]);
      System.out.println("-------------------------------------------------------");
  } 

  // Print studentInvoice function
  public static void studentInvoice(String firstStudent[], String secondStudent[])
  {
    //0-name, 1-ID, 2-GPA/Rank , 3-Credit Hours/Department
    int creditHrs1 = Integer.parseInt(firstStudent[3]);
    int creditHrs2 = Integer.parseInt(secondStudent[3]);
    double total = 0;
    double discountTotal = 0;
    double discount = 0;

    double GPA1 = Double.parseDouble(firstStudent[2]);
    double GPA2 = Double.parseDouble(secondStudent[2]);
  

    Scanner invoiceScnr = new Scanner(System.in);
    System.out.println("Which student? 1 " + firstStudent[0] + " or 2 " + secondStudent[0] + "?");
    int choice = invoiceScnr.nextInt();

      if (choice == 1)
      {
          System.out.println("-------------------------------------------------------");
          System.out.println(firstStudent[0] + "\t\t " + firstStudent[1]); 
          // name and student id
          System.out.println("Credit Hours: " + firstStudent[2] + "($236.45/credit hour)"); 
          // credit Hours
          System.out.println("Fees: $52");
          
         if(GPA1 >= 3.85)
        {
          total = (creditHrs1 * 236.45) + 52;
          discountTotal = total * 0.75;
          discount = total * 0.25;
          System.out.printf("Total payment: $%.2f \t\t\t ($%.2f discount applied)",discountTotal,discount);
          System.out.println("-------------------------------------------------------");
        }
        else
        {
          System.out.printf("Total payment: $%.2f \t\t\t ($0 discount applied)\n",((creditHrs2 * 236.45) + 52));
          System.out.println("-------------------------------------------------------");
        }
      }
      
      else if (choice == 2)
      {
       
          System.out.println("-------------------------------------------------------");
          System.out.println(secondStudent[0] + "\t\t " + secondStudent[1]);
          System.out.println("Credit Hours: " + secondStudent[2] + "($236.45/credit hour)"); // credit Hours
          System.out.println("Fees: $52");
        if(GPA2 >= 3.85)
        {
          total = (creditHrs2 * 236.45) + 52;
          discountTotal = total * 0.75;
          discount = total * 0.25;
          System.out.printf("Total payment: $%.2f \t\t\t ($%.2f discount applied)",discountTotal,discount);
          System.out.println("-------------------------------------------------------");
        }
        else
        {
          System.out.printf("Total payment: $%.2f \t\t\t ($0 discount applied)\n",((creditHrs1 * 236.45) + 52));
          System.out.println("-------------------------------------------------------");
        }
        
      }
  }

  public static void main(String[] args) 
  {
     int choice = 0;
     
    
    do  {
          printMenu();
          Scanner scnr = new Scanner(System.in);
          if(scnr.hasNextInt())
          {
            int option = scnr.nextInt();
            System.out.println("");
            choice = selectChoice(option);// Menu works, we got somewhere printMenu
          }
          else
          {
            System.out.println("Invalid Entry- Try again");
          }
          
        } while (choice < 5);   
  }
  
}



