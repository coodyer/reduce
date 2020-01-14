
$(function () {
	loadHeader();
	loadMenu();
});

function loadHeader() {
	$.get("/html/common/header.html", function (html) {
		$("#header").html(html);
	});
	$.get("/user/info", function (data) {
		if (data.code == 405) {
			location.href = '/html/login.html';
			return;
		}
		$("#nickName").html(data.datas.email);
	}, 'json');
}

function loadMenu() {
	$.get("/html/common/menu.html", function (html) {
		$("#menu").html(html);
	});
}