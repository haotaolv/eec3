//创建Ajax请求
var xmlHttp;//声明全局变量
function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    }else{
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
//发送
function sendToServer(){
    var sendContent = document.getElementById("sendContent").value;
    var url = "/sendToServer?sendContent="+sendContent;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = sendState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//发送请求状态
function sendState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            sendUpdate();
        }
    }
}
//发送成功并更新内容
function sendUpdate(){
    sendClear();
}
//清空发送文本框内容
function sendClear(){
    document.getElementById("sendContent").value = "";
}
//检查用户是否处于在线状态
function check(){

    var url = "/check";
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = checkState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//检查请求状态
function checkState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            checkUpdate();
        }
    }
}
//检查更新
function checkUpdate(){
    var xml = xmlHttp.responseXML;
    var joinFlags = xml.getElementsByTagName("joinFlag");
    var joinFlag = joinFlags[0].firstChild==null?"":joinFlags[0].firstChild.nodeValue;
    if(joinFlag == "true"){
        fetch();
    }
}
//获取聊天内容
function fetch(){
    var url = "/fetch?time="+new Date().getTime();
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = fetchState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//获取聊天内容请求状态
function fetchState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            fetchUpdate();
        }
    }
}
//获取内容并更新页面
function fetchUpdate(){
    //alert("fetchUpdate...");
    //var xml = xmlHttp.responseXML;
    //var joinContents = xml.getElementsByTagName("joinContent");
    //var joinContent = joinContents[0].firstChild==null?"":joinContents[0].firstChild.nodeValue;
    //if(joinContent != ""){
    //    document.getElementById("chatContent").value = joinContent;
    //    //setTimeout("dealErr()",2000);
    //}

    //var text = xmlHttp.responseText;
    //alert("text=="+text);
    //document.getElementById("chatContent").value = text;

    document.getElementById("chatContent").innerHTML = xmlHttp.responseText;
    //document.getElementById("chatContent").value = xmlHttp.responseText;
}
//处理错误
function dealErr(){
    var url = "/dealErr";
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = dealErrState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//处理错误状态
function dealErrState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            dealErrUpdate();
        }
    }
}
//处理错误更新
function dealErrUpdate(){
    var xml = xmlHttp.responseXML;
}
//开启长轮询
function start(){
    //setUserName();
    setInterval("check()",1000);
}
//设置客户名
function setUserName(){
    var url = "/setName";
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = setNameState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//设置客户名请求状态
function setNameState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            setNameUpdate();
        }
    }
}
//设置名字更新
function setNameUpdate(){
    var xml = xmlHttp.responseXML;
}
