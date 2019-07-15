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
	
	//定义控件
	private EditText edphone;
    private EditText edpassword;
    private ImageButton login;
	private TextView register;
	private ImageView info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// 找到变量，并且赋值
		register =(TextView) findViewById(R.id.register);
		login =(ImageButton) findViewById(R.id.login);
	    edphone =(EditText) findViewById(R.id.edphone);
		edpassword =(EditText) findViewById(R.id.edpassword);
		
		//跳转到注册页面
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
	
	// 登录按钮的点击事件
		private final class ButtonClickListener implements View.OnClickListener {
			public void onClick(View v) {
				String phone = edphone.getText().toString();
				String password = edpassword.getText().toString();
				
//				Errorinfo error = new Errorinfo();
//				final ErrorinfoService errsvc = new ErrorinfoService(LoginActivity.this);
//				error.setCode("P0505");
//				error.setContent("怠速控制系统故障");
//				error.setType("怠速控制系统");
//				errsvc.insert(error);
//				
//				error.setCode("P0104");
//				error.setContent("空气流量计线路间歇故障");
//				error.setType("空气流量计");
//				errsvc.insert(error);
//				
//				error.setCode("P1300");
//				error.setContent("点火系统发生失火");
//				error.setType("点火系统");
//				errsvc.insert(error);
				
				Log.i("TAG",phone+"_"+password);
				UserService uService=new UserService(LoginActivity.this);
				boolean flag=uService.uservertify(phone, password);
				if(flag){
					Log.i("TAG","登录成功");
					Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

					Intent intent = new Intent(LoginActivity.this,ShowActivity.class);
					startActivity(intent);
				}else{
					Log.i("TAG","登录失败");
					Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
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
