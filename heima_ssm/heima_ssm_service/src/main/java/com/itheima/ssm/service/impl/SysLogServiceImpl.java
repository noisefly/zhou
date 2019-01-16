package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.SysLog;
import com.itheima.ssm.dao.SysLogDao;
import com.itheima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/13 17:59
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */


@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
   private SysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findByName(String username,Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return sysLogDao.findByName("%"+username+"%");
    }
}
