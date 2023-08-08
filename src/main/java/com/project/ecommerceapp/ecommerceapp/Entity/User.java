package com.project.ecommerceapp.ecommerceapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name="app_user")
public class User implements UserDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String lastt_name;
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number")
	private String number;
	@Column(name="userpass")
	private String password;
	
	@Column(name="roles")
	private String roles;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	@JsonIgnore
	private ShoppingCart shoppingCart;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
