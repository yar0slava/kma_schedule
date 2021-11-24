$(document).ready(function () {

    $('#addButton').click(function (event){
        event.preventDefault();
        console.log("here")
      console.log($("#isLecture")[0].checked)
        let lectFIO = $("#list-lect").val().split(' ');
        console.log(lectFIO)
        let group = {
            specialization: $("#specialization").val(),
            degree: $("#degree").val(),
            isLecture: $("#isLecture")[0].checked,
            course: $("#course").val(),
            groupNumber: $("#groupNumber").val(),
            lecturer: {
                surname: lectFIO[0],
                name: lectFIO[1],
                middlename: lectFIO[2]
            }

        }
        console.log(group);

        $.ajax({
            type: 'POST',
            url: '/group',

            data: JSON.stringify(group),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json')
            },
            success: function (response) {
                console.log(response);
                //showTabl();
                alert("Lector is successfully added!")
                $("#specialization").val("");
                $("#degree").val("");
                $("#course").val("");
                $("#isLecture").val("");
                $("#groupNumber").val("");
                $("#list-lect").val("");
                // window.location='/'
            },
            error: function (response) {
                alert(response.responseText);
                $("#specialization").val("");
                $("#degree").val("");
                $("#course").val("");
                $("#isLecture").val("");
                $("#groupNumber").val("");
                $("#list-lect").val("");
            }
        })
    });
});