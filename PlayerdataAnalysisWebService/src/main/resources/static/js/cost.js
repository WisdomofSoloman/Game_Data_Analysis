// 使用立即执行函数实现代码隔离
(function() {
    // 初始化ECharts实例
    const chartDom = document.getElementById('id2');
    const myChart = echarts.init(chartDom);

        // 发送AJAX请求获取数据
        $.ajax({
            url: "http://localhost:8080/api/getCostStatistics",
            type: "GET",
            success: function(res) {
                console.log("响应数据:", res);

                // 配置ECharts图表
                const option = {
                    title: {
                        text: '零氪,小于三十,大于三十',
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        right:'5%',
                    },
                    series: [
                        {
                            name: '消费分布',
                            type: 'pie',
                            radius: '50%',
                            data: [
                                { value: res.zeroCostCount, name: "零氪"},
                                { value: res.mediumCostCount, name: "充钱少于三十(非零氪)"},
                                { value: res.highCostCount, name: "充钱大于三十 "}
                            ],
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                // 设置图表配置
                    myChart.setOption(option);
            },
            error: function(err) {
                console.error("AJAX请求失败:", err);
                alert("数据加载失败，请检查网络连接或刷新页面");
            }
        });

        // 窗口大小变化时重新调整图表
        window.addEventListener('resize', function() {
            myChart.resize();
        })
})();