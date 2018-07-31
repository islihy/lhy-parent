package org.lhy.log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/30 下午6:52
 */
public class LogWriterImpl implements LogWriter {

    private Writer logWriter;

    public LogWriterImpl(LogType logType) {
        try {
            switch (logType) {
                case RUNTIME:
                    logWriter = new OutputStreamWriter(new FileOutputStream("D:\\log\\test\\runtime.log", true));
                    break;
                case CONSOLE:
                    logWriter = new OutputStreamWriter(System.out);
                    break;
                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void log(String log) {
        try
        {
            logWriter.write(log);
            logWriter.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
