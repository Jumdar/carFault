package car;

public class carDoor {

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isLockOpen() {
		return lockOpen;
	}
	public boolean isCloseStatus() {
		return closeStatus;
	}
	public carDoor() {
		// TODO Auto-generated constructor stub
		this.status = true;
	}
	private boolean status;
	private boolean lockOpen;
	private boolean closeStatus;
	
	public void LockDoor()
	{
		lockOpen = false;
		System.out.println("The door was lock");
	}
	public void OpenLock()
	{
		lockOpen = true;
		System.out.println("The clock was open");
	}
	public void OpenDoor(){
		closeStatus = false;
	}
	public void CloseDoor(){
		closeStatus = true;
	}
}
