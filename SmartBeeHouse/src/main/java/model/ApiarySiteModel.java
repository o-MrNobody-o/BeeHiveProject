package model;

import dao.ApiarySiteDAO;
import entity.ApiarySite;

import java.util.List;

public class ApiarySiteModel {
    private ApiarySiteDAO apiarySiteDAO;

    public ApiarySiteModel() {
        apiarySiteDAO = new ApiarySiteDAO();
    }

    public boolean createApiarySite(ApiarySite site) {
        return apiarySiteDAO.addApiarySite(site);
    }

    public List<ApiarySite> getAllApiarySites() {
        return apiarySiteDAO.getAllApiarySites();
    }

    public ApiarySite getApiarySiteById(int id) {
        return apiarySiteDAO.getApiarySiteById(id);
    }

    public boolean updateApiarySite(ApiarySite site) {
        return apiarySiteDAO.updateApiarySite(site);
    }

    public boolean deleteApiarySite(int id) {
        return apiarySiteDAO.deleteApiarySite(id);
    }

    
}
