package edu.fzu.wah.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {//用于处理全国数据请求
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CountryServlet() {
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
	
	//根据type类型获取全国数据，type包括现有确诊和累计确诊两种类型
	private HashMap<String, Integer> getCountryInfo(String type){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		/* 
		 * 前端直接通过map.entrySet()方法添加固定数据
		 * 如map.entrySet("福建",1)......;
		 * 
		 * 后端负责具体实现该方法：通过service类获取bean类的数据并进行整合，最终返回给本函数
		 * 
		 * */
		return map;
	}

}
