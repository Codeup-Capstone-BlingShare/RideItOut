// map.js

document.addEventListener('DOMContentLoaded', function() {
	// Initialize the map
	var map = L.map('map').setView([51.505, -0.09], 13);
	
	// Add a tile layer to the map
	L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
		attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
	}).addTo(map);
	
	// Define marker coordinates and icons
	var markers = [
		{ lat: 51.505, lng: -0.09, title: 'Marker 1' },
		{ lat: 51.51, lng: -0.1, title: 'Marker 2' },
		// Add more markers as needed
	];
	
	// Add markers to the map
	markers.forEach(function(marker) {
		L.marker([marker.lat, marker.lng]).addTo(map)
			.bindPopup(marker.title)
			.openPopup();
	});
});