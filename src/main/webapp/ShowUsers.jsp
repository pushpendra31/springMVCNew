<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    <link rel="stylesheet" type="text/css" href="resources/css_js/Showdetails.css"/>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">

<title>All Users Details</title>
</head>
<body class="body1">
 <div class="box" align="center">
<form action="showuserDtls" method="post">   
  <label for="html">Name</label>
<input type="text" id="Fname"  placeholder=" Name" name="Fname">  
  <label for="html">Mobile No.</label>
<input type="text" id="Contact"  placeholder=" Mobile No." name="Contact">  <br>

<!-- <!--    <label width=180px for="birthday">From Date:</label>
  <input type="date" id="date" name="date">
  <label for="birthday">    To Date:</label>
  <input type="date" id="todate" name="todate"> -->



<button type="submit">Search</button>  

</form> 
    </div>   
    <div class="theader" align="center">
        <table cellpadding="0">
            <caption><h2>Registered  users</h2></caption>
            <tr class="tabHead">
                <th>ID</th>
                <th>First Name</th>
                    <th>Last Name</th>
 <th>Address</th>
 <th>City</th>
  <th>Email</th>
 <th>Gender</th>
 <th>Contact</th>
    <th>Action</th>
            </tr>

    
<c:forEach var="item" items="${showuser}" >
       <c:if test="${item ne null}" >

            <TR  class="tabRow">
            
                <TD> ${item.getPersonid()}</TD>
                <TD> ${item.getFname()}</TD>
              <TD> ${item.getLastName()}</td>
                <TD> ${item.getAddress()}</TD>
                <TD> ${item.getCity()}</TD>
                 <TD>${item.getEmail()}</TD>
                <TD>${item.getGender()}</TD>
                <TD>${item.getContact()}</TD>
                <TD><button onclick="editData(this)">Edit</button>edit </TD>
                
              
            </TR>
            </c:if>
            </c:forEach>
           
        </table>
    </div>
  

</body>
</html>