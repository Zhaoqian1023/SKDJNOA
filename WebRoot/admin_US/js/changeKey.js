var inputs = document.getElementById("mm").getElementsByTagName("input");
function keyDown(event) {
	var focus = document.activeElement;
	if (!document.getElementById("mm").contains(focus))
		return;
	var event = window.event || event;
	var key = event.keyCode;
	for (var i = 0; i < inputs.length; i++) {
		if (inputs[i] === focus){
			inputs[i].style="background-color:#DCE2E8;text-align:center";
			break;
		}
	}
	switch (key) {
	case 37:
		if (i > 0){
			inputs[i - 1].focus();
			inputs[i - 1].style="background-color:#DCE2E8;text-align:center";
		}
		break;
	case 38:
		if (i - 5 >= 0){
			inputs[i - 5].focus();
			inputs[i - 5].style="background-color:#DCE2E8;text-align:center";
		}
		break;
	case 39:
		if (i < inputs.length - 1){
			inputs[i + 1].focus();
			inputs[i + 1].style="background-color:#DCE2E8;text-align:center";
		}
		break;
	case 40:
		if (i + 5 < inputs.length){
			inputs[i + 5].focus();
			inputs[i + 5].style="background-color:#DCE2E8;text-align:center";
		}
		break;
	}
}