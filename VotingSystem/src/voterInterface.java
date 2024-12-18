import voting.*;

import java.util.Scanner;
import static java.lang.System.exit;

public class voterInterface {

    private static ElectoralBody electoralBody = new ElectoralBody();
    private static Voter voter = new Voter();
    private static Election election = new Election(electoralBody);


    public static void main(String[] args) {
        registerCandidate();
        goToMainMenu();

    }

    public static void goToMainMenu(){
        String menu = """
                NATIONAL ELECTION
                1 -> Voters' registration
                2 -> Get your registration number
                3 -> View all candidates
                4 -> Cast vote
                5 -> View voted candidates
                6 -> Change password
                7 -> Exit
                """;
        display(menu);
        menuInput();
    }

    private static void menuInput() {
        try{


        char input = input("Enter a number: ").charAt(0);
        switch (input) {
            case '1':
                registerVoter();
                break;
            case '2':
                displayRegistrationNumber();
                break;
            case '3':
                displayCandidates();
                break;
            case '4':
                castVote();
                break;
            case '5':
                findListOfVotedCandidate();
                break;
            case '6':
                updatePassword();
                break;
            case '7':
                exitApp();
                break;
            default:
                display("Invalid input, try again");goToMainMenu();

        }
        }catch(Exception e){
            display("Invalid input, try again");
            }
            finally{
            goToMainMenu();
            }

    }

    public static void castVote() {
       int candidateId = selectCandidate();
        long voterId = collectLongInput("Enter your registration number: ");
        try {
            Vote vote = election.castVote(voterId, candidateId);

            display("Your vote for" + " " + electoralBody.getCandidateName(candidateId) + " " + "with ID no:" + " " + vote.getCandidateId() + " " + "was successful");
        }
        catch(VoterNotRegisteredException e) {
            display(e.getMessage());
        }
        catch(CandidateNotRegisteredException e) {
            display(e.getMessage());
        }
        catch(CandidateHasBeenVotedException e) {
            display(e.getMessage());
        }
        catch(Exception e) {
            display("Invalid input, try again");
        }
        finally {
            goToMainMenu();
        }
    }


    public static void displayRegistrationNumber() {
        display("Your Voters' Registration Number is" + " " + electoralBody.getVoterId());
        goToMainMenu();
    }

    public static void registerVoter() {
        try {
            String firstName = input("Enter first name: ");
            String lastName = input("Enter last name: ");
            String password = input("Enter password: ");
            var registeredVoter = electoralBody.registerVoter(firstName, lastName, password);
            voter = registeredVoter;
            display("Your Voters' Registration Number is : " + " " + registeredVoter.getVoterId());
        }
        catch(Exception e){
            display("Invalid input");
        }
        finally {
            goToMainMenu();
        }
    }


    public static void updatePassword() {
        try {
            String oldPassword = input("Enter current password: ");
            String newPassword = input("Enter new password: ");
            voter.updatePassword(oldPassword, newPassword);
            display("Password updated successfully!");
        }
        catch(Exception e){
            display("Invalid input");
        }
        finally {
            goToMainMenu();
        }
    }

    public static void exitApp() {
        display("Thank you for using this app");
        exit(0);
    }



    public static void display(String message){
        System.out.println(message);
    }


    public static void displayCandidates(){
        for(Candidate candidates: electoralBody.candidateList){
            display(candidates.getName()+" - "+ candidates.getPosition());
        }
        goToMainMenu();
    }

    public static int selectCandidate() {
        for (Candidate positions: electoralBody.candidateList ) {
            display(positions.getId() + " " + "->" + " " + positions.getName()+"- "+ positions.getPosition());
        }
        return collectIntegerInput("Enter candidate number: ");
    }

    public static void findListOfVotedCandidate(){

        for (Vote list : election.votes) {
            System.out.println(list.toString());
        }
        goToMainMenu();
    }

    private static void registerCandidate() {
        electoralBody.registerCandidate("Bola", "Brown", "President");
        electoralBody.registerCandidate("lala", "White", "Governor");
        electoralBody.registerCandidate("Gorimakpa", "Black", "Senate President");
        electoralBody.registerCandidate("Bolarinde", "Brown", "Speaker, House of Rep");
    }

    private static String input(String prompt){
        display(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    private static int collectIntegerInput(String prompt){
        try {
            return Integer.parseInt(input(prompt));
        }
        catch (NumberFormatException e){
            display("Invalid input, try again");
        }
        return collectIntegerInput(prompt);
    }

    private static Long collectLongInput(String prompt){
        try {
            return Long.parseLong(input(prompt));
        }
        catch (NumberFormatException e){
            display("Invalid input, try again");
        }
        return collectLongInput(prompt);
    }





}
