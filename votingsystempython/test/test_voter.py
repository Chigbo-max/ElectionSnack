import unittest

from electoralbody import ElectoralBody

class VoterTestCase(unittest.TestCase):
    def test_that_password_is_updated(self):
        electoral_body = ElectoralBody()
        voter1 = electoral_body.register_voter("ade", "wale", "1234")
        self.assertEqual(voter1.update_password("1234", "0000"), "0000")

    def test_that_exceptions_are_raised_for_invalid_new_password(self):
        electoral_body = ElectoralBody()
        voter1 = electoral_body.register_voter("ade", "wale", "1234")
        self.assertRaises(Exception, voter1.update_password, "1111", "0000")

    def test_that_exceptions_are_raised_if_voter_has_voted_for_a_specific_candidate(self):
        electoral_body = ElectoralBody()
        voter1 = electoral_body.register_voter("ade", "wale", "1234")
        candidate1 = electoral_body.register_candidate("bola", "bolanle", "president")
        voter1.cast_vote(candidate1.get_id(),voter1.get_id())
        self.assertRaises(Exception, voter1.cast_vote, candidate1.get_id(),voter1.get_id())

    def test_that_exceptions_are_raised_if_candidate_id_is_invalid(self):
        electoral_body = ElectoralBody()
        voter1 = electoral_body.register_voter("ade", "wale", "1234")
        candidate1 = electoral_body.register_candidate("bola", "bolanle", "president")
        voter1.cast_vote(candidate1.get_id(),voter1.get_id())
        self.assertRaises(RuntimeError, voter1.cast_vote, 2,voter1.get_id())

