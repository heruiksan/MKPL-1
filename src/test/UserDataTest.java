package manko_tubes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataTest {

    private UserData userData;

    @BeforeEach
    public void setUp() {
        // Menginisialisasi objek UserData sebelum setiap tes
        userData = new UserData(1234, 8766); // Sesuaikan dengan kombinasi userID dan password yang valid
    }

    @Test
    public void testLoginSuccess() {
        // Menguji login sukses dengan userID dan password yang benar
        assertDoesNotThrow(() -> userData.login());
        assertTrue(userData.isLoggedIn);
    }

    @Test
    public void testLoginFailure() {
        // Menguji login gagal dengan userID dan password yang salah
        UserData wrongUserData = new UserData(1234, 1234);
        LoginFailed exception = assertThrows(LoginFailed.class, () -> wrongUserData.login());
        assertEquals("Login USER 1234 gagal, telah gagal login" + LoginFailed.getFailedCounter(1234) + " kali", exception.getMessage());
        assertFalse(wrongUserData.isLoggedIn);
    }

    @Test
    public void testInvalidUserIdOrPassword() {
        // Menguji userID atau password yang tidak valid (bukan 4 digit)
        UserData invalidUserData = new UserData(123, 8766); // userID tidak valid
        Exception exception = assertThrows(AssertionError.class, () -> invalidUserData.login());
        assertTrue(exception.getMessage().contains("User ID and password  must be 4 digits long"));

        invalidUserData = new UserData(1234, 876); // password tidak valid
        exception = assertThrows(AssertionError.class, () -> invalidUserData.login());
        assertTrue(exception.getMessage().contains("User ID and password  must be 4 digits long"));
    }

    @Test
    public void testFailedCounter() {
        // Menguji penghitung kegagalan login
        UserData userData = new UserData(1234, 1234); // Password salah untuk login
        for (int i = 0; i < 3; i++) {
            try {
                userData.login();
            } catch (LoginFailed e) {
                // Ignored
            }
        }
        assertEquals(3, LoginFailed.getFailedCounter(1234));
    }
}
