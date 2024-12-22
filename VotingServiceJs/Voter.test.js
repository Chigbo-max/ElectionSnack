const Voter = require("./Voter");
const ElectoralBody = require("./ElectoralBody");

test("test that exception is thrown if voter has voted for a specific candidate", () => {
    let electoralBody = new ElectoralBody();
    let candidate1 = electoralBody.registerCandidate("willy", "willy", "President")
    let voter1 = electoralBody.registerVoter("oga", "oga", "1234")
    let newVote = voter1.castVote(candidate1.id,voter1.id);
    let errorMessage = "Can't vote twice"
    expect(newVote).toThrowError(errorMessage);

})