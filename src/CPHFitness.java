import java.util.Scanner;
public class CPHFitness {
    private User currentUser;
    private TrainingPlanList trainingPlansList;
    private Leaderboard leaderboard;
    private TextUI ui = new TextUI();
    private RunningLog runningLog;



    public CPHFitness(){

    }

    public void startMenu(){
        String bold = "\u001B[1m";
        //Tænker man her skal blive mødt med valget om at logge ind eller oprette sig som bruger, ved at kalde på
        //registerUser() eller userLogin()
        int choice = ui.promptNumeric(bold+"Welcome to CPHFitness!\n"+"1) Log in\n"+"2) Sign up\n"+"3) Exit app");
        switch(choice){
            case 1:
                currentUser.userLogin();
                break;
            case 2:
                registerUser();
                break;
            case 3:
                exitProgram();
                break;
            default:
                startMenu();
        }

    }

    public void registerUser(){

        String username = ui.promptText("Enter your username:");
        String password = ui.promptText("Enter your password:");
        int age = ui.promptNumeric("Enter your age:");
        String gender =  ui.promptText("Enter your gender (Male/Female): ");
        int height = ui.promptNumeric("Enter your height in cm:");
        double weight = ui.promptNumeric("Enter your weight in kg:");
        User user = new User(username, password, age, gender, height, weight);

        





    }

    public void mainMenu(){


            int choice = ui.promptNumeric("You have the following options: \n " +
                    "1) Add a run\" \n " +
                    "2) View previous runs \n " +
                    "3) View your current training plan or choose a new one \n " +
                    "4) View your current challenge or take a new one \n " +
                    "5) View your goals \n " +
                    "6) Exit program");

    switch (choice) {
        case 1:
            int hours = ui.promptNumeric("Enter hours: ");
            int minutes = ui.promptNumeric("Enter minutes ");
            int seconds = ui.promptNumeric("Enter seconds: ");
            String date = ui.promptText("Enter the date of the run: dd/mm/yy: ");
            float distance = ui.promptNumeric("Enter the distance:");

            Run run = new Run(hours, minutes, seconds, date, distance);
            runningLog.addRun(run);
            break;
        case 2:
            runningLog.viewRunningLog();
            break;
        case 3:
            currentUser;
            break;
        case 4:
            ChallengesList.viewChallenge();
            break;
        case 5:
            Goal.viewGoals();
            break;
        case 6:
            System.out.println("Exiting the program. Goodbye!");
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }


        /*
        Tænker man her skal have følgende valg: // +1, enig
        1) Tilføje et løb: addRun
        2) se historik: viewRunningLog()
        3) Se din træningsplan eller vælg en ny: viewTrainingPlan  EKSTRA
        4) Se din nuværende Challenge eller tilføj en ny: viewChallenge EKSTRA
        5) Se dine mål: showGoals EKSTRA
        6) exit

         */
    }

    public void exitProgram(){

        System.exit(0);

    }


}
