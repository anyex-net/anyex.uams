package com.umeng.push.android;

import com.umeng.push.AndroidNotification;

public class AndroidBroadcast extends AndroidNotification
{
    public AndroidBroadcast(String appkey, String appMasterSecret) throws Exception
    {
        setAppMasterSecret(appMasterSecret);
        setPredefinedKeyValue("appkey", appkey);
        this.setPredefinedKeyValue("type", "broadcast");
    }
}
