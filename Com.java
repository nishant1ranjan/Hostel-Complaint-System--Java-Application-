import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
class Com extends JFrame implements ActionListener{  
JRadioButton rb1,rb2,rb3,rb4,rb5;    
JButton b;
JFrame f;
DateTimeFormatter dtf ;
   LocalDateTime now;

String and; 
String uname;
Connection con;
Statement stmt;
ResultSet rs;
String IQuery;


     Com(String username)  
        {  
			
	JLabel m_comp;
	//JButton b1;
	JButton b2;
	JButton b3;
	JLabel naam;
	JButton logout;
	f= new JFrame("Complaint kro");    
        JPanel panel=new JPanel(); 
	JPanel panel1=new JPanel();  
        panel.setBounds(0,0,500,70);    
        panel.setBackground(Color.black);  
	panel1.setBounds(500,0,500,70);    
        panel1.setBackground(Color.black);  
	JLabel label = new JLabel("HCS");
	label.setFont(new Font("Serif", Font.BOLD, 35));
	label.setForeground(Color.white);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel.add(label);
 
	Image icon = Toolkit.getDefaultToolkit().getImage("Logo.jpg");    
	f.setIconImage(icon); 


	f.add(panel); 
	f.add(panel1); 
	//f.add(logout);
	//b1=new JButton("Complaint");
	//b1.setBounds(20,120,150,30);
	m_comp=new JLabel("Make a Complaint :");
	m_comp.setFont(new Font("Serif", Font.BOLD, 20));
	m_comp.setBounds(350,90,250,30);
	b2=new JButton("View Complaints");
	b2.setBounds(20,160,150,30);
	b3=new JButton("Notice");
	b3.setBounds(20,200,150,30);

	logout=new JButton("Logout");
	logout.setForeground(Color.black);
	logout.setOpaque(false);
	logout.setContentAreaFilled(false);	
	logout.setBorderPainted(false);
	logout.setBounds(20,250,150,25);    

/*	b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.setBorderPainted(false);*/
//f.add(b1);
f.add(b2);   
f.add(b3);   
f.add(m_comp);
f.add(logout);		


   String sql="Select * from detail";
try {
Class.forName("com.mysql.jdbc.Driver");
con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
/*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
stmt=con.createStatement();
 rs = stmt.executeQuery(sql);


//String user=tf.getText();
//String pwd= new String(value.getPassword());

int tmp=0;
while(rs.next())
 {
uname=rs.getString("erno");

        if (username.equals(uname) ) {
		String IQuery ="select name from detail where erno='username'";
		con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
		con.createStatement().execute(IQuery);
		and=rs.getString("name");
	naam = new JLabel("Hello, "+ and);
	naam.setFont(new Font("Serif", Font.BOLD, 15));
	naam.setForeground(Color.white);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel1.add(naam);
 
	f.add(panel1); 
	
//new JFrame().setVisible(true);
tmp++;
    }
}
if (tmp==0) {

JOptionPane.showMessageDialog(null, "Not in database!");
  
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


    
rb1=new JRadioButton("Electricity");    
rb1.setBounds(350,120,100,30);      
rb2=new JRadioButton("Lan / Wifi");    
rb2.setBounds(350,150,100,30);    
rb3=new JRadioButton("Furniture");    
rb3.setBounds(350,180,100,30);      
rb4=new JRadioButton("Cleaning");    
rb4.setBounds(350,210,100,30);    
rb5=new JRadioButton("Duct");    
rb5.setBounds(350,240,100,30);    
b=new JButton("Submit");    
b.setBounds(350,310,80,30);     
logout.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	log_out();

        }  
    });     
b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	S(username,and);

        }  
    });     
b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	ViewCom c=new ViewCom(username,and);
	f.setVisible(false);

        }  
    });   

	b3.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	SNotice c=new SNotice(username);
	f.setVisible(false);

        }  
    });   
f.add(rb1);f.add(rb2);f.add(rb3);f.add(rb4);f.add(rb5);f.add(b);
 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
  now = LocalDateTime.now();
   
	     
       	        f.setSize(1020,700);    
                f.setLayout(null);    
                f.setVisible(true);    
        
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

public void actionPerformed(ActionEvent e){    
 // JOptionPane.showMessageDialog(this, dtf.format(now));     
}    

public void S(String enroll,String name)
{
	
System.out.println("COM se");
System.out.println(enroll);
	String sql="Select * from detail";
        
                 try    {

			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
			stmt=con.createStatement();
			rs = stmt.executeQuery(sql);
                String ca = "";
				String wa = "";
                String ho = "";
				String ro = "";
				String d_t = "";
				//System.out.print("1");
				int tmp=0;
				 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
  				Date date = new Date(); 
				  String f_date=formatter.format(date); 
				while(rs.next())
                {
							uname=rs.getString("erno");
						      if (enroll.equals(uname) ) 
							  {
								IQuery ="select hostel from detail where erno='username'";
								con.createStatement().execute(IQuery);
								ho=rs.getString("hostel");
								
								IQuery ="select room from detail where erno='username'";
								con.createStatement().execute(IQuery);
								ro=rs.getString("room");
								
								IQuery ="select warden from detail where erno='username'";
								con.createStatement().execute(IQuery);
								wa=rs.getString("warden");

								 d_t=dtf.format(now);
								if(rb1.isSelected())
								{  
          							 ca=((rb1) .getText().toString());
									 
								}  
								if(rb2.isSelected())
								{  
          							 ca=((rb2) .getText().toString());
								} 
								if(rb3.isSelected())
								{ 
          							 ca=((rb3) .getText().toString());
								} 
								if(rb4.isSelected())
								{  
          							 ca=((rb4) .getText().toString());
								} 
								if(rb5.isSelected())
								{  
          							 ca=((rb5) .getText().toString());


											
  					  			}
									tmp++;
							  }
				}
					if(tmp==0)
						{	
								String SMessage = ("Nothing Selected !");
					
								JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
						}
					else
					{
					IQuery = "INSERT INTO comp VALUES('"+enroll+"', '"+name+"','"+ca+"','"+ho+"','"+ro+"','"+wa+"','"+f_date+"')";
					System.out.println(IQuery);
					System.out.println("Connecting to a selected database...");
					//System.out.println(now);
				System.out.println("Connected database successfully...");
					  
				con.createStatement().execute(IQuery);
				

                     
							String SMessage = "Complaint Registered for "+enroll+" on "+dtf.format(now);
					
                            
	                    JOptionPane.showMessageDialog(f,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
					
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

}

public void log_out()
{
	       Pro p=new Pro();
		  f.setVisible(false);
}
}  