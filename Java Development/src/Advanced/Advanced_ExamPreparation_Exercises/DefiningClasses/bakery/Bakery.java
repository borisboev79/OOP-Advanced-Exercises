package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {

      Employee toBeRemoved = employees.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
      if (toBeRemoved != null) {
          employees.remove(toBeRemoved);
          return true;
      }
      return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        return "Employees working at Bakery " + this.name + ":" + System.lineSeparator() +
                this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
