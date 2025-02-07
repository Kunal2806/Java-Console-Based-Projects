import java.util.InputMismatchException;
import java.util.Scanner;


class Bank {
    private int balance = 0;

    public void deposit(int depositAmount) {
        try {
            if(depositAmount <= 0) {
                throw new IllegalArgumentException("The provided amount to deposit is not valid");
            }

            balance += depositAmount;
            System.out.println(depositAmount + "is deposited in your account");
        }
        catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("An unknown error occurd: " + e.getMessage());
        }
    }

    public void withdraw(int withdrawAmount) {
        try {
            if(withdrawAmount > balance) {
                throw  new IllegalArgumentException("You donot have " + withdrawAmount + " in your account");
            }
            balance -= withdrawAmount;
            System.out.println(withdrawAmount + "Successfully withdraw form your account");
        }
        catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("An unknown error occured: " + e.getMessage());
        }
    }

    public void display() {
        System.out.println("Your balance: " + balance);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();
        while(true) {
            System.out.println(
            "\nEnter 1 to deposit\n" +
            "Enter 2 to withdraw\n" +
            "Enter 0 to check balance\n" +
            "Enter -1 to exit"
            );
            try {
                int option = sc.nextInt();
                switch(option) {
                    case 1: 
                    System.out.print("Enter money to deposit: ");
                    int depositAmount = sc.nextInt();
                    b.deposit(depositAmount);
                    break;
                    case 2:
                    System.out.print("\nEmter money to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    b.withdraw(withdrawAmount);
                    break;
                    case 0:
                    b.display();
                    break;
                    case -1:
                    System.out.println("Thanks to visit");
                    sc.close();
                    return;
                    default:
                    System.out.println("Invalid button pressed, Try again");
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Error: " + "Invalid input, try again");
                sc.next();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }   
        
    }
}