<%@ page import="vn.projectLTW.util.Language" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Map<String,String> showLanguage = new Language().vietnameseLanguage();
    String lang = (String) session.getAttribute("lang");
    if(lang!=null){
        if(lang.equals("Vietnamese")){
            showLanguage = new Language().vietnameseLanguage();
        } else if (lang.equals("English")) {
            showLanguage = new Language().englishLanguage();

        }
    }%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
          crossorigin="anonymous">

    <title>changePassword</title>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-sm-12">
            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">
                        ${error}
                </div>
            </c:if>
            <c:if test="${not empty success}">
                <div class="alert alert-success" role="alert">
                        ${success}
                </div>
            </c:if>

            <form action="ChangePassword" method="POST">
                <input type="hidden" class="form-control" id="Id" name="Id"
                       value="${sessionScope.account.userId}">
                <div class="mb-3">
                    <label>Mật khẩu cũ</label> <input type="password" required
                         class="form-control" id="oldPass" name="oldPass" title="Nhập mật khẩu cũ" >
                </div>

                <div class="mb-3">
                    <label>Mật khẩu mới</label> <input type="password" required
                        class="form-control" id="newPass" name="newPass" title="Nhập mật khẩu mới">
                </div>

                <div class="mb-3">
                    <label>Nhập lại mật khẩu</label> <input type="password" required
                       class="form-control" id="confirmPass" name="confirmPass" title="Nhập lại mật khẩu">
                </div>
                <br>
                <button  class="btn btn-primary" type="submit" style="margin-left: 47%" title="Thay đổi mật khẩu>">Thay đổi mật khẩu</button>

            </form>
            <br>

        </div>

    </div>

</div>
</body>
</html>