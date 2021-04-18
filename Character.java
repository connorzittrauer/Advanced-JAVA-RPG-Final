/*
Should have a method to roll for damage that combines a random number generator with the attack stat
Should have a method to roll for attack that combines a random number generator with the accuracy stat
Should have a method to roll for physical defense that combines a random number generator with the physical defense stat
Should have a method to roll for magical defense that combines a random number generator with the magical defense stat
 */


import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Character 
{
    int health =100, accuracy, attack, physicalDefense, magicalDefense;
    int count=0;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    String username;

    //setters
    public abstract void setAttack(int value);
    public abstract void setAccuracy(int value);
    public abstract void setMagicalDefense(int value);
    public abstract void setPhysicalDefense(int value);
    public abstract void setHealth();
    public abstract void setUsername(String username);
    public abstract void kill();

    //getters
    public abstract int getAttack();
    public abstract int getHealth();
    public abstract int getAccuracy();
    public abstract int getMagicalDefense();
    public abstract int getPhysicalDefense();
    public abstract String getUsername();


    //fighting action generators
    public abstract void rollAttack();
    public abstract void rollDamage();
    public abstract void rollPhysDefense();
    public abstract void rollMagicDefense();


    //fighting console methods
    public abstract void showDamage();
    public abstract void takeDamage(int damage);





    
}
