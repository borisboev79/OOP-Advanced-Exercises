package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {

        int oldest = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
        return employees.stream().filter(a -> a.getAge() == oldest).findFirst().orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        return "Employees working at Cafe: " + this.name + ":" + System.lineSeparator() +
                this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}

