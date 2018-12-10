package cn.wilmar.demo.service.impl;

import cn.wilmar.demo.mapper.RoleMapper;
import cn.wilmar.demo.model.Role;
import cn.wilmar.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAll() {
        return roleMapper.selectAll();
    }
}
