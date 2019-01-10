layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage', 'table', 'laytpl'], function () {
    var form = layui.form, table = layui.table;
    active = {
        searchShortage : function() {
            //执行重载
            table
                .reload(
                    'stockList',
                    {
                        page : {
                            curr : 1
                            //重新从第 1 页开始
                        },
                        where : {
                        type:1
                        }
                    });
        },
        searchStorage : function() {
            //执行重载
            table
                .reload(
                    'stockList',
                    {
                        page : {
                            curr : 1
                            //重新从第 1 页开始
                        },
                        where : {
                            type:2
                        }
                    });
        }
    };

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
            , {field: 'name', title: '商品名'}
            , {field: 'home', title: '来源'}
            , {field: 'price', title: '商品价格'}
            , {field: 'supplierName', title: '供应商'}
            , {field: 'amount', title: '商品数量'}
            , {field: 'cordon', title: '警戒数量'}
            , {title: '操作', toolbar: '#barEdit'}
        ]]
        , page: true //开启分页
        , done: function (res, page, count) {
            var that = this.elem.next();
            console.log(that)
            res.data.forEach(function (item, index) {
                console.log(item);
                if (item.cordonStatus == 0) {//商品数量低于警戒值显示红色
                    var tr = that.find(".layui-table-box tbody tr[data-index='" + index + "']").css("background-color", "#FF5722");
                }else if(item.cordonStatus == 2){//商品数量高于警戒值显示橙色
                    var tr = that.find(".layui-table-box tbody tr[data-index='" + index + "']").css("background-color", "#FFB800");
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
        }
    })


    //查询缺货
    $("#searchShortage").click(function() {

        active.searchShortage().call(this);
    })

    //查询超储
    $("#searchStorage").click(function() {

       active.searchStorage().call(this);
    })
});