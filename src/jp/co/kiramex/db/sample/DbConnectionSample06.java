package jp.co.kiramex.db.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import jp.co.kiramex.db.sample.DAO.CountryDAO;
import jp.co.kiramex.db.sample.entity.Country;

public class DbConnectionSample06 {

    public static void main(String[] args) {
        CountryDAO dao = new CountryDAO();

        System.out.print("検索キーワードを入力してください > ");
        String name = keyIn();

        List<Country> list = dao.getCountryFromName(name);

        for (Country item : list) {
            System.out.println(item.getName());
            System.out.println(item.getPopulation());
        }
    }

    public static String keyIn() {
        String line = null;
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = key.readLine() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}
