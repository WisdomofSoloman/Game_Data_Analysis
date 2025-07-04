(function() {
    // 获取表格tbody元素
    const tableBody = document.getElementById('table-body1');

    // 发送AJAX请求获取数据
    $.ajax({
        url: "http://localhost:8080/getTop10PvePlayers",
        type: "GET",
        success: function(res) {
            console.log("响应数据:", res);

            // 清空表格内容（避免重复添加）
            tableBody.innerHTML = '';

            // 检查数据是否存在且格式正确
            if (res && Array.isArray(res) && res.length > 0) {
                // 遍历数据并添加到表格
                res.forEach((player, index) => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${index + 1}</td>
                        <td>${player.id || '-'}</td>
                        <td>${player.avgOnlineTime || '-'}</td>
                        <td>${player.pveWinCount || '-'}</td>
                        <td>${player.pveWinRate || '-'}</td>
                    `;
                    tableBody.appendChild(row);
                });
            } else {
                // 无数据时显示提示
                tableBody.innerHTML = '<tr><td colspan="5">暂无数据</td></tr>';
            }
        },
        error: function(err) {
            console.error("AJAX请求失败:", err);
            alert("数据加载失败，请检查网络连接或刷新页面");
        }
    });
    $('.table1').click(function() {
        console.log('点击事件触发！');
        window.location.href = "../pve_top10.html";
    });
})();