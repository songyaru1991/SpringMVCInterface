	var _menus = {
		"menus" : [ {
			"menuid" : "1",
			"icon" : "icon-sys",
			"menuname" : "加班單管理",
			"menus" : [ {
				"menuname" : "加班單審核",
				"icon" : "icon-nav",
				"url" : "show_overtime_backup.jsp"
			}, {
				"menuname" : "員工加班詳情",
				"icon" : "icon-nav",
				"url" : "EmployeeInfor.jsp"
			}, {
				"menuname" : "刷卡記錄查詢",
				"icon" : "icon-nav",
				"url" : "swipecardtime_bylineno.jsp"
			}, {
				"menuname" : "忘卡人员查询",
				"icon" : "icon-nav",
				"url" : "swipecardtime_bylineno.jsp"
			},{
				"menuname" : "班别信息查询",
				"icon" : "icon-nav",
				"url" : "swipecardtime_bylineno.jsp"
			},{
				"menuname" : "原始刷卡記錄查詢",
				"icon" : "icon-nav",
				"url" : "swipecardtime_bylineno.jsp"
			},{
				"menuname" : "崗位津貼查詢",
				"icon" : "icon-nav",
				"url" : "swipecardtime_bylineno.jsp"
			}]
		}, {
			"menuid" : "56",
			"icon" : "icon-sys",
			"menuname" : "權限管理",
			"menus" : [ {
				"menuname" : "助理信息管理",
				"icon" : "icon-nav",
				"url" : "demo1.html"
			}, {
				"menuname" : "賬號管理",
				"icon" : "icon-nav",
				"url" : "Account/ShowAllAccount"
			} , {
				"menuname" : "修改密碼",
				"icon" : "icon-nav",
				"url" : "demo1.html"
			} ]
		} ]
	};

	$(function() {

		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
				if (r) {
					location.href = 'Login?logout';
				}
			});

		})

	});