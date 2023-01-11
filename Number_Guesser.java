import java.util.*;
import java.io.*;
class Number_Guesser
{
    static InputStreamReader in = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(in);
    static Scanner sc = new Scanner(System.in);
    public static void main(String Args[]) throws IOException
    {
        System.out.println("-----------Welcome To The Automated Number Guessing Game------------\nChoose your preference:\n1. Computer\n2. User");
        while(true)
        {
            int choice = Integer.parseInt(br.readLine());
            switch(choice)
            {
                case 1: System.out.println("Enter the min and max of the range of guesses: ");
                        int min = sc.nextInt();
                        int max =sc.nextInt();
                        computerGuess(min, max);
                        return;
                case 2: System.out.println("Enter the max range of guesses: ");
                        int range = sc.nextInt();
                        userGuess(range);
                        return;
                default: System.out.println("Invalid input. Enter again.");    
                break;
            }
        }
    }
    public static void computerGuess(int min, int max) throws IOException
    {
        char answer = '\0';
        System.out.println("Enter C if guess is correct, L if guess is lower and H if guess is higher");
        while(answer!='c')
        {
            int guess = (int)Math.floor((Math.random()*(max-min+1))+min);
            System.out.print("Is "+guess+" the correct guess: ");
            answer = br.readLine().toLowerCase().charAt(0);
            if(answer == 'h')
            {
                max = guess - 1;
            }
            else if(answer == 'l')
            {
                min = guess + 1;
            }
        }
        System.out.println("Heh. Guesses it right!");
    }
    public static void userGuess(int range) throws IOException
    {
        int guess = (int)(Math.random()*range + 1);
        int answer = 0;
        System.out.print("Guess the number: ");
        while(answer!=guess)
        {
            answer = sc.nextInt();
            if(answer<guess)
                System.out.println("The guess is lower.");
            else if(answer>guess)
                System.out.println("The guess is higher");
        }
        System.out.println("Congratulations, you guessed it right!!");
    }
}