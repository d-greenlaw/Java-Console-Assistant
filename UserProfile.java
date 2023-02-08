public class UserProfile {
    String username;
    String password;
    String email;
    int phone;
    UserProfile(String username, String password, String email, Integer phone){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    String getUsername(){
        return this.username;
    }
    String getPassword(){
        return this.password;
    }
    String getEmail(){
        return this.email;
    }
    Integer getPhone(){
        return this.phone;
    }
    String getProfileInfo(){
        return "Your Username is: \n"
        + this.username 
        + " Your Password is:\n "
        + this.password
        + " Your Email is: \n"
        + this.email
        + " Your Phone is: \n"
        + this.phone; 
    }
    // TODO: Let the user update their profile
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = Integer.parseInt(phone);
    }
}
