package org.bankApp.service;

import org.bankApp.exception.MyEntityNotFoundException;
import org.bankApp.model.Customer;
import org.bankApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id));
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer newCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, Long id){
        Customer updateCustomer = getCustomer(id);

        updateCustomer.setFirstName(customer.getFirstName());
        updateCustomer.setLastName(customer.getLastName());
        updateCustomer.setMiddleName(customer.getMiddleName());
        updateCustomer.setStatus(customer.getStatus());

        return customerRepository.save(updateCustomer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
