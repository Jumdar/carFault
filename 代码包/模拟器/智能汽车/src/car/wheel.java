package car;

public class wheel {

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public wheel() {
		// TODO Auto-generated constructor stub
		this.status = true;
	}
	private boolean status;
	private int pressure;
}
