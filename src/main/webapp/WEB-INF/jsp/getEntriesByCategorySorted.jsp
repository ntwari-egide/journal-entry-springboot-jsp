<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    body {
        background-color: #C4E5FF;
        padding: 2em;
        font-family: 'Poppins', sans-serif;
    }

    h1 {
        background: #185359;
        padding: 16px;
        margin-top: -45px;
        width: 98vw;
        margin-left: -42px;
        height: 5vh;
        font-size: 17px;
        margin-bottom: 60px;
        position: sticky;
        top: 0px;
        color: white;
    }

    .entry-container {
        border: 1px solid #004681;
        padding: 19px;
        width: 50vw;
        border-radius: 6px;
        margin: auto;
    }

    .entry-container:hover{
         background: #ABD9FF;
         transition: ease-in-out 0.4s;
         border: 1px solid white;
    }

    h4 {
        text-align: center;
    }

</style>
<title>Insert title here</title>
</head>
<body>
        <h1>Journal Entry Publisher</h1>

	    <h4>Entry found: </h4>

        <c:forEach items="${entries}" var="entry">
           <div class="entry-container">
                    ${entry}
                   <p>ID: <t> ${entry.id}</p>
                   <p>Content: <t> ${entry.title}</p>
                   <p>Category: <t> ${entry.category}</p>
           </div>  <br />
        </c:forEach>
</body>
</html>