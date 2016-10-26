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

<BODY background="../background" >


<H1 align="center"> Table name is : <%= request.getParameter("inputTableName") %>
</H1>

<% String inputTableName = request.getParameter("inputTableName");%>

<%
    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/belarus", "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from " + inputTableName);

%>

<style type="text/css" scoped>
    .gridtable {
        background: #f5ffff;
        border-collapse: collapse;
        text-align: left;
    }

    .gridtable th {
        border-top: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset 0 1px 0 #999999, inset 0 -1px 0 #999999;
        background: linear-gradient(#9595b6, #5a567f);
        color: white;
        padding: 10px 15px;
        position: relative;
    }

    .gridtable th:after {
        content: "";
        display: block;
        position: absolute;
        left: 0;
        top: 25%;
        height: 25%;
        width: 100%;
        background: linear-gradient(rgba(255, 255, 255, 0), rgba(255, 255, 255, .08));
    }

    .gridtable tr:nth-child(odd) {
        background: #ebf3f9;
    }

    .gridtable th:first-child {
        border-left: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset 1px 1px 0 #999999, inset 0 -1px 0 #999999;
    }

    .gridtable th:last-child {
        border-right: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset -1px 1px 0 #999999, inset 0 -1px 0 #999999;
    }

    .gridtable td {
        border: 1px solid #e3eef7;
        padding: 10px 15px;
        position: relative;
        transition: all 0.5s ease;
    }

    .gridtable tbody:hover td {
        color: transparent;
        text-shadow: 0 0 3px #a09f9d;
    }

    .gridtable tbody:hover tr:hover td {
        color: #444444;
        text-shadow: none;
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
    <% while (resultset.next()) { %>
    <TR>
        <TD><%= resultset.getRow() %>
        </TD>
        <TD><%= resultset.getString(1) %>
        </TD>
        <TD><%= resultset.getString(2) %>
        </TD>
        <TD><%= resultset.getString(3) %>
        </TD>
        <TD>
            <form name="form"
                  action="http://localhost:8080/NetCracker_SecondMission_war_exploded/servlets/updateServlet/"
                  method="post">
                <input type="submit" value="<%= resultset.getString(1) %>" name="changeButton">
            </form>
        </TD>
        <TD>
            <form name="form"
                  action="http://localhost:8080/NetCracker_SecondMission_war_exploded/servlets/deleteServlet/"
                  method="post">
                <input type="submit" value="<%= resultset.getString(1) %>" name="deleteButton">
            </form>
        </TD>
    </TR>
    <% } %>
</TABLE>

<%
        resultset.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
%>


</BODY>
</HTML>
