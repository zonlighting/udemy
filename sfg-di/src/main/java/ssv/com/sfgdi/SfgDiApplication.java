package ssv.com.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfgDiApplication.class, args);
//		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
//		MyController myController = (MyController) ctx.getBean("myController");
//		String greeting = myController.sayHello();
//		System.out.println(greeting);
	}

}
