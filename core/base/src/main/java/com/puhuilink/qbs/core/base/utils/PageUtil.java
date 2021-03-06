package com.puhuilink.qbs.core.base.utils;

import com.puhuilink.qbs.core.base.vo.PageVO;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    /**
     * Mybatis-Plus分页封装
     * @param page
     * @return
     */
//    public static Page initPage(PageVO page){
//
//        Page p = null;
//        int pageNumber = page.getPageNumber();
//        int pageSize = page.getPageSize();
//        String sort = page.getSort();
//        String order = page.getOrder();
//
//        if(pageNumber<1){
//            pageNumber = 1;
//        }
//        if(pageSize<1){
//            pageSize = 10;
//        }
//        if(pageSize>100){
//            pageSize = 100;
//        }
//        if(StrUtil.isNotBlank(sort)) {
//            Boolean isAsc = false;
//            if(StrUtil.isBlank(order)) {
//                isAsc = false;
//            } else {
//                if("desc".equals(order.toLowerCase())){
//                    isAsc = false;
//                } else if("asc".equals(order.toLowerCase())){
//                    isAsc = true;
//                }
//            }
//            p = new Page(pageNumber, pageSize);
//            if(isAsc){
//                p.addOrder(OrderItem.asc(sort));
//            } else {
//                p.addOrder(OrderItem.desc(sort));
//            }
//
//        } else {
//            p = new Page(pageNumber, pageSize);
//        }
//        return p;
//    }

    /**
     * List 手动分页
     *
     * @param page
     * @param list
     * @return
     */
    public static List listToPage(PageVO page, List list) {

        int pageNumber = page.getPageNumber() - 1;
        int pageSize = page.getPageSize();

        if (pageNumber < 0) {
            pageNumber = 0;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        if (pageSize > 100) {
            pageSize = 100;
        }

        int fromIndex = pageNumber * pageSize;
        int toIndex = pageNumber * pageSize + pageSize;

        if (fromIndex > list.size()) {
            return new ArrayList();
        } else if (toIndex >= list.size()) {
            return list.subList(fromIndex, list.size());
        } else {
            return list.subList(fromIndex, toIndex);
        }
    }
}
