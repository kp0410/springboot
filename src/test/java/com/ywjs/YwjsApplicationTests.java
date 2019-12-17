package com.ywjs;

import com.alibaba.fastjson.JSONException;
import com.ywjs.pythontookit.pipesimutil.PipesimConversionUnit;
import com.ywjs.pythontookit.pipesimutil.PipesimUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.apache.catalina.startup.ExpandWar.deleteDir;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class YwjsApplicationTests {

    @Test
    public void danweizhuanhua(){
        int a = 1;
        for (int i = 0; i < 100 ; i++) {
            a += i;
        }
        System.out.println(a);
    }

    @Test
    public void contextLoads()  {
        String[][] updateData = {{"P106","Parameters.Source.TEMPERATURE","103.35300079999999"},
                                {"P106","Parameters.Source.PRESSURE","129.4404908"},
                                {"P106","Parameters.Source.GASFLOWRATE","29.71082174268449"},
                                {"P107","Parameters.Source.TEMPERATURE","103.35300079999999"},
                                {"P107","Parameters.Source.PRESSURE","129.4404908"},
                                {"P107","Parameters.Source.GASFLOWRATE","29.71082174268449"},
                                {"P108","Parameters.Source.TEMPERATURE","103.35300079999999"},
                                {"P108","Parameters.Source.PRESSURE","129.4404908"},
                                {"P108","Parameters.Source.GASFLOWRATE","29.71082174268449"},
                                {"P109","Parameters.Source.TEMPERATURE","103.35300079999999"},
                                {"P109","Parameters.Source.PRESSURE","129.4404908"},
                                {"P109","Parameters.Source.GASFLOWRATE","29.71082174268449"}};
        String[] a = new String[updateData.length/3*2];
        String[] b = new String[updateData.length/3*2];
        String[] c = new String[updateData.length/3*2];
        for (int i = 0; i < updateData.length; i++) {
            if (i%3 != 1){
                for (int j = 0; j < 3; j++) {
                    switch (j) {
                        case 0:
                            if (i%3 != 0){
                                if (i == 0){
                                    a[i%3] = updateData[i][j];
                                }else {
                                    a[(i+1)/3*2-1] = updateData[i][j];
                                }
                            }else {
                                a[i/3*2] = updateData[i][j];
                            }
                            break;
                        case 1:
                            if (i%3 != 0){
                                if (i == 0){
                                    b[i%3] = updateData[i][j];
                                }else {
                                    b[(i+1)/3*2-1] = updateData[i][j];
                                }
                            }else{
                                b[i/3*2] = updateData[i][j];
                            }

                            break;
                        case 2:
                            if (i%3 != 0){
                                if (i == 0){
                                    c[i%3] = updateData[i][j];
                                }else {
                                    c[(i+1)/3*2-1] = updateData[i][j];
                                }
                            }else {
                                c[i/3*2] = updateData[i][j];
                            }
                            break;
                    }
                }
            }
        }
    }

    @Test
    public void oracleData() throws JSONException, org.json.JSONException {
        String data = "{\n" +
                "\"message\": \"231\",\n"+
                "\"employees\": [\n" +
                "{ \"firstName\":\"John\" , \"lastName\":\"Doe\" },\n" +
                "{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" },\n" +
                "{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" }\n" +
                "]\n" +
                "}\n";
        org.json.JSONObject jsonObject = new org.json.JSONObject(data);
        String message = jsonObject.getString("message");
        System.out.println(message);
        org.json.JSONArray simsettinglist = jsonObject.getJSONArray("employees");
        String[][] str = new String[simsettinglist.length()][2];
        for (int i = 0; i < simsettinglist.length(); i++) {
            String firstName = simsettinglist.getJSONObject(i).getString("firstName");
            String lastName = simsettinglist.getJSONObject(i).getString("lastName");
            System.out.println("firstName=" + firstName);
            System.out.println("lastName=" + lastName);
            str[i][0] = firstName;
            str[i][1] = lastName;
        }
        System.out.println(Arrays.deepToString(str));
    }

}
