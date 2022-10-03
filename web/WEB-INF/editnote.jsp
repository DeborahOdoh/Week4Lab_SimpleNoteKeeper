<%-- 
    Document   : editnote
    Created on : 2-Oct-2022, 7:13:29 PM
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
        <h1>Edit Note</h1>
        <form method="post" action="note"></form>
        Title:<input type="text" name="title" value="${note.title}"><br>
        Content:<textarea name="content" rows="4" cols="50">${note.content}</textarea><br>
        <input type="submit" value="Save">
    </body>
</html>
