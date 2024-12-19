package voting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectionTest {


    @Test
    public void testThatExceptionIsThrownIfVoterTriesToVoterForACandidateMoreThanOnce() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Candidate candidate2 = electoralBody.registerCandidate("ade", "wale", "President");
        Candidate candidate3 = electoralBody.registerCandidate("ade", "wale", "President");
        Voter voter = electoralBody.registerVoter("ade", "wale", "1234");
        Election election = new Election(electoralBody);
        election.castVote(electoralBody.getVoterId(), 1);
        CandidateHasBeenVotedException candidateHasBeenVotedException = assertThrows(CandidateHasBeenVotedException.class, () -> {election.castVote(electoralBody.getVoterId(), 1);});
        assertEquals(candidateHasBeenVotedException.getMessage(), "You have voted already voted for this candidate");

    }

    @Test
    public void testThatExceptionIsThrownIfVoterIdDoesNotMatch() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Election election = new Election(electoralBody);
        VoterNotRegisteredException voterNotRegisteredException = assertThrows(VoterNotRegisteredException.class, () -> {election.castVote(2, 1);});
        assertEquals(voterNotRegisteredException.getMessage(), "Voter with id 2 is not registered");

    }

    @Test
    public void testThatExceptionIsThrownIfCandidateIdDoesNotMatch() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Election election = new Election(electoralBody);
        CandidateNotRegisteredException candidateNotRegisteredException = assertThrows(CandidateNotRegisteredException.class, () -> {election.validateCandidate(0);});
        assertEquals(candidateNotRegisteredException.getMessage(), "Candidate with id 0 is not registered");
    }




}