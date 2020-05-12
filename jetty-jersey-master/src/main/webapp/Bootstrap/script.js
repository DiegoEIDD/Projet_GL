listOfUsers = new Map();

function verifPassword() {
	login();
	listOfUsers.set("","");
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(listOfUsers.has(username)){
		if(listOfUsers.get(username)===password){
			listOfUsers.clear()
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
        if(result === "Connected"){
            document.location.href="../Bootstrap/map.html";
        }
        else{
        alert("All fields must be completed");
        }
    });
}

signUp = () =>{
/*function signUp(){*/
    console.log("function signUp() called");
    console.log(document.getElementById("passSign").value);
    postServerData("../ws/user/signUp","userSign="+document.getElementById("userSign").value+"&email="+document.getElementById("email").value+"&passSign="+document.getElementById("passSign").value,function(result){
        console.log(result);
        if(result === "Sign Up completed"){
            document.location.href="../Bootstrap/home.html";
        }
        else{
        alert(result);
        }
	});
}

var check = {};


check["userSign"] = function() {
    var username = document.getElementById("userSign");
    if (username.value.length >= 3) {
        return true;
    } else {
		alert("Username must have at least 3 characters");
        return false;
    }
};

check["passSign"] = function() {
    var pwd1 = document.getElementById("passSign");
    if (pwd1.value.length >= 6) {
        return true;
    } else {
		alert("Password must have at least 6 characters");
        return false;		
    }
};

check["passSign2"] = function() {
    var pwd1 = document.getElementById("passSign");
        pwd2 = document.getElementById("passSign2");
    if (pwd1.value === pwd2.value && pwd2.value != "") {
        return true;
    } else {
		alert("Passwords not identical");
        return false;		
    }
};

function createAccount(){
	var result = true;
	for (var i in check) {
		result = check[i]() && result;
	}
	if(result){
		var username=document.getElementById("userSign").value;
		var password=document.getElementById("passSign").value;
		signUp();
		alert("Account created");
		document.location.href="../Bootstrap/home.html";
	}
}

function testRecup(){
	postServerData("../ws/user/login","username="+"MyName"+"&password="+"MyPassword",function(result){
		console.log(result);
	});
	var x=getServerData("../ws/user/login",function(result){
		console.log(result);
	});
	console.log(x);
}

function sendEmail() {
	Email.send({
		SecureToken : "93778168-fbda-481f-a6a5-ba63f66265b1",
	    To : "maximilien.duvina@gmail.com",
	    From : "maximilien.duvina@gmail.com",
	    Subject : "This is the subject",
	    Body : "And this is the body"
	}).then(
	  message => alert(message)
	);
}

