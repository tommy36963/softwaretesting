package five;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FunctionUtilTest {

    private static List<Employee> employees;
    private static List<Animal> animals;

    @BeforeClass
    public static void setUp() throws Exception{
        Employee[] arrayOfEmps = {
                new Employee(1,"Jeff Bezos", 10.0,DepartmentType.IT),
                new Employee(1,"Bill Gates", 20.0,DepartmentType.IT),
                new Employee(1,"Mark Zuckerberg", 300.0,DepartmentType.IT),
                new Employee(1,"Feride", 10.0,DepartmentType.IT),
        };
        employees = new ArrayList<>(Arrays.asList(arrayOfEmps));

        animals = new ArrayList<>();
        animals.add(new Animal(1,"Cat"));
        animals.add(new Animal(2,"Dog"));
    }
    @Test
    public void testGetEmployeesBySalaryWith100ReturnHigherThan100(){
        List<Employee> expectedList = FunctionUtil.getEmployeesBySalary(employees,10);
        assertEquals(expectedList.size(),2);
    }
    @Test
    public void testGroupEmployeesByDepartmentWithOneDeptReturnOne(){
        Map<DepartmentType,List<Employee>> departmentTypeListMap= FunctionUtil.groupEMployeesByDepartment(employees);
        assertEquals(departmentTypeListMap.get(DepartmentType.IT).size(),4);

    }
    @Test
    public void testGroupEmployeesByDepartmentWithOneDeptReturnTwo(){
        Map<Integer,Animal> animalMap= FunctionUtil.convertAnimalListToMap(animals);
        assertEquals(animalMap.size(),2);
    }
    @AfterClass
    public static void tearDown(){
        employees.clear();
        animals.clear();
    }

}