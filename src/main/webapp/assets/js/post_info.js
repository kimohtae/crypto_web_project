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

    $("#initial_btn").click(function(){
        selected = new Set();
        $(".post_list_table tbody tr input").prop("checked",false)
        $(".post_list_table tbody tr").removeClass("active")
    })
    
    $("#status_btn").click(function(){
        if(selected.size==0){
            alert("선택된 항목이 없습니다.")
            return;
        }else{
            if(!confirm("정말 변경하시겠습니까?"))return;
        }
        for (var seq of selected){
            if(seq.slice(-1)=="p"){
                seq = seq.slice(0,-1);
                $.ajax({
                    url:"/admin/post/update/toPrivate?seq="+seq,
                    type:"patch",
                    success:function(r){
                        location.reload()
                    }
                })
            }else{
                seq = seq.slice(0,-1);
                $.ajax({
                    url:"/admin/post/update/toPublic?seq="+seq,
                    type:"patch",
                    success:function(r){
                        location.reload()
                    }
                })
            }
        }
    })
    
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
                url:"/admin/post/delete?seq="+seq,
                type:"delete",
                success:function(r){
                    if(r.status){
                        location.reload();
                    }
                }
            })
        }
    })


    $(".post_list_table tbody tr").dblclick(function(){
        let check = $(this).attr("data-seq")
        check = check.slice(0,-1);
        selected = new Set();
        $(".post_list_table tbody tr input").prop("checked",false)
        $(".post_list_table tbody tr").removeClass("active")
        $(".popup_container").css("display","block")
        
        $.ajax({
            url:"/admin/post/select?seq=" + check,
            type:"get",
            success:function(r){
                $("#popup_number").html("번호: "+r.pi_seq);
                $("#popup_author").html("작성자: "+r.mi_name);
                $("#popup_title").html("제목: "+r.pi_title);
                $("#content_wrap").html(r.pi_contents);
                $("#popup_content").html("내용")
                $("#popup_cat").html(r.ti_table+"/"+r.iti_type);
                let status = r.pi_status==1?"공개":"비공개";
                $("#popup_status").html("조회:"+r.pi_views+" 추천:"+r.pi_like+" 상태:"+status);
                $("#popup_reg_dt").html("등록일: "+r.pi_reg_dt);
                $("#popup_mod_dt").html("수정일: "+r.pi_mod_dt);
                console.log(r)
            }
        })
        $("#popup_delete_btn").click(function(){
            if(confirm("정말 삭제하시겠습니까?")==false) return;
            $.ajax({
                url:"/admin/post/delete?seq="+check,
                type:"delete",
                success:function(r){
                    if(r.status){
                        location.reload();
                    }
                }
            })
        })
    })

    $(".search_post_btn").click(function(){
        let keyword = $(".search_post_box").val();
        let type = $("#keyword_type").val();
        location.href="/admin/post?keyword="+keyword+"&type="+type
    })

    $("#seq_arrow").click(function(){
        let keyword = $("#sending").attr("keyword");
        let type = $("#sending").attr("type");
        let order = $("#sending").attr("order");
        let dir = $("#sending").attr("dir");
        
        if(dir=="asc"){
            dir="desc";
        }else{
            dir="asc";
        }
        location.href="/admin/post?keyword="+keyword+"&type="+type+"&order="+order+"&dir="+dir
    })
    $("#status_arrow").click(function(){
        let keyword = $("#sending").attr("keyword");
        let type = $("#sending").attr("type");
        let order = "pi_like";
        let dir = "desc";
        location.href="/admin/post?keyword="+keyword+"&type="+type+"&order="+order+"&dir="+dir
    })
    $("#page_left_move").click(function(){
        let keyword = $("#sending").attr("keyword");
        let offset = $("#sending").attr("offset");
        let page = $("#sending").attr("page");
        let cnt = $("#sending").attr("cnt");
        let type = $("#sending").attr("type");
        let order = $("#sending").attr("order");
        let dir = $("#sending").attr("dir");
        offset -= 20;
        if(offset<0) offset = 0;
        location.href="/admin/post?offset="+offset+"&keyword="+keyword+"&type="+type+"&order="+order+"&dir="+dir
    })
    $("#page_right_move").click(function(){
        let keyword = $("#sending").attr("keyword");
        let offset = $("#sending").attr("offset");
        let page = $("#sending").attr("page");
        let cnt = $("#sending").attr("cnt");
        let type = $("#sending").attr("type");
        let order = $("#sending").attr("order");
        let dir = $("#sending").attr("dir");
        offset = offset*1 + 20;
        if(offset>cnt) offset = (page-1)*20;
        location.href="/admin/post?offset="+offset+"&keyword="+keyword+"&type="+type+"&order="+order+"&dir="+dir
    })


   $("#popup_close_btn").click(function(){
    $(".popup_container").css("display","none")
   })
   $(".search_post_wrap").keydown(function(e){
       if(e.keyCode==13){
           $(".search_post_btn").trigger("click");
       }
   })

 
})
