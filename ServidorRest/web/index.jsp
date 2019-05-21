<%-- 
    Document   : index
    Created on : 19/05/2019, 08:55:36 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.arduino.sensor.Arduino"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            if (request.getParameter("botonsensar") != null) {

                Arduino ar = new Arduino();

            } else {%>

        <form action="index.jsp" method="post">


            <%}%>
            <button name="botonsensar" type="input">Sensar</button>


    </body>
</html>
