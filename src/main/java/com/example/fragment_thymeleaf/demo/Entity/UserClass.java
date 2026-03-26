package com.example.fragment_thymeleaf.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class UserClass {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long  id;

   @NotBlank(message="It cannot be empty")
   @Size(min=4,message="Username must be 4 characters long")

  @Column(unique=true)
   private String username;
    public UserClass() {
    }
   @Override
   public String toString() {
      return "UserClass [id=" + id + ", username=" + username + ", email=" + email + "]";
   }
   // @Pattern(regexp="[a-zA-Z_/./-]*+[@]+[a-z A-Z]*+/.+[a-z A-Z]{2,3}")
   @Email(message="Enter a valid email")
   @Column(unique=true)
   private String email;
   
   public void setId(Long id) {
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
