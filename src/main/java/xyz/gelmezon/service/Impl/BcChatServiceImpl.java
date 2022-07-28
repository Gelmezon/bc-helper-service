package xyz.gelmezon.service.Impl;

import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import xyz.gelmezon.entity.BcChat;
import xyz.gelmezon.service.BaseService;
import xyz.gelmezon.service.BcChatService;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 12:05
 **/
@Service
public class BcChatServiceImpl extends BaseServiceImpl<BcChat> implements BcChatService{

    @Override
    public Class<BcChat> getEntityClass() {
        return BcChat.class;
    }
}
