package ReadXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		//Declare the file path
		File xmlFile = new File("C:\\Users\\hparupalli\\MYCTestcases\\Data\\Bodleian Library EAD_Large catalogue.xml");
		
		// Create instance for document builder factory
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc =dBuilder.parse(xmlFile);
		
		//get node list for xml
		NodeList nlxml = doc.getChildNodes();
		
		//get xml first node
		
		Node nxml = nlxml.item(0);
		//assign node element
		
		Element element = (Element)nxml;
		
		//pring the application url by tag name
		//System.out.println("publisher: "+element.getAttribute(name));
		
		System.out.println("publisher: "+element.getTextContent());
		
		System.out.println("publisher: "+element.getElementsByTagName("publisher").item(0).getTextContent());
		
	}

}
