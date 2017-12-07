<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<c:url value="/resources/assets/css/icons.css" var="iconsCSS" />
<c:url value="/resources/assets/css/bootstrap.css" var="bootstrapCSS" />
<c:url value="/resources/assets/css/plugins.css" var="pluginsCSS" />
<c:url value="/resources/assets/css/main.css" var="mainCSS" />

<link href="${iconsCSS}" rel="stylesheet">
<link href="${bootstrapCSS}" rel="stylesheet">
<link href="${pluginsCSS}" rel="stylesheet">
<link href="${mainCSS}" rel="stylesheet">

<c:url value="/resources/assets/js/jquery-1.8.3.min.js" var="jqueryJS" />
<c:url value="/resources/assets/My97DatePicker/WdatePicker.js"
	var="wdatePickerJS" />
<c:url value="/resources/js/Project/ModifyAccount.js"
	var="modifyAccountJS" />

<script src="${jqueryJS}" type="text/javascript"></script>
<script src="${wdatePickerJS}" language="javascript"
	type="text/javascript"></script>
<script src="${modifyAccountJS}" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-FRAME-OPTIONS" content="SAMEORIGIN">
<title>賬戶管理</title>
</head>
<body>
	<div id="header" class="header-fixed">
		<div class="navbar">
				<a class="navbar-brand" href="Login"> 
				<i class="im-windows8 text-logo-element animated bounceIn"></i>
				<span class="text-logo">FOX</span><span class="text-slogan">LINK</span>
				</a>
		</div>
		<!-- Start .header-inner -->
	</div>
	
	<div style="position: absolute; top: 55px; margin-left: 10px">
		<div class="panel-body" style="border: 1px solid #e1e3e6;">
			開始日期-<input id="dpick1" class="Wdate" type="text"
				onClick="WdatePicker()"> 結束日期-<input id="dpick2"
				class="Wdate" type="text" onClick="WdatePicker()"> 車間-<select
				id="lineno">
				<option value="%">All</option>
				<c:forEach var="lineno" items="${lineno.rows }">
					<option value="${lineno.lineno }">
						<c:out value="${lineno.lineno }" />
					</option>
				</c:forEach>
			</select> 加班單狀態-<select id="checkState">
				<option value="All">All</option>
				<option value="'0','9'">未審核</option>
				<option value="1">已審核</option>
			</select> <input name="" class="btn btn-primary" type="button"
				onclick="showRCInforByDate();" value="查詢" />

			<div>
				<div class="panel-body" style="border: 1px solid #e1e3e6;">
					<table id="accountInfoTable" class="table table-striped">
						<thead>
							<tr>
								<th>賬號</th>
								<th>姓名</th>
								<th>關聯助理ID</th>
								<th>部門代碼</th>
								<th>報加班費用代碼</th>
								<th>郵箱</th>
								<th>分機號碼</th>
								<th>查詢賬號權限</th>
								<th>是否有效</th>
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot>
							<tr>
								<th>賬號</th>
								<th>姓名</th>
								<th>關聯助理ID</th>
								<th>部門代碼</th>
								<th>報加班費用代碼</th>
								<th>郵箱</th>
								<th>分機號碼</th>
								<th>查詢賬號權限</th>
								<th>是否有效</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
</body>
</html>