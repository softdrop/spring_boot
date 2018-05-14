package com.wang.project;

import com.wang.project.entity.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(new User() {
			{
				setAccount("wwwww");
			}
		}.toString());
		System.out.println(new User() {
			String ss() {
				return "qqqqq";
			}
		}.ss());
		System.out.println(new User() {
			String ss() {
				return "eeeee";
			}
		}.toString());
		
		new User() {
			 String ss ;
		};

	}
}
