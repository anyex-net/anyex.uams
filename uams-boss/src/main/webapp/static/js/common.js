var locale;//全局语言标识
var appKey = "FFFF000000000177330E";
//放全网站的通用js
var bitms = {
    success: 200, // ajax 成功代码
    error: 1000, // 表单提交验证错误
    gaValid: 2001,//GOOGLE 认证
    codeError: 2002, //验证码错误
    captchaError: 2007,//滑块验证码错误
    emailExists: 2010,//邮箱已存在
    noUser: 2004,//用户不存在
    unbindGA: 2024//GOOGLE验证码未绑定
};

//提示类型
var remindType = {
    success: "success",
    error: "error",
    normal: 'normal'
}

function dictDropDownOptionsList(id, name, dictCode, value, option,style) {
    style = style || "";
    var locale = "zh_CN";
    var data=[];
    var html="<input id='"+id+"' name='"+name+"' style='"+style+"' class=\"easyui-combobox\" data-options=\" "+option+"valueField:'code',textField:'name',editable:false, panelHeight:'auto' , data: ";
	$.each(dictionary, function (idx, obj) {
        if (dictCode == obj.code) {
        	data.push({ "name": "-请选择-", "code": ""});
            $.each(obj.children, function (cidx, cobj) {
                if (locale == cobj.lang) {
                    if (cobj.code == value) {
                        data.push({ "name": cobj.name, "code": cobj.code ,selected:true});
                    } else {
                    	data.push({ "name": cobj.name, "code": cobj.code });
                    }
                }
            });
            html+= JSON.stringify(data).replace(/"/g, "'");
            html += "\" />";
        }
    });
    return html;
};


function dictDropDownOptions(id, name, dictCode, value, option,style) {
    style = style || "";
    var locale = "zh_CN";
    var data=[];
    var html="<input id='"+id+"' name='"+name+"' style='"+style+"' class=\"easyui-combobox\" data-options=\" "+option+"valueField:'code',textField:'name',editable:false, panelHeight:'auto' , data: ";
	$.each(dictionary, function (idx, obj) {
        if (dictCode == obj.code) {
            $.each(obj.children, function (cidx, cobj) {
                if (locale == cobj.lang) {
                    if (cobj.code == value) {
                        data.push({ "name": cobj.name, "code": cobj.code ,selected:true});
                    } else {
                    	data.push({ "name": cobj.name, "code": cobj.code });
                    }
                }
            });
            html+= JSON.stringify(data).replace(/"/g, "'");
            html += "\" />";
        }
    });
    return html;
};



/**
 * 根据字典编码取显示的名称
 * @param code
 */
function getDictValueByCode(dictCode) {
    var locale ="zh_CN";
    var str = "";
    $.each(dictionary, function (idx, obj) {
        $.each(obj.children, function (cidx, cobj) {
            if (dictCode == cobj.code && locale == cobj.lang) {
                str = cobj.name;
            }
        });
    });
    return str;
}

/**
 * 安全的使用 console.log 和 console.error
 */
if (typeof window.console == 'undefined') {
    window.console = {};
    $.each(['log', 'error'], function (i, v) {
        if (typeof window.console[v] == 'undefined') {
            window.console[v] = function () {
            };
        }
    })
}

//解析
$.unparam = function (url) {
    var vars = {}, hash, i, urlParams = url.indexOf('?') > -1 ? url.split('?')[1] : url;
    var hashes = urlParams.split('&');
    for (i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        vars[hash[0]] = decodeURIComponent(hash[1]).replace(/\+/g, ' ');
    }
    return vars;
};

//select
$.fn.SelectBox = function () {
    //老版本
    return this.each(function () {

        if ($.browser.msie6() || $.browser.msie7()) {
            return;
        }

        var className = "";

        var oparent = $(this).parent();

        if (oparent.find("select").length > 1) {
            $(this).wrap('<div class="inline-block"></div>');
        }

        oparent = $(this).parent();

        if (!oparent.hasClass("pr")) {
            oparent.addClass("pr");
        }


        $(this).css({
            "opacity": 0,
            "position": "absolute",
            "left": 0,
            "top": 0,
            "filter": "alpha(opacity=0)"
        })

        var str = "";

        var name_val = $(this).attr("name");
        var id_val = $(this).attr("id");

        if (name_val) {
            str = name_val;
        } else {
            if (id_val) {
                str = id_val;
            } else {
                console.error("没找到select的name或者ID值");
                return;
            }
        }

        $('<div id="' + str + '_div" class="common_select_box"><span class="fn-text-overflow">' + $(this).find("option:selected").text() + '</span><i class="arrow"></i></div>').insertBefore($(this));

        //处理小箭头的位置，3为箭头的高度的一半，就相当于top:50%-(xx的一半)
        $("#" + str + "_div .arrow").css("top", $(this).outerHeight() / 2 - 3);


        $("#" + str + "_div").css({
            "width": $(this).outerWidth() - 2,
            "height": $(this).outerHeight() - 2,
            "line-height": $(this).outerHeight() - 2 + "px"
        });

        $("#" + str + "_div span").css("width", $(this).outerWidth() - 20);

        $(this).on("change", function () {
            $("#" + str + "_div span").html($(this).find("option:selected").text());
        })

    });
}

/**
 *
 * @param select css选择器
 */
function renderSelect(select) {
    if ($.type(select) == "string") {
        var name = $(select).attr("name");
        $("#" + name + "_div span").html($(select).find("option:selected").text());
    }

    if ($.type(select) == "array") {
        $.each(select, function (i, ele) {
            var name = $(ele).attr("name");
            $("#" + name + "_div span").html($(ele).find("option:selected").text());
        })
    }

    var name = $(select).attr("name");
    $("#" + name + "_div span").html($(select).find("option:selected").text());
}

//校验price
$.fn.isPrice = function (flag) {
    return this.each(function () {

        //$(this).on("keyup keydown input", function () {//会出现选中全部输入在后面追加，而不是覆盖的情况
        $(this).on("keyup change", function () {
            //如果只是数字
            if (flag == false) {
                $(this).val($(this).val().replace(/[^\d]/g, ''));
                return;
            }

            //干掉非数字
            $(this).val($(this).val().replace(/[^0-9+.?0-9]/g, ''));

            //处理折扣之类的
            var min = parseFloat($(this).data("min")),
                max = parseFloat($(this).data("max"));

            var value = parseFloat($(this).val());

            if (min && max) {
                min = Math.min(min, max);
                max = Math.max(min, max);
            }

            if (max) {
                value > max ? $(this).val('') : "";
            }
            if (min) {
                value < min ? $(this).val('') : "";
            }

        });
    });
}

//发送短信验证码倒计时
function countDown(obj, msg) {
    var time = 60;
    var validCode = true;
    var code = $(obj);
    if (validCode) {
        validCode = false;
        var t = setInterval(function () {
            time--;
            code.html(time + "s");
            code.attr('disabled', 'disabled');
            if (time == 0) {
                clearInterval(t);
                code.html(msg);
                validCode = true;
                code.removeAttr("disabled");
            }
        }, 1000)
    }
}

//注册发送邮箱验证5分钟内有效
function sendDown(obj, msg1, msg2) {
    var time = 300;
    var validCode = true;
    var code = $(obj);
    if (validCode) {
        validCode = false;
        var t = setInterval(function () {
            time--;
            code.html(msg2);
            code.attr('disabled', 'disabled').addClass('disBtn');
            if (time == 0) {
                clearInterval(t);
                code.html(msg1);
                validCode = true;
                code.removeAttr("disabled").removeClass('disBtn');
            }
        }, 1000)
    }
}

//倒计时
$.fn.cutDown = function (format, onEnd, onBefore) {

    var getDHMS = function (s) {
        var d = parseInt(s / 86400);//秒数除以（3600*24） 则可以取到天数
        s %= 86400;//取余数
        var h = parseInt(s / 3600);
        s %= 3600;
        var m = parseInt(s / 60);
        s %= 60;
        var s = parseInt(s);
        return {d: d, h: h, m: m, s: s};
    };

    if (!format) {
        format = function (dhms) {
            return (dhms.d * 24 + dhms.h) + ':' + dhms.m + ':' + dhms.s;
        };
    }

    this.each(function () {
        var $that = $(this);
        var start = +new Date();
        var end = $that.data('endtime');

        if (end <= start) {

            if (typeof onBefore === 'function') {
                onBefore();
            }

            return;
        }

        var interval = setInterval(function () {

            var remain = end - new Date();

            if (remain <= 0) {
                remain = 0;
                clearInterval(interval);

                if (typeof onEnd === 'function') {
                    onEnd();
                }
            }

            $that.html(format(getDHMS(remain / 1000), remain));

        }, 900);
    });
    return this;
};
//判断浏览器
$.browser = {
    mozilla: function () {
        return /firefox/.test(navigator.userAgent.toLowerCase());
    },
    webkit: function () {
        return /webkit/.test(navigator.userAgent.toLowerCase());
    },
    opera: function () {
        return /opera/.test(navigator.userAgent.toLowerCase());
    },
    msie: function () {
        return /msie/.test(navigator.userAgent.toLowerCase());
    },
    msie6: function () {
        return /msie 6\.0/i.test(navigator.userAgent.toLowerCase());
    },
    msie7: function () {
        return /msie 7\.0/i.test(navigator.userAgent.toLowerCase());
    },
    //竺显斌 2014-04-22
    msie8: function () {
        return /msie 8\.0/i.test(navigator.userAgent.toLowerCase());
    }
    //竺显斌 2014-04-22
};
//如果是IE6就加载png24的js文件
if ($.browser.msie6()) {
    $.getScript("/scripts/DD_belatedPNG.js", function () {
        DD_belatedPNG.fix("*");
    })
}


//获取验证码的函数
function getCodeFn(obj, num) {

    $(obj).attr("disabled", "disabled");
    var num = typeof num == "undefined" ? 60 : parseInt(num);

    function cutDown() {
        if (num == 0) {
            clearInterval(getCodeFn.timer);
            $(obj).html("获取验证码");
            $(obj).removeAttr("disabled");
            return;
        }
        $(obj).html("倒计时（" + num + "）");
        num--;
    }

    cutDown();
    getCodeFn.timer = setInterval(function () {
        cutDown();
    }, 1000);

}

//弹出提示信息
function remind(type, message, timeout, fn) {
    if ($.isFunction(timeout)) {
        fn = timeout;
        timeout = 3;
    }

    timeout = timeout || 2000;

    remindfn(type, message, timeout, fn);
}

function remindfn(type, message, timeout, fn) {
    seajs.use(["underscore", "dialog", "template", "i18n"], function (_, Dialog, template, I18n) {
        //var types = 'simple,error,warning,success,tip,loading';
        var types = 'success,error,normal';
        if (_.indexOf(types.split(','), type) == -1) {
            return;
        }
        var format = '<div class="remind-border"><div class="ui-head"><h3>'
            + I18n.prop("generic.tips") + '</h3></div>'
            + '<div class="remind remind-{{type}}">'
            + '<i class="remind-icon" style="{{style}}"></i>'
            + '<span class="remind-message">{{message}}</span></div></div>';

        var render = template.compile(format);
        var html = render({
            "type": type,
            "message": message,
            "style": (function () {
                var str = ""
                if (type == "success") {
                    str = "background: url(/images/common/icon_warn.png) -100px -0px no-repeat;";
                } else if (type == "error") {
                    str = "background: url(/images/common/icon_warn.png) -97px -48px no-repeat;";
                } else if (type == "normal") {
                    str = "background: url(/images/common/icon_warn.png) -37px -94px no-repeat;";
                }
                return str;
            }())
        });
        var d = new Dialog({
            "content": html,
            "hasMask": true,
            "classPrefix": "remind-dialog",
            "closeTpl": "",
            "width": "auto"
        });
        d.after('show', function () {
            setTimeout(function () {
                d.hide();
                if ($.isFunction(fn)) {
                    fn()
                }
            }, timeout);
        });
        d.show();
    });
}

//确认弹出框
function confirmDialog(str, fn, isClose, beforeFn, isCancel) {
    var d = null;
    var isClose = isClose || "true";
    var title = "", content = "";
    if ($.type(str) == "string") {
        content = str;
    }
    if ($.type(str) == "object") {
        title = str.title;
        content = str.content;
    }
    if (fn == null && beforeFn == null) {
        return false;
    }

    seajs.use(["dialog", "i18n"], function (Dialog, I18n) {
        if ("" == title) title = I18n.prop("generic.tips");
        var isCancelStyle = isCancel ? "display: none" : "";
        d = new Dialog({
            "content": '<div id="confirmDialog"><div class="ui-head"><h3>'
            + title + '</h3></div><div class="confirm_bd"><div class="ta-c confirm-txt fz14">'
            + content + '</div><div class="operate"><a class="confirm_btn" href="javascript:;">'
            + I18n.prop("generic.confirm") + '</a>'
            + '<a class="cancel_btn" style="' + isCancelStyle + '" href="javascript:;">'
            + I18n.prop("generic.cancel") + '</a></div></div></div>',
            "width": 256
        });
        d.before("show", function () {
            if ($.isFunction(beforeFn)) {
                beforeFn(d);
            }
        })
        d.after("show", function () {
            $("#confirmDialog .confirm_btn").on("click", function () {
                if (isClose == "true") {
                    d.hide();
                }
                if ($.isFunction(fn)) {
                    fn(d);
                }
            });
        })
        d.show();
    });

    $(document).on("click", "#confirmDialog .cancel_btn", function () {
        d.hide();
    });

}


/**
 * 表单验证
 * @param json
 */
//[selector,isAjax,beforeSubmitFn,addElemFn]
function baseFormValidator(json) {
    // selector,isAjax,fn,editor
    var setting = {
        "isAjax": false
    }
    var config = $.extend(setting, json);
    seajs.use(["validator", "widget"], function (Validator, Widget) {
        Widget.autoRenderAll();
        var Core = Validator.query(config.selector);
        if (config.isAjax) {
            Core.set("autoSubmit", false);
        }
        if ($.isFunction(config.addElemFn)) {
            config.addElemFn(Core, Validator);
        }
        Core.on('formValidated', function (error) {
            if (!error) {
                if ($.isFunction(config.beforeSubmitFn)) {
                    config.beforeSubmitFn();
                }
            }
        });
    });
}

/**
 * 日期控件
 * @param elem
 * @param json
 * @param flag
 * @param dateFmt
 * @param minDate
 */
function baseCalendar(elem, json, flag, dateFmt, minDate) {
    seajs.use(["my97DatePicker"], function () {
        $(elem).on("click", function () {
            if (typeof flag != "undefined") {
                if (minDate == undefined) {
                    minDate = '%y-%M-%d';
                }
                var newjson = $.extend(json || {}, {minDate: minDate, dateFmt: dateFmt});
                WdatePicker(newjson);
            } else {
                WdatePicker(json || {});
            }
        })
    });
}

/**
 * 应用场景：起始日期，截止日期
 * @param start 起始的input ID
 * @param end  截止的input ID
 * @param flag  是否从今天开始
 * @param addClass  类型object 需要给input加一个类
 */
function rangeCalendar(start, end, flag, addClass) {
    doubleCalendar({
        start: start,
        end: end,
        flag: flag,
        addClass: addClass
    });
}

/**
 * 应用场景：起始日期，截止日期
 * @param start 起始的input ID
 * @param end  截止的input ID
 * @param flag  是否从今天开始
 * @param addClass  类型object 需要给input加一个类
 * @param cb 空间
 */
function rangeCalendarTime(start, end, flag, addClass, cb) {
    if (addClass) {
        $("#" + start).add("#" + end).addClass(addClass.name || "hasDatepicker");
    }

    seajs.use(["my97DatePicker"], function () {
        $("#" + start).on("focus", function () {
            if (typeof flag != "undefined") {
                WdatePicker({
                    maxDate: '#F{$dp.$D(\'' + end + '\')}',
                    minDate: '%y-%M-%d %H:%m',
                    dateFmt: 'yyyy-MM-dd HH:mm',
                    onpicked: function (a) {
                        cb && cb(a)
                    }
                });
            } else {
                WdatePicker({
                    maxDate: '#F{$dp.$D(\'' + end + '\')}', dateFmt: 'yyyy-MM-dd HH:mm',
                    onpicked: function (a) {
                        cb && cb(a)
                    }
                });
            }
        })

        $("#" + end).on("focus", function () {
            WdatePicker({
                minDate: '#F{$dp.$D(\'' + start + '\')}', dateFmt: 'yyyy-MM-dd HH:mm', onpicked: function (a) {
                    cb && cb(a)
                }
            });
        })
    });
}

function doubleCalendar(_config) {
    var config = $.extend({
        start: "",
        end: "",
        flag: "",
        addClass: "hasDatepicker",
        format: 'yyyy-MM-dd'
    }, _config);
    if (config.addClass) {
        $("#" + config.start, "#" + config.end).addClass(config.addClass);
    }

    seajs.use(["my97DatePicker"], function () {
        $("#" + config.start).on("focus", function () {
            if (config.flag) {
                WdatePicker({
                    maxDate: '#F{$dp.$D(\'' + config.end + '\')}',
                    minDate: '%y-%M-%d',
                    dateFmt: config.format
                });
            } else {
                WdatePicker({maxDate: '#F{$dp.$D(\'' + config.end + '\')}', dateFmt: config.format});
            }
        })

        $("#" + config.end).on("focus", function () {
            WdatePicker({minDate: '#F{$dp.$D(\'' + config.start + '\')}', dateFmt: config.format});
        })
    });
}


//重置错误信息（让错误信息隐藏）
function resetValidatorError(form) {
    var form = !form ? "" : form;
    $(form + " .ui-form-item").removeClass("ui-form-item-error");
    $(form + " .ui-form-explain").html("");
}

/**
 * 字符串截取
 * @param origText
 * @param length
 * @param ellipsisStr
 */
function trimLongString(origText, len, ellipsisStr) {
    var newText = "";
    var ellipsis = ellipsisStr || "...";
    if ($.type(origText) == "string") {
        newText = origText;
    }
    if (len > 0 && len < newText.length) {
        newText = newText.slice(0, len) + ellipsis;
    }

    return newText;
}

/**
 * 字符串截取
 * @param origText
 * @param length
 * @param ellipsisStr
 * 例YYYY年MM月DD日 HH:II:SS
 */
function form_unixtime(unixtime, format) {
    var unixtimestamp = new Date(unixtime);
    return format.replace("YYYY", unixtimestamp.getFullYear()).replace("MM", unixtimestamp.getMonth() + 1).replace("DD", unixtimestamp.getDate()).replace("HH", unixtimestamp.getHours()).replace("II", unixtimestamp.getMinutes()).replace("SS", unixtimestamp.getSeconds());
}

function form_unixtimeFull(unixtime, format) {
    function fill_zero(i) {
        if (i < 10) i = "0" + i;
        return i;
    }

    var unixtimestamp = new Date(unixtime);
    return format.replace("YYYY", unixtimestamp.getFullYear())
        .replace("MM", fill_zero(unixtimestamp.getMonth() + 1)).replace("DD", fill_zero(unixtimestamp.getDate()))
        .replace("HH", fill_zero(unixtimestamp.getHours())).replace("II", fill_zero(unixtimestamp.getMinutes()))
        .replace("SS", fill_zero(unixtimestamp.getSeconds()));
}

/**
 * 判断是否是金额
 * @param str 具体的金额值
 * @returns {boolean}
 */
function isAmount(str) {
    return /^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/.test(str);
}


// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2014-05-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2014-5-2 8:9:4.18
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * 跳转到指定的地址
 * @param url
 */
function jumpUrl(url) {
    window.location.href = url;
}

