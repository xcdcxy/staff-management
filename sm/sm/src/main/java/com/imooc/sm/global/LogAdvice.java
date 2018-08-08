package com.imooc.sm.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.sm.entity.Log;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.LogService;

/*
 * ��־��Ϣ������
 */
@Aspect
public class LogAdvice {
	
	@Autowired
	private LogService logService;
	
	/*
	 * ������־
	 */
	@AfterReturning("execution(* com.imooc.sm.controller.*.*(..) && !execution(* com.imooc.sm.controller.*.to*(..) && !execution(* com.imooc.sm.controller.SelfController.*.*(..))")
	public void operationLog(JoinPoint joinPoint) {
		Log log = new Log();
		log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
		log.setOperation(joinPoint.getSignature().getName());
		HttpServletRequest request =  (HttpServletRequest) joinPoint.getArgs()[0];
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("USER");
		log.setOperator(staff.getAccount());
		log.setResult("����");
		logService.addOperationLog(log);
	}
	
	/*
	 * ϵͳ��־
	 */
	@AfterThrowing(throwing="e",pointcut="execution(* com.imooc.sm.controller.*.*(..) && !execution(* com.imooc.sm.controller.SelfController.*(..))")
	public void systemLog(Throwable e, JoinPoint joinPoint) {
		Log log = new Log();
		log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
		log.setOperation(joinPoint.getSignature().getName());
		HttpServletRequest request =  (HttpServletRequest) joinPoint.getArgs()[0];
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("USER");
		log.setOperator(staff.getAccount());
		log.setResult(e.getClass().getSimpleName());
		logService.addSystemLog(log);
	}
	
	
}
