package model;

import java.sql.Timestamp;

public class Tborrowed {
	private String tno;
	private String cno;
	private Timestamp startdate;
	private Timestamp enddate;
	private String text;
	private int approval;
	private String approvaldate;
	private String applicationdate;
	public String getApplicationdate() {
		return applicationdate;
	}
	public void setApplicationdate(String applicationdate) {
		this.applicationdate = applicationdate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	public String getApprovaldate() {
		return approvaldate;
	}
	public void setApprovaldate(String approvaldate) {
		this.approvaldate = approvaldate;
	}
}
