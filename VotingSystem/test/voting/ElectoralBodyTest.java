package voting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectoralBodyTest {

    @Test
    public void testThatCandidateIsRegistered(){
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate1 = electoralBody.registerCandidate("Bola","Brown","President");
        Candidate candidate2 = electoralBody.registerCandidate("Bola","Brown","President");
        assertEquals(2, electoralBody.getCandidateId());
    }

    @Test
    public void testThatVoterIsRegistered() {
        ElectoralBody electoralBody = new ElectoralBody();
        Voter voter1 = electoralBody.registerVoter("Ade", "Wale", "correctPassword");
        Voter voter2 = electoralBody.registerVoter("Ade", "Wale", "correctPassword");
        assertEquals(2, electoralBody.getNumberOfRegisteredVoters());
    }



}