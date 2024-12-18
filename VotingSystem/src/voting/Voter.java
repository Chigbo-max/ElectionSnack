package voting;

public class Voter {

    private String name;
    private String password;
    private long id;

    public Voter(String name, String password, long voterId) {
        this.name = name;
        this.password = password;
        this.id = voterId;
    }
    public Voter(){

    }


    public long getVoterId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(password))this.password = newPassword;
        else throw new IllegalArgumentException("Invalid credentials");
    }
}
