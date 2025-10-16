import java.util.logging.Logger;

class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());

    public static int getNumber() {
        int value = 42;
        logger.info("Returning value: " + value);
        return value;
    }

    public static void main(String[] args) {
        logger.info(String.valueOf(getNumber()));
    }
}
