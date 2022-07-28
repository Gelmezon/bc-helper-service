package xyz.gelmezon.service.Impl;

import org.springframework.stereotype.Service;
import xyz.gelmezon.entity.BcWear;
import xyz.gelmezon.service.BcWearService;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 12:05
 **/
@Service
public class BcWearServiceImpl extends BaseServiceImpl<BcWear> implements BcWearService {

    @Override
    public Class<BcWear> getEntityClass() {
        return BcWear.class;
    }
}
