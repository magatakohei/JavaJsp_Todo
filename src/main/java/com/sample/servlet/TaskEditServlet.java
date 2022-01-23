package com.sample.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.model.Task;

/**
 * Servlet implementation class TaskEdit
 */
@WebServlet("/edit")
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		List<Task> taskList = (List<Task>) session.getAttribute("taskList");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Optional<Task> optTask = taskList.stream().filter(t->t.getId() == id).findFirst();
		
		request.setAttribute("editTask", optTask.get());

		RequestDispatcher rd = request.getRequestDispatcher("/taskEdit.jsp");
		response.setContentType("text/html; charset=UTF-8");
		rd.forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		List<Task> taskList = (List<Task>) session.getAttribute("taskList");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Optional<Task> optTask = taskList.stream().filter(t->t.getId() == id).findFirst();
		Task targetTask = optTask.orElseThrow();
		
		targetTask.setDetail(request.getParameter("detail"));
		targetTask.setPerson(request.getParameter("person"));
		try {
			targetTask.setDeadline(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deadline")));
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/list");
		response.setContentType("text/html; charset=UTF-8");
		rd.forward(request, response);
		
		return;
		
	}

}
