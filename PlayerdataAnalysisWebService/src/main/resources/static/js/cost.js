// 使用立即执行函数实现代码隔离
(function() {
    // 初始化ECharts实例
    const chartDom = document.getElementById('id4');
    const myChart = echarts.init(chartDom);

    // 创建转化率显示区域（动态插入到页面）
    const createConversionRatePanel = () => {
        const panel = document.createElement('div');
        panel.style.cssText = `
            position: absolute;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            background: rgba(255, 255, 255, 0.9);
            padding: 10px 20px;
            border-radius: 6px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);  
            text-align: center;
        `;
        panel.innerHTML = `
            <div style="font-size: 14px; color: #666;">付费转化率</div>
            <div style="font-size: 24px; font-weight: bold; color: #333;" id="conversionRate">--</div>
            <div style="font-size: 12px; color: #999;" id="conversionDesc">计算中...</div>
        `;
        // 将面板插入到图表容器的父元素中
        chartDom.parentNode.appendChild(panel);
        return panel;
    };

    // 创建转化率面板
    const conversionPanel = createConversionRatePanel();

    // 发送AJAX请求获取数据
    $.ajax({
        url: "http://localhost:8080/api/getCostStatistics",
        type: "GET",
        success: function(res) {
            console.log("响应数据:", res);

            // 计算总玩家数和付费转化率
            const totalPlayers = res.zeroCostCount + res.mediumCostCount + res.highCostCount;
            const paidPlayers = res.mediumCostCount + res.highCostCount; // 非零氪即为付费玩家
            const conversionRate = totalPlayers > 0 ? (paidPlayers / totalPlayers * 100).toFixed(2) : 0;

            // 更新转化率显示
            document.getElementById('conversionRate').textContent = `${conversionRate}%`;

            // 根据转化率添加描述
            let desc = '';
            if (conversionRate < 5) {
                desc = "转化率较低，建议优化付费引导";
            } else if (conversionRate < 15) {
                desc = "转化率中等，可通过活动提升";
            } else {
                desc = "转化率良好，付费生态健康";
            }
            document.getElementById('conversionDesc').textContent = desc;

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
                    orient: 'vertical',
                    right: '5%',
                    top: 'center'
                },
                series: [
                    {
                        name: '消费分布',
                        type: 'pie',
                        radius: '50%',
                        center: ['40%', '55%'], // 调整饼图位置，避免与转化率面板重叠
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
            // 隐藏转化率面板（避免显示错误状态）
            conversionPanel.style.display = 'none';
        }
    });

    // 窗口大小变化时重新调整图表
    window.addEventListener('resize', function() {
        myChart.resize();
    });
})();