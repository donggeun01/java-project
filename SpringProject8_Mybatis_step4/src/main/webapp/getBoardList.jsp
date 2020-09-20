<%@page import="java.util.*"%>
<%@page import="com.springbook.biz.board.impl.BoardDAOMybatis2"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//세션에 저장된 글 목록을 꺼낸다.
	List<BoardVO> boardList = (List)request.getAttribute("boardList");

%>

<!DOCTYPE html PUBLIC "-//W3c//DTD HTML 4.01 Transitional//EN"
					  "http://www.w3.org/TR/html4/loose.dtd">
					  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>글 목록</title>
</head>

<body>
<center>
<h1>글 목록</h1>
<h3>"${userName }" 환영합니다...<a href="logout.do">Log-out</a></h3>

<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">

				<select name = "searchCondition">
				<c:forEach items="${conditionMap }" var = "option">
					<option value = "${option.value }">${option.key } </option>
				</c:forEach>
				</select>
				<input name = "searchKeyword" type="text"/>
				<input type = "submit" value = "검색"/>
			</td>	
		</tr>
	</table>
</form>

<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<th bgcolor="orange" width="100">번호</th>
		<th bgcolor="orange" width="200">제목</th>
		<th bgcolor="orange" width="150">작성자</th>
		<th bgcolor="orange" width="150">등록일</th>
		<th bgcolor="orange" width="100">조회수</th>
	</tr>
	
	<% for(BoardVO board : boardList) { %>
		<tr>
			<td><%= board.getSeq() %> </td>
			<td ailgn="left"><a href="getBoard.do?seq=<%= board.getSeq() %>">
			<%=board.getTitle() %></a> </td>
			<td><%= board.getWriter() %> </td>
			<td><%= board.getRegDate() %> </td>
			<td><%= board.getCnt() %> </td>
		</tr>
		<%} %>
</table>
<br>
<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>