package com.example.fragment_thymeleaf.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fragment_thymeleaf.demo.DatabaseClass.dbClass;
import com.example.fragment_thymeleaf.demo.Entity.UserClass;





@RestController
public class controller {

    @Autowired
    private dbClass db;

    @GetMapping("/project")
    public ResponseEntity<List<UserClass>> Data()
    {
        List<UserClass>li=new ArrayList<>();
        li.add(new UserClass("Raju", "aaa@gmail.com"));
        if(db.gettingData()==null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(li);
        }
        return ResponseEntity.status(HttpStatus.OK).body(db.gettingData());
    }
    @GetMapping("/particular/{id}")
    public ResponseEntity<UserClass>User(@PathVariable String id)
    {
       UserClass u1=db.use(id);
       if(u1==null)
       {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       else
       {
          return ResponseEntity.status(HttpStatus.OK).body(u1);
       }

    }
    @PostMapping("/post")
    public ResponseEntity<String> postMethodName(@RequestBody UserClass u) {
        boolean f=db.postData(u);
        if(f==false)
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not Created");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> delete(String id)
    {
        boolean f=db.deleteUser(id);
        if(f==true)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Deleted");
        }
        else
        {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't Delete User");
        }
    }
    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserClass> updateData(@PathVariable String id, @RequestBody UserClass u) {
       UserClass u1=db.updateUser(u, id);
       if(u1==null)
       {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
        
        return ResponseEntity.status(HttpStatus.OK).body(u1);
    }
    
    
}
