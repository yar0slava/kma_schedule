$(document).ready(function () {

    $('#addButton').click(function (event){
        event.preventDefault();
        console.log("here")
        let classtime = {
            classDate: $("#date").val(),
            classTime: $("#time").val(),
            weekNumber: $("#weekNumber").val()
        }
        console.log(classtime);

        $.ajax({
            type: 'POST',
            url: '/classtime',

            data: JSON.stringify(classtime),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json')
            },
            success: function (response) {
                console.log(response);
                //showTabl();
                alert("Classtime is successfully added!")
                $("#date").val("");
                $("#time").val("");
                $("#weekNumber").val("");
                // window.location='/'
            },
            error: function (response) {
                alert(response.responseText);
                $("#date").val("");
                $("#time").val("");
                $("#weekNumber").val("");
            }
        })
    });
});