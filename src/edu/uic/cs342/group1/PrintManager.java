package edu.uic.cs342.group1;

/**
* Class: Example4
* <p>
* 
* Example of using the TextLayout class to format a text paragraph.
* <p>
* 
* @author Jean-Pierre Dube <jpdube@videotron.ca>
* @version 1.0
* @since 1.0
*/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.text.AttributedString;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 THIS CODE HAD BEEN HEAVILY MODIFYED MY MAC CARTER TO ACCOMIDATE MULTIPLE PAGE PRINTING
Original credit to
* @author Jean-Pierre Dube <jpdube@videotron.ca>
* @version 1.0
* @since 1.0
*/

public class PrintManager{
  public static void printCustomer(int calcPrice){
	  
//	       this.currentLineOnPage=0;
	  PrintFile.FileName = "customer.txt";
	try{  
	  PrintFile example = new PrintFile();
	}
	catch(Exception e){	
		System.out.println("no file found for customer");
	}
  }
	
  public static void Print(){
  //     this.currentLineOnPage=0;
//	  PrintFile.FileName = "test.txt";    
//	  PrintFile example = new PrintFile();
  }

  public static void PrintLow(){
  //  this.currentLineOnPage=0;
	  PrintFile.FileName = "Low_stock.txt";    
	  PrintFile example = new PrintFile();
  }
}

