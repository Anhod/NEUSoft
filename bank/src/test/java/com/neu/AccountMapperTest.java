package com.neu;

import com.neu.DBConfig;
import com.neu.mapper.AccountMapper;
import com.neu.po.Account;
import com.neu.service.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(classes = {DBConfig.class,MyBatisMapperScannerConfig.class,MybatisConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountMapperTest {
    @Resource
    private AccountServiceImpl accountService;

    @Test
    public void getById(){
        Account account = accountService.getById(1);
        System.out.println(account);
    }

}
