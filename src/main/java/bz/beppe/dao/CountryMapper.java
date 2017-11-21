package bz.beppe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bz.beppe.entity.Country;

public interface CountryMapper {
	
	Country selectById(@Param("code") String code);
	
	int insert(Country country);

	int update(@Param("add")int add,@Param("id")String id,@Param("score")int score);
	
	List<Country> selectCountris();
}