/**
 * mvcAction02.jsp
 */
console.log("Success call mvcAction02.js");

$(function() {
	
	$("button").click(function() {
		document.location.href = "locationAction.do?id=" + this.id;
	});	
	
	$("img").click(function(){
		document.location.href = "locationActionImg.do?alt=" + this.alt;
	})
})