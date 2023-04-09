package com.uams.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.uams.orm.utils.EncryptUtils;

/**
 *  扩展数据库连接
 * <p>File： CustomDruidDataSource.java </p>
 * <p>Title:  CustomDruidDataSource </p>
 * <p>Description: CustomDruidDataSource </p>
 * <p>Copyright: Copyright (c) 2017/8/2 </p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class CustomDruidDataSource extends DruidDataSource
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6367743185033643860L;

    @Override
    public void setPassword(String password)
    {
        super.setPassword(EncryptUtils.desDecrypt(password));
    }
}
