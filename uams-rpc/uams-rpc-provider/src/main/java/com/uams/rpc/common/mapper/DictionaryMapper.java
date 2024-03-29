/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.rpc.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uams.rpc.common.entity.Dictionary;
import com.uams.orm.annotation.MyBatisDao;
import com.uams.orm.core.GenericMapper;

/**
 * 数据典 持久层接口
 * <p>File：DictionaryDao.java </p>
 * <p>Title: DictionaryDao </p>
 * <p>Description:DictionaryDao </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */
@MyBatisDao
public interface DictionaryMapper extends GenericMapper<Dictionary>
{
    /**
     * 根据字典编码取字典数据
     * @param lang
     * @param code
     * @return
     */
    List<Dictionary> findByCode(@Param("lang")String lang,@Param("code")String code);
    
    /**
     * 根据上线ID取数据
     * @param parentId
     * @return
     */
    List<Dictionary> findByParentId(@Param("parentId") String parentId);
}
