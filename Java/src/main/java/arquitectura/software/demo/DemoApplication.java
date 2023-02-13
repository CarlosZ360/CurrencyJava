package arquitectura.software.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Hello World");
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		try {
			context.reset();
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			configurator.doConfigure("src/main/java/Logback.xml");
		} catch (JoranException je) {
			StatusPrinter.print(context);
		}

	}

}
