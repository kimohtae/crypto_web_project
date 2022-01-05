// contact_info.js
$(function(){

    $(".contact_page_wrap").addClass("active")
    $(".contact_list_table").addClass("active")


    
    $("#delete_btn").click(function(){
        if(selected.size==0){
            alert("선택된 항목이 없습니다.")
            return;
        }else{
            if(!confirm("정말 삭제하시겠습니까?"))return;
        }
        for (var seq of selected){
            seq = seq.slice(0,-1);
            $.ajax({
                url:"/admin/contact/delete?seq="+seq,
                type:"delete",
                success:function(r){
                    if(r.status){
                        location.reload();
                    }
                }
            })
        }
    })


    $(".contact_list_table tbody tr").dblclick(function(){
        let check = $(this).attr("data-seq")
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
                    '<div class="reply_list" id="'+ r[i].pri_seq +'r" >' + 
                        '<p class="reply_id">'+ r[i].mi_id +'</p>'+
                        '<p class="reply_content">'+ r[i].pri_contents +'</p>'+
                        '<p class="reply_reg_dt">' +r[i].pri_format_dt+ '</p>'+
                        '<button class="reply_del_btn" reply-seq="'+ r[i].pri_seq +'r"><i class="far fa-trash-alt"></i></button>'+
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
    $(".popup_container").css("display","none")
    $(".reply_popup_wrap").css("display","none")
    $(".reply_list_box div").remove();
   })

 
})
