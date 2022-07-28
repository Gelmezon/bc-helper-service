package xyz.gelmezon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import xyz.gelmezon.entity.BaseEntity;
import xyz.gelmezon.service.BaseService;
import xyz.gelmezon.service.BcChatService;

import java.util.List;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 12:11
 **/

public abstract class BaseController<T extends BaseEntity> {

    @PostMapping
    public void create(@RequestBody T entity) throws Exception {
        service().insert(entity);
    }

    @PutMapping("/{id}")
    public void modify(@PathVariable("id") Long id, @RequestBody T entity) throws Exception {
        service().update(entity);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) throws Exception {
        service().remove(id);
    }

    @GetMapping("/{id}")
    public T get(@PathVariable("id") Long id) throws Exception {
        return service().findOne(id);
    }

    @GetMapping
    protected List<T> list(T query) throws Exception {
        return service().list(query);
    }

    abstract BaseService<T> service();
}
