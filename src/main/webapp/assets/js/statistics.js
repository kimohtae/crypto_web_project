// post_info.js
$(function(){
    
    $(".stat_page_wrap").addClass("active")
    $(".stat_list_table").addClass("active")
    $(".stat_list_table tbody tr input").css("display","none")
    $("#keyword_type").val(type)
    $(".search_post_box").val(keyword)

    let seq_map = new Map();
    $("tbody tr").click(function(){
        let seq = $(this).attr("data-seq");
        if(seq_map.get(seq) == null || !seq_map.get(seq)){
            seq_map.set(seq, true);
            $(this).addClass("active");
        }else{
            seq_map.set(seq, false);
            $(this).removeClass("active");
        }
    })

    $("#initial_btn").click(function(){
        $("tbody tr").removeClass("active");
        seq_map = new Map();
    })
    $("#delete_btn").click(function(){
        for(let item of seq_map.keys()) {
            if(seq_map.get(item)){
                let cur_seq = item.slice(0,-1);

                $.ajax({
                    url:"/admin/statistics/delete?seq="+cur_seq,
                    type:"delete",
                    success:function(r){
                        location.reload();
                    }
                })
            }
        }
    })
    $("#status_btn").click(function(){
        for(let item of seq_map.keys()) {
            if(seq_map.get(item)){
                let cur_seq = item.slice(0,-1);
                $.ajax({
                    url:"/admin/statistics/status?seq="+cur_seq,
                    type:"patch",
                    success:function(r){
                        location.reload()
                    }
                })
            }
        }
        
    })
    let uploaded_img;

    $("#add_si_img_wrap").click(function(){
        $("#add_input_file").trigger("click");
    })
    $("#add_input_file").change(function(){
        let form = $(".add_input_contents .add_form_img");
        let formData = new FormData(form[0]);
        $.ajax({
            url:"/image/statistics",
            type:"post",
            data:formData,
            contentType:false,
            processData:false,
            success: function(r){
                $("#add_si_img_wrap").attr("style", "background-image:url(http://localhost:8088/image/statistics/"+r.image+")");
                if(uploaded_img != null){
                    $.ajax({
                        url:"/image/statistics/"+uploaded_img,
                        type:"delete",
                        success:function(r){
                            $("#add_input_file").val();
                        }
                    })
                }
                uploaded_img = r.image;
            }
        })
    })

    $("#si_img_wrap").click(function(){
        $("#mod_input_file").trigger("click");
    })
    $("#mod_input_file").change(function(){
        let form = $(".popup_wrap .form_img");
        let formData = new FormData(form[0]);
        $.ajax({
            url:"/image/statistics",
            type:"post",
            data:formData,
            contentType:false,
            processData:false,
            success: function(r){
                $("#si_img_wrap").attr("style", "background-image:url(http://localhost:8088/image/statistics/"+r.image+")");
                if(uploaded_img != null){
                    $.ajax({
                        url:"/image/statistics/"+uploaded_img,
                        type:"delete",
                        success:function(r){
                            $("#mod_input_file").val();
                        }
                    })
                }
                uploaded_img = r.image;
            }
        })
    })

    $("#img_del").click(function(){
        if(uploaded_img != null){
            $.ajax({
                url:"/image/statistics/"+uploaded_img,
                type:"delete",
                success:function(r){
                    $("#add_si_img_wrap").attr("style", "background-image:url()");
                }
            })
        }
    })
    $("#mod_img_del").click(function(){
        if(uploaded_img != null){
            $.ajax({
                url:"/image/statistics/"+uploaded_img,
                type:"delete",
                success:function(r){
                }
            })
        }
        $("#si_img_wrap").attr("style", "background-image:url()");
    })

    $("#add_btn").click(function(){
        $(".post_list_table tbody tr").removeClass("active")
        $(".add_container").css("display","block")
    })
    $("#add_popup_close_btn").click(function(){
        if(!confirm("????????? ???????????? ????????????. ?????????????????????????"))return;
        $(".add_container").css("display","none")
        if(uploaded_img != null){
            $.ajax({
                url:"/image/statistics/"+uploaded_img,
                type:"delete",
                success:function(r){
                    $("#add_si_img_wrap").attr("style", "background-image:url()");
                }
            })
        }
        $("#add_popup_title").val("")
        $("#add_popup_cat").val(0)
        $("#add_content_wrap").val("")
    })
    $("#popup_close_btn").click(function(){
        if(!confirm("????????? ????????? ???????????? ????????????. ?????????????????????????"))return;
        $(".popup_container").css("display","none")
        if(uploaded_img != null){
            $.ajax({
                url:"/image/statistics/"+uploaded_img,
                type:"delete",
                success:function(r){

                }
            })
        }

    })
    $("#add_popup_add_btn").click(function(){
        if(!confirm("????????? ?????????????????????????"))return;
        if($("#add_popup_title").val()==""){
            alert("????????? ????????? ?????????")
            return;
        }
        if($("#add_popup_cat").val()=="0"){
            alert("??????????????? ????????? ?????????")
            return;
        }
        
        let data = {
            "si_mi_seq":mi_seq,
            "si_title":$("#add_popup_title").val(),
            "si_sti_seq":$("#add_popup_cat").val(),
            "si_contents":$("#add_content_wrap").val(),
            "si_img_url":uploaded_img
        }
        $.ajax({
            url:"/admin/statistics/add",
            data:JSON.stringify(data),
            type:"put",
            contentType:"application/json",
            success:function(r){
                alert(r);
                location.reload();
            }
        })
    })
        
    $("#popup_modify_btn").click(function(){
        if(!confirm("????????? ????????? ????????? ??? ????????????. ????????? ?????? ???????????????????"))return;
        if($("#popup_title").val()==""){
            alert("????????? ????????? ?????????")
            return;
        }
        if($("#popup_cat").val()=="0"){
            alert("??????????????? ????????? ?????????")
            return;
        }
        if(uploaded_img == null){
            uploaded_img = $("#si_img_wrap").val()
        }

        let data = {
            "si_mi_seq":mi_seq,
            "si_seq":$("#popup_modify_btn").attr("data-seq"),
            "si_title":$("#popup_title").val(),
            "si_sti_seq":$("#popup_cat").val(),
            "si_contents":$("#content_wrap").val(),
            "si_img_url":uploaded_img
        }
        $.ajax({
            url:"/admin/statistics/modify",
            data:JSON.stringify(data),
            type:"patch",
            contentType:"application/json",
            success:function(r){
                alert(r);
                location.reload();
            }
        })
        
    })



    $(".stat_list_table tbody tr").dblclick(function(){
        let check = $(this).attr("data-seq")
        let mi_check = $(this).attr("mi-seq")
        console.log(mi_check)
        check = check.slice(0,-1);
        mi_check = mi_check.slice(0,-1);
        seq_map = new Map();
        if(mi_check != mi_seq){
            alert("???????????? ????????? ????????? ??? ????????????.");
            return;
        }
        
        $(".post_list_table tbody tr").removeClass("active")
        $(".popup_container").css("display","block")
        $(".popup_container").css("display","block")
        $(".reply_popup_wrap").css("display","block")
        $("#popup_modify_btn").attr("data-seq",check)
        
        $.ajax({
            url:"/admin/statistics/select?seq=" + check,
            type:"get",
            success:function(r){
                $("#popup_number").html("??????: "+r.si_seq);
                $("#popup_author").html("?????????: "+r.mi_name);
                $("#popup_title").val(r.si_title);
                $("#content_wrap").val(r.si_contents);
                $("#popup_cat").val(r.si_sti_seq);
                let status = r.si_status==1?"??????":"?????????";
                $("#popup_status").html("??????:"+r.si_view+" ??????:"+r.si_like+" ??????:"+status);
                $("#popup_reg_dt").html("?????????: "+r.si_reg_dt);
                $("#popup_mod_dt").html("?????????: "+r.si_mod_dt);
                $("#si_img_wrap").attr("style", "background-image:url(http://localhost:8088/image/statistics/"+r.si_img_url+")");
            }
        })
    })

    $(".search_post_btn").click(function(){
        cur_type = $("#keyword_type").val();
        cur_keyword = $(".search_post_box").val();
        location.href="/admin/statistics?type="+cur_type+"&keyword="+cur_keyword;
    })
    $(".search_post_box").keydown(function(e){
        if(e.keyCode == 13){
            $(".search_post_btn").trigger("click");
        }
    })
})
