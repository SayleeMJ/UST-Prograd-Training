package engineer.saylee.Bank.service;

import engineer.saylee.Bank.entity.Customer;
import engineer.saylee.Bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);

    }
    public List<Customer> listAll(){
        return customerRepository.findAll();
    }

    public Customer findById(String username){
        return customerRepository.findById(username).get();
    }
    public boolean existsById(String username) {
        return customerRepository.existsById(username);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
