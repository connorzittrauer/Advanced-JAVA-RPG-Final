import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Shuffler
{

    public void shuffler() {
        boolean shuffling = true, play = true;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        String choice;

        System.out.println("Welcome to the Shuffler Club!" + "\n");
        System.out.println("Jankel will shuffle 4 cups, if you pick the one with the coin in it, you win! ");
        System.out.println("Enter Numbers (1-4)" + "\n");
        String cup1 = "*", cup2 = "*", cup3 = "*", coin = "*", prompt;

        ArrayList<String> cups = new ArrayList<>(Arrays.asList(cup1, cup2, cup3, coin));


        while (play) {


            Collections.shuffle(cups);

            for (String pick : cups) {
                System.out.print(pick + " " + "\t");

            }
            System.out.println();
            System.out.println();
            System.out.println("Which cup contains the coin? ");
            System.out.print(">>> ");



            try {


                choice = scan.nextLine();
                int range = Integer.parseInt(choice);

                if (range > 0 && range < 5)
                {

                    if (range == (cups.indexOf(coin) + 1))

                        System.out.println("Congrats!" + "\n");

                    else
                        System.out.println("Wrong pick!" + "\n");



                    System.out.print("Play again? y/n: ");
                    prompt = scan2.next();
                    System.out.println();
                    Collections.shuffle(cups);

                    if (!prompt.equalsIgnoreCase("y"))
                        play = false;
                }
                else
                {
                    System.out.println("Numbers 1-4 Only");

                }
            }
            catch (NumberFormatException error) {
                System.out.println("Numbers Only");
            }


        }
    }
    public static void main(String[] args) {
        Shuffler user = new Shuffler();
        user.shuffler();
    }


}
