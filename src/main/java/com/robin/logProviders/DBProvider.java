package com.robin.logProviders;

import java.sql.*;
import java.util.Map;
import java.util.Properties;

import com.robin.mylogger.LogMessageType;

public class DBProvider extends LogProvider implements ILogProvider {

    Statement statement;

    public DBProvider(Map dbParams) throws SQLException {
        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));

        connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
                + ":" + dbParams.get("portNumber") + "/", connectionProps);

        statement = connection.createStatement();
    }

    @Override
    public void Register(String message, LogMessageType logMessageType) {

        String logCode = String.valueOf(logMessageType.ordinal()) + 1;

        try {
            statement.executeUpdate(
                "insert into Log_Values('" + 
                    message + "', " + logCode + "', " + super.GetDataTime() + ")");
        } catch (Exception e) {
        }
    }
}