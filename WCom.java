import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
class WCom extends JFrame //implements ActionListener  
   {
	String and; 
	String uname;
	JLabel naam;
	JLabel m_comp;
	Connection con;
	Statement stmt;
	ResultSet rs,rs1;
	String IQuery;

	WCom(String username)  
        {  
	String na,re,ho,ro,wa,d_t;
	JButton b2;
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

	b2=new JButton("Update Notice");
	b2.setBounds(20,160,180,30);

	b2.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
            
	Notice not=new Notice(username);
	f.setVisible(false);

        }  
    });  
	logout.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
            
	             Pro p=new Pro();
		  f.setVisible(false);
        }  
    });  


	
	f.add(b2);   
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
	
	 try {
    Class.forName("com.mysql.jdbc.Driver");
    con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
    /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
    String column[]={"Enrollment","Name","Reason","Hostel","Room","Warden","Date/Time"};   
    int tmp=0;
    String data[][]=new String[100][7];
	IQuery ="select * from comp where warden='"+and+"'";
	rs=con.createStatement().executeQuery(IQuery);	
	while(rs.next())
	{
		
	and=rs.getString("erno");
	na=rs.getString("name");
        re=rs.getString("reason");	
        ho=rs.getString("hostel");
        ro=rs.getString("room");
        wa=rs.getString("warden");
	d_t=rs.getString("dateTime");
        data[tmp][0]=and;
        data[tmp][1]=na;
        data[tmp][2]=re;
        data[tmp][3]=ho;
        data[tmp][4]=ro;
        data[tmp][5]=wa;
        data[tmp][6]=d_t;
//new JFrame().setVisible(true);
tmp++;
	}
m_comp=new JLabel("Complaints Registered :");
	m_comp.setFont(new Font("Serif", Font.BOLD, 20));
	m_comp.setBounds(230,90,300,30);
	f.add(m_comp);
    JTable jt=new JTable(data,column);    
         jt.setBounds(230,120,950,550);    
		 //f.add(jt);
    JScrollPane sp=new JScrollPane(jt);  
	sp.setBounds(230,120,950,550);  
    f.add(sp);         
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

	
	
	}
}  