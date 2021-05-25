package pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
	}

}
