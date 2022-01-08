package engineer.saylee.Bank.repository;

import engineer.saylee.Bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
