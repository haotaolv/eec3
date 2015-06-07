/**
 * Created by peimengqi on 15/1/11.
 */
$(function(){
    $("#newVoterPanel").hide();

    //固定项目数目（主题、描述、起始时间、结束时间）
    solidItemNum = $(".voterSolidItem").size();


    //新增自定义投票
    $("#addVoterBtn").click(function(){
        $("#newVoterPanel").slideToggle("normal");
    })

    //新增自定义投票项目
    $("#addItemBtn").click(function(){
        //缓存form-groups
        formGroups = $("#newVoterPanel div.form-group");
        //获得新投票项目的标号
        itemIndex = formGroups.size()-solidItemNum +1;

        //拼接出新投票项目的HTML代码
        str = "<div class=\"form-group\">"+
        "<label for=\"voterItem"+itemIndex+"\">投票项目"+itemIndex+"</label>"+
        "<input type=\"text\" class=\"form-control\" id=\"voterItem"+itemIndex+"\" placeholder=\"在此填写投票项目\">"+
        "</div>";

        //将新投票项目加入网页
        formGroups.last().after(str);
    })

    $("#newVoterForm").submit(function(){
        //新投票的主题
        voterTheme = $("#voterTheme").val();
        //新投票的描述
        voterDesc = $("#voterDesciption").val();
        //新投票的起始日期
        voterStartDate = $("#voterStartTime").val();
        //新投票的结束日期
        voterEndDate = $("#voterEndTime").val();

        //获取自定义投票项目的数量，以便之后的遍历
        allinputs = $("#newVoterForm input");
        voterLength = allinputs.size()-solidItemNum;

        var voterValues = new Array(voterLength);
        for(i=1;i<=voterLength;i++) {
            voterValues[i-1] = $("#voterItem" + i).val();
        }

        $.post("/custom/add", {voterTheme:voterTheme, voterDesc:voterDesc,
                voterStartDate:voterStartDate, voterEndDate:voterEndDate, voterValues:voterValues},
            function(data){
                //TODO: 完成自定义投票ajax函数
            })
    })
})
