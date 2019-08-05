package ten.three;

import java.util.List;

public interface EmployeeDao {

    boolean add(Employee employee);

    boolean validate(Employee employee);

    List<Employee> findAll();

    Employee update(Employee employee);
}
