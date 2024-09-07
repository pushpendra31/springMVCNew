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
<script type="text/javascript">
$(document).ready(function() {
	$('[data-toggle=tooltip]').tooltip();
	$('table .edit').on('click' ,function(){
	  let row = button.parentNode.parentNode;
var id =$(this).parent().find('#personid').val();
        // Get the cells within the row
              var personid = row.cells[0];
        alert(id);
	})
});

</script> 
</head>
<body class="body1">
 <div class="box" align="center">
<form action="showuserDtls" method="post">   
  <label for="html">Name</label>
<input type="text" id="Fname"  placeholder=" Name" name="Fname">  
  <label for="html">Mobile No.</label>
<input type="text" id="Contact"  placeholder=" Mobile No." name="Contact">  <br>
   <label for="birthday">From Date:</label>
  <input type="date" id="date" name="date">
  <label for="birthday">To Date:</label>
  <input type="date" id="todate" name="todate">


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

            <TR  class="tabRow" valign="center">
            
                <TD align="center"> ${item.getPersonid()}</TD>
                <TD align="center"> ${item.getFname()}</TD>
              <TD align="center"> ${item.getLastName()}</td>
                <TD> ${item.getAddress()}</TD>
                <TD> ${item.getCity()}</TD>
                 <TD>${item.getEmail()}</TD>
                <TD align="center">${item.getGender()}</TD>
                <TD align="center">${item.getContact()}</TD>
                              <TD align="center"><a href="#editdata" class="edit" data-toggle="modal">Edit <i class="material-icon" data-toggle="tooltip"></i></a>
<!--  <button onclick="editData(this)"  class="btn btn-link btn-rounded btn-sm fw-bold" align="center"
                data-mdb-ripple-color="dark">Edit</button> --></TD>
              
            </TR>
            </c:if>
            </c:forEach>
           
        </table>
    </div>

    <script> 
    function editData(button) {
    	 // Get the parent row of the clicked button
        let row = button.parentNode.parentNode;

        // Get the cells within the row
                let personid = row.cells[0];

        let Firstname = row.cells[1];
        let emailCell = row.cells[5];
        let mobileCell = row.cells[7];    
        
        // Prompt the user to enter updated values
        let nameInput =
            prompt("Enter the updated name:",
            		Firstname.innerHTML);
        let emailInput =
            prompt("Enter the updated email:",
            		emailCell.innerHTML);
        let numberInput =
            prompt("Enter the updated mobile details:",
            		mobileCell.innerHTML
            );
 /*        $.ajax({
            url: '/updateuserDtls',
            type: "POST",
            data: {
            	{"Fname":nameInput,"personid":personid}
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (error) {
                console.log(`Error ${error}`);
            }
        }); */
 
    }
    </script> 
</body>
</html>