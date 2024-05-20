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
        softEmployeeFullTime(employees);
        System.out.println("Danh sách nhân viên toàn thời gian sau khi sắp xếp:");
        for (Employee employee : employees) {
            if (employee instanceof EmployeeFullTime) {
                EmployeeFullTime fullTimeEmployee = (EmployeeFullTime) employee;
                System.out.println(fullTimeEmployee.getName() + " - Lương: " + fullTimeEmployee.getSalary());
            }
        }
    }

    private static void softEmployeeFullTime(Employee[] employees) {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = 0; j < employees.length - i - 1; j++) {
                if (employees[j] instanceof EmployeeFullTime && employees[j + 1] instanceof EmployeeFullTime) {
                    EmployeeFullTime emp1 = (EmployeeFullTime) employees[j];
                    EmployeeFullTime emp2 = (EmployeeFullTime) employees[j + 1];
                    if (emp1.getSalary() > emp2.getSalary()) {
                        Employee temp = employees[j];
                        employees[j] = employees[j + 1];
                        employees[j + 1] = temp;
                    }
                }
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