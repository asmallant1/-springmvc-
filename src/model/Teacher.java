package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@Column(name="tno")
	private String tno;
	@Column(name="tname")
	private String tname;
	@Column(name="sex")
	private String sex;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="institution")
	private String institution;
	@Column(name="personalmeassage")
	private String personalmessage;
	@Column(name="age")
	private String age;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPersonalmessage() {
		return personalmessage;
	}
	public void setPersonalmessage(String personalmessage) {
		this.personalmessage = personalmessage;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
