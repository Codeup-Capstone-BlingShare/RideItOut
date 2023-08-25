$('.carousel').carousel();

function showAnswer() {
	var dropdown = document.getElementById("questionDropdown");
	var selectedValue = dropdown.value;
	var answerContainer = document.getElementById("answerContainer");
	
	// Hide all answers
	var answers = answerContainer.getElementsByClassName("answer");
	for (var i = 0; i < answers.length; i++) {
		answers[i].classList.add("hidden");
	}
	
	// Show selected answer
	if (selectedValue) {
		document.getElementById(selectedValue).classList.remove("hidden");
	}
}