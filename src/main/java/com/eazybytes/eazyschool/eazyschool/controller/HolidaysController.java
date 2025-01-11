package com.eazybytes.eazyschool.eazyschool.controller;

import com.eazybytes.eazyschool.eazyschool.model.Holiday;
import com.eazybytes.eazyschool.eazyschool.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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

    @Autowired
    private HolidaysRepository holidaysRepository;

    @GetMapping("/holidays/{display}")
    public String showHolidays(@PathVariable String display, Model model) {

        if (null != display && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if (null != display && display.equals("federal")) {
            model.addAttribute("federal", true);
        } else if (null != display && display.equals("festival")) {
            model.addAttribute("festival", true);
        }

        List<Holiday> holidays = holidaysRepository.findAll();
        Holiday.Type[] holidayTypes = Holiday.Type.values();
        Map<Holiday.Type, List<Holiday>> holidayTypeList = holidays.stream().collect(Collectors.groupingBy(Holiday::getType));
        Set<Map.Entry<Holiday.Type, List<Holiday>>> entries = holidayTypeList.entrySet();
        for (Map.Entry<Holiday.Type, List<Holiday>> item : entries) {
            model.addAttribute(item.getKey().toString(), item.getValue());
        }
        return "holidays.html";
    }
}
