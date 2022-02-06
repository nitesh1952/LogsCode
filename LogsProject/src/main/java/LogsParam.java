import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class LogsParam {

    String id;
    String state;
    String type;
    String host;
    String timestamp;

    LogsParam(String id,String state,String type, String host,String timestamp)
    {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }
    public static void main(String args[]) throws IOException,ClassNotFoundException, SQLException {


        Connection con = null;
        Statement stmt = null;
        int result = 0;
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        stmt = con.createStatement();
        stmt.executeUpdate("CREATE TABLE Logs (id INT NOT NULL, duration int NOT NULL,type VARCHAR(20), host VARCHAR(20));");

        Scanner in = new Scanner(System.in);
        System.out.println("Ënter the path of file");
        String  string1 = in.next();
        BufferedReader buffreader = new BufferedReader(new FileReader(string1));
        String s2 = "";
        while(buffreader.readLine()!=null) {
            s2 = buffreader.readLine();

            String[] arrsyr = s2.split(",");

            String[] arrstr2 = new String[2];

            Map<String, String> hp = new HashMap<>();

           List<LogsParam> listof = new ArrayList<>();

            Arrays.stream(arrsyr).forEach(s -> {

              hp.put(s.split(":")[0],s.split(":")[1]);

                // stmt.executeUpdate("INSERT INTO Logs VALUES (,'Learn PHP', 'John Poul', NOW())");
            });

        LogsParam logparamers = new LogsParam(hp.get("id"),hp.get("state"),hp.get("type"),hp.get("host"),hp.get("timestamp"));
            listof.add(logparamers);
            hp.clear();



            
           // Here I iterate the list listof to check the record for the id having multiple values and then find the differnece of
            //timespamp between these two record with same id and after iterating through all the logs store that data in hsqldb
            // created above






        }

    }


}


