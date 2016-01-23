package cc.aisc.platform.commons.base;

import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 15-11-16.
 */
public abstract class BaseService <T extends AbstractEntity> extends Loggable{

/**
 * 保存单个实体
 *
 * @param t 实体
 * @return 返回保存的实体
 */
   /* public T save(T t) {
        if(null != t) {
            Optional<T> o = Optional.ofNullable());
            if (o.isPresent()) {
                T tt = o.get();
                BeanUtils.copyPropertiesIgnoreNull(t, tt);
                return groupDao.save(group);
            }else {
                return groupDao.save(obj);
            }
        }
        return null;
    }

    public T saveAndFlush(T t) {
        return t;
    }*/
    /*protected BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    *//**
     * 保存单个实体
     *
     * @param t 实体
     * @return 返回保存的实体
     *//*
    public T save(T t) {
        return baseDao.save(t);
    }

    public T saveAndFlush(T t) {
        t = save(t);
        baseDao.flush();
        return t;
    }

    *//**
     * 更新单个实体
     *
     * @param t 实体
     * @return 返回更新的实体
     *//*
    public T update(T t) {
        return baseDao.save(t);
    }

    *//**
     * 根据主键删除相应实体
     *
     * @param id 主键
     *//*
    public void delete(ID id) {
        baseDao.delete(id);
    }

    *//**
     * 删除实体
     *
     * @param t 实体
     *//*
    public void delete(T t) {
        baseDao.delete(t);
    }

    *//**
     * 根据主键删除相应实体
     *
     * @param ids 实体
     *//*
    public void delete(ID[] ids) {
        baseDao.delete(ids);
    }


    *//**
     * 按照主键查询
     *
     * @param id 主键
     * @return 返回id对应的实体
     *//*
    public T findOne(ID id) {
        return baseDao.findOne(id);
    }

    *//**
     * 实体是否存在
     *
     * @param id 主键
     * @return 存在 返回true，否则false
     *//*
    public boolean exists(ID id) {
        return baseDao.exists(id);
    }

    *//**
     * 统计实体总数
     *
     * @return 实体总数
     *//*
    public long count() {
        return baseDao.count();
    }

    *//**
     * 查询所有实体
     *
     * @return
     *//*
    public List<T> findAll() {
        return baseDao.findAll();
    }

    *//**
     * 按照顺序查询所有实体
     *
     * @param sort
     * @return
     *//*
    public List<T> findAll(Sort sort) {
        return baseDao.findAll(sort);
    }

    *//**
     * 分页及排序查询实体
     *
     * @param pageable 分页及排序数据
     * @return
     *//*
    public Page<T> findAll(Pageable pageable) {
        return baseDao.findAll(pageable);
    }*/

}
