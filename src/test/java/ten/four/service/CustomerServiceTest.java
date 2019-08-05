package ten.four.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ten.four.Customer;
import ten.four.dao.CustomerDao;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    /**
     * @InjectMocks : will inject the mocks marked with
     * @Mock to ths instance when it is created
     */

    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @Captor
    private ArgumentCaptor<Customer> customerArgument;

    @Test
    public void testRegisterWithCustomerReturnsValidToken() {
        service.register(new Customer());
        // captures the arguement which was passed in to save method.
       verify(daoMock).save(customerArgument.capture());
       // make sure a token is assigned by the register method before save
        String id = customerArgument.getValue().getToken();
        assertThat(id, is(notNullValue()));
    }

    @Test
    public void testAddCustomerReturnsNewCustomer() {

        Customer expected = new Customer();
        when(daoMock.save(any(Customer.class))).thenReturn(expected);
        Customer actual = service.addCustomer(expected);
        assertThat(actual, is(notNullValue()));
        assertEquals(expected, actual);

    }

    @Test(expected = RuntimeException.class)
    public void testAddCustomerThrowsException() {
        Customer customer = new Customer();
        when(daoMock.save(customer)).thenThrow(RuntimeException.class);
        service.addCustomer(customer);
    }

    @Test(expected = RuntimeException.class)
    public void yesyChangeEmailWithUpdateEmailThrowsThenThrowsException() {
        doThrow(RuntimeException.class).when(daoMock).updateEmail(any(Customer.class), any(String.class));
        // calling the method under test
        service.changeEmail(new Customer(),"world@ada.com");
    }

}