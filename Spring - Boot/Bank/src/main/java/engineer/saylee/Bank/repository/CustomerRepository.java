package engineer.saylee.Bank.repository;

import engineer.saylee.Bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>{
}
