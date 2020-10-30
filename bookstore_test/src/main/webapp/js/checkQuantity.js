function check(form) {
	var sl=parseInt(form.quantity.value);
	if(sl<=0){
		window.alert("最少数量为1！");
		form.quantity.focus();
		return false;
	}
}