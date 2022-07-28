package xyz.gelmezon.service.Impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.result.DeleteResult;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import xyz.gelmezon.entity.BaseEntity;
import xyz.gelmezon.service.BaseService;
import xyz.gelmezon.utils.BeanMapUtilByReflect;
import xyz.gelmezon.utils.IdGenerator;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 10:50
 **/
@Service
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private  MongoTemplate mongoTemplate;

    @Autowired
    private IdGenerator idGenerator;


    @Override
    public int insert(T t) throws Exception {
        final Long id = idGenerator.nextId();
        t.setId(id);
        t.setCreateDate(new Date());
        mongoTemplate.insert(t);
        return 0;
    }


    @Override
    public int update(T t) throws Exception {
        Query query = new Query(Criteria.where("id").is(t.getId()));
        final Update update = t.createUpdate();
        update.set("updateDate",new Date());
        mongoTemplate.updateFirst(query, update, getEntityClass());
        return 1;
    }

    @Override
    public int remove(Long id) throws Exception {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, getEntityClass());
        return 1;
    }

    @Override
    public T findOne(Long id) throws Exception {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, getEntityClass());
    }

    @Override
    public List<T> list(T t) throws Exception {
        DBObject obj = new BasicDBObject();
        final Map map = BeanMapUtilByReflect.beanToMap(t);
        for (Object o : map.keySet()) {
            final Object value = map.get(o);
            if(ObjectUtils.isNotEmpty(value)){
                obj.put(o.toString(), value.toString());
            }
        }
        BasicQuery query = new BasicQuery(obj.toString());
        return mongoTemplate.find(query, getEntityClass());
    }

}
