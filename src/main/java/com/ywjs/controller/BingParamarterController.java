package com.ywjs.controller;

import com.ywjs.common.vo.Page;
import com.ywjs.model.entity.BingParamarter;
import com.ywjs.model.query.QueryBingParamarter;
import com.ywjs.service.impl.BingParamarterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bing")
public class BingParamarterController {

    @Autowired
    private BingParamarterService bingParamarterService;

    /**BaseDao
     * 查询所有记录
     * @return
     */
    @RequestMapping("/loadAll")
    public List<BingParamarter> getList(){
        return bingParamarterService.loadAll();
    }

    /**
     * 添加记录
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save() throws Exception {
        BingParamarter bp = new BingParamarter();
        bp.setName("测试-2019-6-6");
        bp.setFilename("测试");
        bp.setType(6);
        bp.setIssum(6);
        boolean isSuccess = bingParamarterService.save(bp);
        if(isSuccess){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    /**
     * 批量添加对象
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveBatch")
    public int saveBatch() throws Exception {
        int success = 0;
        for(int i=0;i<15;i++){
            BingParamarter bp = new BingParamarter();
            bp.setName("测试"+(i+15));
            bp.setFilename("测试");
            bp.setType(i);
            bp.setIssum(i);
            boolean isSuccess = bingParamarterService.save(bp);
            if(isSuccess){
                success+=1;
            }
        }
        return success;
    }

    /**
     * 根据字符串类型的属性获取对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getByStrPro",method = RequestMethod.GET)
    public BingParamarter getByStrPro(ServletRequest request) {
        String pro = request.getParameter("name");
        System.out.println(pro);
        return bingParamarterService.getByStrPro(pro);
    }

    /**
     * 修改记录
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String update() throws Exception {
        BingParamarter bp = bingParamarterService.getByStrPro("小明");
        bp.setName("小明");
        bp.setFilename("测试2");
        bp.setType(16);
        bp.setIssum(16);
        boolean isSuccess = bingParamarterService.update(bp);
        if(isSuccess){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @RequestMapping("/findByPage")
    public Page findByPage(){
        QueryBingParamarter bp = new QueryBingParamarter();
        bp.setFilename("测试");
        bp.setSort("issum");
        bp.setOrder("desc");
        bp.setOffset(0);
        bp.setLimit(5);
        bp.setPage(1);
        return bingParamarterService.findByPage(bp);
    }

}
