package util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页PageInfo相关工具类
 *
 * @author sunzhilin
 * @date 2020/8/11  11:26
 */
public class PageInfoUtil {

    /**
     * 替换PageInfo中的list
     *
     * @param pageInfo 原PageInfo
     * @param list     list
     * @param <T>      <T>
     * @param <R>      <R>
     * @return 新PageInfo
     */

    public static <T, R> PageInfo<R> changeList(PageInfo<T> pageInfo, List<R> list) {
        PageInfo<R> rPageInfo = new PageInfo<>(list);
        rPageInfo.setStartRow(pageInfo.getStartRow());
        rPageInfo.setEndRow(pageInfo.getEndRow());
        rPageInfo.setPageNum(pageInfo.getPageNum());
        rPageInfo.setPageSize(pageInfo.getPageSize());
        rPageInfo.setPages(pageInfo.getPages());
        rPageInfo.setTotal(pageInfo.getTotal());
        rPageInfo.setNextPage(pageInfo.getNextPage());
        rPageInfo.setPrePage(pageInfo.getPrePage());
        rPageInfo.setHasNextPage(pageInfo.isHasNextPage());
        rPageInfo.setHasPreviousPage(pageInfo.isHasPreviousPage());
        rPageInfo.setIsFirstPage(pageInfo.isIsFirstPage());
        rPageInfo.setIsLastPage(pageInfo.isIsLastPage());
        return rPageInfo;
    }
}
