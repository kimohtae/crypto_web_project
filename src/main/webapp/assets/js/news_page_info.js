// new_page_info.js
$(function(){

    $(".news_page_wrap").addClass("active")
    $(".news_list_table").addClass("active")

    let selected = new Set();
    $(".news_list_table .news_data").click(function(){
        let check = $(this).attr("data-seq");

        if($("#"+check+" input").prop("checked")){
            $("#"+check+" input").prop("checked",false)
            $("#"+check).removeClass("active")
            selected.delete(check)
        }else{
            $("#"+check+" input").prop("checked",true)
            $("#"+check).addClass("active")
            selected.add(check)
        }
        console.log(selected)
    
    })

    $("#delete_bun").click(function(){
        if(selected.size==0){
            alert("선택된 목록이 없습니다.")
            return;
        }
        if(!confirm("정말 삭제하시겠습니까?"))return;
        for(let s of selected){
            s=s.slice(0,-1);
            $.ajax({
                url:"/admin/news/delete?seq="+s,
                type:"delete",
                success:function(){
                    location.reload()
                }
                
            })
        }
    })










 
})
