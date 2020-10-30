function check(form) {
	var sl=parseInt(form.quantity.value);
	if(sl<=0){
		window.alert("购买数量不能小于等于0！");
		form.quantity.focus();
		return false;
	}
}