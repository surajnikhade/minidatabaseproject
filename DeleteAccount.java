import java.sql.*;
import java.io.*;

class DeleteAccount
{
public static void main(String args[])
{
int no,cnt;

Connection con;
PreparedStatement pst;

InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

try
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=123&useSSL=false");

pst=con.prepareStatement("delete from accounts where accno=?;");
pst.setInt(1,no);
cnt=pst.executeUpdate();

if(cnt>0)
System.out.println("account deleted successfully");
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















