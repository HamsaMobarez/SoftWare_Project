/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_phase3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hamsa Saber
 */
public class Game {
    Scanner scan =  new Scanner(System.in);
    private String name;
    private String type;
    private String category;
    private String difficulty;
    private int num_of_levels;
    ArrayList<Game>games = new ArrayList<Game>();
    DataBase db ;
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setType(String t){
        type  = t;
    }
    public String getType(){
        return type;
    }
    public void setCategory(String Categ){
        category = Categ;
    }
    public String getCtegory(){
        return category;
    }
    public void setDiff(String diff){
        difficulty = diff;
    }
    public String getDiff(){
        return difficulty;
    }
    public void setNum_of_levels(int l){
        num_of_levels = l;
    }
    public int getNum_of_levels(){
        return num_of_levels;
    }
    public int PlayGame(Game mygame) throws FileNotFoundException, IOException{
        String categ =mygame.getCtegory();
        String n = mygame.getName();
        BufferedReader brr = new BufferedReader(new FileReader(n+".txt"));
        String type = brr.readLine();
        String  l = brr.readLine().charAt(0)+"";
        int levels  = Integer.valueOf(l);
        int score = 0;
       String answer;
        if( "m".equals(type) ||"tf".equals(type)){
            for(int i = 0 ; i < levels ; i++){
                String question = brr.readLine();
                String choice1 = brr.readLine();
                String choice2 = brr.readLine();
                String correctanswer = brr.readLine();
                System.out.println(question);
                System.out.println(choice1);
                System.out.println(choice2);
                System.out.println("Enter your answer: ");
                answer = scan.next();
                if(answer.equals(correctanswer)){
                    score++;
                }
                System.out.println("if continue enter 1 if you want to finish game enter 2 : ");
                int value = scan.nextInt();
                if(value == 1){
                    
                }
                else if(value == 2){
                    score = FinishGame(score);
                    i = levels;
                }
            }
        }
    return score;
}
    public void Start_the_tutorial(Game game) throws FileNotFoundException, IOException{
        int choice;
        boolean EOF = true;
        BufferedReader br2 = new BufferedReader(new FileReader(game.getName()+"tutorial.txt"));
       EOF = true;
       while(EOF){
           String line = br2.readLine();
           if(line != null){
              System.out.println(line); 
           }
           else{
               EOF = false;
           }
       } 
       System.out.print("Enter 1 if you want to skip the tutorial and playgame: ");
       choice = scan.nextInt();
       if(choice == 1){
           game.PlayGame(game);
            
       }
    } 
    public int FinishGame(int score){
        System.out.println("Score= " + score); 
        return score;
    
        
    }
    public void RateGame(){
        System.out.println("Rate the game (from 1 to 10): ");
        int rate = scan.nextInt();
        System.out.println("Thank you for  rating our game :D");
    }
    public void CreateGame() throws IOException{
        Game newgame = new Game();
       // String filename = "";
       // File file = new File(filename);
        
        System.out.println("Choose subject Category : ");
        System.out.println("1-Math");
        System.out.println("2-Science");
        System.out.println("3-Basic Programming");
        System.out.println("4-Technology");
        System.out.print("Enter your choice number: ");
        String Category  = scan.next();
        newgame.setCategory(Category);
        System.out.println("Choose Game type:");
        System.out.println("1-Multiple Choice");
        System.out.println("2-True OR False");
        System.out.print("Enter your choice number: ");
        String type = scan.next();
        newgame.setType(type);
        System.out.print("Enter Game Name: ");
        String n = scan.next();
        newgame.setName(n);
        File file = new File(n+".txt");
        file.createNewFile();
        System.out.print("Enter Game Difficulty: ");
        String d =  scan.next();
        newgame.setDiff(d);
        System.out.print("Enter Game Levels: ");
        int level = Integer.parseInt(scan.next());
        newgame.setNum_of_levels(level);
        
        PrintStream bw1 =  new PrintStream(new FileOutputStream(n+".txt"));
        if("1".equals(type)){
            type = "m";
        }
        else if("2".equals(type)){
            type = "tf";
        }
        bw1.println(type);
        bw1.println(level);
        if("1".equals(newgame.getType())){
             PrintStream bw =  new PrintStream(new FileOutputStream(n+".txt"));
            for(int i = 0 ; i < level ; i++){
                Scanner scan2 = new Scanner(System.in);
                System.out.print("Enter question:");
                String question = scan2.nextLine();
                bw.println(question);
                System.out.println("Enter Choice1: ");
                String choice1 = scan2.next();
                bw.println(choice1);
                System.out.println("Enter choice2: ");
                String choice2 = scan2.next();
                bw.println(choice2);
                System.out.println("Correct answer: ");
                String correctanswer = scan2.next();
                bw.println(correctanswer);
            }
        }
        if("2".equals(newgame.getType())){
            PrintStream bw =  new  PrintStream(new FileOutputStream(n+".txt" , true));
            for(int i = 0 ; i < newgame.getNum_of_levels() ; i++){
                Scanner scan1 =  new Scanner(System.in);
                System.out.print("Enter question: ");
                String question = scan1.nextLine();
                bw.println(question);
                bw.println("true");
                bw.println("false");
                System.out.println("Correct answer: ");
                String correctanswer = scan1.next();
                bw.println(correctanswer);
            }
        }
        System.out.print("If you want to save game enter 1 Cancel enter 2: ");
        int c = scan.nextInt();
        if(c == 1){
            db = new DataBase();
            db.AddGame(newgame.getName(), newgame.getCtegory());
            System.out.println("Game Successfully Added");
        }
        else if(c == 2){
            file.delete();
            System.out.println("process Cancelled");
        }
    }
}