from electoralbody import ElectoralBody
from candidate import Candidate
from voter import Voter

class VoterInterface:

    def __init__(self):
        self.voter = None
        self.electoral_body = ElectoralBody()
        self.voter_id = None
        self.voter = None


    def display_menu(self):
        self.__register_candidates()
        self.go_to_main_menu()

    def go_to_main_menu(self):
        menu = '''
        NATIONAL ELECTION
        1 -> Voters' registration
        2 -> Get your registration number
        3 -> View all candidates
        4 -> Cast vote
        5 -> View voted candidates
        6 -> Change password
        7 -> Exit
        '''
        print(menu)

        self.menu_input()

    def menu_input(self):
        try:
            choice = input("Select a number: ")
            match (choice[0]):
                case '1':
                    self.register_voter()
                case '2':
                    self.display_registration_number()
                case '3':
                    self.display_candidates()
                case '4':
                    self.cast_vote()
                case '5':
                    self.find_list_of_voted_candidates()
                case '6':
                    self.update_password()
                case '7':
                    self.exit()
                case _:
                    print("Invalid input try again")
                    self.go_to_main_menu()
        except ValueError:
            print("Invalid input try again")
        finally:
            self.go_to_main_menu()

    def register_voter(self):
        try:
            first_name = input("Enter first name: ")
            last_name = input("Enter last name: ")
            password = input("Enter password: ")
            self.voter = self.electoral_body.register_voter(first_name, last_name, password)
            self.voter_id = self.voter.get_id()
            print("Your voter's registration number is" + " " + self.voter_id)
        except Exception as e:
            print(e.message)
        finally:
            self.go_to_main_menu()

    def display_registration_number(self):
        print("Your voter's registration number is" + " " + self.voter_id)
        self.go_to_main_menu()


    def __select_candidate(self):
        for candidates in self.electoral_body.candidate_list:
            print(f"{candidates.get_id()}  -> {candidates.get_name()}  - {candidates.get_position()}")
        return input("Enter a candidate's number: ")

    def display_candidates(self):
        for candidates in self.electoral_body.candidate_list:
            print(f"{candidates.get_id()}  -> {candidates.get_name()}  - {candidates.get_position()}")
        self.go_to_main_menu()

    def cast_vote(self):
        try:
            candidate_id = self.__select_candidate()
            registration_number = input("Enter your registration number: ")
            vote = self.voter.cast_vote(registration_number, candidate_id)
            print(f"Your vote for { self.electoral_body.get_candidate_name(candidate_id)} with ID  {vote.get_candidate_id()} was successful")
        except Exception as e:
            print(str(e))
        finally:
            self.go_to_main_menu()

    def find_list_of_voted_candidates(self):
        for vote in self.voter.votes:
            print(vote)
        self.go_to_main_menu()

    def update_password(self):
        current_password = input("Enter your current password: ")
        new_password = input("Enter your new password: ")
        self.voter.update_password(current_password, new_password)
        print("Password updated successfully")
        self.go_to_main_menu()


    def exit(self):
        print("Thank you for using this app")

    def __register_candidates(self):
        self.electoral_body.register_candidate("bola", "bolake", "President")
        self.electoral_body.register_candidate("bola", "bolarinwa", "Senate President")
        self.electoral_body.register_candidate("bola", "ige", "Governor")
        self.electoral_body.register_candidate("bola", "bolana", "Local Government chairman")

VoterInterface().display_menu()




