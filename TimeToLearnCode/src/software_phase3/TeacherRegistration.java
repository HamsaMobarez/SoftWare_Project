/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_phase3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Hamsa Saber
 */
public class TeacherRegistration {
    private String Fname ;
	private String Lname;
	private String Username;
	private String Password;
	private String Bdate; 
	private String Email;
	private int Age;
	private String Gender;
	private DataBase DB;
        private String profession;
	private String certificate;
        public void setCertificate(String cert){
            certificate = cert;
        }
        public String getCertificate(){
            return certificate;
        }
        public void setProfession(String prof){
            profession = prof;
        }
        public String getProfession(){
            return profession;
        }
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getBdate() {
		return Bdate;
	}
	public void setBdate(String bdate) {
		Bdate = bdate;
	}
	public String getEmail() { 
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
        public void setGender(String g){
            Gender = g;
        }
        public String getGender(){
            return Gender;
        }
       
            
           public void Save_Registration(TeacherRegistration t) throws FileNotFoundException{
             PrintStream PS = new PrintStream(new FileOutputStream ("Accounts.txt"),true);
        PS.println("Username:" +"\t"+t.getUsername() + "\t"+"Password:"+"\t" + t.getPassword() + "\t"+"teacher"); 
              System.out.println("Successful Registration");
        }
        public void Cancel_Registration(){
                    
                }
}
