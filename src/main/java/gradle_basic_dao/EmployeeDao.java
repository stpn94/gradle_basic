package gradle_basic_dao;

import java.util.List;

import gradle_basic_dto.Department;
import gradle_basic_dto.Employee;
// Data Access Object
public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	
	Employee selectEmployeeByNo(Employee employee);

	int insertEmployee(Employee employee); // 객체

	int updateEmployee(Employee employee);

	int deleteEmployee(int EmployeeNo); // 기본타입

	List<Employee> selectEmployeeBydeptNo(Department department);
}
