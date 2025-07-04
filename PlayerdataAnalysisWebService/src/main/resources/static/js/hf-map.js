// 合肥市地图——Ajax 拉取 GeoJSON 后渲染
$.get(
    'js/340100_full.json',
    function (hfjson) {
        // 1. 注册地图
        echarts.registerMap('合肥', hfjson);

        // 2. 初始化图表实例
        var chart = echarts.init(document.getElementById('id1'));

        // 3. 配置项
        var option = {
            title: {
                text: '合肥市各行政区人口统计',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b}<br/>{c} 人'
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
                    map: '合肥',
                    roam: true,
                    zoom: 1.15,
                    label: {
                        show: true
                    },
                    emphasis: {
                        label: { show: true }
                    },
                    // 4. 行政区人口示例数据（单位：人）
                    data: [
                        { name: '瑶海区', value: 862043 },
                        { name: '庐阳区', value: 697293 },
                        { name: '蜀山区', value: 1047150 },
                        { name: '包河区', value: 1217469 },
                        { name: '高新区', value: 269922 },
                        { name: '经开区', value: 557858 },
                        { name: '新站区', value: 466464 },
                        { name: '长丰县', value: 783982 },
                        { name: '肥东县', value: 884792 },
                        { name: '肥西县', value: 967508 },
                        { name: '庐江县', value: 888238 },
                        { name: '巢湖市', value: 727162 }
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
