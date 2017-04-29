package bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bookmarks.aspects.ReFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @ReFormat
    public String getUsername() {
    	//System.out.println("getUsername");
    	return username;
    }

    @JsonIgnore
    public String password;
    public String username;

    public Account(String name, String password) {
        this.username = name;
        this.password = password;
    }

    @Override
    @ReFormat
    public String toString() {
        return String.format(
                "Customer[id=%d, username='%s']",id, username);
}
    
    Account() { // jpa only
    }
}