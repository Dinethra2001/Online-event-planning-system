package com.oop.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Booking;
import com.oop.util.bookingDBUtill;

/**
 * Servlet implementation class BookingServelet
 */
@WebServlet("/BookingServelet")
public class BookingServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String bookingId = request.getParameter("bookID");
		boolean isTrue;
		
		isTrue = bookingDBUtill.validate(bookingID);
		if(isTrue == true) {
			List<Booking> bookingDetails = bookingDBUtill.getBookingDetails(bookingId);
			request.setAttribute("BookingDetails",bookingDetails);
			
			RequestDispatcher dis = request.getRequestDispatecher("bookingdata.jsp");
			dis.forward(request,response);
		}
		
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Booking ID is incorrrect'");
			out.println("location=booking.jsp");
			out.println("</script>");
		}
	}

}
