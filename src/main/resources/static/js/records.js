$(document).ready(function () {
    getRecords();

        function getRecords(){
            $.ajax({
                type: "GET",
                url: "/records/all",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader('Content-Type', 'application/json'),
                        xhr.setRequestHeader('Authorization', localStorage.getItem("token"))
                },
                success: function (json) {
                    console.log(json);
                },
                error: function (response, status, xhr) {
                    alert("smth went wrong", xhr.responseJSON);
                    console.log(xhr.responseJSON);
                }
            });
        }
}
)