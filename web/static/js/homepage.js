$(function () {
    //获取页面数据
    var $avatarImg = $("#avatar-img");
    var $tel = $("#tel");
    var $address = $("#address");
    var $sex = $("#sex");
    var $birthday = $("#birthday");
    var $backgroundImg = $("#background-img");


    //获取session中存储的tel数据
    var $user = JSON.parse(localStorage.getItem("User"));
    console.log($user);

    $avatarImg.attr('src',$user.avatar);
    $tel.text($user.tel);
    $address.text($user.address);
    $sex.text($user.gender);
    $birthday.text($user.birthday);
    $backgroundImg.attr('src',$user.backgroundImage);


    $("#updateAvatar-btn").click(function () {
       console.log("upload");
    });

    $("#confirmUpdate-btn").click(function(){
        $.ajax({
            url:"/user/updateAvatar",
            method:"post",
            data:{
                "id":$user.id,

            },
            success:function () {
                console.log("上传成功");
            },
            error:function () {
                console.log("上传失败");
            }
        });
    });
})