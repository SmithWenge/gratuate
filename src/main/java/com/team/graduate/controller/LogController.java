package com.team.graduate.controller;

import com.team.graduate.common.constant.ExcelConstant;
import com.team.graduate.common.excel.output.Excel;
import com.team.graduate.common.excel.output.ExcelFactory;
import com.team.graduate.common.excel.output.mapper.LogMessageExcelMapper;
import com.team.graduate.model.LogMessage;
import com.team.graduate.service.LogService;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/12.
 * Module : log
 * Comments : log controller
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllLog(HttpSession session) {
        if (null == session.getAttribute(AdminController.ADMIN_LOGIN_TAG))
            return new ModelAndView(AdminController.REDIRECT_ROUTER_ADMIN_ACTION);

        List<LogMessage> messages = service.listAll();
        int count = service.selectCount();

        ModelAndView mav = new ModelAndView("admin/log/list", "messages", messages);
        mav.addObject("count", count);

        return mav;
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView exportLogs(HttpSession session, HttpServletResponse response) {
        if (null == session.getAttribute(AdminController.ADMIN_LOGIN_TAG))
            return new ModelAndView(AdminController.REDIRECT_ROUTER_ADMIN_ACTION);

        List<LogMessage> messages = service.listAllData();
        ExcelFactory<LogMessage> factory = new ExcelFactory<LogMessage>();
        String targetPath = session.getServletContext().getRealPath("/WEB-INF/data/log/");
        File file = new File(targetPath + "/" + "logs.xls");

        WritableWorkbook workbook = null;
        try {
            workbook = factory.createExcel(new FileOutputStream(file),
                    new Excel("日志", 0), Arrays.asList(ExcelConstant.EXCEL_LOG_MESSAGE_IP,
                            ExcelConstant.EXCEL_LOG_MESSAGE_STUDENT_NAME, ExcelConstant.EXCEL_LOG_MESSAGE_STUDENT_ID,
                            ExcelConstant.EXCEL_LOG_MESSAGE_STUDENT_DEGREE, ExcelConstant.EXCEL_LOG_MESSAGE_STUDENT_DATE,
                            ExcelConstant.EXCEL_LOG_MESSAGE_OK_OR_NOT, ExcelConstant.EXCEL_LOG_MESSAGE_TIME,
                            ExcelConstant.EXCEL_LOG_MESSAGE_TAG), messages, new LogMessageExcelMapper());

            workbook.write();
            workbook.close();

            response.setContentType("application/x-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            int length = 0;
            byte[] buffer = new byte[1024];
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            while (-1 != (length = fis.read(buffer, 0, buffer.length))) {
                os.write(buffer, 0, length);
            }

            fis.close();
            os.flush();
            os.close();
        } catch (WriteException e) {
            e.printStackTrace();
            return new ModelAndView("admin/log/list", "messages", messages);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ModelAndView("admin/log/list", "messages", messages);
        } catch (IOException e) {
            e.printStackTrace();
            return new ModelAndView("admin/log/list", "messages", messages);
        } finally {
            file.delete();
        }


        return null;
    }
}
