jQuery(function(){
	var j = jQuery.noConflict(true);
	j(".menu a:eq(4)").click(function(){
		j(".adminmenu").show(2000);
		return false;
	},
	function(){
		j(".adminmenu").hide(2000);
	});
});