/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Arquivo {

    File arquivo;

    Date data;

    public void criarArquivo() throws FileNotFoundException {
        //Variaveis 

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Inicializando a v�riavel arquivo criando a instancia  da classe File e passando como parametro local de cria��o
        data = new Date();

        arquivo = new File("");

        if (!arquivo.exists()) {
        }

        //Tente criar o arquivo 
        try {
            arquivo = new File("C:\\RegistroLog" + data.getMonth() + "\\log" + data.getDate() + ".txt");

            arquivo.createNewFile();

        } catch (IOException ex) {

            System.out.println("ERRO:" + ex.getMessage());
        }

        if (!data.equals(arquivo.lastModified())) {

            try {
                arquivo.createNewFile();

            } catch (IOException ex) {

                System.out.println("ERRO:" + ex.getMessage());
            }
        }
        //Chamando o metodo escrever arquivo passando como parametro o arquivo
        escreverArquivo(arquivo);

        //Chamando o metodo linhasArquivos passando como parametro o arquivo
        lerArquivos(arquivo);

    }

    public void escreverArquivo(File arquivo) {

        try {

            //Variaveis 
            FileWriter escrever; // Variavel que guarda a instancia da classe FileWriter

            BufferedWriter marcar; // Variavel que guarda a instancia da classe BufferedWriter

            FileReader leitura; // Variavel que guarda a instancia da classe FileReader

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Inicializando a v�riavel escrever criando a instancia  da classe FileWriter com o parametro arquivo
            escrever = new FileWriter(arquivo, true);

            //Inicializando a v�riavel marcar criando a instancia da classe BufferedWriter com o parametro escrever
            marcar = new BufferedWriter(escrever);

            //Utilizando o metodo de write da classe Buffered que escreve no log dados de data e hora
            marcar.write("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + "Sistema em uso");

            // Metodo newLine da classe BufferedWriter que adiciona uma nova linha 
            marcar.newLine();

            marcar.write("Banco Conectado" + data.getHours());

            marcar.newLine();
            
            marcar.write("Sistema Iniciado" + data.getHours());

            //Metodo da classe BufferedWriter que finaliza o objeto
            marcar.close();

            //Metodo da classe fileWriter que finaliza o objeto
            escrever.close();

        } catch (IOException ex) {

            System.out.println("ERRO:" + ex.getMessage());
        }

    }

    public void lerArquivos(File arquivo) throws FileNotFoundException {

        FileReader leitura;

        String linha;

        BufferedReader ler;

        leitura = new FileReader(arquivo);

        ler = new BufferedReader(leitura);

        try {

            linha = ler.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = ler.readLine();
            }

        } catch (IOException ex) {

            System.out.println("ERRO:" + ex.getMessage());
        }
    }
}
