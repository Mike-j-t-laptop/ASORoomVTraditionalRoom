package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "customers",
	indices = {
			@Index(name = "IFK_CustomerSupportRepId",value = {"SupportRepId"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Employees.class
			,childColumns = {
				"SupportRepId"
			}
			,parentColumns = {
				"EmployeeId"
			}
		)
	}
)
public class Customers{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "CustomerId")
	private Long customerId;

	@NonNull
	@ColumnInfo(name = "FirstName")
	private String firstName;

	@NonNull
	@ColumnInfo(name = "LastName")
	private String lastName;

	@ColumnInfo(name = "Company")
	private String company;

	@ColumnInfo(name = "Address")
	private String address;

	@ColumnInfo(name = "City")
	private String city;

	@ColumnInfo(name = "State")
	private String state;

	@ColumnInfo(name = "Country")
	private String country;

	@ColumnInfo(name = "PostalCode")
	private String postalCode;

	@ColumnInfo(name = "Phone")
	private String phone;

	@ColumnInfo(name = "Fax")
	private String fax;

	@NonNull
	@ColumnInfo(name = "Email")
	private String email;

	@NonNull
	@ColumnInfo(name = "SupportRepId")
	private Long supportRepId;

	public Customers() {}

	@Ignore
	public Customers(String firstName, String lastName,
					 String company,
					 String address, String city, String state, String country, String postalCode,
					 String phone, String fax, String email, Long supportRepId
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.supportRepId = supportRepId;
	}

	public Long getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return this.company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return this.fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getSupportRepId() {
		return this.supportRepId;
	}
	public void setSupportRepId(Long supportRepId) {
		this.supportRepId = supportRepId;
	}

}
