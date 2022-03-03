package bread_kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import d0207.for_multiplication_table;

public class makejbutton {
	JPanel panel_cart = new JPanel();
	JLabel label_cart = new JLabel();
	
	
	
	//메뉴 버튼
	public makejbutton(ArrayList<JLabel> a, ArrayList<JButton> b, String[] c, String[][] d,JPanel e,int[] f) {
		// TODO Auto-generated constructor stub
		//중분류 메뉴 이름이 담길 배열a, 소분류 메뉴 가격이 담길 배열b, 중분류 배열c, 소분류 배열d, 중분류 패널 e, 가격배열f
		int index =0;
		for(int j = 0; j<c.length;j++) {
			//중분류 label생성후 배열에 추가
			a.add(new JLabel(c[j]));
			a.get(j).setBounds(125+(j*120),45,70,25);
			a.get(j).setHorizontalAlignment(SwingConstants.CENTER);
			a.get(j).setFont(new Font("굴림", Font.BOLD, 22));
			
			e.add(a.get(j));
			
			for(int k =0; k < d[j].length;k++) {
				//소분류 button생성 후 배열에 추가
				b.add(new JButton("<HTML>"+d[j][k]+"<br>"+f[index] +"원</HTML>"));
		
				b.get(index).setBounds(80+(j*145),75+(k*50),125,40);
				e.add(b.get(index));
				
				index++;
				
				
			}
		}
	}
	
	//마이너스 버튼
	public makejbutton(ArrayList<JButton> a, String[][] b,JPanel p) {
		//소분류 메뉴 버튼 옆에 각각 마이너스 버튼을 추가
		int index =0;
		for(int i = 0; i<b.length; i++) {
			for(int j=0; j<b[i].length;j++) {
				a.add(new JButton("-"));
				a.get(index).setBackground(Color.red);
				a.get(index).setForeground(Color.WHITE);
				a.get(index).setFont(new Font("굴림", Font.BOLD, 5));
				a.get(index).setBounds(205+(i*145),75+(j*50),20,40);
				p.add(a.get(index));
				index++;
			}
			
		}
	}

}
