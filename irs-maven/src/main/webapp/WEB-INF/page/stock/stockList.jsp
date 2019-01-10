<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>库存管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/list.css" media="all" />
	<script>  
        <%--JS gloable varilible--%>  
        var ctx = "${ctx}";  
    </script>  
<style type="text/css">
</style>
</head>
<body class="childrenBody">
	<input type="hidden" id="adminId" value="<shiro:principal property='id'"/>
	<blockquote class="layui-elem-quote list_search">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger " id="searchShortage" data-type="searchShortage" lay-filter="searchShortage"><i class="layui-icon layui-icon-search"></i>短缺查询</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-warm " id="searchStorage" data-type="searchStorage"  lay-filter="searchStorage"><i class="layui-icon layui-icon-search"></i>超储查询</a>
			</div>
		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
	</blockquote>
	<!-- 数据表格 -->
	<table id="stockList" lay-filter="test"></table>
	
	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/page/stock/stockList.js"></script>
	<script type="text/html" id="barEdit">
  			<a class="layui-btn layui-btn-normal" lay-event="edit">编辑</a>
	</script>
	<style>
	.layui-table-cell{
	    height:36px;
	    line-height: 36px;
	}
	</style>
</body>
</html>