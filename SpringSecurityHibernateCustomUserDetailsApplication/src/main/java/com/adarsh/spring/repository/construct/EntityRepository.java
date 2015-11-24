package com.adarsh.spring.repository.construct;

import com.adarsh.spring.entity.construct.Entity;
import org.springframework.dao.DuplicateKeyException;

import java.util.Collection;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@org.springframework.stereotype.Repository
public interface EntityRepository<R> {

    /* public R get(R entity);*/

    public List<R> getAll();

    public List<R> getAll(int limit);

    public List<R> getAll(Integer firstResult, Integer maxResults);

    public List<R> getByExample(final R example);

    public R getUniqueByExample(final R example);

    public void put(final R record) throws DuplicateKeyException;

    public void put(final Collection<R> records);

    public Entity getEntity(Entity entity);

    public Entity getEntityById(Entity entity);

    public Entity getEntityByName(Entity entity);

    public void insert(final R record);

    public void insertAll(final Collection<R> items);

    public void update(final R record);

    public void updateAll(final Collection<R> items);

    public void remove(final R entity);

    public Entity getByColumnName(String columnName, Object columnValue);

    public Collection<R> getByEntities(String columnName, Object columnValue);

    public void clear();

    public void refresh(final R entity);

    public Long size();
}
