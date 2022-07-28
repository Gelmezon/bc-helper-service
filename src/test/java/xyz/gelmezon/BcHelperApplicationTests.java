package xyz.gelmezon;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import xyz.gelmezon.entity.BcChat;

import javax.management.Query;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BcHelperApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {


        DBObject obj = new BasicDBObject();
        obj.put("senderMemberNumber", "72721");
        BasicQuery query = new BasicQuery(obj.toString());
        final List<BcChat> list = mongoTemplate.find(query, BcChat.class);
        System.out.println("===============");

    }

}
