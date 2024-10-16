package com.tns_b83;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
@Service

public class UserService {
	
	
		 @Autowired 
		    private UserRepository repo; 
		      
		    public List<UserEntity> listAll()  
		    { 
		        return repo.findAll(); 
		    } 
		      
		    public void save(UserEntity users1)  
		    { 
		        repo.save(users1); 
		    } 
		      
		    public UserEntity get(Integer id)  
		    { 
		        return repo.findById(id).get(); 
		    } 
		      
		    public void delete(Integer id)  
		    { 
		        repo.deleteById(id); 
		    }
	}

	

