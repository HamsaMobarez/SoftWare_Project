/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_phase3;

/**
 *
 * @author Hamsa Saber
 */
public class Login {
    String Username;
    String Password;
    public void set_Username(String user){
        Username = user;
    }
    public void set_Password(String pass){
        Password = pass;
    }
    public String getUsername(){
        return Username;
    }
    public String getPassword(){
        return Password;
    }
    
}
