package goodcar.model;

public class User {

	private int id;
	private String phone;
	private String password;
	private String bluetooth;
	
	public String getBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
