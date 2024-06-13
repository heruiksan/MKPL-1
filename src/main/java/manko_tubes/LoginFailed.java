package manko_tubes;

public class LoginFailed extends Exception {
    private static int failedCounter = 0;
    private int userID;

    public LoginFailed(String message, int userID) {
        super(message);
        this.userID = userID;
        failedCounter++;
    }

    public static int getFailedCounter(int userID) {
        // Implementasi penghitungan kesalahan login per userID dapat bervariasi
        // Sebagai contoh sederhana, kita hanya menggunakan penghitung umum
        return failedCounter;
    }
}