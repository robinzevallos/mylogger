package com.robin.logProviders;

import java.util.logging.*;
import com.robin.mylogger.LogMessageType;

public class ConsoleProvider extends LogProvider implements ILogProvider {

    Logger logger;

    public ConsoleProvider() {
        logger = Logger.getLogger("MyLog");
        logger.addHandler(new ConsoleHandler());
    }

    @Override
    public void Register(String message, LogMessageType logMessageType) {    
        Level level = null;

        switch (logMessageType) {
            case MESSAGE:
                level = Level.INFO;
                break;
            case WARNING:
                level = Level.WARNING;
                break;
            case ERROR:
                level = Level.SEVERE;
                break; 
        }

        logger.log(level, message);
        System.out.println(super.GetDataTime());
    }

}