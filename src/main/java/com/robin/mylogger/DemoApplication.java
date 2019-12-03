package com.robin.mylogger;

import com.robin.logProviders.ConsoleProvider;
import com.robin.logProviders.ILogProvider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ILogProvider logProvider = new ConsoleProvider();

		logProvider.Register("This is a message", LogMessageType.MESSAGE);
		logProvider.Register("This is a warning", LogMessageType.WARNING);
		logProvider.Register("This is a error", LogMessageType.ERROR);
	}
}
