package voting;

import java.util.ArrayList;
import java.util.List;

public class Voter {

    private String name;
    private String password;
    private long id;
    public List<Vote> votes = new ArrayList<>();



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


    public void updatePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(password))this.password = newPassword;
        else throw new IllegalArgumentException("Invalid credentials");
    }

    public Vote castVote(long voterId, int candidateId){

        validateVoter(voterId);
        validateCandidate(candidateId);
        validateSpecificCandidateVote(voterId, candidateId);

        Vote vote = new Vote(voterId, candidateId);
        votes.add(vote);

        return vote;
    }

    private void validateSpecificCandidateVote(long voterId, int candidateId) {
        if(hasVotedASpecificCandidate(voterId, candidateId)){
            throw new CandidateHasBeenVotedException("You have voted already voted for this candidate");
        }
    }


    private boolean hasVotedASpecificCandidate(long voterId, int candidateId) {
        for (Vote vote : votes) {
            if(vote.getCandidateId() == candidateId && vote.getVoterId() == voterId){
                return true;
            }
        }
        return false;
    }

    public void validateVoter(long voterId) {
        if(ElectoralBody.voterIdList.contains(voterId)){
            return;
        }
        throw new VoterNotRegisteredException("Voter with id " + voterId + " is not registered");
    }


    public void validateCandidate(int candidateId) {
        if(ElectoralBody.candidateIdList.contains(candidateId)){
            return;
        }
        throw new CandidateNotRegisteredException("Candidate with id " + candidateId + " is not registered");
    }

}
