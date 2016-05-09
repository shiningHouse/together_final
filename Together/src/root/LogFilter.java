package root;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ��ȡ�ͻ��˵�IP��ַ
		String ipAddress = request.getRemoteAddr();
		
		// ��¼IP��ַ�͵�ǰ��ʱ���
		System.out.println("IP "+ipAddress+", Time"+new Date().toString());
		
		// �����󴫻ظ�������
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// test----���Դ������ļ��еõ���ʼ��������
		String testParam = config.getInitParameter("test-param");
		
		// �������
		System.out.println("Test Param: " + testParam);
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
