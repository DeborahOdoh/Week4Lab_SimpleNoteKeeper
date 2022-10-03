/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author odohd
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editNote = request.getParameter("edit");
        String title = "";
        String content = "";
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
 
        try{
            BufferedReader bReader = new BufferedReader(new FileReader(new File(path)));
            title = bReader.readLine();
            content = bReader.readLine();
            bReader.close();
        }catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);

        if(editNote == null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.println(content);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

} 