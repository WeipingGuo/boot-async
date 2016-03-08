package wguo.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *  * 
 * @author Weiping Guo
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableAsync
@ComponentScan()
public class Application implements CommandLineRunner {


	@Autowired
	private KafkaConsumerTask kafkaTask;
	     
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaTask.start();
	}
	

}
