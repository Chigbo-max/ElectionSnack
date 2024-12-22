const Candidate = require(`./Candidate.js`);
const Voter = require(`./Voter.js`);

    class ElectoralBody{

    #candidateIdList = [];
    #candidates = [];
        #voters = [];
    #numberOfCandidates;

    constructor(){
        this.#numberOfCandidates = 0;
    }

    registerCandidate(firstName, lastName, position){
        let candidate_id = this.#numberOfCandidates+=1;
        this.#candidateIdList.push(candidate_id);
        let name = "firstName"+ " " + "lastName";
        let newCandidate = new Candidate(name, position, candidate_id);
        this.#candidates.push(newCandidate);
        return newCandidate;
    }

    registerVoter(firstName, lastName, password){
        let voterId = this.generateVoterId();
        let name = "firstName"+" " + "lastName";
        let newVoter = new Voter(name, password, voterId);
        this.#voters.push(newVoter);
        return newVoter;
    }

    generateVoterId(){
        const minCeiled = Math.ceil(1_200_000);
        const maxFloored = Math.floor(1_999_999);
        return Math.floor(Math.random() * (maxFloored - minCeiled + 1) + minCeiled);
    }




}

module.exports = ElectoralBody;