package kr.co.daegu;

public class Haksa {
	private int bunho;
	private String age;
	private String irum;
	
	public Haksa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Haksa(int bunho, String age, String irum) {
		super();
		this.bunho = bunho;
		this.age = age;
		this.irum = irum;
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

}
