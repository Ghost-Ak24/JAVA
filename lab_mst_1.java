import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class lab_mst_1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student List Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name to add: ");
                    String addName = sc.nextLine();
                    students.add(addName);
                    System.out.println(addName + " added successfully.");
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = sc.nextLine();
                    if (students.contains(removeName)) {
                        students.remove(removeName);
                        System.out.println(removeName + " removed successfully.");
                    } else {
                        System.out.println(removeName + " not found in the list.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("Error: Student list is empty!");
                    } else {
                        Collections.sort(students);
                        System.out.println("Sorted names: " + students);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
