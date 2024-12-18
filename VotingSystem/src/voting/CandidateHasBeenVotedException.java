package voting;

public class CandidateHasBeenVotedException extends RuntimeException {
    public CandidateHasBeenVotedException(String message) {
        super(message);
    }
}
