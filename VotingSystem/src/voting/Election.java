package voting;

import java.util.ArrayList;
import java.util.List;

public class Election {

    private List<Long>votedVotersList = new ArrayList<>();
    public List<Vote>votes = new ArrayList<>();
    private ElectoralBody electoralBody;


    public Election(ElectoralBody electoralBody) {
        this.electoralBody = electoralBody;
    }

    public Vote castVote(long voterId, int candidateId){

        validateVoter(voterId);
        validateCandidate(candidateId);

        if(hasVotedASpecificCandidate(voterId, candidateId)){
            throw new CandidateHasBeenVotedException("You have voted already voted for this candidate");
        }

        votedVotersList.add(voterId);
            Vote vote = new Vote(voterId, candidateId);
            votes.add(vote);

            return vote;
    }



    public long getRecentVoterId(){
        return votedVotersList.get(votedVotersList.size()-1);
    }


    public boolean hasVotedASpecificCandidate(long voterId, int candidateId) {
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
        if(electoralBody.getRegisteredCandidateIds().contains(candidateId)){
            return;
        }
        throw new CandidateNotRegisteredException("Candidate with id " + candidateId + " is not registered");
    }




}
