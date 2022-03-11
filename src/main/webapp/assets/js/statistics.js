// post_info.js
$(function(){
    let seq_map = new Map();
    $(".stat_page_wrap").addClass("active")
    $(".stat_list_table").addClass("active")
    $(".stat_list_table tbody tr input").css("display","none")

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
})
