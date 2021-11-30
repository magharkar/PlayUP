function getOtp() {
    var nameText = document.getElementById("username").value;
    var emailText = document.getElementById("email").value;
    var contactText = document.getElementById("contact").value;
    var passwordText = document.getElementById("password").value;

	var windowLocation = window.location.href;

    const obj = {username: nameText, email: emailText, contact: contactText, password: passwordText};
    const supportJSON = JSON.stringify(obj);

    var request = $.ajax({
        url:  windowLocation + "/getOtp",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: supportJSON,
    });

    request.fail(function(jqXHR, textStatus) {
        confirm("Request failed: " + textStatus);
    });
}