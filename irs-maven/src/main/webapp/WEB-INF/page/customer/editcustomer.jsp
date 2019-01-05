<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>修改客户</title>
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
	<input type="hidden" name="id" value="${customer.id }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">客户编号</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" placeholder="请输入客户编号" name="number" value="${customer.number }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入客户名称" name="name" value="${customer.name }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户等级</label>
			<div class="layui-input-block">
				<input type="radio" name="grade" value="0" title="普通客户" <c:if test="${customer.grade eq '0'}"> checked="checked"</c:if>>
				<input type="radio" name="grade" value="1" title="VIP客户"  <c:if test="${customer.grade eq '1'}"> checked="checked"</c:if>>
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">客户性别</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" value="0" title="男" <c:if test="${customer.sex eq '0'}"> checked="checked"</c:if>>
				<input type="radio" name="sex" value="1" title="女" <c:if test="${customer.sex eq '1'}"> checked="checked"</c:if>>
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">客户证件号</label>
			<div class="layui-input-block">
				<input type="text" name="carded" class="layui-input userName"
					   placeholder="请输入客户证件号" value="${customer.carded }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户地址</label>
			<div class="layui-input-block">
				<input type="text" name="address" class="layui-input userName"
					   placeholder="请输入商品价格" value="${customer.address }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" class="layui-input userName"
					   placeholder="请输入客户电话" value="${customer.phone }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户QQ</label>
			<div class="layui-input-block">
				<input type="text" name="qq" class="layui-input userName"
					   placeholder="请输入客户QQ" value="${customer.qq }">
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="editCustomer">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/customer/editcustomer.js"></script>
</body>
</html>