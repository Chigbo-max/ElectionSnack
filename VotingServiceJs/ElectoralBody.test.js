const ElectoralBody = require("./ElectoralBody");

test("test that electoral body registers candidate", () => {
    let firstName = "williams";
    let lastName = "williams";
    let position = "President";
    let electoralBody = new ElectoralBody();
    let candidate1 = electoralBody.registerCandidate(firstName, lastName, position);
    let result = 1;
    expect(candidate1.id).toBe(result);
});

test("test that electoral body registers voters", () => {
    let firstName = "williams";
    let lastName = "williams";
    let electoralBody = new ElectoralBody();
    let voter1 = electoralBody.registerVoter(firstName, lastName, "1234");
    let result = voter1.id;
    expect(voter1.id).toBe(result);
});