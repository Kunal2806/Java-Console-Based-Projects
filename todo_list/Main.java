
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Task{

    private List<String> tasks = new ArrayList<>();

    public boolean add(String addTask)

    {
        try 
        {
            if(addTask.equals(""))
            {
                throw new NullPointerException("Task cannot be Empty!");
            }
            if(addTask.length()>100)
            {
                throw new IllegalArgumentException("Only Tasks upto 100 characters can accepted");
            }
            tasks.add(addTask);
            return true;
        } 
        catch(NullPointerException e) 
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        catch(IllegalArgumentException e) 
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        catch (Exception e) 
        {
            System.out.println("An unexoected error occured: " + e.getMessage());
            return false;
        }
    }

    public boolean remove(String removeTask)
    {
        try 
        {
            if(!tasks.contains(removeTask))
            {
                throw new NoSuchElementException("no such element found!");
            }
            tasks.remove(removeTask);
            return true;
        } 
        catch( NoSuchElementException e) 
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        catch (Exception e) 
        {
            System.out.println("An undefined error occured: " + e.getMessage());
            return false;
        }
    }

    public void display()
    {
        try
        {
            if(tasks.isEmpty())
            {
                throw new NoSuchElementException("No Task to display!");
            }
            tasks.forEach(n -> System.out.println(n));
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("An undefined error occured: " + e.getMessage());
        }
    }
}

public class Main
{
    public static void main(String[] args) {

        Task taskList =  new Task();

        Scanner sc = new Scanner(System.in);
        
        while(true)
        {
            System.out.println
        (
            "\nTo-Do List Applicatiuon\n" +
            "\n\tEnter 1 to Add Task\n" +
            "\tEnter 2 to Remove Task\n" +
            "\tEnter 0 to Display your Tasks\n" +
            "\tEnter -1 to Exit\n" +
            "-------------------------------------"
        );

        int n = sc.nextInt();
        sc.nextLine();
            switch(n)
            {
                case 1: 
                System.out.println("Enter Task to add:");
                String taskToAdd = sc.nextLine();
                if(taskList.add(taskToAdd))
                {
                System.out.println("Task Added\n");
                }
                break;
                
                case 2:
                System.out.println("Enter Task to remove:");
                String taskToRemove = sc.nextLine();
                if(taskList.remove(taskToRemove))
                {
                    System.out.println("Task Removed\n");
                }
                break;

                case 0: 
                System.out.println("Your Tasks:\n");
                taskList.display();
                break;

                case -1:
                System.out.println("Thanks to come!...");
                sc.close();
                return;

                default:
                System.out.println("Undefined Instruction" + "\n Try Again");
                break;
            }
        }
    }
}
   