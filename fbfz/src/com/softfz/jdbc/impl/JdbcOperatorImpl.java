package com.softfz.jdbc.impl;

import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;

import com.softfz.jdbc.FBSQLException;
import com.softfz.jdbc.JdbcOperator;
import com.softfz.model.PageModel;
import com.sun.xml.internal.bind.v2.util.DataSourceSource;

/**
 * jdbc数据操作接口实现类
 * 
 */
public class JdbcOperatorImpl implements JdbcOperator {

	private DataSource dataSource;

	public JdbcOperatorImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int queryForInt(String sql, Object... params) {

		if(this.queryForObject(sql, Integer.class, params)!=null){
			return (Integer) this.queryForObject(sql, Integer.class, params);
		}
		return 0;
	}

	public long queryForLong(String sql, Object... params) {
		if(this.queryForObject(sql, Long.class, params)!=null){
			return (Long) this.queryForObject(sql, Long.class, params);
		}
		return 0;
	}

	public Object queryForObject(String sql, Class elementClass,
			Object... params) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DataSourceHandler.getConnection(this.dataSource);
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
		//			System.out.println(params[i].toString());
				}
			}
	//		System.out.println(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return getColValue(elementClass, rs, 1);
			}

		} catch (Exception e) {
			throw new FBSQLException(e.getMessage());
		} finally {
			closeDB(conn, pst, rs);
		}
		//System.out.println("shitshitshit.......");
		return null;
	}

	private void closeDB(Connection conn, PreparedStatement pst, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
			}
		}
		DataSourceHandler.closeDB(conn);
	}

	private Object getColValue(Class elementClass, ResultSet rs, int index)
			throws SQLException {
		Object value = null;
		boolean needCheckNull = false;
		if (elementClass.equals(String.class)) {
			value = rs.getString(index);
		} else if (elementClass.equals(int.class)
				|| elementClass.equals(Integer.class)) {
			value = new Integer(rs.getInt(index));
			needCheckNull = true;
		} else if (elementClass.equals(long.class)
				|| elementClass.equals(Long.class)) {
			value = new Long(rs.getLong(index));
			needCheckNull = true;
		} else if (elementClass.equals(double.class)
				|| elementClass.equals(Double.class)) {
			value = new Double(rs.getDouble(index));
			needCheckNull = true;
		} else if (elementClass.equals(float.class)
				|| elementClass.equals(Float.class)) {
			value = new Float(rs.getFloat(index));
			needCheckNull = true;
		} else if (elementClass.equals(short.class)
				|| elementClass.equals(Short.class)) {
			value = new Short(rs.getShort(index));
			needCheckNull = true;
		} else if (elementClass.equals(byte.class)
				|| elementClass.equals(Byte.class)) {
			value = new Byte(rs.getByte(index));
			needCheckNull = true;
		} else if (elementClass.equals(java.sql.Time.class)) {
			value = rs.getTime(index);
		} else if (elementClass.equals(java.sql.Date.class)) {
			value = rs.getDate(index);
		} else if (elementClass.equals(java.sql.Timestamp.class)) {
			value = rs.getTimestamp(index);
		} else if (elementClass.equals(java.util.Date.class)) {
			Timestamp tmp = rs.getTimestamp(index);
			if (tmp != null) {
				value = new java.util.Date(tmp.getTime());
			}
		} else if (elementClass.equals(Blob.class)) {
			value = rs.getBlob(index);
		} else if (elementClass.equals(Clob.class)) {
			value = rs.getClob(index);
		} else {
			value = rs.getObject(index);
		}
		if (value != null && needCheckNull && rs.wasNull()) {
			value = null;
		}
		return value;
	}

	public Object queryForJavaBean(String sql, Class javaBeanClass,
			Object... params) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DataSourceHandler.getConnection(this.dataSource);
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			rs = pst.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int colcount = metaData.getColumnCount();

			if (rs.next()) {
				Object bean = javaBeanClass.newInstance();
				for (int i = 1; i <= colcount; i++) {
					String colname = metaData.getColumnName(i).toLowerCase();
					// 获取该字段在JavaBean中的类型
					Class elementClass = getPropertyType(bean, colname);
					if (elementClass == null) {
						continue;
					}
					// 获取字段的值，并且将类型转换成javaBean中的类型
					Object value = getColValue(elementClass, rs, i);
					if (value != null) {
						BeanUtils.setProperty(bean, colname, value);
					}
				}
				return bean;
			}
		} catch (Exception e) {
			throw new FBSQLException(e.getMessage());
		} finally {
			closeDB(conn, pst, rs);
		}
		return null;
	}

	private Class getPropertyType(Object bean, String colname) {
		if (colname == null || colname.trim().length() <= 0)
			return null;
		String setMdName = "set" + colname.substring(0, 1).toUpperCase()
				+ colname.substring(1);
		Method[] mds = bean.getClass().getMethods();
		if (mds != null) {
			for (int i = 0; i < mds.length; i++) {
				Method md = mds[i];
				if (md.getName().equals(setMdName)) {
					Class[] paramTypes = md.getParameterTypes();
					if (paramTypes != null && paramTypes.length == 1) {
						return paramTypes[0];
					}
				}
			}
		}
		return null;
	}

	public int update(String sql, Object... param) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DataSourceHandler.getConnection(this.dataSource);
			pst = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pst.setObject(i + 1, param[i]);
				}
				//System.out.println();
			}
			return pst.executeUpdate();
		} catch (Exception e) {
			throw new FBSQLException(e.getMessage());
		} finally {
			closeDB(conn, pst, null);
		}
	}

	public List queryForJavaBeanList(String sql, Class javaBeanClass,
			Object... params) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			conn = DataSourceHandler.getConnection(this.dataSource);
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			rs = pst.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int colcount = metaData.getColumnCount();

			while (rs.next()) {
				Object bean = javaBeanClass.newInstance();
				for (int i = 1; i <= colcount; i++) {
					String colname = metaData.getColumnName(i).toLowerCase();
					// 获取该字段在JavaBean中的类型
					Class elementClass = getPropertyType(bean, colname);
					if (elementClass == null) {
						continue;
					}
					// 获取字段的值，并且将类型转换成javaBean中的类型
					Object value = getColValue(elementClass, rs, i);
					if (value != null) {
						BeanUtils.setProperty(bean, colname, value);
					}
				}
				list.add(bean);
			}
		} catch (Exception e) {
			throw new FBSQLException(e.getMessage());
		} finally {
			closeDB(conn, pst, rs);
		}
		return list;
	}

	public List<Map<String, String>> queryForList(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			conn = DataSourceHandler.getConnection(this.dataSource);
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			rs = pst.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int colcount = metaData.getColumnCount();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 1; i <= colcount; i++) {
					String key = metaData.getColumnName(i).toLowerCase();
					String value = rs.getString(i);
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (Exception e) {
			throw new FBSQLException(e.getMessage());
		} finally {
			closeDB(conn, pst, rs);
		}
		return list;
	}

	public List queryForList(String sql, Class elementClass, Object... params) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			conn = DataSourceHandler.getConnection(this.dataSource);
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(getColValue(elementClass, rs, 1));
			}
		} catch (Exception e) {
			throw new FBSQLException(e.getMessage());
		} finally {
			closeDB(conn, pst, rs);
		}
		return list;
	}

	public PageModel queryPagModel(StringBuilder querySql,
			StringBuilder countSql, StringBuilder whereSql,
			StringBuilder orderSql, List paramList, int currentPage,
			int pageSize, Class javaBeanClass) {
		int allCount = 0;
		// 计算总记录数
		countSql.append(whereSql);
		allCount = queryForInt(countSql.toString(), paramList.toArray());
		// 查询分页结果
		querySql.append(whereSql);
		if (orderSql != null) {
			querySql.append(orderSql);
		}
		querySql.insert(0, PAGE_SQL_PRE);
		querySql.append(PAGE_SQL_END);
		// 考虑边界值问题
		if (currentPage <= 0)
			currentPage = 1;// 最小值
		int allPage = (allCount - 1) / pageSize + 1;
		if (currentPage > allPage) {
			currentPage = allPage;// 最大值
		}
		paramList.add(currentPage * pageSize);
		paramList.add((currentPage - 1) * pageSize);
		List result = queryForJavaBeanList(querySql.toString(), javaBeanClass,
				paramList.toArray());
		PageModel pageModel = new PageModel();
		pageModel.setCurrentPage(currentPage);
		pageModel.setPageSize(pageSize);
		pageModel.setAllCount(allCount);
		pageModel.setResult(result);
		return pageModel;
	}

}
