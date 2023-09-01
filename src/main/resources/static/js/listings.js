$(document).ready(function () {
	let i = 0;
	$('.listing').each(function () {
		this.setAttribute('data-bs-target', "#car" + i)
		i++
	})

	i = 0;
	$('.modal').each(function () {
		this.setAttribute('id', "car" + i)
		console.log(i)
		i++
	})
		
	$('.carousel-item').first().addClass('active')
})



