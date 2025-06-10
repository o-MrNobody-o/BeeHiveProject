package model;

import java.util.List;

import dao.BeehiveDAO;
import entity.Beehive;

public class BeehiveModel {

    private BeehiveDAO beehiveDAO;

    public BeehiveModel() {
        beehiveDAO = new BeehiveDAO();
    }

    public void createBeehive(Beehive beehive) {
        beehiveDAO.addBeehive(beehive);  
    }

    public List<Beehive> getAllBeehives() {
        return beehiveDAO.getAllBeehives();
    }

    public Beehive getBeehiveById(int id) {
        return beehiveDAO.getBeehiveById(id);
    }

    public void updateBeehive(Beehive beehive) {
        beehiveDAO.updateBeehive(beehive);
    }

    public void deleteBeehive(int id) {
        beehiveDAO.deleteBeehive(id);
    }
}
