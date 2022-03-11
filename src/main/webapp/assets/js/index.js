// index.js
$(function(){
    $("#login").click(function(){
        let id = $(".account").val();
        let pwd = $(".password").val();
        let data = {
            "mi_id":id,
            "mi_pwd":pwd
        }
        
        $.ajax({
            url:"/admin/login",
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                if(!r.status){
                    alert(r.message)
                    return;
                }else{
                    location.href="/admin/summary";
                }
            }
        })
    })
    $(".account, .password").keydown(function(e){
        if(e.keyCode==13){
            $("#login").trigger("click");
        }
    })
})