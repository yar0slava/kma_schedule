$(document).ready(function () {
    $('#logout').onclick(logout);

    function logout(){
            $.ajax({
                type: "GET",
                url: "/records/all",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader('Content-Type', 'application/json')
                },
                success: function (json) {
                    console.log(json);
                },
                error: function (response, status, xhr) {
                    alert("You don't have access to this data!");
                }
            });
        }
}
)