class Vote:
    def __init__(self, candidate_id, voter_id):
        self.candidate_id = candidate_id
        self.voter_id = voter_id

    def get_candidate_id(self):
        return self.candidate_id

    def get_voter_id(self):
        return self.voter_id

    def __str__(self):
        return f'Voter ID: {self.get_voter_id()} -Candidate ID: {self.get_candidate_id()}'