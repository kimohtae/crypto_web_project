// index.js
$(function(){
    let pos = $('#news').offset();
        let wid = $('#news').width();
        let hei = $('#news').innerHeight();
        console.log(pos.left)
        console.log(pos.top)
        console.log(wid)
        console.log(hei)
        $('#underline').css({
           "width":wid+"px",
           "top":pos.top+hei+4+"px",
           "left":pos.left+"px",
           "height":"2px",
       })
    $('#news').click(function(){
        let pos = $('#news').offset();
        let wid = $('#news').width();
        let hei = $('#news').innerHeight();
        console.log(pos.left)
        console.log(pos.top)
        console.log(wid)
        console.log(hei)
        $('#underline').css({
           "width":wid+"px",
           "top":pos.top+hei+4+"px",
           "left":pos.left+"px",
           "height":"2px",
       })
    })
    $('#stra').click(function(){
        let pos = $('#stra').offset();
        let wid = $('#stra').width();
        let hei = $('#stra').innerHeight();
        console.log(pos.left)
        console.log(pos.top)
        console.log(wid)
        console.log(hei)
        $('#underline').css({
           "width":wid+"px",
           "top":pos.top+hei+4+"px",
           "left":pos.left+"px",
           "height":"2px",
       })
    })
    $('#com').click(function(){
        let pos = $('#com').offset();
        let wid = $('#com').width();
        let hei = $('#com').innerHeight();
        console.log(pos.left)
        console.log(pos.top)
        console.log(wid)
        console.log(hei)
        $('#underline').css({
           "width":wid+"px",
           "top":pos.top+hei+4+"px",
           "left":pos.left+"px",
           "height":"2px",
       })
    })  
    $('#adm').click(function(){
        let pos = $('#adm').offset();
        let wid = $('#adm').width();
        let hei = $('#adm').innerHeight();
        console.log(pos.left)
        console.log(pos.top)
        console.log(wid)
        console.log(hei)
        $('#underline').css({
           "width":wid+"px",
           "top":pos.top+hei+4+"px",
           "left":pos.left+"px",
           "height":"2px",
       })
    })  
    
    $(".news_page_wrap").addClass("active")

    $("#news").click(function(){
        $(".news_page_wrap").addClass("active")
        $(".stra_page_wrap").removeClass("active")
        $(".com_page_wrap").removeClass("active")
        $(".admin_page_wrap").removeClass("active")
        
    })
    $("#stra").click(function(){
        $(".news_page_wrap").removeClass("active")
        $(".stra_page_wrap").addClass("active")
        $(".com_page_wrap").removeClass("active")
        $(".admin_page_wrap").removeClass("active")
    })
    
    $("#com").click(function(){
        $(".news_page_wrap").removeClass("active")
        $(".stra_page_wrap").removeClass("active")
        $(".com_page_wrap").addClass("active")
        $(".admin_page_wrap").removeClass("active")
    })
    
    $("#adm").click(function(){
        $(".news_page_wrap").removeClass("active")
        $(".stra_page_wrap").removeClass("active")
        $(".com_page_wrap").removeClass("active")
        $(".admin_page_wrap").addClass("active")
    })
    
})    
