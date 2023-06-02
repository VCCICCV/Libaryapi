package com.example.libary.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Borrow;
import com.example.libary.mapper.BorrowMapper;
import com.example.libary.mapper.po.BorrowReturCountP0;
import com.example.libary.service.IBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/5/6 20:10
 */
@Service
@Slf4j
public class BorrowService implements IBorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Override
    public List<Borrow> list() {
        return borrowMapper.list();
    }

    @Override
    public PageInfo<Borrow> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Borrow> borrows = borrowMapper.listByCondition(baseRequest);
        return new PageInfo<>(borrows);
    }

    @Override
    public void save(Borrow obj) {
        borrowMapper.save(obj);
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowMapper.getById(id);
    }

    @Override
    public void update(Borrow obj) {
        // 更新时间
        obj.setUpdatetime(LocalDate.now());
        borrowMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        borrowMapper.deleteById(id);
    }

    @Override
    public Map<String,Object> getCountByTimeRange(String timeRange) {
        Map<String,Object> map = new HashMap<>();
        Date today = new Date();
        List<DateTime> dateRange;
        switch(timeRange){
            // offsetDay计算时间
            case "week":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today,-6),today, DateField.DAY_OF_WEEK);
                break;
            case "month":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today,-29),today, DateField.DAY_OF_MONTH);
                break;
            case "month2":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today,-59),today, DateField.DAY_OF_MONTH);
                break;
            case "month3":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today,-89),today, DateField.DAY_OF_MONTH);
                break;
            default:
                dateRange = new ArrayList<>();
        }
        List<String> dateStrRange = datetimeToDateStr(dateRange);
        map.put("date",dateStrRange);//x轴
        List<BorrowReturCountP0> borrowCount = borrowMapper.getCountByTimeRange(timeRange,1);
        List<BorrowReturCountP0> returnCount = borrowMapper.getCountByTimeRange(timeRange,2);
        map.put("borrow",countList(borrowCount,dateStrRange));
        map.put("retur",countList(returnCount,dateStrRange));
        return map;
    }
    // DateTime的list转String的list
    private List<String> datetimeToDateStr(List<DateTime> dateTimeList){
        List<String> list = CollUtil.newArrayList();
        if (CollUtil.isEmpty(dateTimeList)){
            return list;
        }
        for (DateTime dateTime :dateTimeList){
            String date = DateUtil.formatDate(dateTime);
            list.add(date);
        }
        return list;
    }
    //  对数据库不存在的处理
    private List<Integer> countList(List<BorrowReturCountP0> countP0List,List<String> dateRange){
       List<Integer> list = CollUtil.newArrayList();
       if(CollUtil.isEmpty(countP0List)){
           return list;
       }
       for(String date : dateRange){
           Integer count = countP0List.stream().filter(countP0 -> date.equals(countP0.getDate())).map(BorrowReturCountP0::getCount).findFirst().orElse(0);
           list.add(count);
       }
       return list;
    }
}
