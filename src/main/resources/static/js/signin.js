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
            data: JSON.stringify(user),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json')
            },
            success: function (response, status, xhr) {
                console.log(xhr.responseJSON);
                localStorage.setItem("token", xhr.responseJSON.token);
                window.location = '/records';
            },
            error: function (response, status, xhr) {
                alert("Incorrect username or password", xhr.responseJSON);
            }
        })
    }

});