package de.iteconomics.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.iteconomics.bo.MountainBO;

public class MountainDAO {

    private static final String COUNTRY_AND_HEIGHT_BETWEEN_AND = "SELECT * FROM mountains WHERE country = ? AND height between ? and ?";

    private final ConnectionHelper connectionHelper = ConnectionHelper.getInstance();

    public List<MountainBO> getMountains(String countryValue, int hFrom, int hTo) {
        final List<MountainBO> result = new ArrayList<>();
        try (final Connection connection = connectionHelper.getConnection();
             final PreparedStatement stmt = connection.prepareStatement(COUNTRY_AND_HEIGHT_BETWEEN_AND)) {
            stmt.setString(1, countryValue);
            stmt.setInt(2, hFrom);
            stmt.setInt(3, hTo);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                final MountainBO bo = new MountainBO();
                bo.id = res.getInt("id");
                bo.country = res.getString("country");
                bo.name = res.getString("name");
                bo.height = res.getInt("height");
                result.add(bo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL query failed", e);
        }
        return result;
    }
}

