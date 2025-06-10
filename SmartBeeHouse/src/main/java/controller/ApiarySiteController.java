package controller;

import entity.ApiarySite;
import model.ApiarySiteModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/apiarysites")
public class ApiarySiteController extends HttpServlet {

    private ApiarySiteModel apiarySiteModel;

    @Override
    public void init() {
        apiarySiteModel = new ApiarySiteModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showForm(request, response, null);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteApiarySite(request, response);
                break;
            default:
                listApiarySites(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        ApiarySite site = new ApiarySite();

        // Set site details from form
        site.setSiteName(request.getParameter("siteName"));
        site.setLatitude(Double.parseDouble(request.getParameter("latitude")));
        site.setLongitude(Double.parseDouble(request.getParameter("longitude")));
        site.setAltitude(Double.parseDouble(request.getParameter("altitude")));
        site.setSetupDate(java.sql.Date.valueOf(request.getParameter("setupDate")));
        site.setClosureDate(java.sql.Date.valueOf(request.getParameter("closureDate")));
        site.setFarmerId(Integer.parseInt(request.getParameter("farmerId")));

        if (id == null || id.isEmpty()) {
            apiarySiteModel.createApiarySite(site);
        } else {
            site.setId(Integer.parseInt(id));
            apiarySiteModel.updateApiarySite(site);
        }

        response.sendRedirect("apiarysites");
    }

    private void listApiarySites(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ApiarySite> list = apiarySiteModel.getAllApiarySites();
        request.setAttribute("apiarySites", list);
        System.out.println("Size: " + list.size());
        for (ApiarySite a :list) {
        	System.out.println(a);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/apiarysite-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, ApiarySite site)
            throws ServletException, IOException {
        request.setAttribute("apiarySite", site);
        this.getServletContext().getRequestDispatcher("/WEB-INF/apiarysite-form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ApiarySite site = apiarySiteModel.getApiarySiteById(id);
        showForm(request, response, site);
    }

    private void deleteApiarySite(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        apiarySiteModel.deleteApiarySite(id);
        response.sendRedirect("apiarysites");
    }
}
