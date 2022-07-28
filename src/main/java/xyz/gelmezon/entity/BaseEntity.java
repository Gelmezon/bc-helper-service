package xyz.gelmezon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 10:53
 **/
@Data
public abstract class BaseEntity {

    @Id
    @MongoId
    private Long id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;


    public abstract Update createUpdate();

}
