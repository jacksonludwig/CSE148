package xml_Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo {

	public static void main(String[] args) {
		HashSet<String> courseAbbreviationSet = new HashSet<>();
		FileWriter fw = null;
		try {
			fw = new FileWriter("Course_Inventory.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		try {
			File fXmlFile = new File("course-inventory-prod.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element:" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("CourseInventory");

//			System.out.println("----------------------------");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String courseAbbreviation = eElement.getElementsByTagName("CourseSubjectAbbreviation").item(0)
							.getTextContent();
					courseAbbreviationSet.add(courseAbbreviation);
					String courseNumber = eElement.getElementsByTagName("CourseNumber").item(0).getTextContent();
					String courseNumberCombined = courseAbbreviation + courseNumber;
					String courseLongTitle = eElement.getElementsByTagName("CourseLongTitle").item(0)
							.getTextContent();
					String courseDescription = eElement.getElementsByTagName("CourseDescription").item(0)
							.getTextContent();
					String courseDescriptionTemp = courseDescription.replaceAll("(  )+", " ");
					String cleanedCourseDescription = courseDescriptionTemp.replaceAll("\n", "");
					String numberOfCredits = eElement.getElementsByTagName("CourseCreditMinimumValue").item(0)
							.getTextContent();
					pw.println(courseNumberCombined);
					pw.println(courseLongTitle);
					pw.println(cleanedCourseDescription);
					pw.println(numberOfCredits);
					pw.println();
				}
			}
			ArrayList<String> courseAbbreviationList = new ArrayList<>();
			courseAbbreviationList.addAll(courseAbbreviationSet);

			String[] courseAbbreviationArray = new String[courseAbbreviationList.size()];

			courseAbbreviationArray = courseAbbreviationList.toArray(courseAbbreviationArray);

			Arrays.sort(courseAbbreviationArray);

			pw.println(Arrays.toString(courseAbbreviationArray));
			System.out.println(Arrays.toString(courseAbbreviationArray));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

}
