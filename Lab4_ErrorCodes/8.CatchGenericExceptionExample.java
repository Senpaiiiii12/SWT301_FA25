import java.util.logging.Logger;

class CatchGenericExceptionExample {
    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            String s = null;
            // Gọi method có thể gây NullPointerException
            logger.info(String.valueOf(s.length()));
        } catch (NullPointerException ex) { // bắt cụ thể
            logger.severe("Null value encountered: " + ex.getMessage());
        }
    }
}
