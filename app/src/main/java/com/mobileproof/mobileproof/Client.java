package com.mobileproof.mobileproof;

import android.os.AsyncTask;
import android.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Madhav on 10/16/16.
 */
public class Client extends AsyncTask<Void, Void, String>{
    private static String hostName = "66.169.62.184";
    private static int portNumber = 12345;
    private String request;
    private String response = "";


    public  Client(String req){
        request = req;
    }


    @Override
    protected String doInBackground(Void... voids) {
        try(
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(echoSocket.getInputStream()));
        ) {
            out.println(request);
            String line;
            while( (line = in.readLine()) != null){
                response += line;
            }
            response =  new PageGenerator(response).getHtml();
        } catch (UnknownHostException e) {
            response = "Don't know about host";
        } catch (IOException e) {
            response = "Couldn't get I/O for the connection to the server";
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}