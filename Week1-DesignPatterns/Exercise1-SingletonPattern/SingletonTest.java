public class SingletonTest {
    public static void main(String[] args) {
        // Attempting to get the instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Success: Both references point to the same instance.");
        } else {
            System.out.println("Failure: Different instances were created.");
        }

        // Using the logger
        logger1.log("This is a test message.");
    }
}
