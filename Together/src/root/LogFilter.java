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
		// 获取客户端的IP地址
		String ipAddress = request.getRemoteAddr();
		
		// 记录IP地址和当前的时间戳
		System.out.println("IP "+ipAddress+", Time"+new Date().toString());
		
		// 把请求传回给过滤链
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// test----测试从配置文件中得到初始化的数据
		String testParam = config.getInitParameter("test-param");
		
		// 输出参数
		System.out.println("Test Param: " + testParam);
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
