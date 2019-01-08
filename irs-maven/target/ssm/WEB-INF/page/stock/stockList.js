layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage', 'table', 'laytpl'], function () {
    var form = layui.form, table = layui.table;
    layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;
    //数据表格
    table.render({
        id: 'stockList',
        elem: '#stockList'
        , url: ctx + '/stock/list' //数据接口
        , cellMinWidth: 80
        , limit: 10//每页默认数
        , limits: [10, 20, 30, 40]
        , cols: [[ //表头
            {type: 'checkbox'}
            , {field: 'id', title: 'ID', sort: true}
            , {field: 'name', title: '商品名' }
            , {field: 'home', title: '来源'}
            , {field: 'price', title: '商品价格'}
            , {field: 'supplierName', title: '供应商'}
            , {field: 'amount', title: '商品数量'}
            , {field: 'cordon', title: '警戒数量'}
            , {title: '操作', toolbar: '#barEdit'}
        ]]
        , page: true //开启分页
        , done: function (res, curr, count) {// 表格渲染完成之后的回调
            var tableArray=new Array();
            tableArray=res.value();
            for (var i=0;i<tableArray.length;i++){
                if (tableArray[i].cordon == 1) {

                }
            }
        }
    });
    //监听工具条
    table.on('tool(test)', function (obj) {
        var data = obj.data;
if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: "编辑库存",
                area: ['380px', '460px'],
                content: ctx + "/stock/editStock?id=" + data.id //这里content是一个普通的String
            })
        }
    });


})


