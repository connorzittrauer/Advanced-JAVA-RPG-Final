/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;
import org.apache.commons.io.FilenameUtils;

public class Initialize implements Serializable
{
    private Scanner scan = new Scanner(System.in);
    private Scanner scan2 = new Scanner(System.in);
    private String[] charList;
    private File path = new File("src/Characters");
    private boolean initializing = true, creating = true, loading = true, playing = true;
    private String charName;
    private ArrayList<Character> characterList = new ArrayList();
    private ArrayList<String> charNames = new ArrayList(Arrays.asList("Archer", "Fisherman", "Magician", "Pick-Pocket"));


    public void initialize() throws IOException {
        String input;

        System.out.println("Welcome to Doom-Scape");
        System.out.println("1. New Character");
        System.out.println("2. Load Existing Character");
        System.out.print(">>> ");
        input = scan.next();
        System.out.println();

        while (initializing) {

            if (input.equals("1"))
            {
                create();
            }
            else if (input.equals("2")) {
                load();
            }
            else {
                System.out.print("Enter a valid number (1, 2): ");
                input = scan.next();
            }
        }
        System.out.println();
    }

    private void create() throws IOException {

        String input = "";

        System.out.println("Choose from a list of characters . . .");
        System.out.println("1. Archer");
        System.out.println("2. Fisherman");
        System.out.println("3. Magician");
        System.out.println("4. Pick-Pocket");
        System.out.print(">>> ");

        input = scan.next();

        while (creating) {

            try {


                //selects from ArrayList of character names to simplify conditionals
                if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < 5) {
                    System.out.println("Character type: " +
                            charNames.get(Integer.parseInt(input) - 1)
                            + " was selected");

                    System.out.print("Choose character name: ");
                    charName = scan.next();
                    creating = false;

                } else {
                    System.out.print("Valid Numbers Only (1-4): ");
                    input = scan.next();
                    System.out.println();
                }
            } catch (NumberFormatException error) {
                System.out.print("Numbers Only: ");
                input = scan.next();

            }

        }

        FileOutputStream fileOut = new FileOutputStream("src/Characters/" + charName + ".ser");
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);

        int selection = Integer.parseInt(input);

        if (selection == 1) {
            Archer archer1 = new Archer();
            SetStats.setStats(archer1);
            archer1.setUsername(charName);


            outStream.writeObject(archer1);
            outStream.close();

        } else if (selection == 2) {
            Fisherman fisher1 = new Fisherman();
            SetStats.setStats(fisher1);
            fisher1.setUsername(charName);

            outStream.writeObject(fisher1);
            outStream.close();

        } else if (selection == 3) {
            Magician mag1 = new Magician();
            SetStats.setStats(mag1);
            mag1.setUsername(charName);

            outStream.writeObject(mag1);
            outStream.close();

        } else if (selection == 4) {
            PickPocket pick1 = new PickPocket();
            SetStats.setStats(pick1);
            pick1.setUsername(charName);

            outStream.writeObject(pick1);
            outStream.close();

        }
        System.out.println("Character " + "'" + charName + "'" + " was created" + '\n');
        fileOut.close();

        load();
    }

    private void load() throws IOException {

        Scanner scan3 = new Scanner(System.in);
        String characterName = "", input;


        charList = path.list();
        System.out.println("Loading Characters...");

        for (String names : charList)
        {

            System.out.println(FilenameUtils.removeExtension(names));
        }
        System.out.println();

        System.out.print("Select Character: ");
        characterName = scan.next();

        while (loading) {

            try {

                FileInputStream file = new FileInputStream("src/Characters/" + characterName + ".ser");
                ObjectInputStream loadIn = new ObjectInputStream(file);

                Character player = (Character)loadIn.readObject();
                player.setUsername(characterName);
                characterList.add(player);

                loadIn.close();
                file.close();

                System.out.println("Character selected!" + "\n");
                System.out.print("Press enter to continue: ");
                input = scan3.nextLine();
                System.out.println();

                if (input.equals(""))
                {
                    loading = false;
                    initializing = false;

                }

            }
            catch (ClassNotFoundException error)
            {
                error.printStackTrace();
            }
            catch (FileNotFoundException error)
            {
                System.out.println();
                System.out.println("Character not found!");
                System.out.print("Select Character: ");
                characterName = scan.next();
            }


        }

        play();

    }

    public void play() throws IOException
    {
        String input;
        boolean selecting = true;
        Battle duel = new Battle();
        Scanner scan4 = new Scanner(System.in);


        Character player = characterList.get(0);


        FileOutputStream fileOut = new FileOutputStream("src/Characters/" + player.getUsername() + ".ser");
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);

        System.out.println("Welcome to Doom-Scape, " + player.getUsername() + ".");
        System.out.println("Enter one of the following");
        while (playing)
        {
            System.out.println();
            System.out.println("A. Fight");
            System.out.println("B. Play 'Shuffles'");
            System.out.println("C. Fish");
            System.out.println("D. Pick Pocket");
            System.out.println("E. Cast Spells");
            System.out.println("F. Save & Exit");
            System.out.println("G. Change Characters");
            System.out.print(">>> ");

            input = scan4.nextLine();

            while (selecting)
            {
                if (input.equalsIgnoreCase("a"))
                {
                    duel.roll(player);
                    break;

                }
                else if (input.equalsIgnoreCase("b"))
                {
                    Actions.shuffler();
                    break;

                }
                else if (input.equalsIgnoreCase("c"))
                {
                    Actions.fish();
                    break;

                }
                else if (input.equalsIgnoreCase("d"))
                {
                    Actions.thieving();
                    break;

                }
                else if (input.equalsIgnoreCase("e"))
                {
                    Actions.castSpells();
                    break;
                }
                else if (input.equalsIgnoreCase("f"))
                {
                    outStream.writeObject(player);
                    System.out.println("Character " + "'" + player.getUsername() + "'" + " was saved" + '\n');
                    System.out.println("Exiting Doom-Scape...");
                    fileOut.close();
                    playing = false;
                    break;

                }
                else if (input.equalsIgnoreCase("g"))
                {
                    outStream.close();
                    fileOut.close();

                    load();
                    break;

                }
                else
                {
                    System.out.println("Enter a Valid Letter");
                    System.out.print(">>> ");
                    input = scan4.nextLine();
                }

            }

        }

    }

}



