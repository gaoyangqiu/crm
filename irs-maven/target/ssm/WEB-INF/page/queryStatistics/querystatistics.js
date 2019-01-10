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
    $.get(ctx+'/saleOrder/queryStatistics', function (json) {
        categories=json.xAxis;
        values = json.datas;
    });
    option = {
        title : {
            text: '站点用户性别占比',
            subtext: '每日定时统计',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: categories
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:values,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart.hideLoading();
})


