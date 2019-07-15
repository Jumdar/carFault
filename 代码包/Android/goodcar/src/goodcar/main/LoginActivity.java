package goodcar.main;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import goodcar.model.Errorinfo;
import goodcar.service.ErrorinfoService;
import goodcar.service.UserService;

public class LoginActivity extends Activity {
	
	//����ؼ�
	private EditText edphone;
    private EditText edpassword;
    private ImageButton login;
	private TextView register;
	private ImageView info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// �ҵ����������Ҹ�ֵ
		register =(TextView) findViewById(R.id.register);
		login =(ImageButton) findViewById(R.id.login);
	    edphone =(EditText) findViewById(R.id.edphone);
		edpassword =(EditText) findViewById(R.id.edpassword);
		
		//��ת��ע��ҳ��
		 register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(LoginActivity.this,RegisterActivity.class);
				startActivityForResult(it,1);
			}
		});
		 
		 login.setOnClickListener(new ButtonClickListener());
	}
	
	// ��¼��ť�ĵ���¼�
		private final class ButtonClickListener implements View.OnClickListener {
			public void onClick(View v) {
				String phone = edphone.getText().toString();
				String password = edpassword.getText().toString();
				
//				Errorinfo error = new Errorinfo();
//				final ErrorinfoService errsvc = new ErrorinfoService(LoginActivity.this);
//				error.setCode("P0505");
//				error.setContent("���ٿ���ϵͳ����");
//				error.setType("���ٿ���ϵͳ");
//				errsvc.insert(error);
//				
//				error.setCode("P0104");
//				error.setContent("������������·��Ъ����");
//				error.setType("����������");
//				errsvc.insert(error);
//				
//				error.setCode("P1300");
//				error.setContent("���ϵͳ����ʧ��");
//				error.setType("���ϵͳ");
//				errsvc.insert(error);
				
				Log.i("TAG",phone+"_"+password);
				UserService uService=new UserService(LoginActivity.this);
				boolean flag=uService.uservertify(phone, password);
				if(flag){
					Log.i("TAG","��¼�ɹ�");
					Toast.makeText(LoginActivity.this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();

					Intent intent = new Intent(LoginActivity.this,ShowActivity.class);
					startActivity(intent);
				}else{
					Log.i("TAG","��¼ʧ��");
					Toast.makeText(LoginActivity.this, "�û������������", Toast.LENGTH_SHORT).show();
				}
				
				SharedPreferences save = getSharedPreferences("user",MODE_PRIVATE);
				SharedPreferences.Editor editor = save.edit();
				editor.putString("phone",edphone.getText().toString());
				editor.commit();
				
			}
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
