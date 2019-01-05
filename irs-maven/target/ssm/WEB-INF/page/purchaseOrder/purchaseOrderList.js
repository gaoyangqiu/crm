layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage', 'table', 'laytpl'], function () {
    var form = layui.form, table = layui.table;
    layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;
    //数据表格
    table.render({
        id: 'purchaseOrderList',
        elem: '#purchaseOrderList'
        , url: ctx + '/purchaseOrder/list' //数据接口
        , cellMinWidth: 80
        , limit: 10//每页默认数
        , limits: [10, 20, 30, 40]
        , cols: [[ //表头
            {type: 'checkbox'}
            , {field: 'id', title: 'ID', sort: true}
            , {field: 'number', title: '采购编号'}
            , {field: 'goodsName', title: '商品名称'}
            , {field: 'price', title: '商品价格'}
            , {field: 'amount', title: '商品数量'}
            , {field: 'money', title: '金额'}
            , {field: 'home', title: '产地'}
            , {field: 'supplierName', title: '供应商'}
            , {field: 'remark', title: '备注'}
            , {field: 'batchNumber', title: '批号'}
            , {field: 'approvalNumber', title: '批准文号'}
            , {field: 'userName', title: '经手人'}
            , {title: '操作', toolbar: '#barEdit'}
        ]]
        , page: true //开启分页
    });
    //监听工具条
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'return') {
            layer.open({
                type: 2,
                title: "添加采购退货单",
                area: ['380px', '460px'],
                content: ctx + "/purchaseOrder/addReturnPurchaseOrder?id=" + data.id //这里content是一个普通的String
            })
        } else if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: "编辑采购单",
                area: ['380px', '460px'],
                content: ctx + "/purchaseOrder/editPurchaseOrder?id=" + data.id //这里content是一个普通的String
            })
        }
    });

    //添加角色
    $(".purchaseOrderAdd_btn").click(function () {
        layer.open({
            type: 2,
            title: "添加采购单",
            area: ['380px', '460px'],
            content: ctx + "/purchaseOrder/addPurchaseOrder", //这里content是一个普通的String
        })
    })


    //批量删除角色
    $(".batchDel").click(function () {
        var checkStatus = table.checkStatus('purchaseOrderList')
            , data = checkStatus.data, purchaseOrderStr = '';
//	      layer.alert(JSON.stringify(data));
        if (data.length > 0) {
            $.each(data, function (n, value) {
                purchaseOrderStr += value.id + ',';
            });
            purchaseOrderStr = purchaseOrderStr.substring(0, purchaseOrderStr.length - 1);
            layer.confirm('真的要删除<strong>' + data.length + '</strong>条数据吗？', function (index) {
                //调用删除接口
                $.ajax({
                    url: 'deletes?purchaseOrderStr=' + purchaseOrderStr,//接口地址
                    type: "get",
                    success: function (d) {
                        if (d.code == 0) {
                            //重载表格
                            table.reload('purchaseOrderList', {})
                            //删除成功，刷新父页面
                            //parent.location.reload();
                        } else {
                            layer.msg("删除错误，稍后再试！", {icon: 5});
                        }
                    }
                })
                layer.close(index);
            });
        } else {
            layer.msg("请选择要操作的数据！");
        }

    })

})


