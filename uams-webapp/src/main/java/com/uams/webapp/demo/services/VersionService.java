package com.uams.webapp.demo.services;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uams.webapp.demo.models.Version;

@Controller
@RequestMapping(value = "fxclient/version")
public class VersionService
{
    @ResponseBody
    @RequestMapping(value = "checkVersion.do", method = RequestMethod.GET)
    public Version checkVersion(HttpServletRequest request)
    {
        String currentVersion = request.getParameter("curVersion");
        Version v = new Version();
        v.setLastVersion(currentVersion);
        if ("1".equals(currentVersion))
        {
            v.setLastVersion("2");
            v.setPreviousVersion(currentVersion);
            v.setUrl("http://localhost:8080/fxclient/version/download.do");
            v.setVersionInfo("客户端V2.0\n1.测试更新\n2.测试更新内容");
        }
        return v;
    }
    
    @ResponseBody
    @RequestMapping(value = "download.do", method = RequestMethod.GET)
    public String downLoad(HttpServletResponse response)
    {
        File file = new File("test.zip");
        if (file.exists())
        {
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
            response.setContentLengthLong(file.length());
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            try
            {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1)
                {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                bis.close();
                fis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
}
