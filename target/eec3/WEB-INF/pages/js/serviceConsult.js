//创建Ajax请求
var xmlHttp;//声明全局变量
var sessionId;//声明全局变量
function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    }else{
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
//开启长轮询
function start(temp){
    sessionId = temp;
    setInterval("checkChatContent()",1000);
}
//检查与客户的对话内容
function checkChatContent(){
    //var url = "/checkChatContent/{sessionId}";
    var url = "/checkChatContent?sessionId="+sessionId;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = checkChatContentState;
    //alert(3);
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//检查请求状态
function checkChatContentState(){
    //alert("xmlHttp.readyState="+xmlHttp.readyState);
    if(xmlHttp.readyState == 4){
        //alert("xmlHttp.status="+xmlHttp.status);
        if(xmlHttp.status == 200){
            ChatContentUpdate();
        }
    }
}
//聊天内容刷新
function ChatContentUpdate(){
    //var xml = xmlHttp.responseXML;
    //var chatContents = xml.getElementsByTagName("chatContent");
    //var chatContent = chatContents[0].firstChild==null?"":chatContents[0].firstChild.nodeValue;
    //if(chatContent != ""){
    //    document.getElementById("chatContent").value = chatContent;
    //    //setTimeout("dealErr()",2000);
    //}
    document.getElementById("chatContent").innerHTML = xmlHttp.responseText;
}
//后台客服发送内容
function sendServer(){
    var sendContent = document.getElementById("sendContent").value;
    var url = "/sendServer?sendContent="+sendContent+"&sessionId="+sessionId;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = sendStateServer;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//发送请求状态
function sendStateServer(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            sendUpdateServer();
        }
    }
}
//发送成功并更新内容
function sendUpdateServer(){
    sendClearServer();
    var xml = xmlHttp.responseXML;
}
//清空发送文本框内容
function sendClearServer(){
    document.getElementById("sendContent").value = "";
}