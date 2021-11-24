$(document).ready(function () {

    $('#addButton').click(function (event){
        event.preventDefault();
        console.log("here")
        let lector = {
            name: $("#name").val(),
            surname: $("#surname").val(),
            middlename: $("#middlename").val()
        }
        console.log(lector);

        $.ajax({
            type: 'POST',
            url: '/lectors',

            data: JSON.stringify(lector),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json')
            },
            success: function (response) {
                console.log(response);
                //showTabl();
                alert("Lector is successfully added!")
                $("#name").val("");
                $("#surname").val("");
                $("#middlename").val("");
                // window.location='/'
            },
            error: function (response) {
                alert(response.responseText);
                $("#name").val("");
                $("#surname").val("");
                $("#middlename").val("");
                console.log(response.responseText);
            }
        })
    });
});