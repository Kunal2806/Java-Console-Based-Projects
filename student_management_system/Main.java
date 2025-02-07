import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class Student {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId() {
        return id;
    }

    public void display() {
        System.out.println(
            "Id: " + id + "\n" +
            "Name: " + name + "\n" +
            "Marks: "+ marks + "\n" +
            "----------------\n"
        );
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> s = new ArrayList<>();
        
        while(true) {
            System.out.println(
                "Enter 1 to add student\n" +
                "Enter 2 to remove student\n" +
                "Enter 0 to display students\n" +
                "Enter -1 to exit" 
            );
            try {
                int option = sc.nextInt();
                sc.nextLine();
                switch(option) {
                    case 1:
                    System.out.print("\nEnter student id(Greater then 0): ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEnter student name: ");
                    String name = sc.nextLine();
                    System.out.print("\nEnter student marks(Greater then 0): ");
                    int marks = sc.nextInt();
                    try {
                        if(id < 1 || name.isEmpty() || marks < 1) {
                            throw new IllegalArgumentException("provided data is not valid, Try again");
                        }
                        Student student = new Student(id, name, marks);
                        s.add(student);
                    } catch(IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                    case 2:
                    System.out.println("Provide student id to remove: ");
                    int removeid = sc.nextInt();
                    s.removeIf(student-> student.getId() == removeid);
                    System.out.println("Student removed Successfully");
                    break;
                    case 0:
                    for(Student student : s) {
                        student.display();
                    }
                    break;
                    case -1:
                    System.out.println("Thanks to visit");
                    sc.close();
                    return;
                    default:
                    System.out.println("Wronng button pressed, Try again");
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Error: " + "Invalid input provided, try again with integer value");
                sc.next();
            } catch (Exception e) {
                System.out.println("An unknown error occured: " + e.getMessage());
            }
        }
    }
}