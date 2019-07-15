package car;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class carBody {
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDistant() {
		return distant;
	}
	public void setDistant(double distant) {
		this.distant = distant;
	}
	public carBody() {
		// TODO Auto-generated constructor stub
		this.ac = new accelerator();
		this.airC=new airConditioner();
		this.brake=new brake();
		this.door1=new carDoor();
		this.door2=new carDoor();
		this.door3=new carDoor();
		this.door4=new carDoor();
		this.highLight=new carLight();
		this.lowLight=new carLight();
		this.rightLight=new carLight();
		this.LeftLight=new carLight();
		this.en=new engine();
		this.me=new media();
		this.oil=new oilTank();
		this.water=new waterTank();
		this.w1=new wheel();
		this.w2=new wheel();
		this.w3=new wheel();
		this.w4=new wheel();
		this.win1=new window();
		this.win2=new window();
		this.win3=new window();
		this.win4=new window();
	}
	accelerator ac;
	airConditioner airC;
	brake brake;
	carDoor door1;
	carDoor door2;
	carDoor door3;
	carDoor door4;
	carLight highLight;
	carLight lowLight;
	carLight rightLight;
	carLight LeftLight;
	engine en;
	media me;
	oilTank oil;
	waterTank water;
	wheel w1;
	wheel w2;
	wheel w3;
	wheel w4;
	window win1;
	window win2;
	window win3;
	window win4;
	ELM327 elm ;
	public ELM327 getElm() {
		return elm;
	}
	public void setElm(int elmId) {
		this.elm = new ELM327(elmId);
	}
	private double speed;
	private double distant;
	private double intoTempture;
	ArrayList<String> code = new ArrayList<String>();
	
	public double getIntoTempture() {
		return intoTempture;
	}
	public void setIntoTempture(double tempture) {
		this.intoTempture = tempture;
	}
	public void startCar(){
		//start the car
		en.StartEngineer();
		en.setCoolantTem(92);
		ac.setEngineLoad(35);
		ac.setRpm(1000);
		this.speed = 40.0;
		this.intoTempture = 25.0;
		this.distant = 500;
		oil.setOilCapacity(0.5);
		System.out.println("�����Ѿ�����");
	}
	public void stopCar(){
		//stop the car
		en.CloseEngineer();
		System.out.println("�����Ѿ�ֹͣ");
	}
	public void openTheDoor(carDoor door){
		door.OpenDoor();
	}
	public void closeTheDoor(carDoor door){
		door.CloseDoor();
	}
	public void openTheDoorClock(carDoor door){
		door.OpenLock();
	}
	public void closeTheDoorClock(carDoor door){
		door.LockDoor();
	}
	public void openWindow(window win){
		win.setOpenOrclose(true);
	}
	public void closeWindow(window win){
		win.setOpenOrclose(false);
	}
	public void speedUp(){
		if(ac.isStatus()){
			//��μ���
		}else{
			System.out.println("������Ż���");
		}
	}
	public void speedDown(){
		if(brake.isStatus()){
			//��μ���
		}else{
			System.out.println("���ɲ������");
		}
	}
	public void openLight(carLight light){
		light.setOpenOrclose(true);
	}
	public void closeLight(carLight light){
		light.setOpenOrclose(false);
	}
	public Map getData(){
		Map carData = new HashMap();
		carData.put("engineerLoad", ac.getEngineLoad());
		carData.put("coolanTem", en.getCoolantTem());
		carData.put("rpm", ac.getRpm());
		carData.put("intoTem", this.intoTempture);
		carData.put("oil", oil.getOilCapacity());
		return carData;
	}
	public ArrayList<String> generateCode(){
		code.add("P0104");
		code.add("P0505");
		code.add("P1300");
		code.add(String.valueOf(ac.getEngineLoad()));//����������
		code.add(String.valueOf(ac.getRpm()/50));//������ÿ����ת��
		code.add(String.valueOf((int)(oil.getOilCapacity()*100)));//������
		code.add(String.valueOf(en.getCoolantTem()));//������ȴҺ�¶�
		return code;
	}
	public void setOrder(String order){
		elm.setOrder(order);
	}
	public String getOrder(){
		return elm.sendOrder();
	}
	//дһ����������elm��order����ʱ�������ݷ��͸�android����ÿ��������ȡ
	/*
	01 04������������
	01 05��������ȴҺ�¶�
	01 0C��������ÿ����ת��
	01 0D������
	01 0F������Ŀ����¶�
	01 2F��������
	*/
}

