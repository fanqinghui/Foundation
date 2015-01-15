package com.foundation.dao.MyBatisRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-14 上午10:48
 * <p>Version: 1.0
 */
@Repository
public interface MybatisBaseDao<T> {

    public T queryById(Long id);

    public Long queryPageCount(Map params);

    public List<T> queryPage(Map params);

    public List<T> queryList(Map params);

    public void update(T t);

    public T save(T t);

    public void batchUpdate(List<T> list);

    public void batchSave(List<T> list);
}
