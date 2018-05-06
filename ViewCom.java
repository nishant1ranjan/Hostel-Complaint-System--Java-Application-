import java.awt.*;  
import java.sql.*;
import javax.swing.*;  
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.*;
class ViewCom extends JFrame// implements ActionListener  
   {
	   String val;
	ResultSet rs;
	//JScrollPane sp;
	ViewCom(String username,String and)  
        {  
	JButton b1;
	JLabel m_comp;
	JButton b3;
	JButton logout;
	String uname;
	Connection con;
	Statement stmt;
	JLabel naam;
	String IQuery;

	String na,re,ho,ro,wa,d_t;
	
	//List<Q> list=new ArrayList<Q>();
        JFrame f= new JFrame("View Complaint");    
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
	naam = new JLabel("Hello, "+ and);
	naam.setFont(new Font("Serif", Font.BOLD, 15));
	naam.setForeground(Color.white);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel1.add(naam);
 
	f.add(panel1); 
		
	Image icon = Toolkit.getDefaultToolkit().getImage("Logo.jpg");    
	f.setIconImage(icon); 


	logout=new JButton("Logout");
	logout.setForeground(Color.black);
	logout.setOpaque(false);
	logout.setContentAreaFilled(false);	
	logout.setBorderPainted(false);
	logout.setBounds(20,250,150,25);    
		logout.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
          Pro p=new Pro();
		  f.setVisible(false);
        }  
    });  

	val=username;

 try {
    Class.forName("com.mysql.jdbc.Driver");
    con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/f","root","");
    /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
    String column[]={"Enrollment","Name","Reason","Hostel","Room","Warden","Date/Time"};   
    int tmp=0;
    String data[][]=new String[100][7];
	IQuery ="select * from comp where erno='"+val+"'";
	rs=con.createStatement().executeQuery(IQuery);	
	while(rs.next())
 	{
		 and=rs.getString("erno");
        na=rs.getString("name");
		/*naam = new JLabel("Hello, "+ and);
	naam.setFont(new Font("Serif", Font.BOLD, 15));
	naam.setForeground(Color.white);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel1.add(naam);
 
	f.add(panel1);*/ 
		
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

m_comp=new JLabel("View Ur Complaints :");
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

	
	f.add(panel); 
	f.add(panel1); 
	f.add(logout);
	b1=new JButton("Complaint");
	b1.setBounds(20,160,180,30);
	b3=new JButton("Notice");
	b3.setBounds(20,200,180,30);
	//b2=new JButton("View Complaint");
	//b2.setBounds(20,160,180,30);

f.add(b1);
//f.add(b2);   
f.add(b3);   

	b1.addActionListener(new ActionListener(){  
  	public void actionPerformed(ActionEvent e){  
          Com m=new Com(username);  
		f.setVisible(false);
        }  
    });  

	b3.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            
	SNotice c=new SNotice(username);
	f.setVisible(false);

        }  
    });   

         	        f.setSize(1220,700);    
                f.setLayout(null);    
                f.setVisible(true);    
        
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}  