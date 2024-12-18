package voting;

public class Vote {
    private long voterId;
    private int candidateId;

    public Vote(long voterId, int candidateId){
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public long getVoterId() {
        return voterId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    @Override
    public String toString() {
        return "Registration number:" + voterId + " ,  Candidate Id: " + candidateId ;

    }

}
