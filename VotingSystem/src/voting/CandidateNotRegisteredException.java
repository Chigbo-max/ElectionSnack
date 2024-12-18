package voting;

public class CandidateNotRegisteredException extends RuntimeException {
    public CandidateNotRegisteredException(String message) {
        super(message);
    }
}
