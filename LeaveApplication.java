public class LeaveApplication {
    private Student student;
    private String date;
    private String reason;
    private String status; // Pending, Approved, Rejected

    public LeaveApplication(Student student, String date, String reason) {
        this.student = student;
        this.date = date;
        this.reason = reason;
        this.status = "Pending";
    }

    public Student getStudent() {
        return student;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return student.getName() + " (" + student.getStudentId() + ") - " +
               date + " - " + reason + " - " + status;
    }
}
