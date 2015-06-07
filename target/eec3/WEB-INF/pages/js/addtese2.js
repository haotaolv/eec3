$(function(){

    $("#addItemBtn").click(function(){
        kcts = $("div.kcts");
        itemIndex = kcts.size()+1;

        str= "<div class=\"row kcts\">" +
        "<div class=\"col-md-12 form-group courseSolidItem fg1\">"+
        "<label for=\"courseTese"+itemIndex+
        "\">课程特色"+itemIndex+
            "：</label>"+
        "<input type=\"text\" class=\"form-control\" id=\"courseTese"+itemIndex+
        "\" placeholder=\"填写课程特色\">";
        kcts.last().after(str);
    })

    $("#delItemBtn").click(function() {
        kcts = $("div.kcts");
        if(kcts.size() > 1) {
            kcts.last().remove();
        }
    })

    $("saveItemBtn").click(function() {
        kcts = $("div.kcts");
    })


})
