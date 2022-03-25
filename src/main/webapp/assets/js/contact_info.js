// contact_info.js
$(function(){

    $(".contact_page_wrap").addClass("active")
    $(".contact_list_table").addClass("active")



    $(".contact_list_table tbody tr").dblclick(function(){
        let check = $(this).attr("data-seq")
        $(".reply_list_box div").remove();
        $(".popup_container").css("display","block")
        $(".reply_popup_wrap").css("display","block")
        $.ajax({
            url:"/admin/contact/select?seq=" + check,
            type:"get",
            success:function(r){
                $("#popup_number").html("번호: "+r.ci_seq);
                $("#popup_author").html("작성자: "+r.mi_id);
                $("#popup_title").html("제목: "+r.ci_title);
                $("#content_wrap").html(r.ci_contents);
                let status = r.ci_status==1?"답변완료":"미답변";
                $("#popup_status").html(" 상태: "+status);
                $("#popup_reg_dt").html("등록일: "+r.ci_reg_dt);
                $("#popup_mod_dt").html("수정일: "+r.ci_mod_dt);
            }
        })
        $.ajax({
            url:"/admin/contact/reply/select?seq="+check,
            type:"get",
            success:function(r){
                for(let i=0; i<r.length; i++){
                    let data = 
                    '<div class="reply_list" id="'+ r[i].cri_seq +'r" >' + 
                        '<p class="reply_id">'+ r[i].mi_id +'</p>'+
                        '<p class="reply_content">'+ r[i].cri_contents +'</p>'+
                        '<p class="reply_reg_dt">' +r[i].cri_format_dt+ '</p>'+
                        '<button class="reply_del_btn" reply-seq="'+ r[i].cri_seq +'r"><i class="far fa-trash-alt"></i></button>'+
                    '</div>'
                    $(".reply_list_box").append(data);
                }
                $(".reply_list_box .reply_del_btn").click(function(){
                    if(confirm("정말 삭제하시겠습니까?")==false) return;
                    let reply_sel = $(this).attr("reply-seq");
                    reply_sel = reply_sel.slice(0,-1);
                    $.ajax({
                        url:"/admin/contact/reply/delete?seq="+reply_sel,
                        type:"delete",
                        success:function(r){
                            if(r.status){
                                reply_sel = reply_sel + "r";
                                $("#"+reply_sel).remove()
                            }
                        }
                    })
                })
            }
        })
        $("#admin_reply_btn").click(function(){
            if(confirm("정말 등록하시겠습니까?")==false) return;
            let data = {
                "cri_ci_seq":check,
                "cri_mi_seq":login_user_mi_seq,
                "cri_contents":$("#admin_reply_text").val()
            }
            $.ajax({
                url:"/admin/contact/reply/insert",
                type:"post",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(){
                    location.reload()
                }
            })
            
        })
        $("#popup_delete_btn").click(function(){
            if(confirm("정말 삭제하시겠습니까?")==false) return;
            $.ajax({
                url:"/admin/contact/delete?seq="+check,
                type:"delete",
                success:function(r){
                    if(r.status){
                        location.reload();
                    }
                }
            })
        })
        
    })


   $("#popup_close_btn").click(function(){
        location.reload();
   })
   $("#page_left_move").click(function(){
    let offset = $("#sending").attr("offset");
    let page = $("#sending").attr("page");
    let cnt = $("#sending").attr("cnt");
    offset -= 20;
    if(offset<0) offset = 0;
    location.href="/admin/contact?offset="+offset
})
$("#page_right_move").click(function(){
    let offset = $("#sending").attr("offset");
    let page = $("#sending").attr("page");
    let cnt = $("#sending").attr("cnt");
    offset = offset*1 + 20;
    if(offset>cnt) offset = (page-1)*20;
    location.href="/admin/contact?offset="+offset
})
 
})
