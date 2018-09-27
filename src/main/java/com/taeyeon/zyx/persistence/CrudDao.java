/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.persistence;


import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * DAO支持类实现
 * 
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao {

	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(Long id) throws DataAccessException;

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity) throws DataAccessException;

	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) throws DataAccessException;

	/**
	 * 查询所有数据列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity) throws DataAccessException;

	/**
	 * 查询所有数据列表
	 * 
	 * @see public List<T> findAllList(T entity)
	 * @return
	 */
	@Deprecated
	public List<T> findAllList() throws DataAccessException;

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(T entity) throws DataAccessException;

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public long insertEntity(T entity) throws DataAccessException;

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @return
	 */
	public int update(T entity) throws DataAccessException;

	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * 
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Deprecated
	public int delete(String id) throws DataAccessException;

	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * 
	 * @param entity
	 * @return
	 */
	public int delete(T entity) throws DataAccessException;

}