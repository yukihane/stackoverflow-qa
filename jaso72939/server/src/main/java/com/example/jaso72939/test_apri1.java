package com.example.jaso72939;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.tomcat.util.codec.binary.Base64;

public class test_apri1 {
    public static void main(final String[] args) {

        HttpURLConnection conn = null;
        final StringBuffer json = new StringBuffer();
        URL url = null;
        InputStream is = null;
        final StringBuffer v_param = new StringBuffer();
        final Map params = new HashMap();
        params.put("tantousya_id", "KANRI");
        params.put("simei", "kanri");

        try {
            url = new URL("http://localhost:8080/sample/json3/testGetData");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Accept-Language", "jp");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //            conn.setRequestProperty("Accept", "application/json");
            final String v_id_pass = "TEST:TEST";
            final byte[] v_id_pass_str64 = Base64.encodeBase64(v_id_pass.getBytes());
            conn.setRequestProperty("Authorization", "Basic " + new String(v_id_pass_str64));
            conn.connect();

            final PrintStream ps = new PrintStream(conn.getOutputStream(), false, "MS932");
            boolean v_syokai_flg = true;
            if (params != null) {
                final Iterator iterator = params.entrySet().iterator();
                while (iterator.hasNext()) {
                    final Map.Entry entry = (Map.Entry) iterator.next();
                    if (v_syokai_flg) {
                        v_syokai_flg = false;
                    } else {
                        v_param.append("&");
                    }
                    v_param.append(entry.getKey().toString() + "=" + entry.getValue());
                }
            }

            ps.print(v_param.toString());
            ps.flush();
            ps.close();

            is = conn.getInputStream();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String s;
            while ((s = reader.readLine()) != null) {
                json.append(s);
            }

            System.out.println(json.toString());

        } catch (final SocketTimeoutException e) {
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
