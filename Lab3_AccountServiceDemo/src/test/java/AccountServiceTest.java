package QuocThinh.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @ParameterizedTest(name = "Test {index} => {0}, {1}, {2} => expected={3}")
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    @DisplayName("Parameterized Test - Kiểm tra đăng ký tài khoản từ file CSV")
    void testRegisterAccountFromFile(String username, String password, String email, boolean expected) {
        boolean actual;
        try {
            actual = accountService.registerAccount(username, password, email);
        } catch (IllegalArgumentException e) {
            actual = false;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Email hợp lệ")
    void testValidEmail() {
        assertTrue(accountService.isValidEmail("user@mail.com"));
    }

    @Test
    @DisplayName("Email null hoặc rỗng -> ném exception")
    void testEmailNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> accountService.isValidEmail(null));
        assertThrows(IllegalArgumentException.class, () -> accountService.isValidEmail(""));
    }

    @Test
    @DisplayName("Password ngắn hơn hoặc bằng 6 ký tự -> ném exception")
    void testShortPassword() {
        assertThrows(IllegalArgumentException.class,
                () -> accountService.registerAccount("user1", "short", "user@mail.com"));
    }

    @Test
    @DisplayName("Đăng ký thành công khi dữ liệu hợp lệ")
    void testRegisterSuccess() {
        assertTrue(accountService.registerAccount("john", "password123", "john@mail.com"));
    }
}
