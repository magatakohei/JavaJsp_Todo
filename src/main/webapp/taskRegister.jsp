<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/reset.css" />
    <link rel="stylesheet" href="./css/base.css" />
    <title>taskRegister</title>
  </head>
  <body>
    <header>
      <div class="header_group">
        <h1 class="header_title">タスク登録</h1>
        <a href="/Todo/list" class="btn_gray btn_md">一覧へ</a>
      </div>
    </header>
    <main>
      <form action="register" method="post" class="form_group">
        <dl class="dl_table">
          <dt>タスク</dt>
          <dd>
            <textarea
              name="detail"
              rows="5"
              placeholder="タスクを入力してください。"
              cols="50"
            ></textarea>
          </dd>
          <dt>期日</dt>
          <dd>
            <input type="date" name="deadline" />
          </dd>
          <dt>担当者</dt>
          <dd>
            <select name="person">
              <option value="tadokoro">tadokoro</option>
              <option value="yasu">yasu</option>
              <option value="yasuga">yasuga</option>
              <option value="ade">ade</option>
              <option value="magata">magata</option>
            </select>
          </dd>
        </dl>
        <div class="form_btn_group">
          <input type="submit" value="登録" class="btn_blue btn_lg form_btn" />
        </div>
      </form>
    </main>
  </body>
</html>
