$(document).ready(function () {
    $('#signIn').submit(sendLogin);

    function sendLogin(ev) {
        ev.preventDefault();

        let user = {
            email: $("#email").val(),
            password: $("#password").val()
        }

        console.log(user);

        $.ajax({
            type: 'POST',
            url: '/sign-in',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',

            data: JSON.stringify(user),
            success: function (response, status, xhr) {
                window.location = '/';
            },
            error: function (response, status, xhr) {
                alert("Incorrect username or password");
                console.log(response);
            }
        })
    }
});