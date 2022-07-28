package xyz.gelmezon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;

/**
 * @description:
 * @version: 0.0.1
 * @author: feitan
 * @createTime: 2022-07-28 09:15
 **/
@Data
@Document(collection = "bcWear")
public class BcWear extends BaseEntity {

    private String updateMemberNumber;
    private String updateMemberNickName;
    private String wearData;
    private String wearName;

    @Override
    public Update createUpdate() {
        Update update = new Update();
        if (!ObjectUtils.isEmpty(updateMemberNumber)) {
            update.set("updateMemberNumber", updateMemberNumber);
        }
        if (!ObjectUtils.isEmpty(wearData)) {
            update.set("wearData", wearData);
        }
        if (!ObjectUtils.isEmpty(wearName)) {
            update.set("wearName", wearName);
        }
        if (!ObjectUtils.isEmpty(updateMemberNickName)) {
            update.set("updateMemberNickName", updateMemberNickName);
        }
        return update;
    }
}
