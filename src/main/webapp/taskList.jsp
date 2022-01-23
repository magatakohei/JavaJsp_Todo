<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/reset.css" />
    <link rel="stylesheet" href="./css/base.css" />
    <title>taskList</title>
  </head>
  <body>
    <header>
      <div class="header_group">
        <h1 class="header_title">登録タスク一覧</h1>
        <a href="/Todo/taskRegister.jsp" class="btn_blue btn_md">登録へ</a>
      </div>
    </header>
    <main>
      <c:if test="${ empty sessionScope.notCompleteTaskList }">
        <p>登録がありません</p>
      </c:if>
      <c:if test="${ !empty sessionScope.notCompleteTaskList }">
        <div class="incomplete_content">
          <form action="complete" method="post">
            <table class="todo_table">
              <thead>
                <tr>
                  <th></th>
                  <th>担当者</th>
                  <th>期限</th>
                  <th>タスク</th>
                </tr>
              </thead>
              <c:forEach
                items="${ sessionScope.notCompleteTaskList }"
                var="task"
              >
                <tr>
                  <td class="table_chk_box">
                    <input
                      type="checkbox"
                      name="complete_chk"
                      value="${ task.id }"
                      class="complete_chk"
                    />
                  </td>
                  <td class="table_person">
                    <c:out value="${ task.person }" />
                  </td>
                  <td class="table_deadline">
                    <fmt:formatDate
                      value="${ task.deadline }"
                      pattern="yyyy/MM/dd"
                    />
                  </td>
                  <td class="table_detail">
                    <c:out value="${ task.detail }" />
                  </td>
                  <td>
                    <a
                      href="/Todo/edit?id=${ task.id }"
                      class="btn_gray btn_sm table_btn"
                      >編集</a
                    >
                  </td>
                </tr>
              </c:forEach>
            </table>
            <input
              type="submit"
              value="完了"
              class="btn_blue btn_sm table_btn"
            />
          </form>
        </div>
      </c:if>

      <c:if test="${ !empty sessionScope.completedTaskList }">
        <div class="complete_content">
          <h1>完了済み</h1>
          <table class="todo_table">
            <thead>
              <tr>
                <th></th>
                <th>担当者</th>
                <th>期限</th>
                <th>タスク</th>
              </tr>
            </thead>
            <c:forEach items="${ sessionScope.completedTaskList }" var="task">
              <tr>
                <td>
                  <form action="incomplete" method="post">
                    <input type="hidden" name="id" value="${ task.id }" />
                    <input
                      type="submit"
                      value="未完了"
                      class="btn_gray btn_sm table_btn"
                    />
                  </form>
                </td>
                <td class="table_person"><c:out value="${ task.person }" /></td>
                <td class="table_deadline">
                  <fmt:formatDate
                    value="${ task.deadline }"
                    pattern="yyyy/MM/dd"
                  />
                </td>
                <td class="table_detail">
                  <c:out value="${ task.detail }" />
                </td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </c:if>
    </main>
  </body>
</html>
