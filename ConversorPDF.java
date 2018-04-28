package ferramentas;
// Operações com arquivos.
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

// Operações com documentos digitais.
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
* Converte PDF para outros formatos digitais.
* @author Lucas Sousa Silva
* @see org.apache.pdfbox.util.PDFTextStripper
*/
public class ConversorPDF{

	/**
	* Retorna toda a String de um PDF.
	* @param documentoPDF - Documento á obter String.
	* @return Retorna o texto do PDF.
	*/
	public static String getString(PDDocument documentoPDF)throws IOException{
		return new PDFTextStripper().getText(documentoPDF);
	}

	/**
	* Acessa um arquivo "*.PDF" , extrai seu texto e salva um arquivo de
	* texto plano "*.TXT".
	* @param arquivoPDF - Arquivo para obtenção de texto.
	* @param arquivoTXT - Arquivo para gravação de dados obtidos.
	*/
	public static void pdfParaTXT(File arquivoPDF, File arquivoTXT)throws IOException{
		FileWriter abridor = new FileWriter(arquivoTXT);
		PrintWriter escritor = new PrintWriter(abridor);
		escritor.print(getString(PDDocument.load(arquivoPDF)));
		abridor.close();
	}
	/*
	//Sugestão de teste
	public static void main(String[] args) throws IOException{
		pdfParaTXT(new File(args[0]),new File(args[1]));
	}
	*/
}
