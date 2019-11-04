package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface EmployeesDao{

	@Insert()
	 Long insertEmployees(Employees employees);

	@Insert()
	 Long[] insertEmployees(Employees... employees);

	@Update()
	 int updateEmployees(Employees employees);

	@Update()
	 int updateEmployees(Employees... employees);

	@Delete()
	int deleteEmployees(Employees employees);

	@Delete()
	int deleteEmployees(Employees... employees);

	@Query("SELECT * FROM `employees`")
	List<Employees> getEveryEmployees();

	@Query("SELECT max(employeeId) FROM employees")
	Long getLastEmployeeId();

	@Query("SELECT * FROM employees WHERE employeeId = :employeeId")
	Employees getEmployeeById(Long employeeId);

	@Query("SELECT count() FROM employees")
	long getRowCount();
}
