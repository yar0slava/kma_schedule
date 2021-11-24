$(document).ready(function () {

    $('#addButton').click(function (event){
        event.preventDefault();
        console.log("here")
        let classroom = {
            name: $("#name").val(),
            capacity: $("#capacity").val()
        }
        console.log(classroom);

        $.ajax({
            type: 'POST',
            url: '/classroom',

            data: JSON.stringify(classroom),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json')
            },
            success: function (response) {
                console.log(response);
                //showTabl();
                alert("Classroom is successfully added!")
                $("#name").val("");
                $("#capacity").val("");
                // window.location='/'
            },
            error: function (response) {
                alert(response.responseText);
                $("#name").val("");
                $("#capacity").val("");
            }
        })
    });
});