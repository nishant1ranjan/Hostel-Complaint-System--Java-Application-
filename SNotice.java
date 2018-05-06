import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
class SNotice extends JFrame //implements ActionListener  
   {
	 String and;
	String uname;
	JLabel naam;
	JLabel m_comp;
	Connection con;
	Statement stmt;
	ResultSet rs,rs1;
	String IQuery;
    String wa;
	SNotice(String username)  
        {  
	String no,d_t;
	JButton b1;
	JButton b2;
	JButton logout;
        JFrame f= new JFrame("Check Notice");    
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
	
	Image icon = Toolkit.getDefaultToolkit().getImage("Logo.jpg");    
	f.setIconImage(icon); 


	f.add(panel1); 
	logout=new JButton("Logout");
	logout.setForeground(Color.black);
	logout.setOpaque(false);
	logout.setContentAreaFilled(false);	
	logout.setBorderPainted(false);
	logout.setBounds(20,250,150,25);    
	f.add(logout);
	f.add(panel); 
	
	b1=new JButton("View Complaint");
	b1.setBounds(20,120,180,30);
	b2=new JButton("Complaint");
	b2.setBounds(20,160,180,30);

    
	b2.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
            
	Com not=new Com(username);
	f.setVisible(false);

        }  
    });  
	logout.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
            
	             Pro p=new Pro();
		  f.setVisible(false);
        }  
    });  


	//f.add(b1);
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
        IQuery ="select warden from detail where erno='username'";
		con.createStatement().execute(IQuery);
		wa=rs.getString("warden");
        System.out.println(wa);
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
    System.out.println(wa+" hai");
        
    String sql1="Select * from n";
        
try {
    Class.forName("com.mysql.jdbc.Driver");
    con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
    /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
    String column[]={"Warden","Notice","Date/Time"};   
    int tmp=0;
    String data[][]=new String[100][3];
	  System.out.println(wa+" hai hai");
     
    IQuery ="select * from n where warden='"+wa+"'";
	rs=con.createStatement().executeQuery(IQuery);		
    
    while(rs.next())
 	{
		// wa1=rs.getString("warden");
      
		/*naam = new JLabel("Hello, "+ and);
	naam.setFont(new Font("Serif", Font.BOLD, 15));
	naam.setForeground(Color.white);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel1.add(naam);
 
	f.add(panel1);*/
       
    //IQuery ="select * from n where warden='"+wa+"'";
	//rs=con.createStatement().executeQuery(IQuery);		
       String wa1=rs.getString("warden");
      System.out.println(wa+" hai hello");
          System.out.println(wa1+" hai tu");
     
        no=rs.getString("notice");
		d_t=rs.getString("dateTime");
        data[tmp][0]=wa;
        data[tmp][1]=no;
        data[tmp][2]=d_t;
//new JFrame().setVisible(true);
tmp++;
	}

m_comp=new JLabel("Notice :");
	m_comp.setFont(new Font("Serif", Font.BOLD, 20));
	m_comp.setBounds(230,90,250,30);
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

	



f.setVisible(true);
        
        b1.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
            
	ViewCom not=new ViewCom(username,and);
	f.setVisible(false);

        }  
    });  
    f.add(b1);
        }
        

   }