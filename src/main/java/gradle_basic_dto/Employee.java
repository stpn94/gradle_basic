package gradle_basic_dto;

public class Employee {
	private int empNo;
	private String empName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;

	public Employee() {

	}

	public Employee(int empno) {
		this.empNo = empno;
	}

	public Employee(int empno, String empName, Title title, Employee manager, int salary, Department dept) {
		this.empNo = empno;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
	}


	public Employee(int empNo, String empName) {
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empno) {
		this.empNo = empno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	
	@Override
	public String toString() {
		return String.format("Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s]", empNo,
				empName, title, manager, salary, dept);
	}

}
