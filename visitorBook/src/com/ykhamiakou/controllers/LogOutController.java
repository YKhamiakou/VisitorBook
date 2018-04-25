package com.ykhamiakou.controllers;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.managers.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutController extends AbstractController {
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
    @Override
    public void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        UserUtils.deleteCookies(response);
        response.sendRedirect(request.getContextPath() + Constants.CONTROLLER_MAIN);
    }

}
