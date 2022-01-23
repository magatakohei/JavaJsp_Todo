package com.sample.servlet;

import java.io.IOException;
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
 * Servlet implementation class TaskComplete
 */
@WebServlet("/complete")
public class TaskCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskCompleteServlet() {
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
		
		HttpSession session = request.getSession();
		
		String[] ids = request.getParameterValues("complete_chk");
		List<Task> taskList = (List<Task>) session.getAttribute("taskList");
		
		if (ids == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/list");
			response.setContentType("text/html; charset=UTF-8");
			rd.forward(request, response);
			
			return;
		}
		
		for (String strId : ids) {
			int id = Integer.parseInt(strId);
			
			Optional<Task> optTask = taskList.stream()
					.filter(task->task.getId() == id)
					.findFirst();
			
			Task targetTask = optTask.orElseThrow();
			targetTask.setIsComplete(true);
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/list");
		response.setContentType("text/html; charset=UTF-8");
		rd.forward(request, response);
		
		return;
	}

}
