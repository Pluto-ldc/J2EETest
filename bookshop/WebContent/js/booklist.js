function AddorRomove(bookId) {
	var buttonText = document.getElementById("box" + bookId).value;//绑定事件
	if (buttonText == '加入购物车') {
		let data = 'bookId=' + bookId,
			url = '../AddCartServlet',
			xhr = new XMLHttpRequest();
		xhr.open('post', url);
		//设置header
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && (xhr.status === 200 || xhr.status === 304)) {
				console.log(xhr.responseText);
			}
		}
		alert("图书添加购物车成功！")
		document.getElementById("box" + bookId).value = "移除购物车";
	}
	if (buttonText == '移除购物车') {
		let data = 'bookId=' + bookId,
			url = '../RemoveCartServlet',
			xhr = new XMLHttpRequest();
		xhr.open('post', url);
		//设置header
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && (xhr.status === 200 || xhr.status === 304)) {
				console.log(xhr.responseText);
			}
		}
		alert("图书移除购物车成功！")
		document.getElementById("box" + bookId).value = "加入购物车";
	}
}
function deleteBook(bookId, bookName) {
	event.returnValue = confirm("确定要删除‘" + bookName + "’吗？");
	let data = 'bookId=' + bookId,
		url = '../DeleteBookServlet',
		xhr = new XMLHttpRequest();
	xhr.open('post', url);
	//设置header
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
	window.location.href="../FindAllBooksServlet"; 
}