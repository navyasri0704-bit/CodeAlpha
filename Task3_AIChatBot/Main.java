import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Chat history
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("      AI CHATBOT");
        System.out.println("====================================");
        System.out.println("Type 'help' to see available questions.");
        System.out.println("Type 'history' to view conversation.");
        System.out.println("Type 'bye' to exit.\n");

        while (true) {

            System.out.print("You : ");
            String input = sc.nextLine();

            history.add("You : " + input);

            String response = getResponse(input);

            history.add("Bot : " + response);

            System.out.println("Bot : " + response);

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("\nThank you for chatting!");
                break;
            }
        }
    }

    // NLP Logic (Keyword Matching)
    static String getResponse(String input) {

        input = input.toLowerCase().trim();

        if (input.contains("hello") || input.contains("hi"))
            return "Hello! Nice to meet you.";

        else if (input.contains("how are you"))
            return "I am doing great! Thanks for asking.";

        else if (input.contains("your name"))
            return "I am an AI ChatBot created in Java.";

        else if (input.contains("java"))
            return "Java is an Object-Oriented Programming Language.";

        else if (input.contains("oops"))
            return "OOP stands for Object-Oriented Programming.";

        else if (input.contains("who created java"))
            return "Java was created by James Gosling.";

        else if (input.contains("python"))
            return "Python is a high-level programming language.";

        else if (input.contains("html"))
            return "HTML is used to create web pages.";

        else if (input.contains("css"))
            return "CSS is used for styling web pages.";

        else if (input.contains("javascript"))
            return "JavaScript makes web pages interactive.";

        else if (input.contains("college"))
            return "I can answer general educational questions.";

        else if (input.contains("course"))
            return "There are many courses like Java, Python, AI, and Web Development.";

        else if (input.contains("ai"))
            return "Artificial Intelligence enables computers to perform tasks that normally require human intelligence.";

        else if (input.contains("machine learning"))
            return "Machine Learning is a branch of AI where systems learn from data.";

        else if (input.contains("chatbot"))
            return "A chatbot is a program that communicates with users automatically.";

        else if (input.contains("weather"))
            return "Sorry, I cannot access live weather information.";

        else if (input.contains("time"))
            return "I cannot access the current system time in this version.";

        else if (input.contains("date"))
            return "I cannot access the current date in this version.";

        else if (input.contains("thank"))
            return "You're welcome!";

        else if (input.equals("history")) {

            System.out.println("\n====== CHAT HISTORY ======");

            for (String chat : history)
                System.out.println(chat);

            return "End of history.";

        }

        else if (input.equals("help")) {

            return """
Available Questions:

• Hello
• Hi
• How are you
• Your name
• What is Java
• What is Python
• What is HTML
• What is CSS
• What is JavaScript
• What is AI
• What is Machine Learning
• What is OOPS
• Who created Java
• What is Chatbot
• College
• Course
• History
• Bye
""";
        }

        else if (input.equals("bye"))
            return "Goodbye! Have a nice day.";

        else
            return "Sorry, I don't understand your question.";
    }
}