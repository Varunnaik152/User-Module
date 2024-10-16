package com.tns_b83;
import java.util.*;

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

 
@RestController 
public class UserControler {
	 @Autowired 
	 private UserService service; 
	    // RESTful API methods for Retrieval operations 
	    @GetMapping("/users") 
	    public List<UserEntity> list()  
	    { 
	        return service.listAll(); 
	    } 
	    @GetMapping("/users/{id}") 
	    public ResponseEntity<UserEntity> get(@PathVariable Integer id)  
	    { 
	        try  
	        { 
	        	UserEntity users1 = service.get(id); 
	            return new ResponseEntity<UserEntity>(users1, HttpStatus.OK); 
	        }  
	        catch (NoSuchElementException e)  
	        { 
	            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND); 
	        }       
	    } 
	    // RESTful API method for Create operation 
	    @PostMapping("/users") 
	    public void add(@RequestBody UserEntity users1)  
	    { 
	        service.save(users1); 
	    } 
	      
	    // RESTful API method for Update operation 
	    @PutMapping("/users/{id}") 
	    public ResponseEntity<?> update(@RequestBody UserEntity users1, @PathVariable Integer id)  
	    { 
	        try  
	        { 
	            UserEntity existusers = service.get(id); 
	            service.save(users1); 
	            return new ResponseEntity<>(HttpStatus.OK); 
	        }  
	        catch (NoSuchElementException e)  
	        { 
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	        }       
	    } 
	    // RESTful API method for Delete operation 
	    @DeleteMapping("/users/{id}") 
	    public void delete(@PathVariable Integer id)  
	    { 
	        service.delete(id); 
	    } 
}
