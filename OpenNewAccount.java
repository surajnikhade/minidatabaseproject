import java.io.*;
import java.sql.*;

class OpenNewAccount
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;
String nm,typ;
double bal;

Connection con;
Statement st;

try
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());
System.out.print("Enter name ");
nm=br.readLine();
System.out.print("Enter account type ");
typ=br.readLine();
System.out.print("Enter balance ");
bal=Double.parseDouble(br.readLine());

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sharayudb?user=root&password=123&useSSL=false");


st=con.createStatement();

st.executeUpdate("insert into accounts values("+no+",'"+nm+"','"+typ+"',"+bal+");");

System.out.println("Account opened successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}








