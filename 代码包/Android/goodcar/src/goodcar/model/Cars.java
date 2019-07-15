package goodcar.model;

public class Cars {
	private int  Informationid;
	private String EngineLoad;
	private String Temperature;
	private String oil;
	private int UserId;
	public int getInformationid() {
		return Informationid;
	}
	public void setInformationid(int Informationid) {
		this.Informationid = Informationid;
	}
	public String getEngineLoad() {
		return EngineLoad;
	}
	public void setEngineLoad(String EngineLoad) {
		this.EngineLoad = EngineLoad;
	}
	public String getTemperature() {
		return Temperature;
	}
	public void setTemperature(String Temperature) {
		this.Temperature = Temperature;
	}
	public String getOil() {
		return oil;
	}
	public void setOil(String oil) {
		this.oil = oil;
	}
	public String getCoolanTem() {
		return CoolanTem;
	}
	public void setCoolanTem(String pressure) {
		this.pressure = pressure;
	}
	public String getRPM() {
		return RPM;
	}
	public void setRPM(String RPM) {
		this.RPM = RPM;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
	private String CoolanTem;
	private String RPM;
}
