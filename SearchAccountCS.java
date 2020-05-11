import java.io.*;
import java.sql.*;

class SearchAccountCS
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;

Connection con;
CallableStatement cst;
ResultSet rs;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/visadb0645?user=root&password=123&useSSL=false");

cst=con.prepareCall("{call getaccountname(?)}");

System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());

cst.setInt(1,no);

rs=cst.executeQuery();

if(rs.next())
System.out.println(rs.getString(1));
else
System.out.println("account does not exist");

con.close();

}
catch(Exception e)
{
System.out.println(e);
}

}
}
