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

/*
var active = false;
$('#markID').on('click', function() {
  if(active){active=false;}
  else{active=true;}

    if(active){
      mymap.on('click', function(e) {

      var marker = L.marker(e.latlng, { draggable: true }).addTo(mymap);
      marker.bindPopup('<span id="name">Name</span><br><br><button id="btn2">add message</button><br><br><button id="btn3">add picture</button><br>').openPopup();
      
      marker.on('dblclick', function(e) {
        console.log(e);
        mymap.removeLayer(marker);
      
      });
      });
    }  
    else{
      document.getElementById('markID').addEventListener('dblclick',function () {
        mymap.off('click', onClick);
      })
    }
}) 
*/

var active = false;
document.getElementById('markID').addEventListener('click',function () {
  function onClick(e) { 
    var marker = L.marker(e.latlng, { draggable: true }).addTo(mymap);
  marker.bindPopup('<div class="input-group input-group-sm"><label for="recipient-name" class="col-form-label">Marker name:</label><input type="text" placeholder="Name" class="form-control" id="recipient-name"></div>  <br><a href="#" data-toggle="modal" data-target="#addMessage" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add message</span></a><br><br><a href="#" data-toggle="modal" data-target="#addImage" data-whatever="@mdo"> <i class="far fa-circle"></i><span>Add Image</span></a> <br><br><a href="#" data-toggle="modal" data-target="#markMenu" data-whatever="@mdo"> <i class="far fa-circle"></i><span>See Marker</span></a>').openPopup(); 
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
        console.log('定位出错=====>', e);
      });
      
      /*
      mymap.on("popupopen", function(){
        document.getElementById("addname").onclick = function(){
          null;
        }
      });
      mymap.on("popupopen", function(){
        document.getElementById("btn2").onclick = function(){
          null;
        }
      });
      mymap.on("popupopen", function(){
        document.getElementById("btn3").onclick = function(){
          null;
        }
      });   
      */

  /*var marker = L.marker([48.8278364, 2.3806668]).addTo(mymap);
  marker.bindPopup("<b>EIDD</b><br>Paris Diderot").openPopup();*/
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