package ten.three;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    private EmployeeDaoImp employeeDao;

    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {

        employeeService = new EmployeeService();
        employeeDao = mock(EmployeeDaoImp.class);
        employeeService.setEmployeeDao(employeeDao);
    }

    @Test
    public void testAddValidateEmployeeReturnsTrue(){
        boolean expected = true;
        Employee employee = new Employee("1", "Feride", "Celik");

        when(employeeDao.validate(employee)).thenReturn(true);
        boolean actual = employeeService.add(employee);

        verify(employeeDao).validate(employee);
        //verify(employeeDao).validate(employee);

        assertThat(actual, is(notNullValue()));
        assertEquals(expected, actual);

    }

    @Test
    public void testFindAllWithTwoEmployeeReturnsTwo(){
        Employee firstEmployee = new Employee("1","Feride", "Celik");
        Employee secondEmployee = new Employee("2","Ada","Lowalace");
        List<Employee> list = new ArrayList<>();
        list.add(firstEmployee);
        list.add(secondEmployee);
        when(employeeDao.findAll()).thenReturn(list);

        List<Employee> actual = employeeService.findAll();
        verify(employeeDao).findAll();
        verify(employeeDao,times(0)).update(any(Employee.class));
        verify(employeeDao,never()).validate(any(Employee.class));


        assertEquals(list, actual);
        assertEquals("Feride",list.get(0).getName());

    }

    @Test
    public void testFindAllWithEmptyListReturnsZeroData(){
        List<Employee> expected = new ArrayList<>();
        when(employeeDao.findAll()).thenReturn(expected);
        List<Employee> actual = employeeService.findAll();
        verify(employeeDao).findAll();
        assertEquals(0,actual.size());
    }

    @Test
    public void testUpdateWithValidEmployeeReturnsEmployee(){
        Employee employee = new Employee("2","Feride","Celik");
        when(employeeDao.validate(employee)).thenReturn(true);
        Employee actual = employeeService.update(employee);
        verify(employeeDao,times(1)).validate(employee);
        verify(employeeDao,atLeast(1)).validate(employee);
        verify(employeeDao,atMost(2)).validate(employee);
        assertEquals(employee,actual);

    }

}