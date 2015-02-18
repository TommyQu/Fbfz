package com.softfz.jdbc;

import java.util.List;
import java.util.Map;

import com.softfz.model.PageModel;

/**
 * JDBC数据操作接口,本接口未封装调用存储过程和函数相关操作。 如需调用可根据具体情况调用本接口的getCurrentConnection()方法
 * 或者调用本接口的getNewConnection()方法
 * 
 * @author huihewu
 * @version V1.0
 * @time 2013-1-11 上午10:37:58
 */
public interface JdbcOperator {

	public final static String PAGE_SQL_PRE = "select * from (select m.*,rownum num from (";
	public final static String PAGE_SQL_END = " ) m where rownum<=?) where num>?";

	/**
	 * 查询sql语句返回一个整形结果
	 * 
	 * @param sql
	 *            查询语句
	 * @param params
	 *            语句中对应的参数
	 * @return 查询结果
	 */
	public int queryForInt(String sql, Object... params);

	/**
	 * 查询sql语句返回一个长整形结果
	 * 
	 * @param sql
	 *            查询语句
	 * @param params
	 *            语句中对应的参数
	 * @return
	 */
	public long queryForLong(String sql, Object... params);

	/**
	 * 通用查询1行1列的方法，该方法只取一行一列
	 * 
	 * @param sql
	 *            查询SQL语句
	 * @param elementClass
	 *            需要返回的类型（该类型只能是元素类型，比如：String,数字,时间等）,不可以是自定义类型
	 * @param params
	 *            SQL语句中的参数
	 * @return 查询结果对象
	 */
	public Object queryForObject(String sql, Class elementClass,
			Object... params);

	/**
	 * 根据sql语句查询一行记录，并且把这行记录封装成一个JavaBean对象。 要求查询结果返回的字段名必须和JavaBean中对应的属性名一致
	 * 
	 * @param sql
	 *            查询SQL语句
	 * @param javaBeanClass
	 *            需要封装的JavaBean对象的类型
	 * @param params
	 *            查询SQL语句中的参数名
	 * @return JavaBean对象
	 */
	@SuppressWarnings("unchecked")
	public Object queryForJavaBean(String sql, Class javaBeanClass,
			Object... params);

	/**
	 * 根据SQL语句批量修改数据库
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            sql语句中的参数值
	 * @return 更新数据库表中的行数
	 * @exception 如果更新异常抛出运行时异常
	 */
	public int update(String sql, Object... param);

	/**
	 * 根据SQL语句查询多行记录，并且把一行记录封装成一个JavaBean对象。 要求查询结果返回的字段名必须和JavaBean中对应的属性名一致
	 * 
	 * @param sql
	 *            查询SQL语句
	 * @param javaBeanClass
	 *            需要封装的JavaBean对象的类型
	 * @param params
	 *            查询SQL语句中的参数名
	 * @return JavaBean对象集合
	 */
	@SuppressWarnings("unchecked")
	public List queryForJavaBeanList(String sql, Class javaBeanClass,
			Object... params);

	/**
	 * 查询返回列表，将列表中的没一行封装成一个Map,key为字段名（小写）,value为字段值
	 * 
	 * @param sql
	 *            查询SQL语句
	 * @param params
	 *            查询语句中的参数
	 * @return map集合
	 */
	public List<Map<String, String>> queryForList(String sql, Object... params);

	/**
	 * 查询多行一列数据
	 * 
	 * @param sql
	 *            查询语句
	 * @param elementClass
	 *            需要将该列转换成需要的数据类型
	 * @param params
	 *            查询SQL语句中的参数
	 * @return elementClass 对象集合
	 */
	public List queryForList(String sql, Class elementClass, Object... params);
	/**
	 * 分页查询方法，将查询结果封装成分页数据模型
	 * @param querySql 查询语句，不带查询条件
	 * @param countSql 计算总记录数语句，不带查询条件
	 * @param whereSql 查询条件
	 * @param orderSql 排序语句
	 * @param paramList 参数列表，条件语句中的"?"对应的值
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条数
	 * @param javaBeanClass 分页模型中的result集合中需要存放的JavaBean类型
	 * @return 分页数据模型
	 */
	public PageModel queryPagModel(StringBuilder querySql,
			StringBuilder countSql, StringBuilder whereSql,
			StringBuilder orderSql, List paramList, int currentPage,
			int pageSize, Class javaBeanClass);

}
