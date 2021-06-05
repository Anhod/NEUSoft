package com.neu.controller;

import com.neu.po.Dept;
import com.neu.service.DeptService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("deptrest")
public class RestDeptController {
    @Resource
    private DeptService deptService;

    @GetMapping("getById/{deptno}")
    public Dept getById(@PathVariable("deptno") int deptno){
        Dept dept = deptService.getById(deptno);

        return dept;
    }

    @GetMapping
    public List<Dept> getAll(){
        return deptService.getAll();
    }

    @GetMapping("{dname}/{loc}")
    public void getByDnameLoc(@PathVariable("dname") String dname,@PathVariable("loc") String loc){
        System.out.println(dname+"   "+loc);
    }

    // @RequestBody 传入JSON对象
    @PostMapping
    public int insert(@RequestBody Dept dept){
        return deptService.insert(dept);
    }

    @PutMapping
    public int update(@RequestBody Dept dept){
        return deptService.update(dept);
    }

    @DeleteMapping
    public int delete(int deptno){
        return deptService.delete(deptno);
    }
}
