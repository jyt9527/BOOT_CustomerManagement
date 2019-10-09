package cn.jyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @ClassName: Application
 * @Description: 用于启动tomcat
 * @author: JYT
 * @date: 2019年8月12日 下午2:53:28
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
