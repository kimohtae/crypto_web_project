// member_info.js
$(function(){
    let AddBtn = true;
    let modBtn = true;

    $(".member_page_wrap").addClass("active")
    $(".member_list_table").addClass("active")
    let i = ($("#sending").attr("offset")/30)+1;
    $(".pager_wrap #"+i).addClass("current")
    

    let selected = new Set();
    $(".member_list_table .member_data").click(function(){
        let check = $(this).attr("tr-seq");

        if($("#"+check+" input").prop("checked")){
            $("#"+check+" input").prop("checked",false)
        }else{
            $("#"+check+" input").prop("checked",true)
        }
        
        if($("#"+check+" input").prop("checked")){
            $("#"+check).addClass("active")
            selected.add(check)
        }else{
            $("#"+check).removeClass("active")
            selected.delete(check)
        }
    })
    
    
    $("#add_btn").click(function(){
        selected = new Set();
        $(".member_list_table .member_data").prop("checked",false)
        $(".member_list_table .member_data").removeClass("active")

        if(AddBtn){
            $(".input_box").addClass("active")
            $("#add_btn").addClass("active")

            $("#add_btn").html("저장")
            $(".member_list_table th:nth-child(8)").html("비밀번호")
            $(".member_list_table th:nth-child(9)").html("비밀번호 확인")

            AddBtn = false;
        }else{
            if(confirm("저장하시겠습니까?")==false)return;

            if($("#input_pwd").val()!=$("#input_pwd_con").val()){
                alert("비밀번호가 일치하지 않습니다.")
                return;
            }else if($("#input_pwd").val()==""){
                alert("비밀번호를 입력해 주세요.")
                return;
            }
            
            let data = {
                "mi_id":$("#input_id").val(),
                "mi_phone":$("#input_phone").val(),
                "mi_birth":$("#input_birth").val(),
                "mi_email":$("#input_email").val(),
                "mi_name":$("#input_name").val(),
                "mi_pwd":$("#input_pwd").val()
            }

            $.ajax({
                url:"/admin/member/insert",
                type:"post",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(r){
                    alert(r.message)
                    if(r.status){
                        location.reload()
                    }
                }
            })
        }
    })
    
    
    $(".member_list_table .member_data").dblclick(function(){
        let selectOri = $(this).attr("tr-seq")
        let select = $(this).attr("tr-seq")*10000000000
        selected = new Set();
        $(".member_list_table .member_data").prop("checked",false)
        $(".member_list_table .member_data").removeClass("active")

        if(modBtn){
            $("#"+select).addClass("active")
            modBtn = false;
            $("#add_btn").css("display","none")
            $("#modify_btn").css("display","inline-block")
    
            $(".member_list_table th:nth-child(8)").html("상태")
            $(".member_list_table th:nth-child(9)").html("등록일")

            $(".input_box").removeClass("active")
            $("#add_btn").removeClass("active")
            AddBtn = true;

            $.ajax({
                url:"/admin/member/select?seq="+selectOri,
                type:"get",
                success:function(r){
                    $("#"+select+" .mod_id").val(r.mi_id)
                    $("#"+select+" .mod_phone").val(r.mi_phone)
                    $("#"+select+" .mod_birth").val(r.mi_birth)
                    $("#"+select+" .mod_email").val(r.mi_email)
                    $("#"+select+" .mod_name").val(r.mi_name)
                    $("#"+select+" .mod_image").val(r.mi_image)
                }
            })

            $("#modify_btn").click(function(){
                let data = {
                    "mi_seq":selectOri,
                    "mi_id":$("#"+select+" .mod_id").val(),
                    "mi_name":$("#"+select+" .mod_name").val(),
                    "mi_phone":$("#"+select+" .mod_phone").val(),
                    "mi_birth":$("#"+select+" .mod_birth").val(),
                    "mi_email":$("#"+select+" .mod_email").val(),
                    "mi_image":$("#"+select+" .mod_image").val()
                }
                
                $.ajax({
                    url:"/admin/member/update",
                    type:"patch",
                    contentType:"application/json",
                    data:JSON.stringify(data),
                    success:function(r){
                        alert(r.message)
                        if(r.status){
                            location.reload()
                        }
                    }
                })
        
        
            })
        }else{
            $("#"+select).removeClass("active")
            $(".input_box").removeClass("active")
            $("#add_btn").removeClass("active")
            $("#add_btn").html("추가")
            AddBtn = true;
    
            $("#add_btn").css("display","inline-block")
            $("#modify_btn").css("display","none")
            $(".member_list_table .modify_box").removeClass("active")
            modBtn = true;
    
            $("#input_id").val("")
            $("#input_phone").val("")
            $("#input_birth").val("")
            $("#input_email").val("")
            $("#input_name").val("")
            $("#input_pwd").val("")
            $("#input_pwd_con").val("")
    
            $("#mod_id").val("")
            $("#mod_phone").val("")
            $("#mod_birth").val("")
            $("#mod_email").val("")
            $("#mod_name").val("")
            $("#mod_image").val("")
        }

    })

    $("#cancel_btn").click(function(){
        selected = new Set();
        $(".member_list_table .member_data").prop("checked",false)
        $(".member_list_table .member_data").removeClass("active")
        $(".input_box").removeClass("active")
        $("#add_btn").removeClass("active")
        $("#add_btn").html("추가")
        AddBtn = true;

        $("#add_btn").css("display","inline-block")
        $("#modify_btn").css("display","none")
        $(".member_list_table .modify_box").removeClass("active")
        modBtn = true;

        $(".member_list_table th:nth-child(8)").html("상태")
        $(".member_list_table th:nth-child(9)").html("등록일")

        $("#input_id").val("")
        $("#input_phone").val("")
        $("#input_birth").val("")
        $("#input_email").val("")
        $("#input_name").val("")
        $("#input_pwd").val("")
        $("#input_pwd_con").val("")

        $("#modify_id").val("")
        $("#modify_phone").val("")
        $("#modify_birth").val("")
        $("#modify_email").val("")
        $("#modify_name").val("")
    })

    $("#status_btn").click(function(){
        let status = $("#status_cat").val();
        if(selected.size == 0){
            alert("선택된 목록이 없습니다.")
        }else{
            if(confirm("선택된 정보가 모두 변경됩니다. \n 정말 변경하시겠습니까?")==false)return;
            
            for (var seq of selected) {
                $.ajax({
                    url:"/admin/member/update/status?seq="+seq+"&status="+status,
                    type:"patch",
                    success:function(){
                        location.reload()
                    }
                })
            }
        }
    })
    $("#delete_btn").click(function(){
        if(selected.size == 0){
            alert("선택된 목록이 없습니다.")
        }else{
            if(confirm("선택된 정보가 모두 삭제됩니다. \n 정말 삭제하시겠습니까?")==false)return;
            
            for (var seq of selected) {
                $.ajax({
                    url:"/admin/member/delete?seq="+seq,
                    type:"delete",
                    success:function(){
                        location.reload()
                    }
                })
            }
        }
    })
    $(".member_list_table thead span").click(function(){
        let newOrder = $(this).attr("order-by");
        let order = $("#sending").attr("order");
        let adesc = $("#sending").attr("adesc");
        location.href="/admin/member?newOrder="+newOrder+"&order="+order+"&adesc="+adesc
    })
    $("#page_left_move").click(function(){
        let order = $("#sending").attr("order");
        let adesc = $("#sending").attr("adesc");
        let offset = $("#sending").attr("offset")-30;
        location.href="/admin/member?offset="+offset+"&newOrder="+order+"&adesc="+adesc
    })
    $("#page_right_move").click(function(){
        let order = $("#sending").attr("order");
        let adesc = $("#sending").attr("adesc");
        let offset = $("#sending").attr("offset")*1 + 30;
        
        location.href="/admin/member?offset="+offset+"&newOrder="+order+"&adesc="+adesc
    })



 
})
