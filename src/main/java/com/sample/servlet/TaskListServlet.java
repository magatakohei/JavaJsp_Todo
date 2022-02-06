package com.sample.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.model.Task;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/list")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListServlet() {
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
		
		if (taskList == null) {
			taskList = new ArrayList();
		}
		
		//ソート
		taskList.sort(Comparator.comparing(Task::getDeadline));
		
		List<Task> notCompleteTaskList = taskList.stream()
				.filter(task->!task.getIsComplete())
				.collect(Collectors.toList());
		
		List<Task> completedTaskList = taskList.stream()
				.filter(task->task.getIsComplete())
				.collect(Collectors.toList());
		
		session.setAttribute("notCompleteTaskList", notCompleteTaskList);
		session.setAttribute("completedTaskList", completedTaskList);

		RequestDispatcher rd = request.getRequestDispatcher("/taskList.jsp");
		response.setContentType("text/html; charset=UTF-8");
		rd.forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
