package voting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoterTest {

    @Test
    public void testThatCandidateIdIsCorrect() {
        ElectoralBody electoralBody = new ElectoralBody();
        Voter voter1 = electoralBody.registerVoter("Ade", "Wale", "correctPassword");
        assertEquals(electoralBody.getVoterId(), voter1.getVoterId());
        Voter voter2 = electoralBody.registerVoter("Ade", "Wale", "correctPassword");
        assertEquals(electoralBody.getVoterId(), voter2.getVoterId());
        Voter voter3 = electoralBody.registerVoter("Ade", "Wale", "correctPassword");
        assertEquals(electoralBody.getVoterId(), voter3.getVoterId());
    }

    @Test
    public void testThatUpdatePasswordMethodThrowsExceptionForIncorrectPassword() {
        Voter voter1 = new Voter("Ali", "correctPassword", 0000000000);
        String newPassword = "newPassword";
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {voter1.updatePassword("IncorrectPassword", newPassword);});
        assertEquals(illegalArgumentException.getMessage(), "Invalid credentials");
    }

    @Test
    public void testThatExceptionIsThrownIfVoterTriesToVoterForACandidateMoreThanOnce() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Candidate candidate2 = electoralBody.registerCandidate("ade", "wale", "President");
        Candidate candidate3 = electoralBody.registerCandidate("ade", "wale", "President");
        Voter voter = electoralBody.registerVoter("ade", "wale", "1234");
        voter.castVote(electoralBody.getVoterId(), 1);
        CandidateHasBeenVotedException candidateHasBeenVotedException = assertThrows(CandidateHasBeenVotedException.class, () -> {voter.castVote(electoralBody.getVoterId(), 1);});
        assertEquals(candidateHasBeenVotedException.getMessage(), "You have voted already voted for this candidate");

    }

    @Test
    public void testThatExceptionIsThrownIfVoterIdDoesNotMatch() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Voter voter = electoralBody.registerVoter("ade", "wale", "1234");

        VoterNotRegisteredException voterNotRegisteredException = assertThrows(VoterNotRegisteredException.class, () -> {voter.castVote(2, 1);});
        assertEquals(voterNotRegisteredException.getMessage(), "Voter with id 2 is not registered");

    }
    @Test
    public void testThatExceptionIsThrownIfCandidateIdDoesNotMatch() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("ade", "wale", "President");
        Voter voter = electoralBody.registerVoter("ade", "wale", "1234");

        CandidateNotRegisteredException candidateNotRegisteredException = assertThrows(CandidateNotRegisteredException.class, () -> {voter.validateCandidate(-1);});
        assertEquals(candidateNotRegisteredException.getMessage(), "Candidate with id -1 is not registered");
    }



}