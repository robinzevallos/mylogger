package com.robin.mylogger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.robin.logProviders.ConsoleProvider;
import com.robin.logProviders.ILogProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testLogProvider() {

		ILogProvider logProvider = new ConsoleProvider();

		logProvider.Register("This is a message", LogMessageType.MESSAGE);
		logProvider.Register("This is a warning", LogMessageType.WARNING);
		logProvider.Register("This is a error", LogMessageType.ERROR);

		assertEquals(LogMessageType.MESSAGE, LogMessageType.MESSAGE);
	}

}
