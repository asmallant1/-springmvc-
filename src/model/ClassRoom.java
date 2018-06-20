package model;

import javax.persistence.Column;
import javax.persistence.Id;

public class ClassRoom {
	@Id
	@Column(name="cno")
	private String cno;
	@Column(name="cname")
	private String cname;
	@Column(name="type")
	private String type;
	@Column(name="size")
	private int size;
	@Column(name="address")
	private String address;
	@Column(name="institution")
	private String institution;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
}
