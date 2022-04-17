import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javafx.*;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public static String[]   traderName;
	public static Integer[]  quantity;
	public static String[]   cropname;
	public static String[]   croptype;
	public static Integer[]  price;
	public static Object[][] data;
	public static DefaultTableModel model;
	public static String[] columns = { " Trader Name "," Crop Type " , " Crop Name " , "Required Quantity" , "Price" ,};
	public static JTable table;
	
	
	private static JScrollPane jps;
	private static Connection conn;
	private static int total = 0;
	
	MainPanel()
	{
		super(new GridLayout(1,0));
		connDB();
		price       = new Integer[getTotalad()];
		cropname 	= new String[getTotalad()];
		croptype   = new String[getTotalad()];
		traderName  = new String[getTotalad()];
		quantity    = new Integer[getTotalad()];
		data = new String[getTotalad()][5];
		getData();
		
	       this.setBackground(new Color(100,100,160));
	       this.setBounds(10,10,400 ,420);
	       //this.setLayout(null);
	       this.setVisible(false);
	       this.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Advertisements", TitledBorder.CENTER, TitledBorder.TOP));
		   
	       table = new JTable(data,columns);
		
		table.setPreferredScrollableViewportSize(new Dimension(300,300));
		table.setRowHeight(40);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.GRAY);
		
		jps = new JScrollPane(table);
		//jps.setBounds(20, 20, 300, 300);
		add(jps);
		
	
		
		for(int i = 0 ; i < data.length ; i++ )
		{
			System.out.println();
		 	System.out.print("\ttrader name = : " + data[i][0]);
		 	System.out.print("\tcroptype = " + data[i][1]);
		 	System.out.print("\tcropname  = " + data[i][2]);
		 	System.out.print("\tprice  = " + data[i][3]);
		 	System.out.print("\tquantity  = " + data[i][4]);
		}
		System.out.println("\nTable has been created .!");
	}
	
	public void connDB()
    {
          
               try{
            	   Class.forName("com.mysql.cj.jdbc.Driver");
   	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/ecaa" , "root" , "root"  ); 
               	  }
             catch(Exception e){  e.printStackTrace(); }
  }
	
	
	public static void getData()
	{
		Statement stm;
		try {
			stm = conn.createStatement();  
	        String sql1  = "select * from ecaa.ads";
	        ResultSet rs = stm.executeQuery(sql1);
	        int x =0;
	        while(rs.next())
	        {
	        	traderName[x] = rs.getString(2);
	        	croptype[x] =  rs.getString(3);//Croptype
		        cropname[x] =  rs.getString(4);//CropName
		        quantity[x] =  rs.getInt(5);//Required Quantity	
		        price[x]    =  rs.getInt(6);//Price		       
		        x++;
	        }
	        
	        for(int i = 0 ; i < data.length; i++)
			{
	        	data[i][0]= traderName[i];
	        	data[i][1]= croptype[i];
	        	data[i][2]= cropname[i];
				data[i][3] = String.valueOf(quantity[i]); 
				data[i][4] = String.valueOf(price[i]);
			}
	        System.out.println("Query successfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getTotalUser()
	{
		Statement stm;
		try {
			stm = conn.createStatement();
			String sql = "select traderId from ecaa.trader order by traderid desc;";
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			total = rs.getInt(1);
			
			//for(int i = 0 ; i < )
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	public static int getTotalad()
	{
		Statement stm;
		try {
			stm = conn.createStatement();
			String sql = "select Adnum from ecaa.ads order by AdNum desc;";
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			total = rs.getInt(1);
			
			//for(int i = 0 ; i < )
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	

}

