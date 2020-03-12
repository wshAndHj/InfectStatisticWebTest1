package edu.fzu.wah.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreventGuid
 */
@WebServlet("/PreventGuid")
public class PreventGuidServlet extends HttpServlet {//处理防疫信息的数据请求
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreventGuidServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//该方法用于获取预防指南的HashMap，(K,V)分别对应的是预防类型和建议列表，如：("个人清洁"，{"1...", "2..."})
	private HashMap<String, List<String>> getPrepareGuids() {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		/*
		 * 前端直接通过map.entrySet()方法添加固定数据
		 * 后端具体实现该方法：通过service类获取bean类的数据并进行整合，最终返回给本函数
		 * 
		 * */
		return map;
	}

}
