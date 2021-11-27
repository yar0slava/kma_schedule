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
            url: '/login',
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
                alert("Incorrect login or password");
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