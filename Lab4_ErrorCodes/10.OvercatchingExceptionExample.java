import java.util.logging.Logger;

class OvercatchingExceptionExample {
    private static final Logger logger = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            logger.severe("Array index out of bounds: " + ex.getMessage());
        } catch (Exception ex) {
            logger.warning("Unexpected exception: " + ex.getClass().getSimpleName());
        }
    }
}
