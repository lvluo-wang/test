package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import edu.emory.mathcs.backport.java.util.Arrays;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.stream.*;
public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    
    
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url1){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
        	URL url = new URL(url1);
        	URI uri;
			try {
				uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
				DefaultHttpClient client = new DefaultHttpClient();
				//url = URLDecoder.decode(url, "GBK");
				//发送get请求
				HttpGet request = new HttpGet(uri);
				HttpResponse response = client.execute(request);
				/**读取服务器返回过来的json字符串数据**/
				String strResult = EntityUtils.toString(response.getEntity());
				/**把json字符串转换成json对象**/
				jsonResult = JSONObject.fromObject(strResult);
			
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
 
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return jsonResult;
    }

 // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
    throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat(formatType);
    Date date = null;
    date = formatter.parse(strTime);
    return date;
    }
    public static boolean  checkSignature(String pkey,HashMap<String,String> map,String md5){
    	return true;
    }
    
    public static String getParamString(Map<String, String> map) {
        return map.entrySet()
            .stream()
            .map(entry -> entry.getKey() + "=" + (entry.getValue()))
            .collect(Collectors.joining("&"));
    }
    
    public static void main(String[] args) throws Exception {
    	//httpGet("http://ns801.gicp.net:8003/fans/getOutCode?companyFlag=lvjin&userId=111111&&sign=b8c8645d96d1c53d484099d55d8d77b8");
    	//String result = sendPost("http://ns801.gicp.net:8003/fans/getOutCode","companyFlag=lvjin&userId=111111&&sign=b8c8645d96d1c53d484099d55d8d77b8");
    	//String result = sendPost("http://ns801.gicp.net:8003/fans/getOutCodeJson","companyFlag=lvjin&userId=111111&&sign=b8c8645d96d1c53d484099d55d8d77b8");
    	//System.out.println(result);
    	
    	//List<DealResult> list = ReadExcel.readTxt();
    	//List<DealResult> list = ReadExcel.readExcel();
    	//FileWriter fw=new FileWriter("e:/test.txt");
    	  File f=new File("e:/test1.txt");
          f.createNewFile();
          FileOutputStream fileOutputStream = new FileOutputStream(f);
          PrintStream printStream = new PrintStream(fileOutputStream);
          System.setOut(printStream);
          Date valueDate = stringToDate("2016-5-10","yyyy-MM-dd");
    	//for(DealResult dealResult: list){
    	String[] arr = {"0.06","0.06","0.06","0.06","0.06","0.06","0.06","0.06","0.04","0.04","0.04","0.04","0.04","0.04","0.04","0.04","0.03","0.03","0.03","0.03","0.03","0.03","0.01","0.01"};
    	StringBuffer param = new StringBuffer();
    	param.append("amount=20000");
    	param.append("&duration=24");
    	param.append("&durationUnit=M");
    	param.append("&extensionData=");
    	param.append("&interestRate=0.24");
    	param.append("&lateFeeRate=0");
    	param.append("&loanType=ABA_RENT");
    	param.append("&mgmtFeeRate=0");
    	param.append("&repaymentType=FIXED_DURATION_EQUAL_PRINCIPAL_AND_INTEREST_PAYMENT");
    	param.append("&valueDate="+valueDate);
    	JSONObject jsonResult = httpGet("http://localhost/api/loans/repaymentplans/?"+param.toString());
        Object items = jsonResult.get("items");
        //String loanId=dealResult.getLoanId().toString();
    	//String planId=dealResult.getPlanId().toString();
			String sql  = dealItems(items.toString(),"10693","10688");
			System.out.println(sql);
    	}
    
    public static String dealItems(String items,String loanId,String planId ) throws IOException{

    	 JSONArray jsonArray = JSONArray.fromObject(items.toString());
    	 StringBuffer sql= new StringBuffer();
    	 sql.append("-- loanId="+loanId+" -- planId="+planId+" --\n");
    	// sql.append("DELETE FROM T_REPAYMENT_AMORTIZATION WHERE PLAN_ID="+planId+";\n");
        for(int i=0;i<jsonArray.size();i++){
      	Object one = jsonArray.get(i);
      	JSONObject json = JSONObject.fromObject(one);
      	Object period = json.get("period");
      	Object totalPeriods = json.get("totalPeriods");
      	Object repaymentDate = json.get("repaymentDate");
      	Object interest = json.get("interest");
      	Object principal = json.get("principal");
      	Object remainingPrincipal = json.get("remainingPrincipal");
      	Object managementFee = json.get("managementFee");
      	Object totalAmount = json.get("totalAmount");
//      	sql.append("INSERT INTO T_REPAYMENT_AMORTIZATION (PLAN_ID,LOAN_ID,PERIOD,TOTAL_PERIOD,MGMT_FEE_ACCRUED,INTEREST_ACCRUED,PRINCIPAL_ACCRUED,CREATE_TIME,REPAYMENT_DATE)");
//      	sql.append(" VALUES("+planId+","+loanId+","+period+","+totalPeriods+","+managementFee+","+interest+","+principal+",sysdate,"+repaymentDate+");\n");
      	sql.append("UPDATE T_REPAYMENT_AMORTIZATION SET MGMT_FEE_ACCRUED="+managementFee+",INTEREST_ACCRUED="+interest+",PRINCIPAL_ACCRUED="+principal+" WHERE ");
      	sql.append(" PLAN_ID="+planId+" AND PERIOD="+period+";\n");
        }
        return sql.toString();
    }
}
    
