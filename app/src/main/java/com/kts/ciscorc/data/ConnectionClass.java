package com.kts.ciscorc.data;

import android.util.Log;

import javax.net.ssl.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class ConnectionClass {
    public static String ipAddress;
    public static URL url;

    //Отключение проверки сертификата ->
    public static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
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

    public static String connect(String ipaddress, String login, String password){
        String uri = null;
        //Логика подключения к терминалу, авторизация
        try {
            uri = "https://" + ipaddress + "/getxml?location=/Status/SystemUnit";
            url = new URL(uri);
            String userCredentials = login + ":" + password;
//            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));  //Работает только с версии API 26
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes());  //Работает со старыми версиями Java
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Authorization", basicAuth);

            return connection.getResponseMessage();

        } catch (SocketTimeoutException e){
            return "Видеотерминал не отвечает";
        } catch (UnknownHostException e) {
            return "Неизвестный хост";
        } catch (IOException e) {
            return "Запрос не авторизован";
        } catch(Exception e) {
            e.printStackTrace();
            return "Неизвестная ошибка";
        }

    }
    public static String getSystemInfo(String ipaddress, String login, String password){

        try {
            url = new URL ("http://178.176.35.45:8084/status.xml");                                         //1-GET


            String userCredentials = "operator:password";
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes())); //Работает только с Java 8

//            String encoded = DatatypeConverter.printBase64Binary(userCredentials.getBytes()); //Работает со старыми версиями Java
//            String basicAuth = "Basic " + new String(encoded);                                //Работает со старыми версиями Java

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");                                                                  //1-GET

            connection.setReadTimeout(3000);
            connection.setConnectTimeout(15000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Authorization", basicAuth);

            System.out.println("Внимание! Ответ сервера " + connection.getResponseMessage());


            InputStream content = connection.getInputStream();                             // -> чтение из потока
            BufferedReader in = new BufferedReader (new InputStreamReader (content));
            String line;
            String resalt = null;
            while ((line = in.readLine()) != null) {
                Log.d("INFO", line);
                resalt += line;
            }
            return resalt;

        } catch (SocketTimeoutException e){
            return "Видеотерминал не отвечает";
        } catch (UnknownHostException e) {
            return "Неизвестный хост";
        } catch (IOException e) {
            return "Запрос не авторизован";
        } catch(Exception e) {
            e.printStackTrace();
            return "Неизвестная ошибка";
        }
    }
//    public static List<String> runDiagnostic(){
//        //Запуск диагностики терминала, выдача результата
//
//        return null;
//    }
//    public static void getPhonebook(){
//        //Запрос и выдача адресной книги
//
//    }
//    public static void sendCommand(){
//        //Отправка команд
//
//    }
}
