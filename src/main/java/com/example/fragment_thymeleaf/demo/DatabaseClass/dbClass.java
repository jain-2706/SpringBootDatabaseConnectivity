package com.example.fragment_thymeleaf.demo.DatabaseClass;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragment_thymeleaf.demo.Entity.UserClass;
import com.example.fragment_thymeleaf.demo.Repository.UserRepository;

@Service
public class dbClass {
    @Autowired
    private UserRepository urepo;

    //Getting The Data
   public List<UserClass>gettingData()
   {
      List<UserClass>li=(List<UserClass>)urepo.findAll();
      if(li.isEmpty())
      {
        return null;
      }
      else
      return li;
   }
   //Getting the Particular User
   public UserClass use(Long id)
   {
    UserClass u1=urepo.findById(id).orElse(null);
    return u1;
   }
   
   
   
   //Posting the Data
   public boolean postData(UserClass u)
   {
      if(urepo.existsByEmail(u.getEmail()))
      {
         return false;
      }
      long a=urepo.count();
      urepo.save(u);
      long b=urepo.count();
      return b==a+1;

   }

   //Deleting the Data
   public boolean deleteUser(Long id)
   {
     if(urepo.existsById(id))
     {
        urepo.deleteById(id);
        return true;
     }
     return false;
   }


   //Updating the Data
   public UserClass updateUser(UserClass u,Long id)
   {
       if(urepo.existsById(id))
       {
       Optional<UserClass> op=urepo.findById(id);
       UserClass u1=op.get();
       u1.setEmail(u.getEmail());
       u1.setUsername(u.getUsername());
      
        return u1;
       }
  return null;
   }

}
