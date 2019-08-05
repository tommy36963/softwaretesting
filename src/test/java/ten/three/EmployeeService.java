package ten.three;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public boolean add(Employee employee){
        if(employeeDao.validate(employee)){
            return true;
        }
        return false;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee update( Employee employee){
        if(employeeDao.validate(employee)){
            // do update operation
            return employee;
        }
        throw new RuntimeException("Validation failed");
    }
}
