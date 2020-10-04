<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="au.com.prince.bean.MovieCollector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prince's Theatre</title>
<style>
    h1 {
        border: 0px solid #dddddd;
        text-align: center;
        padding: 16px;
    }

	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 20%;
	}
    table.center {
        margin-left: auto;
        margin-right: auto;
    }

    th {
        border: 1px solid #dddddd;
        text-align: center;
        padding: 8px;
    }

	td {
		border: 1px solid #dddddd;
		text-align: left;
		padding: 8px;
	}

	tr:nth-child(even) {
		background-color: #dddddd;
	}
</style>
</head>
<body>
<h1>Prince's Theatre</h1>
<table class = "center">
    <tr>
        <td colspan="2"><a href="/ClassicMovies"><img src = "/images/back.png" style = "width:30%; height:40%"></td>
    </tr>
    <tr>
        <th colspan="2"><img src = ${movieDetails.getPoster()} ></th>
    </tr>
    <h3>
        <td colspan="2"><h3>${movieDetails.getTitle()}</h3></td>
    </tr>
    <tr>
        <td>${movieDetails.getProviderLow()}</td>
        <td>$${movieDetails.getPriceLow()}</td>
    </tr>
    <tr>
        <td>${movieDetails.getProviderHigh()}</td>
        <td>$${movieDetails.getPriceHigh()}</td>
    </tr>
</table>
</body>
</html>