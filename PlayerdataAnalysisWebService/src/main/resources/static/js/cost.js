// 使用立即执行函数实现代码隔离
(function() {
    // 初始化ECharts实例
    const chartDom = document.getElementById('id4');
    const myChart = echarts.init(chartDom);

    // 发送AJAX请求获取数据
    $.ajax({
        url: "http://localhost:8080/api/getCostStatistics",
        type: "GET",
        success: function(res) {
            console.log("响应数据:", res);

            // 计算总玩家数（用于图表副标题）
            const totalPlayers = res.zeroCostCount + res.mediumCostCount + res.highCostCount;

            // 配置ECharts图表
            const option = {
                title: {
                    top: '5%',
                    left: '5%',
                    text: '玩家消费分布',
                    subtext: `总玩家数: ${totalPlayers.toLocaleString()} 人` // 显示总玩家数
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b}: {c}人 ({d}%)' // 显示数量和百分比
                },
                legend: {
                    orient: 'vertical',  // 垂直排列图例
                    right: '5%',         // 右侧距离
                    top: '15%',          // 顶部距离，调整为不遮挡标题
                },
                series: [
                    {
                        name: '消费分布',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            { value: res.zeroCostCount, name: "零氪" },
                            { value: res.mediumCostCount, name: "充钱少于三十(非零氪)" },
                            { value: res.highCostCount, name: "充钱大于三十" }
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        label: {
                            formatter: '{b}: {d}%' // 扇区显示名称和百分比
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
    });
})();