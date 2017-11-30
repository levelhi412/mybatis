package com.levelhi;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserTest {

	public static void main(String[] args) throws IOException {
		
		Reader reader = Resources.getResourceAsReader("conf.xml");
		
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sessionFactory.openSession();
		
		String statement = "mapper.userMapper" + ".getUser";
		User user = sqlSession.selectOne(statement, 2);
		
		System.out.println(user);
	}
}
