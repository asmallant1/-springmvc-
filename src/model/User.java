package model;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
	@Id
	@Column
	private String id;
	@Column
	private String password;
	@Column
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
