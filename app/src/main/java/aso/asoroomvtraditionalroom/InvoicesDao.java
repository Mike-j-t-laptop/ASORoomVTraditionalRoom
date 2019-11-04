package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface InvoicesDao{

	@Insert()
	 Long insertInvoices(Invoices invoices);

	@Insert()
	 Long[] insertInvoices(Invoices... invoices);

	@Update()
	 int updateInvoices(Invoices invoices);

	@Update()
	 int updateInvoices(Invoices... invoices);

	@Delete()
	int deleteInvoices(Invoices invoices);

	@Delete()
	int deleteInvoices(Invoices... invoices);

	@Query("SELECT * FROM `invoices`")
	List<Invoices> getEveryInvoices();

	@Query("SELECT count() FROM invoices")
	long getRowCount();
}
