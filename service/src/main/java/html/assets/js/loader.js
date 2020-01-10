
$(function () {
	loadHeader();
	loadMenu();
});

function loadHeader() {
	$.get("/html/common/header.html", function (html) {
		$("#header").html(html);
	});
	$.get("/user/info", function (data) {
		$("#nickName").html(data.datas.email);
	}, 'json');
}

function loadMenu() {
	$.get("/html/common/menu.html", function (html) {
		$("#menu").html(html);
	});
}