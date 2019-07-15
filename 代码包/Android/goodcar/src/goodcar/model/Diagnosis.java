package goodcar.model;

public class Diagnosis {
	private int carid;
	private int userid;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDiaresult() {
		return diaresult;
	}
	public void setDiaresult(String diaresult) {
		this.diaresult = diaresult;
	}
	private String diaresult;
}
