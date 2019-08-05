package ten.four.service;

import ten.four.Customer;
import ten.four.dao.CustomerDao;

import java.util.UUID;

public class CustomerService {

        private CustomerDao dao;

        // Requirement: we want to register a new customer. Every new customer
        // should be assigned a random token before saving in database.

    public void register(Customer customer){

        customer.setToken(generateToken());
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    public Customer addCustomer(Customer customer) {
        try{
            return dao.save(customer);
        }catch (Exception e) {
            throw new RuntimeException("oops something went wrong");
        }
    }

    public Customer changeEmail(Customer customer, String newEmail) {
        dao.updateEmail(customer, newEmail);
        return customer;
    }

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

}
