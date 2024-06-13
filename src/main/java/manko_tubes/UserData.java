package manko_tubes;
public class UserData {
    private int userID;
    private int password;
    public boolean isLoggedIn;
    
    public UserData(int uid, int pw){
        this.userID = uid;
        this.password = pw;
    }
    
    public void login() throws LoginFailed{
        assert String.valueOf(userID).length()==4 && String.valueOf(password).length() == 4:
                "User ID and password  must be 4 digits long";
        if(password + userID == 10000){
            isLoggedIn = true;
        }else{
            throw new LoginFailed("Login USER "+ userID+" gagal, telah gagal login"
            + LoginFailed.getFailedCounter(userID)+ " kali", userID);
        }
    }
}
