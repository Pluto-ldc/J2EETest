function check(form) {
	var sl=parseInt(form.quantity.value);
	if(sl<=0){
		window.alert("������������С�ڵ���0��");
		form.quantity.focus();
		return false;
	}
}