//0?(13|14|15|17|18|19)[0-9]{9}电话号码正则表达式
///^[a-zA-Z0-9_-]{4,16}$/ //验证用户名正则表达式
//         //4到16位（字母，数字，下划线，减号）

$(function () {
    //定义变量开关
    var flagFirPwd = false;
    var flagSecPwd = false;
    var flagTel = false;

    //标签所在元素查找
    var $firPwd = $("#fir_pwd");
    var $secPwd = $("#sec-pwd");
    var $tel = $("#tel");

    //检查第一次输入密码格式
    $firPwd.blur(fnCheckFirPWd);

    //检查两次输入密码是否一致
    $secPwd.blur(fnCheckSecPwd);

    //检查电话号码格式是否正确
    $tel.blur(fnCheckTel);

    $("#submit-btn").click(function () {
        if(flagFirPwd && flagSecPwd && flagTel){
            //表单验证通过
            console.log("表单验证通过");
            //通过ajax提交用户数据到后台
            $.ajax({
                url:"/user/register",
                method:"post",
                data:{
                    "tel":$tel.val(),
                    "password":$firPwd.val(),
                },
                success:function(response){
                    console.log("请求发送成功");
                    if(response.errorCode === "100"){
                        console.log("注册成功.")
                    }else{
                        console.log("用户已经存在、注册失败.")
                    }
                },
                error:function(){
                    console.log("请求发送失败");
                }
            });

        } else {
            console.log("提交失败");
        }
    });


    //验证第一次输入密码函数
    function fnCheckFirPWd() {
        //获取用户输入数据
        var vals = $firPwd.val();
        var re = /^[\w!-@#$%^&*]{6,20}$/;
        //提示密码不能为空
        if(vals.length === 0){
            $firPwd.next().show().html("密码不能为空");
            flagFirPwd = false;
            return flagFirPwd;
        }
        if(re.test(vals)){
            $firPwd.next().hide();
            flagFirPwd = true;
            return flagFirPwd;
        } else {
            $firPwd.next().show().html("密码是6到20位字母、数字，还可包含@!#$%^&*-字符");
            flagFirPwd = false;
            return flagFirPwd;
        }
    }

    //判断两次密码是否一致
    function fnCheckSecPwd() {
        var vals = $firPwd.val();
        var secVals = $secPwd.val();
        if(secVals === 0){
            $secPwd.next().show().html("请重复确认密码");
            flagSecPwd = false;
            return flagSecPwd;
        }
        if(vals === secVals){
            $secPwd.next().hide();
            flagSecPwd = true;
            return flagSecPwd;
        } else {
            $secPwd.next().show().html("两次输入的密码不同");
            flagSecPwd = false;
            return flagSecPwd;
        }
    }

    //验证电话号码格式
    function fnCheckTel() {
        var vals = $tel.val();
        var re = /0?(13|14|15|17|18|19)[0-9]/;
        if(vals.length === 0){
            $tel.next().show().html("电话号码不能为空");
            flagTel = false;
            return flagTel;
        }
        if(re.test(vals)){
            $tel.next().hide();
            flagTel = true;
            return flagTel;
        } else {
            $tel.next().show().html("请输入正确的电话号码");
            flagTel = false;
            return flagTel;
        }
    }
})
