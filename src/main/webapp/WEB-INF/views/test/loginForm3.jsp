<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import = "java.util.*"
    isELIgnored="false"
    %>
<%@taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="${contextPath }/test/login3.do">
			
		<table>
			<tr>
				<td>아이디 <input type="text" name="userID" size="10"></td>
			</tr>
			<tr>
				<td>이름 <input type="text" name="userName" size="10"></td>
			</tr>
			<tr>
				<td>이메일 <input type="text" name="userEmail" size="10"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
			</tr>	
		</table>
	</form>

</body>
</html>