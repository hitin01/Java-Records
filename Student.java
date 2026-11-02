import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== STUDENT RECORD MANAGER ====");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:

                sc.nextLine();

                System.out.println("Enter Student name: ");
                String name = sc.nextLine();
                System.out.println("Enter Student age: ");
                int age = sc.nextInt();

                try (FileWriter writer = new FileWriter("Student.txt", true)) {
                    writer.write("Name: " + name + "\n" + ", Age: " + age + "\n");
                    System.out.println("Student saved successfully!");
                } catch (IOException e) {
                    System.out.println("Error occurred while writing to the file.");
                    e.printStackTrace();
                }
                break;

            case 2:
                try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                    String line;
                    boolean found = false;

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        found = true;
                    }
                    if (!found) {
                        System.out.println("No student records found.");
                    }
                } catch (IOException e) {
                    System.out.println("Error occurred while reading the file.");
                    e.printStackTrace();
                }

                break;

            case 3:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice!");

                System.out.println("You selected option: " + choice);
        }
        sc.close();
    }

}
