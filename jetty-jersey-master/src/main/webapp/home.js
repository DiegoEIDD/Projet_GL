function getServerData(url, success) {
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function verifPassword() {
	var listOfUsers = new Map();
	listOfUsers.set("Machin","AcA123")
	listOfUsers.set("Bidule","g")
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(listOfUsers.has(username)){
		if(listOfUsers.get(username)===password){
			document.location.href="../Bootstrap/map.html";
		}else{
			alert("Wrong Password")
		}
	}else{
		alert("Unknown User")
	}
}

$.Put = function (url, data, callback) {
    $.ajax({
        url: url,
        type: "put",
        contentType: "application/json",
        dataType: "json",
        data: data,
        timeout: 60000,
        success: function (msg) {
            callback(msg);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });
};

$.Post = function (url, data, callback) {
    $.ajax({
        url: url,
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: data,
        timeout: 20000,
        success: function (msg) {
            callback(msg);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });
};

$.Delete = function (url, data, callback) {
    $.ajax({
        url: url,
        type: "delete",
        contentType: "application/json",
        dataType: "json",
        data: data,
        success: function (msg) {
            callback(msg);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });
};

function callDone(result) {
    var templateExample = _.template($('#templateExample').html());

    var html = templateExample({
        "attribute": JSON.stringify(result)
    });

    $("#result").append(html);
}

$(function () {
    /*
    $("#buttonGet").click(function () {
        getServerData("/wsStub/user/password", callDone);
    });
    $("#buttonPut").click(function () {
        var toto = { "value" : 10};
        $.Put("/wsStub/user/addMap", JSON.stringify(toto), callDone);
    });
    $("#buttonPost").click(function () {
        $.Post("/wsStub/user/modNames", null, callDone);
    });
    $("#buttonDelete").click(function () {
        $.Delete("/wsStub/user/deleteF", null, callDone);
    });
    */
   //MapRessourcesStub
   ///////////////////////GET///////////////////////////
   $("#buttonGetNameMap").click(function () {
        getServerData("/wsStub/map/names", callDone);
    });
    $("#buttonGetAccess").click(function () {
        getServerData("/wsStub/map/access", callDone);
    });
    $("#buttonGetMarker").click(function () {
        getServerData("/wsStub/map/markers", callDone);
    });
    $("#buttonGetEvent").click(function () {
        getServerData("/wsStub/map/event", callDone);
    });
    $("#buttonPrintMap").click(function () {
        getServerData("/wsStub/map/print", callDone);
    });
    ////////////////////PUT/////////////////////////////
    $("#buttonShareMap").click(function () {
        $.Put("/wsStub/map/share", null, callDone);
    });
    $("#buttonAddMarker").click(function () {
        $.Put("/wsStub/map/addMark", null, callDone);
    });
    $("#buttonAddEvent").click(function () {
        $.Put("/wsStub/map/addEvt", null, callDone);
    });
    ////////////////////POST///////////////////////////
    ///////////////////DELETE//////////////////////////
    $("#buttonUnshareMap").click(function () {
        $.Delete("/wsStub/map/unshare", null, callDone);
    });
    $("#buttonDeleteMarker").click(function () {
        $.Delete("/wsStub/map/delMark", null, callDone);
    });
    $("#buttonDeleteEvent").click(function () {
        $.Delete("/wsStub/map/delEvt", null, callDone);
    });


    //UserRessourcesStub
    ///////////////////////GET///////////////////////////
    $("#buttonGetNameUser").click(function () {
        getServerData("/wsStub/user/name", callDone);
    });
    $("#buttonGetPassword").click(function () {
        getServerData("/wsStub/user/password", callDone);
    });
    $("#buttonGetFriends").click(function () {
        getServerData("/wsStub/user/friend", callDone);
    });
    $("#buttonGetMaps").click(function () {
        getServerData("/wsStub/user/maps", callDone);
    });
    ////////////////////PUT/////////////////////////////
    $("#buttonAddMaps").click(function () {
        $.Put("/wsStub/user/addMap", null, callDone);
    });
    $("#buttonAddFriends").click(function () {
        $.Put("/wsStub/user/addF", null, callDone);
    });
    ////////////////////POST///////////////////////////
    $("#buttonModifyMapName").click(function () {
        $.Post("/wsStub/user/modNames", null, callDone);
    });
    ///////////////////DELETE//////////////////////////
    $("#buttonDeleteFriends").click(function () {
        $.Delete("/wsStub/user/deleteF", null, callDone);
    });
    $("#buttonDeleteMap").click(function () {
        $.Delete("/wsStub/user/deleteMap", null, callDone);
    });


    //MarkerRessourcesStub
    ///////////////////////GET///////////////////////////
    $("#buttonGetNameMarker").click(function () {
        getServerData("/wsStub/marker/name", callDone);
    });
    $("#buttonGetMessages").click(function () {
        getServerData("/wsStub/marker/messages", callDone);
    });
    $("#buttonGetPosition").click(function () {
        getServerData("/wsStub/marker/position", callDone);
    });
    $("#buttonGetDuration").click(function () {
        getServerData("/wsStub/marker/duration", callDone);
    });
    ////////////////////PUT/////////////////////////////
    $("#buttonAddImage").click(function () {
        $.Put("/wsStub/marker/addImg", null, callDone);
    });
    $("#buttonAddMessage").click(function () {
        $.Put("/wsStub/marker/addMsg", null, callDone);
    });
    ////////////////////POST///////////////////////////
    ///////////////////DELETE//////////////////////////
    $("#buttonDeleteMessage").click(function () {
        $.Delete("/wsStub/marker/deleteMsg", null, callDone);
    });

});