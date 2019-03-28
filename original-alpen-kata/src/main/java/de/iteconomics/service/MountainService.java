package de.iteconomics.service;

import de.iteconomics.bo.MountainBO;
import de.iteconomics.db.MountainDAO;

import java.util.List;

public class MountainService {

    private final MountainDAO dao = new MountainDAO();

    public List<MountainBO> fetchMountains(String country, String hFrom, String hTo) {
        return dao.getMountains(country,Integer.parseInt(hFrom), Integer.parseInt(hTo));
    }
}
