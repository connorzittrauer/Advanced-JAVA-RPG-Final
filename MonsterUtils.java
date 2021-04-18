import java.util.Scanner;

public class MonsterUtils
{
    private static Scanner scan = new Scanner(System.in);
    private static boolean choosing = true;
    private static String input;

    public static void attack(Character player, Character monster)
    {
        //give player options
        System.out.println("Options");
        System.out.println("A. Regular Attack");
        System.out.println("B. Super Attack");
        System.out.println("C. Boost Physical Defense");
        System.out.println("D. Boost Magical Defense");
        System.out.print(">>> ");
        input = scan.next();

        while (choosing)
        {
            if (input.equalsIgnoreCase("a"))
            {
                player.rollAttack();
                System.out.println("You inflicted " + player.getAttack() + " damage points");
                monster.takeDamage(player.getAttack());
                System.out.println();
                prompt();
                choosing = false;
            } else if (input.equalsIgnoreCase("b"))
            {
                player.rollDamage();
                System.out.println("You inflicted " + player.getAttack() + " damage points");
                monster.takeDamage(player.getAttack());
                System.out.println();
                prompt();
                choosing = false;
            }
            else if (input.equalsIgnoreCase("c"))
            {
                player.rollPhysDefense();
                System.out.println();
                prompt();
                choosing = false;
            }
            else if (input.equalsIgnoreCase("d"))
            {
                player.rollMagicDefense();
                System.out.println();
                prompt();
                choosing = false;
            }

            else
            {
                System.out.println("Enter a Valid Letter");
                System.out.print(">>> ");
                input = scan.next();
            }


        }


    }

    public static void prompt()
    {
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Press Enter to Continue: ");
        while (true)
        {
            System.out.print(">>> ");
            input = scan.nextLine();
//                System.out.println();

            if (!input.equals(""))
            {
                System.out.println("Press enter");
            } else
                break;
        }
    }

    public static boolean checkHealth(Character player, Character monster)
    {
        boolean binary = false;

        if (player.getHealth() <= 0 || monster.getHealth() <= 0)
            binary = true;

        if (player.getHealth() <= 0)
            player.kill();
        else if (monster.getHealth() <=0)
            monster.kill();

        return binary;
    }
}
