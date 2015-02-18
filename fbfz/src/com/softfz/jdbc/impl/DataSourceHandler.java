package com.softfz.jdbc.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.softfz.jdbc.FBSQLException;
import com.softfz.jdbc.JdbcUtils;

class DataSourceHandler {
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	static void beginTransaction() {
		DataSource dataSource = JdbcUtils.getDataSource();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new FBSQLException(e.getMessage());
		}
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				throw new FBSQLException(e.getMessage());
			}
			local.set(conn);// 保存到线程变量中
		}
	}

	static void endTransaction() {
		Connection conn = local.get();
		if (conn != null) {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				throw new FBSQLException(e.getMessage());
			}

			local.set(null);
		}
	}

	static void commit() {
		Connection conn = local.get();
		if (conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				throw new FBSQLException(e.getMessage());
			}
		}
	}

	static void rollback() {
		Connection conn = local.get();
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new FBSQLException(e.getMessage());
			}
		}
	}

	/**
	 * 获取数据库连接Connection对象,如果外部有开启事务。使用外部开启事务的连接。 如果外部没有开启事务，则使用重新从连接池中获取一个新的连接
	 * 
	 * @param dataSource
	 *            数据源
	 * @return 数据库连接对象Connection
	 * @throws SQLException
	 */
	static Connection getConnection(DataSource dataSource) throws SQLException {
		Connection conn = local.get();
		if (conn != null) {
			return conn;// 使用外部开启事务的时候用到的连接
		} else {
			// 重新获取一个连接
			return dataSource.getConnection();
		}
	}

	public static void closeDB(Connection conn) {
		if (local.get() == null) {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}
}
