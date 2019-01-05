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
	<input type="hidden" name="id" value="${supplier.id }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">企业名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" placeholder="请输入企业名称" name="name" value="${supplier.name}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">供应商地址</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入地址" name="address" value="${supplier.address}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">邮编</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入邮编" name="postCode" value="${supplier.postCode}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入电话" name="phone" value="${supplier.phone}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">联系人</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入联系人" name="contact" value="${supplier.contact}">
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">联系人电话</label>
			<div class="layui-input-block">
				<input type="text" name="contactPhone" class="layui-input userName"
					   placeholder="请输入联系人电话" value="${supplier.contactPhone}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" name="mail" class="layui-input userName"
					   placeholder="请输入邮箱" value="${supplier.mail}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">开户银行</label>
			<div class="layui-input-block">
				<input type="text" name="bank" class="layui-input userName"
					   placeholder="请输入开户银行" value="${supplier.bank}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-block">
				<input type="text" name="account" class="layui-input userName"
					   placeholder="请输入账号" value="${supplier.account}">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="editSupplier">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/supplier/editsupplier.js"></script>
</body>
</html>