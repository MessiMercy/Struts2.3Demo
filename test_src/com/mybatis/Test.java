package com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.inter.IUserOperation;

public class Test {
	private static SqlSessionFactory factory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			setFactory(new SqlSessionFactoryBuilder().build(reader));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SqlSession session = factory.openSession();
		IUserOperation operation = session.getMapper(IUserOperation.class);
		User addUser = new User();
		addUser.setUserAddress("chengdu.sichuan");
		addUser.setUserAge("25");
		addUser.setUserName("mybatis");
		operation.inserUser(addUser);
		session.commit();
		System.out.println("auto generated keys id = " + addUser.getId());
		// User user = operation.selectUserByID(1);
		List<User> list = operation.selectUsers("%");
		// User user =
		// session.selectOne("com.mybatis.UserMapper.selectUserByID", 1);
		// System.out.println(user.getUserName() + ": " +
		// user.getUserAddress());
		for (User user : list) {
			System.out.println("userId = " + user.getId());
			System.out.println(user.getUserName() + ": " + user.getUserAddress());

		}
		session.close();
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SqlSessionFactory factory) {
		Test.factory = factory;
	}

}
