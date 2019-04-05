<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>添加单车</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<script>  
        <%--JS gloable varilible--%>  
        var ctx = "${ctx}";  
    </script>  
<style type="text/css">
.layui-form-item .layui-inline {
	width: 33.333%;
	float: left;
	margin-right: 0;
}

@media ( max-width :1240px) {
	.layui-form-item .layui-inline {
		width: 100%;
		float: none;
	}
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width: 80%;" id="aaf">
		<div class="layui-form-item">
			<label class="layui-form-label">单车名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					lay-verify="required" placeholder="请输入单车名称" name="name" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">单车编号</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					    placeholder="请输入单车编号" name="number" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">单车类型</label>
			<div class="layui-input-block">
				<select name="type" lay-filter="aihao" lay-verify="required">
				<c:forEach items="${bicycleTypeVos}" var="var" varStatus="vs">
					<option value="${var.id}"  > ${var.name}</option>
				</c:forEach>
				</select>
			</div>
		</div>
        <div class="layui-form-item">
            <label class="layui-form-label">单车数量</label>
            <div class="layui-input-block">
                <input type="text" name="count" class="layui-input userName"
                       placeholder="单车数量" value="${bicycle.count }">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单车价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" class="layui-input userName"
                       placeholder="请输入单车价格" value="">
            </div>
        </div>
<%--		<div class="layui-form-item">
			<label class="layui-form-label">单车状态</label>
			<div class="layui-input-block">
				<select name="status" lay-filter="aihao" lay-verify="required">
					<c:forEach items="${suppliers}" var="var" varStatus="vs">
						<option value="${var.id}"  > ${var.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>--%>


		<div class="layui-form-item">
			<label class="layui-form-label">单车价格</label>
			<div class="layui-input-block">
				<input type="text" name="price" class="layui-input userName"
					    placeholder="请输入单车价格" value="">
			</div>
		</div>

		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addbicycle">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/bicycle/addbicycle.js"></script>
</body>
</html>