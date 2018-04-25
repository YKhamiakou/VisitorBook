package com.ykhamiakou.controllers;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.beans.Message;
import com.ykhamiakou.beans.User;
import com.ykhamiakou.dao.MessageDAOFactory;
import com.ykhamiakou.dao.UserDAOFactory;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;
import com.ykhamiakou.managers.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller for creating massages
 */
public class CreateMessageController extends AbstractController {

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
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            User user = UserUtils.getUserFromSession(request.getSession());
            if(user.equals(UserDAOFactory.getClassFromFactory().getUserById(user.getId()))){
                request.setCharacterEncoding(Constants.PAGE_ENCODING);
                String text = request.getParameter(Constants.MESSAGE_TEXT_PARAM);
                synchronized (this){
                    MessageDAOFactory.getClassFromFactory().addMessage(new Message(user, text));
                }
                response.sendRedirect(request.getContextPath() + Constants.CONTROLLER_MAIN);
            } else {
                throw new AuthenticationException(Constants.LOGGED_OUT_EXCEPTION);
            }
        } catch (DAOException ex) {
            System.err.println("CREATEMESSAGE.DAOException------->" + ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.MESSAGE_SOMETHING_WENT_WRONG);
            request.getRequestDispatcher(Constants.CONTROLLER_MAIN).forward(request, response);
        } catch (AuthenticationException ex) {
            System.err.println("CREATEMESSAGE.AuthenticationException------->" + ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.AUTHENTICATION_EXCEPTION);
            request.getRequestDispatcher(Constants.CONTROLLER_MAIN).forward(request, response);
        }
    }
}
