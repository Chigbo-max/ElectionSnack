package voting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {

    @Test
    public void testThatCandidateIdIsCorrect() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate = electoralBody.registerCandidate("Bola", "Bola", "President");
        assertEquals(electoralBody.getCandidateId(), candidate.getId());
        Candidate candidate2 = electoralBody.registerCandidate("Bola", "Bola", "President");
        assertEquals(electoralBody.getCandidateId(), candidate2.getId());
    }

    @Test
    public void testThatCandidateNameIsCorrect() {
        ElectoralBody electoralBody = new ElectoralBody();
        Candidate candidate = electoralBody.registerCandidate("Bola", "Bola", "President");
        assertEquals(candidate.getName(), electoralBody.findCandidateNameByPosition("President"));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {electoralBody.findCandidateNameByPosition("Governor");});
        assertEquals(illegalArgumentException.getMessage(),"The position does not exist");
    }

}