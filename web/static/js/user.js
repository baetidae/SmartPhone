// user.html有关的js
$(function(){

    //点击登陆，发送ajax请求
    $("#login-btn").click(function(){
        //发送ajax请求
        $.ajax({
            url:"/user/login/auth",
            method:"post",
            data:{
                "tel":$("#tel").val(),
                "password":$("#password").val()
            },
            success:function(response){
                if(response.errorCode === "100"){
                    //登陆成功
                    console.log("请求发送成功");
                    //获取到后端传来的userList
                    var $user = response.objectMap.User;

                    //将$user转换成json保存在localStorage中
                    window.localStorage.setItem("User",JSON.stringify($user));
                    //跳转到homepage.html
                    window.location.href="../pages/homepage.html";
                }else{
                    //登陆失败
                    $("#error-info").text("账号或者密码有误，请重新登陆。").css({"color":"red"});
                }
            },
            error:function () {

                console.log("请求发送失败");
            }

        })

    })

    //点击注册跳转到注册页面
    $("#register-btn").click(function () {
        window.location="register.html";
    })

})
