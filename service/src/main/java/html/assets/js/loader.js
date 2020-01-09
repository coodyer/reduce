	var config = (function($) {
		$.server = "http://localhost"
		return $;
	})(window.config || {})

	$(function(){ 
	　	loadHeader();
	　	loadMenu();
	}); 
	
	function loadHeader(){
		$.get(config.server+"/html/common/header.html", function(html){
			    $("#header").html(html);
		});
	}
	
	function loadMenu(){
		$.get(config.server+"/html/common/menu.html", function(html){
			    $("#menu").html(html);
		});
	}