<%--
  Created by IntelliJ IDEA.
  User: akmami
  Date: 12.02.2023
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
  <h1>Add Employee</h1>
  <s:form modelAttribute="employee" action="saveProcess">

    <input type="hidden" value="${employee.hobbies}" id="hiddenTxt"/>

    <s:hidden path="id"/>

    Employee Name: <s:input path="fullname"/> <br/>

    Email: <s:input path="email"/> <br/>

    Gender:
    <s:radiobutton path="gender" value="Male"/> Male
    <s:radiobutton path="gender" value="Female"/> Female <br/>

    Interests: <br/>
    <s:checkbox path="hobbies" value="Sports"/> Sports <br/>
    <s:checkbox path="hobbies" value="Swimming"/> Swimming <br/>
    <s:checkbox path="hobbies" value="Cycling"/> Cycling <br/>

    Country: <s:select path="country">
      <s:option value="Turkey"> Turkey </s:option>
      <s:option value="Turkmenistan"> Turkmenistan </s:option>
    </s:select>  <br/>

    Address: <s:textarea path="address"/> <br/>

    <input type="submit" value="Save Employee"/>

  </s:form>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script>
    $(document).ready(function() {
      var hobbies = $("#hiddenTxt").val().split(",");
      var $checkboxes = $("input[type=checkbox]");
      $checkboxes.each(function(id, element) {
        if (hobbies.indexOf(element.value) != -1) {
          element.setAttribute("checked", "true");
        } else {
          element.removeAttribute("checked");
        }
      });
    });
  </script>

</body>
</html>
