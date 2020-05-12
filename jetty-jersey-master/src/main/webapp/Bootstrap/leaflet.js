function getServerData(url, success) {
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}


function putServerData(url, data, success){
    console.log(data);
    $.ajax({
      url: url,
      type: "put",
      contentType: "application/json",
      dataType: "json",
      data: data,
    }).done(success);
}

function deleteServerData(url, data, success){
    console.log(data);
    $.ajax({
        type: 'DELETE',
        data: data,
        url:url
    }).done(success);
}

function postServerData(url, data, success){
  console.log(data);
  $.ajax({
    type: 'POST',
    data: data,
    url:url
  }).done(success);
}

var pos;
function createMarker(){
    console.log("function createMarker() called");
    console.log(document.getElementById("markername").value);
    var a={'markeradd':document.getElementById('markername').value,'lat':pos.lat, 'lon':pos.lng};
    
    postServerData("../ws/marker/create",a ,function(result){
        console.log(result);
        if(!result){
          alert("failed");
      }
     
	});
}
function getMarker(){
  console.log("function getMarker called");
  getServerData("/ws/marker/getmarker",function(result){
    console.log(result);
})
}

$(function (){

  var mymap = L.map('mapleflet1').setView([48.8278364, 2.3806668], 15);
  document.getElementById("main").style.marginLeft = "260px";

  L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 20,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoibGVkb2RvaW5jb25udSIsImEiOiJjazg3OXNkZWUwZDdiM2VwcmQxbjI0cWczIn0.gsqi-Jp2FZ066BoQ_0IEJQ'
  }).addTo(mymap);

/*
  L.Routing.control({

		// Nous personnalisons le tracé
		lineOptions: {
			styles: [{color: '#e43e32', opacity: 1, weight: 7}]
		},			
		// Nous personnalisons la langue et le moyen de transport
		router: new L.Routing.osrmv1({
			language: 'fr',
			profile: 'car', 
		}),
    geocoder: L.Control.Geocoder.nominatim()
    }).addTo(mymap);
*/


mymap.on('click', getMarker);
var route = L.Routing.control({});
$('#itinerary').on('click', function() {
  if($('.leaflet-routing-container').is(':visible')){
    mymap.removeControl(route);
  }
  else{
    route = L.Routing.control({
      /*waypoints: [
          L.latLng(48.8278364, 2.3806668),
          L.latLng(48.8278364, 2.6006670)
      ],*/
      routeWhileDragging: true,
      /*itineraryShown: true,
      autoRoute: true,
      show: true,*/
      geocoder: L.Control.Geocoder.nominatim()
    }).addTo(mymap);
  }
});
/*
$('#itinerary').on('dblclick', function() {
  route.removeFrom(mymap)
});
*/

  /*var it = document.getElementById("itinerary");
  $('#itinerary').on('click', function() {
    $('.leaflet-routing-container').is(':visible') ? mymap.removeLayer(route) : route.addTo(mymap);
  }); */
  
  

var active = false;
document.getElementById('markID').addEventListener('click',function () {
  function onClick(e) { 
    
    var marker = L.marker(e.latlng, { draggable: true }).addTo(mymap);
    pos=e.latlng;
    marker.bindPopup('<div class="input-group input-group-sm"><label for="recipient-name" class="col-form-label">Marker name:</label><input type="text" placeholder="Name" class="form-control" id="recipient-name"></div>  <br> <a href="#" data-toggle="modal" data-target="#addName" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add name and create marker</span></a> <br><br><a href="#" data-toggle="modal" data-target="#addMessage" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add message</span></a><br><br><a href="#" data-toggle="modal" data-target="#addImage" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add Image</span></a> <br><br><a href="#" data-toggle="modal" data-target="#markMenu" data-whatever="@mdo"> <i class="far fa-circle"></i><span>See Marker</span></a>').openPopup(); 
    marker.on('dblclick', function(e) {
    console.log(e);
    mymap.removeLayer(marker);
  })
}
if(active){
  mymap.removeEventListener('click',false);
  active=false;
}
  else{
    mymap.on('click', onClick);
    active=true;
  }
});

      mymap.locate({
        setView: true,
        maxZoom: 16
      })
      mymap.on('locationfound', function(e) {
        var radius = e.accuracy / 2;
        L.marker(e.latlng).addTo(mymap).bindPopup("Here you are").openPopup();
        L.circle(e.latlng, radius).addTo(mymap);
      });
      
      mymap.on('locationerror', function(e) {
        console.log('Erreur de localisation =====>', e);
      });


    var evtIcon = L.icon({
      iconUrl: '../Bootstrap/img/event.png',
    
      iconSize:     [40, 40], // size of the icon
      shadowSize:   [50, 64], // size of the shadow
      iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
    var active = false;
    document.getElementById('event').addEventListener('click',function () {
      function onClick(e) { 
        var evt = L.marker(e.latlng, { draggable: true, icon: evtIcon }).addTo(mymap);
        evt.bindPopup('<div class="input-group input-group-sm"><label for="recipient-name" class="col-form-label">Marker name:</label><input type="text" placeholder="Name" class="form-control" id="recipient-name"></div>  <br><a href="#" data-toggle="modal" data-target="#addMessage" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add message</span></a><br><br><a href="#" data-toggle="modal" data-target="#addImage" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add Image</span></a> <br><br><a href="#" data-toggle="modal" data-target="#eventMenu" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Duration</span></a> <br><br><a href="#" data-toggle="modal" data-target="#markMenu" data-whatever="@mdo"> <i class="far fa-circle"></i><span>See Marker</span></a>').openPopup(); 
        evt.on('dblclick', function(e) {
          console.log(e);
          mymap.removeLayer(evt);
        })
      }
      if(active){
        mymap.removeEventListener('click',false);
        active=false;
      }
        else{
          mymap.on('click', onClick);
          active=true;
        }
      });
      
          mymap.locate({
            setView: true,
            maxZoom: 16
          })
          mymap.on('locationfound', function(e) {
            var radius = e.accuracy / 2;
            L.marker(e.latlng).addTo(mymap).bindPopup("Here you are").openPopup();
            L.circle(e.latlng, radius).addTo(mymap);
          });
          
          mymap.on('locationerror', function(e) {
            console.log('Erreur de localisation =====>', e);
          });
});



jQuery(function ($) {

  $(".sidebar-dropdown > a").click(function() {
$(".sidebar-submenu").slideUp(200);
if (
  $(this)
    .parent()
    .hasClass("active")
) {
  $(".sidebar-dropdown").removeClass("active");
  $(this)
    .parent()
    .removeClass("active");
} else {
  $(".sidebar-dropdown").removeClass("active");
  $(this)
    .next(".sidebar-submenu")
    .slideDown(200);
  $(this)
    .parent()
    .addClass("active");
}
});

$("#close-sidebar").click(function() {
$(".page-wrapper").removeClass("toggled");
document.getElementById("main").style.marginLeft = "35px";
});
$("#show-sidebar").click(function() {
$(".page-wrapper").addClass("toggled");
document.getElementById("main").style.marginLeft = "260px";
});
});


// Material Select Initialization
/*
$(document).ready(function() {
$('.mdb-select').materialSelect();
});
*/
$('#shareMap').on('show.bs.modal', function (event) {
var button = $(event.relatedTarget) // Button that triggered the modal
var recipient = button.data('whatever') // Extract info from data-* attributes
// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
var modal = $(this)
modal.find('.modal-title').text('New message to ' + recipient)
modal.find('.modal-body input').val(recipient)
})

$('#newMap').on('show.bs.modal', function (event) {
var button = $(event.relatedTarget) // Button that triggered the modal
var recipient = button.data('whatever') // Extract info from data-* attributes
// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
var modal = $(this)
modal.find('.modal-title').text('New message to ' + recipient)
modal.find('.modal-body input').val(recipient)
})

$('#editMap').on('show.bs.modal', function (event) {
var button = $(event.relatedTarget) // Button that triggered the modal
var recipient = button.data('whatever') // Extract info from data-* attributes
// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
var modal = $(this)
modal.find('.modal-title').text('New message to ' + recipient)
modal.find('.modal-body input').val(recipient)
})

$('#settings').on('show.bs.modal', function (event) {
var button = $(event.relatedTarget) // Button that triggered the modal
var recipient = button.data('whatever') // Extract info from data-* attributes
// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
var modal = $(this)
modal.find('.modal-title').text('New message to ' + recipient)
modal.find('.modal-body input').val(recipient)
})