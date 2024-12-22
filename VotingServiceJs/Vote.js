class Vote {
    #candidateId;
    #voterId;

    constructor(candidateId, voterId) {
        this.#voterId = voterId;
        this.#candidateId = candidateId;
    }
}

module.exports = Vote;