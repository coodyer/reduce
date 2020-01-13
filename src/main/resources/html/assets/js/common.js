function form2JsonString(form) {
	var paramArray = form.serializeArray();
	/* 请求参数转json对象 */
	var jsonObj = {};
	$(paramArray).each(function () {
		jsonObj[this.name] = this.value;
	});
	console.log(jsonObj);
	// json对象再转换成json字符串
	return JSON.stringify(jsonObj);
}

function formatTimeStamp(timeStamp) {
	if (timeStamp > 0) {
		var date = new Date();
		date.setTime(timeStamp);
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		m = m < 10 ? ('0' + m) : m;
		var d = date.getDate();
		d = d < 10 ? ('0' + d) : d;
		var h = date.getHours();
		h = h < 10 ? ('0' + h) : h;
		var minute = date.getMinutes();
		var second = date.getSeconds();
		minute = minute < 10 ? ('0' + minute) : minute;
		second = second < 10 ? ('0' + second) : second;
		return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
	}
	return "";
}
function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	return null;
}

function loadBasePath() {
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var basePath = localhostPath + "/";
	return basePath;
};