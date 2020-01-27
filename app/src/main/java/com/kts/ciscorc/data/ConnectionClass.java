package com.kts.ciscorc.data;

import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.RequiresApi;

import javax.net.ssl.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.stream.Collectors;

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
            uri = "http://" + ipaddress + "/getxml?location=/Status/SystemUnit";
            url = new URL(uri);
            String userCredentials = login + ":" + password;
//            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));  //Работает только с версии API 26
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes());  //Работает со старыми версиями Java
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestMethod("GET");
            connection.setReadTimeout(3000);
            connection.setConnectTimeout(3000);
            connection.connect();

            return connection.getResponseMessage();

        } catch (SocketTimeoutException e){
            return e.toString() + "Запрос не авторизован";
        } catch (UnknownHostException e) {
            return "UnknownHostException, Неизвестный хост";
        } catch (IOException e) {
            return "IOException, Запрос не авторизован";
        } catch(Exception e) {
            e.printStackTrace();
            return e.toString() + "Видеотерминал не отвечает";
        }

    }

    public static String getSystemInfo(String ipaddress, String login, String password){
        String uri = null;
        try {
            uri = "http://" + ipaddress + "/getxml?location=/Status/SystemUnit";
            url = new URL(uri);
            String userCredentials = login + ":" + password;
//            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));  //Работает только с версии API 26
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes());  //Работает со старыми версиями Java
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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


        } catch (SocketTimeoutException e){
            return "SocketTimeoutException, Видеотерминал не отвечает";
        } catch (UnknownHostException e) {
            return "UnknownHostException, Неизвестный хост";
        } catch (IOException e) {
            return "IOException, Запрос не авторизован";
        } catch(Exception e) {
            e.printStackTrace();
            return e.toString() + "Видеотерминал не отвечает";
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
