class Candidate:
    def __init__(self, name, position, candidate_id):
        self.name = name
        self.position = position
        self.candidate_id = candidate_id

    def get_id(self)->int:
        return self.candidate_id

    def get_name(self):
        return self.name

    def get_position(self):
        return self.position
