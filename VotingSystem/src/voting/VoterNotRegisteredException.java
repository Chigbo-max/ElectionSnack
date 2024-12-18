package voting;

public class VoterNotRegisteredException extends RuntimeException{
    public VoterNotRegisteredException(String message){
        super(message);
    }
}
