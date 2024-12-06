public class User {

    private String username;
    private String password;
    private int age;
    private String gender;
    private int height;
    private double weight;
    private RunningLog runningLog;
    private TextUI ui = new TextUI();


    public User(String username, String password, int age, String gender, int height, double weight) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.runningLog = new RunningLog();

    }

    public void userLogin(){
        String bold = "\u001B[1m";
        String inputUsername = ui.promptText(bold+"Enter your username: ");
        String inputPassword = ui.promptText(bold+"Enter your password: ");
        // TO DO: Fejl i denne kode skal rettes!!!!!!!!
        if(inputUsername.equals(this.username) && inputPassword.equals(this.password)){
            ui.displayMsg(bold+"Login succeeded!");
            ui.displayMsg(bold+"Welcome, "+this.username+"!");
            CPHFitness.mainMenu();
        }else{
            ui.displayMsg(bold+"Your username and/or password was incorrect - try again or sign up!");
            userLogin();
        }
    }

    public void editGoal(Goal goal) {

        //Kode der gør at man kan

    }

    public void updateWeight() {
        String bold = "\u001B[1m";
        try {
            double newWeight = ui.promptNumeric(bold+"Type your updated weight in kg's: ");
            if (newWeight > 0) {
                ui.displayMsg(bold+"Weight has been updated from: " + weight + "kg., to: " + newWeight + "kg.");
                this.weight = newWeight;
            } else {
                ui.displayMsg(bold+"Invalid weight. Please type a positive number!");
                updateWeight();
            }
        } catch (Exception e) {
            System.out.println(bold+e);
        }

    }

    public void updateHeight() {
        String bold = "\u001B[1m";
        try {
            int newHeight = ui.promptNumeric(bold+"Type your updated height in cm's: ");
            if (newHeight > 0) {
                ui.displayMsg(bold+"Weight has been updated from: " + height + "cm., to: " + newHeight + "cm.");
                this.height = newHeight;
            } else {
                ui.displayMsg(bold+"Invalid height. Please type a positive number!");
                updateHeight();
            }
        } catch (Exception e) {
            System.out.println(bold+e);
        }
    }

}

