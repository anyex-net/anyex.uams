package com.uams.tools.ip;

/**
 * 一条IP范围记录，不仅包括国家和区域，也包括起始IP和结束IP *
 * <p>File：IPEntry.java</p>
 * <p>Title: IPEntry</p>
 * <p>Description: IPEntry</p>
 * <p>Copyright: Copyright (c) 2017/8/3</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class IPEntry
{
    public String beginIp;
    
    public String endIp;
    
    public String country;
    
    public String area;
    
    /**
     * 构造函数 
     */
    public IPEntry()
    {
        beginIp = endIp = country = area = "";
    }
    
    public String toString()
    {
        return this.area + "  " + this.country + "IP范围:" + this.beginIp + "-" + this.endIp;
    }
}
