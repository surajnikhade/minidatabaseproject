import java.io.*;
import java.sql.*;

class Transactions
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;
String typ;
double amt;

Connection con;
PreparedStatement pst;

try
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());
System.out.print("Enter transaction type ");
typ=br.readLine();
System.out.print("Enter amount ");
amt=Double.parseDouble(br.readLine());

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=123&useSSL=false");

if(typ.equalsIgnoreCase("deposit"))
pst=con.prepareStatement("update accounts set balance=balance+? where accno=?;");
else
pst=con.prepareStatement("update accounts set balance=balance-? where accno=? and balance>=?;");

pst.setDouble(1,amt);
pst.setInt(2,no);

if(!typ.equalsIgnoreCase("deposit"))
pst.setDouble(3,amt);

int cnt=pst.executeUpdate();

if(cnt>0)
System.out.println("balance updated successfully");
else
System.out.println("transaction failed..account does not exist or insufficient funds");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}