package car;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("welcome to your virtual car!Please start your car!");
		System.out.println("Do you want to start your car?y or n:");
		Scanner reader = new Scanner(System.in);
		while(true)
		{
			String reader1 = reader.next();
			//System.out.println(".........."+a);
			if(reader1.equals("y")){
				//System.out.println("...................");
				carBody car = new carBody();
				car.startCar();
				Map m = car.getData();
				System.out.println("请选择接下来你要进行的操作：1-模拟故障检测，2-退出:");
				Scanner reader2 = new Scanner(System.in);
				while(true)
				{
					if(reader2.nextInt() == 1){
						//car.generateCode();
						System.out.println("please wait a moment.......");
						try {
							GreetServer t = new GreetServer(6066);
							t.setSendData(car.generateCode());
							t.start();
							if(t.isLink()){
								System.out.println("现在开始传输数据........");
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else if(reader2.nextInt() == 2){
						break;
					}
				}
				break;
				//Map carData = car.getData();
			}else{
				break;
			}
		}
		
	}

}
