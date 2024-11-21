package model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	@Id
	@Column(name="username",nullable = false,unique = true)
	private String username;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="role",nullable = false)
	private String role;
	
	@Column(name="emailstatus",nullable = false)
	private boolean emailStatus = false;
	
	public boolean isEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(boolean emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(){
		
	}
	
	public User(String email, String username, String Password,String role) {
		this.email = email;
		this.username = username;
		this.password = Password;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", emailStatus=" + emailStatus + "]";
	}
	
}
