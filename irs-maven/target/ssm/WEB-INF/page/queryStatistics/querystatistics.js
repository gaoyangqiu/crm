layui.config({
    base : "js/"
}).use(['form','element','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        element = layui.element,
        $ = layui.jquery;

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('querystatistics'));
    myChart.showLoading({
        text: '正在努力加载中...'
    });

    var categories = [];
    var values = [];

    // 同步执行
    $.ajaxSettings.async = false;

    // 加载数据
    $.get(ctx+'/saleOrder/queryStatistics?type=1', function (data) {
        categories=data.data.xAxis;
        values = data.data.datas;
    });
    option = {
        title : {
            text: '销售额排行',
        },
        xAxis: {
            type: 'category',
            data: categories
        },
        yAxis: {
            type: 'value'
        },
        series : [
            {
                name: '访问来源',
                type: 'bar',
                data:values
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart.hideLoading();
});

layui.config({
    base : "js/"
}).use(['form','element','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        element = layui.element,
        $ = layui.jquery;

    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('querystatisticsAmount'));
    myChart1.showLoading({
        text: '正在努力加载中...'
    });

    var categories = [];
    var values = [];

    // 同步执行
    $.ajaxSettings.async = false;

    // 加载数据
    $.get(ctx+'/saleOrder/queryStatistics?type=2', function (data) {
        categories=data.data.xAxis;
        values = data.data.datas;
    });
    option = {
        title : {
            text: '销售数量排行',
        },
        xAxis: {
            type: 'category',
            data: categories
        },
        yAxis: {
            type: 'value'
        },
        series : [
            {
                name: '访问来源',
                type: 'bar',
                data:values
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option);
    myChart1.hideLoading();
});



