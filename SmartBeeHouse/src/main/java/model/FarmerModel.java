package model;

import dao.FarmerDAO;
import entity.Farmer;

import java.util.List;

public class FarmerModel 
{

    private FarmerDAO farmerDAO;

    public FarmerModel() 
    {
        farmerDAO = new FarmerDAO();
    }

    public boolean createFarmer(Farmer farmer) 
    {
        return farmerDAO.addFarmer(farmer);
    }

    public List<Farmer> getAllFarmers() 
    {
        return farmerDAO.getAllFarmers();
    }

    public Farmer getFarmerById(int id) 
    {
        return farmerDAO.getFarmerById(id);
    }

    public boolean updateFarmer(Farmer farmer) 
    {
        return farmerDAO.updateFarmer(farmer);
    }

    public boolean deleteFarmer(int id) 
    {
        return farmerDAO.deleteFarmer(id);
    }
}
