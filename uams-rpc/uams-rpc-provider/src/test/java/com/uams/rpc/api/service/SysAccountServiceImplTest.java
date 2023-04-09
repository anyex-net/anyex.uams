package com.uams.rpc.api.service;

import com.uams.basic.service.AbstractBaseTest;

import com.uams.rpc.api.model.SysAccountModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2018/2/5.
 */
public class SysAccountServiceImplTest extends AbstractBaseTest
{
    @Autowired
    SysAccountService sysAccountService;

    @Test
    public void testList()
    {
        SysAccountModel entity = new SysAccountModel();
        sysAccountService.findList(entity);
    }
}