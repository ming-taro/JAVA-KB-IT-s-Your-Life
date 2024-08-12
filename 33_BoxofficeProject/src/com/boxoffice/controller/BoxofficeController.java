package com.boxoffice.controller;


import java.time.LocalDate;
import java.util.List;

import com.boxoffice.api.OpenApiManagerForXML;
import com.boxoffice.model.service.BoxOfficeService;
import com.boxoffice.model.vo.Boxoffice;


public class BoxofficeController {
	private BoxOfficeService boxOfficeService = new BoxOfficeService();
	
	public void initBoxOffice() {
		LocalDate date = LocalDate.of(2024, 1, 1);
		LocalDate today = LocalDate.now().minusWeeks(1);
		
		while(true) {
			System.out.println(date);
			if(date.isAfter(today)) {
				break;
			}
			List<Boxoffice> list = OpenApiManagerForXML.parse(date);
			date = date.plusWeeks(1);
			if(list == null || list.isEmpty()) {
				continue;
			}
			for(Boxoffice box : list) {
				System.out.println(box);
				boxOfficeService.insert(box);
			}
		}
	}
	
	public List<Boxoffice> getAllMvList(){
		return boxOfficeService.selectAll();
	}
	
	
	public List<Boxoffice> getMvListByYearweekTime(String yearweekTime){
		return boxOfficeService.selectByYearweekTime(yearweekTime);
	}
	
	public Boxoffice searchByBoxofficeNo(int boxofficeNo){
		return boxOfficeService.selectOne(boxofficeNo);
	}
	
	
	public List<Boxoffice> searchMovieName(String movieName){
		return boxOfficeService.selectByMvName(movieName);
	}
	
	
	public static void main(String[] args) {
		BoxofficeController controller = new BoxofficeController();
		controller.initBoxOffice();
	}
}
