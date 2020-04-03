$(function () {
    $('#fullpage').fullpage({
        // fullpage参数
        sectionsColor: ['', '#000000', '#000000', '#000000', '#000000', '#000000','#000000'],
        navigation: true,
        verticalCentered: false,
        // 回调函数
        // afterLoad: (anchorLink, index) => {
        //     if (index == 3){
        //         $(".phoneModule").animate({
        //             left: '25%'
        //         }, "slow");
        //     } else if (index == 4) {
        //         $(".nav-img").animate({
        //             opacity: '1'
        //         }, 1500);
        //     }
        // }
        afterLoad: function(anchorLink, index){
            if(index == 3){

                $(".phoneModule").animate({
                    left:'25%'
                },"slow");
            } else if(index == 4){
                $(".nav-img").animate({
                    opacity:'1'
                },1500);
            }
        }
    })
});