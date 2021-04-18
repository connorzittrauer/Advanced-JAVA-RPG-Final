import java.text.DecimalFormat;
import java.util.*;

public class Actions
{

    public static void fish()
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String prompt;
        int lobsters, lobsterCount=0, count=0;

        System.out.println("Welcome to the Lobster Lagoon! Would you like to "
                + "fish for some lobsters? y/n: ");
        System.out.print(">>> ");
        prompt = scan.nextLine();

        while (prompt.equalsIgnoreCase("y"))
        {
            //catches between 0-10 lobsters
            lobsters = rand.nextInt(11);
            System.out.println("You just caught " + lobsters + " lobsters!");
            //stores lobsters in fishing net
            lobsterCount += lobsters;

            System.out.print("Continue fishing? y/n: ");
            prompt = scan.nextLine();
            System.out.println();
            count++;
        }
        if (count < 1)
            System.out.println("Ok. See you next time . . .");
        else
        {
            System.out.println("Thanks for coming by!");
            System.out.println("You caught " + lobsterCount + " "
                    + "lobsters during your fishing trip today.");
        }
    }

    public static void castSpells() {
        String prompt ="y";
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Spellcaster Guild");
        System.out.println("Here you may cast spells..." + "\n");

        while (prompt.equalsIgnoreCase("y"))
        {
            System.out.println("Enter your the enemy's name you wish to smite with a spell! ");
            System.out.print(">>> ");
            input = scan.nextLine();
            while (input.length() < 3) {
                System.out.println("Enter a valid name: ");
                System.out.print(">>> ");
                input = scan.nextLine();
                System.out.println("");
            }
            SpellGenerator.stripKeyword(input);
            System.out.println();

            System.out.print("Cast more spells? y/n: ");
            prompt = scan.nextLine();
        }

        System.out.println("Leaving the Spellcasters guild...");
    }

    public static void thieving()
    {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        DecimalFormat fmt = new DecimalFormat("####0.00");
        ArrayList<String> charNames = new ArrayList<>
                (Arrays.asList("Cristoph", "Baggs", "Diene", "Piklo", "Djinnuk"));
        double total =0;
        boolean thieveing = true;
        String option, prompt;


        System.out.println("Surprise! You have been transported to the Uldhek "
                + "Marketplace. There are 5 people to pickpocket. ");
        System.out.println();
        System.out.println("Here are your choices: ");
        System.out.println("1. Cristoph: The Duke of Paladium ");
        System.out.println("2. Baggs: The Local Town Beggar");
        System.out.println("3: Diene: Daughter of King Haalsof");
        System.out.println("4: Piklo: The Village Luthier");
        System.out.println("5: Djinnuk: The Village Clown");
        System.out.println();

        System.out.print(">>> ");

        prompt = scan.next();

        while (thieveing)
        {
            try
            {
                //String prompt is cast to an integer, for some reason this troubleshooting exceptions much easier
                int range = Integer.parseInt(prompt);

                if (range > 0 && range < 6)
                {
                    //new random monetary value generated every instance
                    double money = rand.nextDouble() + rand.nextInt(50);

                    //selects from ArrayList of character names to simplify conditionals
                    System.out.println("You pick-pocketed " + charNames.get(range - 1)
                            + " and got " + "$" + fmt.format(money));

                    //running total of money stolen
                    total += money;

                    System.out.print("Continue pick-pocketing? y/n: ");
                    option = scan.next();

                    if (!option.equalsIgnoreCase("y"))
                    {
                        thieveing = false;
                    }
                    else
                    {
                        System.out.print(">>> ");
                        prompt = scan.next();
                    }
                }
                else
                {
                    System.out.print("Enter a valid number (1-5): ");
                    prompt = scan.next();
                }
            }
            catch (NumberFormatException error)
            {
                System.out.print("Numbers Only: ");
                prompt = scan.next();
            }
        }

        System.out.println();
        System.out.println("You stole " + "$" + fmt.format(total) + " today!");
        System.out.println("Leaving the Uldhek Marketplace...");

    }

    public static void shuffler()
    {
        boolean shuffling = true, play = true;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        String choice;

        System.out.println("Welcome to the Shuffler Club!" + "\n");
        System.out.println("Jankel will shuffle 4 cups, if you pick the one with the coin in it, you win! ");
        System.out.println("Enter Numbers (1-4)" + "\n");
        String cup1 = "*", cup2 = "*", cup3 = "*", coin = "*", prompt;

        ArrayList<String> cups = new ArrayList<>(Arrays.asList(cup1, cup2, cup3, coin));


        while (play)
        {


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
}
