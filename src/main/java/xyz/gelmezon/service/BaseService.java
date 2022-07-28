package xyz.gelmezon.service;

import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.query.Query;
import xyz.gelmezon.entity.BaseEntity;

import java.util.List;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 10:15
 **/
public interface BaseService<T extends BaseEntity> {

    int insert(T t) throws Exception;

    int update(T t)throws Exception;

    int remove(Long id)throws Exception;


    T findOne(Long id)throws Exception;

    List<T> list(T student)throws Exception;

    Class<T> getEntityClass();

}
