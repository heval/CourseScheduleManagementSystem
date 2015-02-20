jQuery(function(){
	var j = jQuery.noConflict(true);
	j(".navbar a:eq(4)").click(function(){
		j(".adminmenu").show(2000);
		return false;
	});
	j(".navbar a:not(:eq(4))").click(function(){
		j(".adminmenu").hide(2000);
	});
});