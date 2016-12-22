/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_phase3;

import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Hamsa Saber
 */
public class RegistrationForm {
	Scanner scan = new Scanner(System.in);
    StudentRegistartion register;
    TeacherRegistration register2;

 public String DisplayRF(int t) throws FileNotFoundException{
  String username; String firstname;
  String password; String lastname;
  String Birthdate; int age;
  String mail; String gender;
  String profession;  String stage;
  register = new StudentRegistartion();
  register2 = new TeacherRegistration();
  int x;
  String user = "";
	if(t == 1){
	System.out.print("First Name: ");
	firstname = scan.nextLine();
	register.setFname(firstname);
	System.out.print("Last Name: ");
	lastname = scan.nextLine();
	register.setLname(lastname);
	System.out.print("Username:  ");
	username = scan.nextLine();
    register.setUsername(username);
    System.out.print("Email:  ");
    mail = scan.nextLine();
    register.setEmail(mail);
    System.out.print("Password: ");
    password = scan.nextLine();
    register.setPassword(password);
    System.out.print("Birthdate: ");
    Birthdate = scan.nextLine();
    register.setBdate(Birthdate);
    System.out.print("Gender:  ");
    gender = scan.nextLine();
    register.setGender(gender);
    System.out.print("Studying Stage: ");
    stage = scan.nextLine();
    register.setStudyingstage(stage);
    System.out.print("Age: ");
    age = scan.nextInt();
    register.setAge(age);
    System.out.println("        ");
    System.out.print("Enter 1 if you want to save registration or 2 if you want to cancel process");
     x =scan.nextInt();
     if(x == 1){
    	 register.Save_Registration(register);
     }
     else if(x == 2){
    	 register.Cancel_Registration();
     }
     else{ System.out.print("ERROR");
     }
     user ="student";
    }
  else if(t == 2){
	 System.out.print("First Name: ");
		firstname = scan.next();
		register2.setFname(firstname);
		System.out.print("Last Name: ");
		lastname = scan.next();
		register2.setLname(lastname);
		System.out.print("Username:  ");
		username = scan.next();
	    register2.setUsername(username);
	    System.out.print("Email:  ");
	    mail = scan.next();
	    register2.setEmail(mail);
	    System.out.print("Password: ");
	    password = scan.next();
	    register2.setPassword(password);
	    System.out.print("Birthdate: ");
	    Birthdate = scan.next();
	    register2.setBdate(Birthdate);
	    System.out.print("Age: ");
	    age = scan.nextInt();
	    register2.setAge(age);
	    System.out.print("Gender: " );
	    gender = scan.next();
	    register2.setGender(gender);
	    System.out.print("Profession: ");
	    profession = scan.next();
	    register2.setProfession(profession);
	    System.out.print("Enter 1 if you want to save registration or 2 if you want to cancel process");
	     x =scan.nextInt();
	     if(x == 1){
	    	 register2.Save_Registration(register2);
	     }
	     else if(x == 2){
	    	 register2.Cancel_Registration();
	     }
	     else{ System.out.print("ERROR");
	     }
       user = "teacher" ;     
  }
        return user;
}
}
