package kr.co.daegu;

import java.io.Serializable;

public class ManagerDTO implements Serializable {
	private int bunho;
	private String age;
	private String irum;
	private String part;
	
	public ManagerDTO() {
		
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
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	@Override
	public String toString() {
		return "ManagerDTO [bunho=" + bunho + ", age=" + age + ", irum=" + irum + ", part=" + part + "]";
	}
}
