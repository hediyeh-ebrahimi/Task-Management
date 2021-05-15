<%@ page import="bean.Index" %>
<%@ page import="entity.Task" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hedi
  Date: 5/10/2021
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>مدیریت تسک</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body style="direction: rtl;">
<jsp:useBean id="task" class="bean.Index"/>

<div class="container">
    <form action="/save" method="post">
        <div class="form-group">
            <label for="title">عنوان:</label>
            <input type="title" class="form-control" id="title" placeholder="عنوان را وارد کنید" name="title">
        </div>
        <div class="form-group">
            <label for="description">توضیحات:</label>
            <textarea class="form-control" placeholder="توضیحات را وارد کنید" name="description" id="description">
        </textarea>
        </div>

        <div class="form-group">
            <label for="duration">زمان:</label>
            <input type="date" class="form-control" id="duration" placeholder="مدت زمان را وارد کنید" name="duration"/>
        </div>
        <button type="submit" class="btn btn-default ">Submit</button>
    </form>
</div>
<div class="container">
    <table class="table">
      <thead>
      <tr>
        <th>عنوان</th>
        <th>توضیحات</th>
        <th>مدت زمان</th>
        <th>تاریخ ایجاد</th>
        <th>تاریخ ویرایش</th>
        <th>ویرایش</th>
        <th>حذف</th>
      </tr>
      </thead>
        <%
            List<Task> tasks = task.getTaskList();
            if (tasks.size() > 0) {
                for (Task task0 : tasks) {
        %>
        <tr>
            <td><%= task0.getTitle()%></td>
            <td><%= task0.getDescription()%></td>
            <td><%= task0.getDuration()%></td>
            <td><%= task0.getCreatedOn()%></td>
            <td><%= task0.getUpdatedOn()%></td>
          <td><a class="btn btn-default btn-info" href="/update?id=<%= task0.getId()%>">ویرایش</a></td>
          <td><a class="btn btn-default btn-danger" href="/delete?id=<%= task0.getId()%>">حذف</a></td>
        </tr>
        <%
                }
            }

        %>
    </table>

</div>


</body>
</html>
