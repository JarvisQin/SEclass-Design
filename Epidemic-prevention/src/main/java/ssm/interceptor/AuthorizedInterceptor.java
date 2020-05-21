package ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizedInterceptor implements HandlerInterceptor
{

  //  @Autowired
  //  private TestDao testDao;


    private static final String[] IGNORE_URI= {".css","index",".gif","image",".js","ico","login"};
    /**
     * 该方法需要preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {

    }

    /**
     * 这个方法在preHandle方法返回值为true的时候才会执行。
     * 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView mv) throws Exception {

    }
    /**
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
     * 当preHandle的返回值为false的时候整个请求就结束了。
     * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
                             Object handler) throws Exception
    {

        //默认用户没有登录
        boolean flag=false;
        //获得请求的ServletPath
        String servletPath=request.getServletPath();

        //System.out.println("进入拦截器");
        // System.out.println(servletPath);
        for(String s:IGNORE_URI)
        {
            if(servletPath.contains(s)) //包含字符串 并不是以s结尾
            {
                flag=true;
                break;
            }
        }
        //拦截请求
        if(!flag)
        {
            Admin admin=(Admin) request.getSession().getAttribute("user");
            if(admin==null)
            {

                // 如果是 ajax 请求，则设置 session 状态 、CONTEXTPATH 的路径值
                // 如果是ajax请求响应头会有，x-requested-with

                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))
                {
                    // System.out.println("来自于ajax请求");
                    response.setHeader("SESSIONSTATUS", "TIMEOUT");
                    response.setHeader("CONTEXTPATH", "/index.jsp");
                    // FORBIDDEN，forbidden。也就是禁止、403
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }else{
                    // 如果不是 ajax 请求，则直接跳转即可
                    // System.out.println("来自于普通请求");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }



                System.out.println("我是拦截器 拦截成功");
                System.out.println(servletPath);
                return flag;
            }
            else
            {
                flag=true;
            }

        }

        return flag;

    }



}

