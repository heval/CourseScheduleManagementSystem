package org.managementsystem.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "update")
@ViewScoped
public class Updatable {
	public static boolean updatable;

	public boolean getUpdatable() {
		return updatable;
	}

	public static void setUpdatable(boolean bool) {
		updatable = bool;
	}

	public void activeToUpdatable() {
		setUpdatable(true);
	}
}
