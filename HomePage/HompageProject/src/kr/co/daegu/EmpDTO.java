package kr.co.daegu;

public class EmpDTO {
	String emp_id;
	String ename;
	int salary;
	String depart;
	
	public EmpDTO() {

	}
	
	public EmpDTO(String emp_id, String ename, int salary, String depart) {
		super();
		this.emp_id = emp_id;
		this.ename = ename;
		this.salary = salary;
		this.depart = depart;
	}
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	@Override
	public String toString() {
	return "EmpDTO [emp_id=" + emp_id + ", ename=" + ename + ", salary=" + salary + ", depart=" + depart + "]";
	}

}
