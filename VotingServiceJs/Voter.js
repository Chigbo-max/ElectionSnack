const Vote = require('voter');

    class Voter{
    #name;
    #password;
    #id;
    #votes = [];

    constructor(name,password,id){
        this.#name = name;
        this.#password = password;
        this.#id = id;
    }
    get name(){
        return this.#name;
    }

    get id(){
        return this.#id;
    }

    castVote(candidateId, voterId){
        let newVote = new Vote(candidateId, voterId);
        this.#votes.push(newVote);
        return newVote;
    }


}
module.exports = Voter;