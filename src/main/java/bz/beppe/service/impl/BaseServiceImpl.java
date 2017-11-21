package bz.beppe.service.impl;

import bz.beppe.CommonException;
import bz.beppe.iservice.BaseService;

public class BaseServiceImpl implements BaseService{
	
	
	@Override
	public void thrown(String code, String mess) throws Exception {
		new CommonException(code,mess);
		return;
	}


}
