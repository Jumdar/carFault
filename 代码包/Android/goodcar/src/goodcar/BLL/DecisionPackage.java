package goodcar.BLL;

import goodcar.model.Errorinfo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;


public class DecisionPackage {
	public JSONObject pack(ArrayList<Errorinfo> errlist){
		JSONObject object = new JSONObject();
		try {
			object.put("x1", 0);
			object.put("x2", 0);
			object.put("x3", 0);
			object.put("x4", 0);
			object.put("x5", 0);
			object.put("x6", 0);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		int length = errlist.size();
		for(int i=0;i<length;i++){
			if(errlist.get(i).getType() == "����������"){
				
			} try {
				object.put("x1", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(errlist.get(i).getType() == "����������"){
				
			} try {
				object.put("x2", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(errlist.get(i).getType() == "���������Ӽ�"){
				
			} try {
				object.put("x3", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(errlist.get(i).getType() == "�ͱõ�·"){
				
			} try {
				object.put("x4", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(errlist.get(i).getType() == "������"){
				
			} try {
				object.put("x5", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(errlist.get(i).getType() == "ȼ��ѹ��������"){
				
			} try {
				object.put("x6", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
}
