package bread_kiosk;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import d0207.for_multiplication_table;
import d0211.static_test;
import java.awt.Color;

public class bread_test {
	private static final ActionListener ActionListener = null;

	static int si = 0;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bread_test window = new bread_test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bread_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 50, 600, 230);
		panel_1.setLayout(null);
		panel.add(panel_1);
		panel_1.setVisible(false);
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 50, 600, 230);
		panel_2.setLayout(null);
		panel.add(panel_2);
		panel_2.setVisible(false);
		
		JPanel panel_3= new JPanel();
		panel_3.setBounds(0, 50, 600, 230);
		panel_3.setLayout(null);
		panel.add(panel_3);
		panel_3.setVisible(false);
		
		cart cb=new cart();
		cb.panel_cart(panel);
		
		new payment(panel, panel_1, panel_2, panel_3);
		
		
		ArrayList<JLabel> cartnameLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> cartpriceLabels = new ArrayList<>();
		
		
		
		//대분류
		ArrayList<JButton> sicdeca= new ArrayList<>();
		String[] sicdecaname = {"식사빵", "디저트", "케이크"};
				
		int max = 3;
		for(int i = 0; i<max; i++) {
			sicdeca.add(new JButton(sicdecaname[i]));
			sicdeca.get(i).setBounds(150+(i*100),5,85,30);
			panel.add(sicdeca.get(i));
					
		}
		//db
		bread_db db = new bread_db();
		
		//식사빵
		ArrayList<JLabel> siclabel = new ArrayList<JLabel>();
		ArrayList<JButton> sicbutton = new ArrayList<JButton>();
		ArrayList<JButton> sicminus = new ArrayList<>();
		
		makejbutton sic= new makejbutton(siclabel, sicbutton, db.sic_1, db.sic_2, panel_1, db.sic_3);
		panel_1.setLayout(null);
		
		makeactionlistening sicaction = new makeactionlistening(sicdeca, 0, panel_1, panel_2, panel_3);
		
		for(int i = 0; i<sicbutton.size();i++){
			
			cb.action(sicbutton,db.sic_4,db.sic_3,i,panel);
			
			
		}
		
		new makejbutton(sicminus, db.sic_2, panel_1);
		
		for(int i = 0; i<sicminus.size();i++) {
			cb.minusaction(sicminus, db.sic_4, db.sic_3, i,panel);
			
		}
		
		//디저트
		ArrayList<JLabel> delabel = new ArrayList<JLabel>();
		ArrayList<JButton> debutton = new ArrayList<JButton>();
		ArrayList<JButton> deminus=new ArrayList<JButton>();
		
		makejbutton de= new makejbutton(delabel, debutton, db.de_1, db.de_2, panel_2, db.de_3);
		panel_2.setLayout(null);
		
		makeactionlistening deaction = new makeactionlistening(sicdeca, 1, panel_2, panel_1, panel_3);
		
		for(int i = 0; i<debutton.size();i++){
			
			cb.action(debutton,db.de_4,db.de_3,i,panel);
			
		}
		new makejbutton(deminus, db.de_2, panel_2);
		
		for(int i = 0; i<deminus.size();i++) {
			cb.minusaction(deminus, db.de_4, db.de_3, i,panel);
		}
		
		
		//케이크
		ArrayList<JLabel> calabel = new ArrayList<JLabel>();
		ArrayList<JButton> cabutton = new ArrayList<JButton>();
		ArrayList<JButton> caminus =new ArrayList<>();
		
		makejbutton ca= new makejbutton(calabel, cabutton, db.ca_1, db.ca_2, panel_3, db.ca_3);
		panel_3.setLayout(null);
		
		makeactionlistening caction = new makeactionlistening(sicdeca, 2, panel_3, panel_1, panel_2);
		
		for(int i = 0; i<cabutton.size();i++){
			
			cb.action(cabutton,db.ca_4,db.ca_3,i,panel);
			
			
		}
		new makejbutton(caminus, db.ca_2, panel_3);
		
		for(int i = 0; i<caminus.size();i++) {
			cb.minusaction(caminus, db.ca_4, db.ca_3, i,panel);
			
		}
		
		
		
		
	}

}
