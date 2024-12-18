package voting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectionTest {

    @Test
    public void testVotesAreAddedToVotersList() {
        ElectoralBody electoralBody = new ElectoralBody();
        Election election = new Election(electoralBody);
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        election.castVote(000000000, 1);
        assertEquals(election.getRecentVoterId(), 000000000);
        assertEquals(candidate1.getId(), 1);

    }

    @Test
    public void testThatExceptionIsThrownIfVoterTriesToVoterForACandidateMoreThanOnce() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Candidate candidate2 = electoralBody.registerCandidate("ade", "wale", "President");
        Candidate candidate3 = electoralBody.registerCandidate("ade", "wale", "President");
        Election election = new Election(electoralBody);
        election.castVote(000000000, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {election.castVote(000000000, 1);});
        assertEquals(illegalArgumentException.getMessage(), "You have voted already voted for this candidate");

    }

    @Test
    public void testThatExceptionIsThrownIfVoterIdDoesNotMatch() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Election election = new Election(electoralBody);
        VoterNotRegisteredException voterNotRegisteredException = assertThrows(VoterNotRegisteredException.class, () -> {election.castVote(2, 1);});
        assertEquals(voterNotRegisteredException.getMessage(), "Voter with id 2 is not registered");


    }


}