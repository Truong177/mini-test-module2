public class EmployeeFullTime extends Employee{
    private double bonusMoney;
    private double fineMoney;
    private double hardSalary;

    public EmployeeFullTime() {
    }

    public EmployeeFullTime(int code, String name, int age, String phoneNumber, String email, double bonusMoney, double fineMoney, double hardSalary) {
        super(code, name, age, phoneNumber, email);
        this.bonusMoney = bonusMoney;
        this.fineMoney = fineMoney;
        this.hardSalary = hardSalary;
    }

    public double getBonusMoney() {
        return bonusMoney;
    }

    public void setBonusMoney(double bonusMoney) {
        this.bonusMoney = bonusMoney;
    }

    public double getFineMoney() {
        return fineMoney;
    }

    public void setFineMoney(double fineMoney) {
        this.fineMoney = fineMoney;
    }

    public double getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }

    @Override
    public long getSalary() {
        return (long) (getHardSalary() + getBonusMoney() - getFineMoney());
    }

}
