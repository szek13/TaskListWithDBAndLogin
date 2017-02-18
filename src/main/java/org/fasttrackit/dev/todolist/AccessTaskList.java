package org.fasttrackit.dev.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by icondor on 18/02/17.
 */
public class AccessTaskList {

    public List getTaskList() {

        List listaTaskList = new ArrayList<ToDoBean>();
        try {


            Class.forName("org.postgresql.Driver");


            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5IonelD";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
            Statement st = conn.createStatement();

            String query = "SELECT * FROM tasklistionel order by taskname asc";
            // 5. execute a query
            ResultSet rs = st.executeQuery(query);

            // 6. iterate the result set and print the values
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("taskname");
                boolean isdone = rs.getBoolean("isdone");

                ToDoBean randcurent = new ToDoBean(id, name, isdone);


                listaTaskList.add(randcurent);

                // 7. close the objects

            }
            rs.close();
            st.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaTaskList;
    }


}
