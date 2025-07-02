//初始化echart实例对象
var myChart = echarts.init(document.getElementById("id1"));
// 设置数据配置项
var option;

option = {
    //提示框组件
    tooltip:{
        trigger:"axis"//触犯方式
    },
    //图例组件
    legend:{
        right:"10%",
    },
    // 配置图标大小
    grid:{
        top:"20%",
        containLabel:true,//包含刻度文字
        left:"3%",
        right:"4%",
        bottom:"4%"
    },

    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {   name:"A",
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        },
        {   name:"B",
            data: [850, 32, 501, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        }
    ]
};
// 将配置项设置给echart实例对象,生成图表
myChart.setOption(option);


    // <script>
    // $.ajax({ //正常的要把那些script放在这个function里,正常的要用(function(){***})()来实现我们的立即执行函数,实现代码的隔离,可以使用同名的变量
    //     url:"",
    //     type:"",
    //     success:function(res){//回调函数!!!,将请求后的数据做一个处理
    //         //将请求获取的数据在echart中显示
    //         }
    //     }
    //
    // )
    // </script>