package de.iteconomics.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import de.iteconomics.bo.MountainBO;
import de.iteconomics.service.MountainService;

public class Suche extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final MountainService mountainService = new MountainService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {       
		String country = req.getParameter("country");
		String hFrom = req.getParameter("hFrom");
		String hTo = req.getParameter("hTo");
		List<MountainBO> data = mountainService.fetchMountains(country, hFrom, hTo);
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(data));
		out.flush();
	}
	
}
