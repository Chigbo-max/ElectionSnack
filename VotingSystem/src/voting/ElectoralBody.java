package voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElectoralBody {
    public List<Candidate> candidateList = new ArrayList<Candidate>();
    private List<Voter> voterList = new ArrayList<>();
    public List<Long> voterIdList = new ArrayList<>();

    private int numberOfCandidates;
    private int numberOfVoters;
    private String position;

    public ElectoralBody(String position) {
        this.position = position;
    }

    public ElectoralBody() {

    }

    public Candidate registerCandidate(String firstName, String lastName, String position) {
       numberOfCandidates++;
       String name = firstName + " " + lastName;
       Candidate candidate = new Candidate(name, position, numberOfCandidates);
       candidateList.add(candidate);
       return candidate;
    }

    public Voter registerVoter(String firstName, String lastName, String password){
        numberOfVoters++;
        long voterId = generateVoterId();
        voterIdList.add(voterId);
        String name = firstName + " " + lastName;
        Voter voter = new Voter(name, password, voterId);
        voterList.add(voter);
        return voter;
    }


    public int getCandidateId() {
        return numberOfCandidates;
    }


    public int getNumberOfRegisteredVoters() {
        return numberOfVoters;
    }

    public long generateVoterId(){
        Random rand = new Random();
        long voterId = Math.abs(rand.nextLong() % 2_147_483_647);
        return voterId;
    }

    public long getVoterId(){
        return voterIdList.get(voterIdList.size()-1);
    }

    public String getPosition(){
        return position;
    }

    public String findCandidateNameByPosition(String position){
        for (Candidate candidate : candidateList) {
            if (candidate.getPosition().equals(position)) {
                return candidate.getName();
            }
        }
        throw new IllegalArgumentException("The position does not exist");
    }

    public String getCandidateName(int candidateId){
        for (Candidate candidate : candidateList) {
            if (candidate.getId() == candidateId) {
                return candidate.getName();
            }
        }
        throw new IllegalArgumentException("The candidate does not exist");
    }

    public List <Integer> getRegisteredCandidateIds() {
        List<Integer> CandidateIdList = new ArrayList<>();
        for (Candidate candidate : candidateList) {
            CandidateIdList.add(candidate.getId());
        }
        return CandidateIdList;
    }



}
