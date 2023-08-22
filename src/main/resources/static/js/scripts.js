// Toggle FAQ answers when clicking on questions
document.addEventListener('DOMContentLoaded', function() {
	const faqItems = document.querySelectorAll('.faq-item');
	
	faqItems.forEach(function(item) {
		item.addEventListener('click', function() {
			this.classList.toggle('open');
		});
	});
});