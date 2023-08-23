// map.js
	// Initialize the map
	let coordinates = [-121.866126, 42.577636];

	//-------------------------Initial Calls---------------------------//
	updateMap();
// console.log(cars)

	//-------------------------Creates and updates map---------------------------//
	function updateMap() {
		mapboxgl.accessToken = mapBoxKey;
		let map = new mapboxgl.Map({
			container: 'map',
			style: 'mapbox://styles/mapbox/streets-v9',
			zoom: 10,
			center: coordinates
		})
		$(document).ready(function () {
			$('.location').each(function (){
				console.log($(this))
				geocode($(this).html(), mapBoxKey).then(function (result) {
					coordinates = result;
					updateMarker(map)
				})
			})
		})
	}

	//-------------------------Creates and updates marker---------------------------//
	function updateMarker(map) {
		new mapboxgl.Marker({
			draggable: false
		})
			.setLngLat(coordinates)
			.addTo(map);
	}

$(`#submit`).on(`click`, function () {
	geocode($(`#searchCity`).val(), mapBoxKey).then(function (result) {
		coordinates = result;
		updateMap();
	})
})



function geocode(search, token) {
	let baseUrl = 'https://api.mapbox.com';
	let endPoint = '/geocoding/v5/mapbox.places/';

	return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
		.then(function (res) {
			return res.json();
			// to get all the data from the request, comment out the following three lines...
		}).then(function (data) {
			return data.features[0].center;
		});
}

	// var map = L.map('map').setView([51.505, -0.09], 13);
	//
	// // Add a tile layer to the map
	// L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	// 	attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
	// }).addTo(map);
	//
	// // Define marker coordinates and icons
	// var markers = [
	// 	{ lat: 51.505, lng: -0.09, title: 'Marker 1' },
	// 	{ lat: 51.51, lng: -0.1, title: 'Marker 2' },
	// 	// Add more markers as needed
	// ];
	//
	// // Add markers to the map
	// markers.forEach(function(marker) {
	// 	L.marker([marker.lat, marker.lng]).addTo(map)
	// 		.bindPopup(marker.title)
	// 		.openPopup();
	// });