package model;

import static java.lang.Thread.sleep;

import java.awt.Component;

import oshi.PlatformEnum;
import oshi.SystemInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class cpuMODEL {
static slackModel slack = new slackModel();
	public static double consumoCPU() {

		SystemInfo sistema = new SystemInfo();

		double cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
		double cpu1 = cpu * (400);
		DecimalFormat df = new DecimalFormat();

		return cpu1;
	} 
        public static void main(String[] args) {
       
                cpuMODEL  cpu = new cpuMODEL();
        
                double cpu1 = cpu.consumoCPU();
                
             
                
                DecimalFormat df = new DecimalFormat();
                df.applyPattern("##,00%");

                System.out.println("Você está utilizando " + df.format(cpu1) + " de sua CPU");
        }

	public static double naoUsada() {

		SystemInfo sistema = new SystemInfo();

		double cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
		double cpu1 = cpu * (100);
		DecimalFormat df = new DecimalFormat();

		double total = 100 - cpu1;
		return total;
	}
	//---------------------------LABELS

	public static String hardware() throws Exception {

		SystemInfo sistema = new SystemInfo();

		double cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
		double cpu1 = cpu * (1000);
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("###,000%");

		if (cpu1 <= 50000) {
			Component rootPane = null;
			 JSONObject message = new JSONObject();
		        message.put("text", "Esta tudo ok, com sua CPU..... USO DA CPU  "+ df.format(cpu1));
		       slack.insertMessage(message);
			

		}
		if (cpu1 >= 70000) {
			Component rootPane = null;
			JSONObject message = new JSONObject();
	        message.put("text", "CPU EXCEU LIMITE DE UTILIZAÇÃO");
	        slack.insertMessage(message);
			JOptionPane.showMessageDialog(rootPane, "CPU EXCEU LIMITE DE UTILIZAÇÃO", "ALERTA",
					JOptionPane.ERROR_MESSAGE, null);
		}
		{

		}
		return df.format(cpu1);
	}

	public String getProcessadorDiagnostico() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

}