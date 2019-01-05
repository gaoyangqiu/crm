layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage', 'table', 'laytpl'], function () {
    var form = layui.form, table = layui.table;
    layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;
    //数据表格
    table.render({
        id: 'customerList',
        elem: '#customerList'
        , url: ctx + '/customer/list' //数据接口
        , cellMinWidth: 80
        , limit: 10//每页默认数
        , limits: [10, 20, 30, 40]
        , cols: [[ //表头
            {type: 'checkbox'}
            , {field: 'id', title: 'ID', sort: true}
            , {field: 'number', title: '客户编号'}
            , {field: 'name', title: '客户名称'}
            , {field: 'grade', title: '客户等级' ,templet: function(d) {
                    if (d.sex == 1) {
                        return 'VIP客户'
                    } else {
                        return '普通客户'
                    }
                }}
            , {field: 'sex', title: '客户性别' ,templet: function(d) {
                        if (d.sex == 1) {
                            return '女'
                        } else {
                            return '男'
                        }
                }}
            , {field: 'carded', title: '客户证件号'}
            , {field: 'address', title: '客户地址'}
            , {field: 'phone', title: '客户电话'}
            , {field: 'qq', title: 'QQ'}
            , {title: '操作', toolbar: '#barEdit'}
        ]]
        , page: true //开启分页
    });
    //监听工具条
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么?', function (index) {
                $.ajax({
                    url: ctx + '/customer/delete?id=' + data.id,
                    type: "get",
                    success: function (d) {
                        if (d.code == 0) {
                            table.reload('customerList', {})
                        } else {
                            layer.msg("权限不足，联系超管！", {icon: 5});
                        }
                    }
                })
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: "编辑客户",
                area: ['380px', '460px'],
                content: ctx + "/customer/editCustomer?id=" + data.id //这里content是一个普通的String
            })
        }
    });

    //添加角色
    $(".customerAdd_btn").click(function () {
        layer.open({
            type: 2,
            title: "添加客户",
            area: ['380px', '460px'],
            content: ctx + "/customer/addCustomer", //这里content是一个普通的String
        })
    })


    //批量删除角色
    $(".batchDel").click(function () {
        var checkStatus = table.checkStatus('customerList')
            , data = checkStatus.data, customerStr = '';
//	      layer.alert(JSON.stringify(data));
        if (data.length > 0) {
            $.each(data, function (n, value) {
                customerStr += value.id + ',';
            });
            customerStr = customerStr.substring(0, customerStr.length - 1);
            layer.confirm('真的要删除<strong>' + data.length + '</strong>条数据吗？', function (index) {
                //调用删除接口
                $.ajax({
                    url: 'deletes?customerStr=' + customerStr,//接口地址
                    type: "get",
                    success: function (d) {
                        if (d.code == 0) {
                            //重载表格
                            table.reload('customerList', {})
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


