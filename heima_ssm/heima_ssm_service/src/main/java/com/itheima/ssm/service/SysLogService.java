package com.itheima.ssm.service;

import com.itheima.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/13 17:57
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

public interface SysLogService {

    void save(SysLog sysLog);

    List<SysLog> findByName(String username ,Integer page, Integer size);
}
