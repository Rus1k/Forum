<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FORUM</title></head>
<body><h1>WELCOME</h1>
<center ><h1>authorization</h1>

    <form action="startServlet" method="POST"> <br/>

        Login   :<input type="text" name="login"> <br/>
        Password:<input type="password" name="password"> <br/>
        <input type="submit" name="enter" value="Login in"/>
        <input type="submit" name="register" value="Registration"/>

    </form>
</center>
</body>
</html>