package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface CustomersDao{

	@Insert()
	 Long insertCustomers(Customers customers);

	@Insert()
	 Long[] insertCustomers(Customers... customers);

	@Update()
	 int updateCustomers(Customers customers);

	@Update()
	 int updateCustomers(Customers... customers);

	@Delete()
	int deleteCustomers(Customers customers);

	@Delete()
	int deleteCustomers(Customers... customers);

	@Query("SELECT * FROM `customers`")
	List<Customers> getEveryCustomers();

	@Query("SELECT count() FROM customers")
	long getRowCount();
}
