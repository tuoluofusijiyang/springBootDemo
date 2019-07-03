<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/pages/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><msg:message code="system.name"/></title>
    <meta name="keywords" content="<msg:message code="system.name"/>">
    <meta name="description" content="<msg:message code="system.name"/>">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${base}/${skin}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/${skin}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <!-- jqgrid-->
    <link href="${base}/${skin}/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
    <link href="${base}/${skin}/css/plugins/poshytip/tip-violet.css" rel="stylesheet">

    <link href="${base}/${skin}/css/animate.css" rel="stylesheet">
    <link href="${base}/${skin}/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<!-- 全局js -->
<script src="${base}/${skin}/js/jquery.min.js?v=2.1.4"></script>
<script src="${base}/${skin}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${base}/${skin}/js/plugins/poshytip/jquery.poshytip.js"></script>
<script src="${base}/${skin}/js/plugins/poshytip/jquery.poshytip-t.plugin.js"></script>
<!-- jqGrid -->
<script src="${base}/${skin}/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script src="${base}/${skin}/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
<script src="${base}/${skin}/js/plugins/jqgrid/jquery.jqGrid.tree.plugin.js?0820"></script>
<!-- 自定义js -->
<script src="${base}/${skin}/js/content.js?v=1.0.0"></script>
<script type="text/javascript">
    $(document).ready(function () {
        tab(1);
        var options = {
            event: 'focus',
            ajax: {
                url: '${base}/website/websitesetting/valid.json'
            },
            validStatus: function (status) {
                //status 返回结果为true 代表验证全部通过
                if (status) {
                    $("form#websitesetting").submit();
                }
            }
        };
        $("form #btnok1").valid(options);
        $("form #btnok2").valid(options);

        $("#uploadify").uploadify({
            //指定uploadify.swf路径
            'swf': '${base}/common/flash/uploadify/uploadify.swf',
            //后台处理的请求的servlet,同时传递参数,由于servlet只能接收一个参数，所以将两个参数合并成一个
            'uploader': '${base}/website/websitesetting/uploadfile;jsessionid=<%=session.getId()%>',
            //按钮样式
            'buttonClass': 'btn2',
            //选择文件的容器
            'queueID': 'fileQueue',
            //上传表单名
            'file_post_name': 'Filedata',
            //队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
            'progressData': 'all',
            //上传成功后的文件，是否在队列中自动删除
            'removeCompleted': true,
            //是否自动上传，即选择了文件即刻上传
            'auto': false,
            //是否允许同时上传多文件，默认false
            'multi': false,
            //说明
            'fileTypeDesc': "文件类型",
            'fileTypeExts': "*.jpg;*.jpeg;*.gif;*.png;*.bmp",
            'buttonText': "<msg:message code='info.prompt.select'/>",
            'width': 60,
            'height': 24,
            'fileSizeLimit': '5MB',
            //上传数量限制
            'queueSizeLimit': 1,
            'onInit': function () {
                var pi = "${websitesetting.logo}";
                if (pi != "") {
                    $("#delImg").css("color", "#000");
                    $("#fileDel").html("<img height='100' width='100' src='${basePath}${websitesetting.logo}'>");
                    loadPIMG = true;
                } else {
                    $("#delImg").css("color", "#CCC");
                }

            },
            'onSelectError': function (file, errorCode, errorMsg) {
                var settings = this.settings;
                if ($.inArray('onSelectError', settings.overrideEvents) < 0) {
                    if (errorCode = SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
                        if (settings.queueSizeLimit > errorMsg) {
                            this.queueData.errorMsg = '只能上传唯一标题图片';
                        }
                    }
                }
            },
            'onUploadSuccess': function (file, data, response) {
                if (response == true) {
                    var showpath = "<div id='inforTitleImage'><img height='100' width='100' src='${basePath}" + data + "'>";
                    showpath += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                    showpath += "<a href='#' class='uploadAct' onclick=\"del('inforTitleImage')\">删除</a></div>";
                    $("#fileDel").html(showpath);
                    $("#logo").val(data);
                } else {
                    window.parent.Boxy.alert("上传失败", null, {title: "<msg:message code='info.prompt'/>"});
                }
            }
        });
    });

    //删除上传文件
    function del(inforTitleImage) {
        $('#' + inforTitleImage).remove();
        $("#logo").val('');
    }

    function tab(tag) {
        for (var i = 1; i <= 3; i++) {
            if (i == tag) {
                $("#tab_" + i).addClass("selected");
                $("#div_" + i).css("visibility", "visible");
            } else {
                $("#tab_" + i).removeClass("selected");
                $("#div_" + i).css("visibility", "hidden");
            }
        }
    }
</script>
</head>
<body class="gray-bg">
<input type="hidden" name="id" value="${websitesetting.id}"/>
<input type="hidden" name="c" value="${websitesetting.c}"/>
<input type="hidden" name="prompt" value="name"/>
<input type="hidden" name="operate" value="1"/>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-title">
                    <h5>网站管理 / 网站设置</h5>
                </div>
                <div class="ibox-content tabs-container">
                    <ul id="tabnav" class="nav nav-tabs">
                        <li id="tab_1" onclick="tab(1)" class="active" ><a><msg:message code="websitesetting.basicinformation"/></a></li>
                        <li id="tab_2" onclick="tab(2)"><a><msg:message code="websitesetting.extendedinformation" /></a></li>
                        <li id="tab_3" onclick="tab(3)"><a><msg:message code="websitesetting.systemuploadservice" /></a></li>
                    </ul>

                    <div class="tab-content tab-div-content">
                        <div id="div_1" class="tab-div-show">
                            <div class="panel-body">

                                <div class="ibox-content clearfix">

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.name"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="name" maxlength='20' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.title"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="title" maxlength='20' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.platformCode"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="platformCode" maxlength='30' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.websites"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="websites" onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.mobileWebsites"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="mobileWebsites" onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.apiUrl"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="apiUrl" onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.istest"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:select path="tested">
                                                <form:option value="">--请选择--</form:option>
                                                <form:option value="0">否</form:option>
                                                <form:option value="1">是</form:option>
                                            </form:select>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.keyword"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="keyword" maxlength='20' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.copyright"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="copyright" maxlength='20' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.logo"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:hidden path="logo"/>
                                            <div id="fileQueue"></div>
                                            <input type="file" name="file_upload" id="uploadify"/>
                                            <div id="fileOperateInfo">
                                                <a href="javascript:$('#uploadify').uploadify('cancel', '*')">
                                                    取消上传</a> |
                                                <a href="javascript:$('#uploadify').uploadify('upload', '*')">
                                                    开始上传</a>
                                            </div>
                                            <div id="fileDel"></div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.description"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:textarea path="description" maxlength='100' rows="4" cols="30"  onchange="this.value=$.trim(this.value)" cssStyle="width: 100%; height: atuo;"/>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.channelOrgCode"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="channelOrgCode" maxlength='20' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.channelOrgName"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="channelOrgName" maxlength='20' onchange="this.value=$.trim(this.value)"/>
                                        </div>
                                    </div>

                                </div>


                            </div>
                        </div>

                        <div id="div_2" class="tab-div-hide">
                            <div class="panel-body">
                                <div class="ibox-content clearfix">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.passworderr"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:input path="pwdErrorNum" maxlength='20' onchange="this.value=$.trim(this.value)" onkeyup="value=value.replace(/[^\d]/g,'')"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.mrbz"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:select path="currency">
                                                <form:option value="">--请选择--</form:option>
                                                <form:option value="1">人民币</form:option>
                                            </form:select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.issh"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:select path="IsDashCash">
                                                <form:option value="">--请选择--</form:option>
                                                <form:option value="0">否</form:option>
                                                <form:option value="1">是</form:option>
                                            </form:select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <msg:message code="websitesetting.issh"/><msg:message code="system.common.sign.colon"/>
                                        </label>
                                        <div class="col-sm-6">
                                            <form:select path="IsDashCash">
                                                <form:option value="">--请选择--</form:option>
                                                <form:option value="0">否</form:option>
                                                <form:option value="1">是</form:option>
                                            </form:select>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
