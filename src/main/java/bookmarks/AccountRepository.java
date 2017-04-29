package bookmarks;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    Optional<Account> findById(Long id);
    
    List<AccountUsername> findAllProjectedBy();
    //Account findOne(Long id);
    
    }
