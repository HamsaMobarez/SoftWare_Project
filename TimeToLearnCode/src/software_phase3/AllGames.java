/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_phase3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hamsa Saber
 */
public class AllGames {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Game>mygames = new ArrayList<Game>();
    public void set_mygames(Game game){
        mygames.add(game);
    }
    public Game Display_Category_Games(int categ) throws FileNotFoundException, IOException{
        if(categ == 1){
            BufferedReader br =  new BufferedReader(new FileReader("math.txt"));
            boolean EOF = true;
            while(EOF){
                String line = br.readLine();
                if(line != null){
                    Game g = new Game();
                    g.setName(line);
                    g.setCategory("1");
                    mygames.add(g);
                }
                else{
                    EOF = false;
                }
            }
        }
        else if(categ == 2){
             BufferedReader br =  new BufferedReader(new FileReader("science.txt"));
            boolean EOF = true;
            while(EOF){
                String line = br.readLine();
                if(line != null){
                    Game g = new Game();
                    g.setName(line);
                    g.setCategory("2");
                    mygames.add(g);
                }
                else{
                    EOF = false;
                }
            }
        }
         else if(categ == 3){
             BufferedReader br =  new BufferedReader(new FileReader("programming.txt"));
            boolean EOF = true;
            while(EOF){
                String line = br.readLine();
                if(line != null){
                    Game g = new Game();
                    g.setName(line);
                    g.setCategory("3");
                    mygames.add(g);
                }
                else{
                    EOF = false;
                }
            }
        }
         else if(categ == 4){
             BufferedReader br =  new BufferedReader(new FileReader("technology.txt"));
            boolean EOF = true;
            while(EOF){
                String line = br.readLine();
                if(line != null){
                    Game g = new Game();
                    g.setName(line);
                    g.setCategory("4");
                    mygames.add(g);
                }
                else{
                    EOF = false;
                }
            }
         }
        int num = 0;
        for(int i = 0 ; i < mygames.size() ; i++){
            String x = mygames.get(i).getName();
            System.out.println((i+1)+"-"+x);
            }
        System.out.print("Enter Game number: ");
            num = scan.nextInt();
            Game gg = mygames.get(num-1);
        return gg;
    }
    public int Display_Categories_List(){
        System.out.println("Subject categories: ");
        System.out.println("1-Math");
         System.out.println("2-Science");
          System.out.println("3-programming");
           System.out.println("4-Technology");
           System.out.print("Enter Category number you want: ");
           int cnum = scan.nextInt();
           return cnum;
    }
}
