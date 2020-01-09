	$(function(){ 
	　	loadHeader();
	　	loadMenu();
	}); 
	
	function loadHeader(){
		$.get("common/header.html", function(html){
			    $("#header").html(html);
		});
	}
	
	function loadMenu(){
		$.get("common/menu.html", function(html){
			    $("#menu").html(html);
		});
	}