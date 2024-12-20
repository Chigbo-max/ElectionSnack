import unittest
from votingsystem.src.electoralbody import ElectoralBody


class TestElectoralBody(unittest.TestCase):
    def test_that_electoral_body_registers_candidate(self):
        electoral_body = ElectoralBody()
        candidate1 = electoral_body.register_candidate("ade", "wale", "president")
        candidate2 = electoral_body.register_candidate("ade", "wale", "president")
        self.assertEqual(1, candidate1.get_id())


    def test_that_electoral_body_registers_voter(self):
        electoral_body = ElectoralBody()
        voter1 = electoral_body.register_voter("ade", "wale", "1234")
        voter2 = electoral_body.register_voter("ade", "wale", "1234")
        self.assertEqual(2, electoral_body.get_number_of_registered_voters())





