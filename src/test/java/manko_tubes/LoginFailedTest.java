/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package manko_tubes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author herui
 */
public class LoginFailedTest {

    @BeforeEach
    public void setUp() {
        // Reset failedCount untuk memastikan setiap tes dimulai dari awal
        LoginFailed.failedCount.clear();
    }

    @Test
    public void testLoginFailedInitialization() {
        // Menguji inisialisasi objek LoginFailed dan apakah userID disimpan dengan benar
        LoginFailed loginFailed = new LoginFailed("Test Message", 1234);
        assertEquals(1234, loginFailed.getUserID());
        assertEquals("Test Message", loginFailed.getMessage());
    }

    @Test
    public void testFailedCounterIncrement() {
        // Menguji apakah counter gagal login bertambah dengan benar
        new LoginFailed("Test Message 1", 1234);
        assertEquals(1, LoginFailed.getFailedCounter(1234));

        new LoginFailed("Test Message 2", 1234);
        assertEquals(2, LoginFailed.getFailedCounter(1234));
    }

    @Test
    public void testFailedCounterDifferentUsers() {
        // Menguji apakah counter gagal login berfungsi untuk beberapa user yang berbeda
        new LoginFailed("Test Message 1", 1234);
        new LoginFailed("Test Message 2", 5678);
        assertEquals(1, LoginFailed.getFailedCounter(1234));
        assertEquals(1, LoginFailed.getFailedCounter(5678));

        new LoginFailed("Test Message 3", 1234);
        assertEquals(2, LoginFailed.getFailedCounter(1234));
        assertEquals(1, LoginFailed.getFailedCounter(5678));
    }

    @Test
    public void testFailedCounterNonExistentUser() {
        // Menguji apakah counter gagal login untuk user yang tidak ada mengembalikan 0
        assertEquals(0, LoginFailed.getFailedCounter(9999));
    }
}   
}
