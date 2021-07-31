package demo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class serverlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		int rank = Integer.parseInt(req.getParameter("rank"));
		String br = req.getParameter("branch");
		String cate = req.getParameter("category");
		String categry =cate.toUpperCase();
	    String branch = br.toUpperCase();
	    
        EnggObj E= new EnggObj();
        E.startPushing();
        
        ArrayList<String> myclg = E.searching_engg(rank, categry,branch);
        
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result</title>");
        out.println("</head>");
        out.println("<body style='background-color:powderblue;'>");
        
        if(myclg.isEmpty()) {
        	out.println("<h1>");
        	out.println("Couldn't match a college with your rank,category with desired branch");
        	out.println("</h1>");
        }
        else {
        	out.println("<h1>");
        	out.println("<center>");
            out.println("Applicable clgs are :");
            out.println("</h1>");
            for(int i=0;i < myclg.size();i++) {
               out.println("<p style='color:white;'>");
               out.println("<center>");
        	   out.println((i+1) +" ) "+myclg.get(i));
        	   out.println("</p>");
            }
       }
       out.println("</html>");
	}

}
