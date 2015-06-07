/**
 * Created by peimengqi on 14/12/29.
 */
$(function(){
    //初始时隐藏注册信息和注册按钮
    $("#signupInfo").hide();
    $("#signup").hide();

    $("#showSignupInfo").click(function(){
        $(this).hide("normal");
        $("#signupInfo").slideDown("slow");
        $("#signup").show("slow");
    })

    $("#signup").click(function(){
        var username = $('#inputusername').val();
        var password = $('#inputpassword').val();
        var email = $('#inputemail').val();
        var identity = $('#inputidentity').val();
        //保存当前按钮并置为“loading”状态，以便之后再重置回来
        var $btn = $(this).button('loading');

        $.post("/add",
        {username:username, password:password, email:email, identity:identity},
        function(response){
            //response中，status表示注册成功或失败或用户名已注册，errormessagelist保存所有错误信息
            //alert(response.status + ", " + response.errorMessageList);
            if(response.status == "SUCCESS") {  //注册成功
                $("#successMessage").html("注册成功，正在登录！")
                $("#successMessage").show("slow");
                $("#errorMessage").hide("slow");
                //模态框延时一秒后拉起
                window.location.href="/news";
            } else if(response.status == "SIGNED"){ //当前用户已注册，可以直接登录
                $("#successMessage").html("您已注册过，可以直接登录！")
                $("#successMessage").show("slow");
                $("#errorMessage").hide("slow");
                //页面转向
                window.location.href="/news";
            } else {
                errorInfo = "错误信息：";

                //重置所有输入框的样式
                $("#loginPanel .form-group").removeClass("has-error");

                //遍历所有错误信息，生成错误清单，并更改对应输入框的样式为出错
                for(i=0; i<response.errorMessageList.length; i++) {
                    errorInfo += "<br/>" + (i+1) + ". "
                    + response.errorMessageList[i].errormessage;
                    //更改对应出错的input元素的样式
                    $("#form"+response.errorMessageList[i].errorfield).addClass("has-error");
                }
                $('#errorMessage').html(errorInfo);
                $("#errorMessage").show("slow");
                $("#successMessage").hide("slow");
            }
            $btn.button('reset');
        })
    })

    $('#login').click(function(){
        var username = $('#inputusername').val();
        var password = $('#inputpassword').val();
        var email = $('#inputemail').val();
        var identity = $('#inputidentity').val();
        //保存当前按钮并置为“loading”状态，以便之后再重置回来
        var $btn = $(this).button('loading');

        $.post("/login",
            {username:username, password:password, email:email, identity:identity},
            function(response){
                if(response.status == "SUCCESS") {
                    //alert("欢迎！");
                    $("#successMessage").html("验证成功，正在登录！")
                    $("#successMessage").show("slow");
                    $("#errorMessage").hide("slow");
                    //登录成功，页面转向
                    window.location.href="/news";
                } else {
                    errorInfo = "错误信息：";
                    //重置所有输入框的样式
                    $("#loginPanel .form-group").removeClass("has-error");

                    //遍历所有错误信息，生成错误清单，并更改对应输入框的样式为出错
                    for(i=0; i<response.errorMessageList.length; i++) {
                        errorInfo += "<br/>" + (i+1) + ". "
                        + response.errorMessageList[i].errormessage;

                        $("#form"+response.errorMessageList[i].errorfield).addClass("has-error");
                    }
                    $('#errorMessage').html(errorInfo);
                    $("#errorMessage").show("slow");
                    $("#successMessage").hide("slow");
                }
                $btn.button('reset');
            })
    })
})
