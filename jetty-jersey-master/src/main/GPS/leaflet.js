$(function (){

		var mymap = L.map('mapleflet1').setView([51.505, -0.09], 13);
		L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    	attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    	maxZoom: 18,
    	id: 'mapbox/streets-v11',
    	tileSize: 512,
    	zoomOffset: -1,
    	accessToken: 'pk.eyJ1IjoibGVkb2RvaW5jb25udSIsImEiOiJjazg3OXNkZWUwZDdiM2VwcmQxbjI0cWczIn0.gsqi-Jp2FZ066BoQ_0IEJQ'
		}).addTo(mymap);

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
        }).addTo(mymap);

		
		
});

