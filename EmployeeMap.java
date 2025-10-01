import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMap {

    static class EmployeeNotFoundException extends Exception {
        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> employees = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Retrieve Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    employees.put(id, name);
                    System.out.println("Employee added: " + id + " -> " + name);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to retrieve: ");
                    int searchId = sc.nextInt();
                    try {
                        if (!employees.containsKey(searchId)) {
                            throw new EmployeeNotFoundException("Employee ID " + searchId + " not found!");
                        }
                        System.out.println("Employee Found: " + searchId + " -> " + employees.get(searchId));
                    } catch (EmployeeNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    if (employees.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("Employee List:");
                        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
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
