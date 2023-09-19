$(document).ready(function () {
	let i = 0;
	$('.listing').each(function () {
		this.setAttribute('data-bs-target', "#car" + i)
		i++
	})

	i = 0;
	$('.modal').each(function () {
		this.setAttribute('id', "car" + i)
		i++
	})

	$('#photoLoop .photo-item:first-child').addClass('active')

	const [today] = new Date().toISOString().split('T');
	const setMin = document.getElementById('startDate');
		setMin.setAttribute('min', today);

	$('#startDate').on('change', function () {
		let minEnd = $('#startDate').val();
		minEnd = new Date(minEnd);
		minEnd.setDate(minEnd.getDate() + 1);
		let [minEndFormatted] = minEnd.toISOString().split('T');
		const setMinEnd = document.getElementById('endDate');
		setMinEnd.setAttribute('min', minEndFormatted);
	})
})



