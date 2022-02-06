<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/add-user.css"/>
    <%--   <script src="<%request.getContextPath()%>/validation.js"></script>--%>
    <title>Add user</title>
</head>
<body style="background-color: #F5F5DC">
<div class="container">
    <h1>Add user</h1>
    <form name="registration" method="POST" action="${pageContext.request.contextPath}/addUser" class="registration-form"
          onsubmit="return formValidation()">
        <table>
            <tr>
                <td><label for="role">Role</label></td>
                <td>
                    <select name="role" id="role">
                        <option value="">Select role</option>
                        <option value="English">admin</option>
                        <option value="Spanish">user</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="login">Login:</label></td>
                <td><label>
                    <input name="login" id="login" placeholder="Login" class="form-control" type="text" required>
                </label></td>
            </tr>


            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" name="password" placeholder="Password" id="password" required></td>
            </tr>
            <tr>
                <td><label for="confirm_password">Confirm password:</label></td>
                <td><input type="password" placeholder="Confirm Password" id="confirm_password" required></td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input type="text" name="email" id="email" placeholder="your email"></td>
            </tr>
            <tr>

                <td><label for="firstname">Firstname:</label></td>
                <td><input type="text" name="firstname" id="firstname" placeholder="firstname"></td>
            </tr>

            <tr>

                <td><label for="lastname">Lastname:</label></td>
                <td><input type="text" name="lastname" id="lastname" placeholder="lastname"></td>
            </tr>


            <tr>
                <form action="">
                    <td>
                        <label for="birthday">Birthday:</label></td>
                    <td><input type="date" id="birthday" name="birthday"></td>
                </form>
                </td>

            </tr>

            <tr>
                <td colspan="2"><input type="submit" class="submit" value="Add"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
