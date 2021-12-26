// post_info.js
$(function(){

    $(".post_page_wrap").addClass("active")
    $(".post_list_table").addClass("active")
    $(".post_list_table tbody tr input").css("display","none")

    let selected = new Set();
    $(".post_list_table tbody tr").click(function(){
        let check = $(this).attr("data-seq");

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
    
    $(".post_list_table tbody tr").dblclick(function(){
        let check = $(this).attr("data-seq")
        selected = new Set();
        $(".post_list_table tbody tr").prop("checked",false)
        $(".post_list_table tbody tr").removeClass("active")
        
       
    })

    $("#cancel_btn").click(function(){
        selected = new Set();
        $(".post_list_table .member_data").prop("checked",false)
        $(".post_list_table .member_data").removeClass("active")
        $(".input_box").removeClass("active")
        $("#add_btn").removeClass("active")
        $("#add_btn").html("추가")
        AddBtn = true;

        $("#add_btn").css("display","inline-block")
        $("#modify_btn").css("display","none")
        $(".post_list_table .modify_box").removeClass("active")
        modBtn = true;

        $(".post_list_table th:nth-child(8)").html("상태")
        $(".post_list_table th:nth-child(9)").html("등록일")

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
    $(".post_list_table thead span").click(function(){
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
