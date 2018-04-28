import ferramentas.ConversorPDF;

// Biblioteca de entrada e saída
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

// Biblioteca de operações com documentos digitais
import org.apache.pdfbox.pdmodel.PDDocument;

/**
* Classe principal faz uma implementação da classe <b>ConversorPDF</b>,
* na janela do console .
* Uso
* @author Lucas Sousa Silva
* @see ConversorPDF
*/
public class Txtzadordepdf extends ConversorPDF{

	/**
	* Imprime mensagem ajuda
	* @see System.out.println
	*/
	private static void ajuda(){
		System.out.println(
		"Opções :\n"+
		"        -p [arquivo]    (Imprime texto de um arquivo .PDF)\n"+
		"        -s [arquivoEntrada] [arquivoSaida]  (Retira texto e "+
		"salva em um arquivo)\n"+
		"        -h (Imprime esta ajuda)");
	}

	/**
	* Main é o que faz tudo funcionar ;¬)
	*/
	public static void main(String[] args)throws IOException{
		if(args.length < 1){
			ajuda();
			return;// Fecha o programa
		}else if(args[0].equals("-s")){
			if (args.length != 3) {
				ajuda();
			}else{
				ConversorPDF.pdfParaTXT(new File(args[1]),new File(args[2]));
				System.out.println("Feito !!!");
			}
		}else if (args[0].equals("-p")) {
			// Imprime texto de um arquivo .PDF
			System.out.println(ConversorPDF.getString(PDDocument.load(args[1])));
		}else{
			ajuda();
		}
	}
}
