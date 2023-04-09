package com.uams.boss.payment.controller;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

public class HttpClientUtil {

	private static final Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

	private static CloseableHttpClient httpClient;

	private static void createHttpClientUtil() {
		httpClient = HttpClientBuilder.create().build();
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String sendPost(String url, Map<String, Object> params) {

		HttpPost httpPost = postForm(url, params);
		try {
			createHttpClientUtil();
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 参数转化
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private static HttpPost postForm(String url, Map<String, Object> params) {

		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key,
					String.valueOf(params.get(key))));
		}

		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpost;
	}

	public static String jsonPost(String url, String parameters) {
		HttpPost httpost = new HttpPost(url);
		httpost.addHeader("Content-type", "application/json; charset=utf-8");
		httpost.setHeader("Accept", "application/json");
		httpost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
		HttpResponse response;
		try {
			createHttpClientUtil();
			response = httpClient.execute(httpost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
			}
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据指定URL外发POST请求，入参为字符串
	 *
	 * @param keyValStr
	 *            外发字符串
	 * @param url
	 *            外发地址
	 * @param encoding
	 *            编码
	 * @return 返回字符串
	 * @throws Exception
	 */
	public static String sendPostMessage(String keyValStr, String url,
			String encoding) throws Exception {
		StringEntity strEntity = new StringEntity(keyValStr, encoding);
		return sendPostRequest(strEntity, url, encoding, new HashMap<String, String>());
	}
	
	/**
	 * 
	 * @param keyValStr
	 * @param url
	 * @param encoding
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	public static String sendPostMessage(String keyValStr, String url,
			String encoding, Map<String, String> headers) throws Exception {
		StringEntity strEntity = new StringEntity(keyValStr, encoding);
		return sendPostRequest(strEntity, url, encoding, headers);
	}

	/**
	 * 外发POST请求
	 *
	 * @param httpEntity
	 *            外发对象
	 * @param url
	 *            外发地址
	 * @param encoding
	 *            编码
	 * @return 返回字符串
	 * @throws Exception
	 */
	private static String sendPostRequest(HttpEntity httpEntity, String url,
                                          String encoding, Map<String, String> headers) throws Exception {
		LOG.debug("发送请求URL==>" + url + ", 字符编码：" + encoding);
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = null;
		if (url.startsWith("https")) {
			// 执行 Https 请求.
			try {
				httpclient = createSSLInsecureClient();
			} catch (GeneralSecurityException e) {
				LOG.error("createSSLInsecureClient Error ==> ", e);
				throw e;
			}
		} else {
			httpclient = HttpClients.createDefault();
		}

		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		if (MapUtils.isNotEmpty(headers)) {
			Set<Entry<String, String>> entrySet = headers.entrySet();
			for (Entry<String, String> entry : entrySet) {
				httppost.addHeader(entry.getKey(), entry.getValue());
			}
		}
		LOG.debug("Post方法创建！");
		String resMes = null;
		try {

			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(600000)
					.setConnectTimeout(15000).build();
			httppost.setConfig(requestConfig);
			httppost.setEntity(httpEntity);
			LOG.debug("请求URL:" + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				LOG.info("StatusLine ==>" + response.getStatusLine());
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					resMes = EntityUtils.toString(entity, encoding);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			LOG.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage(), e);
		} catch (SocketTimeoutException e) {
			// 捕获服务器响应超时
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				LOG.error("Close HttpClient Error==> ", e);
			}
		}

		return resMes;
	}


	/** 
	* @Title: createSSLInsecureClient 
	* @Description: 创建发送https请求
	* @return
	* @throws GeneralSecurityException    设定文件 
	*/
	protected static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {
					return true;
				}
			}).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

				@Override
				public boolean verify(String arg0, javax.net.ssl.SSLSession arg1) {
					return true;
				}

				@Override
				public void verify(String host, javax.net.ssl.SSLSocket ssl) throws IOException {
				}

				@Override
				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
				}

				@Override
				public void verify(String host, X509Certificate cert) throws SSLException {
				}
			});
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (GeneralSecurityException e) {
			LOG.error("", e );
			throw e;
		}
	}

	 public static HttpResponse sendRequest(String pushUrl, String parameter) throws Exception {
		HttpPost httpost = new HttpPost(pushUrl);
		httpost.addHeader("Content-type", "application/json; charset=utf-8");
		httpost.setHeader("Content-Encoding", "gzip");
		httpost.setEntity(new StringEntity(parameter, Charset.forName("UTF-8")));
		HttpResponse response = null;
		try {
			createHttpClientUtil();
			response = httpClient.execute(httpost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	 }

	public static String sendPostMessage(Map<String, Object> params, String url,
										  String encoding) throws Exception {
		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs,"utf-8");
		return sendPostRequest(entity, url, encoding, new HashMap<String, String>());
	}

	public static String sendPostMessage(Map<String, Object> params, String url,
										 Map<String,String> headers) throws Exception {
		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs,"utf-8");
		return sendPostRequest(entity, url, "utf-8", headers);
	}

	public static String sendGetRequest(String url, Map<String, String> headers) throws Exception {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet httpget = new HttpGet(url);
		if (MapUtils.isNotEmpty(headers)) {
			Set<Entry<String, String>> entrySet = headers.entrySet();
			for (Entry<String, String> entry : entrySet) {
				httpget.addHeader(entry.getKey(), entry.getValue());
			}
		}
		LOG.debug("get方法创建！");
		StringBuffer resMes = new StringBuffer();
		try {
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(600000)
					.setConnectTimeout(15000).build();
			httpget.setConfig(requestConfig);
			LOG.debug("请求URL:" + httpget.getURI());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				LOG.info("StatusLine ==>" + response.getStatusLine());
				HttpEntity entity = response.getEntity();
				BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
				String line;
				while ((line = in.readLine()) != null) {
					resMes.append(line);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			LOG.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage(), e);
		} catch (SocketTimeoutException e) {
			// 捕获服务器响应超时
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				LOG.error("Close HttpClient Error==> ", e);
			}
		}
		return resMes.toString();
	}

	private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Entry<String, Object> param : params.entrySet()) {
			pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}

		return pairs;
	}


	/**
	 * 发送get请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String sendGet(String url, Map<String, String> params) {
		String result = "";
		BufferedReader in = null;
		try {
			List<String> keyList = new ArrayList<>();
			keyList.addAll(params.keySet());
			Collections.sort(keyList);
			StringBuilder paramsSort = new StringBuilder();
			paramsSort.append(keyList.get(0));
			paramsSort.append("=");
			paramsSort.append(params.get(keyList.get(0)));
			for	(int i = 1;	i < keyList.size();	i++)	{
				paramsSort.append("&");
				paramsSort.append(keyList.get(i));
				paramsSort.append("=");
				paramsSort.append(params.get(keyList.get(i)));
			}
			String urlNameString = url + "?" + paramsSort.toString();
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			LOG.error("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				LOG.error("关闭流异常！");
			}
		}
		return result;
	}

	/**
	 * 发送get请求 设置header
	 * @param url
	 * @param headers
	 * @return
	 */
	public static String sendGetWithHeader(String url, Map<String, String> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(60000)
				.setSocketTimeout(60000)
				.setConnectionRequestTimeout(60000)
				.build();

		HttpGet httpget = new HttpGet(url);

		if (MapUtils.isNotEmpty(headers)) {
			Set<Entry<String, String>> entrySet = headers.entrySet();
			for (Entry<String, String> entry : entrySet) {
				httpget.addHeader(entry.getKey(), entry.getValue());
			}
		}
		httpget.setConfig(config);
		String result = null;
		try {
			CloseableHttpResponse response = httpClient.execute(httpget);
			try {
				HttpEntity responseEntity = response.getEntity();
				result = EntityUtils.toString(responseEntity);
				EntityUtils.consume(responseEntity);
			} finally {
				response.close();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				LOG.error(e.getMessage(),e);
			}
		}

		return result;
	}
}
