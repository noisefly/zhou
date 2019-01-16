package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/13 18:32
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findByName")
    public String findByName(Model model, @RequestParam(name="page",defaultValue = "1")Integer page,
                          @RequestParam(name = "size",defaultValue = "8")Integer size,
                          @RequestParam(name = "username",defaultValue = "")String likeusername){
        List<SysLog> sysLogs=sysLogService.findByName(likeusername,page,size);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("likeusername",likeusername);
        return "syslog-list-page";
    }
}
