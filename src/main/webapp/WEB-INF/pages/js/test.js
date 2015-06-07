
//设置客户名
function setUserNameCookie(){
    var url = "/setName";
    alert("setUserNameCoolie");
    createXMLHttpRequest();
    alert(11);
    xmlHttp.onreadystatechange = setNameStateTest;
    alert(22);
    url = encodeURI(url);
    alert(33);
    xmlHttp.open("GET",url,true);
    alert(44);
    xmlHttp.send(null);
    alert(55);
}
//设置客户名请求状态
function setNameStateTest(){
    alert(1);
    if(xmlHttp.readyState == 4){
        alert(2);
        if(xmlHttp.status == 200){
            alert(3);
            setNameUpdateTest();
        }
    }
}
//设置名字更新
function setNameUpdateTest(){
    var xml = xmlHttp.responseXML;
}