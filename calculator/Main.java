import java.util.InputMismatchException;
import java.util.Scanner;
class Calculator {
    
    public int add(int num1, int num2) {
       
    return num1 + num2;
    }
    public int sub(int num1, int num2) {  
        return num1 - num2;
    }
    public int mult(int num1, int num2) {
        return num1 * num2;
    }
    public int divide(int num1, int num2) {
        if(num2==0) {
            throw new ArithmeticException("Denomenator cannot be 0");
        }
        return num1 / num2;
    }
}
public class Main {
    public static void main(String [] args) {
        Calculator c = new Calculator();
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println(
                "\nEnter 1 for Addition \n" +
                "Enter 2 for Subtraction \n" +
                "Enter 3 for Multiplication \n" +
                "Enter 4 for Division \n" +
                "Enter -1 to Exit"
            );
            int option = sc.nextInt();
            int num1 = 0, num2 = 0;
            if(option!=-1) {
                System.out.print("Enter num1: ");
                num1 = sc.nextInt();
                System.out.print("\nEnter num2: ");
                num2 = sc.nextInt();
            }
            switch(option) {
                case 1:
                System.out.println(c.add(num1, num2));
                break;
                case 2:
                System.out.println(c.sub(num1, num2));
                break;
                case 3:
                System.out.println(c.mult(num1, num2));
                break;
                case 4:
                System.out.println(c.divide(num1, num2));
                break;
                case -1:
                System.out.println("Thanks to visit");
                sc.close();
                return;
                default:
                System.out.println("Invalid button presed, Try agian");
                break;
            }
            }
            catch(InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
                sc.next();
            }
            catch(ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
            catch(Exception e) {
                System.out.println("An unknown error occured: " + e.getMessage());
            }
        }
    }
}
