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
	
	
	
	//�޴� ��ư
	public makejbutton(ArrayList<JLabel> a, ArrayList<JButton> b, String[] c, String[][] d,JPanel e,int[] f) {
		// TODO Auto-generated constructor stub
		//�ߺз� �޴� �̸��� ��� �迭a, �Һз� �޴� ������ ��� �迭b, �ߺз� �迭c, �Һз� �迭d, �ߺз� �г� e, ���ݹ迭f
		int index =0;
		for(int j = 0; j<c.length;j++) {
			//�ߺз� label������ �迭�� �߰�
			a.add(new JLabel(c[j]));
			a.get(j).setBounds(125+(j*120),45,70,25);
			a.get(j).setHorizontalAlignment(SwingConstants.CENTER);
			a.get(j).setFont(new Font("����", Font.BOLD, 22));
			
			e.add(a.get(j));
			
			for(int k =0; k < d[j].length;k++) {
				//�Һз� button���� �� �迭�� �߰�
				b.add(new JButton("<HTML>"+d[j][k]+"<br>"+f[index] +"��</HTML>"));
		
				b.get(index).setBounds(80+(j*145),75+(k*50),125,40);
				e.add(b.get(index));
				
				index++;
				
				
			}
		}
	}
	
	//���̳ʽ� ��ư
	public makejbutton(ArrayList<JButton> a, String[][] b,JPanel p) {
		//�Һз� �޴� ��ư ���� ���� ���̳ʽ� ��ư�� �߰�
		int index =0;
		for(int i = 0; i<b.length; i++) {
			for(int j=0; j<b[i].length;j++) {
				a.add(new JButton("-"));
				a.get(index).setBackground(Color.red);
				a.get(index).setForeground(Color.WHITE);
				a.get(index).setFont(new Font("����", Font.BOLD, 5));
				a.get(index).setBounds(205+(i*145),75+(j*50),20,40);
				p.add(a.get(index));
				index++;
			}
			
		}
	}

}
