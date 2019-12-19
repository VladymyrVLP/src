import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false",
                "root","shishkagnv0116");
        Statement stm = connection.createStatement();
        ResultSet st = stm.executeQuery("select * from student");
        while (st.next()){
            int i = st.getInt(1);
            String name = st.getString(2);
            int j = st.getInt(3);
            int k = st.getInt(4);
            System.out.println("id: " + i + " | " + "FIO: " + name + " | " + "Group: " + j + " | "
                    + "Year started education: " + k);

        }
        System.out.println("============================================================================");
        ResultSet rs = stm.executeQuery("select FIOStudent, `Group` from student where `Group`=1");
        while (rs.next()){
            String name1 = rs.getString(1);
            int g = rs.getInt(2);
            System.out.println("FIO: " + name1 + " | " + "Group: " + g);

        }
        System.out.println("============================================================================");
        ResultSet gs = stm.executeQuery("select FIOStudent, `YearOfStart` from student where `YearOfStart`=2006");
        while (gs.next()){
            String name2 = gs.getString(1);
            int g = gs.getInt(2);
            System.out.println("FIO: " + name2 + " | " + "Year started education: " + g);

        }
        System.out.println("============================================================================");
        ResultSet ms = stm.executeQuery("select Mark,FIOStudent,Name,FIOTeacher from student.mark " +
                "right join student.student on Student=idSTUDENT " +
                "left join student.exersize on Exersize=idExersize " +
                "left join student.teacher on Teacher=idTeacher where idSTUDENT = 5");
        while (ms.next()){
            int m = ms.getInt(1);
            String nameStudent = ms.getString(2);
            String exersize = ms.getString(3);
            String nameTeacher = ms.getString(4);
            System.out.println("FIO Studenta: " + nameStudent + " | " + "Exersize: " + exersize + " | " +
                    "Mark: " + m + " | " + "FIO Teacher: " + nameTeacher);
        }
         System.out.println("============================================================================");
        ResultSet avg = stm.executeQuery("select avg(Mark),FIOStudent from student.mark " +
                "right join student.student on Student=idSTUDENT  where idSTUDENT=4");
        while (avg.next()){
            float m = avg.getFloat(1);
            String nameStudent = avg.getString(2);
            System.out.println("FIO Studenta: " + nameStudent + " | " + "Exersize: " +
                    "Mark: " + m);
        }
    }
}
