package com.example.fragment_thymeleaf.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserClass {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private String id;
   private String username;

    public UserClass() {
    }
   @Override
   public String toString() {
      return "UserClass [id=" + id + ", username=" + username + ", email=" + email + "]";
   }
   private String email;

   public void setId(String id) {
      this.id = id;
   }
   public UserClass(String username, String email) {
      this.username = username;
      this.email = email;
   }
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }   
}
