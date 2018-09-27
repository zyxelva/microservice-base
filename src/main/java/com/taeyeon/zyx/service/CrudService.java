/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.service;

import com.taeyeon.zyx.common.Page;
import com.taeyeon.zyx.persistence.CrudDao;
import com.taeyeon.zyx.persistence.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService implements CrudInf<T> {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(Long id) throws DataAccessException {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) throws DataAccessException {
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) throws DataAccessException {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) throws DataAccessException {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 * @throws DataAccessException 
	 */
	@Transactional(readOnly = false)
	public void save(T entity) throws DataAccessException {

		if (entity.getIsNewRecord()){
//				entity.preInsert();
			dao.insert(entity);
		}else{
//				entity.preUpdate();
			dao.update(entity);
		}
	}
	
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) throws DataAccessException {
		dao.delete(entity);
	}

}
