$(document).ready(function () {
    $('#signIn').submit(sendLogin);

    function sendLogin(ev) {
        ev.preventDefault();

        let user = {
            username: $("#username").val(),
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
                // localStorage.setItem("token", xhr.getResponseHeader("Authorization"));
                localStorage.setItem("token", xhr.responseJSON.token);
                window.location = '/records';
                // getMain();

            },
            error: function (response, status, xhr) {
                alert("Incorrect username or password", xhr.responseJSON);
            }
        })
    }

    //
    // function getMain(){
    //         $.ajax({
    //             type: 'GET',
    //             url: '/main',
    //             dataType: 'json',
    //             beforeSend: function (xhr) {
    //                 xhr.setRequestHeader('Content-Type', 'application/json')
    //             },
    //             success: function (res) {
    //                 console.log(res);
    //
    //                 $('#hospitalss').html(searchResults(res)).then(
    //                     window.location = '/main-render'
    //                 );
    //
    //
    //
    //             },
    //             error: function (response) {
    //                 console.log(response);
    //             }
    //         })
    // }

});