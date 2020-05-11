function verifPassword() {
	var listOfUsers = new Map();
	listOfUsers.set("","");
	listOfUsers.set("Machin","AcA123");
	listOfUsers.set("Bidule","g");
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(listOfUsers.has(username)){
		if(listOfUsers.get(username)===password){
			document.location.href="../Bootstrap/map.html";
		}else{
			alert("Wrong Password");
		}
	}else{
		alert("Unknown User");
	}
}

function getServerData(url, success) {
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function putServerData(url, data, success){
    console.log(data);
    $.ajax({
        type: 'PUT',
        data: data,
        url:url
    }).done(success);
}

function deleteServerData(url, data, success){
    console.log(data);
    $.ajax({
        type: 'DELETE',
        data: data,
        url:url
    }).done(success);
}

function postServerData(url, data, success){
    console.log(data);
    $.ajax({
        type: 'POST',
        data: data,
        url:url
    }).done(success);
}

login = () =>{
/*function login(){*/
    console.log("function login() called");
    console.log(document.getElementById("password").value);
    postServerData("../ws/user/login","username="+document.getElementById("username").value+"&password="+document.getElementById("password").value,function(result){
		console.log(result);
	});
}

signUp = () =>{
/*function signUp(){*/
    console.log("function signUp() called");
    console.log(document.getElementById("passSign").value);
    postServerData("../ws/user/signUp","userSign="+document.getElementById("userSign").value+"&email="+document.getElementById("email").value+"&passSign="+document.getElementById("passSign").value,function(result){
		console.log(result);
	});
}
/*
if(result.equals("Sign Up completed")){
    document.location.href="../Bootstrap/home.html";
}
else{
    alert("All fields must be completed");
}*/