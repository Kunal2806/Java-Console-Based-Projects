import java.util.InputMismatchException;
import java.util.Scanner;

class Gameclass
{
    private int generatedNumber;
    private int correctGuess = 0;

    public int getCorrectGuess()
    {
        return correctGuess;
    }

    public void check(int guess)
    {
        try
        {
            if(guess < 1 || guess > 10) 
            {
                throw new IllegalArgumentException("The number guessed by you is out of range");
            }
            if(generatedNumber == guess)
        {
            System.out.println("Lucky Number: " + generatedNumber + " Congrats, You guessed it correctly");
            correctGuess++;
        }
        else{
            System.out.println("Lucky Number: " + generatedNumber + " Wrong guess!");
        }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("An unknown error occured: " + e.getMessage());
        }
    }

    public void generate()
    {
        try
        {
            generatedNumber =  ((int)((Math.random()*10)+1));
        }
        catch(Exception e)
        {
            System.out.println("Error occured while generating a number: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Gameclass gc = new Gameclass();
        Scanner sc = new Scanner(System.in);


        while(true)
        {
            try
            {
                System.out.println("\nYour Score: " + gc.getCorrectGuess());
                System.out.println("\nEnter 1 to play\n" +"Enter -1 to exit");
                int num = sc.nextInt();
    
                switch (num) {
                    case 1:
                        gc.generate();
                        System.out.println("Guess the number between 1 - 10 : ");
                        int guess = sc.nextInt();
                        gc.check(guess);
                    break;
    
                    case -1:
                        System.out.println("Thanks to come");
                        sc.close();
                    return;
    
                    default:
                        System.out.println("Invalid instruction, try again!");
                    break;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input, Please select a number: " + e.getMessage() );
                sc.next();
            }
            catch(Exception e)
            {
                System.out.println("An unknown error occured: " + e.getMessage());
            }
        }
    }
}
