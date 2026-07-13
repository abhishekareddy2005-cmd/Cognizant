public class Logger {
    // 1. Private static instance
    private static Logger instance;

    // 2. Private constructor prevents instantiation from other classes
    private Logger() {
        System.out.println("Logger Initialized.");
    }

    // 3. Public static method to provide global access
    public static Logger getInstance() {
        if (instance == null) {
            // Using synchronized to ensure thread safety
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
