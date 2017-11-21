package bz.beppe.iservice;

import java.util.Set;

import bz.beppe.entity.TUser;

public interface TUserService {

	Set<String> findRoles(String userName);
    
	Set<String> findPermissions(String userName);
	
	TUser findUserByUsername(String userName);
	
	
}
