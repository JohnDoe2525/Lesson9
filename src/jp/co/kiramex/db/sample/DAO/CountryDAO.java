package jp.co.kiramex.db.sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.kiramex.db.sample.entity.Country;
import jp.co.kiramex.db.sample.util.DatabaseManager;

public class CountryDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;

    public List<Country> getCountryFromName(String name){
        List<Country> result= new ArrayList<Country>();

        try {
            Connection con = DatabaseManager.getConnection();

            String sql =  "SELECT * FROM country WHERE Name = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Country country = new Country();

                country.setName(rs.getString("Name"));
                country.setPopulation(rs.getInt("Population"));

                result.add(country);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
