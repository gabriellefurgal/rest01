package bookmarks;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "accountUsername", types = { Account.class }) 
public interface AccountUsername {
	String getUsername();
}
