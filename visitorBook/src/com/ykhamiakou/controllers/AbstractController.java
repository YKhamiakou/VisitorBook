package com.ykhamiakou.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Abstract servlet for project
 */
public abstract class AbstractController extends HttpServlet {

    /**
     * Serial version
     */
    private static final long serialVersionUID = 1L;

    /**
     * Request processor
     *
     * @param request
     *            - input request
     * @param response
     *            - output response
     * @throws ServletException
     * @throws IOException
     */
    public abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        this.processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        this.processRequest(request, response);
    }
}
