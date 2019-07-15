package car;

public class window {

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isOpenOrclose() {
		return openOrclose;
	}
	public void setOpenOrclose(boolean status) {
		this.status = status;
	}
	public window() {
		// TODO Auto-generated constructor stub
		this.status = true;
		this.openOrclose = false;
	}
	private boolean status;
	private boolean openOrclose;
}
