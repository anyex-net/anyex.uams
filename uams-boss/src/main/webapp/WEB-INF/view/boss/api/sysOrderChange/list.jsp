<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var sysOrderChangeDataGrid;
    $(function () {
        sysOrderChangeDataGrid = $('#sysOrderChangeDataGrid').datagrid({
            url: '${ctx}/api/sysOrderChange/data',
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            idField: 'id',
            sortName: 'id',
            sortOrder: 'asc',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100],
            frozenColumns:[[
                {
                    width: '100',
                    title: '客户资金帐号',
                    field: 'accountNo',
                    sortable: true
                }
            ]],
            columns: [[
                {
                    width: '100',
                    title: '外层错误码',
                    field: 'errorCode1',
                    sortable: true
                },
                {
                    width: '100',
                    title: '是否T+1有效',
                    field: 'addOneIsValid',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },
                {
                    width: '100',
                    title: '看涨看跌1',
                    field: 'callOrPutFlag',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="C"){
                            return "买权"
                        }else if(value.trim()=="P"){
                            return "卖权"
                        }else{
                            return "无"
                        }
                    }
                },
                {
                    width: '100',
                    title: '看涨看跌2',
                    field: 'callOrPutFlag2',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="C"){
                            return "买权"
                        }else if(value.trim()=="P"){
                            return "卖权"
                        }else{
                            return "无"
                        }
                    }
                },{
                    width: '100',
                    title: '客户子账号',
                    field: 'clientID',
                    sortable: true
                },
                {
                    width: '100',
                    title: '终端网络地址',
                    field: 'clientIP',
                    sortable: true
                },
                {
                    width: '100',
                    title: '终端本地IP',
                    field: 'clientLocalIP',
                    sortable: true
                },
                {
                    width: '100',
                    title: '终端本地Mac地址',
                    field: 'clientMac',
                    sortable: true
                },
                {
                    width: '100',
                    title: '客户端本地委托编号',
                    field: 'clientOrderNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '品种编号',
                    field: 'commodityNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '品种类型',
                    field: 'commodityType',
                    sortable: true
                },
                {
                    width: '100',
                    title: '合约1',
                    field: 'contractNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '合约2',
                    field: 'contractNo2',
                    sortable: true
                },
                {
                    width: '100',
                    title: '里层错误码',
                    field: 'errorCode',
                    sortable: true
                },
                {
                    width: '100',
                    title: '错误信息',
                    field: 'errorText',
                    sortable: true
                },
                {
                    width: '100',
                    title: '交易所编号',
                    field: 'exchangeNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '有效日期(GTD情况下使用)',
                    field: 'expireTime',
                    sortable: true
                },
                {
                    width: '100',
                    title: '投机保值',
                    field: 'hedgeFlag',
                    sortable: true
                },
                {
                    width: '100',
                    title: '询价号',
                    field: 'inquiryNo',
                    sortable: true
                },{
                    width: '100',
                    title: '是否为T+1单',
                    field: 'isAddOne',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },{
                    width: '100',
                    title: '是否为录入委托单',
                    field: 'isBackInput',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },{
                    width: '100',
                    title: '委托成交删除标志',
                    field: 'isDeleted',
                    sortable: false
                },{
                    width: '100',
                    title: '是否风险报单',
                    field: 'isRiskOrder',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="N"){
                            return "否"
                        }else{
                            return "是"
                        }
                    }
                },{
                    width: '100',
                    title: '软件授权号',
                    field: 'licenseNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '冰山单最大随机量',
                    field: 'maxClipSize',
                    sortable: true
                },
                {
                    width: '100',
                    title: '冰山单最小随机量',
                    field: 'minClipSize',
                    sortable: true
                },
                {
                    width: '100',
                    title: '录单操作人',
                    field: 'orderCommandUserNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '交易所系统号',
                    field: 'orderExchangeSystemNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '下单时间',
                    field: 'orderInsertTime',
                    sortable: true
                },
                {
                    width: '100',
                    title: '下单人',
                    field: 'orderInsertUserNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '本地号',
                    field: 'orderLocalNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交价1',
                    field: 'orderMatchPrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交价2',
                    field: 'orderMatchPrice2',
                    sortable: true
                },
                {
                    width: '100',
                    title: '成交量1',
                    field: 'orderMatchQty',
                    sortable: true
                },{
                    width: '100',
                    title: '成交量2',
                    field: 'orderMatchQty2',
                    sortable: true
                },
                {
                    width: '100',
                    title: '最小成交量',
                    field: 'orderMinQty',
                    sortable: true
                }
                ,
                {
                    width: '100',
                    title: '委托编码',
                    field: 'orderNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '父单系统号',
                    field: 'orderParentSystemNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托价格1',
                    field: 'orderPrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托价格2',
                    field: 'orderPrice2',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托数量',
                    field: 'orderQty',
                    sortable: true
                },{
                    width: '100',
                    title: '买入卖出',
                    field: 'orderSide',
//                    sortable: true
                    formatter: function (value, row, index) {
                        alert(value);
                        if(value.trim()=="S"){
                            return "卖出";
                        }else if(value.trim()=="B"){
                            return "买入";
                        }else {
                            return "无";
                        }
                    }
                },{
                    width: '100',
                    title: '委托来源',
                    field: 'orderSource',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="1"){
                            return "自助电子单 ";
                        }else if(value.trim()=="2"){
                            return "代理电子单 ";
                        }else if(value.trim()=="3"){
                            return "外部电子单";
                        }else if(value.trim()=="4"){
                            return "人工录入单";
                        }else if(value.trim()=="5"){
                            return "carry单";
                        }else if(value.trim()=="6"){
                            return "程式化报单 ";
                        }else if(value.trim()=="7"){
                            return "交割行权 ";
                        }else if(value.trim()=="8"){
                            return "期权放弃 ";
                        }else if(value.trim()=="9"){
                            return "通道费";
                        }else {
                            return "易盛API ";
                        }
                    }
                },{
                    width: '100',
                    title: '委托状态',
                    field: 'orderState',
                    sortable: true
                },{
                    width: '100',
                    title: '委托流水号',
                    field: 'orderStreamID',
                    sortable: true
                },
                {
                    width: '100',
                    title: '系统号',
                    field: 'orderSystemNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托类型',
                    field: 'orderType',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托更新时间',
                    field: 'orderUpdateTime',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托更新人',
                    field: 'orderUpdateUserNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '开平标志1',
                    field: 'positionEffect',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="C"){
                            return "平仓";
                        }else if(value.trim()=="T"){
                            return "平当日";
                        }else if(value.trim()=="N"){
                            return "不分开平";
                        }else {
                            return "开仓";
                        }
                    }
                },
                {
                    width: '100',
                    title: '开平标志2',
                    field: 'positionEffect2',
//                    sortable: true
                    formatter: function (value, row, index) {
                        if(value.trim()=="C"){
                            return "平仓";
                        }else if(value.trim()=="T"){
                            return "平当日";
                        }else if(value.trim()=="N"){
                            return "不分开平";
                        }else {
                            return "开仓";
                        }
                    }
                },
                {
                    width: '100',
                    title: '浮点参考值',
                    field: 'refDouble',
                    sortable: true
                },
                {
                    width: '100',
                    title: '整型参考值',
                    field: 'refInt',
                    sortable: true
                },
                {
                    width: '100',
                    title: '字符串参考值',
                    field: 'refString',
                    sortable: true
                },
                {
                    width: '100',
                    title: '服务器标识',
                    field: 'serverFlag',
                    sortable: true
                },
                {
                    width: '100',
                    title: '触发价格',
                    field: 'stopPrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '执行价格1',
                    field: 'strikePrice',
                    sortable: true
                },
                {
                    width: '100',
                    title: '执行价格2',
                    field: 'strikePrice2',
                    sortable: true
                },
                {
                    width: '100',
                    title: '策略单类型',
                    field: 'tacticsType',
                    sortable: true
                },
                {
                    width: '100',
                    title: '委托有效类型',
                    field: 'timeInForce',
                    sortable: true
                },
                {
                    width: '100',
                    title: '触发条件',
                    field: 'triggerCondition',
                    sortable: true
                },
                {
                    width: '100',
                    title: '触发价格类型',
                    field: 'triggerPriceType',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手通道号',
                    field: 'upperChannelNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手号',
                    field: 'upperNo',
                    sortable: true
                },
                {
                    width: '100',
                    title: '上手流号',
                    field: 'upperStreamID',
                    sortable: true
                },
                {
                    width: '100',
                    title: '会话ID',
                    field: 'sessionID',
                    sortable: true
                },
                {
                    width: '100',
                    title: '备注',
                    field: 'remark',
                    sortable: true
                },
                {
                    width: '150',
                    title: '创建时间',
                    field: 'createDate',
                    sortable: true,
                    formatter: function (value, row, index) {
                        if(value!=null){
                            return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                        }else {
                            return "";
                        }
                    }
                },
                {
                    width: '150',
                    title: '修改时间',
                    field: 'updateDate',
                    sortable: true,
                    formatter: function (value, row, index) {
                        if(value!=null){
                            return new Date(parseInt(value)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                        }else {
                            return "";
                        }
                    }
                }
            ]]
        });

        $("#curreListSysOrderChangeTd").html(dictDropDownOptionsList('currencyList','currency', 'currency','', 'required:true,',  'width:142px,'));
        $("#currencyListSysOrderChange").combobox({
            valueField:'code',
            textField:'name'
        });

    });

    function searchSysOrderChangeFun() {
        sysOrderChangeDataGrid.datagrid('load', $.serializeObject($('#searchSysOrderChangeForm')));
    }
    function cleanSysOrderChangeFun() {
        $('#searchSysOrderChangeForm input').val('');
        sysOrderChangeDataGrid.datagrid('load', {});
    }
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchSysOrderChangeForm">
            <table style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden; width: auto; float: left;">
                <tr>
                    <th>账户</th>
                    <td><input name="accountName" placeholder="请输入账户" style="width:100px;"/></td>
                    <th>币种:</th>
                    <td id="currencyListSysOrderChangeTd"></td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchSysOrderChangeFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanSysOrderChangeFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="sysOrderChangeDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

