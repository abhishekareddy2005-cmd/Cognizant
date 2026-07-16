public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger Initialised.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("log message: " + message);
    }
}
