/*
- Project 1
- Jessa Ecle, Johnny Chan, Santiago Acevedo, Christopher Nguyen, follow me on instagram @ chris.to.pho chris sucks my ass ,:D atleast i didnt get rejected from lockheed
*/
import java.util.Scanner;


class Main {
  public static void main(String[] args) {
     int choice;
     
    do{
      printMenu();
       Scanner scnr = new Scanner(System.in);

          int option = scnr.nextInt();
          System.out.println("");
          choice = selectChoice(option);// Menu works, we got somewhere
    }
    while(choice < 5);   
  }
  
  public static void printMenu() {

      System.out.println("\t\t\tWelcome to my Personal Management System\n\n");
      System.out.println("Choose one of the options: \n");
      System.out.println("1 - Enter the information of the faculty");
      System.out.println("2 - Enter the information of two students");
      System.out.println("3 - Print tuition invoice");
      System.out.println("4 - Print faculty information");
      System.out.println("5 - Exit program");
      
   }
   
  public static int selectChoice (int option){
      int choice = 0;
      switch (option) {
        case 1:
        // faculty\
        choice = 1;
        System.out.println("Enter faculty information");
       // Instructor=Faculty();
        break;

        case 2:
        choice = 2;
        System.out.println("Enter student 1 information");
        //Student1();
        // students
        break;

        case 3:
        choice = 3;
        //Invoice(studentName1);
        break;

        case 4:
        choice = 4;
        // faculty info
        break;

        case 5:
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
}

