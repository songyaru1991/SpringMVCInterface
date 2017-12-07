<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=utf-8");
%>
<html>
<head>
<title>往数据库插入数据</title>
</head>
<body>
	<%
		String userName = request.getParameter("username"); //从表单获得
		String userPwd = request.getParameter("password"); //从表单获得 
		out.println(userName);
		try {
			/** 连接数据库参数 **/
			String driverName = "com.mysql.jdbc.Driver"; //驱动名称 
			String DBUser = "root"; 
			String DBPasswd = "foxlink"; 
			String DBName = "swipecard"; 

			String connUrl = "jdbc:mysql://localhost/" + DBName + "?user="
					+ DBUser + "&password=" + DBPasswd;
			Class.forName(driverName).newInstance();
			Connection conn = DriverManager.getConnection(connUrl);
			Statement stmt = conn.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String query_sql = "select * from user_data where userid = '"+ userName+"' and password = '"+userPwd+"'";
			out.println(query_sql);
			try {
				ResultSet rs = stmt.executeQuery(query_sql);
				if(rs.next()) {
					String permission = rs.getString("swipe_system_chief");
					out.println("id: " + rs.getString("id"));
					session.setAttribute("userName", userName);
					session.setAttribute("permissionLv", permission);
					//request.getSession().setAttribute("UserName", username);
					response.sendRedirect("index.jsp");
				}else{
					out.println("登錄失敗!");
					response.sendRedirect("Login.html");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//rs.close(); 
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>