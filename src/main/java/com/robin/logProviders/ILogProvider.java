package com.robin.logProviders;

import com.robin.mylogger.LogMessageType;

public interface ILogProvider {

    void Register(String message, LogMessageType logMessageType);
}