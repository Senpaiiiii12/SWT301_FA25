// Đổi từ interface sang class để chứa constant
final class Constants {
    private Constants() {} // ngăn tạo đối tượng
    public static final int MAX_USERS = 100;
}

class InterfaceFieldModificationExample {
    public static void main(String[] args) {
        // Constants.MAX_USERS = 200; // Compile-time error
    }
}
