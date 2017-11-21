package bz.beppe.iservice;

import java.util.List;

import bz.beppe.entity.Country;
import bz.beppe.entity.User;

public interface UserService {

	int saveUser(Country country,User user);
	
	int insertUser(User user);
	
	User getUser(String  code);
	
	List<User> getUserList(String code);
	
	
    
}
