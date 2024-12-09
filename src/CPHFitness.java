public class CPHFitness {
    private User currentUser;
    private Leaderboard leaderboard;
    private TrainingPlanList trainingPlanList;
    private TextUI ui = new TextUI();

    public CPHFitness(){

    }

    public void startMenu(){
        String bold = "\u001B[1m";
        //Tænker man her skal blive mødt med valget om at logge ind eller oprette sig som bruger, ved at kalde på
        //registerUser() eller userLogin()
        int choice = ui.promptNumeric(bold+"Welcome to CPHFitness!\n"+"1) Log in\n"+"2) Sign up\n"+"3) Exit app");
        switch(choice){
            case 1:
                //userLogin();
                mainMenu();
                break;
            case 2:
                currentUser = registerUser();
                mainMenu();
                break;
            case 3:
                exitProgram();
                break;
            default:
                startMenu();
        }
    }

    public void mainMenu() {
        int choice = ui.promptNumeric("You have the following options: \n " +
                "1) Add a run \n " +
                "2) Add a goal \n " +
                "3) View previous runs \n " +
                "4) View your current training plan or choose a new one \n " +
                "5) View your current challenge or take a new one \n " +
                "6) View your goals \n " +
                "7) Exit program");

        switch (choice) {
            case 1:
                int hours = ui.promptNumeric("Enter hours: ");
                int minutes = ui.promptNumeric("Enter minutes ");
                int seconds = ui.promptNumeric("Enter seconds: ");
                String date = ui.promptText("Enter the date of the run: dd/mm/yy: ");
                float distance = ui.promptNumeric("Enter the distance in meters:");
                Run run = new Run(hours, minutes, seconds, distance, date);
                currentUser.getRunningLog().add(run);
                mainMenu();
            case 2:
                createGoal();
                mainMenu();
            case 3:
                currentUser.viewRunningLog();
                mainMenu();
            case 4:
                //currentUser.viewTrainingPlanList;   // Metode findes ikke endnu
                mainMenu();
            case 5:
                ChallengesList.viewChallenge();
                mainMenu();
            case 6:
                currentUser.viewGoalLog();
                mainMenu();
            case 7:
                System.out.println("Exiting the program. Goodbye!");
                exitProgram();
            default:
                System.out.println("Invalid choice. Please try again.");
                mainMenu();
        }
    }

    public void createGoal() {
        int choice = ui.promptNumeric("You have the following options: \n " +
                "1) Add untimed distance-based goal (e.g 50 km)\n " +
                "2) Add timed distance-based goal (e.g 10 km under 60 minutes) \n " +
                "3) Add timed non-distance based goal (e.g 30 minutes) \n " +
                "4) Exit program");



        switch(choice){
            case 1:
                float goal1 = ui.promptNumeric("Enter distance in kilometers:");
                currentUser.addGoal(new Goal(goal1, 0));
                break;
            case 2:
            //    float goal2 = ui. ;
            default:
                System.out.println("Invalid number");
                createGoal();
        }
    }

    /*public void userLogin() {
        String bold = "\u001B[1m";
        String inputUsername = ui.promptText(bold + "Enter your username: ");
        String inputPassword = ui.promptText(bold + "Enter your password: ");
        // Herfra kan først fikses når databasen virker
        if (inputUsername.equals(this.username) && inputPassword.equals(this.password)) {
            ui.displayMsg(bold + "Login succeeded!");
            ui.displayMsg(bold + "Welcome, " + this.username + "!");
        } else {
            ui.displayMsg(bold + "Your username and/or password was incorrect - try again or sign up!");
            userLogin();
        }
    }
    */

    public User registerUser() {
        String username = ui.promptText("Enter your username:");
        String password = ui.promptText("Enter your password:");
        int age = ui.promptNumeric("Enter your age:");
        String gender = ui.promptText("Enter your gender (Male/Female): ");
        int height = ui.promptNumeric("Enter your height in cm:");
        double weight = ui.promptNumeric("Enter your weight in kg:");
        User user = new User(username, password, age, gender, height, weight);
        //DatabaseHandler.saveUser(user);
        ui.displayMsg("User registered successfully!");
        return user;
    }

    public void exitProgram(){
        System.exit(0);
    }
}
