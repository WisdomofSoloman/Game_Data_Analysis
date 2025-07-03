// 南京市地图——Ajax 拉取 GeoJSON 后渲染
$.get(
    'js/320100_full.json',
    function (njjson) {
        // 1. 注册地图
        echarts.registerMap('南京', njjson);

        // 2. 初始化图表实例
        var chart = echarts.init(document.getElementById('id1'));

        // 3. 配置项
        var option = {
            title: {
                text: '南京市各行政区人口统计',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b}<br/>{c} 万人'
            },
            visualMap: {
                min: 50,
                max: 200,
                text: ['高', '低'],
                realtime: true,
                calculable: true,
                inRange: {
                    // 把这里替换成你想要的渐变数组
                    color: ['#f1f9ff', '#9dc9f7', '#5a9bf6', '#2865f6']
                }
            },


            series: [
                {
                    name: '人口数量',
                    type: 'map',
                    map: '南京',
                    roam: true,
                    zoom: 1.15,
                    label: {
                        show: true
                    },
                    emphasis: {
                        label: { show: true }
                    },
                    // 4. 行政区人口示例数据（单位：万人）
                    data: [
                        { name: '玄武区', value: 85 },
                        { name: '秦淮区', value: 110 },
                        { name: '建邺区', value: 95 },
                        { name: '鼓楼区', value: 108 },
                        { name: '浦口区', value: 130 },
                        { name: '栖霞区', value: 125 },
                        { name: '雨花台区', value: 90 },
                        { name: '江宁区', value: 180 },
                        { name: '六合区', value: 95 },
                        { name: '溧水区', value: 65 },
                        { name: '高淳区', value: 60 }
                    ]
                }
            ]
        };


        // 5. 渲染
        chart.setOption(option);


        // 6. 浏览器窗口变化时自动缩放
        window.addEventListener('resize', function () {
            chart.resize();
        });
    }
);
