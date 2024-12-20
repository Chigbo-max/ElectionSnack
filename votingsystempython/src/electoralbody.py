import random
from candidate import Candidate

class ElectoralBody:

    def __init__(self):
        self.candidate_list = []
        self.voter_list = []
        self.candidate_id_list = []
        self.voter_id_list = []

    def register_candidate(self, first_name, last_name, position):
        __candidate_id = len(self.candidate_list) + 1
        self.candidate_id_list.append(__candidate_id)

        name = first_name + " " + last_name
        new_candidate = Candidate(name, position,__candidate_id)
        self.candidate_list.append(new_candidate)
        return new_candidate

    def register_voter(self, first_name, last_name, password):
        from voter import Voter
        voter_id = self.generate_voter_id()
        self.voter_id_list.append(voter_id)

        name = first_name + " " + last_name
        new_voter = Voter(name, voter_id, password)
        self.voter_list.append(new_voter)
        return new_voter


    def generate_voter_id(self):
        voter_id = str(random.randrange(1_200_000_000, 1_299_999_999))
        return voter_id

    def get_number_of_registered_voters(self):
        return len(self.voter_list)

    def get_candidate_name(self, candidate_id):
        for candidate in self.candidate_list:
            if str(candidate.get_id()) == str(candidate_id):
                return candidate.get_name()

    def get_candidate_id_list(self):
        return self.candidate_id_list








