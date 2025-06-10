package controller;

import entity.Beehive;
import model.BeehiveModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/beehives")
public class BeehiveController extends HttpServlet {

    private BeehiveModel beehiveModel;

    @Override
    public void init() {
        beehiveModel = new BeehiveModel();
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
                deleteBeehive(request, response);
                break;
            default:
                listBeehives(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Beehive beehive = new Beehive();

        beehive.setHiveName(request.getParameter("hiveName"));
        beehive.setSiteId(Integer.parseInt(request.getParameter("siteId")));
        beehive.setHiveType(request.getParameter("hiveType"));
        beehive.setExtensionCount(Integer.parseInt(request.getParameter("extensionCount")));
        beehive.setResponsibleAgent(request.getParameter("responsibleAgent"));

        if (id == null || id.isEmpty()) {
            beehiveModel.createBeehive(beehive);
        } else {
            beehive.setId(Integer.parseInt(id));
            beehiveModel.updateBeehive(beehive);
        }

        response.sendRedirect("beehives");
    }

    private void listBeehives(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Beehive> list = beehiveModel.getAllBeehives();
        request.setAttribute("beehives", list);
        this.getServletContext().getRequestDispatcher("/WEB-INF/beehive-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Beehive beehive)
            throws ServletException, IOException {
        request.setAttribute("beehive", beehive);
        this.getServletContext().getRequestDispatcher("/WEB-INF/beehive-form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Beehive beehive = beehiveModel.getBeehiveById(id);
        showForm(request, response, beehive);
    }

    private void deleteBeehive(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        beehiveModel.deleteBeehive(id);
        response.sendRedirect("beehives");
    }
}
