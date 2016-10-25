<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 20.10.2016
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>VIEW</title>
<HTML>
<HEAD>
    <TITLE>VIEW TABLE </TITLE>
</HEAD>

<BODY background="../background">


<H1 align="center"> Table name is : <%= request.getParameter("inputTableName") %> </H1>

<% String inputTableName = request.getParameter("inputTableName");%>

<%
    try{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/belarus", "root", "root");

        Statement statement = connection.createStatement() ;
        ResultSet resultset = statement.executeQuery("select * from "+inputTableName) ;
%>

<style type="text/css" scoped>
    table.gridtable {
        font-family: mo, Monotype Corsiva, sans-serif;
        font-size:20px;
        color:#333333;
        border: 1px #666666;
        border-collapse: collapse;
    }
    table.gridtable th {
        padding: 8px;
        border: 1px solid #666666;
        background-color: mediumturquoise;
    }
    table.gridtable td {
        padding: 8px;
        border: 1px solid #666666;
        background-color: paleturquoise;
    }
</style>

<h2 align="center">
    <form action="http://localhost:8080/NetCracker_SecondMission_war_exploded/servlets/createServlet/" method="post">
        <input type="submit" value="ADD NEW ROW IN TABLE">
    </form>
</h2>

<TABLE class="gridtable" align="center">
    <TR>
        <TH>№</TH>
        <TH>id</TH>
        <TH>town_name</TH>
        <TH>url_name</TH>
        <TH>change</TH>
        <TH>delete</TH>
    </TR>
    <% while(resultset.next()){ %>
    <TR>
        <TD> <%= resultset.getRow() %></TD>
        <TD> <%= resultset.getString(1) %></TD>
        <TD> <%= resultset.getString(2) %></TD>
        <TD> <%= resultset.getString(3) %></TD>
        <TD>
            <form name="form" action="http://localhost:8080/NetCracker_SecondMission_war_exploded/servlets/updateServlet/" method="post">
                <input type="submit" value="<%= resultset.getString(1) %>" name="changeButton">
            </form>
        </TD>
        <TD>
            <form name="form" action="http://localhost:8080/NetCracker_SecondMission_war_exploded/servlets/deleteServlet/" method="post">
                <input type="submit" value="<%= resultset.getString(1) %>" name="deleteButton">
            </form>
        </TD>
    </TR>
    <% } %>
</TABLE>

<% }
catch (SQLException e) {
    e.printStackTrace();
}
catch (ClassNotFoundException e) {
    e.printStackTrace();
}%>


</BODY>
</HTML>
