$(document).ready(function(){
	init();
	
	function init(callback){
		ShowAllAccountList();
	}
	
	function ShowAllAccountList(){
		$.getJSON('../Account/AllAccount.show',function(data){
			if(data.StatusCode!="500"){
				if(data.length>0){
					
				}
				else{
					alert("NO Data!!");
				}
			}
			else{
				alert(data.ErrorMessage);
			}
		});
	}
	
});