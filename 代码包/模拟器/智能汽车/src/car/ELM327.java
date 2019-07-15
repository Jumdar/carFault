package car;

public class ELM327 {

	public ELM327(int elmid) {
		// TODO Auto-generated constructor stub
		this.elmId = elmid;
	}
	private int elmId;
	private String order;
	
	public void setOrder(String order)
	{
		this.order = order;
	}
	public String sendOrder(){
		return order;
	}
	
}
