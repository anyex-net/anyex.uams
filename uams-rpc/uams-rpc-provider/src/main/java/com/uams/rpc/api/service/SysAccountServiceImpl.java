/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.api.service;


import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.api.mapper.SysAccountMapper;
import com.uams.rpc.api.model.SysAccountModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import com.uams.tools.utils.SerialnoUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 平台资金账户信息表 服务实现类
 * <p>File：SysAccountServiceImpl.java </p>
 * <p>Title: SysAccountServiceImpl </p>
 * <p>Description:SysAccountServiceImpl </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class SysAccountServiceImpl extends GenericServiceImpl<SysAccountModel> implements SysAccountService
{

    protected SysAccountMapper sysAccountMapper;

    @Autowired
    public SysAccountServiceImpl(SysAccountMapper sysAccountMapper)
    {
        super(sysAccountMapper);
        this.sysAccountMapper = sysAccountMapper;
    }

    /**
     * 平台资金账户信息增加
     * @param sysAccountModel
     * @return
     * @throws BusinessException
     */
    @Override
    public int saveSysAccount(SysAccountModel sysAccountModel) throws BusinessException {

        SysAccountModel sysAccountSelect=new SysAccountModel();
        sysAccountSelect.setAccountNo(sysAccountModel.getAccountNo());
        List<SysAccountModel> sysAccountModelList=findList(sysAccountSelect);
        logger.debug("onRspQryAccount解析账户信息...");
        logger.debug(String.valueOf(ListUtils.isNotNull(sysAccountModelList)));
        logger.debug("sysAccountModelList.size():" + sysAccountModelList.size());
        boolean save=true;
        SysAccountModel sysAccount=null;
        if(sysAccountModelList==null || sysAccountModelList.size()==0){
            sysAccount=new SysAccountModel();
        }else {
            sysAccount=sysAccountModelList.get(0);
            save=false;
        }
            sysAccount.setId(SerialnoUtils.buildPrimaryKey());
            sysAccount.setAccountEnShortName("hahaha");
            sysAccount.setAccountNo(sysAccountModel.getAccountNo());
            sysAccount.setAccountShortName(sysAccountModel.getAccountShortName());
            sysAccount.setAccountState(String.valueOf(sysAccountModel.getAccountState()));
            sysAccount.setAccountTradeRight(String.valueOf(sysAccountModel.getAccountTradeRight()));
            sysAccount.setAccountType(String.valueOf(sysAccountModel.getAccountType()));
            sysAccount.setCommodityGroupNo(sysAccountModel.getCommodityGroupNo());
            sysAccount.setRemark("11111");
            sysAccount.setUpdateDate(new Date());
        if (save){
            sysAccount.setCreateDate(new Date());
            insert(sysAccount);
        }else {

            updateByPrimaryKey(sysAccount);
        }
        logger.debug("onRspQryAccount解析账户信息结束");
        return 0;
    }
}
