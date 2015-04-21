/**
 * Dianping.com Inc.
 * Copyright (c) 2003-2013 All Rights Reserved.
 */
package com.dianping.pigeon.demo.typical;

import java.util.Date;

import com.dianping.pigeon.container.SpringContainer;
import com.dianping.pigeon.demo.EchoService;
import com.dianping.pigeon.demo.UserService;
import com.dianping.pigeon.demo.UserService.User;
import com.dianping.pigeon.util.ContextUtils;

public class Client {

	private static SpringContainer CLIENT_CONTAINER = new SpringContainer(
			"classpath*:META-INF/spring/typical/invoker.xml");

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CLIENT_CONTAINER.start();

		EchoService echoService = (EchoService) CLIENT_CONTAINER.getBean("echoService");
		EchoService echoServiceWithCallback = (EchoService) CLIENT_CONTAINER.getBean("echoServiceWithCallback");
		EchoService echoServiceWithFuture = (EchoService) CLIENT_CONTAINER.getBean("echoServiceWithFuture");

		UserService userService = (UserService) CLIENT_CONTAINER.getBean("userService");

		User user = new User();
		user.setUsername("jason");
		User[] users = new User[] { user };
		int i = 0;
		while (true) {
			try {
//				 PhoenixContext.getInstance().setRequestId("1");
//				 ExecutionContextHolder.setTrackerContext(new
//				 TrackerContext());
				
				 ContextUtils.putContextValue("key1", "1");
				 System.out.println(echoService.echo("" + i++));
				 System.out.println(echoService.echo(new Date()));
//				 ContextUtils.putContextValue("key1", user);
//				 System.out.println(echoService.echo("hi, 2"));
//				
//				 ArrayList<String> l = new ArrayList<String>();
//				 l.add("key1 list");
//				 ContextUtils.putContextValue("key1", l);
//				 System.out.println(echoService.echo("hi, 3"));
//				
//				 ArrayList<User> l2 = new ArrayList<User>();
//				 l2.add(user);
//				 ContextUtils.putContextValue("key1", l2);
//				 System.out.println(echoService.echo("hi, 4"));
				// System.out.println(userService.getUserDetail(users, false));
				// System.out.println(echoService.echo("hi"));
				// echoServiceWithFuture.echo("future");
				// ServiceFuture f = ServiceFutureFactory.getFuture();
				// System.out.println(f._get());
			} catch (Exception e) {
				System.out.println("");
			}
		}
	}

}
