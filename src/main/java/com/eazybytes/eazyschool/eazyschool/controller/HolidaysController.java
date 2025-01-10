package com.eazybytes.eazyschool.eazyschool.controller;

import com.eazybytes.eazyschool.eazyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @GetMapping("/holidays/{display}")
    public String showHolidays(@PathVariable String display, Model model) {

        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
        }

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] holidayTypes = Holiday.Type.values();
        Map<Holiday.Type, List<Holiday>> holidayTypeList = holidays.stream().collect(Collectors.groupingBy(Holiday::getType));
        Set<Map.Entry<Holiday.Type, List<Holiday>>> entries = holidayTypeList.entrySet();
        for (Map.Entry<Holiday.Type, List<Holiday>> item : entries) {
            model.addAttribute(item.getKey().toString(), item.getValue());
        }
        return "holidays.html";
    }
}
