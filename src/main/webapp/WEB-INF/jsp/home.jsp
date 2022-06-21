<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addEntry">
		<div>Add New Journal Entry :</div><br>
		<div>Id :</div> <input type="text" name="id"><br>
		<div>Title :</div> <input type="text" name="title"><br>
		<div>Category :</div> <input type="text" name="category"><br>

		<input type="submit">
	</form><br>

	<form action="getEntry">
		<div>Enter the Id to get Specific Entry:</div><br>
		<input type="text" name="id"><br>

		<input type="submit">
	</form><br>

	<form action="deleteEntry">
		<div>Enter the Id to Delete Entry:</div><br>
		<input type="text" name="id"><br>
		<input type="submit">
	</form><br>

	<form action="getEntriesByCategory">
		<div>Enter the Category to Get Entries :</div><br>
		<input type="text" name="category"><br>
		<input type="submit">
	</form><br>

	<form action="getEntriesByIdGT">
		<div>Enter the marginal Id :</div><br>
		<input type="text" name="id"><br>
		<input type="submit">
	</form><br>

	<form action="getEntriesByCategorySorted">
		<div>Enter the Category to Get Sorted Entries :</div><br>
		<input type="text" name="category"><br>
		<input type="submit">
	</form>

</body>
</html>