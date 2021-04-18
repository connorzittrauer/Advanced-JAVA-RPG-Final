/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.Scanner;

public class Battle 
{


    public void roll(Character player)
    {
        Random rand = new Random();



        if (rand.nextInt(2) == 0)
            duel1(player);
        else
            duel2(player);
    }

    private void duel1(Character player)
    {
        Karlor monster = new Karlor();
        Random rand = new Random();
        boolean fighting = true;

        //initializes character's health to 100
        player.setHealth();
        monster.setHealth();

        System.out.println("Get prepared! You are about to battle Karlor!");
        System.out.println("---------------------------------------------");
        System.out.println("Here are your stats: ");
        System.out.println("Attack " + player.getAttack());
        System.out.println("Accuracy " + player.getAccuracy());
        System.out.println("Magical Defense: " + player.getMagicalDefense());
        System.out.println("Physical Defense: " + player.getPhysicalDefense());
        System.out.println();
        MonsterUtils.prompt();
        System.out.println();

        {
            //monster strikes, out of loop since its the first attack
            System.out.println("Karlor gets the first attack!");

            while (fighting)
            {
                //generates new monster attack every loop
                monster.setAttack(rand.nextInt(50) + 25);
                monster.setAccuracy(rand.nextInt(50) + 25);
                monster.rollAttack();

                System.out.println("Karlor inflicted " + monster.getAttack() + " damage points");
                System.out.println();
                player.takeDamage(monster.getAttack());

                //print out health
                System.out.println(player.getUsername() + "'s Health: " + player.getHealth());
                System.out.println("Karlor's Health: " + monster.getHealth());
                System.out.println();
                //checks health, if return true breaks out of loop
                if (MonsterUtils.checkHealth(player, monster)) break;

                MonsterUtils.prompt();
                System.out.println();

                //get players attack choice
                MonsterUtils.attack(player, monster);


                System.out.println(player.getUsername() + "'s Health: " + player.getHealth());
                System.out.println("Karlor's Health: " + monster.getHealth());
                System.out.println();
                if (MonsterUtils.checkHealth(player, monster)) break;


            }
            System.out.println("Exited..." + "\n");

            if (player.getHealth() <= 0)
                System.out.println("Karlor won!");
            if (monster.getHealth() <= 0)
                System.out.println("You won, " + player.getUsername() + "!");

        }

    }

        private void duel2(Character player)
        {
            Lapalux monster = new Lapalux();
            Random rand = new Random();
            boolean fighting = true;

            //initializes health to 100
            player.setHealth();
            monster.setHealth();

            System.out.println("Get prepared! You are about to battle Lapalux!");
            System.out.println("---------------------------------------------");
            System.out.println("Here are your stats: ");
            System.out.println("Attack " + player.getAttack());
            System.out.println("Accuracy " + player.getAccuracy());
            System.out.println("Magical Defense: " + player.getMagicalDefense());
            System.out.println("Physical Defense: " + player.getPhysicalDefense());
            System.out.println();

            MonsterUtils.prompt();

                    {
                        //player strikes
                        System.out.println(player.getUsername() + " gets the first attack!");
                        System.out.println();
                        player.rollAttack();
                        System.out.println("You inflicted " + player.getAttack() + " damage points");
                        System.out.println();
                        monster.takeDamage(player.getAttack());
                        //checks health
                        MonsterUtils.checkHealth(player, monster);

                        while (fighting)
                        {

                            //print out health
                            System.out.println(player.getUsername() + "'s Health: " + player.getHealth());
                            System.out.println("Lapalux's Health: " + monster.getHealth());
                            System.out.println();

                            if (MonsterUtils.checkHealth(player, monster)) break;
                            MonsterUtils.prompt();

                            //monster strikes
                            monster.setAttack(rand.nextInt(50));
                            monster.setAccuracy(rand.nextInt(50));
                            monster.rollAttack();
                            System.out.println("Lapalux inflicted " + monster.getAttack() + " damage points!");

                            //player takes damage
                            player.takeDamage(monster.getAttack());

                            //checks health
                            if (MonsterUtils.checkHealth(player, monster)) break;

                            System.out.println(player.getUsername() + "'s Health: " + player.getHealth());
                            System.out.println("Lapalux's Health: " + monster.getHealth());
                            System.out.println();
                            if (MonsterUtils.checkHealth(player, monster)) break;

                            //give player attack options
                            MonsterUtils.attack(player, monster);

                        }
                        System.out.println("Exited..." + "\n");

                        if (player.getHealth() <= 0)
                            System.out.println("Lapalux won!");
                        if (monster.getHealth() <= 0)
                            System.out.println("You won, " + player.getUsername() + "!");

                    }

            }
        }


