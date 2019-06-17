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

    public static double capturaCpu() {

        SystemInfo cpu = new SystemInfo();

        double cpu1 = cpu.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
        double usoCpu = cpu1 * (500);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("##,00%");

        System.out.println("Você está utilizando " + df.format(usoCpu) + " de sua CPU");

        return usoCpu;

    }

    public static double naoUsada() {

        SystemInfo sistema = new SystemInfo();

        double cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
        double cpu1 = cpu * (100);
        DecimalFormat df = new DecimalFormat();

        double total = 100 - cpu1;
        return total;
    }

    public String capturaIp() {

        String ipMaquina;

        SystemInfo ip = new SystemInfo();

        ipMaquina = ip.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway();

        return ipMaquina;

    }

    public String capturaNomeProcessador() {

        SystemInfo processadorMaquina = new SystemInfo();

        String processador = processadorMaquina.getHardware().getProcessor().getName();

        System.out.println("Processador: " + processador);
        return processador;

    }
    //---------------------------LABELS

    public static String hardware() throws Exception {

        SystemInfo sistema = new SystemInfo();

        double cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
        double cpu1 = cpu * (1000);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("###,000%");

        if (cpu1 >= 50000) {
            Component rootPane = null;
            JSONObject message = new JSONObject();
            message.put("text", "CPU ALCANÇANDO LIMITE DE UTILIZAÇÃO");
            slack.insertMessage(message);
            JOptionPane.showMessageDialog(rootPane, "CPU ALCANÇANDO LIMITE DE UTILIZAÇÃO", "ALERTA",
                    JOptionPane.ERROR_MESSAGE, null);

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
