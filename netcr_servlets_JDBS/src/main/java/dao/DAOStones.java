package dao;

import model.creator.ClassStone;
import model.myEntitys.Stone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by USER on 16.04.2017.
 */
public class DAOStones {

    public static Collection<Stone> getGems(Connection conn) {
        String sql = "select * from gems";
        String classStone = "GEMS";
        Collection<Stone> list = getStones(conn, sql, classStone);
        return list;
    }

    public static Collection<Stone> getSemiprecious(Connection conn) {
        String sql = "select * from semiprecious";
        String classStone = "SEMIPRECIOUS";
        Collection<Stone> list = getStones(conn, sql, classStone);
        return list;
    }

    public static Stone getStoneById(Connection conn, Integer id, String classStone) {
        String sql = "";
        if(classStone.compareTo("gems")==0)
            sql = "select name, carat from gems where id = ?";
        else if (classStone.compareTo("semiprecious")==0)
            sql = "select name, carat from semiprecious where id = ?";
        PreparedStatement pstm = null;
        Stone stone = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Double carat = rs.getDouble("carat");
                stone = ClassStone.createStone(classStone, id, name, carat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stone;
    }


    public static Collection<Stone> getStones(Connection conn, String sql, String classStone) {
        List<Stone> list = new ArrayList<>();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Double carat = rs.getDouble("carat");

                Stone stone = ClassStone.createStone(classStone, id, name, carat);
                list.add(stone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
