package com.jdbcservlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import servlet.CidadeServlet;

import java.io.File;

public class IniciaServidor {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat(); // Instancia objeto do Tomcat para servidor web

        tomcat.setPort(8080); // Define porta de acesso
        tomcat.getConnector(); // Inicia o connector http

        String webapp = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp("", webapp);

        String nomeServlet = "PessoaServlet";

        Tomcat.addServlet(context, nomeServlet, new CidadeServlet());
        context.addServletMappingDecoded("/cidades", nomeServlet);

        System.out.println("Servidor tomcat rodando...");

        tomcat.start();
        tomcat.getServer().await();
    }
}
