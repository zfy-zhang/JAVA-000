package org.geekbang.java.insert;

import org.junit.Test;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class InsertTestDemo {

    private String url = "jdbc:mysql://localhost:3306/inserttest";
    private String user = "root";
    private String password = "zfy123456";

    @Test
    public void testOne() throws Exception {
//        int i = batchInsert();
//        System.out.println(i);
        simpleInsertTest();
    }

    // 批量插入+事务
    private int batchInsert() throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement =null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            Long startTime = System.currentTimeMillis();

            String sql = "INSERT INTO orders" +
                    "(id, user_id, receiver_name, receiver_mobile, receiver_address, total_amount, real_pay_amount, post_amount, pay_method, is_comment, is_delete, created_time, updated_time) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,sysdate(),sysdate())";
            preparedStatement = conn.prepareStatement(sql);

            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2, "200509GYMFN89028");
                preparedStatement.setString(3, "不才人");
                preparedStatement.setString(4, "13298933324");
                preparedStatement.setString(5, "上海 上海 浦东新区 唐镇");
                preparedStatement.setInt(6, 2000);
                preparedStatement.setInt(7, 1700);
                preparedStatement.setInt(8, 0);
                preparedStatement.setInt(9, 1);
                preparedStatement.setInt(10, 1);
                preparedStatement.setInt(11, 0);
                preparedStatement.addBatch();
            }
    //        preparedStatement.execute();
            final int[] results = preparedStatement.executeBatch();
            conn.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime));
            return results.length;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
//        return results.length;
    }

    // JDBC往数据库中普通插入方式
    private void simpleInsertTest() {
        Connection conn = null;
        PreparedStatement pstm =null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO orders" +
                    "(id, user_id, receiver_name, receiver_mobile, receiver_address, total_amount, real_pay_amount, post_amount, pay_method, is_comment, is_delete, created_time, updated_time) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,sysdate(),sysdate())";
            pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            Long startTime = System.currentTimeMillis();
            Random random = new Random();
            for (int i = 1; i <= 1000000; i++) {
                pstm.setString(1, UUID.randomUUID().toString());
                pstm.setString(2, "200509GYMFN89028");
                pstm.setString(3, "不才人");
                pstm.setString(4, "13298933324");
                pstm.setString(5, "上海 上海 浦东新区 唐镇");
                pstm.setInt(6, 2000);
                pstm.setInt(7, 1700);
                pstm.setInt(8, 0);
                pstm.setInt(9, 1);
                pstm.setInt(10, 1);
                pstm.setInt(11, 0);
                pstm.executeUpdate();
            }
            pstm.executeUpdate();
            conn.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
