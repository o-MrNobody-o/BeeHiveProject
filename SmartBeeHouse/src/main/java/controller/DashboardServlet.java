package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DashboardDao;
import entity.Farmer;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private DashboardDao dashboardDao;

    @Override
    public void init() {
        dashboardDao = new DashboardDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Farmer> farmers = dashboardDao.getAllFarmers();
            request.setAttribute("farmers", farmers);       
            this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);

            
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	String farmerName =request.getParameter("farmerName");
            int farmerId = Integer.parseInt(request.getParameter("farmerId"));
            int siteCount = dashboardDao.getSiteCountByFarmerId(farmerId);
            int hiveCount = dashboardDao.getHiveCountByFarmerId(farmerId);
            List<Farmer> farmers = dashboardDao.getAllFarmers();
            request.setAttribute("farmer", farmerName);
            request.setAttribute("farmers", farmers);
            request.setAttribute("selectedFarmerId", farmerId);
            request.setAttribute("siteCount", siteCount);
            request.setAttribute("hiveCount", hiveCount);
            this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
