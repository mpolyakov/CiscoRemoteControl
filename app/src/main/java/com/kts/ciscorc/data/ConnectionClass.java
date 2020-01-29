package com.kts.ciscorc.data;

import javax.net.ssl.*;
import javax.xml.bind.DatatypeConverter;

import java.io.*;
import java.net.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class ConnectionClass {
    public static URL url;

    //Отключение проверки сертификата ->
    public static void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };
            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
    // <- Отключение проверки сертификата

    public static String connect(String ipaddress, String login, String password) {
        disableSslVerification();
        String uri = null;
        //Логика подключения к терминалу, авторизация
        try {
            uri = "https://" + ipaddress + "/getxml?location=/Status/SystemUnit";
            url = new URL(uri);
            String userCredentials = login + ":" + password;
//            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));  //Работает только с версии API 26
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes());  //Работает со старыми версиями Java
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.connect();

            return connection.getResponseMessage();

        } catch (SocketTimeoutException e) {
            return e.toString() + "Видеотерминал не отвечает";
        } catch (UnknownHostException e) {
            return e.toString() + "Неизвестный хост";
        } catch (IOException e) {
            return e.toString() + "Запрос не авторизован";
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString() + "Видеотерминал не отвечает";
        }

    }

    public static String methodGET(String ipaddress, String login, String password, String uriGet) {
//        disableSslVerification();
        String uri = null;
        try {
            uri = "https://" + ipaddress + uriGet;
            url = new URL(uri);
            String userCredentials = login + ":" + password;
//            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));  //Работает только с версии API 26
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes());  //Работает со старыми версиями Java
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestMethod("GET");
            connection.setReadTimeout(3000);
            connection.setConnectTimeout(3000);
            connection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            return result;

        } catch (SocketTimeoutException e) {
            return e.toString() + "Видеотерминал не отвечает";
        } catch (UnknownHostException e) {
            return e.toString() + "Неизвестный хост";
        } catch (IOException e) {
            return e.toString() + "Запрос не авторизован";
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString() + "Видеотерминал не отвечает";
        }
    }

    public static String methodPOST(String ipaddress, String login, String password, String body) {
        //Запрос и выдача адресной книги
//        disableSslVerification();
        String uri = null;
        try {
            uri = "https://" + ipaddress + "/putxml";
            url = new URL(uri);
            String userCredentials = login + ":" + password;
//            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));  //Работает только с версии API 26
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes());  //Работает со старыми версиями Java
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setReadTimeout(3000);
            connection.setConnectTimeout(3000);
            connection.connect();

            OutputStream output = new BufferedOutputStream(connection.getOutputStream());               //2-запись в поток и отправка
            output.write(body.getBytes());                                                              //2-запись в поток и отправка
            output.flush();                                                                             //2-запись в поток и отправка

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            return result;

        } catch (SocketTimeoutException e) {
            return e.toString() + "Видеотерминал не отвечает";
        } catch (UnknownHostException e) {
            return e.toString() + "Неизвестный хост";
        } catch (IOException e) {
            return e.toString() + "Запрос не авторизован";
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString() + "Видеотерминал не отвечает";
        }

    }

}
