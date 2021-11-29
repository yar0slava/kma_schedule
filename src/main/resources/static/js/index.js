function goToRecords() {
        $.ajax({
            type: 'GET',
            url: '/records',
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json'),
                    xhr.setRequestHeader('Authorization', localStorage.getItem("token"))
            },
            success: function (response, status, xhr) {
            },
            error: function (response, status, xhr) {
                alert("smth went wrong");
            }
        })
    }