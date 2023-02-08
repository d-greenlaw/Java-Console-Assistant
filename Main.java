import java.util.*;

public class Main {
    public static void main(String[] args) {
        instantiateAssistants();
    }

    static void instantiateAssistants() {
        ArrayList<VirtualAssistant> assistant_list = new ArrayList<VirtualAssistant>();
        int id_counter = 1;
        String[][] assistant_data = { 
            {"Cindy","Voice1",Integer.toString(id_counter++)}, 
            {"Donna","Voice2",Integer.toString(id_counter++)}, 
            {"Bruno","Voice3",Integer.toString(id_counter++)} 
        };
        for(int i=0;i<assistant_data.length;i++) {
            VirtualAssistant assistant = new VirtualAssistant(assistant_data[i][0], assistant_data[i][1], Integer.parseInt(assistant_data[i][2]));
            assistant_list.add(assistant);
        }
        userSelectAssistant(assistant_list);
    }

    static void userSelectAssistant(ArrayList<VirtualAssistant> assistant_list) {
        Scanner assistant_scanner = new Scanner(System.in);
        System.out.println("Select a Virtual Assistant:");
        System.out.println("--------------------------");
        for (VirtualAssistant assistant : assistant_list){
            System.out.println("To Select " + assistant.getAssistantName() + ", Type " + assistant.getAssistantid());
        }
        try{
            int selectedAssistantId = assistant_scanner.nextInt();
            // If the user selected one of the possible options let them know who they selected
            // Loop through the options again, if the user input a number that was not an option retry
            ArrayList<Integer> assistant_ids = new ArrayList<Integer>();
            for (VirtualAssistant assistant : assistant_list){
                assistant_ids.add(assistant.getAssistantid());
            }
            if (assistant_ids.contains(selectedAssistantId)){
                // Success! start up the assistant now
                startUpAssistant(selectedAssistantId, assistant_list, assistant_scanner);
            }
            else{
                clearConsole();
                System.out.println("**** You must select a valid option! ****\n");
                userSelectAssistant(assistant_list);
            }
        }
        catch(InputMismatchException e) {
            // If the user types in a letter or special character throw an error message
            clearConsole();
            System.out.println("**** You must select a number! ****\n");
            userSelectAssistant(assistant_list);
        }
        assistant_scanner.close();
    }

    static void startUpAssistant(int assistant_id, ArrayList<VirtualAssistant> assistant_list, Scanner assistant_scanner){
        VirtualAssistant selected_assistant;
        // Loop the assistant instances ArrayList and see if it matches the id parameter in this function
        // if it does, assign the instance to the selected_assistant variable
        for (VirtualAssistant assistant : assistant_list){
            if(assistant.getAssistantid() == assistant_id){
                final String ANSI_YELLOW = "\u001B[33m"; // Define color of assistant text / reset
                final String ANSI_RESET = "\u001B[0m";
                selected_assistant = assistant;
                clearConsole(); 
                System.out.println(ANSI_YELLOW
                + "Hello, I am " + selected_assistant.getAssistantName()
                + ANSI_RESET);
                System.out.println(ANSI_YELLOW
                + "Let me know anytime if you want to create a profile \n"
                + "What can I do for you?"
                + ANSI_RESET);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(1>0){
                    String userInput = assistant_scanner.nextLine();
                    if(userInput != ""){
                        System.out.println(ANSI_YELLOW
                        + assistantLogic(userInput)
                        + ANSI_RESET);
                    }
                }
            }
        }
    }

    static void userSettings(){
        Scanner profile_scanner = new Scanner(System.in);
        System.out.println("What should your username be?");
        String username = profile_scanner.nextLine();
        System.out.println("What should your password be?");
        String password = profile_scanner.nextLine();
        System.out.println("What is your email address?");
        String email = profile_scanner.nextLine();
        System.out.println("What is your phone number?");
        Integer phone = profile_scanner.nextInt();
        UserProfile user_profile = new UserProfile(username, password, email, phone);
        System.out.println(user_profile.getProfileInfo());
        profile_scanner.close();
        assistantLogic("resume");
        // TODO - this is buggy
    }
        
    static String assistantLogic(String user_input){
        String assistant_output;
        if(user_input.contains("test")){
            assistant_output = "You are running a test?";
        }
        else if(user_input.contains("fun")){
            assistant_output = "You like to have fun?";
        }
        else if(user_input.contains("profile" )){
            userSettings(); // Check if user wants to create or update(todo) their profile
            assistant_output = "Okay!";
        }
        else if(user_input.contains("resume" )){
            assistant_output = "Great you created your profile!";
        }
        else{
            assistant_output = "I didn't get that, please try again.";
        }
        clearConsole();
        return assistant_output;
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J"); // Clear the screen / move cursor to first row
        System.out.flush();
    }
}

