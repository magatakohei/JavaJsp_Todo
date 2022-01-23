package com.sample.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.model.Task;

/**
 * Servlet implementation class TaskRegister
 */
@WebServlet("/register")
public class TaskRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		List<Task> taskList = (List<Task>) session.getAttribute("taskList");
		
		if (taskList == null) {
			taskList = new ArrayList();
		}
		
		Integer id = (Integer) session.getAttribute("id");
		if (id == null) {
			id = 0;
		}
		
		String detail = request.getParameter("detail");
		Date deadline = null;
		
		try {
			deadline = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deadline"));
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		String person = request.getParameter("person");
		
		//未完了の状態で作成
		Task task = new Task(++id, person, deadline, detail, false);
		taskList.add(task);
		session.setAttribute("taskList", taskList);
		session.setAttribute("id", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list");
		
		response.setContentType("text/html; charset=UTF-8");
		rd.forward(request, response);
		
		return;
	}

}
