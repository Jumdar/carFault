package car;

public class engine {

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isOpenOrclose() {
		return openOrclose;
	}


	public engine() {
		// TODO Auto-generated constructor stub
		status = true;
		openOrclose = false;
	}
	private boolean status;
	private boolean openOrclose;
	private int coolantTem;
	
	public int getCoolantTem() {
		return coolantTem;
	}

	public void setCoolantTem(int coolantTem) {
		this.coolantTem = coolantTem;
	}

	public void StartEngineer(){
		openOrclose = true;
	}
	public void CloseEngineer(){
		openOrclose = false;
	}
}
