package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "employees",
	indices = {
			@Index(name = "IFK_EmployeeReportsTo",value = {"ReportsTo"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Employees.class
			,childColumns = {
				"ReportsTo"
			}
			,parentColumns = {
				"EmployeeId"
			}
		)
	}
)
public class Employees{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "EmployeeId")
	private Long employeeId;

	@NonNull
	@ColumnInfo(name = "LastName")
	private String lastName;

	@NonNull
	@ColumnInfo(name = "FirstName")
	private String firstName;

	@ColumnInfo(name = "Title")
	private String title;

	@NonNull
	@ColumnInfo(name = "ReportsTo")
	private Long reportsTo;

	@ColumnInfo(name = "BirthDate")
	private String birthDate;

	@ColumnInfo(name = "HireDate")
	private String hireDate;

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

	@ColumnInfo(name = "Email")
	private String email;

	public Employees() {}

	@Ignore
	public Employees(String firstName, String lastName, String title,
					 long reportsTo,
					 String birthDate, String hireDate,
					 String address, String city, String state,String country, String postalCode,
					 String phone, String fax, String email
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.reportsTo = reportsTo;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getReportsTo() {
		return this.reportsTo;
	}
	public void setReportsTo(Long reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getBirthDate() {
		return this.birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getHireDate() {
		return this.hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
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

}
