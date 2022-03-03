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
	
	//메뉴,가격,수량,합계 arraylist
	ArrayList<JLabel> name_cart = new ArrayList<>();
	ArrayList<JLabel> price_cart = new ArrayList<>();
	ArrayList<JLabel> amount_cart = new ArrayList<>();
	ArrayList<JLabel> sumlabels = new ArrayList<>();
	
	
	//arraylist 인덱스 
	//메뉴 이름, 가격, 수량은 서로 다른 동적 배열을 사용하지만 각 속성에 대응하는 인덱스를 공유한다.
	//ex) 옥수수식빵 1개 3000원
	//name_cart.get(0) = "옥수수식빵", price_cart.get(0) = "3000", amount_cart.get(0)="1개"
	static int index = 0;
	//금액 합계 계산
	static int sum = 0;
	
	public void panel_cart(JPanel p) {
		//카트 panel을 메인 panel에 추가
		panel_cart.setLayout(null);
		panel_cart.setBounds(0,280,600,300);
		panel_cart.setVisible(false);
		p.add(panel_cart);
		
		//합계 label
		JLabel sumLabel = new JLabel("합계 : " +sum+"");
		//합계 label을 메인 panel에 추가
		sumLabel.setBounds(150, 580, 100, 50);
		sumlabels.add(sumLabel);
		p.add(sumlabels.get(0));
		
		
		
		
	}
	////메뉴 버튼 누를 시 장바구니에 메뉴와 가격 출력, 합계액 추가
	public void action(ArrayList<JButton> a,String[] b, int[] c, int i,JPanel p) {
		//메뉴 버튼이 저장되어 있는 arraylist a와 메뉴 배열b, 가격 배열c, 메뉴버튼 배열의 인덱스i, 메인 패널p을 받아온다
		
		a.get(i).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메뉴버튼 배열의 i번이 눌렸을 때 수행되는 작업
				
				if(name_cart.size()==0) {
					//장바구니에 아무 것도 없을 경우
					
					//장바구니에 메뉴 이름 추가
					name_cart.add(new JLabel(b[i]));
					name_cart.get(index).setBounds(20,40+(index*30),100,20);
					panel_cart.add(name_cart.get(index));
					
					//장바구니에 수량 추가
					amount_cart.add(new JLabel("1개"));
					amount_cart.get(index).setBounds(120,40+(index*30),50,20);
					panel_cart.add(amount_cart.get(index));
					
					//장바구니에 가격 추가
					price_cart.add(new JLabel(c[i]+""));
					price_cart.get(index).setBounds(170,40+(index*30),100,20);
					panel_cart.add(price_cart.get(index));
					
					//메뉴 이름, 가격, 수량의 배열 인덱스에 +1
					index++;
					
					//합계
					sum += c[i];
					p.remove(sumlabels.get(0));
					sumlabels.set(0, new JLabel("합계 : " +sum+""));
					sumlabels.get(0).setBounds(150, 580, 100, 50);
					p.add(sumlabels.get(0));
					
				}
				else{
					//장바구니에 이미 추가된 메뉴가 존재할 경우
					int count =0;
					for(int j = 0; j<name_cart.size();j++) {
					
						if(name_cart.get(j).getText()==b[i]){
							//장바구니에 이미 메뉴가 있을 경우 가격과 수량만 더해준다
							
							int price = Integer.parseInt(price_cart.get(j).getText())+c[i];
							int amount = (int)(price/c[i]);
							
							panel_cart.remove(price_cart.get(j));
							price_cart.set(j, new JLabel(price+""));
							
							panel_cart.remove(amount_cart.get(j));
							amount_cart.set(j, new JLabel(amount+"개"));
							
							price_cart.get(j).setBounds(170,40+(j*30),100,20);
							amount_cart.get(j).setBounds(120,40+(j*30),50,20);
							
							panel_cart.add(price_cart.get(j));
							panel_cart.add(amount_cart.get(j));
							
							
							sum += c[i];
							p.remove(sumlabels.get(0));
							sumlabels.set(0, new JLabel("합계 : " +sum));
							sumlabels.get(0).setBounds(150, 580, 100, 50);
							p.add(sumlabels.get(0));
							
							//중복시 count++
							count++;
							
						}
					
					}
					
					if(count ==0) {
						//장마구니에 해당 메뉴가 없을 경우 
						
						name_cart.add(new JLabel(b[i]));
						name_cart.get(index).setBounds(20,40+(index*30),100,20);
						panel_cart.add(name_cart.get(index));
						
						amount_cart.add(new JLabel("1개"));
						amount_cart.get(index).setBounds(120,40+(index*30),50,20);
						panel_cart.add(amount_cart.get(index));
					
						price_cart.add(new JLabel(c[i]+""));
						price_cart.get(index).setBounds(170,40+(index*30),100,20);
						panel_cart.add(price_cart.get(index));
						
						
						sum += c[i];
						p.remove(sumlabels.get(0));
						sumlabels.set(0, new JLabel("합계 : " +sum+""));
						sumlabels.get(0).setBounds(150, 580, 100, 50);
						p.add(sumlabels.get(0));
						
						
						index++;
					}
				
				}
				//장바구니 panel을 보여준다
				panel_cart.setVisible(true);
				
			}
		});
	}
	
	//마이너스 버튼 누를시 메뉴,가격, 수량 삭제 또는 가격, 수량 감소
	public void minusaction(ArrayList<JButton> a,String[] b, int[] c, int i,JPanel p) {
	
		
		a.get(i).addActionListener(new ActionListener() {
			//마이너스 버튼 배열의 i번 인덱스가 눌렸을 때 작업
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for(int j = 0; j<name_cart.size();j++) {
					
					if(name_cart.get(j).getText()==b[i]){
						//장바구니에 메뉴가 존재할 경우
						int price = Integer.parseInt(price_cart.get(j).getText())-c[i];
						int amount = (int)(price/c[i]);
						sum -= c[i];
						
						p.remove(sumlabels.get(0));
						sumlabels.set(0, new JLabel("합계 : " +sum+""));
						sumlabels.get(0).setBounds(150, 580, 100, 50);
						p.add(sumlabels.get(0));
						if(price ==0) {
							//장바구니에 메뉴가 1개 담겨있을 경우 마이너스 버튼을 누르면 장바구니에서 삭제한다.
							panel_cart.remove(price_cart.get(j));
							panel_cart.remove(name_cart.get(j));
							panel_cart.remove(amount_cart.get(j));
							
							price_cart.remove(j);
							name_cart.remove(j);
							amount_cart.remove(j);
							
							
							if(name_cart.size()>0) {
								//장바구니에 메뉴가 삭제되어 생긴 빈 공간에 남은 메뉴 정렬
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
							//장바구니에 존재하는 메뉴가 2개 이상일때 가격과 수량만 변경한다.
							
							panel_cart.remove(price_cart.get(j));
							panel_cart.remove(amount_cart.get(j));
							
							price_cart.set(j, new JLabel(price+""));
							price_cart.get(j).setBounds(200,40+(j*30),100,20);
							
							amount_cart.set(j,new JLabel(amount+"개"));
							amount_cart.get(j).setBounds(120,40+(j*30),100,20);
							
							panel_cart.add(price_cart.get(j));
							panel_cart.add(amount_cart.get(j));
							
							
							
						
						}
					}
				}
					
				//장바구니panel을 보여준다.
				panel_cart.setVisible(true);
				
			}
		});
	}
	
	
	
		
	
}



