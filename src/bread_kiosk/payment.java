package bread_kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import practice.login;


public class payment {
	ArrayList<JLabel>disArrayList = new ArrayList<>();
	ArrayList<JLabel>accArrayList = new ArrayList<>();
	
	
	public payment(JPanel p,JPanel p1, JPanel p2, JPanel p3) {
		// TODO Auto-generated constructor stub
		
		
		JButton paymentButton = new JButton("결제");
		paymentButton.setBounds(0,580,100,50);
		p.add(paymentButton);
		
		
		JPanel discountaccumulatePanel = new JPanel();
		discountaccumulatePanel.setLayout(null);
		discountaccumulatePanel.setBounds(0, 40, 600, 300);
		discountaccumulatePanel.setBackground(Color.blue);
		discountaccumulatePanel.setVisible(false);
		
		
		
		
		
		JButton discountButton = new JButton("할인");
		JButton accuButton=new JButton("적립");
		JButton xButton = new JButton("x");
		JButton realpay = new JButton("결제");
		
		
		
		
		xButton.setBackground(Color.red);
		xButton.setForeground(Color.white);
		xButton.setBounds(540,0,50,50);
		discountaccumulatePanel.add(xButton);
		
		discountButton.setBounds(100,100,100,100);
		discountaccumulatePanel.add(discountButton);
		
		accuButton.setBounds(250,100,100,100);
		discountaccumulatePanel.add(accuButton);
		
		realpay.setBounds(400,100,100,100);
		discountaccumulatePanel.add(realpay);
		
	
		paymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				p.add(discountaccumulatePanel);
				
				if(disArrayList.size() != 0) {
					
					discountaccumulatePanel.remove(disArrayList.get(0));
					disArrayList.remove(0);
				}
				if(accArrayList.size() !=0) {
					discountaccumulatePanel.remove(accArrayList.get(0));
					accArrayList.remove(0);
				}
				discountaccumulatePanel.setVisible(true);
				discountButton.setVisible(true);
				accuButton.setVisible(true);
				realpay.setVisible(true);
			}
		});
		
		xButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				discountaccumulatePanel.setVisible(false);
				
			}
		});
		
		discountButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				discountButton.setVisible(false);
				JLabel disJLabel = new JLabel("<html>할인되어<br>"+discount(cart.sum)+"원입니다</html>");
				disArrayList.add(disJLabel);
				disArrayList.get(0).setBounds(100,100,100,100);
				discountaccumulatePanel.add(disArrayList.get(0));
			}
		});
		accuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				accuButton.setVisible(false);
				JLabel accLabel = new JLabel("<html>"+accumulate(cart.sum)+"원이<br>적립되었습니다</html>");
				accArrayList.add(accLabel);
				accArrayList.get(0).setBounds(250,100,100,100);
				discountaccumulatePanel.add(accArrayList.get(0));
			}
		});
	}

	
	
	
	
	public int discount(int sum) {
		sum = sum - (int)(sum*0.1);
		return sum;
	}
	public int accumulate(int sum) {
		int accu = (int)(sum*0.1);
		return accu;
	}
	

}
