$(document).ready(function(){
	init();
	
	function init(callback){
		ShowAllAccountList();
	}
	
	function ShowAllAccountList(){
		$.getJSON('../Account/AllAccount.show',function(rawData){
			if(rawData.StatusCode!="500"){
				if(rawData.length>0){
					ShowAllAccountTable(rawData);
				}
				else{
					alert("NO Data!!");
				}
			}
			else{
				alert(rawData.ErrorMessage);
			}
		});
	}
	
	function ShowAllAccountTable(rawData){
		$('#accountInfoTable tbody').empty();
		for(var i=0;i<rawData.length;i++){
			var	tableContents='<tr><td>'+rawData[i]["USERNAME"]+'</td>'+
					'<td>'+rawData[i]["CHINESENAME"]+'</td>'+
					'<td>'+rawData[i]["ASSISTANT_ID"]+'</td>'+
					'<td>'+rawData[i]["DEPARTMENTCODE"]+'</td>'+
					'<td>'+rawData[i]["COSTID"]+'</td>'+
					'<td>'+rawData[i]["EMAIL"]+'</td>'+
					'<td>'+rawData[i]["PHONE_TEL"]+'</td>';
					switch(rawData[i]["ENABLED"]){
					case 0:
						tableContents+='<td>Disable</td>';
						break;
					case 1:
						tableContents+='<td>Enable</td>';
						break;
					default:						
						break;
					}		
					tableContents+='<td><input type="button" value="編輯" class="modifyAccountBtn btn btn-xs btn-link">'+
					'<input type="button" value="刪除" class="delAccountBtn btn btn-xs btn-link"></td></tr>';
					$('#accountInfoTable tbody').append(tableContents);
		}	
	}
	
});