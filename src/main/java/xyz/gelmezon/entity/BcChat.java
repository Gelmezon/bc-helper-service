package xyz.gelmezon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 09:58
 **/
@Data
@Document(collection = "bcChat")
public class BcChat extends BaseEntity {

    private String senderMemberNumber;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;
    private String NickName;
    private String roomName;
    private String sendMessage;
    private String senderCode;


    @Override
    public Update createUpdate() {
        Update update = new Update();
        if (!ObjectUtils.isEmpty(senderMemberNumber)) {
            update.set("senderMemberNumber", senderMemberNumber);
        }
        if (!ObjectUtils.isEmpty(sendDate)) {
            update.set("sendDate", sendDate);
        }
        if (!ObjectUtils.isEmpty(NickName)) {
            update.set("NickName", NickName);
        }
        if (!ObjectUtils.isEmpty(roomName)) {
            update.set("roomName", roomName);
        }
        if (!ObjectUtils.isEmpty(sendMessage)) {
            update.set("sendMessage", sendMessage);
        }
        return update;

    }

}
