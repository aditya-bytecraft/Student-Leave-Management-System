import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeaveManager manager = new LeaveManager();

        while (true) {
            System.out.println("\n--- Student Leave Management ---");
            System.out.println("1. Apply Leave");
            System.out.println("2. View Applications");
            System.out.println("3. Approve/Reject Leave");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter leave date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter reason: ");
                    String reason = sc.nextLine();

                    Student s = new Student(name, id);
                    LeaveApplication app = new LeaveApplication(s, date, reason);
                    manager.applyLeave(app);
                    System.out.println("Leave applied successfully!");
                    break;

                case 2:
                    System.out.println("\n--- All Applications ---");
                    int i = 0;
                    for (LeaveApplication a : manager.getApplications()) {
                        System.out.println((i++) + ". " + a);
                    }
                    break;

                case 3:
                    System.out.print("Enter application index to update: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter status (Approved/Rejected): ");
                    String status = sc.nextLine();
                    manager.updateStatus(index, status);
                    System.out.println("Status updated.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
