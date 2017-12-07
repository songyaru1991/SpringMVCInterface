/**
 * 常用的javascript function
 */


function ShowTableHeader(reportType){
	var Title='';
	switch(reportType){
		case 'Account':
			Title = '<tr><th>賬號</th>'+
			'<th>姓名</th>'+
			'<th>關聯助理ID</th>'+
			'<th>部門代碼</th>'+
			'<th>報加班費用代碼</th>'+
			'<th>郵箱</th>'+
			'<th>分機號碼</th>'+
			'<th>查詢賬號權限</th>'+
			'<th>是否有效</th></tr>';
			break;
		case '':
			Title='<tr></tr>';
		break;
		case '':
			Title='<tr></tr>';
			break;
		case '':
			Title='<tr></tr>';
			break;
		default:
			break;
	
	}
	return Title;
}

function ShowTableContents(rawData,reportType){
	var tableContents='';
	if(reportType==''){
		tableContents+='<tr><td>'+rawData.SN+'</td>'+
			'<td>'+rawData.FACTORY+'</td>'+
			'<td>'+rawData.WORKSHOP+'</td>'+
			'<td>'+rawData.LINENO+'</td>'+
			'<td>'+rawData.MODELNO+'</td></tr>';
	}
	else{
		for(var i=0;i<rawData.length;i++){
			 if(reportType=='RobotState'){
				 if(rawData[i]["ERRORCODE"]=='正常運行'){
					tableContents+='<tr class="success"><td>'+rawData[i]["TIME"]+'</td>'+
					'<td>'+rawData[i]["STATUSCODE"]+'</td>'+
					'<td>'+rawData[i]["ERRORCODE"]+'</td></tr>';
				 }
				 else{
						tableContents+='<tr class="danger"><td>'+rawData[i]["TIME"]+'</td>'+
						'<td>'+rawData[i]["STATUSCODE"]+'</td>'+
						'<td>'+rawData[i]["ERRORCODE"]+'</td></tr>';
				 }

			}
			else{
				tableContents+='<tr><td>'+rawData[i]["TIME"]+'</td>'+
					'<td>'+rawData[i]["MAX"]+'</td>'+
					'<td>'+rawData[i]["AVG"]+'</td>'+
					'<td>'+rawData[i]["MIN"]+'</td>'+
				'</tr>';
			}
		}
	}
	return tableContents;
}


