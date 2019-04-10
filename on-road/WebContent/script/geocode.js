function showPosition() {
           // alert("calling showPosition()");
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (position) {
                    document.getElementById("lat").value = position.coords.latitude;
                    document.getElementById("lng").value = position.coords.longitude;

                });
            } else {
                alert("Sorry, your browser does not support HTML5 geolocation.");
            }

        }