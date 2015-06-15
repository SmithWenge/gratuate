package com.team.graduate.controller;

import com.google.code.kaptcha.Constants;
import com.team.graduate.common.constant.WebConstant;
import com.team.graduate.common.util.MD5Util;
import com.team.graduate.model.Admin;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.AdminService;
import com.team.graduate.service.LoginTimeService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/1.
 * Module : admin
 * Comments : administrator
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    public static final String ADMIN_LOGIN_TAG = "adminLogin";
    public static final String UPLOAD_EXCEL_FILE_NAME ="targetFile";
    public static final String IMPORT_DATA_ERROR_DATA_RESULT = "errorImportData";
    public static final String IMPORT_DATA_RIGHT_DATA_RESULT = "rightImportData";
    public static final String IMPORT_DATA_REPEAT_DATA_RESULT = "repeatImportData";

    private static final String IMPORT_IMAGE_FORMAT = ".jpg";
    public static final String REDIRECT_ROUTER_ADMIN_ACTION = "redirect:/router/admin.action";

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService service;

    @Autowired
    private LoginTimeService loginTimeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLogin(Admin admin, HttpSession session, @RequestParam("authCode") String authCode) {
        Object sessionCode = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (sessionCode == null ) {
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);
        }

        if (!authCode.equals(sessionCode.toString()))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        admin.setPassword(MD5Util.getMD5String(admin.getPassword()));
        Admin result = service.login(admin);

        if (null == result) return new ModelAndView("redirect:/router/admin.action");

        session.setAttribute(ADMIN_LOGIN_TAG, result);

        ModelAndView mav = new ModelAndView("admin/result/importIndex");
        Timestamp recent = loginTimeService.queryRecent();
        if (recent == null) {
            mav.addObject("recent", "你是第一次登陆");
        } else {
            mav.addObject("recent", recent);
        }

        mav.addObject("total", service.queryAllCount());

        loginTimeService.update(new Timestamp(new DateTime().toDate().getTime()));

        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String adminLoginGet(Admin admin, HttpSession session) {
        return REDIRECT_ROUTER_ADMIN_ACTION;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String adminLogout(HttpSession session) {
        session.removeAttribute(ADMIN_LOGIN_TAG);

        return REDIRECT_ROUTER_ADMIN_ACTION;
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public ModelAndView processDataImport(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (null == request.getSession().getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        File importFile = save(file, request);

        if (null == importFile) return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        Map<String, List<StuGraduateInfo>> result = service.importData(importFile);

        List<StuGraduateInfo> errorData = result.get(IMPORT_DATA_ERROR_DATA_RESULT);
        List<StuGraduateInfo> repeatData = result.get(IMPORT_DATA_REPEAT_DATA_RESULT);
        List<StuGraduateInfo> rightData =  result.get(IMPORT_DATA_RIGHT_DATA_RESULT);

        if ( errorData.size() > 0 || repeatData.size() > 0) {
            ModelAndView mav = new ModelAndView("admin/error/importError");
            mav.addObject("errorData", errorData);
            mav.addObject("repeatData", repeatData);
            mav.addObject("rightData", rightData.size());

            return mav;
        } else {
            return new ModelAndView("admin/result/success", "data", rightData.size());
        }
    }

    private File save(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String targetPath = request.getSession().getServletContext().getRealPath("/WEB-INF/data/real/");
        String sourceFileName = file.getOriginalFilename();

        String dateString = new DateTime().toString("MM-dd-yyyy-HH-mm-ss-SSS");
        String prefixName = sourceFileName.substring(0, sourceFileName.indexOf("."));
        String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));
        String newName = prefixName + "-" + dateString + subName;

        File targetFile = new File(targetPath, newName);
        request.getSession().setAttribute(UPLOAD_EXCEL_FILE_NAME, targetFile.getName());

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);

            return targetFile;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String processDataImport() {
        return REDIRECT_ROUTER_ADMIN_ACTION;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String downloadTemplate(HttpServletResponse response, HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG)) return REDIRECT_ROUTER_ADMIN_ACTION;

        String templatePath = session.getServletContext().getRealPath("/") + "WEB-INF/data/template/Template.xls";
        try {
            File file = new File(templatePath);

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

            os.flush();
            os.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @RequestMapping(value = "/image/import", method = RequestMethod.POST)
    public ModelAndView processImageImport(@RequestParam("image") MultipartFile[] files, HttpServletRequest request) {
        if (null == request.getSession().getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        String targetPath = request.getSession().getServletContext().getRealPath("/WEB-INF/images/");

        ArrayList<String> rightImages = new ArrayList<String>();
        ArrayList<String> repeatImages = new ArrayList<String>();
        ArrayList<String> errorImages = new ArrayList<String>();

        for (MultipartFile file : files) {
            String sourceFileName = file.getOriginalFilename();
            String idNum = sourceFileName.substring(0, sourceFileName.indexOf("."));
            String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

            if (service.isRightImage(idNum) && subName.equals(IMPORT_IMAGE_FORMAT)) {
                String prefixName = MD5Util.getMD5String(idNum);
                String newName = prefixName + subName;
                File targetFile = new File(targetPath, newName);

                if (targetFile.exists()) {
                    repeatImages.add(sourceFileName);
                    continue;
                }

                try {
                    file.transferTo(targetFile);

                    rightImages.add(sourceFileName);
                } catch (IOException e) {
                    errorImages.add(sourceFileName);
                }
            } else {
                errorImages.add(sourceFileName);
            }
        }

        if (errorImages.size() > 0 || repeatImages.size() > 0) {
            ModelAndView mav = new ModelAndView("admin/image/error/importError");
            mav.addObject("rightImages", rightImages.size());
            mav.addObject("errorImages", errorImages);
            mav.addObject("repeatImages", repeatImages);

            return mav;
        } else {
            return new ModelAndView("admin/image/success", "rightImages", rightImages.size());
        }
    }

    @RequestMapping(value = "/image/import", method = RequestMethod.GET)
    public String processImageImportGet() {
        return "redirect:/router/image.action";
    }

    @RequestMapping(value = "/single/add", method = RequestMethod.POST)
    public ModelAndView singleAdd(StuGraduateInfo info, @RequestParam("file") MultipartFile file, 
                                  HttpSession session, @RequestParam("authCode") String authCode) {
        if (!authCode.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString()))
            return new ModelAndView("redirect:/router/single/add.action");

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (!info.isLegalImportData() || file == null)
            return new ModelAndView("redirect:/router/single/add.action");

        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        String realFileName = saveSingleImage(info, file, session);
        if (null == realFileName) {
            return new ModelAndView("redirect:/router/single/add.action");
        }

        info.setId(UUID.randomUUID().toString());

        service.addNewStudent(info);

        ModelAndView mav = new ModelAndView("admin/single/information");
        mav.addObject("stu", info);
        mav.addObject("realFileName", realFileName);

        return mav;
    }

    private String saveSingleImage(StuGraduateInfo info, @RequestParam("file") MultipartFile file,
                                   HttpSession session) {
        String targetPath = session.getServletContext().getRealPath("/WEB-INF/images/");
        String sourceFileName = file.getOriginalFilename();
        String idNum = sourceFileName.substring(0, sourceFileName.indexOf("."));
        String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

        if (idNum.equals(info.getStuIdentificationNum()) && subName.equals(IMPORT_IMAGE_FORMAT)) {
            String prefixName = MD5Util.getMD5String(idNum);
            String newName = prefixName + subName;
            File targetFile = new File(targetPath, newName);

            if (targetFile.exists()) {
                targetFile.delete();
            }

            try {
                file.transferTo(targetFile);
                return prefixName;
            } catch (IOException e) {
                return null;
            }
        }

        return null;
    }

    @RequestMapping(value = "/single/add", method = RequestMethod.GET)
    public String singleAddGet() {
        return "redirect:/router/single/add.action";
    }

    @RequestMapping(value = "/single/query", method = RequestMethod.POST)
    public ModelAndView queryByStuNumber(@RequestParam("stuNumber") String stuNumber, HttpSession session,
                                         @RequestParam("authCode") String authCode) {
        if (!authCode.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString()))
            return new ModelAndView("redirect:/router/single.action");

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        StuGraduateInfo info = service.queryKV(WebConstant.STU_NUMBER, stuNumber);

        if (info == null) {
            return new ModelAndView("redirect:/router/single.action", "warning", "没有所查学号的学生");
        }

        String realFileName = MD5Util.getMD5String(info.getStuIdentificationNum());

        ModelAndView mav = new ModelAndView("admin/single/detail");
        mav.addObject("stu", info);
        mav.addObject("realFileName", realFileName);

        return mav;
    }

    @RequestMapping(value = "/single/query", method = RequestMethod.GET)
    public String queryByStuNumber(HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return REDIRECT_ROUTER_ADMIN_ACTION;

        return "redirect:/router/single.action";
    }

    @RequestMapping("/single/queryById/{id}")
    public ModelAndView queryForUpdate(@PathVariable("id") String stuId, HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        StuGraduateInfo info = service.query4Update(stuId);

        String realFileName = MD5Util.getMD5String(info.getStuIdentificationNum());

        ModelAndView mav = new ModelAndView("admin/single/modify");
        mav.addObject("stu", info);
        mav.addObject("realFileName", realFileName);

        return mav;
    }

    @RequestMapping(value = "/single/update", method = RequestMethod.POST)
    public ModelAndView updateInformation(StuGraduateInfo info, HttpSession session,
                                          @RequestParam("file") MultipartFile file,
                                          @RequestParam("authCode") String authCode) {
        if (!authCode.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString()))
            return new ModelAndView("redirect:/router/single/add.action");

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (!info.isLegalImportData() || file == null)
            return new ModelAndView("redirect:/router/single/add.action");

        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        String realFileName = saveSingleImage(info, file, session);

        if (null == realFileName) {
            return new ModelAndView("redirect:/router/single/add.action");
        }

        StuGraduateInfo newInfo = service.updateGraduate(info);

        ModelAndView mav = new ModelAndView("admin/single/information");
        mav.addObject("stu", newInfo);
        mav.addObject("realFileName", realFileName);

        return mav;
    }

    @RequestMapping(value = "/single/update", method = RequestMethod.GET)
    public String updateInformation(HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return REDIRECT_ROUTER_ADMIN_ACTION;

        return "admin/single/index";
    }

    @RequestMapping(value = "/log/query", method = RequestMethod.POST)
    public ModelAndView query4Log(@RequestParam("logDate") String date, @RequestParam("authCode") String authCode,
                                  HttpSession session) {
        if (!authCode.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString()))
            return new ModelAndView("redirect:/router/single.action");

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        String logFilePath = session.getServletContext().getRealPath("/WEB-INF/logs/");
        System.out.println(logFilePath);

        File file = new File(logFilePath);
        List<String> list = new ArrayList<String>();

        if (file.exists() && file.isDirectory()) {
            File[] logs = file.listFiles();

            for (File log : logs) {
                DateTime time = new DateTime(log.lastModified());
                if ( date.equals(time.toString("yyyy-MM-dd"))) {
                    list.add(log.getName());
                }
            }
        }

        if (list.size() == 0) list.add("graduate.log");

        return new ModelAndView("admin/log/result", "src/main/logs", list);
    }

    @RequestMapping(value = "/log/query", method = RequestMethod.GET)
    public ModelAndView query4LogGet(HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        return new ModelAndView("redirect:/router/log/index.action");
    }

    @RequestMapping(value = "/log/all", method = RequestMethod.GET)
    public ModelAndView listAll(HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return new ModelAndView(REDIRECT_ROUTER_ADMIN_ACTION);

        String logFilePath = session.getServletContext().getRealPath("/WEB-INF/logs/");
        System.out.println(logFilePath);

        File file = new File(logFilePath);
        List<String> list = new ArrayList<String>();

        if (file.exists() && file.isDirectory()) {
            File[] logs = file.listFiles();

            for (File log : logs) {
                list.add(log.getName());
            }
        }

        return new ModelAndView("admin/log/result", "src/main/logs", list);
    }

    @RequestMapping(value = "/log/delete")
    public String deleteLog(@RequestParam("log") String fileName, HttpSession session) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return REDIRECT_ROUTER_ADMIN_ACTION;

        String logFilePath = session.getServletContext().getRealPath("/WEB-INF/logs/");
        File file = new File(logFilePath);

        if (file.exists() && file.isDirectory()) {
            File[] logs = file.listFiles();

            for (File test : logs) {
                if (test.equals(fileName)) test.delete();
            }
        }

        return "redirect:/router/log/index.action";
    }

    @RequestMapping("/log/download")
    public String downloadLog(@RequestParam("log") String fileName, HttpSession session, HttpServletResponse response) {
        if (null == session.getAttribute(ADMIN_LOGIN_TAG))
            return REDIRECT_ROUTER_ADMIN_ACTION;

        String templatePath = session.getServletContext().getRealPath("/") + "WEB-INF/logs/" + fileName;
        System.out.println(templatePath);

        try {
            File file = new File(templatePath);

            if (!file.exists()) return null;

            response.setContentType("application/x-msdownload");
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

            os.flush();
            os.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
