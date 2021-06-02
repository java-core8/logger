package ru.tcreator;

import java.util.Date;

public class Logger implements LoggerInterface {
    private int count;
    private static Logger logger;

    private Logger(){}

    @Override
    public void log(String msg) {
        StringBuilder builder = new StringBuilder('[')
                .append(new Date())
                .append(" N")
                .append(++count)
                .append(']')
                .append(" ")
                .append(msg)
                .append("\n");
        System.out.print(builder.toString());
    }

    public static Logger getInstance() {
        if(logger == null) logger = new Logger();
        return logger;
    }
}
