package xyz.gelmezon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.gelmezon.entity.BcChat;
import xyz.gelmezon.service.BaseService;
import xyz.gelmezon.service.BcChatService;

/**
 * @description:
 * @version: 0.0.1
 * @author: Candy
 * @createTime: 2022-07-21 12:19
 **/
@RestController
@RequestMapping("bcChat")
@CrossOrigin
public class BcChatController extends BaseController<BcChat>{

    private final BcChatService bcChatService;

    public BcChatController(BcChatService bcChatService) {
        this.bcChatService = bcChatService;
    }

    @Override
    BaseService<BcChat> service() {
        return bcChatService;
    }
}
