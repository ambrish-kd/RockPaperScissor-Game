//Java program for Popular Game - Rock, Paper, Scissor
//Code Author: Ambrish Dubey

//Importing the Random class of util package
import java.util.Random;

//Importing the Scanner class of util package
import java.util.Scanner;

//Main class of the Program
public class RPS {
    //giving options to choose from
    public static void showMenu(){
        System.out.println("Options to choose from: \n1. Rock\n2. Paper\n3. Scissor");
    }

    //generating computer choice using random 
    public static String generateComputerChoice(Random randomNumber) {
        
        //generating random numbers within a range 0 to 3(excluded)
        int computerInt = randomNumber.nextInt(3);
        String computerChoice = "";

        //defining computer's choice based on the random number generated
        if(computerInt == 0){
            computerChoice = "Rock";
        }else if(computerInt == 1){
            computerChoice = "Paper";
        }else{
            computerChoice = "Scissor";
        }

        System.out.print("\nThe computer already made it's choice.");
        return computerChoice;
    }

    //getting user choice
    public static String getUserChoice(Scanner sc){
        String playerChoice = "";
        System.out.print("\nPlease make yours: ");
        playerChoice = sc.next();
        return playerChoice;
    }

    //decision-making code, to decide winner
    public static String chooseWinner(String computerChoice, String playerChoice) {
        String Winner = "No Winner";
        String customMessage = "Both choose same.";
        String finalMessage = "";

        String rockMessage = "The Rock crushes scissor.";
        String paperMessage = "Paper wraps rock.";
        String scissorsMessage = "Scissor cuts the paper.";

        //using conditionals for deciding winner
        if(playerChoice.equals("Rock") && computerChoice.equals("Scissor")){
            Winner = "You";
            customMessage = rockMessage;
        }else if(playerChoice.equals("Rock") && computerChoice.equals("Paper")){
            Winner = "Computer";
            customMessage = paperMessage;
        }else if(playerChoice.equals("Paper") && computerChoice.equals("Scissor")){
            Winner = "Computer";
            customMessage = scissorsMessage;
        }else if(playerChoice.equals("Paper") && computerChoice.equals("Rock")){
            Winner = "You";
            customMessage = paperMessage;
        }else if(playerChoice.equals("Scissor") && computerChoice.equals("Paper")){
            Winner = "You";
            customMessage = scissorsMessage; 
        }else if(playerChoice.equals("Scissor") && computerChoice.equals("Rock")){
            Winner = "Computer";
            customMessage = rockMessage;
        }
        
        finalMessage = Winner + " won ( " + customMessage + " )";
        return finalMessage;
    }

    //main function
    public static void main(String[] args) {
        //making object of Random class
        Random randomNumber = new Random();

        //making object of Scanner class
        Scanner sc = new Scanner(System.in);

        //Declaring variables
        String computerChoice;
        String playerChoice;
        String Winner;

        //printing welcome message
        System.out.println("-:Rock Paper Scissor Game:-\nWelcome to the Game.");

        //calling functions
        showMenu();
        computerChoice = generateComputerChoice(randomNumber);
        playerChoice = getUserChoice(sc);
        Winner = chooseWinner(computerChoice, playerChoice);

        //printing winner announcement message
        System.out.println("\nYou choose: "+ playerChoice +"\nComputer choose: "+ computerChoice);
        System.out.print( "\n"+Winner );

        //thank you message for playing the game
        System.out.println("\nThanks for playing the Game :)\n");
    }    
}