package com.service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

@WebServlet(value = "")
public class PublishService extends HttpServlet {

    /**
     *
     */
    //private static final long serialVersionUID = 1L;

    /**
     * Constructor of the object.
     */
    public PublishService() {
        super();
    }


    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init(ServletConfig config) throws ServletException {
        Endpoint.publish("http://localhost:1008/webservice/protocolservice/protocolManagerService", new Service());
        System.out.println("发布成功!");
    }

}
