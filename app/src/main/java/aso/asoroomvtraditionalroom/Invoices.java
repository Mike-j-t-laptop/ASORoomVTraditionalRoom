package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "invoices",
	indices = {
			@Index(name = "IFK_InvoiceCustomerId",value = {"CustomerId"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Customers.class
			,childColumns = {
				"CustomerId"
			}
			,parentColumns = {
				"CustomerId"
			}
		)
	}
)
public class Invoices{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "InvoiceId")
	private Long invoiceId;

	@NonNull
	@ColumnInfo(name = "CustomerId")
	private Long customerId;

	@NonNull
	@ColumnInfo(name = "InvoiceDate")
	private String invoiceDate;

	@ColumnInfo(name = "BillingAddress")
	private String billingAddress;

	@ColumnInfo(name = "BillingCity")
	private String billingCity;

	@ColumnInfo(name = "BillingState")
	private String billingState;

	@ColumnInfo(name = "BillingCountry")
	private String billingCountry;

	@ColumnInfo(name = "BillingPostalCode")
	private String billingPostalCode;

	@NonNull
	@ColumnInfo(name = "Total")
	private String total;

	public Long getInvoiceId() {
		return this.invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Long getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getInvoiceDate() {
		return this.invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getBillingAddress() {
		return this.billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBillingCity() {
		return this.billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingState() {
		return this.billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public String getBillingCountry() {
		return this.billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingPostalCode() {
		return this.billingPostalCode;
	}
	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}
	public String getTotal() {
		return this.total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}
