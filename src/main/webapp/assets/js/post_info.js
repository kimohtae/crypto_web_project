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
        check = check.slice(0,-1);
        selected = new Set();
        $(".post_list_table tbody tr").prop("checked",false)
        $(".post_list_table tbody tr").removeClass("active")
        $(".popup_container").css("display","block")
        
        $.ajax({
            url:"/admin/post/select?seq=" + check,
            type:"get",
            success:function(r){
                $("#popup_number").html("번호: "+r.pi_seq);
                $("#popup_author").html("작성자: "+r.mi_name);
                $("#popup_title").html("제목: "+pi_title);
                $("#content_wrap").html(pi_contents);
                $("#popup_cat").html(ti_table+"/"+iti_type);
                $("#popup_status").html("조회:"+pi_views+" 추천:"+pi_like+" 상태:"+pi_status==1?"공개":"비공개");
                $("#popup_reg_dt").html("등록일: "+pi_reg_dt);
                $("#popup_mod_dt").html("수정일: "+pi_mod_dt);
            }
        })
       
    })

   


 
})
