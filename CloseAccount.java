import java.io.*;
import java.sql.*;

class CloseAccount
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;

Connection con;
PreparedStatement pst;

try
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?user=root&password=123&useSSL=false");

pst=con.prepareStatement("delete from accounts where accno=?;");

pst.setInt(1,no);

int cnt=pst.executeUpdate();

if(cnt>0)
System.out.println("account deleted and copied successfully");
else
System.out.println("transaction failed..account does not exist");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}