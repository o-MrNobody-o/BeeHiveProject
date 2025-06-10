package controller;

import entity.Farmer;
import model.FarmerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/farmers")
public class FarmerController extends HttpServlet 
{

    private FarmerModel farmerModel;

    @Override
    public void init() 
    {
        farmerModel = new FarmerModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) 
        {
            case "new":
                showForm(request, response, null);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteFarmer(request, response);
                break;
            default:
                listFarmers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        String id = request.getParameter("id");
        Farmer farmer = new Farmer();

        // Set farmer details from form
        farmer.setFirstName(request.getParameter("firstName"));
        farmer.setLastName(request.getParameter("lastName"));
        farmer.setEmail(request.getParameter("email"));
        farmer.setPhone(request.getParameter("phone"));

        if (id == null || id.isEmpty()) 
        {
            farmerModel.createFarmer(farmer);
        } 
        else 
        {
            farmer.setId(Integer.parseInt(id));
            farmerModel.updateFarmer(farmer);
        }

        response.sendRedirect("farmers");
    }

    private void listFarmers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<Farmer> list = farmerModel.getAllFarmers();
        request.setAttribute("farmers", list);
        this.getServletContext().getRequestDispatcher("/WEB-INF/farmer-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Farmer farmer)
            throws ServletException, IOException 
    {
        request.setAttribute("farmer", farmer);
        this.getServletContext().getRequestDispatcher("/WEB-INF/farmer-form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Farmer farmer = farmerModel.getFarmerById(id);
        showForm(request, response, farmer);
    }

    private void deleteFarmer(HttpServletRequest request, HttpServletResponse response)
            throws IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        farmerModel.deleteFarmer(id);
        response.sendRedirect("farmers");
    }
}
