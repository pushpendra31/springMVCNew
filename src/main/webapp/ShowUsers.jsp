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

<form action="showuserDtls" method="post">   
  <label for="html">Name</label>
<input type="text" id="Fname"  placeholder=" Name...." name="Fname">   
<button type="submit">Submit</button>   
</form> 
     
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
   <th>Mobile</th>

 <th>Gender</th>
             
                <th>Contact</th>
            </tr>

    
<c:forEach var="item" items="${list}" >
       <c:if test="${list ne null}" >

            <TR  class="tabRow">
            
                <TD> ${item.getPersonid()}</TD>
          <%--       <TD> ${item}</TD>
              <TD> ${item.get}</td>
                <TD> ${item}</TD>
                <TD> ${item}</TD>
                 <TD>${item}</TD>
                <TD> ${item}</TD>
                <TD> ${item}</TD>
                <TD> ${item}</TD> --%>
            </TR>
            </c:if>
            </c:forEach>
           
        </table>
    </div>

</body>
</html>