package com.huyue.common.base;

import com.huyue.common.util.ControllerUtil;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyue01@sinovatech.com 2019/4/7 17:01
 */
public abstract class BaseController {
    private static final String JSON_VIEW = "jsonView";

    protected ModelAndView createJsonView() {
        return new ModelAndView(JSON_VIEW);
    }

    protected ModelAndView createJspView(String name) {
        return new ModelAndView(name);
    }

    protected String getParameter(HttpServletRequest request, String key) {
        if (key == null)
            return "";
        String parameter = request.getParameter(key);
        if (parameter == null)
            return "";
        return ControllerUtil.proccessInjection(parameter);
    }
}
