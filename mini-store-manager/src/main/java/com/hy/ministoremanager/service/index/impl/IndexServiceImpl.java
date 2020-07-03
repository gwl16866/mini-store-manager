package com.hy.ministoremanager.service.index.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ministoremanager.bean.*;
import com.hy.ministoremanager.dao.IndexMapper;
import com.hy.ministoremanager.service.index.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Service
public class IndexServiceImpl extends ServiceImpl<IndexMapper, Slideshow> implements IIndexService {

    @Autowired
  private IndexMapper indexMapper;


    @Override
    public List<Slideshow> queryLunbo() {
        return indexMapper.queryLunbo();
    }

    @Override
    public List<Slideshow> queryNavigation() {
        return indexMapper.queryNavigation();
    }

    @Override
    public List<Product> queryProductList(Integer classes) {
        return indexMapper.queryProductList(classes);
    }

    @Override
    public List<String> queryImgByPid(Integer pid) {
        return indexMapper.queryImgByPid(pid);
    }

    @Override
    public List<String> queryProductDetailsImgByPid(Integer pid) {
        return indexMapper.queryProductDetailsImgByPid(pid);
    }

    @Override
    public List<BigClass> queryBigClass() {
        List<BigClass> bList = new ArrayList<>();

        for(int i=1;i<=8;i++){
            BigClass bigClass = indexMapper.queryAllBigClass(i);
            List<BigClassTwo> list = indexMapper.queryBigClass(i);
            BigClass b = new BigClass();
            b.setId(bigClass.getId());
            //b.setUrl(bigClass.getUrl());
            b.setText(bigClass.getText());
            b.setChildren(list);
            bList.add(b);
        }
          return bList;
    }

    @Override
    public Product queryOneProductById(Integer id) {
        return indexMapper.queryOneProductById(id);
    }

    @Override
    public List<Product> querySlideshowProduct(Integer id,String style) {
        return indexMapper.querySlideshowProduct(id,style);
    }

    @Override
    public List<Product> queryNavigaterProduct(Integer id, String style) {
        return indexMapper.queryNavigaterProduct(id,style);
    }

    @Override
    public Slideshow querySlideshowById(Integer id) {
        return indexMapper.querySlideshowById(id);
    }

    @Override
    public Slideshow queryNavigaterById(Integer id) {
        return indexMapper.queryNavigaterById(id);
    }

    @Override
    public List<ModelAndColor> queryModelByPid(Integer pid) {
        return indexMapper.queryModelByPid(pid);
    }

    @Override
    public List<ModelAndColor> queryColorByPid(Integer pid) {
        return indexMapper.queryColorByPid(pid);
    }

    @Override
    public List<ModelAndColor> queryModelByColor(String val,Integer pid) {
        return indexMapper.queryModelByColor(val,pid);
    }

    @Override
    public List<ModelAndColor> queryColorByModel(String val,Integer pid) {
        return indexMapper.queryColorByModel(val,pid);
    }

    @Override
    public List<Product> queryProductByClasses(Integer classes,String style) {
        return indexMapper.queryProductByClasses(classes,style);
    }

    @Override
    public List<GoodsCar> queryGoodsCar(String id) {
        return indexMapper.queryGoodsCar(id);
    }

    @Override
    public Integer queryCounts(String model, String color,Integer pid) {
        return indexMapper.queryCounts(model,color,pid);
    }

    @Override
    public Integer queryPrice(String model, String color, Integer pid) {
        return indexMapper.queryPrice(model,color,pid);
    }

    @Override
    public Integer insertGoodsCar(Integer pid, String model, String color, Integer counts,String price) {
        Integer coun = indexMapper.queryGoodsCarCountsById(pid,model,color);
        Integer up=0;
        Integer insert=0;
        if(coun != null && coun >0){
            up = indexMapper.updateGoodsCarCountsById(pid, model, color, counts);
            return up;
        }else {
            insert = indexMapper.insertGoodsCar(pid, model, color, counts,price);
            return insert;
        }

    }

    @Override
    public Integer deleteGoodsCar(String ids) {
        return indexMapper.deleteGoodsCar(ids);
    }

    @Override
    public BigDecimal SumPrice(String ids) {
        //价格数量
        List<GoodsCar> list =indexMapper.SumPrice(ids);
        BigDecimal res=new BigDecimal(0);
        for (int i = 0; i < list.size(); i++) {
            BigDecimal b = list.get(i).getPrice();
            Integer count =list.get(i).getCounts();
            BigDecimal in = new BigDecimal(count);
            res = res.add(b.multiply(in));
        }
        return res.multiply(new BigDecimal(100));
    }


}
