package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Servlet implementation class EnviarEmail
 */
@WebServlet("/EnviarEmail")
public class EnviarEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  // Recipient's email ID needs to be mentioned.
	      String emailRecibe = "leo.peretti5@gmail.com";
	 
	      // Sender's email ID needs to be mentioned
	      String emailEnvia = request.getParameter("txtEmail");
	      
	      // Nombre del usuario que envia el mail
	      String nombreEnvia = request.getParameter("txtNombreEnvia");
	 
	      // Assuming you are sending email from localhost
	      String host = "localhost";
	 
	      // Get system properties
	      Properties properties = System.getProperties();
	 
	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	 
	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);
	      
		  // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	       try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(emailEnvia));
	 
	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(emailRecibe));
	 
	         // Set Subject: header field
	         message.setSubject(nombreEnvia+" "+"PRGNATACION");
	 
	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();
	 
	         // Fill the message
	         messageBodyPart.setText("txtMensaje");
	         
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();
	 
	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);
	 
	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "file.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	 
	         // Send the complete message parts
	         message.setContent(multipart );
	 
	         // Send message
	         Transport.send(message);
	         String title = "CONSULTA";
	         String res = "Sent message successfully...";
	         String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n" +
	         "<p align=\"center\">" + res + "</p>\n" +
	         "</body></html>");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
