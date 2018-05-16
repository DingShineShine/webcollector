package com.ding.webcollector_boot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ding
 * @create 2018/5/15
 * @description :html文本处理工具类
 */
public class HtmlUtils {
    /**
     * 定义script的正则表达式
     */
    private static final String REGEX_SCRIPT = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    /**
     * 定义style的正则表达式
     */
    private static final String REGEX_STYLE = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    /**
     * 定义HTML标签的正则表达式
     */
    private static final String REGEX_HTML = "<[^>]+>";
    /**
     * 定义空格回车换行符
     */
    private static final String REGEX_SPACE = "\\s*|\t|\r|\n";
    /**
     * 定义所有w标签
     */
    private static final String REGEX_W = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";

    /**
     * @param htmlStr
     * @return 删除Html标签
     * @author LongJin
     */
    public static String delHTMLTag(String htmlStr) {
        if (htmlStr != null) {
            // 过滤script标签
            Pattern w = Pattern.compile(REGEX_W, Pattern.CASE_INSENSITIVE);
            Matcher mw = w.matcher(htmlStr);
            htmlStr = mw.replaceAll("");

            // 过滤script标签
            Pattern script = Pattern.compile(REGEX_SCRIPT, Pattern.CASE_INSENSITIVE);
            Matcher mScript = script.matcher(htmlStr);
            htmlStr = mScript.replaceAll("");

            // 过滤style标签
            Pattern style = Pattern.compile(REGEX_STYLE, Pattern.CASE_INSENSITIVE);
            Matcher mStyle = style.matcher(htmlStr);
            htmlStr = mStyle.replaceAll("");

            // 过滤html标签
            Pattern html = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
            Matcher mHtml = html.matcher(htmlStr);
            htmlStr = mHtml.replaceAll("-");

            // 过滤空格回车标签
            Pattern space = Pattern.compile(REGEX_SPACE, Pattern.CASE_INSENSITIVE);
            Matcher mSpace = space.matcher(htmlStr);
            htmlStr = mSpace.replaceAll("");
            return htmlStr.trim();
        } else {
            return "";
        }
    }

}


