package bread_kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import d0207.for_multiplication_table;
import d0211.instance_test;
import d0211.static_test;

public class cart extends JFrame {

	
	JPanel panel_cart = new JPanel();
	
	//�޴�,����,����,�հ� arraylist
	ArrayList<JLabel> name_cart = new ArrayList<>();
	ArrayList<JLabel> price_cart = new ArrayList<>();
	ArrayList<JLabel> amount_cart = new ArrayList<>();
	ArrayList<JLabel> sumlabels = new ArrayList<>();
	
	
	//arraylist �ε��� 
	//�޴� �̸�, ����, ������ ���� �ٸ� ���� �迭�� ��������� �� �Ӽ��� �����ϴ� �ε����� �����Ѵ�.
	//ex) �������Ļ� 1�� 3000��
	//name_cart.get(0) = "�������Ļ�", price_cart.get(0) = "3000", amount_cart.get(0)="1��"
	static int index = 0;
	//�ݾ� �հ� ���
	static int sum = 0;
	
	public void panel_cart(JPanel p) {
		//īƮ panel�� ���� panel�� �߰�
		panel_cart.setLayout(null);
		panel_cart.setBounds(0,280,600,300);
		panel_cart.setVisible(false);
		p.add(panel_cart);
		
		//�հ� label
		JLabel sumLabel = new JLabel("�հ� : " +sum+"");
		//�հ� label�� ���� panel�� �߰�
		sumLabel.setBounds(150, 580, 100, 50);
		sumlabels.add(sumLabel);
		p.add(sumlabels.get(0));
		
		
		
		
	}
	////�޴� ��ư ���� �� ��ٱ��Ͽ� �޴��� ���� ���, �հ�� �߰�
	public void action(ArrayList<JButton> a,String[] b, int[] c, int i,JPanel p) {
		//�޴� ��ư�� ����Ǿ� �ִ� arraylist a�� �޴� �迭b, ���� �迭c, �޴���ư �迭�� �ε���i, ���� �г�p�� �޾ƿ´�
		
		a.get(i).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �޴���ư �迭�� i���� ������ �� ����Ǵ� �۾�
				
				if(name_cart.size()==0) {
					//��ٱ��Ͽ� �ƹ� �͵� ���� ���
					
					//��ٱ��Ͽ� �޴� �̸� �߰�
					name_cart.add(new JLabel(b[i]));
					name_cart.get(index).setBounds(20,40+(index*30),100,20);
					panel_cart.add(name_cart.get(index));
					
					//��ٱ��Ͽ� ���� �߰�
					amount_cart.add(new JLabel("1��"));
					amount_cart.get(index).setBounds(120,40+(index*30),50,20);
					panel_cart.add(amount_cart.get(index));
					
					//��ٱ��Ͽ� ���� �߰�
					price_cart.add(new JLabel(c[i]+""));
					price_cart.get(index).setBounds(170,40+(index*30),100,20);
					panel_cart.add(price_cart.get(index));
					
					//�޴� �̸�, ����, ������ �迭 �ε����� +1
					index++;
					
					//�հ�
					sum += c[i];
					p.remove(sumlabels.get(0));
					sumlabels.set(0, new JLabel("�հ� : " +sum+""));
					sumlabels.get(0).setBounds(150, 580, 100, 50);
					p.add(sumlabels.get(0));
					
				}
				else{
					//��ٱ��Ͽ� �̹� �߰��� �޴��� ������ ���
					int count =0;
					for(int j = 0; j<name_cart.size();j++) {
					
						if(name_cart.get(j).getText()==b[i]){
							//��ٱ��Ͽ� �̹� �޴��� ���� ��� ���ݰ� ������ �����ش�
							
							int price = Integer.parseInt(price_cart.get(j).getText())+c[i];
							int amount = (int)(price/c[i]);
							
							panel_cart.remove(price_cart.get(j));
							price_cart.set(j, new JLabel(price+""));
							
							panel_cart.remove(amount_cart.get(j));
							amount_cart.set(j, new JLabel(amount+"��"));
							
							price_cart.get(j).setBounds(170,40+(j*30),100,20);
							amount_cart.get(j).setBounds(120,40+(j*30),50,20);
							
							panel_cart.add(price_cart.get(j));
							panel_cart.add(amount_cart.get(j));
							
							
							sum += c[i];
							p.remove(sumlabels.get(0));
							sumlabels.set(0, new JLabel("�հ� : " +sum));
							sumlabels.get(0).setBounds(150, 580, 100, 50);
							p.add(sumlabels.get(0));
							
							//�ߺ��� count++
							count++;
							
						}
					
					}
					
					if(count ==0) {
						//�帶���Ͽ� �ش� �޴��� ���� ��� 
						
						name_cart.add(new JLabel(b[i]));
						name_cart.get(index).setBounds(20,40+(index*30),100,20);
						panel_cart.add(name_cart.get(index));
						
						amount_cart.add(new JLabel("1��"));
						amount_cart.get(index).setBounds(120,40+(index*30),50,20);
						panel_cart.add(amount_cart.get(index));
					
						price_cart.add(new JLabel(c[i]+""));
						price_cart.get(index).setBounds(170,40+(index*30),100,20);
						panel_cart.add(price_cart.get(index));
						
						
						sum += c[i];
						p.remove(sumlabels.get(0));
						sumlabels.set(0, new JLabel("�հ� : " +sum+""));
						sumlabels.get(0).setBounds(150, 580, 100, 50);
						p.add(sumlabels.get(0));
						
						
						index++;
					}
				
				}
				//��ٱ��� panel�� �����ش�
				panel_cart.setVisible(true);
				
			}
		});
	}
	
	//���̳ʽ� ��ư ������ �޴�,����, ���� ���� �Ǵ� ����, ���� ����
	public void minusaction(ArrayList<JButton> a,String[] b, int[] c, int i,JPanel p) {
	
		
		a.get(i).addActionListener(new ActionListener() {
			//���̳ʽ� ��ư �迭�� i�� �ε����� ������ �� �۾�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for(int j = 0; j<name_cart.size();j++) {
					
					if(name_cart.get(j).getText()==b[i]){
						//��ٱ��Ͽ� �޴��� ������ ���
						int price = Integer.parseInt(price_cart.get(j).getText())-c[i];
						int amount = (int)(price/c[i]);
						sum -= c[i];
						
						p.remove(sumlabels.get(0));
						sumlabels.set(0, new JLabel("�հ� : " +sum+""));
						sumlabels.get(0).setBounds(150, 580, 100, 50);
						p.add(sumlabels.get(0));
						if(price ==0) {
							//��ٱ��Ͽ� �޴��� 1�� ������� ��� ���̳ʽ� ��ư�� ������ ��ٱ��Ͽ��� �����Ѵ�.
							panel_cart.remove(price_cart.get(j));
							panel_cart.remove(name_cart.get(j));
							panel_cart.remove(amount_cart.get(j));
							
							price_cart.remove(j);
							name_cart.remove(j);
							amount_cart.remove(j);
							
							
							if(name_cart.size()>0) {
								//��ٱ��Ͽ� �޴��� �����Ǿ� ���� �� ������ ���� �޴� ����
								for(int i = 0; i<price_cart.size();i++) {
									panel_cart.remove(price_cart.get(i));
									panel_cart.remove(name_cart.get(i));
									panel_cart.remove(amount_cart.get(i));
								
									price_cart.get(i).setBounds(200,40+(i*30),100,20);
									name_cart.get(i).setBounds(20,40+(i*30),100,20);
									amount_cart.get(i).setBounds(120,40+(i*30),50,20);
									
									panel_cart.add(price_cart.get(i));
									panel_cart.add(name_cart.get(i));
									panel_cart.add(amount_cart.get(i));
								}
							
								
							}
							
							index--;
						}
						
						else {
							//��ٱ��Ͽ� �����ϴ� �޴��� 2�� �̻��϶� ���ݰ� ������ �����Ѵ�.
							
							panel_cart.remove(price_cart.get(j));
							panel_cart.remove(amount_cart.get(j));
							
							price_cart.set(j, new JLabel(price+""));
							price_cart.get(j).setBounds(200,40+(j*30),100,20);
							
							amount_cart.set(j,new JLabel(amount+"��"));
							amount_cart.get(j).setBounds(120,40+(j*30),100,20);
							
							panel_cart.add(price_cart.get(j));
							panel_cart.add(amount_cart.get(j));
							
							
							
						
						}
					}
				}
					
				//��ٱ���panel�� �����ش�.
				panel_cart.setVisible(true);
				
			}
		});
	}
	
	
	
		
	
}



