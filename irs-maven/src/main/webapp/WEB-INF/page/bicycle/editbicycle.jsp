<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>添加管理员</title>
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
	<input type="hidden" name="id" value="${goods.id }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" placeholder="请输入商品名称" name="name" value="${goods.name }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品规格</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   placeholder="请输入商品规格" name="specifications" value="${goods.specifications }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品批号</label>
			<div class="layui-input-block">
				<input type="text" name="batchNumber" class="layui-input userName"
					   placeholder="请输入商品批号" value="${goods.batchNumber }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品类型</label>
			<div class="layui-input-block">
				<select name="goodsType" lay-filter="aihao">
					<c:forEach items="${goodsTypes}" var="var" varStatus="vs">
						<option value="${var.id}"    <c:if test="${var.id==goods.goodsType}">selected</c:if>> ${var.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">供应商</label>
			<div class="layui-input-block">
				<select name="suppliersId" lay-filter="aihao" lay-verify="required">
					<c:forEach items="${suppliers}" var="var" varStatus="vs">
						<option value="${var.id}"  <c:if test="${var.id==goods.suppliersId}">selected</c:if> > ${var.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品批准文号</label>
			<div class="layui-input-block">
				<input type="text" name="approvalNumber" class="layui-input userName"
					   placeholder="请输入商品批准文号" value="${goods.approvalNumber }">
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">商品产地</label>
			<div class="layui-input-block">
				<input type="text" name="home" class="layui-input userName"
					   placeholder="请输入商品产地" value="${goods.home }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品价格</label>
			<div class="layui-input-block">
				<input type="text" name="price" class="layui-input userName"
					   placeholder="请输入商品价格" value="${goods.price }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品包装</label>
			<div class="layui-input-block">
				<input type="text" name="packing" class="layui-input userName"
					   placeholder="请输入商品包装" value="${goods.packing }">
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="editGoods">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/goods/editGoods.js"></script>
</body>
</html>