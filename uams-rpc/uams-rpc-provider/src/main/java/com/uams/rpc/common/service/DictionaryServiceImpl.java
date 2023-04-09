/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.service;

import com.google.common.collect.Lists;
import com.uams.orm.core.GenericServiceImpl;
import com.uams.rpc.common.entity.Dictionary;
import com.uams.rpc.common.mapper.DictionaryMapper;
import com.uams.rpc.common.model.DictModel;
import com.uams.tools.bean.TreeModel;
import com.uams.tools.exception.BusinessException;
import com.uams.tools.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据典 服务实现类
 * <p>File：Dictionary.java </p>
 * <p>Title: Dictionary </p>
 * <p>Description:Dictionary </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@Service
public class DictionaryServiceImpl extends GenericServiceImpl<Dictionary> implements DictionaryService
{
    private DictionaryMapper dictionaryMapper;
    
    @Autowired
    public DictionaryServiceImpl(DictionaryMapper dictionaryMapper)
    {
        super(dictionaryMapper);
        this.dictionaryMapper = dictionaryMapper;
    }
    
    @Override
    public List<Dictionary> findByCode(String lang, String code) throws BusinessException
    {
        return dictionaryMapper.findByCode(lang, code);
    }
    
    @Override
    public List<DictModel> findAllDict() throws BusinessException
    {
        List<DictModel> result = Lists.newArrayList();
        List<Dictionary> data = dictionaryMapper.selectAll();
        for (Dictionary parent : data)
        {
            if (null == parent.getParentId())
            {
                DictModel model = conventModel(parent);
                for (Dictionary child : data)
                {
                    if (null == child.getParentId()) continue;
                    if (model.getId().equals(child.getParentId()))
                    {
                        if (model.getChildren() == null)
                        {
                            model.setChildren(Lists.newArrayList(conventModel(child)));
                        }
                        else
                        {
                            model.getChildren().add(conventModel(child));
                        }
                    }
                }
                result.add(model);
            }
        }
        return result;
    }
    
    @Override
    public List<TreeModel> findByDict(String id) throws BusinessException
    {
        List<Dictionary> data = dictionaryMapper.findByParentId(id);
        if (ListUtils.isNull(data)) return null;
        List<TreeModel> treeModels = Lists.newArrayList();
        for (Dictionary dict : data)
        {
            treeModels.add(conventObject(dict));
        }
        return treeModels;
    }
    
    DictModel conventModel(Dictionary dict)
    {
        DictModel model = new DictModel();
        model.setId(dict.getId());
        model.setCode(dict.getCode());
        model.setLang(dict.getLang());
        model.setName(dict.getName());
        return model;
    }
    
    /**
     * 转换对象类型
     * @param dict
     * @return
     */
    TreeModel conventObject(Dictionary dict)
    {
        TreeModel model = new TreeModel();
        model.setId(dict.getId());
        if (null != dict.getParentId())
        {
            model.setState("closed");
        }
        model.setPid(dict.getParentId());
        model.setText(dict.getName());
        return model;
    }
}
