import java.util.logging.Logger;

class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());

    public String name;
    public int age;

    public void display() {
        logger.info("Name: " + name + ", Age: " + age);
    }
}
