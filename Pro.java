import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;

public class Pro extends Frame//,Canvas//implements ActionListener
{
     
JFrame f;
JTextField tf;JButton b;
JLabel login,id,pass,line;
JPasswordField value;

JLabel sign,line1,name,mobile,hostel,room,erno,wrdn,pswd;
JTextField na,mo,ho,ro,er;
JButton si;
Choice c;
JPasswordField value1;
Connection con;
Statement stmt;
ResultSet rs;

Pro()
{
	
f=new JFrame("HCS");
login=new JLabel("Login :");
login.setBounds(675,70,80,30);
login.setFont(new Font("Serif", Font.BOLD, 20));
line=new JLabel("_______________________________");
line.setBounds(675,78,500,25);
line.setFont(new Font("Serif", Font.BOLD, 20));

id=new JLabel("Enrollment");
id.setBounds(675,110,65,30);
pass=new JLabel("Password");
pass.setBounds(820,110,100,30);

tf=new JTextField();
tf.setBounds(675,140,125,20);
b=new JButton("Login");
b.setBounds(675,180,70,30);

value = new JPasswordField();   
value.setBounds(820,140,125,20);    
           
Image icon = Toolkit.getDefaultToolkit().getImage("Logo.jpg");    
f.setIconImage(icon); 




sign=new JLabel("Sign Up : ");
sign.setBounds(675,250,100,30);
sign.setFont(new Font("Serif", Font.BOLD, 20));
line1=new JLabel("_______________________________");
line1.setBounds(675,258,500,25);
line1.setFont(new Font("Serif", Font.BOLD, 20));

name=new JLabel("Name : ");
name.setBounds(675,300,65,30);
erno=new JLabel("Enrollment :");
erno.setBounds(675,330,90,30);
mobile=new JLabel("Mobile :");
mobile.setBounds(675,360,100,30);
hostel=new JLabel("Hostel :");
hostel.setBounds(675,390,65,30);
room=new JLabel("Room :");
room.setBounds(675,420,100,30);
wrdn=new JLabel("Warden :");
wrdn.setBounds(675,450,65,30);
pswd=new JLabel("Password :");
pswd.setBounds(675,480,100,30);


na=new JTextField();
na.setBounds(780,305,125,20);
er=new JTextField();
er.setBounds(780,335,125,20);
mo=new JTextField();
mo.setBounds(780,365,125,20);
ho=new JTextField();
ho.setBounds(780,395,125,20);
ro=new JTextField();
ro.setBounds(780,425,125,20);

        c=new Choice();  
        c.setBounds(780,455, 125,20);  
        c.add("Dhananjay Mishra");  
        c.add("KN Gupta");  
        c.add("Nilesh patel");  
		c.add("Rachna Chaudhary");
       

si=new JButton("Sign Up!");
si.setBounds(675,525,80,30);

value1 = new JPasswordField();   
value1.setBounds(780,485,125,20);  	

b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	L();

        }  
    });  

si.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	S();

        }  
    });  



f.add(login);
f.add(id);
f.add(pass);
f.add(line);
f.add(tf);
f.add(value);
f.add(b); 

f.add(sign);
f.add(line1);
f.add(name);
f.add(erno);
f.add(mobile);
f.add(hostel);
f.add(room);
f.add(wrdn);
f.add(pswd);
 

f.add(na);
f.add(er);
f.add(mo);
f.add(ho);
f.add(ro);

f.add(value1); 
f.add(si);
 f.add(c);

f.setSize(1000,700);
f.setLayout(null);
f.setVisible(true);


JPanel panel=new JPanel();  
        panel.setBounds(0,0,1000,70);    
        panel.setBackground(Color.black);  
JLabel label = new JLabel("HCS", JLabel.LEFT);
	label.setFont(new Font("Serif", Font.BOLD, 35));
	label.setForeground(Color.white);
        panel.add(label);
 f.add(panel); 

JLabel j=new JLabel(new ImageIcon("collg1.jpg"));
	//j.setIcon(new ImageIcon("collg1.jpg"));
	j.setBounds(-30,20,700,600);


f.add(j);



f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}


public void L()
{
 //    if (evt.getSource()==b)
   //      {
            String sql="Select * from detail";
try {
Class.forName("com.mysql.jdbc.Driver");
con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
/*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
stmt=con.createStatement();
 rs = stmt.executeQuery(sql);


String user=tf.getText();
String pwd= new String(value.getPassword());

int tmp=0;
while(rs.next())
 {
String uname=rs.getString("erno");
String password=rs.getString("password");

if((user.equals(uname)) && (pwd.equals(password)) && ((uname.equals("2010")) || (uname.equals("2011")) || (uname.equals("2012"))|| (uname.equals("2013"))))
{
		WCom c=new WCom(user);	
		f.setVisible(false);
		tmp++;
}


        else if ((user.equals(uname)) && (pwd.equals(password))) {
		Com c=new Com(user);
		f.setVisible(false);
		tmp++;
    }
}
if (tmp==0) {

JOptionPane.showMessageDialog(null, "Username and Password not in database!");
  
   }
}
catch (Exception q){
JOptionPane.showMessageDialog(null, q);
} 
         }

public void S()
{

	String sql="Select * from detail";
        
                 try    {

			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
			/*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
			stmt=con.createStatement();
			rs = stmt.executeQuery(sql);
                               
				String username = "";
				String password = "";
				String name = "";
                                String mobile = "";
				String warden = "";
                                String hostel = "";
				String room = "";
				
				
				username = er.getText();
				name = na.getText();
				password = new String(value1.getPassword());
				mobile = mo.getText();
                                hostel = ho.getText();
                                room = ro.getText();
                                warden = new String(c.getItem(c.getSelectedIndex()));
                                                         
				if (username.equals(" ")|| password.equals(" ")||name.equals(" ")||mobile.equals(" ")||hostel.equals(" ")||room.equals(" ")||warden.equals(" "))
                                {
                                JOptionPane.showMessageDialog(null,"Field can't be empty","Error",JOptionPane.ERROR_MESSAGE);
				
                                }

				else  
                                {

                                        while(rs.next())
                                        {
                                                String uname=rs.getString("erno");
                                               
                                                if (username.equals(uname)) {
                                                      JOptionPane.showMessageDialog(null,"User already exists","Error",JOptionPane.ERROR_MESSAGE);
                                                
                                                  }
                                        }



                                        
					String IQuery = "INSERT INTO detail VALUES('"+username+"', '"+name+"','"+mobile+"','"+warden+"','"+hostel+"','"+room+"','"+password+"')";
					
					System.out.println("Connecting to a selected database...");
				
				
				//con = (Connection)DriverManager.getConnection(DB_URL, USER, PASS);
				con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
					System.out.println("Connected database successfully...");
					  
				con.createStatement().execute(IQuery);
				

			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f","root","password");
			As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
                       */
							String SMessage = "Record added for "+username;
					
                                       //
	                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
					
					//((java.sql.Connection.conn).close());
					 Pro p=new Pro();
		 		 f.setVisible(false);			
				}				
			}
			catch (SQLException se) 
			{
				
				se.printStackTrace();
			}
			catch (Exception a) 
			{
				a.printStackTrace();
			}
   //      }
   //System.exit(0);
	
}


public static void main(String ar[])
{
new Pro();
}
}