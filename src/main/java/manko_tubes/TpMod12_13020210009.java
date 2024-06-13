package manko_tubes;

import java.util.Scanner;
public class TpMod12_13020210009 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isLoggedIn = false;
        UserData u1 = new UserData(0, 0);
        
        while(!isLoggedIn){
            System.out.println("Masukan UserID: ");
            int userID = input.nextInt();
            System.out.println("Masukan Password: ");
            int password = input.nextInt();
            
            try{
                u1 = new UserData(userID,password);
                    u1.login();
                    isLoggedIn = u1.isLoggedIn;
                    System.out.println("Login Berhasil!!!");
            }catch (LoginFailed e){
                System.out.printf("Login user %d gagal, telah gagal login %d kali\n", e.getUserID(), e.getFailedCounter(e.getUserID()));
            }
        }
    }
}