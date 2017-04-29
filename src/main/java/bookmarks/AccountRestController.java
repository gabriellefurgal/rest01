package bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

// tag::code[]
@RestController
@RequestMapping("/users")

public class AccountRestController {

	private final AccountRepository accountRepository;

	@Autowired
	AccountRestController( AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	Account readAccount(@PathVariable Long userId) {
		this.validateUser(userId);
		return this.accountRepository.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<AccountUsername> readAccounts() {
		return this.accountRepository.findAllProjectedBy();
	}
	
	private void validateUser(Long userId) {
		this.accountRepository.findById(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}

}
