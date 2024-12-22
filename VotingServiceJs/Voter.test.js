const ElectoralBody = require("./ElectoralBody");


test("test that exception is thrown if voter has voted for a specific candidate", () => {
    let electoralBody = new ElectoralBody();
    let candidate1 = electoralBody.registerCandidate("willy", "willy", "President");
    let voter1 = electoralBody.registerVoter("oga", "oga", "1234");
    voter1.castVote(candidate1.id,voter1.id);
    let vote =()=> voter1.castVote(candidate1.id,voter1.id);
    let errorMessage = "Can't vote twice";
    expect(vote).toThrowError(errorMessage);
})

test("test that exception is thrown if candidate is not registered", () => {
    let electoralBody = new ElectoralBody();
    let candidate1 =  electoralBody.registerCandidate("willy", "willy", "President");
    let voter1 = electoralBody.registerVoter("oga", "oga", "1234");
    let vote =()=>voter1.castVote(2,voter1.id);
    let errorMessage = "Candidate not registered";
    expect(vote).toThrowError(errorMessage);

})

test("test that exception is thrown if voter is not registered",()=>{
    let electoralBody = new ElectoralBody();
    let candidate1 = electoralBody.registerCandidate("willy", "willy", "President");
    let voter1 = electoralBody.registerVoter("oga", "oga", "1234");
    let vote =()=>voter1.castVote(candidate1.id,1);
    let errorMessage = "Voter not registered";
    expect(vote).toThrowError(errorMessage);
})
