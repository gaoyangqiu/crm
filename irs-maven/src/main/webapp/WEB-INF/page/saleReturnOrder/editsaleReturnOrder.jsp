<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>修改销售退货单</title>
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
	<input type="hidden" name="id" value="${saleReturnOrder.id }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">销售单编号</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" placeholder="请输入销售单编号" name="number" value="${saleReturnOrder.number}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品ID</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required"	   placeholder="请输入商品ID" name="type" value="${saleReturnOrder.type}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">销售价格</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入价格" name="salePrice" value="${saleReturnOrder.salePrice}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">数量</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入数量" name="amount" value="${saleReturnOrder.amount}">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">产地</label>
			<div class="layui-input-block">
				<input type="text" name="home" class="layui-input userName"
					   placeholder="请输入产地" value="${saleReturnOrder.home}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">供应商</label>
			<div class="layui-input-block">
				<input type="text" name="supplierId" class="layui-input userName"
					   lay-verify="required"		   placeholder="请输入供应商ID" value="${saleReturnOrder.supplierId}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户</label>
			<div class="layui-input-block">
				<input type="text" name="customerId" class="layui-input userName"
					   lay-verify="required"    placeholder="请输入客户ID" value="${saleReturnOrder.customerId}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">批号</label>
			<div class="layui-input-block">
				<input type="text" name="batchNumber" class="layui-input userName"
					   placeholder="请输入批号" value="${saleReturnOrder.batchNumber}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">批准文号</label>
			<div class="layui-input-block">
				<input type="text" name="approvalNumber" class="layui-input userName"
					   placeholder="请输入批准文号" value="${saleReturnOrder.approvalNumber}">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="editSaleReturnOrder">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/saleReturnOrder/editsaleReturnOrder.js"></script>
</body>
</html>