from vote import Vote
from electoralbody import ElectoralBody


class Voter:
    def __init__(self, name, id, password, electoral_body)->None:
        self.__name = name
        self.__id = id
        self.__password = password
        self.votes = []
        self.electoral_body = electoral_body


    def get_id(self)->int:
        return self.__id

    def update_password(self, old_password, new_password):
        if old_password == self.__password:
            self.__password = new_password
            return self.__password
        else:
            raise Exception("Password doesn't match")

    def cast_vote(self, candidate_id, voter_id):
        self.validate_voter(voter_id)
        self.validate_candidate_id(candidate_id)
        self.has_voted_a_specific_candidate(candidate_id, voter_id)

        vote = Vote(candidate_id, voter_id)
        self.votes.append(vote)
        return vote

    def has_voted_a_specific_candidate(self, candidate_id, voter_id):
        for vote in self.votes:
            if vote.candidate_id == candidate_id and vote.voter_id == voter_id:
                raise Exception("Can't vote twice")

    def validate_candidate_id(self, candidate_id):
        if int(candidate_id) not in self.electoral_body.get_candidate_id_list():
            raise Exception("Candidate id is not valid")

    def validate_voter(self, voter_id):
        if voter_id not in self.electoral_body.get_voter_id_list():
            raise Exception("Voter id is not valid")











