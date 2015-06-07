$(function(){

    //固定项目数目 13个
    solidItemNum = $("div.courseSolidItem").size();

    //新增自定义课程特色
    $("#addItemBtn").click(function(){
        //缓存form-groups
        formGroups = $("div.fg1");
        //获得新课程特色的标号
        itemIndex = formGroups.size()-solidItemNum +3;

        //拼接出新课程特色的HTML代码
        str = "<div class=\"form-group fg1\">"+
        "<label for=\"courseTese"+itemIndex+"\">课程特色"+itemIndex+"</label>"+
        "<input type=\"text\" class=\"form-control\" id=\"courseTese"+itemIndex+"\" placeholder=\"填写课程特色\">"+
        "</div>";

        //将新课程特色加入网页
        formGroups.last().after(str);
    })

    //删除自定义课程特色
    $("#delItemBtn").click(function () {
        //缓存form-groups
        formGroups = $("div.fg1");

        if(formGroups.size() > 13) {
            formGroups.last().remove();
        }
    })

    $("#saveItemBtn").click(function() {
        formGroups = $("div.fg1");
        itemNum = formGroups.size()-11;
        var courseTese = "";
        for(i=1; i<= itemNum; i++) {
            courseTese = courseTese+$("#courseTese"+i).val()+"$$";
        }
        str = "<div class=\"form-group\">"+
            "<input type=\"text\" class=\"form-control hidden\" id=\"courseTese\" name=\"courseTese\" value=\"" +courseTese+ "\"/>"+
            "</div>";
        formGroups.last().after(str);
        alert("课程特色已保存，如需再次编辑请重新保存！");
    })

})
