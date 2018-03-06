package kr.co.daegu;

import java.io.Serializable;

public class StudentDTO implements Serializable {
	private int bunho;
	private String age;
	private String irum;
	private String hakbun;
	public StudentDTO() {
		
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
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [bunho=" + bunho + ", age=" + age + ", irum=" + irum + ", hakbun=" + hakbun + "]";
	}
}
