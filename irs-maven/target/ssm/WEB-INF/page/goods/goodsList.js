layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		//数据表格
		table.render({
			id:'goodsList',
		    elem: '#goodsList'
		    ,url: ctx+'/goods/list' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'id', title: 'ID', sort: true}
/*              ,{field:'goodsType', title: '轮播图',templet:'#tableImg'}*/
				,{field:'name', title: '商品名称'}
              ,{field:'specifications', title: '规格'}
              ,{field:'batchNumber', title: '批号'}
              ,{field:'approvalNumber', title: '批准文号'}
              ,{field:'home', title: '产地'}
                ,{field:'price', title: '价格'}
                ,{field:'packing', title: '包装'}
              ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
		  });
		//监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('真的删除行么?', function(index){
		    	  $.ajax({
		    		  url:ctx+'/goods/delete?id='+data.id,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  table.reload('goodsList', {})
		    			  }else{
		    				  layer.msg("权限不足，联系超管！",{icon: 5});
		    			  }
		    		  }
		    	  })
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		      layer.open({
		    	  type: 2,
		    	  title:"编辑商品",
		    	  area: ['380px', '460px'],
		    	  content:ctx+"/goods/editGoods?id="+data.id //这里content是一个普通的String
		      })
		    }
		  });

	//添加角色
	$(".goodsAdd_btn").click(function(){
		layer.open({
	    	  type: 2,
	    	  title:"添加商品",
	    	  area: ['380px', '460px'],
	    	  content:ctx+"/goods/addGoods", //这里content是一个普通的String
	      })
	})


	
	//批量删除角色
	$(".batchDel").click(function(){
		var checkStatus = table.checkStatus('goodsList')
	      ,data = checkStatus.data,goodsStr='';
//	      layer.alert(JSON.stringify(data));
		if(data.length>0){
			$.each(data, function (n, value) {
                goodsStr+=value.id+',';
	          });
            goodsStr=goodsStr.substring(0,goodsStr.length-1);
			  layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
				//调用删除接口
				  $.ajax({
			    		  url:'deletes?goodsStr='+goodsStr,//接口地址
			    		  type : "get",
			    		  success : function(d){
			    			  if(d.code==0){
			    				//重载表格
                                  table.reload('goodsList', {})
			    				  //删除成功，刷新父页面
			    				  //parent.location.reload();
			    			  }else{
			    				  layer.msg("删除错误，稍后再试！",{icon: 5});
			    			  }
			    		  }
			    	  })
			    	  layer.close(index);
			  });
		}else{
			layer.msg("请选择要操作的数据！");
		}
		
	})
	
})


