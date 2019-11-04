package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface Invoice_itemsDao{

	@Insert()
	 Long insertInvoice_items(Invoice_items invoice_items);

	@Insert()
	 Long[] insertInvoice_items(Invoice_items... invoice_items);

	@Update()
	 int updateInvoice_items(Invoice_items invoice_items);

	@Update()
	 int updateInvoice_items(Invoice_items... invoice_items);

	@Delete()
	int deleteInvoice_items(Invoice_items invoice_items);

	@Delete()
	int deleteInvoice_items(Invoice_items... invoice_items);

	@Query("SELECT * FROM `invoice_items`")
	List<Invoice_items> getEveryInvoice_items();

	@Query("SELECT count() FROM invoice_items")
	long getRowCount();
}
