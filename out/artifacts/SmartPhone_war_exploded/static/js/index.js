//index.html有关的js
$(function () {

    //滚动页面有关的函数
        $("#fullpage").fullpage({
            sectionsColor : ['#000000', '#4BBFC3', '#7BAABE', '#f90'],
            loopBottom: true,
            navigation: true,
            slidesColor: ['#F0F2F4', '#fff', '#fff', '#fff'],
            verticalCentered: false
            //固定元素，默认为null,需要配置一个jquery选择器，在页面滚动时，fixElements设置的元素不滚动
        });

    //点击userPageLogo跳转到user.html函数
    $(".homepage-btn").click(function () {
        window.location="static/pages/user.html";
    })

    //点击shoppingBag跳转到product.html函数
    $(".purchase-btn").click(function () {
        window.location="static/pages/product.html";
    })

    //点击语言切换
    $('.select-div').mouseenter(function() {
        $('.aboutLanguage li:gt(0)').slideToggle();
    });
    $('.select-div').mouseleave(function() {
        $('.aboutLanguage li:gt(0)').slideToggle();
    });

})