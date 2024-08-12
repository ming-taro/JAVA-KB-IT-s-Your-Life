package com.boxoffice.run;

import com.boxoffice.controller.BoxofficeController;

public class InitializeBoxofficeDB {
	public static void main(String[] args) {
		BoxofficeController controller = new BoxofficeController();
		controller.initBoxOffice();
	}
}
