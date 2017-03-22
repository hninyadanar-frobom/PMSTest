function validate() {
	var x = document.myform.userEmail.value;
	var atposition = x.indexOf("@");
	var dotposition = x.lastIndexOf(".");
	if (atposition < 1 || dotposition < atposition + 2
			|| dotposition + 2 >= x.length) {
		alert("Please enter a valid e-mail address");
		return false;
	}

	if (document.myform.userPassword.value.length < 6) {
		alert("Password should at least 6 characters!");
		document.myform.userPassword.focus();
		return false;
	}

	if (document.myform.conPassword.value != document.myform.userPassword.value) {
		alert("Password is not match");
		return false;
	}

	var x = document.myform.userPhoneno.value;

	if (isNaN(x) || x.indexOf(" ") != -1) {
		alert("Enter numeric value")
		return false;
	}
	if (x.length < 8 && x.length > 12) {
		alert("invalid");
		return false;
	}
	if (x.charAt(0) != "0") {
		alert("it should start with 0 ");
		return false
	}
}