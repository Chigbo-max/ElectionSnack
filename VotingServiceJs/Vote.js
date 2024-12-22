class Vote {
    #candidateId;
    #voterId;

    constructor(candidateId, voterId) {
        this.#voterId = voterId;
        this.#candidateId = candidateId;
    }

    get voterId() {
        return this.#voterId;
    }

    get candidateId() {
        return this.#candidateId;
    }
}



module.exports = Vote;