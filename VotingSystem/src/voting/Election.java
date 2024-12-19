package voting;

import java.util.ArrayList;
import java.util.List;

public class Election {

    public List<Vote>votes = new ArrayList<>();
    private ElectoralBody electoralBody;


    public Election(ElectoralBody electoralBody) {
        this.electoralBody = electoralBody;
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
        if(electoralBody.voterIdList.contains(voterId)){
            return;
        }
        throw new VoterNotRegisteredException("Voter with id " + voterId + " is not registered");
    }

    public void validateCandidate(int candidateId) {
        if(electoralBody.candidateIdList.contains(candidateId)){
            return;
        }
        throw new CandidateNotRegisteredException("Candidate with id " + candidateId + " is not registered");
    }




}
