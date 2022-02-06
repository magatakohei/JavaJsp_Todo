<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/reset.css" />
    <link rel="stylesheet" href="./css/base.css" />
    <title>taskEdit</title>
  </head>
  <body>
    <header>
      <div class="header_group">
        <h1 class="header_title">タスク編集</h1>
        <a href="/Todo/list" class="btn_gray btn_md">一覧へ</a>
      </div>
    </header>
    <main>
      <form action="edit" method="post" class="form_group">
        <input type="hidden" name="id" value="${ editTask.id }" />
        <dl class="dl_table">
          <dt>タスク</dt>
          <dd>
            <textarea
              name="detail"
              rows="10"
              placeholder="タスクを入力してください。"
              cols="60"
            ><c:out value="${ editTask.detail }" /></textarea>
          </dd>
          <dt>期日：</dt>
          <dd>
            <input
              type="date"
              name="deadline"
              value="<fmt:formatDate value="${ editTask.deadline }" pattern="yyyy-MM-dd" />"
            />
          </dd>
          <dt>担当者：</dt>
          <dd>
            <select name="person">
              <option
                value="tadokoro"
                <c:if test="${ editTask.person == 'tadokoro' }">selected</c:if>
              >
                tadokoro
              </option>
              <option value="yasu" <c:if test="${ editTask.person == 'yasu' }">selected</c:if>>
                yasu
              </option>
              <option value="yasuga" <c:if test="${ editTask.person == 'yasuga' }">selected</c:if>>
                yasuga
              </option>
              <option value="ade" <c:if test="${ editTask.person == 'abe' }">selected</c:if>>
                ade
              </option>
              <option value="magata" <c:if test="${ editTask.person == 'magata' }">selected</c:if>>
                magata
              </option>
            </select>
          </dd>
        </dl>
        <div class="form_btn_group">
          <a href="/Todo/delete?id=${ editTask.id }" class="btn_red btn_lg">削除</a>
          <input type="submit" value="保存" class="btn_blue btn_lg form_btn"/>
        </div>
      </form>
    </main>
  </body>
</html>
