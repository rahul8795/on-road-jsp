<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>On Road Assistant</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBUa3xdIF3GK8NJzUtHCFmIP-CzO4kvt7Y&libraries=geometry&callback=initMap"
    async defer></script>
   <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 425px;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
</head>

<body>
<div id="map"></div>
    <input type="hidden" value="${accept.mechanicLatitude }" id="lat1">
    <input type="hidden" value="${accept.customerlatitude }" id="lat2">
    <input type="hidden" value="${accept.mechanicLongitude }" id="lng1">
    <input type="hidden" value="${accept.customerLongiude }" id="lng2">
    <script>
      // This example requires the Geometry library. Include the libraries=geometry
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=geometry">

      var  lat1 = document.getElementById('lat1').value;
      var  lat2 = document.getElementById('lat2').value;
      var  lng1 = document.getElementById('lng1').value;
      var  lng2 = document.getElementById('lng2').value;
      document.getElementById("origin").value = lat1;
      var marker1, marker2;
      var poly, geodesicPoly;

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: {lat: 34, lng: -40.605}
        });

        map.controls[google.maps.ControlPosition.TOP_CENTER].push(
            document.getElementById('info'));

        var image = {
        	    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        	    size: new google.maps.Size(20, 32),
        	    origin: new google.maps.Point(0, 0),
        	    anchor: new google.maps.Point(0, 32)
        	  };
        marker1 = new google.maps.Marker({
          map: map,
          draggable: true,
          icon: image,
          position: new google.maps.LatLng(lat1, lng1)
        });

        marker2 = new google.maps.Marker({
          map: map,
          draggable: true,
          position: new google.maps.LatLng(lat2, lng2)
        });

        var bounds = new google.maps.LatLngBounds(
            marker1.getPosition(), marker2.getPosition());
        map.fitBounds(bounds);

        google.maps.event.addListener(marker1, 'position_changed', update);
        google.maps.event.addListener(marker2, 'position_changed', update);

        poly = new google.maps.Polyline({
          strokeColor: '#FF0000',
          strokeOpacity: 1.0,
          strokeWeight: 3,
          map: map,
        });

        geodesicPoly = new google.maps.Polyline({
          strokeColor: '#CC0099',
          strokeOpacity: 1.0,
          strokeWeight: 3,
          geodesic: true,
          map: map
        });

        update();
      }

      function update() {
        var path = [marker1.getPosition(), marker2.getPosition()];
        poly.setPath(path);
        geodesicPoly.setPath(path);
        
      }
      </script>
<div class="container">
    <a href="mechanic.jsp" class="nav-link" >Complete Service</a>
</div>
</body>

</html>