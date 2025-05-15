import java.util.*;
import java.io.*;

public class LeaveManager {
    private List<LeaveApplication> applications = new ArrayList<>();
    private final String fileName = "leave_data.txt";

    public LeaveManager() {
        loadApplicationsFromFile();
    }

    public void applyLeave(LeaveApplication app) {
        applications.add(app);
        saveApplicationsToFile();
    }

    public List<LeaveApplication> getApplications() {
        return applications;
    }

    public void updateStatus(int index, String status) {
        if (index >= 0 && index < applications.size()) {
            applications.get(index).setStatus(status);
            saveApplicationsToFile();
        }
    }

    private void saveApplicationsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (LeaveApplication app : applications) {
                writer.write(app.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadApplicationsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // For simplicity, just store as text (no reloading objects)
                // Advanced version can parse text back to objects
            }
        } catch (IOException e) {
            // No file yet? No problem.
        }
    }
}
