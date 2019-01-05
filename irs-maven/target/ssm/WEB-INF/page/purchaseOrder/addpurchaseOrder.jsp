<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>添加采购单</title>
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
			<label class="layui-form-label">采购单编号</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" placeholder="请输入采购单编号" name="number" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品ID</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required"   placeholder="请输入商品ID" name="type" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">价格</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入价格" name="price" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">数量</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入数量" name="amount" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">金额</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入金额" name="money" value="">
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">产地</label>
			<div class="layui-input-block">
				<input type="text" name="home" class="layui-input userName"
					   placeholder="请输入产地" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">供应商</label>
			<div class="layui-input-block">
				<input type="text" name="supplier" class="layui-input userName"
					   lay-verify="required"	   placeholder="请输入供应商ID" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" name="remark" class="layui-input userName"
					   placeholder="请输入备注" value="">
			</div>
		</div>

<%--		<div class="layui-form-item">
			<label class="layui-form-label">经手人</label>
			<div class="layui-input-block">
				<input type="text" name="sticks" class="layui-input userName"
					   placeholder="请输入经手人" value="">
			</div>
		</div>--%>

		<div class="layui-form-item">
			<label class="layui-form-label">批号</label>
			<div class="layui-input-block">
				<input type="text" name="batchNumber" class="layui-input userName"
					   placeholder="请输入账号" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">批准文号</label>
			<div class="layui-input-block">
				<input type="text" name="approvalNumber" class="layui-input userName"
					   placeholder="请输入账号" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addSupplier">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/purchaseOrder/addpurchaseOrder.js"></script>
</body>
</html>