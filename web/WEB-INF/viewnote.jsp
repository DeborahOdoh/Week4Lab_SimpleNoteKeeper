<%-- 
    Document   : viewnote
    Created on : 2-Oct-2022, 7:13:11 PM
    Author     : odohd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>View Note</h1>
        <b>Title: </b>${note.title}<br>
        <b>Content: </b><br>
        ${note.content}<br>
        <a href=""note?edit">Edit<a/>
    </body>
</html>