package wguo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerTask {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerTask.class);
	
	@Async("kafkaTaskExecutor")
	public void start() {
		log.info("starting consumer for topic testing");
		log.info("doing something ....");
	}
	
	@Bean
	public ThreadPoolTaskExecutor kafkaTaskExecutor() {
		ThreadPoolTaskExecutor bean = new ThreadPoolTaskExecutor();
        bean.setCorePoolSize(1);
        bean.setMaxPoolSize(1 * 2);
		bean.setWaitForTasksToCompleteOnShutdown(true);
		return bean;
	}		

}
