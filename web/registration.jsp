
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <form action="saveInfoServlet" method="post">

      Login: <input type="text" name="login" maxlength="20" /> <br />
      Password: <input type="password" name="password1" maxlength="20"/> <br />
      Verification Password: <input type="password" name="password2" maxlength="20"/> <br />
      FirstName: <input type="text" name="firstName" maxlength="20"/> <br />
      LastName: <input type="text" name="lastName" maxlength="20"/> <br />
      Email: <input type="email" name="email" maxlength="64"/> <br />
      Birthday: <input type="date" name="birthday"/> <br />
      City: <input type="text" name="city" maxlength="20"/> <br />

      <input type="submit" name="register" value="Registration"/>

    </form>

</body>
</html>
