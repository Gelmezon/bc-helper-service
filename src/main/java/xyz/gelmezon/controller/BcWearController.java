package xyz.gelmezon.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.gelmezon.entity.BcWear;
import xyz.gelmezon.service.BaseService;
import xyz.gelmezon.service.BcWearService;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 12:19
 **/
@RestController
@RequestMapping("bcWear")
@CrossOrigin
public class BcWearController extends BaseController<BcWear>{

    private final BcWearService bcChatService;

    public BcWearController(BcWearService bcChatService) {
        this.bcChatService = bcChatService;
    }

    @Override
    BaseService<BcWear> service() {
        return bcChatService;
    }
}
