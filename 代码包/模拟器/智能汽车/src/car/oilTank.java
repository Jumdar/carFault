package car;

public class oilTank {

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getOilCapacity() {
		return oilCapacity;
	}
	public void setOilCapacity(double d) {
		this.oilCapacity = d;
	}
	public oilTank() {
		// TODO Auto-generated constructor stub
		this.status = true;
	}
	private boolean status;
	private double oilCapacity;
}
