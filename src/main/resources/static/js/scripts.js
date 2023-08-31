const carouselItems = document.querySelectorAll('.carousel-item');
let currentIndex = 0;

function showSlide(index) {
	carouselItems.forEach(item => item.classList.remove('fade'));
	carouselItems[index].classList.add('fade');
}

function nextSlide() {
	currentIndex = (currentIndex + 1) % carouselItems.length;
	showSlide(currentIndex);
}

setInterval(nextSlide, 5000); // Change slide every 5 seconds
showSlide(currentIndex); // Show initial slide

$(document).ready(function() {
	$('.question').click(function() {
		$(this).toggleClass('active');
		$(this).next('.answer').slideToggle();
	});
});