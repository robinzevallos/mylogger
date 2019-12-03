package com.robin.logProviders;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.*;

import com.robin.mylogger.LogMessageType;

public class TextFileProvider extends LogProvider implements ILogProvider {

    Logger logger;

    public TextFileProvider(Map dbParams) throws IOException {
        File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
        
		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		
		FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
        
        logger.addHandler(fh);	
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
        logger.log(Level.INFO, super.GetDataTime());
    }
    
}