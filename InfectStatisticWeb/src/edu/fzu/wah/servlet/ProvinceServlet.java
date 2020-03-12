package edu.fzu.wah.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {//用于处理某省的数据请求
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
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
	
	//根据省份名字获取该省的疫情情况，并通过HashMap返回，键值分别对应类型和数量，如：("治愈", 1)、("疑似", 2)....共四种
	private HashMap<String, Integer> getProvinceInfo(String name){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		/*
		 * 前端直接通过map.entrySet()方法添加固定数据
		 * 后端具体实现该方法：通过service类获取bean类的数据并进行整合，最终返回给本函数
		 * 
		 * */
		return map;
	}

}
