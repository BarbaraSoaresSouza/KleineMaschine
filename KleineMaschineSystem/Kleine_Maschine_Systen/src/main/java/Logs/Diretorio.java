
package Logs;


import java.io.File;
import java.util.Date;

public class Diretorio {

    public void criarDiretorio() {

        //V�riaveis
        File diretorio;

        Date data;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        data = new Date();

        //Inicializando a v�riavel diretorio criando a instancia  da classe File e passando como paraemtro o local de cria��o
        diretorio = new File("");

        //Chamando o metodo mkdir que cria diretorios da classe Diretorio
        diretorio.mkdir();

        //Confdi��o que verifica a exist�ncia de um diretorio
        if (!diretorio.exists()) {

            if (!data.equals(diretorio.lastModified())) {
                //Inicializando a v�riavel diretorio criando a instancia  da classe File e passando como parametro o Local de cria��o
                diretorio = new File("C:\\RegistroLog" + data.getMonth());

                //Chamando o metodo mkdir que cria diretorios da classe Diretorio
                diretorio.mkdir();
            }

         
                }
            }
        }
    


