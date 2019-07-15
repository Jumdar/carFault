package car;

public class carLight {

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isOpenOrclose() {
		return openOrclose;
	}

	public void setOpenOrclose(boolean openOrclose) {
		this.openOrclose = openOrclose;
	}

	public carLight() {
		// TODO Auto-generated constructor stub
		status = false;
		openOrclose = false;
	}
	private boolean status;
	private boolean openOrclose;
	
}
