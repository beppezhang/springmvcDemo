package bz.beppe.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import bz.beppe.dao.TUserMapper;
import bz.beppe.entity.TUser;
import bz.beppe.iservice.TUserService;
@Service("tUserService")
public class TUserServiceImpl implements TUserService{

	@Resource
	private TUserMapper tUserMapper;
	
	@Override
	public Set<String> findRoles(String userName) {
		return tUserMapper.findRoles(userName);
	}

	@Override
	public Set<String> findPermissions(String userName) {
		return tUserMapper.findPermissions(userName);
	}

	@Override
	public TUser findUserByUsername(String userName) {
		
		return tUserMapper.findUserByUsername(userName);
	}

}
