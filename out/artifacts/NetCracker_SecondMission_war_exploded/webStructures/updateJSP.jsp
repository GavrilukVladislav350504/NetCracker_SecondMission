<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 20.10.2016
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<title>CREATE/UPDATE</title>
<HTML>
<BODY BACKGROUND="../background">
<h1>
    <form align="center"
          action="http://localhost:8080/NetCracker_SecondMission_war_exploded/servlets/writeInTableServlet/"
          method="post">
        Input ID
        <br>
        <input type="text" align="center" name="inputID" value="<%=session.getAttribute("submitName")%>">
        <br>
        Input town name
        <br>
        <input type="text" align="center" name="inputTownName" value="<%=session.getAttribute("name")%>">
        <br>
        Input URL part
        <br>
        <input type="text" align="center" name="inputURL" value="<%=session.getAttribute("url")%>">
        <br>
        <input type="submit" value="SAVE">
    </form>

</h1>

</BODY>
</HTML>
