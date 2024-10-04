import java.util.Scanner;

public class Main {
    // Arrays to store 3 different users and passwords
    static String[] userNames = {"McImp", "Bearlier", "Miplukus"};
    static String[] passWords = {"Davs12345!", "Hej12345!", "Hallo12345!"};


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String inputUsername = input.nextLine();

        //calls validate username method to check if username matches logged array usernames
        int userIndex = validateUsername(inputUsername);

        if (userIndex == -1) {
            System.out.println("Username does not exist!");
        } else {
            loginHandle(userIndex, input);
        }

        input.close();

    } // main end


    public static int validateUsername(String username) {
        // validates usernames from logged array of usernames, returns -1 if non existing and terminates program
        for (int i = 0; i < userNames.length; i++) {
            if (userNames[i].equals(username)) {
                return i;
            }
        }
        return -1;
    }


    public static void loginHandle(int userIndex, Scanner input) {
        //This method is used to handle input from user and validate the password to the logged passwords.
        int attempts = 0;
        boolean loggedIn = false;
        // gives user 3 attempts to match the correct password to username, if still not right, it fails.
        while (attempts < 3 && !loggedIn) {
            System.out.print("Enter your password: ");
            String passWord = input.nextLine();

            if (passWords[userIndex].equals(passWord)) {
                loggedIn = true;
                System.out.println("Login successful! Welcome to our login system, " + userNames[userIndex] + "!");
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Incorrect password. Try again (" + (3 - attempts) + " attempts left).");
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts, try again later.");
        }
    }

}