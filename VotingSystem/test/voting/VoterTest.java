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


}