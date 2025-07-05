(function() {
    const chartDom = document.getElementById('id5');
    const myChart = echarts.init(chartDom);

    $.ajax({
        url: "http://localhost:8080/api/getTotalWinRate",
        type: "GET",
        success: function(res) {
            console.log("响应数据:", res);

            // 检查响应是否是数组且包含元素
            if (Array.isArray(res) && res.length > 0) {
                // 从第一个元素获取数据
                const data = res[0];

                // 提取并格式化数据
                const pvpRate = parseFloat(data.pvpWinRate) || 0;
                const pveRate = parseFloat(data.pveWinRate) || 0;

                console.log("解析后 PVP:", pvpRate, "PVE:", pveRate);

                // 配置图表
                const option = {
                    title: { text: '全服 PVP / PVE 总胜率', left: 'center' },
                    tooltip: {
                        trigger: 'item',
                        formatter: p => `${p.name}：${p.value}%`
                    },
                    xAxis: {
                        type: 'category',
                        data: ['PVP', 'PVE'],
                        axisLabel: { fontSize: 14 }
                    },
                    yAxis: {
                        type: 'value',
                        name: '胜率 (%)',
                        min: 0,
                        max: 100,
                        axisLabel: { formatter: '{value}%' }
                    },
                    series: [{
                        name: '胜率',
                        data: [pvpRate, pveRate],
                        type: 'bar',
                        itemStyle: {
                            borderRadius: 10,
                        }
                    }]
                };

                // 应用图表配置
                myChart.setOption(option);
            } else {
                console.error("数据格式不符合预期:", res);
                alert("数据格式错误，请联系管理员");
            }
        },
        error: function(err) {
            console.error("AJAX请求失败:", err);
            alert("数据加载失败，请检查网络连接或刷新页面");
        }
    });
    $('#id5').click(function() {
        console.log('点击事件触发！');
        window.location.href = "../overall_winrate.html";
    });
})();