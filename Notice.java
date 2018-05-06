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
class Notice extends JFrame //implements ActionListener  
   {
	String and; 
	String uname;
	JLabel naam;
    JLabel not;
    JTextArea note;
    DateTimeFormatter dtf ;
   LocalDateTime now;
    JButton post;
	Connection con;
	Statement stmt;
	ResultSet rs;
	String IQuery;
    String d_t;
	Notice(String username)  
        {  
	//	String na,re,ho,ro,wa,d_t;
	JButton b1;
	//JButton b2;
	JButton logout;
        JFrame f= new JFrame("Warden");    
        JPanel panel=new JPanel(); 
	JPanel panel1=new JPanel();  
        panel.setBounds(0,0,500,70);    
        panel.setBackground(Color.black);  
	panel1.setBounds(500,0,700,70);   
        panel1.setBackground(Color.black);  
	JLabel label = new JLabel("HCS");
	label.setFont(new Font("Serif", Font.BOLD, 35));
	label.setForeground(Color.white);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel.add(label);
	logout=new JButton("Logout");
	logout.setForeground(Color.black);
	logout.setOpaque(false);
	logout.setContentAreaFilled(false);	
	logout.setBorderPainted(false);
	logout.setBounds(20,250,150,25);    
	f.add(logout);
    f.add(panel); 

	Image icon = Toolkit.getDefaultToolkit().getImage("Logo.jpg");    
	f.setIconImage(icon); 

		logout.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
                 Pro p=new Pro();
		 		 f.setVisible(false);
        }  
    });  


	b1=new JButton("View Complaint");
	b1.setBounds(20,160,180,30);
	//b2=new JButton("Update Notice");
	//b2.setBounds(20,160,180,30);

	f.add(b1);
	//f.add(b2);   
    b1.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
            
	WCom w=new WCom(username);
     f.setVisible(false);

        }  
    });  
 	f.setSize(1220,700);     
        f.setLayout(null);    
        f.setVisible(true);    
        
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
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
dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
             now = LocalDateTime.now();
not=new JLabel("Notice");
not.setBounds(640,120,100,30);
not.setFont(new Font("Serif", Font.BOLD, 20));
JLabel line=new JLabel("______");
line.setFont(new Font("Serif", Font.BOLD, 20));
line.setBounds(640,120,100,30);
note=new JTextArea();
note.setBounds(330,160,700,250);
JScrollPane sp=new JScrollPane(note);  
sp.setBounds(330,160,700,250);
f.add(sp); 
post=new JButton("Post");
post.setBounds(330,430,80,30);

post.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	P(username);
    }});     


f.add(line);
f.add(not);
//f.add(note);
f.add(post);

 }
 public void P(String username)
 {
     String sql="Select * from n";
        
                 try    {

			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
			stmt=con.createStatement();
			rs = stmt.executeQuery(sql);
                    String noti=note.getText();
                	String wa=and;
            
                    d_t=dtf.format(now);
				
					if(noti==null)
						{	
								String SMessage = ("No Notice !");
					
								JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
						}
					else
					{
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
  						Date date = new Date(); 
				  String f_date=formatter.format(date);
					IQuery = "INSERT INTO n VALUES('"+wa+"', '"+noti+"','"+f_date+"')";
					System.out.println(IQuery);
					System.out.println("Connecting to a selected database...");
					//System.out.println(now);
				System.out.println("Connected database successfully...");
					  System.out.println(noti);
				con.createStatement().execute(IQuery);
				

                     
							String SMessage = "Notice registered on "+dtf.format(now);
					
                            
	                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
					
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
}
	