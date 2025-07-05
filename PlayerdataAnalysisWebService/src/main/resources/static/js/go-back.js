(function() {
    $('.goback').click(function() {
        console.log('点击事件触发！');
        window.location.href = "../index.html";
    });
})();//这里后面这个()是执行符,没有执行符执行不了跳转