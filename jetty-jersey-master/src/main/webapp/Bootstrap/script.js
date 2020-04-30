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