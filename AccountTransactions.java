import java.sql.*;
import java.io.*;

class AccountTransactions
{
public static void main(String args[])
{
int no,cnt;
String trtype;
double amt;

Connection con;
PreparedStatement pst;

InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

try
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());
System.out.print("Enter transaction type (deposit/withdraw) ");
trtype=br.readLine();
System.out.print("Enter amount ");
amt=Double.parseDouble(br.readLine());

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?user=root&password=123&useSSL=false");

if(trtype.equals("deposit"))
{
pst=con.prepareStatement("update accounts set balance=balance+? where accno=?;");
}
else
{
pst=con.prepareStatement("update accounts set balance=balance-? where accno=?;");
}
pst.setDouble(1,amt);
pst.setInt(2,no);
cnt=pst.executeUpdate();
if(cnt>0)
System.out.println("balance updated successfully");
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















