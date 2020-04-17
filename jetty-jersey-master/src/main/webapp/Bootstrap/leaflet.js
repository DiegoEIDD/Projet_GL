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
      geocoder: L.Control.Geocoder.nominatim()
    }).addTo(mymap);
    */
   L.Routing.control({
    // Nous personnalisons le tracé
    lineOptions: {
        styles: [{color: '#e43e32', opacity: 1, weight: 7}]
    },
  
    // Nous personnalisons la langue et le moyen de transport
    router: new L.Routing.osrmv1({
        language: 'fr',
        profile: 'car', // car, bike, foot
    }),
  
    geocoder: L.Control.Geocoder.nominatim()
  }).addTo(mymap)

		/*var marker = L.marker([48.8278364, 2.3806668]).addTo(mymap);
		marker.bindPopup("<b>EIDD</b><br>Paris Diderot").openPopup();*/
});
/*
L.Routing.control({
  // Nous personnalisons le tracé
  lineOptions: {
      styles: [{color: '#ff8f00', opacity: 1, weight: 7}]
  },

  // Nous personnalisons la langue et le moyen de transport
  router: new L.Routing.osrmv1({
      language: 'fr',
      profile: 'car', // car, bike, foot
  }),

  geocoder: L.Control.Geocoder.nominatim()
}).addTo(mymap)
*/

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