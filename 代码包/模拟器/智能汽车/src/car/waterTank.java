package car;

public class waterTank {

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isWaterCapacity() {
		return waterCapacity;
	}
	public void setWaterCapacity(boolean waterCapacity) {
		this.waterCapacity = waterCapacity;
	}
	public waterTank() {
		// TODO Auto-generated constructor stub
		this.status = true;
	}
	private boolean status;
	private boolean waterCapacity;
}
