/*
 * @(#)SQLServerDialect.java 2015-4-17 下午3:34:17
 * Copyright 2015 Playguy, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.uams.orm.dialect;

/**
 * <p>File：SQLServerDialect.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-4-17 下午3:34:17</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class SQLServerDialect implements Dialect
{
    @Override
    public boolean supportsLimit()
    {
        return true;
    }
    
    static int getAfterSelectInsertPoint(String sql)
    {
        int selectIndex = sql.toLowerCase().indexOf("select");
        final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
        return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
    }
    
    @Override
    public String getLimitString(String sql, int offset, int limit)
    {
        return getLimit(sql, offset, limit);
    }
    
    /**
     * 将sql变成分页sql语句,提供将offset及limit使用占位符号(placeholder)替换.
     * <pre>
     * 如mysql
     * dialect.getLimitString("select * from user", 12, ":offset",0,":limit") 将返回
     * select * from user limit :offset,:limit
     * </pre>
     *
     * @param sql    实际SQL语句
     * @param offset 分页开始纪录条数
     * @param limit  分页每页显示纪录条数
     * @return 包含占位符的分页sql
     */
    public String getLimit(String sql, int offset, int limit)
    {
        if (offset > 0) throw new UnsupportedOperationException("sql server has no offset");
        return new StringBuffer(sql.length() + 8).append(sql).insert(getAfterSelectInsertPoint(sql), " top " + limit).toString();
    }
}
