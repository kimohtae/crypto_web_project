// new_page_info.js
$(function(){
    $(".category_page_wrap").addClass("active")
    $(".category_list_table").addClass("active")

    $(".select_category").change(function(){
        let page_seq = $(this).val();
        $(".select_category").val(page_seq)
        
        if(page_seq == 1){
            $(".NewsTable").css("display","block");
            
            $(".NewsTable").removeClass("gone");

            $(".CommuTable").addClass("gone");
            $(".StatTable").addClass("gone");
        }
        if(page_seq == 2){
            $(".CommuTable").css("display","block");

            $(".CommuTable").removeClass("gone");
            
            $(".NewsTable").addClass("gone");
            $(".StatTable").addClass("gone");
        }
        if(page_seq == 3){
            $(".StatTable").css("display","block");

            $(".StatTable").removeClass("gone");
            
            $(".NewsTable").addClass("gone");
            $(".CommuTable").addClass("gone");
        }
    })

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

    $(".initial_btn").click(function(){
        $("tbody tr").removeClass("active");
        seq_map = new Map();
    })
    $(".add_btn").click(function(){
        seq_map = new Map();
        $(".category_list_table tbody tr").removeClass("active")
        $(".container").css("display","block")
        $(".popup_contents .popup_name span").html("추가")
        $("#popup_add_btn").css("display","inline-block")
        $("#popup_modify_btn").css("display","none")
        let table_seq = $(".NewsTable .select_category").val()
        $("#popup_add_btn").attr("table-seq",table_seq)
    })
    $("#popup_close_btn").click(function(){
        $(".container").css("display","none")
        $("#add_popup_name").val("")
        $("#add_popup_order").val(0)
    })

    $("#popup_add_btn").click(function(){
        let data
        if($(this).attr("table-seq")==1){
            data = {
                "nti_name":$("#add_popup_name").val(),
                "nti_order":$("#add_popup_order").val()
            }
            $.ajax({
                url:"/admin/category/news",
                data:JSON.stringify(data),
                type:"put",
                contentType:"application/json",
                success:function(r){
                    alert(r)
                    location.reload();
                }
            })
        }else if($(this).attr("table-seq")==2){
            data = {
                "cti_name":$("#add_popup_name").val(),
                "cti_order":$("#add_popup_order").val()
            }
            $.ajax({
                url:"/admin/category/commumity",
                data:JSON.stringify(data),
                type:"put",
                contentType:"application/json",
                success:function(r){
                    alert(r)
                    location.reload();
                }
            })
        }else if($(this).attr("table-seq")==3){
            data = {
                "sti_name":$("#add_popup_name").val(),
                "sti_order":$("#add_popup_order").val()
            }
            $.ajax({
                url:"/admin/category/statistics",
                data:JSON.stringify(data),
                type:"put",
                contentType:"application/json",
                success:function(r){
                    alert(r)
                    location.reload();
                }
            })
        }
        
    })

    $(".delete_btn").click(function(){
        if(!confirm("정말 삭제하시겠습니까?"))return;
        let cate_seq = $(".NewsTable .select_category").val();
        for(let item of seq_map.keys()) {
            if(seq_map.get(item)){
                if(cate_seq == 1){
                    $.ajax({
                        url:"/admin/category/news?seq="+item,
                        type:"delete",
                        success:function(){
                            location.reload();
                        }
                    })
                }else
                if(cate_seq == 2){
                    $.ajax({
                        url:"/admin/category/commumity?seq="+item,
                        type:"delete",
                        success:function(){
                            location.reload();
                        }
                    })
                }else
                if(cate_seq == 3){
                    $.ajax({
                        url:"/admin/category/statistics?seq="+item,
                        type:"delete",
                        success:function(){
                            location.reload();
                        }
                    })
                }
            }
        }
    })

    $(".category_list_table tbody tr").dblclick(function(){
        seq_map = new Map();
        $(".category_list_table tbody tr").removeClass("active")
        $(".container").css("display","block")
        $(".popup_contents .popup_name span").html("수정")
        $("#popup_modify_btn").css("display","inline-block")
        $("#popup_add_btn").css("display","none")
        let table_seq = $(".NewsTable .select_category").val()
        let this_seq = $(this).attr("data-seq");
        let mod_name;
        let mod_order;
        $("#popup_modify_btn").attr("table-seq",table_seq)
        $("#popup_modify_btn").attr("data-seq",this_seq)

        if(table_seq == 1){
            $.ajax({
                url:"/admin/category/news?seq="+this_seq,
                type:"get",
                success:function(r){
                    mod_name = r.nti_name;
                    mod_order = r.nti_order;
                    $("#add_popup_name").val(mod_name)
                    $("#add_popup_order").val(mod_order)
                }
            })
        }else
        if(table_seq == 2){
            $.ajax({
                url:"/admin/category/commumity?seq="+this_seq,
                type:"get",
                success:function(r){
                    mod_name = r.cti_name;
                    mod_order = r.cti_order;
                    $("#add_popup_name").val(mod_name)
                    $("#add_popup_order").val(mod_order)
                }
            })
        }else
        if(table_seq == 3){
            $.ajax({
                url:"/admin/category/statistics?seq="+this_seq,
                type:"get",
                success:function(r){
                    mod_name = r.sti_name;
                    mod_order = r.sti_order;
                    $("#add_popup_name").val(mod_name)
                    $("#add_popup_order").val(mod_order)
                }
            })
        }   
    })
    $("#popup_modify_btn").click(function(){
        let table_seq = $(this).attr("table-seq");
        let data_seq = $(this).attr("data-seq");
        let data_name = $("#add_popup_name").val();
        let data_order = $("#add_popup_order").val();

        if(table_seq == 1){
            let data = {
                "nti_seq":data_seq,
                "nti_name":data_name,
                "nti_order":data_order
            }
            $.ajax({
                url:"/admin/category/news",
                type:"patch",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(r){
                    alert(r)
                    location.reload();
                }
            })
        }else
        if(table_seq == 2){
            let data = {
                "cti_seq":data_seq,
                "cti_name":data_name,
                "cti_order":data_order
            }
            $.ajax({
                url:"/admin/category/commumity",
                type:"patch",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(r){
                    alert(r)
                    location.reload();
                }
            })
        }else
        if(table_seq == 3){
            let data = {
                "sti_seq":data_seq,
                "sti_name":data_name,
                "sti_order":data_order
            }
            $.ajax({
                url:"/admin/category/statistics",
                type:"patch",
                data:JSON.stringify(data),
                contentType:"application/json",
                success:function(r){
                    alert(r)
                    location.reload();
                }
            })
        }  
    })





 
})
