package car;

public class airConditioner {

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
	public int getTemperture() {
		return temperture;
	}
	public String getFunction() {
		return function;
	}
	public double getAirSpeed() {
		return airSpeed;
	}
	public int getGears() {
		return gears;
	}
	public String getCycle() {
		return cycle;
	}
	public String getDirection() {
		return direction;
	}
	public airConditioner() {
		// TODO Auto-generated constructor stub
		this.status = true;
		this.openOrclose = false;
	}
	private boolean status;
	private boolean openOrclose;
	private int temperture;
	private String function;
	private double airSpeed;//m/s
	private int gears;
	private String cycle;
	private String direction;
	
	public double ComputerSpeed(int gears,String cycle,String directionMode)
	{
		double airspeed = 0;
		if(cycle == "inner"){
			switch(directionMode){
				case "face":
					if(gears==1)
						airspeed = 0.95;
					else if(gears==2)
						airspeed = 1.7;
					else if(gears==3)
						airspeed = 2.75;
					else if(gears==4)
						airspeed = 3.8;
					break;
				case "window":
					if(gears==1)
						airspeed = 1.7;
					else if(gears==2)
						airspeed = 2.7;
					else if(gears==3)
						airspeed = 3.9;
					else if(gears==4)
						airspeed = 5.1;
					break;
				case "foot":
					if(gears==1)
						airspeed = 2.7;
					else if(gears==2)
						airspeed = 3.9;
					else if(gears==3)
						airspeed = 5.8;
					else if(gears==4)
						airspeed = 6.95;
					break;
				case "foot and window":
					if(gears==1)
						airspeed = 1.275;
					else if(gears==2)
						airspeed = 1.95;
					else if(gears==3)
						airspeed = 2.825;
					else if(gears==4)
						airspeed = 4.125;
					break;
				case "face and foot":
					if(gears==1)
						airspeed = 0.85;
					else if(gears==2)
						airspeed = 1.52;
					else if(gears==3)
						airspeed = 2.18;
					else if(gears==4)
						airspeed = 3.2;
					break;
			}
				
		}else if(cycle == "outer"){
			switch(directionMode){
			case "face":
				if(gears==1)
					airspeed = 0.95;
				else if(gears==2)
					airspeed = 1.725;
				else if(gears==3)
					airspeed = 2.675;
				else if(gears==4)
					airspeed = 3.65;
				break;
			case "window":
				if(gears==1)
					airspeed = 1.4;
				else if(gears==2)
					airspeed = 2.7;
				else if(gears==3)
					airspeed = 3.65;
				else if(gears==4)
					airspeed = 5.2;
				break;
			case "foot":
				if(gears==1)
					airspeed = 1.95;
				else if(gears==2)
					airspeed = 3.8;
				else if(gears==3)
					airspeed = 5.25;
				else if(gears==4)
					airspeed = 7.0;
				break;
			case "foot and window":
				if(gears==1)
					airspeed = 1.125;
				else if(gears==2)
					airspeed = 1.825;
				else if(gears==3)
					airspeed = 3.15;
				else if(gears==4)
					airspeed = 4.175;
				break;
			case "face and foot":
				if(gears==1)
					airspeed = 0.8;
				else if(gears==2)
					airspeed = 1.52;
				else if(gears==3)
					airspeed = 2.25;
				else if(gears==4)
					airspeed = 3.0;
				break;
			}
		
			
	}else{
			if(!openOrclose){
				airSpeed = 0.0;
			}else{
				System.out.printf("error:cycle don't have the mode");
			}
	}
	return airspeed;
	}
	public boolean open(){
		openOrclose = true;
		return openOrclose;
	}
	public boolean close(){
		openOrclose = false;
		return openOrclose;
	}
	public void adjustGear(int gears){
		this.gears = gears;
		System.out.println("Now gears:"+gears);
	}
	public void adjustFunction(String function){
		this.function = function;
		System.out.println("Now function:"+function);
	}
	public void adjustCycle(String cycle){
		this.cycle = cycle;
		System.out.println("Now cycle:"+cycle);
	}
	public void adjustDirection(String direction)
	{
		this.direction = direction;
		System.out.println("Now direction:"+direction);
	}
	public int computerTem(){
		return 0;
	}//¼ì²âÎÂ¶È
	
}
