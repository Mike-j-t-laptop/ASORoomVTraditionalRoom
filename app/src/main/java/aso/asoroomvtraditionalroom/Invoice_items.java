package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "invoice_items",
	indices = {
			@Index(name = "IFK_InvoiceLineInvoiceId",value = {"InvoiceId"}),
		
			@Index(name = "IFK_InvoiceLineTrackId",value = {"TrackId"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Tracks.class
			,childColumns = {
				"TrackId"
			}
			,parentColumns = {
				"TrackId"
			}
		),
		@ForeignKey(
			entity=Invoices.class
			,childColumns = {
				"InvoiceId"
			}
			,parentColumns = {
				"InvoiceId"
			}
		)
	}
)
public class Invoice_items{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "InvoiceLineId")
	private Long invoiceLineId;

	@NonNull
	@ColumnInfo(name = "InvoiceId")
	private Long invoiceId;

	@NonNull
	@ColumnInfo(name = "TrackId")
	private Long trackId;

	@NonNull
	@ColumnInfo(name = "UnitPrice")
	private String unitPrice;

	@NonNull
	@ColumnInfo(name = "Quantity")
	private Long quantity;

	public Long getInvoiceLineId() {
		return this.invoiceLineId;
	}
	public void setInvoiceLineId(Long invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}
	public Long getInvoiceId() {
		return this.invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Long getTrackId() {
		return this.trackId;
	}
	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}
	public String getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Long getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
