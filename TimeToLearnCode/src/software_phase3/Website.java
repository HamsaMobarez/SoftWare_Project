/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_phase3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Hamsa Saber
 */
public class Website{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Scanner scan =  new Scanner(System.in);
       RegistrationForm RF;
       Login login = null ;
       DataBase database =  new DataBase();
       AllGames games = new AllGames();
       String myuser = null;
       Game the_game = new Game();
        System.out.print("Enter 1 if Register Or 2 if Login: ");
        int x = scan.nextInt();
        if(x == 1){
            int type;
            System.out.print("Enter 1 if Regsiter as Student Or 2 if Register as Teacher: ");
            type = scan.nextInt();
            RF = new RegistrationForm();
            myuser =RF.DisplayRF(type);
            System.out.print(myuser);
        }
       if(x == 2){
           System.out.print("UserName: ");
           String username = scan.next();
           //System.out.println("  ");
           System.out.print("Password: ");
           String password = scan.next();
           login = new Login();
           database = new DataBase();
           login.set_Username(username);
           login.set_Password(password);
           boolean validation= database.Validate(login);
           if(validation == true) { System.out.println("Successfully Logged IN");
           myuser = database.User_Type(login);
           //System.out.print(myuser);
           }
           else if(validation == false){
           System.out.println("Wrong Username Or Password");
           System.out.print("UserName: ");
           username = scan.next();
           //System.out.print("Password: ");
           password = scan.next();
           login.set_Username(username);
           login.set_Password(password);
           validation= database.Validate(login);
           if(validation == true) { System.out.println("Successfully Logged IN");
           myuser = database.User_Type(login);
           
           }
           }
       }
       if("student".equals(myuser)){
           System.out.println("Hello Welcome to our Website :D");
           System.out.println("Enter 1 if you want to view Games");
           int option = scan.nextInt();
           if(option == 1){
               int choice= games.Display_Categories_List();
             the_game =   games.Display_Category_Games(choice);
             System.out.print("Enter 1 if you want to play Tutorial OR 2 if you want to play game: ");
             option = scan.nextInt();
             if(option == 1){
                 the_game.Start_the_tutorial(the_game);
                 the_game.RateGame();
             }
             else if(option == 2){
                 int result =the_game.PlayGame(the_game);
                 database.Add_To_Acheivments(result,login.getUsername());
                 the_game.RateGame();
             }
           }
       }
       if("teacher".equals(myuser)){
          System.out.println("Hello Welcome to our Website :D");
          System.out.println("Enter 1 if you want to Create new Game and 2 if you want to play Game");
          int option = scan.nextInt();
          if(option == 1){
              the_game.CreateGame();
          }
          if(option == 2){
            int choice= games.Display_Categories_List();
             the_game =   games.Display_Category_Games(choice);
             System.out.print("Enter 1 if you want to play Tutorial OR 2 if you want to play game: ");
             option = scan.nextInt();
             if(option == 1){
                 the_game.Start_the_tutorial(the_game);
                 the_game.RateGame();
             }
             else if(option == 2){
                 int result =the_game.PlayGame(the_game);
                 database.Add_To_Acheivments(result,login.getUsername());
                 the_game.RateGame();
             }
           }
        }
    }
    
    
}
