const Vote = require('./Vote');
const ElectoralBody = require('./ElectoralBody.js');

class Voter{
    #name;
    #password;
    #id;
    #votes = [];

    constructor(name,password,id, electoralBody){
        this.#name = name;
        this.#password = password;
        this.#id = id;
        this.electoralBody = electoralBody;
    }
    get name(){
        return this.#name;
    }

    get id(){
        return this.#id;
    }

    castVote(candidateId, voterId){
        this.validateVoter(voterId);
        this.validateCandidate(candidateId);
        this.hasVotedAlreadyForASpecificCandidate(candidateId, voterId);
        let newVote = new Vote(candidateId, voterId);
        this.#votes.push(newVote);
        return newVote;
    }
    hasVotedAlreadyForASpecificCandidate(candidateId, voterId){
        for(let vote of this.#votes){
            if(vote.voterId === voterId && vote.candidateId === candidateId){
                throw new Error("Can't vote twice");
            }
        }
        return false;
    }

    validateCandidate(candidateId){
        if(!this.electoralBody.candidateIdList.includes(candidateId)){
            throw new Error("Candidate not registered");
        }
        return false;
    }

    validateVoter(voterId){
        if(!this.electoralBody.voterIdList.includes(voterId)){
            throw new Error("Voter not registered");
        }
        return false;
    }

}
module.exports = Voter;