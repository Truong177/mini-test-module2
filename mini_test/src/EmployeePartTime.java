public class EmployeePartTime extends Employee {
    private double numOfWork;

    public EmployeePartTime() {
    }

    public EmployeePartTime(int code, String name, int age, String phoneNumber, String email, double numOfWork) {
        super(code, name, age, phoneNumber, email);
        this.numOfWork = numOfWork;
    }

    public double getNumOfWork() {
        return numOfWork;
    }

    public void setNumOfWork(double numOfWork) {
        this.numOfWork = numOfWork;
    }

    @Override
    public long getSalary() {
        return (long) (getNumOfWork() * 100000);
    }
}
