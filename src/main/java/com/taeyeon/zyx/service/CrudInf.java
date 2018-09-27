package com.taeyeon.zyx.service;

import com.taeyeon.zyx.common.Page;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lynn on 2018/4/14.
 */
public interface CrudInf<T>  {

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(Long id) throws DataAccessException;

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity) throws DataAccessException ;

    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<T> findList(T entity) throws DataAccessException;

    /**
     * 查询分页数据
     * @param page 分页对象
     * @param entity
     * @return
     */
    public Page<T> findPage(Page<T> page, T entity) throws DataAccessException;

    /**
     * 保存数据（插入或更新）
     * @param entity
     * @throws DataAccessException
     */
    @Transactional(readOnly = false)
    public void save(T entity) throws DataAccessException ;


    /**
     * 删除数据
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity) throws DataAccessException;

}
