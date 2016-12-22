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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *
 * @author Hamsa Saber
 */
public class DataBase {
    Scanner scan = new Scanner(System.in);
    private static ArrayList<String>Passwords = new ArrayList<String>();
    private static ArrayList<String>Users =  new ArrayList<String>();
    public void Create_Users_Passwords() throws FileNotFoundException, IOException{
        BufferedReader BR = new BufferedReader (new FileReader("Accounts.txt"));
        boolean EOF = true;
        int  i = 0;
        while(EOF){
            String line = BR.readLine();
            if(line != null){
                StringTokenizer breakline =  new StringTokenizer(line);
                String temp1 = breakline.nextToken();
                String user = breakline.nextToken();
                String temp2 = breakline.nextToken();
                String pass = breakline.nextToken();
                String temp3 = breakline.nextToken();
                Users.add(user);
                Passwords.add(pass);
                i++;
            }
            else {
                EOF = false;
            }
        }
    }
    public boolean Validate(Login login) throws IOException{
        Create_Users_Passwords();
        if(Users.contains(login.getUsername()) && Passwords.contains(login.getPassword())){
            return true;       
    }
        else{
            return false;
        }
    }
    public String User_Type(Login login) throws FileNotFoundException, IOException{
        BufferedReader BR = new BufferedReader (new FileReader("Accounts.txt"));
        boolean EOF = true;
        String result = "";
        while(EOF){
            String line = BR.readLine();
            if(line != null){
                StringTokenizer breakline =  new StringTokenizer(line);
                String temp1 = breakline.nextToken();
                String user = breakline.nextToken();
                String temp2 = breakline.nextToken();
                String pass = breakline.nextToken();
                String usertype = breakline.nextToken();
               // System.out.print("dakhlet function el user" + user+"  ");
                if(login.getUsername().equals(user)){
                   // System.out.println("dakhlet el if");
                    result = usertype;
                }
            }
            else {
                EOF = false;
            }
        }
        return result;
    }
   public void  Add_to_accounts1(StudentRegistartion R) throws FileNotFoundException{
            
      PrintStream PS = new PrintStream(new FileOutputStream ("Accounts.txt"));
      PS.println("Username:" +"\t"+R.getUsername() + "\t"+"Password:"+"\t" + R.getPassword());
   }
  
    public void  Add_to_accounts2( TeacherRegistration r) throws FileNotFoundException{
       
    	 PrintStream PS = new PrintStream(new FileOutputStream ("Accounts.txt"));
      PS.println("Username:" +"\t"+r.getUsername() + "\t"+"Password:"+"\t" + r.getPassword());   
   }
   public void display_Game(Game game) throws FileNotFoundException, IOException{
       String c = game.getCtegory();
       String name = game.getName();
       BufferedReader br = new BufferedReader(new FileReader("startpage.txt"));
       boolean EOF = true;
       while(EOF){
           String line = br.readLine();
           if(line != null){
              System.out.println(line); 
           }
       }
       int choice = scan.nextInt();
       if(choice == 1){
           game.PlayGame(game);
       }
       else if(choice == 2){
         game.Start_the_tutorial(game);
       }
   }
   public void AddGame(String gamename , String category) throws IOException{
       //game = game2;
        String filename = "";
        
        if("1".equals(category)){
           filename = "math.txt";
        }
        else if("2".equals(category)){
            filename = "science.txt";
        }
        else if("3".equals(category)){
            filename = "programming.txt";
        }
        else if("4".equals(category)){
            filename = "technology.txt";
        }
        PrintStream bw =  new  PrintStream(new FileOutputStream(filename , true));
        bw.println(gamename);
   }
   public void Add_To_Acheivments(int Score,String user) throws FileNotFoundException, IOException{
       BufferedReader br2 = new BufferedReader(new FileReader("acheivments.txt"));
       PrintStream PS = new PrintStream(new FileOutputStream("acheivments.txt",true));
       PS.println(user+"\t"+Score);
   }
}

