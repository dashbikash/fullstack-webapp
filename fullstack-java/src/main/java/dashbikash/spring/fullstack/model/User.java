package dashbikash.spring.fullstack.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Document
public class User implements UserDetails {
	public User(String username, String passwd, String role) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.role = role;
	}

	public User() {
		super();
	}

	private static final long serialVersionUID = 1L;
	private String username;
	private String passwd;
	private String role;

	// Getter Methods

	public String getUsername() {
		return username;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getRole() {
		return role;
	}

	// Setter Methods

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(this.role));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.passwd;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passwd=" + passwd + ", role=" + role + "]";
	}
}