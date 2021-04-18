import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SetStats {

    /* I know this class is a monstrosity of redundancy, but I spent
       an eternity trying to debug the try/catch blocks and this was
       what I was finally able to get to work
     */
    public static void setStats(Character player)
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String input;
        boolean selecting = true;

        int stat1 = rand.nextInt(51) + 50;
        int stat2 = rand.nextInt(51) + 50;
        int stat3 = rand.nextInt(51) + 50;
        int stat4 = rand.nextInt(51) + 50;
        ArrayList<Integer> statlist = new ArrayList<>(Arrays.asList(stat1, stat2, stat3, stat4));

        System.out.println();
        System.out.println("Stat Selector Menu");
        System.out.println("----------------------------------");
        System.out.println("Here are your stats to choose from.");
        System.out.println("Enter numbers (1-4) only");
        System.out.println();

        for (Integer values : statlist)
            System.out.print(values + "\t");
        System.out.println();
        System.out.println();

        while (selecting)
        {

            System.out.println("Which stat which you like to assign your attack value to?");
            System.out.print(">>> ");
            input = scan.nextLine();

            while (true) {

                try {
                    //selects from ArrayList of character names to simplify conditionals
                    if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 4)
                    {
                        if (input.equals("1"))
                            player.setAttack(statlist.get(0));
                        else if (input.equals("2"))
                            player.setAttack(statlist.get(1));
                        else if (input.equals("3"))
                            player.setAttack(statlist.get(2));
                        else if (input.equals("4"))
                            player.setAttack(statlist.get(3));
                        break;
                    }
                    else
                    {
                        System.out.print("Valid Numbers Only (1-4): ");
                        input = scan.next();
                    }
                }
                catch (NumberFormatException error)
                {
                    System.out.print("Numbers Only: ");
                    input = scan.next();
                }
            }

            //remove the selected value and update
            int index = Integer.parseInt(input);
            statlist.remove(index - 1);

            for (Integer values : statlist)
                System.out.print(values + "\t");
            System.out.println();

            System.out.println("Which stat which you like to assign your accuracy value to?");
            System.out.print(">>> ");
            input = scan.next();

            while (true) {

                try {
                    //selects from ArrayList of character names to simplify conditionals
                    if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 4)
                    {
                        if (input.equals("1"))
                            player.setAccuracy(statlist.get(0));
                        else if (input.equals("2"))
                            player.setAccuracy(statlist.get(1));
                        else if (input.equals("3"))
                            player.setAccuracy(statlist.get(2));
                        break;
                    }
                    else
                    {
                        System.out.print("Valid Numbers Only (1-3): ");
                        input = scan.next();
                    }
                }
                catch (NumberFormatException error)
                {
                    System.out.print("Numbers Only: ");
                    input = scan.next();
                }
            }

            //remove the selected value and update
            index = Integer.parseInt(input);
            statlist.remove(index - 1);

            for (Integer values : statlist)
                System.out.print(values + "\t");
            System.out.println();

            System.out.println("Which stat which you like to assign your Physical Defense value to?");
            System.out.print(">>> ");
            input = scan.next();
            while (true)
            {
                try {
                    //selects from ArrayList of character names to simplify conditionals
                    if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 4)
                    {
                        if (input.equals("1"))
                            player.setPhysicalDefense(statlist.get(0));
                        else if (input.equals("2"))
                            player.setPhysicalDefense(statlist.get(1));
                        break;
                    }
                    else
                    {
                        System.out.print("Valid Numbers Only (1-2): ");
                        input = scan.next();
                    }
                }
                catch (NumberFormatException error)
                {
                    System.out.print("Numbers Only: ");
                    input = scan.next();
                }
            }

            //remove the selected value and update
            index = Integer.parseInt(input);
            statlist.remove(index - 1);

            //last value is auto-assigned
            System.out.println("Assigning the value " + statlist.get(0) + " to your player's Magical Defense...");
            player.setMagicalDefense(statlist.get(0));

            selecting = false;

        }
    }

}


















