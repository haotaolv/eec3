//创建Ajax请求
var xmlHttp;//声明全局变量
function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    }else{
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
//检查客户列表
function checkUserList(){

    var url = "/checkUserList";
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = checkListState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//检查请求状态
function checkListState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            onlineUserUpdate();
        }
    }
}
//显示并更新在线用户
function onlineUserUpdate(){
    document.getElementById("onlineUser").innerHTML = xmlHttp.responseText;
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
    setInterval("checkUserList()",3000);
}
//设置客服名
function setUserName(){
    var servername = "shanghai";
    var url = "/setNameServer/servername";
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

//设置客服状态
function setServerFlag(){
    var url = "/setServerFlag";
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = checkServerState;
    url = encodeURI(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}
//检查请求服务状态
function checkServerState(){
    if(xmlHttp.readyState == 4){
        if(xmlHttp.status == 200){
            serverStateUpdate();
        }
    }
}
//客服状态更新
function serverStateUpdate(){
    var xml = xmlHttp.responseXML;
}
