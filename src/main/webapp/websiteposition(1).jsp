<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.role/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/pages/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="${base}/${skin}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/${skin}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <!-- jqgrid-->
    <link href="${base}/${skin}/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
    <link href="${base}/${skin}/css/plugins/poshytip/tip-violet.css" rel="stylesheet">

    <link href="${base}/${skin}/css/animate.css" rel="stylesheet">
    <link href="${base}/${skin}/css/style.css?v=4.1.0" rel="stylesheet">

    <!-- 全局js -->
    <script src="${base}/${skin}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${base}/${skin}/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- Peity -->
    <script src="${base}/${skin}/js/plugins/peity/jquery.peity.min.js"></script>

    <!-- jqGrid -->
    <script src="${base}/${skin}/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
    <script src="${base}/${skin}/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
    <script src="${base}/${skin}/js/plugins/jqgrid/jquery.jqGrid.tree.plugin.js?0820"></script>

    <!-- 自定义js -->
    <script src="${base}/${skin}/js/content.js?v=1.0.0"></script>


    <%--
    <script type="text/javascript" src="${base}/common/js/jquery-1.8.min.js"></script>
    <script type="text/javascript" src="${base}/common/js/jquery.json-2.2.min.js"></script>
    <script src="${base}/common/js/jqgrid/grid.locale-cn.js" type="text/javascript"></script>
    <script src="${base}/common/js/jqgrid/jquery.jqGrid.src.js" type="text/javascript"></script>
    <script src="${base}/common/js/json2.js" type="text/javascript"></script> --%>
    <script type="text/javascript">
        var count = 0;
        $(document).ready(function(){
            jQuery("#valueList").jqGrid({
                datatype: "local",
                colNames: ["<msg:message code='attribute.value.source.key'/><font color=\"red\">&nbsp;*&nbsp;</font>",
                    "<msg:message code='attribute.value.source.value'/><font color=\"red\">&nbsp;*&nbsp;</font>",
                    "<i class='glyphicon glyphicon-plus' id='addRow'></i>"
                ],
                colModel: [
                    {name: 'key',index:'key',width:'45%',align:'center',hidden: false,sortable:false},
                    {name: 'value',index:'value',width:'45%',align:'center',hidden: false,sortable:false},
                    {name: 'operate',index:'operate',width:'10%',align:'center',hidden: false,sortable:false}
                ],
                height:'auto',
                autowidth:false,
                width:'420'
            });
            $('#addRow').click(function(){
                var data={
                    key:"<input type='text' id='key"+(parseInt(count)+1)+"' onclick=\"changeStyle('key"+(parseInt(count)+1)+"');\"  maxlength='25'  style='width:80%;'/>",
                    value:"<input type='text' id='value"+(parseInt(count)+1)+"' onclick=\"changeStyle('value"+(parseInt(count)+1)+"');\" maxlength='30'  style='width:80%;'/>",
                    operate:"<a href='javascript:void(0);' id='" + (parseInt(count)+1) + "' onclick='delRow(this);'><i class='glyphicon glyphicon-remove'></i></a>"
                };
                jQuery("#valueList").jqGrid('addRowData',(parseInt(count)+1),data);
                count++;
                autoHeight();
            });
            //addRow
            if("${type}" == "3"){
                if("${value}" != ""){
                    var values = "${value}".split("*");
                    for(var i = 0 ; i < values.length ; i++){
                        var data_db={
                            key:"<input type='text' value='"+values[i].split(":")[0]+"' id='key"+(parseInt(count)+1)+"' onclick=\"changeStyle('key"+(parseInt(count)+1)+"');\"  maxlength='25'  style='width:80%;'/>",
                            value:"<input type='text' value='"+values[i].split(":")[1]+"' id='value"+(parseInt(count)+1)+"' onclick=\"changeStyle('value"+(parseInt(count)+1)+"');\" maxlength='30'  style='width:80%;'/>",
                            operate:"<a href='javascript:void(0);' id='" + (parseInt(count)+1) + "' onclick='delRow(this);'><img src='${base}/${skin}/images/icon/reduce.png' width='20' height='20'/></a>"
                        };
                        count++;
                        jQuery("#valueList").jqGrid('addRowData',count,data_db);
                    }
                }
                autoHeight();
            }
        });
        function autoHeight(){
            var main = $(window.parent.document).find("#valueFrame");
            var thisheight = $(document).height();
            main.height(thisheight);
        }
        function delRow(o){
            var rowid = $(o).attr("id");
            jQuery("#valueList").jqGrid('delRowData',rowid);
            autoHeight();
        }
        function changeTab(object){
            var id = $(object).attr("id").split("_")[1];
            for (var i=1;i<4;i++){
                if(id==i){
                    $("#div_"+i).css("display","");
                    //$(object).attr("class","nav_1");
                    //$("#div_"+i).css({"visibility":"visible"});
                    $(object).addClass("active nav_1");
                }else{
                    $("#div_"+i).css("display","none");
                    //$("#div_"+i).css({"visibility":"hidden"});
                    $("#li_"+i).attr("class","");
                    $("#li_"+i).removeClass("active");
                }
            }
            autoHeight();
        }

        function submit(){
            var type = $(".nav_1").attr("id").split("_")[1];
            var valueString = "";
            if(type == 1){
                if($('#dictionaryValue').val()==null || $('#dictionaryValue').val() == ''){
                    $('#errorValueMessage').text("<msg:message code='please.select.dictionary'/>");
                    return false;
                }else{
                    valueString = $('#dictionaryValue').val();
                }
            }else if(type ==2){
                if($('#localValue').val()==null || $('#localValue').val() == ''){
                    $('#errorValueMessage').text("<msg:message code='please.select.local'/>");
                    return false;
                }else{
                    valueString = $('#localValue').val();
                }
            }else if(type ==3){
                var ids = jQuery("#valueList").jqGrid('getDataIDs');
                var keys = new Array();
                var values = new Array();
                for(var i=0;i < ids.length;i++){
                    var id = ids[i];
                    var key = $("#key"+id).val();
                    var value = $("#value"+id).val();
                    if(key == "<msg:message code='attribute.value.source.key.exist'/>"){
                        $("#key"+id).attr("class","prompt");
                        return false;
                    }
                    if(value == "<msg:message code='attribute.value.source.key.exist'/>"){
                        $("#value"+id).attr("class","prompt");
                        return false;
                    }
                    if(key == "" || key == null){
                        $("#key"+id).attr("class","prompt");
                        $("#key"+id).val("<msg:message code='please.input'/>");
                        return false;
                    }
                    if(key!=""&& getArrayCount(key,keys)>0){
                        $("#key"+id).attr("class","prompt");
                        $("#key"+id).val("<msg:message code='attribute.value.source.key.exist'/>");
                        return false;
                    }if(key!=""&& getArrayCount(key,keys)<=0){
                        keys.push(key);
                    }
                    if(value == ""||value == null){
                        $("#value"+id).attr("class","prompt");
                        $("#value"+id).val("<msg:message code='please.input'/>");
                        return false;
                    }
                    if(value!=""&& getArrayCount(value,values)>0){
                        $("#value"+id).attr("class","prompt");
                        $("#value"+id).val("<msg:message code='attribute.value.source.key.exist'/>");
                        return false;
                    }
                    if(value!=""&& getArrayCount(value,values)<=0){
                        values.push(value);
                    }
                    valueString += key+":";
                    valueString += value;
                    if(i != ids.length-1)
                        valueString += "*";
                }
            }
            top.document.getElementById("${iframeId}").contentWindow.attributeValueBoxySubmit("${id}",type+"_"+valueString);
            top.layer.close(top.attributeValueBoxy);
        }
        function getArrayCount(temp,array){
            var count = 0;
            for(var i=0; i < array.length; i++){
                if(temp == array[i]){
                    count++;
                }
            }
            return count;
        }
        function changeStyle(object){
            if($("#"+object).attr("class") == "prompt"){
                $("#"+object).val("");
                $("#"+object).attr("class","normal");
            }
        }
    </script>
    <style type="text/css">
        .prompt{
            color:red;
        }
        .normal{
            color:black;
        }
    </style>
</head>
<body width="100%" class="gray-bg">
<table cellSpacing=1 cellPadding=0 border=0 width="100%">
    <tr>
        <td style='border-bottom:5px solid #B4B1CE;white-space:nowrap;'>
            <div class='mainNav'>
                <ul id="tabnav" class="nav nav-tabs">
                    <li id='li_1' style='cursor: pointer;' <c:if test="${type == 1}">class='nav_1 active'</c:if> onclick='changeTab(this)'>
                        <a><msg:message code='attribute.value.source.dictionary'/></a>
                    </li>
                    <!--
							<li id='li_2' style='cursor: pointer;' <c:if test="${type == 2}">class='nav_1'</c:if> onclick='changeTab(this)'>
								<div  class='mainFont'><msg:message code='attribute.value.source.local'/></div>
							</li>
						 -->
                    <li id='li_3' style='cursor: pointer;' <c:if test="${type == 3}">class='nav_1'</c:if> onclick='changeTab(this)'>
                        <%-- 							<div  class='mainFont'><msg:message code='attribute.value.source.defined'/></div> --%>
                        <a><msg:message code='attribute.value.source.defined'/></a>
                    </li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <div id='div_1' <c:if test="${type != 1}">style='display:none;'</c:if>>
                <table cellpadding='0' cellspacing='1' border='0' width='100%' class='skinLayout'>
                    <tr>
                        <td width='30%' align='right' class='skinLayout_info'><msg:message code='attribute.value.source.dictionary.type'/></td>
                        <td width='70%'  style='border:1px solid #A6C9E2;'>
                            <select id='dictionaryValue' style='width:80%;'>
                                <c:forEach var="dictionary" items="${dictionaryList}">
                                    <option <c:if test="${type == 1 && value ==dictionary.code}">selected</c:if> value="${dictionary.code}">${dictionary.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            <!--
					<div id='div_2' <c:if test="${type != 2}">style='display:none;'</c:if>>
						<table cellpadding='0' cellspacing='1' border='0' width='100%' class='skinLayout'>
							<tr>
								<td width='30%' align='right' class='skinLayout_info'><msg:message code='attribute.value.source.local.type'/></td>
								<td width='70%'  style='border:1px solid #A6C9E2;'>
									<select id='localValue' style='width:80%;'>
										<c:forEach var="local" items="${localList}">
											<option <c:if test="${type == 2 && value ==local.id}">selected</c:if> value="${local.id}">${local.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
					</div>
				 -->
            <div id='div_3' <c:if test="${type != 3}">style='display:none;'</c:if>>
                <table cellpadding='0' cellspacing='0' border='0' width='100%'>
                    <tr>
                        <td>
                            <table id="valueList"><tr><td>&nbsp;</td></tr></table>
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <td align='center'><span id='errorValueMessage' style='color:red;'></span>&nbsp;&nbsp;&nbsp;<input type='button' value='<msg:message code='button.save'/>' class='boxy-btn1'  style='cursor:pointer' onclick='submit();'/></td>
    </tr>
</table>
</body>
</html>