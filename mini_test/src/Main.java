public class Main {
    public static void main(String[] args) {
        long total = 0;
        Employee[] employees = new Employee[6];
        employees[0] = new EmployeeFullTime(1, "John", 30, "0902020202", "john@gmail.com", 10000000, 200000, 5000000);
        employees[1] = new EmployeeFullTime(2, "Andy", 25, "0902020203", "andy@gmail.com", 1500000, 300000, 6000000);
        employees[2] = new EmployeeFullTime(3, "James", 28, "0902020204", "james@gmail.com", 500000, 500000, 3000000);
        employees[3] = new EmployeePartTime(4, "Bruno", 22, "0902546158", "bruno@gmail.com", 150);
        employees[4] = new EmployeePartTime(5, "Saka", 23, "0902543145", "saka@gmail.com", 100);
        employees[5] = new EmployeePartTime(6, "Nathan", 26, "0902983145", "nathan@gmail.com", 50);
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        long averageSalary = total / employees.length;
        System.out.println("Lương trung bình của toàn bộ nhân viên là: " + averageSalary);
        underAverage(employees, averageSalary);
        long totalPartTimeSalary = calculateTotalPartTimeSalary(employees);
        System.out.println("Tổng lương phải trả cho tất cả các nhân viên bán thời gian là: " + totalPartTimeSalary);
        System.out.println("Nhân viên toàn thời gian sắp xếp theo lương tăng dần:");
        softEmployeeFullTime(employees);
    }

    private static void softEmployeeFullTime(Employee[] employees) {
        System.out.println("Danh sách nhân viên toàn thời gian sau khi sắp xếp:");
        for (Employee employee : employees) {
            if (employee instanceof EmployeeFullTime) {
                EmployeeFullTime employeeFullTime = (EmployeeFullTime) employee;
                System.out.println(employeeFullTime.getName() + " - Lương: " + employeeFullTime.getSalary());
            }
        }
    }

    private static long calculateTotalPartTimeSalary(Employee[] employees) {
        long totalPartTimeSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof EmployeePartTime) {
                totalPartTimeSalary += employee.getSalary();
            }
        }
        return totalPartTimeSalary;
    }

    private static void underAverage(Employee[] employees, long averageSalary) {
        System.out.println("Danh sách nhân viên toàn thời gian có mức lương thấp hơn mức lương trung bình:");
        for (Employee employee : employees) {
            if (employee instanceof EmployeeFullTime) {
                EmployeeFullTime employeeFullTime = (EmployeeFullTime) employee;
                if (employeeFullTime.getSalary() < averageSalary) {
                    System.out.println(employeeFullTime.getName() + " - Mã nhân viên: " + employeeFullTime.getCode());
                }
            }
            if (employee instanceof EmployeePartTime) {
                EmployeePartTime employeePartTime = (EmployeePartTime) employee;
                if (employeePartTime.getSalary() < averageSalary) {
                    System.out.println(employeePartTime.getName() + " - Mã nhân viên: " + employeePartTime.getCode());

                }
            }
        }
    }


}