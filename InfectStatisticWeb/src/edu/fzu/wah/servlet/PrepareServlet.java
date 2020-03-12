package edu.fzu.wah.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.fzu.wah.service.InfectStatistic;
import edu.fzu.wah.service.ProcessParameter;

/**
 * Servlet implementation class PrepareServlet
 */
@WebServlet("/PrepareServlet")
public class PrepareServlet extends HttpServlet {//该类用于最初的调用bean类中的方法，对日志文件的数据进行处理
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareServlet() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String parameters = "-list -log C:\\Users\\绍鸿\\Desktop\\部分疫情日志log"
				+ " -out C:\\Users\\绍鸿\\Desktop\\out.txt";
		String []args = parameters.split(" ");
		ProcessParameter processParameter = new ProcessParameter();
		processParameter.processParameters(args);
		processParameter.statistic();//开始统计
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
