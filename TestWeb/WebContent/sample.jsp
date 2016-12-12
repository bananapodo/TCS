<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		//request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("data");

		out.println("This is server response.");
		out.println(value);
	%>
</body>
</html>