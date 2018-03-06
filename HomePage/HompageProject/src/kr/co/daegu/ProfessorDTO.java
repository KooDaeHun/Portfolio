package kr.co.daegu;

import java.io.Serializable;

public class ProfessorDTO implements Serializable {
	private int bunho;
	private String age;
	private String irum;
	private String subject;
	
	public ProfessorDTO() {
		
	}
	public int getBunho() {
		return bunho;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "ProfessorDTO [bunho=" + bunho + ", age=" + age + ", irum=" + irum + ", subject=" + subject + "]";
	}
}
