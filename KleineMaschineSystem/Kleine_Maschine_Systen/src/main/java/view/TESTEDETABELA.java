package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Processo;

public class TESTEDETABELA {
	public static void main(String args[]) {
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Processo.qualquerCoisa();

	    Object dados[][] = { { Processo.ps.get(3).getPid() , "Row1-Column2", "Row1-Column3" }};
	       
		Object colunas[] = { " PROGRAMA ", " PID", "CPU %"};
	    JTable table = new JTable(dados, colunas);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setSize(300, 150);
	    frame.setVisible(true);

	  }
	}
