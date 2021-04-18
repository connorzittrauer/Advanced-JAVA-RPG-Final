/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class SpellGenerator
{


    //Generate random username based off of random three letters from keyword
    public static void stripKeyword(String keyWord)
    {
        int index1, index2, index3, randLang;
        String randSeed;
        char chr1, chr2, chr3;
        
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        keyWord = keyWord.toLowerCase();
        int wordLength = keyWord.length();

        index1 = rand.nextInt(wordLength);
        index2 = rand.nextInt(wordLength);
        index3 = rand.nextInt(wordLength);
        
            
        
        chr1 = keyWord.charAt(index1);
        chr2 = keyWord.charAt(index2);
        chr3 = keyWord.charAt(index3);
        
        //mitigates repeating duplicate letters from seed word "ss" "dd" "oo"
        if (chr2 == chr1)
            chr2 = keyWord.charAt((wordLength - 1));
        if (chr3 == chr2)
            chr3 = keyWord.charAt(wordLength - 2);
        if (chr3 == chr1)
            chr3 = keyWord.charAt(wordLength - 3);
        StringBuilder sb = new StringBuilder();
        sb.append(chr1);
        sb.append(chr2);
        sb.append(chr3);
        randSeed = sb.toString();
        

        spellSeed(randSeed);

    }

    private static void spellSeed(String seed)
    {
        Random rand = new Random();
        String suffix, username;
        
        ArrayList<String> lsuffix = new ArrayList<>();
        lsuffix.add("aria");
        lsuffix.add("atum");
        lsuffix.add("icus");
        lsuffix.add("ax");
        lsuffix.add("osus");
        lsuffix.add("nomia");
        lsuffix.add("ellus");
        lsuffix.add("cida");
        lsuffix.add("izo");
        lsuffix.add("illo");
        lsuffix.add("esco");
        lsuffix.add("etum");
        lsuffix.add("sura");
        lsuffix.add("sus");
        lsuffix.add("thica");
        lsuffix.add("trix");
        
        int arrayLength = lsuffix.size();

        for (int x = 1; x <=1; x++)
        {
            suffix = lsuffix.get(rand.nextInt(arrayLength));     
                System.out.println("You cast the " + (username = seed + suffix) + " spell!");

        }

        Random rand2 = new Random();
        int spell = rand.nextInt(5);

        if (spell == 0)
            System.out.println("They were frozen!");
        else if (spell == 1)
            System.out.println("They were turned to stone!");
        else if (spell == 2)
            System.out.println("They will never find true love!");
        else if (spell == 3)
            System.out.println("Armor reduced by 50%!");
        else if (spell == 4)
            System.out.println("That spell did not work!");


    }
}
