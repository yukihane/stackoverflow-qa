package com.github.yukihane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

    private Connection db;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<Lunch> findFour(final int code, final int Quantity) {
        final List<Lunch> list = new ArrayList<>();

        final int qu = 0 + Quantity;
        try {
            //DBに接続
            this.connect();
            //SQL文に全件表示文字列の挿入
            ps = db.prepareStatement(
                "select product_code,product_name,quantity + ? as total from m_product where product_code=?");
            ps.setInt(1, qu);
            ps.setInt(2, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                final int product_code = rs.getInt("product_code");
                final String product_name = rs.getString("product_name");
                final int total = rs.getInt("total");
                final Lunch l = new Lunch(product_code, product_name, total);
                insertTwo(product_name, product_code, total);
                list.add(l);
            }
            for (final Lunch l : list) {
                System.out.println(l);
            }

            //クローズ処理
            rs.close();
            ps.close();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        return list;

    }

    private void disconnect() {
        // TODO Auto-generated method stub

    }

    private void insertTwo(final String product_name, final int product_code, final int total) {
        // TODO Auto-generated method stub

    }

    private void connect() {
        // TODO Auto-generated method stub

    }

    public static void main(final String[] args) throws SQLException {
        final App app = new App();
        try {
            app.prepare();
            app.findFour(2, 9);
        } finally {
            app.shutdown();
        }
    }

    private void prepare() throws SQLException {
        System.out.println("start");
        db = DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=my-secret-pw");
        System.out.println("connected");
    }

    private void shutdown() throws SQLException {
        if (db != null) {
            db.close();
        }
    }
}
