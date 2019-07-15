package car;

public class accelerator {

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public accelerator() {
		// TODO Auto-generated constructor stub
		this.status = true;
	}
	private boolean status;
	private int engineLoad;
	
	private int rpm;
	public int getRpm() {
		return rpm;
	}
	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
	public int getEngineLoad() {
		return engineLoad;
	}
	public void setEngineLoad(int engineLoad) {
		this.engineLoad = engineLoad;
	}
	
	

}
