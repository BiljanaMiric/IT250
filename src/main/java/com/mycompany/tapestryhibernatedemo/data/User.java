/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.data;

import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author blah
 */
public class User {
    private String Name;
    private String Surname;
    private String Address;
    private String passportNumber;
    private String email;
    private String password;
    
    @Inject
    public User () {}
        public User (String Name, String Surname,String Address, String passportNumber, String email,
                String password) {
            this.Name=Name;
            this.Surname=Surname;
            this.Address=Address;
            this.passportNumber=passportNumber;
            this.email=email;
            this.password=password;
        }
        
        public String getName (){
            return Name;
        }
        public void setName(String Name){
            this.Name=Name;
            
        }
        public String getSurname(){
            return Surname;
        }
        public void setSurname (String Surname){
        this.Surname=Surname;
    }
        public String getAddress(){
            return Address;
        }
        public void setAddress (String Address) {
                this.Address=Address;
        }
        public String getemail (){
            return email;
        }
        public void setemail (String email) {
            this.email=email;
        }
        public String getpassword (){
            return password;
        }
        public void setpassword(String password){
            this.password=password;
        }
}
