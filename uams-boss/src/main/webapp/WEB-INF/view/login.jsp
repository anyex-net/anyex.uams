<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>UAMS资产投资管理平台</title>
    <%@ include file="/commons/basejs.jsp" %>
    <script type="text/javascript" src="${res}/login.js" charset="utf-8"></script>
    <!-- 此段必须要引入 t为小时级别的时间戳 -->
    <link type="text/css" href="//g.alicdn.com/sd/ncpc/nc.css?t=1502956831425" rel="stylesheet"/>
    <script type="text/javascript" src="//g.alicdn.com/sd/ncpc/nc.js?t=1502956831425"></script>
    <!-- 引入结束 -->
    <!-- 此段必须要引入 -->
    <div id="_umfp" style="display:inline;width:1px;height:1px;overflow:hidden"></div>
    <!-- 引入结束 -->
    <link rel="stylesheet" type="text/css" href="${res}/style/css/login.css" />
</head>
<body onkeydown="enterlogin();">
<div class="top_div"></div>
<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231);
    border-image:none;width:400px;text-align: center;">
    <form:form method="post" id="loginform">
        <div style="width: 165px; height: 96px; position: absolute;">
            <div class="tou"></div>
            <div class="initial_left_hand" id="left_hand"></div>
            <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <P style="padding: 30px 0px 10px; position: relative;">
            <span class="u_logo"></span>
            <input class="ipt" type="text" name="username" placeholder="请输入登录名"/>
        </P>
        <P style="position: relative;">
            <span class="p_logo"></span>
            <input class="ipt" id="password" type="password" name="password" placeholder="请输入密码"/>
        </P>
        <P style="position: relative;">
            <div class="ln">
                <div id="captcha"></div>
                <input type='hidden' id='csessionid' name='csessionid'/>
                <input type='hidden' id='sig' name='sig'/>
                <input type='hidden' id='token' name='token'/>
                <input type='hidden' id='scene' name='scene'/>
            </div>
        </P>
        <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <span style="float: right;">
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px;
                    border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255);
                    font-weight: bold;" href="javascript:;" onclick="submitForm()">登录</a>
                </span>
            </P>
        </div>
    </form:form>
</div>

</body>
</html>
