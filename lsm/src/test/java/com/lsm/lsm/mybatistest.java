package com.lsm.lsm;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatistest  {
	
	public void gettingStart() throws Exception{
	String resource = "com/lsm/lsm/mybatis-config.xml";
	InputStream inputStream = Resources.getResourceAsStream(resource);
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	SqlSession session = sqlSessionFactory.openSession();
	try {
	  BlogMapper mapper = session.getMapper(BlogMapper.class);
	  Blog blog = mapper.selectBlog(101);
	} finally {
	  session.close();
	}
	
	}
		
}
