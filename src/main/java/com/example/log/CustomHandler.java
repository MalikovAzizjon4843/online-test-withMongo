package com.example.log;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class CustomHandler extends StreamHandler {
    @Override
    public synchronized void publish(LogRecord record) {
        super.publish(record);
    }

    @Override
    public void flush() {
        super.flush();
    }


    @Override
    public void close() throws SecurityException {
        super.close();
    }
}