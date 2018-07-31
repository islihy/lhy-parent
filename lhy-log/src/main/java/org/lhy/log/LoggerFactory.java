package org.lhy.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/30 下午6:58
 */
public class LoggerFactory implements LoggerBuilder{
    private LoggerFactory() {
    }

    private static class SingletonHolder {
        private static final LoggerFactory instance = new LoggerFactory();
    }

    public static final LoggerFactory getInstance() {
        return SingletonHolder.instance;
    }

    private static ThreadLocal<Map<String, Logger>> loggers = new ThreadLocal<Map<String, Logger>>() {
        @Override
        public Map<String, Logger> initialValue() {
            return new HashMap<String, Logger>();
        }
    };

    @Override
    public Logger getRunLogger(Class<?> T) {
        return getLogger(T, LogType.RUNTIME);
    }

    @Override
    public Logger getConLogger(Class<?> T) {
        return getLogger(T, LogType.CONSOLE);
    }

    private Logger getLogger(Class<?> T, LogType logType) {
        String tagName = T.getName() + "@" + logType;
        Logger logger = loggers.get().get(tagName);
        if (logger == null) {
            logger = new LoggerInstance(T.getName(), new LogWriterImpl(logType));
            loggers.get().put(tagName, logger);
        }
        return logger;
    }

    private class LoggerInstance implements Logger {
        private LogWriter logWriter;
        private String module;
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        public LoggerInstance(String module, LogWriter logWriter) {
            this.module = module;
            this.logWriter = logWriter;
        }

        @Override
        public void debug(String msg) {
            log(msg, "DEBUG");
        }

        @Override
        public void info(String msg) {
            log(msg, "INFO");
        }

        @Override
        public void warn(String msg) {
            log(msg, "WARN");
        }

        @Override
        public void error(String msg) {
            log(msg, "ERROR");
        }

        @Override
        public void fatal(String msg) {
            log(msg, "FATAL");
        }

        private void log(String msg, String logLevel) {
            String logText = String.format("%s-[%s] [%s] %s\r\n", sdf.format(new Date()), module, logLevel, msg);
            logWriter.log(logText);
        }

        @Override
        public void debug(String format, Object... args) {
            String logText = String.format(format, args);
            debug(logText);
        }

        @Override
        public void info(String format, Object... args) {
            String logText = String.format(format, args);
            info(logText);
        }

        @Override
        public void warn(String format, Object... args) {
            String logText = String.format(format, args);
            warn(logText);
        }

        @Override
        public void error(String format, Object... args) {
            String logText = String.format(format, args);
            error(logText);
        }

        @Override
        public void fatal(String format, Object... args) {
            String logText = String.format(format, args);
            fatal(logText);
        }
    }
}
