package com.softfz.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.objectweb.asm.xwork.tree.IntInsnNode;

import com.softfz.jdbc.impl.JdbcOperatorImpl;
import com.softfz.jdbc.impl.TransactionManagerImpl;

/**
 * JDBC工具类,该类负责JDBC相关操作接口的初始化操作
 * 
 * @author huihewu
 * 
 */
public class JdbcUtils {
	private static DataSource dataSource;
	private static JdbcOperator jdbcOperator;
	private static TransactionManager transactionManager;
	static {
		initDataSource();// 初始化连接池数据源
	}

	private JdbcUtils() {
	}

	private static void initDataSource() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context
					.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static JdbcOperator getJdbcOperator() {
		if (jdbcOperator == null) {
			jdbcOperator = new JdbcOperatorImpl(dataSource);
		}
		return jdbcOperator;
	}

	public static TransactionManager getTransactionManager() {
		if (transactionManager == null) {
			transactionManager = new TransactionManagerImpl();
		}
		return transactionManager;
	}
}
